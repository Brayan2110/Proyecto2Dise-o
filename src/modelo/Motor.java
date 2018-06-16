package modelo;

public class Motor implements Runnable {
    static public boolean esperar = true;
    Elevador elevador;
    DataDTO dataDTO;

    public Motor(Elevador elevador, DataDTO dataDTO) {
        this.elevador = elevador;
        this.dataDTO = dataDTO;
    }
    
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            while(!elevador.getSolicitud().isEmpty()){
                try {
                Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                while(esperar){
                    elevador.moverMotor();
                }
            }
        }
    }
    
    public void start(){
        new Thread(this).start();
    }
    
}
