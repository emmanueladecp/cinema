/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.webapp.services;

import com.cinema.webapp.entities.SalesOrder;

/**
 *
 * @author ADMIN
 */
public interface SalesOrderService {
    
    public SalesOrder createOrder(SalesOrder salesOrder);
}
