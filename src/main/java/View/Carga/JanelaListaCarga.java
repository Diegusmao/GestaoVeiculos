package View.Carga;

import View.JanelaInicial;
import com.mycompany.gestaoVeiculos.BDVeiculos;
import com.mycompany.gestaoVeiculos.Carga;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego
 */
public class JanelaListaCarga {

    //variavel criada para evitar instanciar o listener mais d euma vez
    static boolean controleInstanciamento = false;

    //instanciando elementos da janela
    private static final JFrame janelaListaCarga = new JFrame("Lista Carga");
    private static JPanel PanelListTitle = new JPanel(new FlowLayout());
    private static JPanel PanelTable = new JPanel(new FlowLayout());
    private static JPanel panelBotoes = new JPanel(new FlowLayout());
    private static final JLabel labelListaCarga = new JLabel("Lista de veículos de Carga cadastrados:\n");
    private static final JButton botaoExcluirTodosCarga = new JButton("Excluir todos");
    private static final JButton botaoVoltar = new JButton("Voltar");

    //instanciando elementos da tabela
    private static final String[] colunas = {"Placa", "Marca", "Modelo", "Cor", "Vel. Máxima", "Qtd Rodas", "Carga Máxima", "Tara"};
    private static DefaultTableModel model = new DefaultTableModel(colunas, 0);
    private static JTable tableDados = new JTable(model);
    private static final JScrollPane barraRolagemLista = new JScrollPane(tableDados);

    public static void carregaJanelaListaCarga() {

        controleInstanciamento = true;

        //setando e adicionando os elementos da pagina
        PanelListTitle.add(labelListaCarga);
        model.setColumnIdentifiers(colunas);
        PanelTable.add(barraRolagemLista);
        //PanelTable.add(tableDados);

        panelBotoes.add(botaoExcluirTodosCarga);
        panelBotoes.add(botaoVoltar);

        //instanciando listeners
        botaoExcluirTodosCarga.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BDVeiculos.ExcluirListaCarga();
                imprimeListaCarga();
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JanelaCarga.getJanelaCarga().setVisible(true);
                janelaListaCarga.dispose();
            }
        });

        //layout e visibilidade
        janelaListaCarga.setSize(JanelaInicial.larguraSistema, JanelaInicial.alturaSistema);
        //tableDados.setLayout(new FlowLayout());
        janelaListaCarga.setLayout(new BorderLayout());
        janelaListaCarga.add(PanelListTitle, BorderLayout.NORTH);
        janelaListaCarga.add(barraRolagemLista, BorderLayout.CENTER);
        //janelaListaCarga.add(PanelTable, BorderLayout.CENTER);
        janelaListaCarga.add(panelBotoes, BorderLayout.SOUTH);
        janelaListaCarga.setLocationRelativeTo(null);

        // Chamar o método para exibir a lista de carga
        imprimeListaCarga();

        janelaListaCarga.setVisible(true);
        janelaListaCarga.setDefaultCloseOperation(janelaListaCarga.EXIT_ON_CLOSE);
    }

    public static void imprimeListaCarga() {
        DefaultTableModel model = (DefaultTableModel) tableDados.getModel();
        model.setRowCount(0);
        for (Carga carga : BDVeiculos.getListaCarga()) {
            String[] dadosCarga = {carga.getPlaca(), carga.getMarca(), carga.getModelo(),
                carga.getCor(), String.valueOf(carga.getVelocMax()),
                String.valueOf(carga.getQtdRodas()),
                String.valueOf(carga.getCargaMax()),
                String.valueOf(carga.getTara())};
            model.addRow(dadosCarga);
        }
    }

    public static void atualizarListaCarga() {
        model.setRowCount(0);
        tableDados.setModel(BDVeiculos.imprimirListaCarga());
    }

    public static JFrame getJanelaListaCarga() {
        return janelaListaCarga;
    }
}
