/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.logitudmaxima;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author diani
 */
public class HttpServer implements Runnable {

    private ServerSocket clientSocket = null;

    public HttpServer(ServerSocket clientSocket) {
        this.clientSocket = clientSocket;
    }


    @Override
    public void run(){
        try {
            while (true){
                Socket socket = null;
                socket = clientSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                String inputLine, outputLine,datos;
                while ((inputLine = in.readLine()) != null) {
                   
                    if (inputLine.contains("GET")) {
                        String input = inputLine.split(" ")[1];
                        if (input.equals("/") || input.equals("/index.html")){
                            URL file = HttpServer.class.getResource("/index.html");
                            datos = "";
                            BufferedReader br = new BufferedReader(new InputStreamReader(file.openStream()));
                            String texto;
                            while ((texto = br.readLine()) != null){
                                datos+=texto;
                            }
                            br.close();
                            outputLine = "HTTP/1.1 200 OK\r\n"
                                    + "Content-Type: "
                                    + "text/html"
                                    +"\r\n\r\n"
                                    + datos;
                            out.println(outputLine);
                        }else if (input.contains("/response")){
                            outputLine = "HTTP/1.1 200 OK\r\n"

                                    + "Content-Type: " 

                                    + "text/html"

                                    + "\r\n\r\n"

                                    +getValue(input.split("/")[2]); 

                            out.println(outputLine);
                        }
                    }
                    if (!in.ready()){
                        break;
                    }
                    if (inputLine.equals("")){
                        break;
                    }
                } 
                out.close();
                in.close();
                socket.close();
            }
        }catch (IOException e){
            Logger.getLogger(HttpServer.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private String getValue(String valores) {
        valores= valores.split("=")[1];
        String [] lista = valores.split("%2C");
        ArrayList<Integer> arreglo = new ArrayList<>();
        for (int i = 0; i<lista.length; i++){
            arreglo.add(Integer.parseInt(lista[i]));
        }
        return String.valueOf(aplicacion.getValue(arreglo));
    }
    
}
