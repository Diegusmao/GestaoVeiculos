package com.mycompany.gestaoVeiculos;

import java.text.DecimalFormat;

public final class Carga extends Veiculo implements Calcular {

    private int cargaMax;
    private int tara;

    public Carga() {
        this.cargaMax = 0;
        this.tara = 0;
    }

    @Override
    public final float calcVel(float velocMax) {
        return velocMax * 100000;
    }

    @Override
    public final int calcular() {
        int somaNumeros;
        return somaNumeros = (int)getVelocMax()
                + getQtdRodas()
                + getMotor().getPotencia()
                + getMotor().getQtdPist()
                + getCargaMax()
                + getTara();
    }

    public int getCargaMax() {
        return cargaMax;
    }

    public final void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    public int getTara() {
        return tara;
    }

    public final void setTara(int tara) {
        this.tara = tara;
    }

    @Override
    public final String toString() {
        DecimalFormat df = new DecimalFormat("#,##0");
        System.out.println("--------------------------------------");
        System.out.println("\nVEÍCULO DE CARGA ENCONTRADO:");
        System.out.println("\nDados do veículo: ");
        System.out.println("Marca: " + this.getMarca());
        System.out.println("Modelo: " + this.getModelo());
        System.out.println("Cor: " + this.getCor());
        System.out.println("Placa: " + this.getPlaca());
        System.out.println("Quantidade de rodas: " + this.getQtdRodas());
        System.out.println("Quantidade de Pistões: " + this.getMotor().getQtdPist());
        System.out.println("Potencia do motor: " + this.getMotor().getPotencia());
        System.out.println("Velocidade máxima: " + this.getVelocMax() + " km/h");
        System.out.println("Velocidade máxima: " + df.format(this.calcVel(getVelocMax())) + " cm/h");
        System.out.println("Carga máxima: " + this.getCargaMax());
        System.out.println("Tara: " + this.getTara());
        System.out.println("--------------------------------------");
        return null;
    }

}
