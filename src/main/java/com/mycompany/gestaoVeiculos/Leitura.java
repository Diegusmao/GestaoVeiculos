package com.mycompany.gestaoVeiculos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leitura {

    public static String entDados(String dados) {

        System.out.println(dados);
        InputStreamReader tec = new InputStreamReader(System.in);
        BufferedReader buff = new BufferedReader(tec);
        String ret = "";

        try {
            ret = buff.readLine();
        } catch (IOException ioe) {
            System.out.println("/n Erro de sistema");
        }
        return ret;
    }

    public static int entDadosInt(String dados) {

      
        InputStreamReader tec = new InputStreamReader(System.in);
        BufferedReader buff = new BufferedReader(tec);
        int ret = 0;

        boolean valorInvalido = true;
        while (valorInvalido) {
            System.out.println(dados);
            try {
                ret = Integer.parseInt(buff.readLine());
                valorInvalido=false;
            } catch (IOException | NumberFormatException ine) {
                System.out.println("\n VALOR INVÁLIDO, DIGITE NOVAMENTE!\n");
            }
        }
        return ret;
    }
}
