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
import model.Aluno;

public class AlunoFX {
    private TableView<Aluno> table;

    public void start (Stage stage) {
        // Formulario de Cadastro
        TextField nomefield = new TextField();
        nomefield.setPromptText("");
        nomefield.setPrefWidth(300);
        nomefield.setPrefHeight(40);
        TextField idadeField = new TextField();
        idadeField.setPromptText("");
        idadeField.setPrefWidth(300);
        idadeField.setPrefHeight(40);
        TextField cepField = new TextField();
        cepField.setPromptText("");
        cepField.setPrefWidth(300);
        cepField.setPrefHeight(40);
        TextField numeroField = new TextField();
        numeroField.setPromptText("");
        numeroField.setPrefWidth(300);
        numeroField.setPrefHeight(40);
        TextField complementoField = new TextField();
        complementoField.setPromptText("");
        complementoField.setPrefWidth(300);
        complementoField.setPrefHeight(40);

        TextField logradouroField = new TextField();
        logradouroField.setPromptText("");
        logradouroField.setPrefWidth(300);
        logradouroField.setPrefHeight(40);
        TextField bairroField = new TextField();
        bairroField.setPromptText("");
        bairroField.setPrefWidth(300);
        bairroField.setPrefHeight(40);
        TextField localidadeField = new TextField();
        localidadeField.setPromptText("");
        localidadeField.setPrefWidth(300);
        localidadeField.setPrefHeight(40);
        TextField ufField = new TextField();
        ufField.setPromptText("");
        ufField.setPrefWidth(300);
        ufField.setPrefHeight(40);

        
        Button btnCadastrar = new Button("cadastrar");
        Label lblMensage = new Label();

        GridPane form = new GridPane();
        form.setPadding(new Insets(10));
        form.setHgap(10);
        form.setVgap(10);

        form.add(new Label("Nome: "), 0, 0);
        form.add(nomefield, 1, 0);
        form.add(new Label("Idade: "), 0, 1);
        form.add(idadeField, 1, 1);
        form.add(new Label("Cep: "), 0, 2);
        form.add(cepField, 1, 2);
        form.add(new Label("Número: "), 0, 3);
        form.add(numeroField, 1, 3);
        form.add(new Label("Complemento do endereço: "), 0, 4);
        form.add(complementoField, 1, 4);

        form.add(new Label("Logradouro: "), 0, 7);
        form.add(logradouroField, 1, 7);
        form.add(new Label("Bairro: "), 0, 8);
        form.add(bairroField, 1, 8);
        form.add(new Label("Localidade: "), 0, 9);
        form.add(localidadeField, 1, 9);
        form.add(new Label("UF: "), 0, 10);
        form.add(ufField, 1, 10);

        form.add(btnCadastrar, 0, 13);
        form.add(lblMensage, 0, 13);

        table = new TableView<>();

        //Monta Cena e Janela
        Scene scene = new Scene(form, 400, 530);
        stage.setTitle("Cadastro de Aluno");
        stage.setScene(scene);

        //Opcional: modal bloqueando a janela main
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }
}
