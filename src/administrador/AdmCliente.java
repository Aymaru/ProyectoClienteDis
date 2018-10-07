/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador;

import Comunicacion.ObjetoComunicador;
import Comunicacion.TipoAccion;
import Controlador.DTOAlgoritmos;
import cliente.Cliente;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author M-01
 */
public class AdmCliente {

    
    public DTOAlgoritmos procesarPeticion(String elHost, int elPuerto, DTOAlgoritmos dto) {
        ObjetoComunicador Objeto=new ObjetoComunicador(null, TipoAccion.PROCESAR_PETICION);
        Objeto.setDatos(dto);
        Cliente c=new Cliente();
        c.setHOST((elHost.isEmpty() ? "localhost" : elHost)   );
        c.setPUERTO((elPuerto < 0 ? 5000 : elPuerto));

        try {
            Objeto=c.conecteServidor(Objeto);
            return Objeto.getDatos();
        } catch (UnknownHostException ex) {
            return null;
        }
    }
    
    public List<String> cargarAlfabetos(String elHost, int elPuerto) {
        ObjetoComunicador Objeto=new ObjetoComunicador(null, TipoAccion.CARGAR_ALFABETO);
        Cliente c=new Cliente();
        c.setHOST((elHost.isEmpty() ? "localhost" : elHost)   );
        c.setPUERTO((elPuerto < 0 ? 5000 : elPuerto));

        try {
            Objeto=c.conecteServidor(Objeto);
            return (List<String>) Objeto.getDatoSalida();
        } catch (UnknownHostException ex) {
            return null;
        }
    }
    
    public String getSimbolosAlfabeto(String elHost, int elPuerto, DTOAlgoritmos dto){
        ObjetoComunicador Objeto=new ObjetoComunicador(dto, TipoAccion.GET_SIMBOLOS_ALFABETO);
        Cliente c=new Cliente();
        c.setHOST((elHost.isEmpty() ? "localhost" : elHost)   );
        c.setPUERTO((elPuerto < 0 ? 5000 : elPuerto));

        try {
            Objeto=c.conecteServidor(Objeto);
            return (String) Objeto.getDatoSalida();
        } catch (UnknownHostException ex) {
            return null;
        }
    }
    
    public DTOAlgoritmos getDTO(String elHost, int elPuerto){
        ObjetoComunicador Objeto=new ObjetoComunicador(null, TipoAccion.GET_DTO);
        Cliente c=new Cliente();
        c.setHOST((elHost.isEmpty() ? "localhost" : elHost)   );
        c.setPUERTO((elPuerto < 0 ? 5000 : elPuerto));

        try {
            Objeto=c.conecteServidor(Objeto);
            return Objeto.getDatos();
        } catch (UnknownHostException ex) {
            return null;
        }
    }
    
    
    /*
    public boolean registrar(String elHost, int elPuerto, String elLogin) {
        OBJComunicacion Objeto=new OBJComunicacion(elLogin, TipoAccion.REGISTRAR_USUARIO);
        Cliente c=new Cliente();
        c.setHOST((elHost.isEmpty() ? "localhost" : elHost)   );
        c.setPUERTO((elPuerto < 0 ? 5000 : elPuerto));

        try {
            Objeto=c.conecteServidor(Objeto);
            return (boolean) Objeto.getDatoSalida();
        } catch (UnknownHostException ex) {
            return false;
        }
    }

    public boolean revisar(String elHost, int elPuerto, String elLogin) {
        OBJComunicacion Objeto=new OBJComunicacion(elLogin, TipoAccion.REVISAR_USUARIO);
        Cliente c=new Cliente();
        c.setHOST((elHost.isEmpty() ? "localhost" : elHost)   );
        c.setPUERTO((elPuerto < 0 ? 5000 : elPuerto));
        System.out.println("el host es |"+c.getHOST()+"| y el puerto es "+ c.getPUERTO());
        try {
            Objeto=c.conecteServidor(Objeto);
            return (boolean) Objeto.getDatoSalida();
        } catch (UnknownHostException ex) {
            return false;
        }
    }

    public boolean desactivar(String elHost, int elPuerto, String elLogin) {
        OBJComunicacion Objeto=new OBJComunicacion(elLogin, TipoAccion.DESACTIVAR_USUARIO);
        Cliente c=new Cliente();
        c.setHOST((elHost.isEmpty() ? "localhost" : elHost)   );
        c.setPUERTO((elPuerto < 0 ? 5000 : elPuerto));
        try {
            Objeto=c.conecteServidor(Objeto);
            return (boolean) Objeto.getDatoSalida();
        } catch (UnknownHostException ex) {
            return false;
        }
    }

    public Object cargarArchivo(String nombreArchivo, String elLogin) {
        File cualArchivo = new File(nombreArchivo);
        byte[] data;  // aqui va a quedar el archivo leido correctamente..
        if (cualArchivo.isDirectory()) {
            return null;   // no leerá un directorio
        } else {
            try {
                data = Files.readAllBytes(cualArchivo.toPath());
                ArrayList lista = new ArrayList();
                lista.add(nombreArchivo);  // primera casilla - posicion 0 : el nombre del archivo
                lista.add(elLogin);        // segunda casilla - posicion 1 : la persona que lo envia
                lista.add(data);           // tercera casilla - posicion 3 arreglo de bytes que es el archivo a transferir
                return lista;
            } catch (IOException e) {
                return null;
            }
        }
    }
    
    public boolean enviarArchivo(String elHost, int elPuerto, String elLogin, String nombreArchivo) {
        Object archivo = cargarArchivo(nombreArchivo, elLogin);
        if (archivo!=null){
            OBJComunicacion Objeto=new OBJComunicacion( archivo, TipoAccion.ENVIAR_ARCHIVO);
            Cliente c=new Cliente();
            c.setHOST((elHost.isEmpty() ? "localhost" : elHost)   );
            c.setPUERTO((elPuerto < 0 ? 5000 : elPuerto));
            try {
                Objeto=c.conecteServidor(Objeto);
                return (boolean) Objeto.getDatoSalida();
            } catch (UnknownHostException ex) {
                return false;
            }
        }
        return false;   // hubo problemas con la carga del archivo..
    }
    */
}
