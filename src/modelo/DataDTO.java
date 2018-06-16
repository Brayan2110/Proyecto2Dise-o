//editado por Bryan
package modelo;

import java.util.HashMap;


public class DataDTO {
    private int cantidadDePisos;
    private HashMap<String,Float> probSolicitarElevadorEnUnPiso = new HashMap<>();
    private HashMap<String,Float> probEscogerPisoComoDestino = new HashMap<>();
    private int cantidadDeElevadores;
    private HashMap<String,Float> probBotonDetenerse = new HashMap<>();
    private float probBotonEmergencia;
    private int tiempoEntrepiso;
    private int tiempoPuertaAbierta;
    private int tiempoPuertaAbiertaBotonDetenerse;
    private int cantidadPersonas;

    public DataDTO() {
    }

    public int getCantidadDePisos() {
        return cantidadDePisos;
    }

    public void setCantidadDePisos(int cantidadDePisos) {
        this.cantidadDePisos = cantidadDePisos;
    }

    public HashMap<String, Float> getProbSolicitarElevadorEnUnPiso() {
        return probSolicitarElevadorEnUnPiso;
    }

    public void setProbSolicitarElevadorEnUnPiso(HashMap<String, Float> probSolicitarElevadorEnUnPiso) {
        this.probSolicitarElevadorEnUnPiso = probSolicitarElevadorEnUnPiso;
    }

    public HashMap<String, Float> getProbEscogerPisoComoDestino() {
        return probEscogerPisoComoDestino;
    }

    public void setProbEscogerPisoComoDestino(HashMap<String, Float> probEscogerPisoComoDestino) {
        this.probEscogerPisoComoDestino = probEscogerPisoComoDestino;
    }

    public int getCantidadDeElevadores() {
        return cantidadDeElevadores;
    }

    public void setCantidadDeElevadores(int cantidadDeElevadores) {
        this.cantidadDeElevadores = cantidadDeElevadores;
    }

    public HashMap<String, Float> getProbBotonDetenerse() {
        return probBotonDetenerse;
    }

    public void setProbBotonDetenerse(HashMap<String, Float> probBotonDetenerse) {
        this.probBotonDetenerse = probBotonDetenerse;
    }

    public float getProbBotonEmergencia() {
        return probBotonEmergencia;
    }

    public void setProbBotonEmergencia(float probBotonEmergencia) {
        this.probBotonEmergencia = probBotonEmergencia;
    }

    public int getTiempoEntrepiso() {
        return tiempoEntrepiso;
    }

    public void setTiempoEntrepiso(int tiempoEntrepiso) {
        this.tiempoEntrepiso = tiempoEntrepiso;
    }

    public int getTiempoPuertaAbierta() {
        return tiempoPuertaAbierta;
    }

    public void setTiempoPuertaAbierta(int tiempoPuertaAbierta) {
        this.tiempoPuertaAbierta = tiempoPuertaAbierta;
    }

    public int getTiempoPuertaAbiertaBotonDetenerse() {
        return tiempoPuertaAbiertaBotonDetenerse;
    }

    public void setTiempoPuertaAbiertaBotonDetenerse(int tiempoPuertaAbiertaBotonDetenerse) {
        this.tiempoPuertaAbiertaBotonDetenerse = tiempoPuertaAbiertaBotonDetenerse;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }
}
