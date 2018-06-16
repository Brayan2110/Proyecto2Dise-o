package modelo;

import java.util.ArrayList;
import java.util.Map;
import static modelo.Motor.esperar;

public class SimuladorSingleton implements Runnable{
    private int UT;
    public static SimuladorSingleton ourInstance = new SimuladorSingleton();
    private DataDTO datosSimulacion;
    private ArrayList lista = new ArrayList();
    private Controlador controlador = new Controlador();
    private int[] personas;
    public static SimuladorSingleton getInstance() {
        return ourInstance;
    }

    public int getUT() {
        return UT;
    }

    public void setUT(int UT) {
        this.UT = UT;
    }
    
    public SimuladorSingleton() {
    }
    public void cargar(String direccion)
    {
        ArchivoFactory archivoFactory = new ArchivoFactory();
        IArchivoStrategy archivito = archivoFactory.crearArchivo(direccion);

        datosSimulacion = archivito.leerArchivo(direccion);
        for (int i = 1;i <= datosSimulacion.getCantidadDeElevadores();i++)
        {
            controlador.crearElevador(i);

        }
        for(int i = 0; i<controlador.getElevadores().size();i++){
            Motor motor = new Motor(getControlador().getElevadores().get(i),datosSimulacion);
            motor.start();
            lista.add(motor);
        }
        Elevador.maximo = datosSimulacion.getCantidadPersonas();
        personas = new int[datosSimulacion.getCantidadDePisos()];
        for(int i=0; i< personas.length; i++){
            personas[i]=0;
        }
    }
    
    public String guardar(String direccion)
    {
        ArchivoFactory archivoFactory = new ArchivoFactory();
        IArchivoStrategy archivito = archivoFactory.crearArchivo(direccion);
        String respuesta = archivito.guardarArchivo(direccion, datosSimulacion);
        return respuesta;

    }
    
    public void simulador ()
    {
        try{
            while(true){
            try {
                Thread.sleep(100);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            while(esperar){
                try {
                Thread.sleep(UT*1000);
                    } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Realizar solicitud de un piso
                int pisoSolicitud = Integer.valueOf(SolicitarElevador());
                if(pisoSolicitud == 1)
                {
                    controlador.atenderSolicitudBotonPiso(pisoSolicitud,Direccion.Subir);
                }
                else
                {
                    if(pisoSolicitud == 6)
                    {
                        controlador.atenderSolicitudBotonPiso(pisoSolicitud,Direccion.Bajar);
                    }
                    else
                    {
                        if(pisoSolicitud >=4)
                        {
                            controlador.atenderSolicitudBotonPiso(pisoSolicitud,Direccion.Bajar);
                        }
                        else
                        {
                            controlador.atenderSolicitudBotonPiso(pisoSolicitud,Direccion.Subir);
                        }
                    }
                }
                //Fin de solicitud desde un piso
                }
            }
        }
        catch(Exception e){
            
        }
        
    }
    public String SolicitarElevador(){
        String key = "";
        try{
            int random= (int) (Math.random() * 100 + 1);
            int numero = 0;
            for (Map.Entry<String, Float> entry : datosSimulacion.getProbSolicitarElevadorEnUnPiso().entrySet()) {
                //System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
                numero += entry.getValue()*100;
                if(random<=numero){
                    key = entry.getKey();
                    break;
                }
            }
        }
        catch(Exception e){
            
        }
        return key;
        
    }

    public int[] getPersonas() {
        return personas;
    }

    public void setPersonas(int[] personas) {
        this.personas = personas;
    }

    
    
    public String SolicitarDestino(){
        String key = "";
        try{
            int random= (int) (Math.random() * 100 + 1);
            int numero = 0;
            //System.out.println("random: " +random);
            for (Map.Entry<String, Float> entry : datosSimulacion.getProbEscogerPisoComoDestino().entrySet()) {
                //System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
                numero += entry.getValue()*100;
                if(random<=numero){
                    key = entry.getKey();
                    break;
                }
            }
        }
        catch(Exception e){
            
        }
        return key;
    }

    public boolean pulsarbotondetenerse(float prob){
        int random= (int) (Math.random() * 100 + 1);

        return random < prob * 100;
    }

    public boolean pulsarbotonemergencia(float prob){
        int random= (int) (Math.random() * 100 + 1);

        return random < prob * 100;
    }

    public ArrayList getLista() {
        return lista;
    }

    public void setLista(ArrayList lista) {
        this.lista = lista;
    }
    
    

    @Override
    public void run() {
        simulador();
    }
    
    public void start(){
        new Thread(this).start();
    }

    public static SimuladorSingleton getOurInstance() {
        return ourInstance;
    }

    public static void setOurInstance(SimuladorSingleton ourInstance) {
        SimuladorSingleton.ourInstance = ourInstance;
    }

    public DataDTO getDatosSimulacion() {
        return datosSimulacion;
    }

    public void setDatosSimulacion(DataDTO datosSimulacion) {
        this.datosSimulacion = datosSimulacion;
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    
    
}
