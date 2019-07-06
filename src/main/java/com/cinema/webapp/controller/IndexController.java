/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.webapp.controller;

import com.cinema.webapp.repositories.CustomerRepository;
import com.cinema.webapp.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ADMIN
 */
public class IndexController {
    @Autowired CustomerRepository customerRepository;
    @Autowired TicketRepository ticketRepository;
    
    @RequestMapping("/")
    public String home(Model model)
    {
        model.addAttribute("customers", customerRepository.findAll());
        model.addAttribute("tickets", ticketRepository.findAll());
        
        return "index";
    }
    
}
