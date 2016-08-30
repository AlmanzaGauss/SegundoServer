/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundointentoth;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author falag
 */
public class HilosServer extends Thread{
    DatagramPacket peticion;
    DatagramSocket miSocket;
    MandarMensaje message= new MandarMensaje();
    public HilosServer()
    {
    
    }
    
    public HilosServer(DatagramSocket socket,DatagramPacket paquete)
    {
        this.peticion=paquete;
        this.miSocket=socket;
    }
    
    public void SendMessage(InetAddress addr, int port)
    {
         String resp= new Date().toString();
         
         
              DatagramPacket paqueteEnvio= new DatagramPacket(resp.getBytes(),resp.length(),addr,port);
            System.out.println("Enviando"+new String(paqueteEnvio.getData()));
        try {
            miSocket.send(paqueteEnvio);
        } catch (IOException ex) {
            Logger.getLogger(HilosServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run()
    {
        
        System.out.println("ip:"+peticion.getAddress());
         
         System.out.println("Canonical"+peticion.getAddress().getCanonicalHostName());
         System.out.println("SocketAddress"+peticion.getSocketAddress());
         System.out.println("Algo"+peticion.getAddress().getHostAddress());
         System.out.println("Mas"+peticion.getAddress().getHostName());
         
         System.out.println("Puerto:"+peticion.getPort());
         System.out.println("Mensaje:"+new String(peticion.getData(),0,peticion.getLength()));
              //InetAddress ip=peticion.getAddress();
              
              
              /*Aqui manadamos al Cliente*/
              
             // String resp= new Date().toString();
            InetAddress addr= peticion.getAddress();
            int port=peticion.getPort();
            
            while(true)
            {
                SendMessage(addr, port);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HilosServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
             //Timer timer = new Timer();
           // timer.schedule(message.run(), 0, 5000);
            
           /* DatagramPacket paqueteEnvio= new DatagramPacket(resp.getBytes(),resp.length(),addr,port);
            System.out.println("Enviando"+new String(paqueteEnvio.getData()));
        try {
            miSocket.send(paqueteEnvio);
        } catch (IOException ex) {
            Logger.getLogger(HilosServer.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
}
