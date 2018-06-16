package modelo;

import java.util.Hashtable;

public class BotonDePiso {
    private boolean estadoLuz;
    private TipoBotonPiso tipoBoton;
    private int piso;

    // falta el calendarizador

    //Método que solicita al Calendarizador la solicitud.
    public void enviarSolicitudDePedirElevador(){

    }

    public boolean isEstadoLuz() {
        return estadoLuz;
    }

    public void setEstadoLuz(boolean estadoLuz) {
        this.estadoLuz = estadoLuz;
    }

    public TipoBotonPiso getTipoBoton() {
        return tipoBoton;
    }

    public void setTipoBoton(TipoBotonPiso tipoBoton) {
        this.tipoBoton = tipoBoton;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }
}
