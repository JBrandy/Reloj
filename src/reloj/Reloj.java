package reloj;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class Reloj extends Label {

    private int segundos;
    private int minutos;
    private int horas;
    private int horas12;
    private Calendar calendar;

    public Reloj() {
        super ();
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public void start(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        calcularHora();
                        //if(minutos%2 ==0) poner si el usuario escoge 24 o 12
                        setText(horas12+" : "+minutos+" : "+segundos);
                    }
                });
            }
        },1000,1000);

    }

    public void calcularHora(){
        calendar = new GregorianCalendar();
        horas12 = calendar.get(calendar.HOUR);
        horas = calendar.get(Calendar.HOUR_OF_DAY);
        minutos = calendar.get(Calendar.MINUTE);
        segundos = calendar.get(Calendar.SECOND);


    }

}
