/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.webapp.impl;

import com.cinema.webapp.entities.Ticket;
import com.cinema.webapp.repositories.TicketRepository;
import com.cinema.webapp.services.TicketService;
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
    
}
