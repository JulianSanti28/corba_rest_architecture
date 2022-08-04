package co.unicauca.servidor.declaracion.servidordeclaracion.service;


import co.unicauca.servidor.declaracion.servidordeclaracion.model.Compra;
import org.springframework.stereotype.Service;
import sop_corba.ControladorCompraInt;
import sop_corba.ControladorCompraIntPackage.CompraDTO;

@Service
public class NotificarServiceImpl implements INotificarService, Runnable{
    private CompraDTO compraNotificar;
    private  ControladorCompraInt objRemoto;

    @Override
    public boolean notificar(CompraDTO c) {
        if(this.objRemoto == null){
            return false;
        }else{
            return this.objRemoto.registrarNotificacion(c);
        }
    }

    @Override
    public void init(Compra c, ControladorCompraInt objRemoto){
        this.objRemoto = objRemoto;
        this.compraNotificar = new CompraDTO(c.getIdUsuario(),c.getTipoIdentificacion(),c.getValorCompra(),c.getLugarCompra(),c.getFechaCompra(),c.getMedioPago(),c.getNitEmpresa());
    }
    @Override
    public void run() {
        System.out.println("Envíar notificación");
        notificar(this.compraNotificar);
    }
}
