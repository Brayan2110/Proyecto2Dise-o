//editado por Bryan
package modelo;

import java.util.ArrayList;
import java.util.Collections;

public class Elevador {
    private Direccion direccionActual;
    private Direccion direccionPrevista;
    private int Piso;
    private float SensorPeso;
    private int SensorPiso;
    private ArrayList<Integer> Solicitud = new ArrayList();
    private ArrayList<Direccion> Solicitud2 = new ArrayList();
    private int PesoPermitido;
    private int NumeroElevador;
    private int CantPersonas;
    static int maximo;
    private String estado;

    public Elevador() {
    }

    public Elevador(Direccion direccionActual, Direccion direccionPrevista, int Piso, float SensorPeso, int SensorPiso, int PesoPermitido, int NumeroElevador, int CantPersonas, String estado) {
        this.direccionActual = direccionActual;
        this.direccionPrevista = direccionPrevista;
        this.Piso = Piso;
        this.SensorPeso = SensorPeso;
        this.SensorPiso = SensorPiso;
        this.PesoPermitido = PesoPermitido;
        this.NumeroElevador = NumeroElevador;
        this.CantPersonas = CantPersonas;
        this.estado = estado;
    }

    public Direccion getDireccionActual() {
        return direccionActual;
    }

    public void setDireccionActual(Direccion direccionActual) {
        this.direccionActual = direccionActual;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    

    public Direccion getDireccionPrevista() {
        return direccionPrevista;
    }

    public ArrayList<Direccion> getSolicitud2() {
        return Solicitud2;
    }

    public void setSolicitud2(ArrayList<Direccion> Solicitud2) {
        this.Solicitud2 = Solicitud2;
    }

    public void setDireccionPrevista(Direccion direccionPrevista) {
        this.direccionPrevista = direccionPrevista;
    }

    public int getPiso() {
        return Piso;
    }

    public void setPiso(int Piso) {
        this.Piso = Piso;
    }

    public float getSensorPeso() {
        return SensorPeso;
    }

    public void setSensorPeso(float SensorPeso) {
        this.SensorPeso = SensorPeso;
    }

    public int getSensorPiso() {
        return SensorPiso;
    }

    public void setSensorPiso(int SensorPiso) {
        this.SensorPiso = SensorPiso;
    }

    public ArrayList<Integer> getSolicitud() {
        return Solicitud;
    }

    public void setSolicitud(ArrayList<Integer> Solicitud) {
        this.Solicitud = Solicitud;
    }

    public int getPesoPermitido() {
        return PesoPermitido;
    }

    public void setPesoPermitido(int PesoPermitido) {
        this.PesoPermitido = PesoPermitido;
    }

    public int getNumeroElevador() {
        return NumeroElevador;
    }

    public void setNumeroElevador(int NumeroElevador) {
        this.NumeroElevador = NumeroElevador;
    }

    public static int getMaximo() {
        return maximo;
    }

    public static void setMaximo(int maximo) {
        Elevador.maximo = maximo;
    }

    public boolean puedoRecoger(){
        if(this.getCantPersonas() < maximo){
            return true;
        }
        else{
            return false;
        }

    }
    public void moverMotor(){
        try{
            SimuladorSingleton s = SimuladorSingleton.getInstance();
        int pisoSolicitud;
        for(int i=0; i<this.getSolicitud().size();i++){
            if(this.getPiso()==this.getSolicitud().get(i) && this.getSolicitud2().get(i).equals(Direccion.Subir)){
                do{
                    pisoSolicitud = Integer.valueOf(s.SolicitarDestino());
                }while(pisoSolicitud == this.getPiso());
                this.atenderSolicitudes();
                this.getSolicitud().set(i, pisoSolicitud);
                this.getSolicitud2().set(i, Direccion.Bajar);
                this.setCantPersonas(this.getCantPersonas()+1);
                s.getPersonas()[this.getPiso()-1]--;
                try {
                    this.setEstado("Puerta Abierta");
                    Thread.sleep(s.getDatosSimulacion().getTiempoPuertaAbierta()*1000);
                } catch (InterruptedException e) {
                }
                if(s.pulsarbotondetenerse(s.getDatosSimulacion().getProbBotonDetenerse().get(String.valueOf(this.getNumeroElevador())))){
                    try {
                        this.setEstado("Detenido");
                        Thread.sleep(s.getDatosSimulacion().getTiempoPuertaAbiertaBotonDetenerse()*1000);
                    }catch (InterruptedException e) {
                    }
                }
                else{
                    if(s.pulsarbotonemergencia(s.getDatosSimulacion().getProbBotonEmergencia())){
                        try {
                            this.setEstado("Emergencia");
                            Thread.sleep(s.getDatosSimulacion().getTiempoPuertaAbiertaBotonDetenerse()*1000);
                        }catch (InterruptedException e) {
                        }
                    }
                }
                this.setEstado("Normal");
            }
        }
        for(int i=0; i<this.getSolicitud().size();i++){
            if(this.getPiso()==this.getSolicitud().get(i) && this.getSolicitud2().get(i).equals(Direccion.Bajar)){
                this.getSolicitud().remove(i);
                this.getSolicitud2().remove(i);
                this.setCantPersonas(this.getCantPersonas()-1);
                try {
                    this.setEstado("Puerta Abierta");
                    Thread.sleep(s.getDatosSimulacion().getTiempoPuertaAbierta()*1000);
                } catch (InterruptedException e) {
                }
                if(s.pulsarbotondetenerse(s.getDatosSimulacion().getProbBotonDetenerse().get(String.valueOf(this.getNumeroElevador())))){
                    try {
                        this.setEstado("Detenido");
                        Thread.sleep(s.getDatosSimulacion().getTiempoPuertaAbiertaBotonDetenerse()*1000);
                    }catch (InterruptedException e) {
                    }
                }
                else{
                    if(s.pulsarbotonemergencia(s.getDatosSimulacion().getProbBotonEmergencia())){
                        try {
                            this.setEstado("Emergencia");
                            Thread.sleep(s.getDatosSimulacion().getTiempoPuertaAbiertaBotonDetenerse()*1000);
                        }catch (InterruptedException e) {
                        }
                    }
                }
                this.setEstado("Normal");
            }
        }
        if(!this.getSolicitud().isEmpty()){
            if(this.getPiso()<this.getSolicitud().get(0)){
                this.setDireccionActual(Direccion.Subir);
                this.setDireccionPrevista(Direccion.Subir);
            }
            else{
                this.setDireccionActual(Direccion.Bajar);
                this.setDireccionPrevista(Direccion.Bajar);
            }
        }
        else{
            this.setDireccionActual(Direccion.Ninguno);
            this.setDireccionPrevista(Direccion.Ninguno);
        }
        try {
            Thread.sleep(s.getDatosSimulacion().getTiempoEntrepiso()*1000);
        } catch (InterruptedException e) {
        }
        if(!this.getSolicitud().isEmpty()){
            if(this.getPiso()<this.getSolicitud().get(0)){
                this.setPiso(this.getPiso()+1);
            }
            else{
                this.setPiso(this.getPiso()-1);
            }
            if(this.getPiso()==this.getSolicitud().get(0)){
                this.setDireccionPrevista(Direccion.Ninguno);
            }
        }
        else{
            this.setDireccionActual(Direccion.Ninguno);
            this.setDireccionPrevista(Direccion.Ninguno);
        }
        this.setDireccionActual(Direccion.Ninguno);
        }
        catch(Exception e){
            System.out.println("XD");
        }
    }
    public void activarEmergencia(){

    }
    public void agregardestino(int piso){
        this.getSolicitud().add(piso);
    }

    public int getCantPersonas() {
        return CantPersonas;
    }

    public void setCantPersonas(int CantPersonas) {
        this.CantPersonas = CantPersonas;
    }

    public void atenderSolicitudes(){

    }

    public boolean verificarPeso(){

        return true;
    }
}
