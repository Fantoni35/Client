/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientserver;

/**
 *
 * @author PC
 */

import java.io.*;
import java.net.*;

public class Client {
    String nomeServer="Localhost";
    int portaServer=6789;
    Socket mioSocket;
    BufferedReader tastiera;
    String stringaUtente;
    String stringaRicevutaDalServer;
    DataOutputStream outVersoServer;
    BufferedReader inDalServer;

    public Socket Connetti(){
        System.out.println("Client partito in esecuzione");
        try
        {
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            mioSocket=new Socket(nomeServer,portaServer);
            outVersoServer=new DataOutputStream(mioSocket.getOutputStream());
            inDalServer = new BufferedReader(new InputStreamReader(mioSocket.getInputStream()));

        }
        catch (UnknownHostException e){
            System.err.println("host sconosciuto");

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("errore durante la connessione!");
            System.exit(1);

        }
        return mioSocket;
    }
    public void comunica(){
        try{
            System.out.println("4... inserisci la stringa da trasmettere al server:"+'\n');
            stringaUtente= tastiera.readLine();
            System.out.println("5...invio la stringa al server e attendo...");
            outVersoServer.writeBytes(stringaUtente+'\n');
            stringaRicevutaDalServer=inDalServer.readLine();
            System.out.println("8...risposta dal server"+'\n'+stringaRicevutaDalServer);
            System.out.println("9 CLIENT: termina elaborazione e chiude la connessione");
            mioSocket.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la comunicazione col server");
            System.exit(1);
        }
    }
}







