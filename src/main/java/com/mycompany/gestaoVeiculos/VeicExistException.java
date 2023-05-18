package com.mycompany.gestaoVeiculos;

import javax.swing.JOptionPane;

public class VeicExistException extends Exception {

    public VeicExistException(String placa) {
        JOptionPane.showMessageDialog(null, "A placa " + placa + " já está cadastrada!", "Erro", JOptionPane.ERROR_MESSAGE);

    }
}
