package View.Passeio;

import View.JanelaInicial;
import com.mycompany.gestaoVeiculos.BDVeiculos;
import com.mycompany.gestaoVeiculos.Passeio;
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

public class JanelaListaPasseio{

    //variavel criada para evitar instanciar o listener mais d euma vez
    static boolean controleInstanciamento = false;

    //instanciando elementos da janela
    private static final JFrame janelaListaPasseio = new JFrame("Lista Passeio");
    private static JPanel PanelListTitle = new JPanel(new FlowLayout());
    private static JPanel PanelTable = new JPanel(new FlowLayout());
    private static JPanel panelBotoes = new JPanel(new FlowLayout());
    private static final JLabel labelListaPasseio = new JLabel("Lista de veículos de Passeio cadastrados:\n");
    private static final JButton botaoExcluirTodosPasseio = new JButton("Excluir todos");
    private static final JButton botaoVoltar = new JButton("Voltar");

    //instanciando elementos da tabela
    private static final String[] colunas = {"Placa", "Marca", "Modelo", "Cor", "Vel. Máxima", "Qtd Rodas", "Qtd Passageiros"};
    private static DefaultTableModel model = new DefaultTableModel(colunas, 0);
    private static JTable tableDados = new JTable(model);
    private static final JScrollPane barraRolagemLista = new JScrollPane(tableDados);

    public static void carregaJanelaListaPasseio() {

        controleInstanciamento = true;

        //setando e adicionando os elementos da pagina
        PanelListTitle.add(labelListaPasseio);
        model.setColumnIdentifiers(colunas);
        PanelTable.add(barraRolagemLista);
        //PanelTable.add(tableDados);
        
        panelBotoes.add(botaoExcluirTodosPasseio);
        panelBotoes.add(botaoVoltar);

        //instanciando listeners
        botaoExcluirTodosPasseio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BDVeiculos.ExcluirListaPasseio();
                imprimeListaPasseio();
            }
        });
        
        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JanelaPasseio.getJanelaPasseio().setVisible(true);
                janelaListaPasseio.dispose();
            }
        });

        //layout e visibilidade
        janelaListaPasseio.setSize(JanelaInicial.larguraSistema, JanelaInicial.alturaSistema);
        //tableDados.setLayout(new FlowLayout());
        janelaListaPasseio.setLayout(new BorderLayout());
        janelaListaPasseio.add(PanelListTitle, BorderLayout.NORTH);
        janelaListaPasseio.add(barraRolagemLista, BorderLayout.CENTER);
        //janelaListaPasseio.add(PanelTable, BorderLayout.CENTER);
        janelaListaPasseio.add(panelBotoes, BorderLayout.SOUTH);
        janelaListaPasseio.setLocationRelativeTo(null);

        // Chamar o método para exibir a lista de passeio

        imprimeListaPasseio();
        
        janelaListaPasseio.setVisible(true);
        janelaListaPasseio.setDefaultCloseOperation(janelaListaPasseio.EXIT_ON_CLOSE);
    }

    public static void imprimeListaPasseio() {
        DefaultTableModel model = (DefaultTableModel) tableDados.getModel();
        model.setRowCount(0);
        for (Passeio passeio : BDVeiculos.getListaPasseio()) {
            String[] dadosPasseio = {passeio.getPlaca(), passeio.getMarca(), passeio.getModelo(),
                passeio.getCor(), String.valueOf(passeio.getVelocMax()),
                String.valueOf(passeio.getQtdRodas()),
                String.valueOf(passeio.getQtdPassageiros())};
            model.addRow(dadosPasseio);
        }
    }
    
    public static void atualizarListaPasseio() {
        model.setRowCount(0);
        tableDados.setModel(BDVeiculos.imprimirListaPasseio());
    }

    public static JFrame getJanelaListaPasseio() {
        return janelaListaPasseio;
    }
}
