/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.repository;

import java.util.ArrayList;
import java.util.List;

import sop_corba.ControladorCompraIntPackage.CompraDTO;

/**
 *
 * @author Paula
 */
public class CompraRepositoryImpl implements ICompraRepository {

    private final ArrayList<CompraDTO> listaCompras;
    
    public CompraRepositoryImpl() {
        this.listaCompras = new ArrayList();
    }

    @Override
    public boolean registrarCompra(CompraDTO objCompra) {
        boolean bandera;        
        bandera = this.listaCompras.add(objCompra);
        System.out.println("Archivo creado en el servidor");
        return bandera;
    }

    @Override
    public List<CompraDTO> listarCompra() {
        System.out.println("Listando compras");
        return this.listaCompras;
    }
    
}
