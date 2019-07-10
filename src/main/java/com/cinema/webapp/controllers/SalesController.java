/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.webapp.controllers;

import com.cinema.webapp.entities.Sales;
import com.cinema.webapp.services.InvalidOrderException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cinema.webapp.services.SalesService;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/order")
public class SalesController {
    
    @Autowired
    private SalesService salesService;
    
    @PostMapping("/createOrder")
    public void createOrder(@Valid @RequestBody Sales salesOrder) throws InvalidOrderException{
        salesService.createOrder(salesOrder);
    }
    
}
