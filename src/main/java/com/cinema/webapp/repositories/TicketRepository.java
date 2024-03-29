/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.webapp.repositories;

import com.cinema.webapp.entities.Ticket;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ADMIN
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>{

    @Query("SELECT a FROM Ticket a where a.qty > 0 and a.date >= CURRENT_DATE() ")
    List<Ticket> fetchActiveTicket();
}
