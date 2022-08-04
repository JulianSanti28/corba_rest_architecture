/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.service;

import servidor.repository.CompraRepositoryImpl;
import servidor.controller.CompraControladorImpl;
import servidor.utils.UtilidadesRegistroS;
/**
 *
 * @author Paula
 */
public class ServidorNotificacion {
    public static void main(String[] args) {
       
        try {
            String[] vectorDatosLocalizarNS = new String[4];
            vectorDatosLocalizarNS[0] = "-ORBInitialHost";
            vectorDatosLocalizarNS[1] = "localhost";
            vectorDatosLocalizarNS[2] = "-ORBInitialPort";
            vectorDatosLocalizarNS[3] = "2020";
            CompraRepositoryImpl objRepository = new CompraRepositoryImpl();
            CompraControladorImpl objRemotoGestionCanciones = new CompraControladorImpl(objRepository);
            UtilidadesRegistroS.registrarObjetoRemoto(vectorDatosLocalizarNS, objRemotoGestionCanciones,"idObjetoRemoto");
            
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace(System.out);
        }
    }
      
}
