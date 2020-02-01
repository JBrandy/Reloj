package prueba;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import reloj.Evento;
import reloj.Logica;
import reloj.Reloj;
import reloj.Tarea;

import java.time.LocalDate;

public class prueba extends Application {


    @Override
    public void start(Stage stage) throws Exception {

        VBox vBox = new VBox();
        Reloj reloj = new Reloj();
        LocalDate fecha = LocalDate.now();
        Tarea a = new Tarea("prueba",fecha, 13,25, null );
        Logica.getInstance().anadirTarea(a);
        reloj.setFormato24Horas(false);
        reloj.start();
        reloj.addEvento(new Evento() {
            @Override
            public void inicioTarea(Tarea tarea) {

                System.out.println("hola");
            }

        });
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