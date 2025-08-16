package view.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainFX extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        // Menu principal
        MenuBar menuBar = new MenuBar();
        Menu menuCadastro = new Menu("Cadastros");
        MenuItem menuAluno = new MenuItem("Alunos");
        MenuItem menuProfesor = new MenuItem("Professores");
        MenuItem menuDiscplina = new MenuItem("Disciplinas");

        // menu
        
        menuCadastro.getItems().add(menuAluno);
        menuCadastro.getItems().add(menuProfesor);
        menuCadastro.getItems().add(menuDiscplina);
        menuBar.getMenus().add(menuCadastro);
        
        Label labelRodape = new Label("©Gabriel Pontes - Senai Luiz Massa - 2025");
        labelRodape.setStyle("-fx-padding: 10; -fx-alignment: center;");

        // Layout Principal
        BorderPane painel = new BorderPane();
        painel.setTop(menuBar);
        painel.setBottom(labelRodape);

        Scene tela = new Scene(painel, 1024, 768);
        BackgroundImage  bg = new BackgroundImage(
            new Image(
                getClass()
                    .getResource("/images/fundo.jpeg")
                    .toExternalForm()
            ),
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            new BackgroundSize(
                1024,
                768,
                true,
                true,
                true,
                false
            )
        );
        
        painel.setBackground(new Background(bg));

        stage.setTitle("Menu Acadêmico 1.0");
        stage.setScene(tela);
        stage.setMaximized(false);
        stage.show();

        //Abre o 
        menuAluno.setOnAction( _ -> {
            new AlunoFX().start(new Stage());
        });

        menuProfesor.setOnAction(_ -> {
            new ProfessorFX().start(new Stage());
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
