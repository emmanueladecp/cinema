/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.webapp.impl;

import com.cinema.webapp.entities.SalesOrder;
import com.cinema.webapp.entities.Ticket;
import com.cinema.webapp.repositories.CustomerRepository;
import com.cinema.webapp.repositories.SalesOrderRepository;
import com.cinema.webapp.repositories.TicketRepository;
import com.cinema.webapp.services.InvalidOrderException;
import com.cinema.webapp.services.SalesOrderService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@Service
public class SalesOrderServiceImpl implements SalesOrderService{

    //@Autowired
    private SalesOrderRepository salesOrderRepository;
    private TicketRepository ticketRepository;
    
    @Autowired
    public void setOrderRepository(SalesOrderRepository salesOrderRepository) {
        this.salesOrderRepository = salesOrderRepository;
    }
    
    @Autowired
    public void setTicketRepository(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    @Transactional(rollbackFor = InvalidOrderException.class)
    public void createOrder(SalesOrder salesOrder) throws InvalidOrderException {
        
        if (salesOrder.getQtyBuy() > salesOrder.getTicket().getQty()) {
              throw new InvalidOrderException(
                      "Order quantity cannot be more than ticket stock, found: "
                              + salesOrder.getQtyBuy());
          }
        
        Optional<Ticket> t = ticketRepository.findById(salesOrder.getTicket().getId());
        
        Ticket newTicket = t.get();
        
        newTicket.setQty( salesOrder.getTicket().getQty() - salesOrder.getQtyBuy() );
        
        salesOrderRepository.save(salesOrder);
        ticketRepository.save(newTicket);
    }
    
   
    
}
