package View.Carga;

import View.JanelaInicial;
import View.Passeio.JanelaPasseio;
import com.mycompany.gestaoVeiculos.BDVeiculos;
import com.mycompany.gestaoVeiculos.VeicExistException;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Diego
 */
public class JanelaCadastroCarga {

    //variavel criada para evitar instanciar o listener mais d euma vez
    static boolean controleInstanciamento = false;
    
    //instanciando elementos
    private static final JFrame janelaCadastroCarga = new JFrame("Cadastro de veículos de Carga");
    private static JPanel PanelCadastro = new JPanel(new GridLayout(0, 2));
    private static JPanel PanelCadastroTitle = new JPanel(new FlowLayout());
    private static JPanel panelBotoes = new JPanel(new FlowLayout());
    private static final JLabel labelCadastroCarga = new JLabel("Preencha os dados do veículo:\n");
    private static final JButton botaoSalvarCarga = new JButton("Salvar veículo");
    private static final JButton botaoLimparCarga = new JButton("Limpar dados");
    private static final JButton botaoVoltar = new JButton("Voltar");

    private static final JLabel labelPlaca = new JLabel("Placa");
    private static final JTextField fieldPlaca = new JTextField(20);
    private static final JLabel labelMarca = new JLabel("Marca");
    private static final JTextField fieldMarca = new JTextField(20);
    private static final JLabel labelModelo = new JLabel("Modelo");
    private static final JTextField fieldModelo = new JTextField(20);
    private static final JLabel labelCor = new JLabel("Cor");
    private static final JTextField fieldCor = new JTextField(20);
    private static final JLabel labelVelocidade = new JLabel("Velocidade máxima");
    private static final JTextField fieldVelocidade = new JTextField(20);
    private static final JLabel labelQtdRodas = new JLabel("Quantidade de rodas");
    private static final JTextField fieldQtdRodas = new JTextField(20);
    private static final JLabel labelQtdPistoes = new JLabel("Quantidade de pistões");
    private static final JTextField fieldQtdPistoes = new JTextField(20);
    private static final JLabel labelPotencia = new JLabel("Potência");
    private static final JTextField fieldPotencia = new JTextField(20);
    private static final JLabel labelCargaMaxima = new JLabel("Carga máxima");
    private static final JTextField fieldCargaMaxima = new JTextField(20);
    private static final JLabel labelTara = new JLabel("Tara");
    private static final JTextField fieldTara = new JTextField(20);

    public static void carregaJanelaCadastroCarga() {

        controleInstanciamento = true;
        
        //adicionando os elementos da pagina
        PanelCadastroTitle.add(labelCadastroCarga);
        PanelCadastro.add(labelPlaca);
        PanelCadastro.add(fieldPlaca);
        PanelCadastro.add(labelMarca);
        PanelCadastro.add(fieldMarca);
        PanelCadastro.add(labelModelo);
        PanelCadastro.add(fieldModelo);
        PanelCadastro.add(labelCor);
        PanelCadastro.add(fieldCor);
        PanelCadastro.add(labelVelocidade);
        PanelCadastro.add(fieldVelocidade);
        PanelCadastro.add(labelQtdRodas);
        PanelCadastro.add(fieldQtdRodas);
        PanelCadastro.add(labelQtdPistoes);
        PanelCadastro.add(fieldQtdPistoes);
        PanelCadastro.add(labelPotencia);
        PanelCadastro.add(fieldPotencia);
        PanelCadastro.add(labelCargaMaxima);
        PanelCadastro.add(fieldCargaMaxima);
        PanelCadastro.add(labelTara);
        PanelCadastro.add(fieldTara);

        panelBotoes.add(botaoSalvarCarga);
        panelBotoes.add(botaoLimparCarga);
        panelBotoes.add(botaoVoltar);

        //listeners dos botoes
        botaoSalvarCarga.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                salvarCarga();
            }
        });
        
        botaoLimparCarga.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                limparCampos();
            }
        });
        
        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                voltarPagina();
            }
        });

        //layout e visibilidade
        janelaCadastroCarga.setSize(JanelaInicial.larguraSistema, JanelaInicial.alturaSistema);
        janelaCadastroCarga.setLayout(new BorderLayout());
        janelaCadastroCarga.add(PanelCadastroTitle, BorderLayout.NORTH);
        janelaCadastroCarga.add(PanelCadastro, BorderLayout.CENTER);
        janelaCadastroCarga.add(panelBotoes, BorderLayout.SOUTH);
        janelaCadastroCarga.setLocationRelativeTo(null);
        janelaCadastroCarga.setVisible(true);
        janelaCadastroCarga.setDefaultCloseOperation(janelaCadastroCarga.EXIT_ON_CLOSE);
    }

    //metodos
    public static void limparCampos() {
        fieldPlaca.setText("");
        fieldMarca.setText("");
        fieldModelo.setText("");
        fieldCor.setText("");
        fieldVelocidade.setText("");
        fieldQtdRodas.setText("");
        fieldQtdPistoes.setText("");
        fieldPotencia.setText("");
        fieldCargaMaxima.setText("");
        fieldTara.setText("");
        fieldPlaca.requestFocus();
    }

    public static void salvarCarga() {
        if (fieldPlaca.getText().isEmpty()) {
            BDVeiculos.placaInexistente();
        } else {
            try {
                BDVeiculos.testaPlacaPasseio(fieldPlaca.getText());
                BDVeiculos.testaPlacaCarga(fieldPlaca.getText());
                BDVeiculos.adicionaCarga();
                limparCampos();

            } catch (VeicExistException veicExcp) {
                limparCampos();
            }

            int resposta = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outro veículo de passeio?", null, JOptionPane.YES_NO_OPTION);
            if (resposta == 0) {
                limparCampos();
            } else {
                janelaCadastroCarga.dispose();
                JanelaCarga.getJanelaCarga().setVisible(true);
            }
        }
    }
    
    public static void voltarPagina() {
        JanelaCarga.carregaJanelaCarga();
        janelaCadastroCarga.dispose();
    }

    //getters e setters
    
    public static JTextField getFieldPlaca() {
        return fieldPlaca;
    }

    public static JTextField getFieldMarca() {
        return fieldMarca;
    }

    public static JTextField getFieldModelo() {
        return fieldModelo;
    }

    public static JTextField getFieldCor() {
        return fieldCor;
    }

    public static JTextField getFieldVelocidade() {
        return fieldVelocidade;
    }

    public static JTextField getFieldQtdRodas() {
        return fieldQtdRodas;
    }

    public static JTextField getFieldQtdPistoes() {
        return fieldQtdPistoes;
    }

    public static JTextField getFieldPotencia() {
        return fieldPotencia;
    }

    public static JTextField getFieldCargaMaxima() {
        return fieldCargaMaxima;
    }

    public static JTextField getFieldTara() {
        return fieldTara;
    }
    
     public static JFrame getJanelaCadastroCarga() {
        return janelaCadastroCarga;
    }

}
