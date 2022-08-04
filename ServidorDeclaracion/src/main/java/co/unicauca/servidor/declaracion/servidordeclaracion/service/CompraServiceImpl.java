package co.unicauca.servidor.declaracion.servidordeclaracion.service;

import co.unicauca.servidor.declaracion.servidordeclaracion.dao.ICompraRepository;
import co.unicauca.servidor.declaracion.servidordeclaracion.utilidades.UtilidadesRegistroC;
import co.unicauca.servidor.declaracion.servidordeclaracion.model.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sop_corba.ControladorCompraInt;

@Service
public class CompraServiceImpl implements  ICompraService{
    //Dependece inyection
    @Autowired
    private ICompraRepository compraRepository;
    @Autowired
    private INotificarService notificarService;
    private ControladorCompraInt objRemoto;
    public CompraServiceImpl(){
        getRemoteObject();
    }
    @Override
    public Compra guardarCompra(Compra save) {
        Compra saveRepository = this.compraRepository.guardarCompra(save);
        if(this.compraRepository.requiereNotificacion(save.getIdUsuario())){
           this.notificarService.init(save,this.objRemoto);
           Thread notificacion = new Thread((Runnable) notificarService);
           notificacion.run();
        }
        return saveRepository;
    }
    public void getRemoteObject(){
        String[] vectorDatosLocalizarNS = new String[4];
        vectorDatosLocalizarNS[0] = "-ORBInitialHost";
        vectorDatosLocalizarNS[1] = "localhost";
        vectorDatosLocalizarNS[2] = "-ORBInitialPort";
        vectorDatosLocalizarNS[3] ="2020";
        this.objRemoto = UtilidadesRegistroC.obtenerObjRemoto(vectorDatosLocalizarNS,"idObjetoRemoto");
    }
}
