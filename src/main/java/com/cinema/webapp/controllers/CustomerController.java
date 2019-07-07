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
import org.springframework.web.bind.annotation.ModelAttribute;


/**
 *
 * @author ADMIN
 */
@RestController

public class CustomerController {
    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/customers")
    public List<Customer> getAll(){
        List<Customer> customers = customerService.findAll();
        
        return customers;
    }
    
    @ModelAttribute("customers")
    public List<Customer> customers() {
        return customerService.findAll();
    }        
}
