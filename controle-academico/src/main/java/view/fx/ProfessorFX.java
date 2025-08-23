package view.fx;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Professor;

public class ProfessorFX {
    private TableView<Professor> table;

    public void start (Stage stage) {
        TextField nomefield = new TextField();
        nomefield.setPromptText("Nome");
        nomefield.setPrefWidth(300);
        nomefield.setPrefHeight(40);
        TextField idadeField = new TextField();
        idadeField.setPromptText("Idade");
        idadeField.setPrefWidth(300);
        idadeField.setPrefHeight(40);
        TextField cpfField = new TextField();
        cpfField.setPromptText("CPF");
        cpfField.setPrefWidth(300);
        cpfField.setPrefHeight(40);
        TextField cepField = new TextField();
        cepField.setPromptText("Cep");
        cepField.setPrefWidth(300);
        cepField.setPrefHeight(40);
        TextField numeroField = new TextField();
        numeroField.setPromptText("Número");
        numeroField.setPrefWidth(300);
        numeroField.setPrefHeight(40);
        TextField complementoField = new TextField();
        complementoField.setPromptText("Complemento do endereço");
        complementoField.setPrefWidth(300);
        complementoField.setPrefHeight(40);
        TextField atuacaoField = new TextField();
        atuacaoField.setPromptText("Atuação do Professor");
        atuacaoField.setPrefWidth(300);
        atuacaoField.setPrefHeight(40);

        // Autocomplemento
        
        TextField logradouroField = new TextField();
        logradouroField.setPromptText("Logradouro: ");
        logradouroField.setPrefWidth(300);
        logradouroField.setPrefHeight(40);

        TextField bairroField = new TextField();
        bairroField.setPromptText("Bairro: ");
        bairroField.setPrefWidth(300);
        bairroField.setPrefHeight(40);

        TextField cidadeField = new TextField();
        cidadeField.setPromptText("Localidade: ");
        cidadeField.setPrefWidth(300);
        cidadeField.setPrefHeight(40);

        TextField ufField = new TextField(); // unidade federativa = estado
        ufField.setPromptText("UF: ");
        ufField.setPrefWidth(300);
        ufField.setPrefHeight(40);


        Label lblMensage = new Label();
        Button btnCadastrar = new Button("Cadastrar");

        GridPane form = new GridPane();
        form.setPadding(new Insets(10));
        form.setHgap(10);
        form.setVgap(10);

        form.add(new Label("Nome: "), 0, 0);
        form.add(nomefield, 1, 0);
        form.add(new Label("Idade"), 0, 1);
        form.add(idadeField, 1, 1);
        form.add(new Label("CPF: "), 0, 2);
        form.add(cpfField, 1, 2);
        form.add(new Label("Cep: "), 0, 3);
        form.add(cepField, 1, 3);
        form.add(new Label("Número: "), 0, 4);
        form.add(numeroField, 1, 4);
        form.add(new Label("complemento do endereço: "), 0, 5);
        form.add(complementoField, 1, 5);
        form.add(new Label("Atuação do Professor: "), 0, 6);
        form.add(atuacaoField, 1, 6);

        form.add(new Label("Logradouro: "), 0, 9);
        form.add(logradouroField, 1, 9);
        form.add(new Label("Bairro: "), 0, 10);
        form.add(bairroField, 1, 10);
        form.add(new Label("Localidade: "), 0, 11);
        form.add(cidadeField, 1, 11);
        form.add(new Label("UF: "), 0, 12);
        form.add(ufField, 1, 12);

        form.add(btnCadastrar, 0, 15);
        form.add(lblMensage, 0, 15);

        table = new TableView<>();

        //Monta Cena e Janela
        Scene scene = new Scene(form, 400, 550);
        stage.setTitle("Cadastro de Professor");
        stage.setScene(scene);

        //Opcional: modal bloqueando a janela main
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }
}
