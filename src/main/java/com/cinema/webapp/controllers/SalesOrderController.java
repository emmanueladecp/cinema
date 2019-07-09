/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.webapp.controllers;

import com.cinema.webapp.entities.SalesOrder;
import com.cinema.webapp.services.SalesOrderService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/order")
public class SalesOrderController {
    
    @Autowired
    private SalesOrderService salesOrderService;
    
    @PostMapping("/")
    public SalesOrder createOrder(@Valid @RequestBody SalesOrder salesOrder){
        return salesOrderService.createOrder(salesOrder);
    }
    
}
