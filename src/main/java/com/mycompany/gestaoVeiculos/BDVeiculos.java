package com.mycompany.gestaoVeiculos;

import View.Carga.JanelaCadastroCarga;
import View.Carga.JanelaConsultaCarga;
import static View.Carga.JanelaConsultaCarga.getJanelaConsultaCarga;
import static View.Carga.JanelaListaCarga.imprimeListaCarga;
import View.Passeio.JanelaCadastroPasseio;
import View.Passeio.JanelaConsultaPasseio;
import static View.Passeio.JanelaConsultaPasseio.getJanelaConsultaPasseio;
import static View.Passeio.JanelaListaPasseio.imprimeListaPasseio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BDVeiculos {

    private static final String[] colunasPasseio = {"Placa", "Marca", "Modelo", "Cor", "Vel. Máxima", "Qtd Rodas", "Qtd Passageiros"};
    private static final String[] colunasCarga = {"Placa", "Marca", "Modelo", "Cor", "Vel. Máxima", "Qtd Rodas", "Carga máxima", "Tara"};
    private static DefaultTableModel model = new DefaultTableModel(colunasPasseio, 0);

    private static List<Passeio> listaPasseio = new ArrayList();
    private static List<Carga> listaCarga = new ArrayList();

    public static void testaPlacaCarga(String placa) throws VeicExistException {
        for (Carga carga : listaCarga) {
            if (carga.getPlaca().equals(placa)) {
                throw new VeicExistException(placa);
            }
        }
    }

    public static void testaPlacaPasseio(String placa) throws VeicExistException {
        for (Passeio passeio : listaPasseio) {
            if (passeio.getPlaca().equals(placa)) {
                throw new VeicExistException(placa);
            }
        }
    }

    public static void adicionaPasseio() {

        Passeio p1 = new Passeio();
        p1.setPlaca(JanelaCadastroPasseio.getFieldPlaca().getText());
        p1.setMarca(JanelaCadastroPasseio.getFieldMarca().getText());
        p1.setModelo(JanelaCadastroPasseio.getFieldModelo().getText());
        p1.setCor(JanelaCadastroPasseio.getFieldCor().getText());
        try {
            p1.setVelocMax(Float.parseFloat(JanelaCadastroPasseio.getFieldVelocidade().getText()));
        } catch (VelocException velocExcp) {
        }
        p1.setQtdRodas(Integer.parseInt(JanelaCadastroPasseio.getFieldQtdRodas().getText()));
        p1.getMotor().setQtdPist(Integer.parseInt(JanelaCadastroPasseio.getFieldQtdPistoes().getText()));
        p1.getMotor().setPotencia(Integer.parseInt(JanelaCadastroPasseio.getFieldPotencia().getText()));
        p1.setQtdPassageiros(Integer.parseInt(JanelaCadastroPasseio.getFieldQtdPassageiros().getText()));

        listaPasseio.add(p1);
        JOptionPane.showMessageDialog(null, "Veículo cadastrado com sucesso");

    }

    public static void adicionaCarga() {
        Carga c1 = new Carga();
        c1.setPlaca(JanelaCadastroCarga.getFieldPlaca().getText());
        c1.setMarca(JanelaCadastroCarga.getFieldMarca().getText());
        c1.setModelo(JanelaCadastroCarga.getFieldModelo().getText());
        c1.setCor(JanelaCadastroCarga.getFieldCor().getText());
        try {
            c1.setVelocMax(Float.parseFloat(JanelaCadastroCarga.getFieldVelocidade().getText()));
        } catch (VelocException velocExcp) {
        }
        c1.setQtdRodas(Integer.parseInt(JanelaCadastroCarga.getFieldQtdRodas().getText()));
        c1.getMotor().setQtdPist(Integer.parseInt(JanelaCadastroCarga.getFieldQtdPistoes().getText()));
        c1.getMotor().setPotencia(Integer.parseInt(JanelaCadastroCarga.getFieldPotencia().getText()));
        c1.setCargaMax(Integer.parseInt(JanelaCadastroCarga.getFieldCargaMaxima().getText()));
        c1.setTara(Integer.parseInt(JanelaCadastroCarga.getFieldTara().getText()));

        listaCarga.add(c1);
        JOptionPane.showMessageDialog(null, "Veículo cadastrado com sucesso");

    }

    public static void imprimePasseio(String placa) {

        boolean placaEncontrada = false;
        Passeio p1 = new Passeio();
        if (placa != null) {
            for (Passeio passeio : listaPasseio) {
                if (passeio.getPlaca().equals(placa)) {

                    JanelaConsultaPasseio.getLabelDadoMarca().setText(passeio.getMarca());
                    JanelaConsultaPasseio.getLabelDadoModelo().setText(passeio.getModelo());
                    JanelaConsultaPasseio.getLabelDadoCor().setText(passeio.getCor());
                    JanelaConsultaPasseio.getLabelDadoVelocidade().setText(Float.toString(passeio.getVelocMax()));
                    JanelaConsultaPasseio.getLabelDadoQtdRodas().setText(Integer.toString(passeio.getQtdRodas()));
                    JanelaConsultaPasseio.getLabelDadoQtdPistoes().setText(Integer.toString(passeio.getMotor().getQtdPist()));
                    JanelaConsultaPasseio.getLabelDadoPotencia().setText(Integer.toString(passeio.getMotor().getPotencia()));
                    JanelaConsultaPasseio.getLabelDadoQtdPassageiros().setText(Integer.toString(passeio.getQtdPassageiros()));
                    JanelaConsultaPasseio.getFieldPlaca().requestFocus();

                    p1 = passeio;
                    placaEncontrada = true;
                    break;
                }
            }
            if (placaEncontrada == false) {
                JanelaConsultaPasseio.getFieldPlaca().setText("");
                JanelaConsultaPasseio.getLabelDadoMarca().setText("");
                JanelaConsultaPasseio.getLabelDadoModelo().setText("");
                JanelaConsultaPasseio.getLabelDadoCor().setText("");
                JanelaConsultaPasseio.getLabelDadoVelocidade().setText("");
                JanelaConsultaPasseio.getLabelDadoQtdRodas().setText("");
                JanelaConsultaPasseio.getLabelDadoQtdPistoes().setText("");
                JanelaConsultaPasseio.getLabelDadoPotencia().setText("");
                JanelaConsultaPasseio.getLabelDadoQtdPassageiros().setText("");
                JOptionPane.showMessageDialog(null, "Placa não encontrada", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Placa não encontrada", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void placaInexistente() {
        JOptionPane.showMessageDialog(null, "Digite uma placa", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void listaVeiculosInexistente() {
        JOptionPane.showMessageDialog(null, "Não há veículo cadastrado.", "ERRO", JOptionPane.ERROR_MESSAGE);

    }

    public static void imprimeCarga(String placa) {

        boolean placaEncontrada = false;
        Carga c1 = new Carga();
        if (placa != null) {
            for (Carga carga : listaCarga) {
                if (carga.getPlaca().equals(placa)) {

                    JanelaConsultaCarga.getLabelDadoMarca().setText(carga.getMarca());
                    JanelaConsultaCarga.getLabelDadoModelo().setText(carga.getModelo());
                    JanelaConsultaCarga.getLabelDadoCor().setText(carga.getCor());
                    JanelaConsultaCarga.getLabelDadoVelocidade().setText(Float.toString(carga.getVelocMax()));
                    JanelaConsultaCarga.getLabelDadoQtdRodas().setText(Integer.toString(carga.getQtdRodas()));
                    JanelaConsultaCarga.getLabelDadoQtdPistoes().setText(Integer.toString(carga.getMotor().getQtdPist()));
                    JanelaConsultaCarga.getLabelDadoPotencia().setText(Integer.toString(carga.getMotor().getPotencia()));
                    JanelaConsultaCarga.getLabelDadoCargaMaxima().setText(Integer.toString(carga.getCargaMax()));
                    JanelaConsultaCarga.getLabelDadoTara().setText(Integer.toString(carga.getTara()));
                    JanelaConsultaCarga.getFieldPlaca().requestFocus();

                    c1 = carga;
                    placaEncontrada = true;
                    break;
                }
            }
            if (placaEncontrada == false) {
                JanelaConsultaCarga.getFieldPlaca().setText("");
                JanelaConsultaCarga.getLabelDadoMarca().setText("");
                JanelaConsultaCarga.getLabelDadoModelo().setText("");
                JanelaConsultaCarga.getLabelDadoCor().setText("");
                JanelaConsultaCarga.getLabelDadoVelocidade().setText("");
                JanelaConsultaCarga.getLabelDadoQtdRodas().setText("");
                JanelaConsultaCarga.getLabelDadoQtdPistoes().setText("");
                JanelaConsultaCarga.getLabelDadoPotencia().setText("");
                JanelaConsultaCarga.getLabelDadoCargaMaxima().setText("");
                JanelaConsultaCarga.getLabelDadoTara().setText("");
                JOptionPane.showMessageDialog(null, "Placa não encontrada", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Placa não encontrada", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static DefaultTableModel imprimirListaPasseio() {
        DefaultTableModel model = new DefaultTableModel();

        // Adicionar colunas ao modelo da tabela
        String[] titulosPasseio = {"Placa", "Marca", "Modelo", "Cor", "Vel. Máxima", "Qtd Rodas", "Qtd Passageiros"};
        model.setColumnIdentifiers(titulosPasseio);

        // Verificar se a lista de carga está vazia
        if (listaPasseio.isEmpty()) {
            // Tratar caso a lista esteja vazia
            listaVeiculosInexistente();
        } else {
            // Preencher o modelo com os dados da lista de carga
            for (Passeio passeio : listaPasseio) {
                String[] dadosPasseio = {passeio.getPlaca(), passeio.getMarca(), passeio.getModelo(),
                    passeio.getCor(), String.valueOf(passeio.getVelocMax()),
                    String.valueOf(passeio.getQtdRodas()),
                    String.valueOf(passeio.getQtdPassageiros())};
                model.addRow(dadosPasseio);
            }
        }
        return model;
    }

    public static DefaultTableModel imprimirListaCarga() {
        DefaultTableModel model = new DefaultTableModel();

        // Adicionar colunas ao modelo da tabela
        String[] titulosCarga = {"Placa", "Marca", "Modelo", "Cor", "Vel. Máxima", "Qtd Rodas", "Carga máxima", "Tara"};
        model.setColumnIdentifiers(titulosCarga);

        // Verificar se a lista de carga está vazia
        if (listaCarga.isEmpty()) {
            // Tratar caso a lista esteja vazia
            listaVeiculosInexistente();
        } else {
            // Preencher o modelo com os dados da lista de carga
            for (Carga carga : listaCarga) {
                String[] dadosCarga = {carga.getPlaca(), carga.getMarca(), carga.getModelo(),
                    carga.getCor(), String.valueOf(carga.getVelocMax()),
                    String.valueOf(carga.getQtdRodas()),
                    String.valueOf(carga.getCargaMax()),
                    String.valueOf(carga.getTara())};
                model.addRow(dadosCarga);
            }
        }
        return model;
    }

    public static void ExcluirListaPasseio() {
        int resposta = JOptionPane.showConfirmDialog(getJanelaConsultaPasseio(), "Confirma a exclusão de todos os veículos?", null, JOptionPane.YES_NO_OPTION);
        if (resposta == 0) {
            listaPasseio.clear();
            imprimeListaPasseio();
            JOptionPane.showMessageDialog(null, "Veículo excluidos com sucesso");
        } else {
        }
    }

    public static void ExcluirListaCarga() {
        int resposta = JOptionPane.showConfirmDialog(getJanelaConsultaCarga(), "Confirma a exclusão de todos os veículos?", null, JOptionPane.YES_NO_OPTION);
        if (resposta == 0) {
            listaCarga.clear();
            imprimeListaCarga();
            JOptionPane.showMessageDialog(null, "Veículo excluidos com sucesso");
        } else {
        }
    }

    public static Passeio consultaExcluirPasseio(String placa) {

        Passeio passeioReturn = null;

        if (placa != null) {
            for (Passeio passeio : listaPasseio) {
                if (passeio.getPlaca().equals(placa)) {
                    passeioReturn = passeio;
                    JanelaConsultaPasseio.getLabelDadoMarca().setText(passeio.getMarca());
                    JanelaConsultaPasseio.getLabelDadoModelo().setText(passeio.getModelo());
                    JanelaConsultaPasseio.getLabelDadoCor().setText(passeio.getCor());
                    JanelaConsultaPasseio.getLabelDadoVelocidade().setText(Float.toString(passeio.getVelocMax()));
                    JanelaConsultaPasseio.getLabelDadoQtdRodas().setText(Integer.toString(passeio.getQtdRodas()));
                    JanelaConsultaPasseio.getLabelDadoQtdPistoes().setText(Integer.toString(passeio.getMotor().getQtdPist()));
                    JanelaConsultaPasseio.getLabelDadoPotencia().setText(Integer.toString(passeio.getMotor().getPotencia()));
                    JanelaConsultaPasseio.getLabelDadoQtdPassageiros().setText(Integer.toString(passeio.getQtdPassageiros()));
                }
            }
        }
        return passeioReturn;
    }

    public static Carga consultaExcluirCarga(String placa) {

        Carga cargaReturn = null;

        if (placa != null) {
            for (Carga carga : listaCarga) {
                if (carga.getPlaca().equals(placa)) {
                    cargaReturn = carga;
                    JanelaConsultaCarga.getLabelDadoMarca().setText(carga.getMarca());
                    JanelaConsultaCarga.getLabelDadoModelo().setText(carga.getModelo());
                    JanelaConsultaCarga.getLabelDadoCor().setText(carga.getCor());
                    JanelaConsultaCarga.getLabelDadoVelocidade().setText(Float.toString(carga.getVelocMax()));
                    JanelaConsultaCarga.getLabelDadoQtdRodas().setText(Integer.toString(carga.getQtdRodas()));
                    JanelaConsultaCarga.getLabelDadoQtdPistoes().setText(Integer.toString(carga.getMotor().getQtdPist()));
                    JanelaConsultaCarga.getLabelDadoPotencia().setText(Integer.toString(carga.getMotor().getPotencia()));
                    JanelaConsultaCarga.getLabelDadoCargaMaxima().setText(Integer.toString(carga.getCargaMax()));
                    JanelaConsultaCarga.getLabelDadoTara().setText(Integer.toString(carga.getTara()));
                    JanelaConsultaCarga.getFieldPlaca().requestFocus();
                }
            }
        }
        return cargaReturn;
    }

    public static void excluirPasseio(Passeio passeio) {
        if (passeio != null) {
            int resposta = JOptionPane.showConfirmDialog(getJanelaConsultaPasseio(), "Confirma a exclusão do veículo?", null, JOptionPane.YES_NO_OPTION);
            if (resposta == 0) {

                listaPasseio.remove(passeio);
                JanelaConsultaPasseio.getFieldPlaca().setText("");
                JanelaConsultaPasseio.getLabelDadoMarca().setText("");
                JanelaConsultaPasseio.getLabelDadoModelo().setText("");
                JanelaConsultaPasseio.getLabelDadoCor().setText("");
                JanelaConsultaPasseio.getLabelDadoVelocidade().setText("");
                JanelaConsultaPasseio.getLabelDadoQtdRodas().setText("");
                JanelaConsultaPasseio.getLabelDadoQtdPistoes().setText("");
                JanelaConsultaPasseio.getLabelDadoPotencia().setText("");
                JanelaConsultaPasseio.getLabelDadoQtdPassageiros().setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Placa não encontrada", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void excluirCarga(Carga carga) {
        if (carga != null) {
            int resposta = JOptionPane.showConfirmDialog(getJanelaConsultaCarga(), "Confirma a exclusão do veículo?", null, JOptionPane.YES_NO_OPTION);
            if (resposta == 0) {

                listaCarga.remove(carga);
                JanelaConsultaCarga.getFieldPlaca().setText("");
                JanelaConsultaCarga.getLabelDadoMarca().setText("");
                JanelaConsultaCarga.getLabelDadoModelo().setText("");
                JanelaConsultaCarga.getLabelDadoCor().setText("");
                JanelaConsultaCarga.getLabelDadoVelocidade().setText("");
                JanelaConsultaCarga.getLabelDadoQtdRodas().setText("");
                JanelaConsultaCarga.getLabelDadoQtdPistoes().setText("");
                JanelaConsultaCarga.getLabelDadoPotencia().setText("");
                JanelaConsultaCarga.getLabelDadoCargaMaxima().setText("");
                JanelaConsultaCarga.getLabelDadoTara().setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Placa não encontrada", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static List<Passeio> getListaPasseio() {
        return listaPasseio;
    }

    public static List<Carga> getListaCarga() {
        return listaCarga;
    }

    public static void setListaPasseio(List<Passeio> listaPasseio) {
        BDVeiculos.listaPasseio = listaPasseio;
    }
}
