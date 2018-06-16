//agregado por Bryan
package modelo;

import java.util.ArrayList;
import java.util.Collections;

public class Controlador {
    ArrayList<Elevador> elevadores = new ArrayList<>();
    ICalendarizador calendarizador = Calendarizador.getInstance();
    public Controlador() {

    }

    public void atenderSolicitudBotonPiso(int piso, Direccion dirección){
        //Obtener el mejor elevador
        Elevador mejorElevador = calendarizador.obtenerElevadorÓptimo(piso,dirección,elevadores);
        if(mejorElevador != null && mejorElevador.getSolicitud().size() < Elevador.maximo){
            calendarizador.despacharElevador(mejorElevador,piso, dirección);
        }
    }

    public void atenderSolicitudBotonElevador(int piso, int elevador){

    }

    public void atenderSolicitudBotonEmergencia(int piso, int elevador){

    }

    public void atenderSolicitudBotonDetener(int piso, int elevador){

    }

    public void crearElevador(int numElevador){
        Elevador elevador = new Elevador(Direccion.Ninguno,Direccion.Ninguno,1,0.0f,0,0,numElevador,0, "Normal");
        elevadores.add(elevador);
    }

    public ArrayList<Elevador> getElevadores() {
        return elevadores;
    }

    public void setElevadores(ArrayList<Elevador> elevadores) {
        this.elevadores = elevadores;
    }

    public ICalendarizador getCalendarizador() {
        return calendarizador;
    }

    public void setCalendarizador(ICalendarizador calendarizador) {
        this.calendarizador = calendarizador;
    }
    
}
