/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.repository;

import java.util.List;
import sop_corba.ControladorCompraIntPackage.CompraDTO;

/**
 *
 * @author Paula
 */
public interface ICompraRepository {
    public boolean registrarCompra(CompraDTO objCompra);   
    public List<CompraDTO> listarCompra();
}
