package View;

import View.Passeio.JanelaPasseio;
import View.Carga.JanelaCarga;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JanelaInicial {

    //setando a altura e largura de todas as paginas do sistema
    public static int alturaSistema = 600;
    public static int larguraSistema = 800;

    //instanciando elementos
    private static final JFrame janelaInicial = new JFrame();
    private static final JPanel PanelOptions = new JPanel(new GridLayout(0, 1));

    private static final JLabel labelInicial = new JLabel();
    private static final JButton botaoPasseio = new JButton();
    private static final JButton botaoCarga = new JButton();
    private static final JButton botaoFecharSistema = new JButton();

    public static void carregaJanelaInicial() {

        //dimensoes e titulo da tela
        janelaInicial.setSize(larguraSistema, alturaSistema);
        janelaInicial.setTitle("Gestão de Veículos");
        janelaInicial.setDefaultCloseOperation(janelaInicial.EXIT_ON_CLOSE); //ver se funciona

        //setando e adicionando os elementos da pagina
        labelInicial.setText("Escolha o tipo de veículo:\n");
        PanelOptions.add(labelInicial);
        botaoPasseio.setText("Veículo de Passeio");
        PanelOptions.add(botaoPasseio);
        botaoCarga.setText("Veículo de Carga");
        PanelOptions.add(botaoCarga);
        botaoFecharSistema.setText("Fechar sistema");
        PanelOptions.add(botaoFecharSistema);
        janelaInicial.add(PanelOptions);

        //listeners dos botoes
        botaoPasseio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            if (JanelaPasseio.controleInstanciamento == false) {
                janelaInicial.setVisible(false);
                JanelaPasseio.carregaJanelaPasseio();
            }else {
                    janelaInicial.dispose();
                    JanelaPasseio.getJanelaPasseio().setVisible(true);
                }
            }
        });

        botaoCarga.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (JanelaCarga.controleInstanciamento == false) {
                janelaInicial.setVisible(false);
                JanelaCarga.carregaJanelaCarga();
                } else {
                    janelaInicial.dispose();
                    JanelaCarga.getJanelaCarga().setVisible(true);
                }
            }
        });

        botaoFecharSistema.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });

        //layout e visibilidade
        janelaInicial.setLayout(new FlowLayout());
        janelaInicial.setVisible(true);
        janelaInicial.setLocationRelativeTo(null);
    }

    public static JFrame getJanelaInicial() {
        return janelaInicial;
    }
}
