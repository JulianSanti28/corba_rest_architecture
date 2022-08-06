/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.controller;

import servidor.repository.ICompraRepository;
import servidor.view.VistaNotificacion;
import sop_corba.ControladorCompraIntPOA;
import sop_corba.ControladorCompraIntPackage.CompraDTO;

/**
 *
 * @author Paula
 */
public class CompraControladorImpl extends ControladorCompraIntPOA{

    private final ICompraRepository objCompraRepositorio;
    private VistaNotificacion vista;
    public CompraControladorImpl(ICompraRepository objCompraRepositorio) {
        this.objCompraRepositorio = objCompraRepositorio;
    }
            
    
    @Override
    public boolean registrarCompra(CompraDTO objCompra) {
        boolean bandera=false;
        if(this.objCompraRepositorio.registrarCompra(objCompra))
        {
            bandera=true;
            vista=new VistaNotificacion(objCompra);
            vista.setVisible(true);
        }
        return bandera;
    }
    @Override
    public CompraDTO[] listarCanciones() {
        CompraDTO[] vector=new CompraDTO[objCompraRepositorio.listarCompra().size()];
        this.objCompraRepositorio.listarCompra().toArray(vector);
        return vector;
    }
    
}
