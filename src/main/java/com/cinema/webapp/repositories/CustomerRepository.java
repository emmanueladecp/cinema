/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.webapp.repositories;

import com.cinema.webapp.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author ADMIN
 */

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{


}
