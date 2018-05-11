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
public class aplicacion {
    private static ArrayList<Integer> lista;
    private static int[] respuestas;
    public static int getValue(ArrayList<Integer> list){
        int n=-1;
        lista=list;
        respuestas = new int [lista.size()];
        respuestas[lista.size()-1]=1;
        for (int i=lista.size()-2; i>=0;i-- ){
            int maximo=mayor(i);
            respuestas[i]=1+respuestas[maximo];
        }
        return respuestas[0];
    }
    
    private static int mayor(int i){
        int maxim=0;
        for (int x=i; x<lista.size(); x++){
            if ( respuestas[x]>maxim && lista.get(x)>lista.get(i)){
                maxim=x;
            }
        }
        return maxim;
    }
}
