
package vista;
import controlador.*;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static vista.Principal.alto;
import static vista.Principal.ancho;

public class IngresarMedidas extends javax.swing.JDialog {
private ControlKeyTyped ckt = new ControlKeyTyped();
private JButton btnGenerarLaberinto;
private JPanel jPanelLaberinto;
    public IngresarMedidas(java.awt.Frame parent, boolean modal, JButton btnGenerarLaberinto,JPanel jPanelLaberinto) {
        
        super(parent, modal);
        this.setUndecorated(true);
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.btnGenerarLaberinto=btnGenerarLaberinto;
        this.jPanelLaberinto=jPanelLaberinto;
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtAlto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAncho = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel5.setLayout(new java.awt.CardLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INGRESAR MEDIDAS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Friz Quadrata TT", 0, 18))); // NOI18N
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setLayout(new java.awt.CardLayout());

        jPanel4.setLayout(new java.awt.GridLayout(2, 0, 0, 15));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText(" Alto:");
        jPanel4.add(jLabel1);

        txtAlto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAltoKeyTyped(evt);
            }
        });
        jPanel4.add(txtAlto);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Ancho:");
        jPanel4.add(jLabel2);

        txtAncho.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnchoKeyTyped(evt);
            }
        });
        jPanel4.add(txtAncho);

        jPanel1.add(jPanel4, "card2");

        jPanel3.add(jPanel1);

        btnConfirmar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sign-check.png"))); // NOI18N
        btnConfirmar.setText("CONFIRMAR");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        jPanel2.add(btnConfirmar);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sign-error.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar);

        jPanel3.add(jPanel2);

        jPanel5.add(jPanel3, "card2");

        getContentPane().add(jPanel5, "card3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAltoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAltoKeyTyped
        ckt.soloDigitos(evt, txtAlto, 3);
    }//GEN-LAST:event_txtAltoKeyTyped

    private void txtAnchoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnchoKeyTyped
       ckt.soloDigitos(evt, txtAncho, 3);
    }//GEN-LAST:event_txtAnchoKeyTyped

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if(!txtAlto.getText().trim().equals("")&&!txtAncho.getText().trim().equals("")){
            if(Integer.valueOf(txtAncho.getText())<5||Integer.valueOf(txtAlto.getText())<5){
                
            JOptionPane.showMessageDialog(null, "Las medidas no pueden ser menores a 5");
            }else{
                jPanelLaberinto.removeAll();
                ancho=Integer.valueOf(txtAncho.getText());
                alto=Integer.valueOf(txtAlto.getText());
                if(ancho%2==0){
                    ancho++;
                }
                if(Principal.alto%2==0){
                    alto++;
                }
                GridLayout gl =(GridLayout) jPanelLaberinto.getLayout();
            gl.setColumns(ancho);
            gl.setRows(alto);
            jPanelLaberinto.setLayout(gl);
            jPanelLaberinto.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                
                
                btnGenerarLaberinto.setEnabled(true);
                this.dispose();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Campos obligatorios vacíos");
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField txtAlto;
    private javax.swing.JTextField txtAncho;
    // End of variables declaration//GEN-END:variables
}
