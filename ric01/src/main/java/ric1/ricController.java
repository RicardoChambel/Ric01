package ric1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ricController {

    @FXML
    private TextField nomeField;

    @FXML
    private TextField idadeField;

    @FXML
    private TextField cidadeField;

    @FXML
    private ComboBox<String> cargoBox;

    @FXML
    private TableView<Funcionario> tabelaFuncionarios;

    @FXML
    private TableColumn<Funcionario, String> sexoCol;

    @FXML
    private TableColumn<Funcionario, String> nomeCol;

    @FXML
    private TableColumn<Funcionario, Integer> idadeCol;

    @FXML
    private TableColumn<Funcionario, String> cidadeCol;

    @FXML
    private TableColumn<Funcionario, String> cargoCol;

    @FXML
    private RadioButton radioButtonM;

    @FXML
    private RadioButton radioButtonF;

    @FXML
    private RadioButton radioButtonOutros;

    private ToggleGroup group;

    private ObservableList<Funcionario> funcionarios;

    @FXML
    private void initialize() {
        // Inicializar a combobox de cargos e tabela de funcionários
        cargoBox.getItems().addAll("Administrador", "Técnico", "Atendimento");

        // Configurar colunas da tabela
        sexoCol.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        nomeCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
        idadeCol.setCellValueFactory(new PropertyValueFactory<>("idade"));
        cidadeCol.setCellValueFactory(new PropertyValueFactory<>("cidade"));
        cargoCol.setCellValueFactory(new PropertyValueFactory<>("cargo"));

        // Inicializar a lista de funcionários e carregar dados
        funcionarios = FXCollections.observableArrayList();
        tabelaFuncionarios.setItems(funcionarios);

        loadFuncionarios();

        // Inicializar ToggleGroup
        group = new ToggleGroup();
        radioButtonM.setToggleGroup(group);
        radioButtonF.setToggleGroup(group);
        radioButtonOutros.setToggleGroup(group);
    }

    @FXML
    private void adicionarFuncionario() {
        String sexo = getSelectedSexo();
        String nome = nomeField.getText();
        String idade = idadeField.getText();
        String cidade = cidadeField.getText();
        String cargo = cargoBox.getValue();

        Database.addFuncionario(sexo, nome, idade, cidade, cargo);
        loadFuncionarios();
    }

    private String getSelectedSexo() {
        RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
        return selectedRadioButton != null ? selectedRadioButton.getText() : "";
    }

    private void loadFuncionarios() {
        funcionarios.clear();
        funcionarios.addAll(Database.getFuncionarios());
    }
}
