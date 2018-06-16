package modelo;

public class BotonDeLlamada {
    Calendarizador calendarizador = Calendarizador.getInstance();
    boolean estadoLuz;
    TipoBotonLlamada tipo;

    public BotonDeLlamada(boolean estadoLuz, TipoBotonLlamada tipo) {
        this.estadoLuz = estadoLuz;
        this.tipo = tipo;
    }

    public void enviarSolicitudDePiso()
    {
        //Calendarizador.atenderSolicitudBotonPiso
    }
}

