//agregado por Bryan
package modelo;

import java.util.ArrayList;

public class DatosSimulador {
    private int personasAfuera;
    private int personasQuesalen;
    private ArrayList<ArrayList<Integer>> pisoDestino;

    public DatosSimulador() {
    }

    public DatosSimulador(int personasAfuera, int personasQuesalen, ArrayList<ArrayList<Integer>> pisoDestino) {
        this.personasAfuera = personasAfuera;
        this.personasQuesalen = personasQuesalen;
        this.pisoDestino = pisoDestino;
    }

    public int getPersonasAfuera() {
        return personasAfuera;
    }

    public void setPersonasAfuera(int personasAfuera) {
        this.personasAfuera = personasAfuera;
    }

    public int getPersonasQuesalen() {
        return personasQuesalen;
    }

    public void setPersonasQuesalen(int personasQuesalen) {
        this.personasQuesalen = personasQuesalen;
    }

    public ArrayList<ArrayList<Integer>> getPisoDestino() {
        return pisoDestino;
    }

    public void setPisoDestino(ArrayList<ArrayList<Integer>> pisoDestino) {
        this.pisoDestino = pisoDestino;
    }
}
