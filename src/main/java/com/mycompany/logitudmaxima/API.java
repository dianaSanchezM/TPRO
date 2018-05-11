/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.logitudmaxima;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author diana
 */
@RestController
@RequestMapping(value = "/")
public class API {
    @RequestMapping(path = "/response/{numeros}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetOrdersAPI(@PathVariable String numeros) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(HttpServer.getValue(numero), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            //
        }
        return null;
    }
    
    
}
