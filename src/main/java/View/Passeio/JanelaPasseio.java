package View.Passeio;

import View.JanelaInicial;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Diego
 */

public class JanelaPasseio {
    
    //variavel criada para evitar instanciar o listener mais d euma vez
    public static boolean controleInstanciamento = false;

    //instanciando elementos
    private static final JFrame janelaPasseio = new JFrame("Veículos de Passeio");
    private static final JPanel PanelOptions = new JPanel(new GridLayout(0, 1));
    private static final JLabel labelPasseio = new JLabel("Escolha uma das opções para veículo de passeio:\n");
    private static final JButton botaoCadastrarPasseio = new JButton("Cadastrar");
    private static final JButton botaoConsultarPasseio = new JButton("Consultar por placa");
    private static final JButton botaoListaPasseio = new JButton("Consultar lista de veículos");
    private static final JButton botaoVoltar = new JButton("Voltar ao menú inicial");

    public static void carregaJanelaPasseio() {

        controleInstanciamento = true;
        
        //adicionando os elementos da pagina
        PanelOptions.add(labelPasseio);
        PanelOptions.add(botaoCadastrarPasseio);
        PanelOptions.add(botaoConsultarPasseio);
        PanelOptions.add(botaoListaPasseio);
        PanelOptions.add(botaoVoltar);
        janelaPasseio.add(PanelOptions);

        //listeners dos botoes
        botaoCadastrarPasseio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (JanelaCadastroPasseio.controleInstanciamento == false) {
                    janelaPasseio.dispose();
                    JanelaCadastroPasseio.carregaJanelaCadastroPasseio();
                } else {
                    janelaPasseio.dispose();
                    JanelaCadastroPasseio.getJanelaCadastroPasseio().setVisible(true);
                }
            }
        });

        botaoConsultarPasseio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (JanelaConsultaPasseio.controleInstanciamento == false) {
                    janelaPasseio.dispose();
                    JanelaConsultaPasseio.carregaJanelaConsultaPasseio();
                } else {
                    janelaPasseio.dispose();
                    JanelaConsultaPasseio.getJanelaConsultaPasseio().setVisible(true);
                }
            }
        });
        
        botaoListaPasseio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (JanelaListaPasseio.controleInstanciamento == false) {
                    janelaPasseio.dispose();
                    JanelaListaPasseio.carregaJanelaListaPasseio();
                } else {
                    janelaPasseio.dispose();
                    JanelaListaPasseio.getJanelaListaPasseio().setVisible(true);
                    JanelaListaPasseio.atualizarListaPasseio();
                }
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                janelaPasseio.dispose();
                JanelaInicial.getJanelaInicial().setVisible(true);
            }
        });

        //layout e visibilidade
        janelaPasseio.setSize(JanelaInicial.larguraSistema, JanelaInicial.alturaSistema);
        janelaPasseio.setLayout(new FlowLayout());
        janelaPasseio.setVisible(true);
        janelaPasseio.setDefaultCloseOperation(janelaPasseio.EXIT_ON_CLOSE);
        janelaPasseio.setLocationRelativeTo(null);
    }


    public static JFrame getJanelaPasseio() {
        return janelaPasseio;
    }
}
