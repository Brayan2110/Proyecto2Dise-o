package modelo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.io.File;
import java.util.HashMap;


public class JSON implements IArchivoStrategy{
    public JSON() {
    }

    @Override
    public String guardarArchivo(String archivo, DataDTO dataDTO)
    {
        String mensaje = "fallo";
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("cantidadPersonas", dataDTO.getCantidadPersonas());
            jsonObject.put("probBotonEmergencia", (Float)dataDTO.getProbBotonEmergencia());
            jsonObject.put("tiempoEntrePiso", dataDTO.getTiempoEntrepiso());
            jsonObject.put("tiempoPuertaAbierta", dataDTO.getTiempoPuertaAbierta());
            jsonObject.put("tiempoPuertaAbiertaBotonDetenerse", dataDTO.getTiempoPuertaAbiertaBotonDetenerse());
            Float[] s = new Float[dataDTO.getCantidadDeElevadores()];
            HashMap<String, Float> elevadores = dataDTO.getProbBotonDetenerse();
            for (int i = 0 ; i < dataDTO.getCantidadDeElevadores() ; i++){
                s[i] = Float.valueOf(elevadores.get(String.valueOf(i+1)));
            }
            jsonObject.put("Elevadores", s);

            s = new Float[dataDTO.getCantidadDePisos()];
            Float[] s1 = new Float[dataDTO.getCantidadDePisos()];
            HashMap<String, Float> pisos1 = dataDTO.getProbEscogerPisoComoDestino();
            HashMap<String, Float> pisos2 = dataDTO.getProbSolicitarElevadorEnUnPiso();
            for (int i = 0 ; i < dataDTO.getCantidadDePisos() ; i++){
                s[i] = Float.valueOf(pisos1.get(String.valueOf(i+1)));
                s1[i] = Float.valueOf(pisos2.get(String.valueOf(i+1)));
            }

            jsonObject.put("SolicitarElevadorEnUnPiso", s1);
            jsonObject.put("EscogerPisoComoDestino", s);

            File f = new File(archivo);
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.print(jsonObject.toString(4));
            bw.write(jsonObject.toString(4));
            bw.flush();
            bw.close();
            fw.close();
            mensaje = "Archivo Guardado";

        } catch (JSONException | IOException e) {
        }
        return mensaje;
    }
    public DataDTO leerArchivo(String archivo)
    {
        File file = new File(archivo);
        String strJSON = "" , linea;
        DataDTO datos = new DataDTO();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                strJSON += linea ;
            }
            JSONObject jsonObject = new JSONObject(strJSON);

            datos.setCantidadPersonas(jsonObject.getInt("cantidadPersonas"));
            datos.setProbBotonEmergencia((float) jsonObject.getDouble("probBotonEmergencia"));
            datos.setTiempoEntrepiso(jsonObject.getInt("tiempoEntrePiso"));
            datos.setTiempoPuertaAbierta(jsonObject.getInt("tiempoPuertaAbierta"));
            datos.setTiempoPuertaAbiertaBotonDetenerse(jsonObject.getInt("tiempoPuertaAbiertaBotonDetenerse"));
            HashMap<String, Float> elevadores = datos.getProbBotonDetenerse();
            JSONArray array = jsonObject.getJSONArray("Elevadores");

            datos.setCantidadDeElevadores(array.length());

            for (int i = 0 ; i < array.length() ; i ++){
                elevadores.put(String.valueOf(i+1) , (float) array.getDouble(i));
            }

            array = jsonObject.getJSONArray("SolicitarElevadorEnUnPiso");
            JSONArray array1 = jsonObject.getJSONArray("EscogerPisoComoDestino");
            HashMap<String, Float> pisos = datos.getProbEscogerPisoComoDestino();
            HashMap<String, Float> pisos1 = datos.getProbSolicitarElevadorEnUnPiso();
            datos.setCantidadDePisos(array.length());
            for (int i = 0 ; i < array.length() ; i ++){
                pisos.put(String.valueOf(i+1) , (float) array.getDouble(i));
                pisos1.put(String.valueOf(i+1) , (float) array1.getDouble(i));
            }
            fr.close();
            return datos;


        } catch (FileNotFoundException | JSONException e) {
        } catch (IOException e) {
        }



        return null;
    }

}