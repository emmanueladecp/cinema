/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.webapp.impl;

import com.cinema.webapp.entities.SalesOrder;
import com.cinema.webapp.repositories.CustomerRepository;
import com.cinema.webapp.repositories.SalesOrderRepository;
import com.cinema.webapp.services.SalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class SalesOrderServiceImpl implements SalesOrderService{

    //@Autowired
    private SalesOrderRepository salesOrderRepository;
    
    @Autowired
    public void setOrderRepository(SalesOrderRepository salesOrderRepository) {
        this.salesOrderRepository = salesOrderRepository;
    }

    @Override
    public SalesOrder createOrder(SalesOrder salesOrder) {
        return salesOrderRepository.save(salesOrder);
    }
    
   
    
}
