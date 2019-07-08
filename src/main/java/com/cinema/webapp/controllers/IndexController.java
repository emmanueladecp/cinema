/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.webapp.controllers;

import com.cinema.webapp.services.CustomerService;
import com.cinema.webapp.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ADMIN
 */
@Controller
public class IndexController {
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private TicketService ticketService;
    
    
    @RequestMapping("/")
    public String home(Model model)
    {
        model.addAttribute("customers", customerService.listAllCustomers());
        model.addAttribute("tickets",ticketService.fetchActiveTicket());
        return "index";
    }
    
}
