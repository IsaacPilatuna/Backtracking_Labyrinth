
package controlador;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class ControlKeyTyped {

    public void soloDigitos(java.awt.event.KeyEvent evt, JTextField txt, int limite){
            char c = evt.getKeyChar();
           if ((!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))||(txt.getText().length()==limite))) {
               evt.consume();
           }
    }
    
}
