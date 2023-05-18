package View.Passeio;

import View.JanelaInicial;
import com.mycompany.gestaoVeiculos.BDVeiculos;
import com.mycompany.gestaoVeiculos.Passeio;
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

public class JanelaConsultaPasseio {

    //variavel criada para evitar instanciar o listener mais d euma vez
    static boolean controleInstanciamento = false;

    //instanciando elementos da janela
    private static JFrame janelaConsultaPasseio = new JFrame("Consulta veículo Passeio");
    private static JPanel PanelDados = new JPanel(new GridLayout(0, 2));
    private static JPanel PanelConsultaTitle = new JPanel(new FlowLayout());
    private static JPanel panelBotoes = new JPanel(new FlowLayout());
    private static JLabel labelConsultaPasseio = new JLabel("Dados do veículo:");
    
    private static JButton botaoExcluirPasseio = new JButton("Excluir veículo");
    private static JButton botaoConsultarPasseio = new JButton("Consultar veículo");
    private static JButton botaoVoltar = new JButton("Voltar");
    
    private static final JLabel labelPlaca = new JLabel("Placa:");
    private static final JTextField fieldPlaca = new JTextField(20);
    private static final JLabel labelMarca = new JLabel("Marca:");
    private static JLabel labelDadoMarca = new JLabel();
    private static final JLabel labelModelo = new JLabel("Modelo:");
    private static JLabel labelDadoModelo = new JLabel();
    private static final JLabel labelCor = new JLabel("Cor:");
    private static JLabel labelDadoCor = new JLabel();
    private static final JLabel labelVelocidade = new JLabel("Velocidade:");
    private static JLabel labelDadoVelocidade = new JLabel();
    private static final JLabel labelQtdRodas = new JLabel("Quantidade de rodas:");
    private static JLabel labelDadoQtdRodas = new JLabel();
    private static final JLabel labelQtdPistoes = new JLabel("Quantidade de pistoes:");
    private static JLabel labelDadoQtdPistoes = new JLabel();
    private static final JLabel labelPotencia = new JLabel("Protência:");
    private static JLabel labelDadoPotencia = new JLabel();
    private static final JLabel labelQtdPassageiros = new JLabel("Quantidade de passageiros:");
    private static JLabel labelDadoQtdPassageiros = new JLabel();

    
    
    public static void carregaJanelaConsultaPasseio() {

        controleInstanciamento = true;
        
        //setando e adicionando os elementos da pagina
        PanelConsultaTitle.add(labelConsultaPasseio);
        
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
        PanelDados.add(labelQtdPassageiros);
        PanelDados.add(labelDadoQtdPassageiros);
        janelaConsultaPasseio.add(PanelConsultaTitle, BorderLayout.NORTH);
     
        
        
        panelBotoes.add(botaoConsultarPasseio);
        panelBotoes.add(botaoExcluirPasseio);
        panelBotoes.add(botaoVoltar);
        
        //listeners dos botoes
        botaoConsultarPasseio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BDVeiculos.imprimePasseio(fieldPlaca.getText());
                fieldPlaca.requestFocus();
            }
        });

        botaoExcluirPasseio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Passeio passeio = BDVeiculos.consultaExcluirPasseio(fieldPlaca.getText());
                BDVeiculos.excluirPasseio(passeio);
                fieldPlaca.requestFocus();
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (JanelaPasseio.controleInstanciamento == false) {
                JanelaPasseio.carregaJanelaPasseio();
                janelaConsultaPasseio.dispose();
            } else {
                janelaConsultaPasseio.dispose();
                JanelaPasseio.getJanelaPasseio().setVisible(true);
            }
            }
        });

        //layout e visibilidade
        janelaConsultaPasseio.setSize(JanelaInicial.larguraSistema, JanelaInicial.alturaSistema);
        janelaConsultaPasseio.setLayout(new BorderLayout());
        janelaConsultaPasseio.add(PanelDados, BorderLayout.CENTER);
        janelaConsultaPasseio.add(panelBotoes, BorderLayout.SOUTH);
        janelaConsultaPasseio.setLocationRelativeTo(null);
        janelaConsultaPasseio.setVisible(true);
        janelaConsultaPasseio.setDefaultCloseOperation(janelaConsultaPasseio.EXIT_ON_CLOSE);
    }

    //getters e setters
    
    public static JLabel getLabelDadoMarca() {
        return labelDadoMarca;
    }

    public static void setLabelDadoMarca(JLabel labelDadoMarca) {
        JanelaConsultaPasseio.labelDadoMarca = labelDadoMarca;
    }

    public static JLabel getLabelDadoModelo() {
        return labelDadoModelo;
    }

    public static void setLabelDadoModelo(JLabel labelDadoModelo) {
        JanelaConsultaPasseio.labelDadoModelo = labelDadoModelo;
    }

    public static JLabel getLabelDadoCor() {
        return labelDadoCor;
    }

    public static void setLabelDadoCor(JLabel labelDadoCor) {
        JanelaConsultaPasseio.labelDadoCor = labelDadoCor;
    }

    public static JLabel getLabelDadoVelocidade() {
        return labelDadoVelocidade;
    }

    public static void setLabelDadoVelocidade(JLabel labelDadoVelocidade) {
        JanelaConsultaPasseio.labelDadoVelocidade = labelDadoVelocidade;
    }

    public static JLabel getLabelDadoQtdRodas() {
        return labelDadoQtdRodas;
    }

    public static void setLabelDadoQtdRodas(JLabel labelDadoQtdRodas) {
        JanelaConsultaPasseio.labelDadoQtdRodas = labelDadoQtdRodas;
    }

    public static JLabel getLabelDadoQtdPistoes() {
        return labelDadoQtdPistoes;
    }

    public static void setLabelDadoQtdPistoes(JLabel labelDadoQtdPistoes) {
        JanelaConsultaPasseio.labelDadoQtdPistoes = labelDadoQtdPistoes;
    }

    public static JLabel getLabelDadoPotencia() {
        return labelDadoPotencia;
    }

    public static void setLabelDadoPotencia(JLabel labelDadoPotencia) {
        JanelaConsultaPasseio.labelDadoPotencia = labelDadoPotencia;
    }

    public static JLabel getLabelDadoQtdPassageiros() {
        return labelDadoQtdPassageiros;
    }

    public static void setLabelDadoQtdPassageiros(JLabel labelDadoQtdPassageiros) {
        JanelaConsultaPasseio.labelDadoQtdPassageiros = labelDadoQtdPassageiros;
    }

    public static JTextField getFieldPlaca() {
        return fieldPlaca;
    }

    public static JFrame getJanelaConsultaPasseio() {
        return janelaConsultaPasseio;
    }

    public static JLabel getLabelConsultaPasseio() {
        return labelConsultaPasseio;
    }

}
