package view.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainFX extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        // Menu principal
        MenuBar menuBar = new MenuBar();
        Menu menuCadastro = new Menu("cadastros");
        MenuItem munuAluno = new MenuItem("alunos");
        
        menuCadastro.getItems().add(munuAluno);
        menuBar.getMenus().add(menuCadastro);
        
        // Layout Principal
        Label label = new Label("©Gabriel Pontes - Senai Luiz Massa - 2025");
        BorderPane painel = new BorderPane();
        painel.setTop(menuBar);
        painel.setBottom(label);

        Scene tela = new Scene(painel, 800, 600);
        stage.setTitle("Menu Acadêmico 1.0");
        stage.setScene(tela);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
