//agregado por Bryan
package modelo;

import java.util.ArrayList;

public interface ICalendarizador {
    void despacharElevador(Elevador elevador, int piso, Direccion direccion);
    Elevador obtenerElevadorÓptimo(int piso,Direccion dirección,ArrayList<Elevador> elevadores);
}
