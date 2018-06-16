package modelo;

import java.util.ArrayList;
import java.util.Collections;

public class Calendarizador implements ICalendarizador {
    private static Calendarizador ourInstance = new Calendarizador();
    public static Calendarizador getInstance() {
        return ourInstance;
    }

    private Calendarizador() {
    }

    @Override
    public void despacharElevador(Elevador elevador, int piso, Direccion direccion) {
        SimuladorSingleton s = SimuladorSingleton.getInstance();
        s.getPersonas()[piso-1]++;
        elevador.getSolicitud().add(piso);
        elevador.getSolicitud2().add(Direccion.Subir);
        if(!elevador.getSolicitud().isEmpty() && elevador.getDireccionPrevista().equals(Direccion.Ninguno) && elevador.getCantPersonas()==0){
            if(elevador.getPiso()<piso){
                elevador.setDireccionActual(Direccion.Subir);
                elevador.setDireccionPrevista(Direccion.Subir);
            }
            else{
                elevador.setDireccionActual(Direccion.Bajar);
                elevador.setDireccionPrevista(Direccion.Bajar);
            }
            
        }
    }

    @Override
    public Elevador obtenerElevadorÓptimo(int piso, Direccion dirección, ArrayList<Elevador> elevadores) {
        Elevador mejor = null;
        try{
            int largo = 6;
            for(int i = 0; i<elevadores.size(); i++){
                if(elevadores.get(i).getPiso() == piso && elevadores.get(i).getDireccionPrevista().equals(dirección) && elevadores.get(i).getDireccionActual().equals(Direccion.Ninguno) && elevadores.get(i).puedoRecoger()){
                    return elevadores.get(i);
                }
                else if(elevadores.get(i).getPiso() == piso && elevadores.get(i).getDireccionPrevista().equals(Direccion.Ninguno) && elevadores.get(i).puedoRecoger()){
                    return elevadores.get(i);
                }
                //uno de distancia
                else if(elevadores.get(i).getPiso()- piso == 1 && elevadores.get(i).getDireccionPrevista().equals(Direccion.Bajar) && dirección.equals(Direccion.Bajar) && elevadores.get(i).puedoRecoger()){
                    if(elevadores.get(i).getSolicitud().size() == 1){
                        if(largo>1){
                            mejor = elevadores.get(i);
                            largo = 1;
                        }
                    }
                    else if(elevadores.get(i).getSolicitud().get(1) <= piso){
                        if(largo>1){
                            mejor = elevadores.get(i);
                            largo = 1;
                        }
                    }
                }
                else if(elevadores.get(i).getPiso()- piso == -1 && elevadores.get(i).getDireccionPrevista().equals(Direccion.Subir) && dirección.equals(Direccion.Subir) && elevadores.get(i).puedoRecoger()){
                    if(elevadores.get(i).getSolicitud().size() == 1){
                        if(largo>1){
                            mejor = elevadores.get(i);
                            largo = 1;
                        }
                    }
                    else if(elevadores.get(i).getSolicitud().get(1) >= piso){
                        if(largo>1){
                            mejor = elevadores.get(i);
                            largo = 1;
                        }
                    }
                }
                else if(elevadores.get(i).getPiso()- piso == 1 && elevadores.get(i).getDireccionPrevista().equals(Direccion.Ninguno) && elevadores.get(i).puedoRecoger()){
                   if(largo>1) {
                       mejor = elevadores.get(i);
                       largo = 1;
                   }

                }
                else if(elevadores.get(i).getPiso()- piso == -1 && elevadores.get(i).getDireccionPrevista().equals(Direccion.Ninguno) && elevadores.get(i).puedoRecoger()){
                    if(largo>1){
                        mejor = elevadores.get(i);
                        largo = 1;
                    }
                }
                //dos de distancia
                else if(elevadores.get(i).getPiso()- piso == 2 && elevadores.get(i).getDireccionPrevista().equals(Direccion.Bajar) && dirección.equals(Direccion.Bajar) && elevadores.get(i).puedoRecoger()){
                    if(elevadores.get(i).getSolicitud().size() == 1){
                        if(largo>2){
                            mejor = elevadores.get(i);
                            largo = 2;
                        }
                    }
                    else if(elevadores.get(i).getSolicitud().get(1) <= piso){
                        if(largo>2){
                            mejor = elevadores.get(i);
                            largo = 2;
                        }
                    }
                }
                else if(elevadores.get(i).getPiso()- piso == -2 && elevadores.get(i).getDireccionPrevista().equals(Direccion.Subir) && dirección.equals(Direccion.Subir) && elevadores.get(i).puedoRecoger()){
                    if(elevadores.get(i).getSolicitud().size() == 1){
                        if(largo>2){
                            mejor = elevadores.get(i);
                            largo = 2;
                        }
                    }
                    else if(elevadores.get(i).getSolicitud().get(1) >= piso){
                        if(largo>2){
                            mejor = elevadores.get(i);
                            largo = 2;
                        }
                    }
                }
                else if(elevadores.get(i).getPiso()- piso == 2 && elevadores.get(i).getDireccionPrevista().equals(Direccion.Ninguno) && elevadores.get(i).puedoRecoger()){
                    if(largo>2) {
                        mejor = elevadores.get(i);
                        largo = 2;
                    }

                }
                else if(elevadores.get(i).getPiso()- piso == -2 && elevadores.get(i).getDireccionPrevista().equals(Direccion.Ninguno) && elevadores.get(i).puedoRecoger()){
                    if(largo>2){
                        mejor = elevadores.get(i);
                        largo = 2;
                    }
                }
                //tres de distancia
                else if(elevadores.get(i).getPiso()- piso == 3 && elevadores.get(i).getDireccionPrevista().equals(Direccion.Bajar) && dirección.equals(Direccion.Bajar) && elevadores.get(i).puedoRecoger()){
                    if(elevadores.get(i).getSolicitud().size() == 1){
                        if(largo>3){
                            mejor = elevadores.get(i);
                            largo = 3;
                        }
                    }
                    else if(elevadores.get(i).getSolicitud().get(1) <= piso){
                        if(largo>3){
                            mejor = elevadores.get(i);
                            largo = 3;
                        }
                    }
                }
                else if(elevadores.get(i).getPiso()- piso == -3 && elevadores.get(i).getDireccionPrevista().equals(Direccion.Subir) && dirección.equals(Direccion.Subir) && elevadores.get(i).puedoRecoger()){
                    if(elevadores.get(i).getSolicitud().size() == 1){
                        if(largo>3){
                            mejor = elevadores.get(i);
                            largo = 3;
                        }
                    }
                    else if(elevadores.get(i).getSolicitud().get(1) >= piso){
                        if(largo>3){
                            mejor = elevadores.get(i);
                            largo = 3;
                        }
                    }
                }
                else if(elevadores.get(i).getPiso()- piso == 3 && elevadores.get(i).getDireccionPrevista().equals(Direccion.Ninguno) && elevadores.get(i).puedoRecoger()){
                    if(largo>3) {
                        mejor = elevadores.get(i);
                        largo = 3;
                    }

                }
                else if(elevadores.get(i).getPiso()- piso == -3 && elevadores.get(i).getDireccionPrevista().equals(Direccion.Ninguno) && elevadores.get(i).puedoRecoger()){
                    if(largo>3){
                        mejor = elevadores.get(i);
                        largo = 3;
                    }
                }
                //cuatro de distancia
                else if(elevadores.get(i).getPiso()- piso == 4 && elevadores.get(i).getDireccionPrevista().equals(Direccion.Bajar) && dirección.equals(Direccion.Bajar) && elevadores.get(i).puedoRecoger()){
                    if(elevadores.get(i).getSolicitud().size() == 1){
                        if(largo>4){
                            mejor = elevadores.get(i);
                            largo = 4;
                        }
                    }
                    else if(elevadores.get(i).getSolicitud().get(1) <= piso){
                        if(largo>4){
                            mejor = elevadores.get(i);
                            largo = 4;
                        }
                    }
                }
                else if(elevadores.get(i).getPiso()- piso == -4 && elevadores.get(i).getDireccionPrevista().equals(Direccion.Subir) && dirección.equals(Direccion.Subir) && elevadores.get(i).puedoRecoger()){
                    if(elevadores.get(i).getSolicitud().size() == 1){
                        if(largo>4){
                            mejor = elevadores.get(i);
                            largo = 4;
                        }
                    }
                    else if(elevadores.get(i).getSolicitud().get(1) >= piso){
                        if(largo>4){
                            mejor = elevadores.get(i);
                            largo = 4;
                        }
                    }
                }
                else if(elevadores.get(i).getPiso()- piso == 4 && elevadores.get(i).getDireccionPrevista().equals(Direccion.Ninguno) && elevadores.get(i).puedoRecoger()){
                    if(largo>4) {
                        mejor = elevadores.get(i);
                        largo = 4;
                    }

                }
                else if(elevadores.get(i).getPiso()- piso == -4 && elevadores.get(i).getDireccionPrevista().equals(Direccion.Ninguno) && elevadores.get(i).puedoRecoger()){
                    if(largo>4){
                        mejor = elevadores.get(i);
                        largo = 4;
                    }
                }
                //cinco de distancia
                else if(elevadores.get(i).getPiso()- piso == 5 && elevadores.get(i).getDireccionPrevista().equals(Direccion.Bajar) && dirección.equals(Direccion.Bajar) && elevadores.get(i).puedoRecoger()){
                    if(elevadores.get(i).getSolicitud().size() == 1){
                        if(largo>5){
                            mejor = elevadores.get(i);
                            largo = 5;
                        }
                    }
                    else if(elevadores.get(i).getSolicitud().get(1) <= piso){
                        if(largo>5){
                            mejor = elevadores.get(i);
                            largo = 5;
                        }
                    }
                }
                else if(elevadores.get(i).getPiso()- piso == -3 && elevadores.get(i).getDireccionPrevista().equals(Direccion.Subir) && dirección.equals(Direccion.Subir) && elevadores.get(i).puedoRecoger()){
                    if(elevadores.get(i).getSolicitud().size() == 1){
                        if(largo>5){
                            mejor = elevadores.get(i);
                            largo = 5;
                        }
                    }
                    else if(elevadores.get(i).getSolicitud().get(1) >= piso){
                        if(largo>5){
                            mejor = elevadores.get(i);
                            largo = 5;
                        }
                    }
                }
                else if(elevadores.get(i).getPiso()- piso == 5 && elevadores.get(i).getDireccionPrevista().equals(Direccion.Ninguno) && elevadores.get(i).puedoRecoger()){
                    if(largo>5) {
                        mejor = elevadores.get(i);
                        largo = 5;
                    }

                }
                else if(elevadores.get(i).getPiso()- piso == -5 && elevadores.get(i).getDireccionPrevista().equals(Direccion.Ninguno) && elevadores.get(i).puedoRecoger()){
                    if(largo>5){
                        mejor = elevadores.get(i);
                        largo = 5;
                    }
                }
                else if(elevadores.get(i).getDireccionPrevista().equals(Direccion.Ninguno)){
                    mejor = elevadores.get(i);
                    largo = 6;
                }
            }
        }
        catch(Exception e){
            
        }
        return mejor;
    }
}
