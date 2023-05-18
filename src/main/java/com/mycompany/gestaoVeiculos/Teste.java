package com.mycompany.gestaoVeiculos;

import View.JanelaInicial;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Teste {
    
    

//    static int resposta = 0;
//    static BDVeiculos db = new BDVeiculos();
//    
//    static private JFrame janelaInicial = new JFrame();
//    
//    
//    static Teste janela = new Teste();
//    static JLabel labelInicial = new JLabel();
//    static JButton botaoPasseio = new JButton();
//    static JButton botaoCarga = new JButton();
//    
//    static private JFrame janelaPasseio = new JFrame();
//    static JLabel labelPasseio = new JLabel();
//    static JButton botaoCadastrarPasseio = new JButton();
//    static JButton botaoConsultarPasseio = new JButton();
//    static JButton botaoImprimirPasseio = new JButton();
//    
//    static private JFrame janelaCarga = new JFrame();
//    static JLabel labelCarga = new JLabel();
//    static JButton botaoCadastrarCarga = new JButton();
//    static JButton botaoConsultarCarga = new JButton();
//    static JButton botaoImprimirCarga = new JButton();
//    
    public static void main(String[] args){
        
    
    JanelaInicial.carregaJanelaInicial();
    }
//        
//        // janela inicial --------------------------------------------
//        
//        labelInicial.setText("Escolha o tipo de veículo:\n");
//        botaoPasseio.setText("Veículo de Passeio");
//        botaoCarga.setText("Veículo de Carga");
//        
//        janelaInicial.setSize(500, 500);
//        janelaInicial.setTitle("Gestão de Veículos");
//        janelaInicial.add(labelInicial);
//        janelaInicial.add(botaoPasseio);
//        janelaInicial.add(botaoCarga);
//        
//        botaoPasseio.addActionListener(janela);
//        botaoCarga.addActionListener(janela);
//          
//        janelaInicial.setLayout(new FlowLayout());
//        janelaInicial.setVisible(true);
//        
//        // janela de veículo passeio ---------------------------------
//        
//        labelPasseio.setText("Escolha uma das opções:\n");
//        botaoCadastrarPasseio.setText("Cadastrar");
//        botaoConsultarPasseio.setText("Consultar por placa");
//        botaoImprimirPasseio.setText("Consultar lista de veículos");
//        
//        janelaPasseio.setSize(500, 500);
//        janelaPasseio.setTitle("Veículos de Passeio");
//        janelaPasseio.add(labelPasseio);
//        janelaPasseio.add(botaoCadastrarPasseio);
//        janelaPasseio.add(botaoConsultarPasseio);
//        janelaPasseio.add(botaoImprimirPasseio);
//          
//        janelaPasseio.setLayout(new FlowLayout());
//        janelaPasseio.setVisible(false);
//        
//        // janela de veículo carga ---------------------------------
//        
//        labelCarga.setText("Escolha uma das opções:\n");
//        botaoCadastrarCarga.setText("Cadastrar");
//        botaoConsultarCarga.setText("Consultar por placa");
//        botaoImprimirCarga.setText("Consultar lista de veículos");
//        
//        janelaCarga.setSize(500, 500);
//        janelaCarga.setTitle("Veículos de Passeio");
//        janelaCarga.add(labelCarga);
//        janelaCarga.add(botaoCadastrarCarga);
//        janelaCarga.add(botaoConsultarCarga);
//        janelaCarga.add(botaoImprimirCarga);
//          
//        janelaCarga.setLayout(new FlowLayout());
//        janelaCarga.setVisible(false);
        
        

//        String testaPlaca = "";
//
//        while (resposta != 7) {
//
//            System.out.println(" ______________________________________________");
//            System.out.println("|                                              |");
//            System.out.println("| Sistema de Gestão de Veículos - Menu Inicial |");
//            System.out.println("|                                              |");
//            System.out.println("| 1.............. Cadastrar Veículo de Passeio |");
//            System.out.println("| 2................ Cadastrar Veículo de Carga |");
//            System.out.println("| 3...... Imprimir Todos os Veículo de Passeio |");
//            System.out.println("| 4........ Imprimir Todos os Veículo de Carga |");
//            System.out.println("| 5.... Imprimir Veículo de Passeio pela Placa |");
//            System.out.println("| 6...... Imprimir Veículo de Carga pela Placa |");
//            System.out.println("| 7..... Excluir Veículo de Passeio pela Placa |");
//            System.out.println("| 8....... Excluir Veículo de Carga pela Placa |");
//            System.out.println("| 9........................... Sair do Sistema |");
//            System.out.println("|______________________________________________|\n");
//
//            try {
//                resposta = Leitura.entDadosInt("\n\tEscoha uma opção:");
//
//            } catch (NumberFormatException nfe) {
//                System.out.println("Opção inválida. escolha um numero de 1 a 7!");
//                continue;
//            }
//            switch (resposta) {
//                case 1:
//                    System.out.println("\nOpção escolhida:");
//                    System.out.println("1.............. Cadastrar Veículo de Passeio");
//
//                    while (resposta == 1) {
//                        testaPlaca = Leitura.entDados("\nDigite a PLACA do veículo: ");
//
//                        try {
//                            db.testaPlacaPasseio(testaPlaca);
//                        } catch (VeicExistException veexp) {
//                            break;
//                        }
//
//                        try {
//                            db.testaPlacaCarga(testaPlaca);
//                        } catch (VeicExistException veexp) {
//                            break;
//                        }
//
//                        Passeio p1 = new Passeio();
//                        p1.setPlaca(testaPlaca);
//
//                        p1.setMarca(Leitura.entDados("Digite a MARCA do veículo: "));
//                        p1.setModelo(Leitura.entDados("Digite o MODELO do veículo: "));
//                        p1.setCor(Leitura.entDados("Digite a COR do veículo: "));
//                        try {
//                            p1.setVelocMax(Leitura.entDadosInt("Digite a VELOCIDADE MÁXIMA (KM/H) do veículo: "));
//                        } catch (VelocException veexp) {
//                            try {
//                                p1.setVelocMax(100);
//                            } catch (VelocException veexp2) {
//                            }
//                        }
//                        p1.setQtdRodas(Leitura.entDadosInt("Digite a QUANTIDADE DE RODAS do veículo: "));
//                        p1.getMotor().setQtdPist(Leitura.entDadosInt("Digite a QUANTIDADE DE PISTÕES do veículo: "));
//                        p1.getMotor().setPotencia(Leitura.entDadosInt("Digite a POTÊNCIA do veículo: "));
//                        p1.setQtdPassageiros(Leitura.entDadosInt("Digite a QUANTIDADE DE PASSAGEIROS do veículo: "));
//
//                        db.adicionaPasseio(p1);
//                        if (resposta != 1) {
//                            break;
//                        }
//
//                    }
//                    break;
//
//                case 2:
//                    System.out.println("\nOpção escolhida:");
//                    System.out.println("2.............. Cadastrar Veículo de Carga");
//                    resposta = 1;
//
//                    while (resposta == 1) {
//                        testaPlaca = Leitura.entDados("\nDigite a PLACA do veículo: ");
//                        try {
//                            db.testaPlacaPasseio(testaPlaca);
//                        } catch (VeicExistException veexp) {
//                            break;
//                        }
//
//                        try {
//                            db.testaPlacaCarga(testaPlaca);
//                        } catch (VeicExistException veexp) {
//                            break;
//                        }
//
//                        Carga c1 = new Carga();
//                        c1.setPlaca(testaPlaca);
//
//                        c1.setMarca(Leitura.entDados("Digite a MARCA do veículo: "));
//                        c1.setModelo(Leitura.entDados("Digite o MODELO do veículo: "));
//                        c1.setCor(Leitura.entDados("Digite a COR do veículo: "));
//                        try {
//                            c1.setVelocMax(Leitura.entDadosInt("Digite a VELOCIDADE MÁXIMA (KM/H) do veículo: "));
//                        } catch (VelocException veexp) {
//                            try {
//                                c1.setVelocMax(90);
//                            } catch (VelocException veexp2) {
//                            }
//                        }
//                        c1.setQtdRodas(Leitura.entDadosInt("Digite a QUANTIDADE DE RODAS do veículo: "));
//                        c1.getMotor().setQtdPist(Leitura.entDadosInt("Digite a QUANTIDADE DE PISTÕES do veículo: "));
//                        c1.getMotor().setPotencia(Leitura.entDadosInt("Digite a POTÊNCIA do veículo: "));
//                        c1.setCargaMax(Leitura.entDadosInt("Digite a CARGA MÁXIMA do veículo: "));
//                        c1.setTara(Leitura.entDadosInt("Digite a TARA do veículo: "));
//
//                        db.adicionaCarga(c1);
//                        if (resposta != 1) {
//                            break;
//                        }
//                    }
//
//                    break;
//                case 3:
//                    db.imprimirListaPasseio();
//                    break;
//                case 4:
//                    db.imprimirListaCarga();
//                    break;
//
//                case 5:
//                    while (resposta == 5) {
//                        db.imprimePasseio();
//                    }
//                    break;
//                case 6:
//                    while (resposta == 6) {
//                        db.imprimeCarga();
//                    }
//                    break;
//                case 7:
//                    while (resposta == 7) {
//                        db.ExcluiPasseio();
//                    }
//                    break;
//                case 8:
//                    while (resposta == 8) {
//                        db.ExcluiCarga();
//                    }
//                    break;
//                case 9:
//                    System.out.println("\nENCERRANDO SISTEMA... ATÉ LOGO!");
//                    break;
//                default:
//                    System.out.println("\nEscolha uma opção entre asseguintes:!\n");
//            }
//        }
    }
    
    
    
    
    

//    @Override
//    public void actionPerformed(ActionEvent evt) {
//        Object obj = evt.getSource();
//        
//        if(obj.equals(botaoPasseio)){
//            janelaInicial.setVisible(false);
//            janelaPasseio.setVisible(true);
//        }
//        
//        if(obj.equals(botaoCarga)){
//            janelaInicial.setVisible(false);
//            janelaCarga.setVisible(true);
//        }
//    }
//}