/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.webapp.controllers;

import com.cinema.webapp.entities.Ticket;
import com.cinema.webapp.services.TicketService;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Iterable<Ticket> listAllTickets(){
        Iterable<Ticket> tickets = ticketService.listAllTickets();
        return tickets;
    }
    
    @GetMapping(value = "/tickets/{id}")
    public Optional<Ticket> getTicketById(@PathVariable("id") int id) {
    		return ticketService.getTicketById(id);
    }
    
    @GetMapping(value = "/tickets/active")
    public Iterable<Ticket> getTicketActive() {
        return ticketService.fetchActiveTicket();
    }
    
    //@PutMapping("/tickets/{id}/{qty}")
    //public ResponseEntity<Ticket> updateTicketStock(@PathVariable("id") int id, @PathVariable("qty") int qty, @Valid  @RequestBody  Ticket ticketDetail) {
       
    //    Optional<Ticket> optionalTicket = ticketService.getTicketById(id);
    //    Ticket newTicket = optionalTicket.get();
        
    //    newTicket.setId(ticketDetail.getId());
    //    newTicket.setName(ticketDetail.getName());
    //    newTicket.setQty(ticketDetail.getQty() - qty);
    //    newTicket.setDate(ticketDetail.getDate());
    //    newTicket.setStarttime(ticketDetail.getStarttime());
    //    newTicket.setEndtime(ticketDetail.getEndtime());
        
    //    return ResponseEntity.ok (ticketService.save(newTicket));
    //}   

}
