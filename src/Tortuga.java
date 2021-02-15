/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author leona
 * La clase tortuga contiene todos los datos relacionados con lo que sera el obajeto tortuga, ademas tendra funciones que dibujaran de diferentes maneras
 */

import SemanticErrorManager.SemanticException;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Tortuga {

    /**
     * Estas son las variables que se utilizaran para manejar todo lo relacionado con la tortuga y el punto de origen para moverse y dibujar dentro del panel
     */
    Image image;
    Integer posx = 405;
    Integer posy = 211;
    Integer posx1 = 0;
    Integer posy1 = 0;
    Integer angulo =0;
    Color color = Color.BLACK;
    Boolean visTort = false;

    /**
     * El constructor de la clase tortuga
     */
    public Tortuga(){
        
    }

    /**
     * Inicializa la clase con sus variables
     */
    public void initTortuga(){
        show_imagen();
    }

    /**
     * La funcion show_imagen carga la imagen a la variable de la clase
     */
    public void  show_imagen(){
        ImageIcon ii = new ImageIcon("src/Imagenes/tortuga.png");
        image = ii.getImage();
        
    }

    /**
     * La funcion getX retorna el valor de la posicion en x
     * @return pos x
     */
    public Integer getX (){
        return posx;
    }
    /**
     * La funcion getY retorna el valor de la posicion en y
     * @return pos y
     */
    public Integer getY (){
        return posy;
    }

    /**
     * La funcion ponx recibe como parametro x el cual sera el nuevo valor de la variable posx
     * @param x
     */
    public void ponx(Integer x) {
        this.posx = x;  
    }
    /**
     * La funcion pony recibe como parametro y el cual sera el nuevo valor de la variable posy
     * @param y
     */
    public void pony(Integer y) {
        this.posy = y;  
    }

    /**
     * La funcion ponpos recibe un x,y como enteros y los coloca como nuevas posiciones en posx y posy en la actual clase tortuga
     * @param x
     * @param y
     */
    public void ponpos(Integer x,Integer y) {
        this.posx = x; 
        this.posy = y;  
    }

    /**
     * La funcion pon_rumbo recibe como parametro angulo el cual llega a ser el nuevo angulo de la clase tortuga
     * @param angulo
     */
    public void pon_rumbo(Integer angulo) {
        this.angulo = angulo;  
    }

    /**
     * La funcion rumbo se encarga de dejar el angulo que se tiene en terminos desde 360 hasta -360
     * @return el valor del angulo entre el rango de 360 a -360
     */
    public Integer rumbo (){
        while(angulo >=360){
            angulo = angulo -360;
        }
        while(angulo <=-360){
            angulo = angulo +360;
        }
        return angulo;
    }

    /**
     * La funcion avanzar Recibe dos parametro un g2d Graphics del panel del dibujo y un x que contiene el valor que se desea avanzar y llama a la funcion linea con el parametro g2d
     * @param g2d
     * @param x
     */
    public void avanzar(Graphics2D g2d,int x){
        posx1=posx;
        posy1=posy;
        posx= valorar_x((int) Math.round(Math.cos((angulo*Math.PI)/180) * x +posx1),posx1);
        posy= valorar_y((int) Math.round(Math.sin((angulo*Math.PI)/180) * x +posy1),posy1);
        linea(g2d);
    }

    /**
     * La funcion valorar_x recibe dos parametros x y pos en la cual revisa que el valor x no sobre pase los limites del panel
     * @param x
     * @param pos
     * @return
     */
    public int valorar_x(int x,int pos){
        if(x>-1 & x<810){
            return x;
        }
        throw new SemanticException("El valor ingresado sobresale el panel de dibujo");
    }

    /**
     * La funcion valorar_x recibe dos parametros x y pos en la cual revisa que el valor x no sobre pase los limites del panel
     * @param x
     * @param pos
     * @return
     */
    public int valorar_y(int x,int pos){
        if(x>-1 & x<423){
            return x;
        }
        throw new SemanticException("El valor ingresado sobresale el panel de dibujo");
    }

    /**
     * La funcion linea recibe como parametro g2d Graphics del panel de dibujo, dibujando una linea con los dos puntos actuales en la variables de la clase
     * @param g2d
     */
    public void linea(Graphics2D g2d){
        g2d.setColor(color);
        g2d.drawLine(posx1, posy1, posx, posy);
    
    }

    /**
     * La funcion retoceder Recibe dos parametro un g2d Graphics del panel del dibujo y un x que contiene el valor que se desea retroceder y llama a la funcion linea con el parametro g2d
     * @param g2d
     * @param x
     */
    
    public void retroceder(Graphics2D g2d,int x){
        posx1=posx;
        posy1=posy;
        posx=  valorar_x(posx1 -(int) Math.round(Math.cos((angulo*Math.PI)/180) * x),posx1);
        posy= valorar_y(posy1 - (int) Math.round(Math.sin((angulo*Math.PI)/180) * x ),posy1);
        linea(g2d);
    }

    /**
     * La funcion girar_izquierda recibe un parametro x el cual se le resta al angulo que contiene la tortuga haciendo que su angolo se mueve a la izquierda
     * @param x
     */
    
    public void girar_izquierda(int x){
        this.angulo = angulo-x;
    }

    /**
     * La funcion girar_derecha recibe un parametro x el cual se le suma al angulo que contiene la tortuga haciendo que su angolo se mueve a la derecha
     * @param x
     */
    public void girar_derecha(int x){
        this.angulo = angulo+x;
        
    }

    /**
     * La funcion centro devuelve el punto de dibujo al centro del panel
     */
    public void centro(){
        posx = 405;
        posy = 211;
    }

    /**
     * La funcion goma cambia el color del lapiz a blanco para poder borrar
     */
    public void goma(){
        color= Color.WHITE;
    }

    /**
     * La funcion borrar_pantalla recibe un Graphics del panel de dibujo y dibuja un cuadro blanco que cubre toda la pantalla ocultando todo lo anterior
     * @param g
     */
    public void borrar_pantalla(Graphics2D g){
        g.setColor(Color.WHITE);
        g.fillRect(0,0, 810, 423);
    }

    /**
     * La funcion lineamouse recibe varios parametros, primero g2d el cual es el Graphics del panel de dibujo y luego cuatro variables las cuales son dos puntos uno
     * de inicio y otro de final para dibujar una linea
     * @param g2d
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public void lineamouse(Graphics2D g2d,int x1,int y1,int x2,int y2){
        g2d.setColor(color);
        g2d.drawLine(x1, y1, x2, y2);
        
    }

    /**
     * La funcion poncolor recibe un parametro color , el cual cambia el valor de color de la clase tortuga actual
     * @param color1
     */
    public void poncolor(Color color1){
        color = color1;
    }

    /**
     * La funcion OcTortuga recibe como parametro Graphics del panel de dibujo, dibujando un cuadro blanco cubriendo la tortuga para poder estarla actualizando
     * @param g
     */
    public void OcTortuga(Graphics2D g){
        g.setColor(Color.WHITE);
        g.fillRect(70, 0, 90, 84);

    }

    /**
     * La funcion OcCoor recibe como parametro Graphics del panel de dibujo, dibujando un cuadro blanco cubriendo las coordenadas para poder estarlas actualizando
     * @param g
     */
    public void OcCoor(Graphics2D g){
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 60, 60);

    }
}
