/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.webapp.services;

import com.cinema.webapp.entities.Customer;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface CustomerService {
    List <Customer> findAll();
}
