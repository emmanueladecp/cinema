/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.webapp.services;

/**
 *
 * @author ADMIN
 */
public class InvalidOrderException extends Exception {
    public InvalidOrderException(String message){
        super(message);
    }
}
