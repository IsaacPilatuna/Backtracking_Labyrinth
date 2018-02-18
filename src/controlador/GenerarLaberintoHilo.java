
package controlador;

import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import static vista.Principal.alto;
import static vista.Principal.ancho;

public class GenerarLaberintoHilo extends Thread{
private JPanel jPanelLaberinto;
private JButton btnIngresarMedidas, btnGenerarLaberinto,btnResolverLaberinto;

    public GenerarLaberintoHilo(JPanel jPanelLaberinto, JButton btnIngresarMedidas, JButton btnGenerarLaberinto, JButton btnResolverLaberinto) {
        this.jPanelLaberinto = jPanelLaberinto;
        this.btnIngresarMedidas = btnIngresarMedidas;
        this.btnGenerarLaberinto = btnGenerarLaberinto;
        this.btnResolverLaberinto = btnResolverLaberinto;
    }
    
    
    @Override
    public void run() {
        GenerarLaberinto laberintoInicial = new GenerarLaberinto(ancho, alto);
        
        Stack pila = new Stack();
        pila.add(laberintoInicial);
        while(!pila.empty()){
            GenerarLaberinto laberinto = (GenerarLaberinto) pila.pop();
            ArrayList<GenerarLaberinto> posiblesMovimientos = laberinto.posiblesMovimientos();
            if(posiblesMovimientos.size()!=0){
                try {
                    pila.add(laberinto);
                    int posicionRandom = (int)Math.floor(Math.random()*posiblesMovimientos.size());
                    String movimiento =  posiblesMovimientos.get(posicionRandom).getMovPrevio();
                    GenerarLaberinto lab=new GenerarLaberinto();
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
                    
                    sleep(2);
                    jPanelLaberinto.repaint();
                    jPanelLaberinto.updateUI();
                    pila.add(lab);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GenerarLaberintoHilo.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
            
            
            
        }
        
        
       
        btnIngresarMedidas.setEnabled(true);
        btnGenerarLaberinto.setEnabled(true);
        btnResolverLaberinto.setEnabled(true);
    }

    @Override
    public synchronized void start() {
        super.start(); 
    }
    
}
