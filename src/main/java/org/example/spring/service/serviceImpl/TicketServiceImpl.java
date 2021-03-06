package org.example.spring.service.serviceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.spring.dao.exceptionDao.DaoException;
import org.example.spring.dao.daoImpl.EventDaoImpl;
import org.example.spring.dao.daoImpl.TicketDaoImpl;
import org.example.spring.dao.daoImpl.UserDaoImpl;
import org.example.spring.model.Entity.EventEntity;
import org.example.spring.model.Entity.UserEntity;
import org.example.spring.model.Event;
import org.example.spring.model.Ticket;
import org.example.spring.model.User;
import org.example.spring.service.ServiceException.ServiceException;
import org.example.spring.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.apache.logging.log4j.Level.DEBUG;

public class TicketServiceImpl implements TicketService {
    private TicketDaoImpl ticketDaoImpl;
    private UserDaoImpl userDaoImpl;
    private EventDaoImpl eventDaoImpl;
    private final static Logger logger = LogManager.getLogger();

    @Autowired
    public TicketServiceImpl(TicketDaoImpl ticketDaoImpl, UserDaoImpl userDaoImpl, EventDaoImpl eventDaoImpl) {
        this.ticketDaoImpl = ticketDaoImpl;
        this.userDaoImpl = userDaoImpl;
        this.eventDaoImpl = eventDaoImpl;
        logger.log(DEBUG, this.getClass().getSimpleName() + " was created");
    }

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) throws ServiceException {
        logger.log(DEBUG, Thread.currentThread()
                .getStackTrace()[1].getMethodName() + " method start");
        UserEntity userEntity = (UserEntity) userDaoImpl.getUserById(userId);
        EventEntity eventEntity = (EventEntity) eventDaoImpl.getEventById(eventId);
        if (userEntity == null) {
            throw new ServiceException("there are no user with id=" + userId);
        }
        if (eventEntity == null) {
            throw new ServiceException("there are no event with id=" + eventId);
        }
        List<Ticket> bookedTickets = getBookedTickets(eventEntity, Integer.MAX_VALUE, 0);
        for (int i = 0; i < bookedTickets.size(); i++) {
            if (bookedTickets.get(i).getPlace() == place) {
                throw new ServiceException("place ???" + place + " is already booked");
            }
        }
        return ticketDaoImpl.saveBookedTicket(userId, eventId, place, category);
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) throws ServiceException {
        logger.log(DEBUG, Thread.currentThread()
                .getStackTrace()[1].getMethodName() + " method start");
        try {
            return ticketDaoImpl.getBookedTickets(user, pageSize, pageNum);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) throws ServiceException {
        logger.log(DEBUG, Thread.currentThread()
                .getStackTrace()[1].getMethodName() + " method start");
        try {
            return ticketDaoImpl.getBookedTickets(event, pageSize, pageNum);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        logger.log(DEBUG, Thread.currentThread()
                .getStackTrace()[1].getMethodName() + " method start");
        return ticketDaoImpl.cancelTicket(ticketId);
    }

    @Override
    public Ticket getTicketById(long id) {
        logger.log(DEBUG, Thread.currentThread()
                .getStackTrace()[1].getMethodName() + " method start");
        return ticketDaoImpl.getTicketById(id);
    }
}
