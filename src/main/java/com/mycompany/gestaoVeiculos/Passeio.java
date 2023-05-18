package com.mycompany.gestaoVeiculos;

import java.text.DecimalFormat;

public final class Passeio extends Veiculo implements Calcular{

    private int qtdPassageiros;

    public Passeio() {
        super();
        this.qtdPassageiros = 0;
    }

    @Override
    public final float calcVel(float velocMax) {
        return velocMax * 1000;
    }
    
      @Override
    public final int calcular() {
          int somaLetras;
          return somaLetras = getPlaca().length()
                              +getMarca().length()
                              +getModelo().length()
                              +getCor().length();
    }

    public int getQtdPassageiros() {
        return qtdPassageiros;
    }

    public final void setQtdPassageiros(int qtdPassageiros) {
        this.qtdPassageiros = qtdPassageiros;
    }

    @Override
    public final String toString() {
        DecimalFormat df = new DecimalFormat("#,##0");
        System.out.println("--------------------------------------");
        
        System.out.println("Marca: " + this.getMarca());
        System.out.println("Modelo: " + this.getModelo());
        System.out.println("Cor: " + this.getCor());
        System.out.println("Placa: " + this.getPlaca());
        System.out.println("Quantidade de rodas: " + this.getQtdRodas());
        System.out.println("Quantidade de Pistões: " + this.getMotor().getQtdPist());
        System.out.println("Potencia do motor: " + this.getMotor().getPotencia());
        System.out.println("Velocidade máxima: " + this.getVelocMax() + " km/h");
        System.out.println("Velocidade máxima: " + df.format(this.calcVel(getVelocMax())) + " m/h");
        System.out.println("Quantidade de passageiros: " + this.getQtdPassageiros());
        System.out.println("--------------------------------------");
        return null;
    }

  
}
