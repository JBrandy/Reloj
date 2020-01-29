package reloj;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.time.LocalDate;
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
    private LocalDate fecha;
    private Boolean formato24Horas;
    private int fechaNumero;
    private Evento evento;

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

    public Boolean getFormato24Horas() {
        return formato24Horas;
    }

    public void setFormato24Horas(Boolean formato24Horas) {
        this.formato24Horas = formato24Horas;
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
                        formatoHora();
                        comprobarTarea();
                    }
                });
            }
        },1000,1000);

    }

    private void comprobarTarea(Tarea tareaUsuario) {
        for (tareaUsuario : Logica.getInstance().getListaTareas()) {
          if(horas == tareaUsuario.getHora() && minutos ==tareaUsuario.getMinuto() && fechaNumero==tareaUsuario.getFecha().getDayOfYear()){
            evento.inicioTarea();
          }else
              System.out.println("error");
        }
    }

    private void formatoHora() {
        if(formato24Horas !=false)
            setText(horas12+" : "+minutos+" : "+segundos);
        else
            setText(horas+" : "+minutos+" : "+segundos);
    }

    private void calcularHora(){
        calendar = new GregorianCalendar();
        horas12 = calendar.get(calendar.HOUR);
        horas = calendar.get(Calendar.HOUR_OF_DAY);
        segundos = calendar.get(Calendar.SECOND);
        minutos = calendar.get(Calendar.MINUTE);
        fechaNumero = fecha.getDayOfYear();


    }

    public void addEvento (Evento evento){
        this.evento = evento;
    }

}



