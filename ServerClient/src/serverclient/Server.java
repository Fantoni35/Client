/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverclient;

/**
 *
 * @author PC
 */
import java.io.*;
import java.net.*;
import java.util.*;
public class Server {
    ServerSocket server;
    Socket client;
String stringaRicevuta;
String stringaModificata = null;
BufferedReader inDalClient;
DataOutputStream outVersoClient;

public Socket attendi(){
    try
    {
        System.out.println("1 server partito in esecuzione");
        server=new ServerSocket(6789);
        client=server.accept();
        server.close();
        inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
        outVersoClient=new DataOutputStream(client.getOutputStream());
        
        
    }
    catch(Exception e){
        System.out.println(e.getMessage());
        System.out.println("errore durante l'istanza del server!");
        System.exit(1);
    }
    return client;
}
 public void comunica()
 {
     try
     {
         System.out.println("3 benvenuto client,scrivi una frase e la trasformo in maiuscolo ,Attendo");
         stringaRicevuta=inDalClient.readLine();
         System.out.println("6 ricevuta la stringa del cliente:"+stringaRicevuta);
         stringaModificata=stringaRicevuta.toUpperCase();
         System.out.println("7 invio la stringa modificata al client");
         outVersoClient.writeBytes(stringaModificata+'\n');
         System.out.println("9 server: fine elaborazioine ... buona notte");
         client.close();
        
     }
 }
}
