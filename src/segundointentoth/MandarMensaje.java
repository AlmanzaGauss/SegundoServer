/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundointentoth;

import java.util.TimerTask;

/**
 *
 * @author falag
 */
public class MandarMensaje extends TimerTask {
    
    
    
    public MandarMensaje()
    {
        //System.out.println("Pruebas de hilos");
    }
    
     public int EnviarMensaje()
    {
        System.out.println("Pruebas de hilos");
        return 0;
    }
    
    

    @Override
    public void run() {
        EnviarMensaje();
    }
    
}
