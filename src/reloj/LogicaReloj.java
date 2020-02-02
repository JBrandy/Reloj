package reloj;

import java.util.ArrayList;
import java.util.List;

public class LogicaReloj {

    private static LogicaReloj INSTANCE = null;
    private List<Tarea> listaTareas = new ArrayList<>();

    public LogicaReloj() {

    }

    public static LogicaReloj getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LogicaReloj();
        }
        return INSTANCE;
    }

    public List<Tarea> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(List<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

    public void anadirTarea(Tarea tarea){
        listaTareas.add(tarea);
    }

    public void borrarTarea(Tarea tarea){
        listaTareas.remove(tarea);
    }
}
