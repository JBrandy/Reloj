package prueba;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import reloj.Reloj;

public class prueba extends Application {


    @Override
    public void start(Stage stage) throws Exception {

        VBox vBox = new VBox();
        Reloj reloj = new Reloj();
        reloj.formatoHora(false);
        reloj.start();
        reloj.setFont(new Font(42));

        vBox.getChildren().add(reloj);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String [] args){
        launch(args);
    }
}