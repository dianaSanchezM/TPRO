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
        lista=list;
        respuestas = new int [lista.size()];
        respuestas[lista.size()-1]=1;
        for (int i=lista.size()-2; i>=0;i-- ){
            int maximo=mayor(i);
            System.out.println(i+" "+maximo);
            if (maximo !=i) {
                respuestas[i]=1+respuestas[maximo];
            }else {
                respuestas[i]=1;
            }
        }
        
        for (int x=0 ; x<respuestas.length;x++){
            System.out.println("   "+respuestas[x]);
        }
        return respuestas[0];
    }
    
    private static int mayor(int i){
        int maxim=i;
        for (int x=i+1; x<lista.size(); x++){
            if (respuestas[x]>respuestas[maxim] && lista.get(x)>lista.get(i)){
                maxim=x;
            }
        }
        return maxim;
    }
}
