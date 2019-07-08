/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.webapp.impl;

import com.cinema.webapp.controllers.TicketController;
import com.cinema.webapp.entities.Ticket;
import com.cinema.webapp.repositories.TicketRepository;
import com.cinema.webapp.services.TicketService;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class TicketServiceImpl implements TicketService {

    //@Autowired
    private TicketRepository ticketRepository;
    
    @Autowired
    public void setTicketRepository(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }
    
    @Override
    public Iterable<Ticket> listAllTickets() {
        return ticketRepository.findAll();
    }
    
    @Override
    public Optional<Ticket> getTicketById(int ticketId) {
        return ticketRepository.findById(ticketId);
    }

    @Override
    public Iterable<Ticket> fetchActiveTicket() {
        //List<Ticket> ticketLists = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        Iterable<Ticket> tickets = ticketRepository.fetchActiveTicket();
        Iterator i = tickets.iterator();
        Ticket t;
        while (i.hasNext()) {
             try {
                 t = (Ticket) i.next();
                 
                 java.util.Date nowTime = sdf.parse(sdf.format(new java.util.Date()));
                 java.util.Date dateTimeMovie = combineDateTime(t.getDate(), t.getStarttime());
                 
                 if (dateTimeMovie.before(nowTime) || t.getQty() <= 0 ) {
                     i.remove();
                 }
                 
                 
             } catch (ParseException ex) {
                 Logger.getLogger(TicketController.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        
        return tickets;
        
        //return ticketRepository.fetchActiveTicket();
    }
    
    private java.util.Date combineDateTime(java.util.Date date, java.util.Date time)
        {
                Calendar calendarA = Calendar.getInstance();
                calendarA.setTime(date);
                Calendar calendarB = Calendar.getInstance();
                calendarB.setTime(time);

                calendarA.set(Calendar.HOUR_OF_DAY, calendarB.get(Calendar.HOUR_OF_DAY));
                calendarA.set(Calendar.MINUTE, calendarB.get(Calendar.MINUTE));
                calendarA.set(Calendar.SECOND, calendarB.get(Calendar.SECOND));
                calendarA.set(Calendar.MILLISECOND, calendarB.get(Calendar.MILLISECOND));

                java.util.Date result = calendarA.getTime();
                return result;
        }
    
}
