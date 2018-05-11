/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.logitudmaxima;

import java.util.ArrayList;


/**
 *
 * @author diani
 */
public class HttpServer  {

    

    public static String getValue(String valores) {
        valores= valores.split("=")[1];
        String [] lista = valores.split("%2C");
        ArrayList<Integer> arreglo = new ArrayList<>();
        for (int i = 0; i<lista.length; i++){
            arreglo.add(Integer.parseInt(lista[i]));
        }
        return String.valueOf(aplicacion.getValue(arreglo));
    }
    
}
