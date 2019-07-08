/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.webapp.controllers;

/**
 *
 * @author ADMIN
 */
public class RestPreconditions {
    public static <T> T checkFound(T resource) throws ResourceNotFoundException {
        if (resource == null) {
            throw new ResourceNotFoundException();
        }
        return resource;
    }
}
