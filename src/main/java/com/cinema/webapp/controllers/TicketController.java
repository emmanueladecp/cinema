/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.webapp.controllers;

import com.cinema.webapp.entities.Customer;
import com.cinema.webapp.entities.Ticket;
import com.cinema.webapp.services.TicketService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;
    
    @GetMapping("/tickets")
    public Iterable<Ticket> listAllCustomers(){
        Iterable<Ticket> tickets = ticketService.listAllTickets();
        
        return tickets;
    }
    
    @GetMapping(value = "/tickets/{id}")
    public Optional<Ticket> getTicketById(@PathVariable("id") int id) {
		return ticketService.getTicketById(id);
    }
    
}
