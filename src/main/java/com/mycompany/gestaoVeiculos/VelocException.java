package com.mycompany.gestaoVeiculos;

import javax.swing.JOptionPane;

public class VelocException extends Exception {

    public VelocException() {
            JOptionPane.showMessageDialog(null, "Velicidade está fora dos limites brasileiros", "Erro", JOptionPane.ERROR_MESSAGE);
        
    }
}
