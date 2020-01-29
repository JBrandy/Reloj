package reloj;

import java.util.List;

public class Logica {

    private static Logica INSTANCE = null;
    private List<Tarea> listaTareas;

    public Logica() {

    }

    public static Logica getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Logica();
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
