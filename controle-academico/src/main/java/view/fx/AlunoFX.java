package view.fx;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Aluno;
import model.Endereco;
import service.EnderecoService;

public class AlunoFX {
    private TableView<Aluno> table;

    public void start(Stage stage) {
        // Formulario de Cadastro
        TextField nomefield = new TextField();
        nomefield.setPromptText("Nome: ");
        nomefield.setPrefWidth(300);
        nomefield.setPrefHeight(40);

        TextField idadeField = new TextField();
        idadeField.setPromptText("Idade: ");
        idadeField.setPrefWidth(300);
        idadeField.setPrefHeight(40);
        idadeField.setTextFormatter(new TextFormatter<>(change -> {
            String novoTexto = change.getControlNewText();
            if (!novoTexto.matches("\\d{0,3}?")) {
                return null;
            }
            //Permitir 3 digitos
            if (novoTexto.length() > 0 && novoTexto.length() < 3) {
                idadeField.setStyle("-fx-border-color:green");
            } else {
                idadeField.setStyle(null);
            }
            return change;
        }));

        TextField cepField = new TextField();
        cepField.setPromptText("CEP: ");
        cepField.setPrefWidth(300);
        cepField.setPrefHeight(40);
        cepField.setTextFormatter(new TextFormatter<>(change -> {
            String novoCep = change.getControlNewText();
            if (novoCep.matches("\\d{0,5}(-?\\d{0,3})?")){
                return change;
            }
            return null;
        }));

        TextField numeroField = new TextField();
        numeroField.setPromptText("Número: ");
        numeroField.setPrefWidth(300);
        numeroField.setPrefHeight(40);

        TextField complementoField = new TextField();
        complementoField.setPromptText("Complemento: ");
        complementoField.setPrefWidth(300);
        complementoField.setPrefHeight(40);

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

        Button btnBuscarCep = new Button("Buscar o CEP");
        Label lblMensage = new Label();
        btnBuscarCep.setOnAction(e -> {
            Endereco endereco = new Endereco();
            endereco.setCep(cepField.getText());

            try {
                EnderecoService.completarEnderecoViaCep(endereco);
                logradouroField.setText(endereco.getLogradouro());
                bairroField.setText(endereco.getBairro());
                cidadeField.setText(endereco.getLocalidade());
                ufField.setText(endereco.getUf());
            } catch (Exception ex) {
                lblMensage.setText(
                    "Erro ao buscar o CEP" +
                    ex.getMessage()
                );
                lblMensage.setStyle("-fx-text-fill:red");
            }

        });

        Button btnCadastrar = new Button("cadastrar");
        btnCadastrar.setOnAction(e -> {
            String nome = nomefield.getText();
            String idade = idadeField.getText();
            String cep = cepField.getText();
            String num = numeroField.getText();

            if (
                nome.isEmpty() ||
                idade.isEmpty() ||
                cep.isEmpty() ||
                num.isEmpty()
            ) {
                // WARNING = Aviso
                // ERROR = Erro
                // CONFIRMATION = Sucesso
                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setTitle("Campos Obrigatórios");
                alerta.setHeaderText(null);
                alerta.setContentText("Preencha todos os campos.");
                alerta.showAndWait();

            } else {
                Aluno aluno = new Aluno();
                aluno.setName(nome);
                aluno.setAge(Integer.parseInt(idade));

                Endereco enderecoAluno = new Endereco();
                enderecoAluno.setCep(cep);
                enderecoAluno.setLogradouro(logradouroField.getText());
                enderecoAluno.setBairro(bairroField.getText());
                enderecoAluno.setLocalidade(cidadeField.getText());
                enderecoAluno.setUf(ufField.getText());
                enderecoAluno.setNumero(num);
                enderecoAluno.setComplemento(complementoField.getText());

                aluno.setAddress(enderecoAluno);

                try {
                    repository.AlunoRepository.salvar(aluno);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                lblMensage.setText("Sucesso");
                lblMensage.setStyle("-fx-text-fill:green");

                nomefield.setText(null);
                idadeField.setText(null);
                cepField.setText(null);
                numeroField.setText(null);
                complementoField.setText(null);
                logradouroField.setText(null);
                bairroField.setText(null);
                cidadeField.setText(null);
                ufField.setText(null);

            }
        });

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
        form.add(btnBuscarCep, 2, 2);
        form.add(new Label("Número: "), 0, 3);
        form.add(numeroField, 1, 3);
        form.add(new Label("Complemento do endereço: "), 0, 4);
        form.add(complementoField, 1, 4);

        form.add(new Label("Logradouro: "), 0, 7);
        form.add(logradouroField, 1, 7);
        form.add(new Label("Bairro: "), 0, 8);
        form.add(bairroField, 1, 8);
        form.add(new Label("Localidade: "), 0, 9);
        form.add(cidadeField, 1, 9);
        form.add(new Label("UF: "), 0, 10);
        form.add(ufField, 1, 10);

        form.add(btnCadastrar, 0, 13);
        form.add(lblMensage, 0, 14);

        table = new TableView<>();

        // Monta Cena e Janela
        Scene scene = new Scene(form, 635, 530);
        stage.setTitle("Cadastro de Aluno");
        stage.setScene(scene);

        // Opcional: modal bloqueando a janela main
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }
}
