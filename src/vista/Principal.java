
package vista;
import controlador.*;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Principal extends javax.swing.JFrame {
public static int[][] matriz;
public static JPanel[][] panelMngr;
public static int ancho,alto;
public static int contador=0; 
private int[] coordenadasInicio= new int[2];
private int[] coordenadasFin = new int[2];
    public Principal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnIngresarMedidas = new javax.swing.JButton();
        btnGenerarLaberinto = new javax.swing.JButton();
        btnResolverLaberinto = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jPanelLaberinto = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LABERINTO UTILIZANDO BACKTRACKING", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Friz Quadrata TT", 0, 24))); // NOI18N
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        btnIngresarMedidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/wrench.png"))); // NOI18N
        btnIngresarMedidas.setText("INGRESAR MEDIDAS");
        btnIngresarMedidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarMedidasActionPerformed(evt);
            }
        });
        jPanel2.add(btnIngresarMedidas);

        btnGenerarLaberinto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/restart.png"))); // NOI18N
        btnGenerarLaberinto.setText("GENERAR LABERINTO");
        btnGenerarLaberinto.setEnabled(false);
        btnGenerarLaberinto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarLaberintoActionPerformed(evt);
            }
        });
        jPanel2.add(btnGenerarLaberinto);

        btnResolverLaberinto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sign-check.png"))); // NOI18N
        btnResolverLaberinto.setText("RESOLVER LABERINTO");
        btnResolverLaberinto.setEnabled(false);
        btnResolverLaberinto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResolverLaberintoActionPerformed(evt);
            }
        });
        jPanel2.add(btnResolverLaberinto);

        jPanel1.add(jPanel2);

        jPanel3.setLayout(new java.awt.CardLayout());

        jPanel5.setLayout(new java.awt.CardLayout());

        jPanelLaberinto.setBackground(new java.awt.Color(204, 204, 204));
        jPanelLaberinto.setForeground(new java.awt.Color(204, 204, 255));
        jPanelLaberinto.setLayout(new java.awt.GridLayout(1, 0));
        jPanel5.add(jPanelLaberinto, "card2");

        jScrollPane1.setViewportView(jPanel5);

        jPanel3.add(jScrollPane1, "card2");

        jPanel1.add(jPanel3);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/exit.png"))); // NOI18N
        btnSalir.setText("SALIR DEL SISTEMA");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel4.add(btnSalir);

        jPanel1.add(jPanel4);

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarMedidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarMedidasActionPerformed
        new IngresarMedidas(this, true,btnGenerarLaberinto,jPanelLaberinto).setVisible(true);
    }//GEN-LAST:event_btnIngresarMedidasActionPerformed

    private void btnGenerarLaberintoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarLaberintoActionPerformed
        coordenadasInicio= new int[2];
        coordenadasFin = new int[2];
        contador=0;
        jPanelLaberinto.removeAll();
        Principal.panelMngr=new JPanel[alto][ancho];
                matriz= new int[alto][ancho];
                matriz[1][1]=1;
                JPanel panelAzulOscuro;
                Color azulOscuro = new Color(0,0,128);
                for (int i = 0; i < matriz.length; i++) {
                    for (int j = 0; j < matriz[0].length; j++) {
                        panelAzulOscuro = new JPanel();
                        panelAzulOscuro.setSize(10, 10);
                        panelAzulOscuro.setBackground(azulOscuro);
                        panelMngr[i][j]=panelAzulOscuro;
                        jPanelLaberinto.add(panelMngr[i][j]);
                        
                    }
                }
                jPanelLaberinto.repaint();
                jPanelLaberinto.updateUI();
        btnGenerarLaberinto.setEnabled(false);
        btnIngresarMedidas.setEnabled(false);
        btnResolverLaberinto.setEnabled(false);
        new GenerarLaberintoHilo(jPanelLaberinto, btnIngresarMedidas, btnGenerarLaberinto, btnResolverLaberinto).start();
    }//GEN-LAST:event_btnGenerarLaberintoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnResolverLaberintoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResolverLaberintoActionPerformed
        for (int i = 0; i < panelMngr.length; i++) {
            for (int j = 0; j < panelMngr[0].length; j++) {
                if(panelMngr[i][j].getBackground()==Color.RED){
                    coordenadasFin[0]=i;
                    coordenadasFin[1]=j;
                }else{
                    if(panelMngr[i][j].getBackground()==Color.GREEN){
                        coordenadasInicio[0]=i;
                    coordenadasInicio[1]=j;
                    }
                }
                
            }
            
        }
        if(coordenadasInicio[0]==0&&coordenadasInicio[1]==0||coordenadasFin[0]==0&&coordenadasFin[1]==0){
           JOptionPane.showMessageDialog(null, "No ha seleccionado las coordenadas de inicio y final");
       }else{
            btnResolverLaberinto.setEnabled(false);
            ResolverLaberintoHilo resolverLaberintoHilo = new ResolverLaberintoHilo(coordenadasInicio, coordenadasFin, jPanelLaberinto);
            resolverLaberintoHilo.start();
            
        
       }
    }//GEN-LAST:event_btnResolverLaberintoActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    
    public String recorrerMatriz(){
        String matrizString="";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matrizString+=matriz[i][j];
            }
            matrizString+="\n";
            
        }
        return matrizString;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarLaberinto;
    private javax.swing.JButton btnIngresarMedidas;
    private javax.swing.JButton btnResolverLaberinto;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelLaberinto;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
