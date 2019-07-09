/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.webapp.services;

import com.cinema.webapp.entities.SalesOrder;
import com.cinema.webapp.entities.Ticket;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@Transactional
public interface SalesOrderService {
    
    public void createOrder(SalesOrder salesOrder) throws InvalidOrderException;
}
