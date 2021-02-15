/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *La clase MT se encarga del movimiento de la tortuga y coordenadas ,por medio de un thread
 * @author leona
 */
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;


public class MT  extends java.awt.Panel implements Runnable {

    /**
     * Se inicializan las funciones que se utilizaran de la clase
     */
    Thread anima;
     Image image,image2;
     java.awt.Panel Panel;
     Tortuga tortuga_aux;

    /**
     * La funcion MT es el contructor donde recibe dos parametros un panel y un objeto de la clase tortuga e inicializa unas variables de imagenes
     * @param panel
     * @param tortu
     */
     public MT (java.awt.Panel panel, Tortuga tortu){
        tortuga_aux= tortu;
        Panel=panel;
        ImageIcon ii = new ImageIcon("src/Imagenes/tortuga.png");
        image = ii.getImage();
        ImageIcon ii2 = new ImageIcon("src/Imagenes/blanco.png");
        image2 = ii2.getImage();
     }


    /**
     * La funcion start inicia el thread
     */
  public void start(){
     if(anima ==null){
        anima=new Thread(this);
        anima.start();
     }
  }

    /**
     * La funcion stop detiene el thread
     */
  public void stop(){
     if(anima!=null){
        anima.stop();
        anima=null;
     }
  }

    /**
     * La funcion run, es lo que va a correr el thread contendiendo la funcion mover
     */
  public void run() {
    while (true) {
        try {
            mover();
        } catch (InterruptedException ex) {
            Logger.getLogger(MT.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
  }

    /**
     * La funcion mover llama la funcion paint1 y si tortuga_aux.visTort es true aplica paint 2
     * @throws InterruptedException
     */
  void mover() throws InterruptedException {
    
        try {
            Thread.sleep(15);
        } catch (InterruptedException ex) {
            Logger.getLogger(java.awt.Panel.class.getName()).log(Level.SEVERE, null, ex);
        }

      paint1();
        if(tortuga_aux.visTort){
            paint2();}

    
  }

    /**
     * La funcion paint1 dibuja en pantalla las coordenadas actuales donde se encuentra la tortuga o punto de dibujo
     * @throws InterruptedException
     */
  public void paint1 () throws InterruptedException {
      Panel.getGraphics().drawImage(image2, 10, 0, 60, 60, this);
      Panel.getGraphics().drawString("Posx: "+tortuga_aux.posx, 10, 13);
      Panel.getGraphics().drawString("Posy: "+tortuga_aux.posy, 10, 29);
      
      
      
      
       
  }

    /**
     * La funcion paint2 se encarga de dibujar la tortuga y de darle el rotamiento necesario que siente el punto de dibujo para poderse guiar
     * @throws InterruptedException
     */
   public void paint2 () throws InterruptedException {
    
    Panel.getGraphics().drawImage(image2, 70, 0, 90, 75, this);
    ((Graphics2D) Panel.getGraphics()).rotate(30*Math.PI/180);
    double rotationRequired = Math.toRadians (tortuga_aux.angulo+90);
    
    AffineTransform tx = new AffineTransform();
    tx.translate(110, 40);
    tx.scale(0.2, 0.2);
    tx.rotate(rotationRequired);
    ((Graphics2D) Panel.getGraphics()).drawImage(image,tx, this);
      
   }
}
    