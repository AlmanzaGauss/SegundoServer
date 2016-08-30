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
import java.net.SocketException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author falag
 */
public class SegundoIntentoTh {

    /**
     * @param args the command line arguments
     */
    public SegundoIntentoTh()
    {
    
    }
    public static void main(String[] args) {
                try {
            // TODO code application logic here
            DatagramSocket miSocket= new DatagramSocket(5010);
            byte[] buffer = new byte[1824];
            while(true)
            {
                DatagramPacket peticion= new DatagramPacket(buffer, buffer.length);
              miSocket.receive(peticion);
              HilosServer hilo= new HilosServer(miSocket, peticion);
              hilo.start();
            }
        } catch (SocketException ex) {
            Logger.getLogger(SegundoIntentoTh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SegundoIntentoTh.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO code application logic here
    }
    
}
