/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.webapp.controllers;

import com.cinema.webapp.entities.Customer;
import com.cinema.webapp.entities.Sales;
import com.cinema.webapp.entities.Ticket;
import com.cinema.webapp.services.CustomerService;
import com.cinema.webapp.services.InvalidOrderException;
import com.cinema.webapp.services.TicketService;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.cinema.webapp.services.SalesService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author ADMIN
 */
@Controller
public class IndexController {
    private String custName;
    private Integer custId;
    private String custPhone;
    private String custEmail;
    
    private Integer filmId;
    private String filmName;
    private String filmTime;
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private TicketService ticketService;
    
    @Autowired
    private SalesService salesService;
    
    @RequestMapping("/")
    public String home(Model model)
    {
            
        model.addAttribute("customers", customerService.listAllCustomers());
        model.addAttribute("tickets",ticketService.fetchActiveTicket());
        model.addAttribute("sales", new Sales());
        
        model.addAttribute("custName", custName) ;
        model.addAttribute("custId", custId) ;
        model.addAttribute("custPhone", custPhone) ;
        model.addAttribute("custEmail", custEmail) ;
        
        model.addAttribute("filmId", filmId) ;
        model.addAttribute("filmName", filmName) ;
        model.addAttribute("filmTime", filmTime) ;
        
        
        return "index";
    }
    
    @GetMapping(value = "/customers/get/{id}")
    public String getCustomer(@PathVariable(value = "id") int id) {
        Optional<Customer> custOptional = customerService.getCustomerById(id);
        Customer c = custOptional.get();
        custName = c.getName();
        custId = c.getId();
        custPhone = c.getPhone();
        custEmail = c.getEmail();
        //System.out.println("Nama : " + custName);
        
        return "redirect:/";
    }
    
    @GetMapping(value = "/tickets/get/{id}")
    public String getFilm(@PathVariable(value = "id") int id) {
        Optional<Ticket> ticketOptional = ticketService.getTicketById(id);
        Ticket t = ticketOptional.get();
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        
        
        
        filmId = t.getId();
        filmName = t.getName();
        filmTime = sdf.format(t.getStarttime());
        
        return "redirect:/";
    }
    
    @PostMapping("/submitOrder")
    public void createOrder(@Valid @RequestBody Sales salesOrder) throws InvalidOrderException{
        salesService.createOrder(salesOrder);
    }
}
