/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.SimuladorSingleton;
import modelo.vista;

/**
 *
 * @author Bvarg
 */
public class ControladorSimulacion {

    SimuladorSingleton ourInstance;
/**
     * @param args the command line arguments
     */
        public static void main(String[] args) {
        // TODO code application logic here
    }

    public ControladorSimulacion() {
        this.ourInstance = new SimuladorSingleton();
        
        vista vista = new vista() {
            @Override
            public void desplegarInformaciondeParametros() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void cambiarVelocidad() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void iniciarModoAutomatico() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void iniciarModoPasoaPaso() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void obtenerArchivodeCarga() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void guardarArchivodeCarga() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void desplegarInformaciondeElevadores() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }
    
}
