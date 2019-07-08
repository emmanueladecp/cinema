/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.webapp.services;

import com.cinema.webapp.entities.Customer;
import com.cinema.webapp.entities.Ticket;
import java.util.Optional;

/**
 *
 * @author ADMIN
 */
public interface TicketService {
    Iterable<Ticket> listAllTickets();
    
    public Optional<Ticket> getTicketById(int ticketId);
}
