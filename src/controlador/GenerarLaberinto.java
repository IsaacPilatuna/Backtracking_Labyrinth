
package controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import vista.Principal;
import static vista.Principal.contador;
import static vista.Principal.panelMngr;

public class GenerarLaberinto {
    int ancho;
    int alto;
    int posicionX;
    int posicionY;
    String movPrevio;
    Color azulClaro = new Color(0,128,255);

    public GenerarLaberinto() {
    }
    
    
    
    public GenerarLaberinto(int ancho, int alto) {
        this.alto=alto;
        this.ancho=ancho;
        this.posicionX=1;
        this.posicionY=1;
        JPanel panelBlanco = panelMngr[posicionY][posicionX];
        panelBlanco.setBackground(Color.white);
        panelBlanco.addMouseListener(new MouseAdapter() {

                        @Override
                        public void mouseClicked(MouseEvent e) {
                           Component source = (Component) e.getSource();
                           if(contador==0){
                            source.setBackground(Color.GREEN);
                            contador++;
                           }else{
                               if(contador==1){
                                source.setBackground(Color.RED); 
                                contador++;
                               }else{
                                   JOptionPane.showMessageDialog(null, "Ya ha seleccionado el inicio y final");
                               }
                           }
                           
                        }
                        
                        

                        @Override
                        public void mouseEntered(MouseEvent e) {
                            
                            Component source = (Component) e.getSource();
                           if(source.getBackground().equals(Color.white)){
                            source.setBackground(azulClaro);
                           }
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                            Component source = (Component) e.getSource();
                            if(source.getBackground().equals(azulClaro)){
                                source.setBackground(Color.white);
                            }
                        }
                        
                    });
        
                    panelMngr[posicionY][posicionX]=panelBlanco;
    }

    private GenerarLaberinto(int ancho, int alto, int posicionX, int posicionY) {
        this.ancho=ancho;
        this.alto=alto;
        this.posicionX=posicionX;
        this.posicionY=posicionY;
    }

    public int getAlto() {
        return alto;
    }

    public int getAncho() {
        return ancho;
    }

    public String getMovPrevio() {
        return movPrevio;
    }

    public void setMovPrevio(String movPrevio) {
        this.movPrevio = movPrevio;
    }

    
    public void pintarPaneles(int posicionX1, int posicionY1, int posicionX2, int posicionY2){
        JPanel panelBlanco1 = panelMngr[posicionY1][posicionX1];
        JPanel panelBlanco2 = panelMngr[posicionY2][posicionX2];
                    panelBlanco1.setBackground(Color.white);
                    panelBlanco1.addMouseListener(new MouseAdapter() {

                        @Override
                        public void mouseClicked(MouseEvent e) {
                           Component source = (Component) e.getSource();
                           if(contador==0){
                            source.setBackground(Color.GREEN);
                            contador++;
                           }else{
                               if(contador==1){
                                source.setBackground(Color.RED); 
                                contador++;
                               }else{
                                   JOptionPane.showMessageDialog(null, "Ya ha seleccionado el inicio y final");
                               }
                           }
                           
                        }
                        
                        

                        @Override
                        public void mouseEntered(MouseEvent e) {
                            
                            Component source = (Component) e.getSource();
                           if(source.getBackground().equals(Color.white)){
                            source.setBackground(azulClaro);
                           }
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                            Component source = (Component) e.getSource();
                            if(source.getBackground().equals(azulClaro)){
                                source.setBackground(Color.white);
                            }
                        }
                        
                    });
                    panelBlanco2.setBackground(Color.white);
                    panelBlanco2.addMouseListener(new MouseAdapter() {

                        @Override
                        public void mouseClicked(MouseEvent e) {
                           Component source = (Component) e.getSource();
                           if(contador==0){
                            source.setBackground(Color.GREEN);
                            contador++;
                           }else{
                               if(contador==1){
                                source.setBackground(Color.RED); 
                                contador++;
                               }else{
                                   JOptionPane.showMessageDialog(null, "Ya ha seleccionado el inicio y final");
                               }
                           }
                           
                        }
                        
                        

                        @Override
                        public void mouseEntered(MouseEvent e) {
                            
                            Component source = (Component) e.getSource();
                           if(source.getBackground().equals(Color.white)){
                            source.setBackground(azulClaro);
                           }
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                            Component source = (Component) e.getSource();
                            if(source.getBackground().equals(azulClaro)){
                                source.setBackground(Color.white);
                            }
                        }
                        
                    });
                    panelMngr[posicionY1][posicionX1]=panelBlanco1;
                    panelMngr[posicionY2][posicionX2]=panelBlanco2;
    }
    
    public GenerarLaberinto moverArriba(){
        GenerarLaberinto lab = new GenerarLaberinto(this.ancho,this.alto,this.posicionX,this.posicionY);
        if(lab.posicionY>1){
            if(Principal.matriz[lab.posicionY-1][lab.posicionX]==0&&Principal.matriz[lab.posicionY-2][lab.posicionX]==0){
                Principal.matriz[lab.posicionY-1][lab.posicionX]=1;
                Principal.matriz[lab.posicionY-2][lab.posicionX]=1;              
                lab.posicionY=lab.posicionY-2;
                this.movPrevio="arriba";
                pintarPaneles(posicionX, posicionY-1, posicionX, posicionY-2);
                
            }else{
                lab=null;
            }
        }else{
            lab=null;
        }
        return lab;
        
    }
    
    public GenerarLaberinto checkArriba(){
        GenerarLaberinto lab = new GenerarLaberinto(this.ancho,this.alto,this.posicionX,this.posicionY);
        if(lab.posicionY>1){
            if(Principal.matriz[lab.posicionY-1][lab.posicionX]==0&&Principal.matriz[lab.posicionY-2][lab.posicionX]==0){
                
                lab.movPrevio="arriba";
            }else{
                lab=null;
            }
        }else{
            lab=null;
        }
        return lab;
        
    }
    
    public GenerarLaberinto moverAbajo(){
        GenerarLaberinto lab = new GenerarLaberinto(this.ancho,this.alto,this.posicionX,this.posicionY);
        if(lab.posicionY<alto-2){
            if(Principal.matriz[lab.posicionY+1][lab.posicionX]==0&&Principal.matriz[lab.posicionY+2][lab.posicionX]==0){
                Principal.matriz[lab.posicionY+1][lab.posicionX]=1;
                Principal.matriz[lab.posicionY+2][lab.posicionX]=1;
                lab.posicionY=lab.posicionY+2;
                lab.movPrevio="abajo";
                pintarPaneles(posicionX, posicionY+1, posicionX, posicionY+2);
            }else{
                lab=null;
            }
        }else{
            lab=null;
        }
        return lab;
    }
    
    public GenerarLaberinto checkAbajo(){
        GenerarLaberinto lab = new GenerarLaberinto(this.ancho,this.alto,this.posicionX,this.posicionY);
        if(lab.posicionY<alto-2){
            if(Principal.matriz[lab.posicionY+1][lab.posicionX]==0&&Principal.matriz[lab.posicionY+2][lab.posicionX]==0){
               
                lab.movPrevio="abajo";
            }else{
                lab=null;
            }
        }else{
            lab=null;
        }
        return lab;
    }
    
    public GenerarLaberinto moverIzquierda(){
         GenerarLaberinto lab = new GenerarLaberinto(this.ancho,this.alto,this.posicionX,this.posicionY);
        if(lab.posicionX>1){
            if(Principal.matriz[lab.posicionY][lab.posicionX-1]==0&&Principal.matriz[lab.posicionY][lab.posicionX-2]==0){
                Principal.matriz[lab.posicionY][lab.posicionX-1]=1;
                Principal.matriz[lab.posicionY][lab.posicionX-2]=1;
                lab.posicionX=lab.posicionX-2;
                this.movPrevio="izq";
                pintarPaneles(posicionX-1, posicionY, posicionX-2, posicionY);
            }else{
                lab=null;
            }
        }else{
            lab=null;
        }
        return lab;
    }
    
    public GenerarLaberinto checkIzquierda(){
         GenerarLaberinto lab = new GenerarLaberinto(this.ancho,this.alto,this.posicionX,this.posicionY);
        if(lab.posicionX>1){
            if(Principal.matriz[lab.posicionY][lab.posicionX-1]==0&&Principal.matriz[lab.posicionY][lab.posicionX-2]==0){
                
                lab.movPrevio="izq";
            }else{
                lab=null;
            }
        }else{
            lab=null;
        }
        return lab;
    }
    
    public GenerarLaberinto moverDerecha(){
        GenerarLaberinto lab = new GenerarLaberinto(this.ancho,this.alto,this.posicionX,this.posicionY);
        if(lab.posicionX<ancho-2){
            if(Principal.matriz[lab.posicionY][lab.posicionX+1]==0&&Principal.matriz[lab.posicionY][lab.posicionX+2]==0){
                Principal.matriz[lab.posicionY][lab.posicionX+1]=1;
               Principal.matriz[lab.posicionY][lab.posicionX+2]=1;
                lab.posicionX=lab.posicionX+2;
                this.movPrevio="der";
                pintarPaneles(posicionX+1, posicionY, posicionX+2, posicionY);
            }else{
                lab=null;
            }
        }else{
            lab=null;
        }
        return lab;
    }
    
public GenerarLaberinto checkDerecha(){
        GenerarLaberinto lab = new GenerarLaberinto(this.ancho,this.alto,this.posicionX,this.posicionY);
        if(lab.posicionX<ancho-2){
            if(Principal.matriz[lab.posicionY][lab.posicionX+1]==0&&Principal.matriz[lab.posicionY][lab.posicionX+2]==0){
                
                lab.movPrevio="der";
            }else{
                lab=null;
            }
        }else{
            lab=null;
        }
        return lab;
    }
    
    public ArrayList<GenerarLaberinto> posiblesMovimientos(){
        ArrayList<GenerarLaberinto> posibilidades = new ArrayList<>();
        GenerarLaberinto arriba=null;
        GenerarLaberinto abajo=null;
        GenerarLaberinto izquierda=null;
        GenerarLaberinto derecha=null;
        if(this.movPrevio==null){
             arriba = this.checkArriba();
             abajo = this.checkAbajo();
             izquierda = this.checkIzquierda();
             derecha = this.checkDerecha();
            
        }else{
            switch(movPrevio){
                case "arriba":
                    abajo = this.checkAbajo();
                    izquierda = this.checkIzquierda();
                    derecha = this.checkDerecha();
                    break;
                    
                case "abajo":
                    arriba = this.checkArriba();
                    izquierda = this.checkIzquierda();
                    derecha = this.checkDerecha();
                    break;
                    
                case "izq":
                    arriba = this.checkArriba();
                    abajo=this.checkAbajo();
                    derecha = this.checkDerecha();
                    break;
                    
                case "der":
                    arriba = this.checkArriba();
                    abajo=this.checkAbajo();
                    izquierda = this.checkIzquierda();
                    break;
            }
        }
         if(arriba!=null){
                posibilidades.add(arriba);
            }
         if(abajo!=null){
                posibilidades.add(abajo);
            }
         if(izquierda!=null){
                posibilidades.add(izquierda);
            }
         if(derecha!=null){
                posibilidades.add(derecha);
            }
        return posibilidades;
    }
    
    
}
