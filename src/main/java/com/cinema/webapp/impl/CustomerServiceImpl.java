/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.webapp.impl;

import com.cinema.webapp.entities.Customer;
import com.cinema.webapp.repositories.CustomerRepository;
import com.cinema.webapp.services.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 *
 * @author ADMIN
 */
@Service
public class CustomerServiceImpl implements CustomerService{

    //@Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    public void setProductRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Iterable<Customer> listAllCustomers() {
        return customerRepository.findAll();
    }
    

}
