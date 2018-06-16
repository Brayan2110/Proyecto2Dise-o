package modelo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class XML implements IArchivoStrategy {
    public String guardarArchivo(String archivo, DataDTO dataDTO) {

        return "";
    }

    public XML() {
    }

    public DataDTO leerArchivo(String archivo) {
        DataDTO datos = new DataDTO();
        try {
            File file = new File(archivo);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();

            //System.out.println("Elemento raiz:" + document.getDocumentElement().getNodeName());

            NodeList cantidad = document.getElementsByTagName("cantidadDePisos");
            Node nodo = cantidad.item(0);
            Element element = (Element) nodo;
            //System.out.println("cantidadDePisos: " + element.getAttribute("cantidad"));
            datos.setCantidadDePisos(Integer.valueOf(element.getAttribute("cantidad")));

            cantidad = document.getElementsByTagName("cantidadDeElevadores");
            nodo = cantidad.item(0);
            element = (Element) nodo;
            //System.out.println("cantidadDeElevadores: " + element.getAttribute("cantidad"));
            datos.setCantidadDeElevadores(Integer.valueOf(element.getAttribute("cantidad")));

            cantidad = document.getElementsByTagName("probBotonEmergencia");
            nodo = cantidad.item(0);
            element = (Element) nodo;
            //System.out.println("probBotonEmergencia: " + element.getAttribute("prob"));
            datos.setProbBotonEmergencia(Float.valueOf(element.getAttribute("prob")));

            cantidad = document.getElementsByTagName("tiempoEntrePiso");
            nodo = cantidad.item(0);
            element = (Element) nodo;
            //System.out.println("tiempoEntrePiso: " + element.getAttribute("time"));
            datos.setTiempoEntrepiso(Integer.valueOf(element.getAttribute("time")));

            cantidad = document.getElementsByTagName("tiempoPuertaAbierta");
            nodo = cantidad.item(0);
            element = (Element) nodo;
            //System.out.println("tiempoPuertaAbierta: " + element.getAttribute("time"));
            datos.setTiempoPuertaAbierta(Integer.valueOf(element.getAttribute("time")));

            cantidad = document.getElementsByTagName("tiempoPuertaAbiertaBotonDetenerse");
            nodo = cantidad.item(0);
            element = (Element) nodo;
            //System.out.println("tiempoPuertaAbiertaBotonDetenerse: " + element.getAttribute("time"));
            datos.setTiempoPuertaAbiertaBotonDetenerse(Integer.valueOf(element.getAttribute("time")));

            cantidad = document.getElementsByTagName("cantidadPersonas");
            nodo = cantidad.item(0);
            element = (Element) nodo;
            //System.out.println("cantidadPersonas: " + element.getAttribute("cantidad"));
            //System.out.println("cantidadPersonas: " + element.getAttribute("cantidad"));
            datos.setCantidadPersonas(Integer.valueOf(element.getAttribute("cantidad")));

            HashMap<String, Float> xHashMap = new HashMap();
            cantidad = document.getElementsByTagName("Elevadores");
            nodo = cantidad.item(0);
            //System.out.println("Elevadores:" + nodo.getNodeName());
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                element = (Element) nodo;
                NodeList id = element.getElementsByTagName("Elevador");
                ArrayList<String> s = new ArrayList();
                for (int temp = 0; temp < id.getLength(); temp++) {
                    nodo = id.item(temp);
                    element = (Element) nodo;
                    cantidad = element.getElementsByTagName("identificador");
                    nodo = cantidad.item(0);
                    element = (Element) nodo;
                    ///System.out.println("identificador: " + element.getAttribute("id"));
                    s.add(element.getAttribute("id"));
                }
                ArrayList<Float> f = new ArrayList();
                for (int temp = 0; temp < id.getLength(); temp++) {
                    nodo = id.item(temp);
                    element = (Element) nodo;
                    cantidad = element.getElementsByTagName("botonDetenerse");
                    nodo = cantidad.item(0);
                    element = (Element) nodo;
                    //System.out.println("botonDetenerse: " + element.getAttribute("prob"));
                    f.add(Float.valueOf(element.getAttribute("prob")));
                }
                for (int i = 0; i < s.size(); i++) {
                    xHashMap.put(s.get(i), f.get(i));
                }
            }
            datos.setProbBotonDetenerse(xHashMap);

            xHashMap = new HashMap<>();
            HashMap<String, Float> xHashMap2 = new HashMap();
            cantidad = document.getElementsByTagName("Pisos");
            nodo = cantidad.item(0);
            //System.out.println("Pisos:" + nodo.getNodeName());
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                element = (Element) nodo;
                NodeList id = element.getElementsByTagName("Piso");
                ArrayList<String> s = new ArrayList();
                for (int temp = 0; temp < id.getLength(); temp++) {
                    nodo = id.item(temp);
                    element = (Element) nodo;
                    cantidad = element.getElementsByTagName("identificador");
                    nodo = cantidad.item(0);
                    element = (Element) nodo;
                    //System.out.println("identificador: " + element.getAttribute("id"));
                    s.add(element.getAttribute("id"));
                }
                ArrayList<Float> f = new ArrayList();
                for (int temp = 0; temp < id.getLength(); temp++) {
                    nodo = id.item(temp);
                    element = (Element) nodo;
                    cantidad = element.getElementsByTagName("probabilidadDestino");
                    nodo = cantidad.item(0);
                    element = (Element) nodo;
                    //System.out.println("probabilidadDestino: " + element.getAttribute("prob"));
                    f.add(Float.valueOf(element.getAttribute("prob")));
                }
                ArrayList<Float> f2 = new ArrayList();
                for (int temp = 0; temp < id.getLength(); temp++) {
                    nodo = id.item(temp);
                    element = (Element) nodo;
                    cantidad = element.getElementsByTagName("probabilidadSolicitud");
                    nodo = cantidad.item(0);
                    element = (Element) nodo;
                    //System.out.println("probabilidadSolicitud: " + element.getAttribute("prob"));
                    f2.add(Float.valueOf(element.getAttribute("prob")));
                }
                for (int i = 0; i < s.size(); i++) {
                    xHashMap.put(s.get(i), f.get(i));
                    xHashMap2.put(s.get(i), f2.get(i));
                }
            }
            datos.setProbEscogerPisoComoDestino(xHashMap);
            datos.setProbSolicitarElevadorEnUnPiso(xHashMap2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datos;
    }
}
