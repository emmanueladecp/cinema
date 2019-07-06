/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.webapp.repositories;

import com.cinema.webapp.entities.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author ADMIN
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
     List<Customer> findByName(String name);
}
