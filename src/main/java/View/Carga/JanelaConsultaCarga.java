package View.Carga;

import View.JanelaInicial;
import com.mycompany.gestaoVeiculos.BDVeiculos;
import com.mycompany.gestaoVeiculos.Carga;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JanelaConsultaCarga {

    //variavel criada para evitar instanciar o listener mais d euma vez
    static boolean controleInstanciamento = false;

    //instanciando elementos da janela
    private static JFrame janelaConsultaCarga = new JFrame("Consulta veículo Carga");
    private static JPanel PanelDados = new JPanel(new GridLayout(0, 2));
    private static JPanel PanelConsultaTitle = new JPanel(new FlowLayout());
    private static JPanel panelBotoes = new JPanel(new FlowLayout());
    private static JLabel labelConsultaCarga = new JLabel("Dados do veículo:");
    
    private static JButton botaoExcluirCarga = new JButton("Excluir veículo");
    private static JButton botaoConsultarCarga = new JButton("Consultar veículo");
    private static JButton botaoVoltar = new JButton("Voltar");
    
    private static JLabel labelPlaca = new JLabel("Placa:");
    private static JTextField fieldPlaca = new JTextField(20);
    private static JLabel labelMarca = new JLabel("Marca:");
    private static JLabel labelDadoMarca = new JLabel();
    private static JLabel labelModelo = new JLabel("Modelo:");
    private static JLabel labelDadoModelo = new JLabel();
    private static JLabel labelCor = new JLabel("Cor:");
    private static JLabel labelDadoCor = new JLabel();
    private static JLabel labelVelocidade = new JLabel("Velocidade:");
    private static JLabel labelDadoVelocidade = new JLabel();
    private static JLabel labelQtdRodas = new JLabel("Quantidade de rodas:");
    private static JLabel labelDadoQtdRodas = new JLabel();
    private static JLabel labelQtdPistoes = new JLabel("Quantidade de pistoes:");
    private static JLabel labelDadoQtdPistoes = new JLabel();
    private static JLabel labelPotencia = new JLabel("Protência:");
    private static JLabel labelDadoPotencia = new JLabel();
    private static JLabel labelCargaMaxima = new JLabel("Carga máxima:");
    private static JLabel labelDadoCargaMaxima = new JLabel();
    private static JLabel labelTara = new JLabel("Tara:");
    private static JLabel labelDadoTara = new JLabel();

    public static void carregaJanelaConsultaCarga() {

        controleInstanciamento = true;
        
        //setando e adicionando os elementos da pagina
        PanelConsultaTitle.add(labelConsultaCarga);
        
        PanelDados.add(labelPlaca);
        PanelDados.add(fieldPlaca);
        PanelDados.add(labelMarca);
        PanelDados.add(labelDadoMarca);
        PanelDados.add(labelModelo);
        PanelDados.add(labelDadoModelo);
        PanelDados.add(labelCor);
        PanelDados.add(labelDadoCor);
        PanelDados.add(labelVelocidade);
        PanelDados.add(labelDadoVelocidade);
        PanelDados.add(labelQtdRodas);
        PanelDados.add(labelDadoQtdRodas);
        PanelDados.add(labelQtdPistoes);
        PanelDados.add(labelDadoQtdPistoes);
        PanelDados.add(labelPotencia);
        PanelDados.add(labelDadoPotencia);
        PanelDados.add(labelCargaMaxima);
        PanelDados.add(labelDadoCargaMaxima);
        PanelDados.add(labelTara);
        PanelDados.add(labelDadoTara);
        janelaConsultaCarga.add(PanelConsultaTitle, BorderLayout.NORTH);
     
        panelBotoes.add(botaoConsultarCarga);
        panelBotoes.add(botaoExcluirCarga);
        panelBotoes.add(botaoVoltar);
        
        //listeners dos botoes
        botaoConsultarCarga.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BDVeiculos.imprimeCarga(fieldPlaca.getText());
                fieldPlaca.requestFocus();
            }
        });

        botaoExcluirCarga.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Carga carga = BDVeiculos.consultaExcluirCarga(fieldPlaca.getText());
                BDVeiculos.excluirCarga(carga);
                fieldPlaca.requestFocus();
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (JanelaCarga.controleInstanciamento == false) {
                JanelaCarga.carregaJanelaCarga();
                janelaConsultaCarga.dispose();
            } else {
                janelaConsultaCarga.dispose();
                JanelaCarga.getJanelaCarga().setVisible(true);
            }
            }
        });

        //layout e visibilidade
        janelaConsultaCarga.setSize(JanelaInicial.larguraSistema, JanelaInicial.alturaSistema);
        janelaConsultaCarga.setLayout(new BorderLayout());
        janelaConsultaCarga.add(PanelDados, BorderLayout.CENTER);
        janelaConsultaCarga.add(panelBotoes, BorderLayout.SOUTH);
        janelaConsultaCarga.setLocationRelativeTo(null);
        janelaConsultaCarga.setVisible(true);
        janelaConsultaCarga.setDefaultCloseOperation(janelaConsultaCarga.EXIT_ON_CLOSE);
    }
    
    //getters e setters
    
    public static JLabel getLabelDadoMarca() {
        return labelDadoMarca;
    }

    public static void setLabelDadoMarca(JLabel labelDadoMarca) {
        JanelaConsultaCarga.labelDadoMarca = labelDadoMarca;
    }

    public static JLabel getLabelDadoModelo() {
        return labelDadoModelo;
    }

    public static void setLabelDadoModelo(JLabel labelDadoModelo) {
        JanelaConsultaCarga.labelDadoModelo = labelDadoModelo;
    }

    public static JLabel getLabelDadoCor() {
        return labelDadoCor;
    }

    public static void setLabelDadoCor(JLabel labelDadoCor) {
        JanelaConsultaCarga.labelDadoCor = labelDadoCor;
    }

    public static JLabel getLabelDadoVelocidade() {
        return labelDadoVelocidade;
    }

    public static void setLabelDadoVelocidade(JLabel labelDadoVelocidade) {
        JanelaConsultaCarga.labelDadoVelocidade = labelDadoVelocidade;
    }

    public static JLabel getLabelDadoQtdRodas() {
        return labelDadoQtdRodas;
    }

    public static void setLabelDadoQtdRodas(JLabel labelDadoQtdRodas) {
        JanelaConsultaCarga.labelDadoQtdRodas = labelDadoQtdRodas;
    }

    public static JLabel getLabelDadoQtdPistoes() {
        return labelDadoQtdPistoes;
    }

    public static void setLabelDadoQtdPistoes(JLabel labelDadoQtdPistoes) {
        JanelaConsultaCarga.labelDadoQtdPistoes = labelDadoQtdPistoes;
    }

    public static JLabel getLabelDadoPotencia() {
        return labelDadoPotencia;
    }

    public static void setLabelDadoPotencia(JLabel labelDadoPotencia) {
        JanelaConsultaCarga.labelDadoPotencia = labelDadoPotencia;
    }

    public static JLabel getLabelDadoCargaMaxima() {
        return labelDadoCargaMaxima;
    }

    public static void setLabelDadoCargaMaxima(JLabel labelDadoQtdPassageiros) {
        JanelaConsultaCarga.labelDadoCargaMaxima = labelDadoQtdPassageiros;
    }
    
    public static JLabel getLabelDadoTara() {
        return labelDadoTara;
    }

    public static void setLabelDadoTara(JLabel labelDadoQtdPassageiros) {
        JanelaConsultaCarga.labelDadoTara = labelDadoQtdPassageiros;
    }

    public static JTextField getFieldPlaca() {
        return fieldPlaca;
    }

    public static JFrame getJanelaConsultaCarga() {
        return janelaConsultaCarga;
    }

    public static JLabel getLabelConsultaCarga() {
        return labelConsultaCarga;
    }

}

