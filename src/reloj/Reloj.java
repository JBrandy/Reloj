package reloj;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.time.LocalDateTime;
import java.util.*;

public class Reloj extends Label {

    private int segundos;
    private int minutos;


    private int horas;
    private int horas12;
    private Calendar calendar;
    private LocalDateTime fecha = LocalDateTime.now();
    private Boolean formato24Horas;
    private int fechaNumero;
    private Evento evento;
    Tarea tarea;
    private  Timer timer;

    public Boolean getFormato24Horas() {
        return formato24Horas;
    }

    public Reloj() {
        super();
    }


    public void setFormato24Horas(Boolean formato24Horas) {
        this.formato24Horas = formato24Horas;
    }

    public void start() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        calcularHora();
                        formatoHora();
                        if (LogicaReloj.getInstance().getListaTareas() != null) {
                            comprobarTarea();

                        }

                    }
                });
            }
        }, 1000, 1000);

    }

    private void comprobarTarea() {
        for (Tarea t : LogicaReloj.getInstance().getListaTareas()) {
            //if (formato24Horas == false) {
                if (horas == t.getHora() && minutos == t.getMinuto() && fechaNumero == t.getFecha().getDayOfYear() && segundos == t.getSegundo()) {
                    evento.inicioTarea(t);
                }
           /*} else {
                int aux = 0;
                for (int i = 12; i < 24; i++) {
                    if(t.getHora()==i){
                        t.setHora(aux);
                    }
                    aux++;
                }
                if (horas12 == t.getHora() && minutos == t.getMinuto() && fechaNumero == t.getFecha().getDayOfYear() && segundos == t.getSegundo()) {
                    evento.inicioTarea(t);
                }

            }*/
        }
    }

    private void formatoHora() {
        if (formato24Horas != false)
            setText(horas12 + " : " + minutos + " : " + segundos);
        else
            setText(horas + " : " + minutos + " : " + segundos);
    }

    private void calcularHora() {
        calendar = new GregorianCalendar();
        horas12 = calendar.get(calendar.HOUR);
        horas = calendar.get(Calendar.HOUR_OF_DAY);
        segundos = calendar.get(Calendar.SECOND);
        minutos = calendar.get(Calendar.MINUTE);
        fechaNumero = fecha.getDayOfYear();


    }

    public void stopReloj(){
        timer.cancel();
        timer.purge();
    }





    public void addEvento(Evento evento) {
        this.evento = evento;
    }

}



