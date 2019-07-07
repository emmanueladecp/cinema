/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.webapp.controllers;

import com.cinema.webapp.repositories.CustomerRepository;
import com.cinema.webapp.entities.Customer;
import com.cinema.webapp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/customers")

public class CustomerController {
    @Autowired
    CustomerService customerService;
    
    @GetMapping("/")
    public List<Customer> getAll(){
        return customerService.findAll();
    }
            
}
