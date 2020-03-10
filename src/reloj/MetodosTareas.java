package reloj;

import java.util.ArrayList;
import java.util.List;

public class MetodosTareas {

    private static MetodosTareas INSTANCE = null;
    private List<Tarea> listaTareas = new ArrayList<>();

    public MetodosTareas() {

    }

    public static MetodosTareas getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MetodosTareas();
        }
        return INSTANCE;
    }
    public void cargarTareas(List<Tarea> listaTareasCliente){
        listaTareas=listaTareasCliente;

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
