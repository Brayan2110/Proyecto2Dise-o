package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

public class Texto implements IArchivoStrategy {
    public Texto() {
    }

    @Override
    public String guardarArchivo(String archivo, DataDTO dataDTO)
    {
        String mensaje = "Fallo";
        try{
            FileOutputStream file = new FileOutputStream(archivo);
            String texto = "";
            texto = "probBotonEmergencia " + dataDTO.getProbBotonEmergencia() + "\n"
                    +"tiempoEntrePiso " + dataDTO.getTiempoEntrepiso() + "\n"
                    +"tiempoPuertaAbierta " + dataDTO.getTiempoPuertaAbierta() + "\n"
                    +"tiempoPuertaAbiertaBotonDetenerse " + dataDTO.getTiempoPuertaAbiertaBotonDetenerse() + "\n"
                    +"cantidadPersonas " + dataDTO.getCantidadPersonas();
            for(int i=0; i< dataDTO.getProbBotonDetenerse().size();i++){
                texto = texto + "\n" + "Elevador " + (i+1) + " " +dataDTO.getProbBotonDetenerse().get(String.valueOf(i+1));
            }
            for(int i=0; i< dataDTO.getProbEscogerPisoComoDestino().size();i++){
                texto = texto + "\n" + "Piso " + (i+1) + " "+dataDTO.getProbEscogerPisoComoDestino().get(String.valueOf(i+1)) + " " +dataDTO.getProbSolicitarElevadorEnUnPiso().get(String.valueOf(i+1));
            }
            byte[] bytext = texto.getBytes();
            file.write(bytext);
            mensaje = "Archivo Guardado";
        }
        catch(Exception e){
            
        }
        return mensaje;
    }
    public DataDTO leerArchivo(String archivo)
    {
        File file = null;

        FileReader fr = null;
        BufferedReader br = null;
        try
        {
            file = new File(archivo);
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            DataDTO datos = new DataDTO();
            String linea;
            while((linea=br.readLine()) != null)
            {
                String tokens[] = linea.split(" ");
                if(tokens[0].compareTo("Elevador") == 0 )
                {
                    int cantidadElevadores = datos.getCantidadDeElevadores();
                    datos.setCantidadDeElevadores(cantidadElevadores+1);
                    String identificador = tokens[1];
                    float probDetenerse = Float.valueOf(tokens[2]);
                    datos.getProbBotonDetenerse().put(identificador,probDetenerse);
                }
                else
                {
                    if(tokens[0].compareTo("Piso") == 0 )
                    {
                        int cantidadPisos = datos.getCantidadDePisos();
                        datos.setCantidadDePisos(cantidadPisos+1);
                        String identificador = tokens[1];
                        float prob = Float.valueOf(tokens[2]);
                        datos.getProbEscogerPisoComoDestino().put(identificador,prob);
                        float probPisoSolicitud = Float.valueOf(tokens[2]);
                        datos.getProbSolicitarElevadorEnUnPiso().put(identificador,probPisoSolicitud);
                    }
                    else
                    {
                        if(tokens[0].compareTo("probBotonEmergencia") == 0)
                        {
                            float prob = Float.valueOf(tokens[1]);
                            datos.setProbBotonEmergencia(prob);
                        }
                        else
                        {
                            if(tokens[0].compareTo("tiempoEntrePiso") == 0)
                            {
                                int prob = Integer.valueOf(tokens[1]);
                                datos.setTiempoEntrepiso(prob);
                            }
                            else
                            {
                                if(tokens[0].compareTo("tiempoPuertaAbierta") == 0)
                                {
                                    int prob = Integer.valueOf(tokens[1]);
                                    datos.setTiempoPuertaAbierta(prob);
                                }
                                else
                                {
                                    if(tokens[0].compareTo("tiempoPuertaAbiertaBotonDetenerse") == 0)
                                    {
                                        int prob = Integer.valueOf(tokens[1]);
                                        datos.setTiempoPuertaAbiertaBotonDetenerse(prob);
                                    }
                                    else
                                    {
                                        if(tokens[0].compareTo("cantidadPersonas") == 0)
                                        {
                                            int canti = Integer.valueOf(tokens[1]);
                                            datos.setCantidadPersonas(canti);
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
            }
            return datos;
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }

        return null;
    }
}
