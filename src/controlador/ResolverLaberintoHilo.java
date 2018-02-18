
package controlador;

import java.awt.Color;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import static vista.Principal.alto;
import static vista.Principal.ancho;
import static vista.Principal.panelMngr;

public class ResolverLaberintoHilo extends Thread{
private int[] coordenadasInicio;
private int[] coordenadasFin;
private JPanel jPanelLaberinto;

    public ResolverLaberintoHilo(int[] coordenadasInicio, int[] coordenadasFin, JPanel jPanelLaberinto){
        
        this.coordenadasInicio = coordenadasInicio;
        this.coordenadasFin = coordenadasFin;
        this.jPanelLaberinto = jPanelLaberinto;
    }
    
    
    @Override
    public void run() {
        ResolverLaberinto resolverLaberinto = new ResolverLaberinto(coordenadasInicio);
        Stack pila=new Stack();
        pila.add(resolverLaberinto);
        try{
            while(!pila.empty()){
            ResolverLaberinto laberinto = (ResolverLaberinto) pila.pop();
            if(laberinto.getPosicionX()==coordenadasFin[1]&&laberinto.getPosicionY()==coordenadasFin[0]){
                pila.add(laberinto);
                int error=1/0;
                            

                    }
            ArrayList<ResolverLaberinto> posiblesMovimientos = laberinto.posiblesMovimientos();
            if(posiblesMovimientos.size()!=0){
                try {
                    pila.add(laberinto);
                    int posicionRandom = (int)Math.floor(Math.random()*posiblesMovimientos.size());
                    String movimiento =  posiblesMovimientos.get(posicionRandom).getMovPrevio();
                    ResolverLaberinto lab=new ResolverLaberinto();
                    switch(movimiento){
                        case "arriba":
                            lab=laberinto.moverArriba();
                            break;
                            
                        case "abajo":
                            lab=laberinto.moverAbajo();
                            break;
                            
                        case "izq":
                            lab=laberinto.moverIzquierda();
                            break;
                            
                        case "der":
                            lab=laberinto.moverDerecha();
                            break;
                    }
                    
                    sleep(1);
                    jPanelLaberinto.repaint();
                    jPanelLaberinto.updateUI();
                    pila.add(lab);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GenerarLaberintoHilo.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
            
            
            
        }
        }catch(Exception e){
            
        }
        
       
        
        
        while(!pila.empty()){
            try {
                ResolverLaberinto laberinto = (ResolverLaberinto) pila.pop();
                panelMngr[laberinto.getPosicionY()][laberinto.getPosicionX()].setBackground(Color.yellow);
                jPanelLaberinto.repaint();
                jPanelLaberinto.updateUI();
                sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(ResolverLaberintoHilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
       
    }

    @Override
    public synchronized void start() {
        super.start(); 
    }
    
    
}
