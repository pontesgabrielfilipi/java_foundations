package view.fx;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Aluno;

public class AlunoView {
    private TableView<Aluno> table;

    public void start (Stage stage) {
        // Formulario de Cadastro
        TextField nomefield = new TextField();
        TextField idadeField = new TextField();
        TextField cepField = new TextField();
        TextField numeroField = new TextField();
        TextField complementoField = new TextField();
        
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
        form.add(btnCadastrar, 0, 5);
        form.add(lblMensage, 0, 6);

        table = new TableView<>();
    }
}
