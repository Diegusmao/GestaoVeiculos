package View.Carga;

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

public class JanelaCarga {

    //variavel criada para evitar instanciar o listener mais d euma vez
    public static boolean controleInstanciamento = false;

    //instanciando elementos
    private static final JFrame janelaCarga = new JFrame("Veículo de Carga");
    private static final JPanel PanelOptions = new JPanel(new GridLayout(0, 1));
    private static final JLabel labelCarga = new JLabel("Escolha uma das opções para veículo de carga:\n");
    private static final JButton botaoCadastrarCarga = new JButton("Cadastrar");
    private static final JButton botaoConsultarCarga = new JButton("Consultar por placa");
    private static final JButton botaoListaCarga = new JButton("Consultar lista de veículos");
    private static final JButton botaoVoltar = new JButton("Voltar ao menú inicial");

    public static void carregaJanelaCarga() {

        controleInstanciamento = true;

        //adicionando os elementos da pagina
        PanelOptions.add(labelCarga);
        PanelOptions.add(botaoCadastrarCarga);
        PanelOptions.add(botaoConsultarCarga);
        PanelOptions.add(botaoListaCarga);
        PanelOptions.add(botaoVoltar);
        janelaCarga.add(PanelOptions);

        //listeners dos botoes
        botaoCadastrarCarga.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (JanelaCadastroCarga.controleInstanciamento == false) {
                    janelaCarga.dispose();
                    JanelaCadastroCarga.carregaJanelaCadastroCarga();
                } else {
                    janelaCarga.dispose();
                    JanelaCadastroCarga.getJanelaCadastroCarga().setVisible(true);
                }
            }
        });

        botaoConsultarCarga.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (JanelaConsultaCarga.controleInstanciamento == false) {
                    janelaCarga.dispose();
                    JanelaConsultaCarga.carregaJanelaConsultaCarga();
                } else {
                    janelaCarga.dispose();
                    JanelaConsultaCarga.getJanelaConsultaCarga().setVisible(true);
                }
            }
        });

        botaoListaCarga.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            if (JanelaListaCarga.controleInstanciamento == false) {
                janelaCarga.dispose();
                JanelaListaCarga.carregaJanelaListaCarga();
            } else {
                janelaCarga.dispose();
                JanelaListaCarga.getJanelaListaCarga().setVisible(true);
                JanelaListaCarga.atualizarListaCarga();
            }
    }
});

        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                janelaCarga.dispose();
                JanelaInicial.getJanelaInicial().setVisible(true);
            }
        });

        //layout e visibilidade
        janelaCarga.setSize(JanelaInicial.larguraSistema, JanelaInicial.alturaSistema);
        janelaCarga.setLayout(new FlowLayout());
        janelaCarga.setVisible(true);
        janelaCarga.setDefaultCloseOperation(janelaCarga.EXIT_ON_CLOSE);
        janelaCarga.setLocationRelativeTo(null);
    }

    public static JFrame getJanelaCarga() {
        return janelaCarga;
    }
}
