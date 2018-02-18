
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

public class ResolverLaberinto {
    int ancho=Principal.ancho;
    int alto=Principal.alto;
    int posicionX;
    int posicionY;
    String movPrevio;

    public ResolverLaberinto() {
    }
    
    
    public ResolverLaberinto(int[] coordenadasInicio) {
     posicionX=coordenadasInicio[1];
     posicionY=coordenadasInicio[0];
        
    }

    private ResolverLaberinto(int ancho, int alto, int posicionX, int posicionY) {
        this.ancho=ancho;
        this.alto=alto;
        this.posicionX=posicionX;
        this.posicionY=posicionY;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
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

    
    public void pintarPaneles(int posicionX1, int posicionY1){
        JPanel panelGris1 = panelMngr[posicionY1][posicionX1];
                    panelGris1.setBackground(Color.gray);
                    panelMngr[posicionY1][posicionX1]=panelGris1;
    }
    
    
    public ResolverLaberinto moverArriba(){
        ResolverLaberinto lab = new ResolverLaberinto(this.ancho,this.alto,this.posicionX,this.posicionY);
        if(lab.posicionY>1){
            if(Principal.matriz[lab.posicionY-1][lab.posicionX]==1){
                Principal.matriz[lab.posicionY-1][lab.posicionX]=2;
                lab.posicionY=lab.posicionY-1;
                this.movPrevio="arriba";
                pintarPaneles(posicionX, posicionY-1);
            }else{
                lab=null;
            }
        }else{
            lab=null;
        }
        return lab;
        
    }
        public ResolverLaberinto checkArriba(){
        ResolverLaberinto lab = new ResolverLaberinto(this.ancho,this.alto,this.posicionX,this.posicionY);
        if(lab.posicionY>1){
            if(Principal.matriz[lab.posicionY-1][lab.posicionX]==1){
                
                lab.movPrevio="arriba";
            }else{
                lab=null;
            }
        }else{
            lab=null;
        }
        return lab;
        
    }
    
    public ResolverLaberinto moverAbajo(){
        ResolverLaberinto lab = new ResolverLaberinto(this.ancho,this.alto,this.posicionX,this.posicionY);
        if(lab.posicionY<alto-2){
            if(Principal.matriz[lab.posicionY+1][lab.posicionX]==1){
                Principal.matriz[lab.posicionY+1][lab.posicionX]=2;
                lab.posicionY=lab.posicionY+1;
                this.movPrevio="abajo";
                pintarPaneles(posicionX, posicionY+1);
            }else{
                lab=null;
            }
        }else{
            lab=null;
        }
        return lab;
    }
    
       public ResolverLaberinto checkAbajo(){
        ResolverLaberinto lab = new ResolverLaberinto(this.ancho,this.alto,this.posicionX,this.posicionY);
        if(lab.posicionY<alto-2){
            if(Principal.matriz[lab.posicionY+1][lab.posicionX]==1){
               
                lab.movPrevio="abajo";
            }else{
                lab=null;
            }
        }else{
            lab=null;
        }
        return lab;
    }
    
       
    public ResolverLaberinto moverIzquierda(){
         ResolverLaberinto lab = new ResolverLaberinto(this.ancho,this.alto,this.posicionX,this.posicionY);
        if(lab.posicionX>1){
            if(Principal.matriz[lab.posicionY][lab.posicionX-1]==1){
                Principal.matriz[lab.posicionY][lab.posicionX-1]=2;
                lab.posicionX=lab.posicionX-1;
                this.movPrevio="izq";
                pintarPaneles(posicionX-1, posicionY);
            }else{
                lab=null;
            }
        }else{
            lab=null;
        }
        return lab;
    }
    
    public ResolverLaberinto checkIzquierda(){
         ResolverLaberinto lab = new ResolverLaberinto(this.ancho,this.alto,this.posicionX,this.posicionY);
        if(lab.posicionX>1){
            if(Principal.matriz[lab.posicionY][lab.posicionX-1]==1){
                
                lab.movPrevio="izq";
            }else{
                lab=null;
            }
        }else{
            lab=null;
        }
        return lab;
    }
    
    public ResolverLaberinto moverDerecha(){
        ResolverLaberinto lab = new ResolverLaberinto(this.ancho,this.alto,this.posicionX,this.posicionY);
        if(lab.posicionX<ancho-2){
            if(Principal.matriz[lab.posicionY][lab.posicionX+1]==1){
                Principal.matriz[lab.posicionY][lab.posicionX+1]=2;
                lab.posicionX=lab.posicionX+1;
                this.movPrevio="der";
                pintarPaneles(posicionX+1, posicionY);
            }else{
                lab=null;
            }
        }else{
            lab=null;
        }
        return lab;
    }
    public ResolverLaberinto checkDerecha(){
        ResolverLaberinto lab = new ResolverLaberinto(this.ancho,this.alto,this.posicionX,this.posicionY);
        if(lab.posicionX<ancho-2){
            if(Principal.matriz[lab.posicionY][lab.posicionX+1]==1){
                
                lab.movPrevio="der";
            }else{
                lab=null;
            }
        }else{
            lab=null;
        }
        return lab;
    }
    
    public ArrayList<ResolverLaberinto> posiblesMovimientos(){
        ArrayList<ResolverLaberinto> posibilidades = new ArrayList<>();
        ResolverLaberinto arriba=null;
        ResolverLaberinto abajo=null;
        ResolverLaberinto izquierda=null;
        ResolverLaberinto derecha=null;
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
