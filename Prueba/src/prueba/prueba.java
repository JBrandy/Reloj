package prueba;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class prueba extends Application {


    @Override
    public void start(Stage stage) throws Exception {

        VBox vBox = new VBox();
        Reloj reloj = new Reloj();

        reloj.start();
        reloj.setFont(new Font(42));

        vBox.getChildren().add(reloj);
        vBox.getChildren().add(new Label("Hola"));
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String [] args){
        launch(args);
    }
}