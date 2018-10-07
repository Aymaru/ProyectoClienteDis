/*
 * To change this template, choose Tools | Templates * and open the template in the editor.
 */

package cliente;


import Comunicacion.ObjetoComunicador;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Macielb Novoa
 */
public class Cliente {

    private String HOST = "192.168.0.104";
    
    //private  String HOST =  "localhost";
   
    private    int PUERTO= 5000;




    private InputStream conexionEntrada;
    private ObjectInputStream flujoLectura;

    private OutputStream conexionSalida;
    private ObjectOutputStream flujoEscritura;




    public Cliente() {
    }
     public String getHOST() {
        return HOST;
    }

    public void setHOST(String HOST) {
        this.HOST = HOST;
    }

    public int getPUERTO() {
        return PUERTO;
    }

    public void setPUERTO(int PUERTO) {
        this.PUERTO = PUERTO;
    }


   

    public ObjetoComunicador conecteServidor(ObjetoComunicador obj) throws UnknownHostException{
        try {
            
            Socket cliente = new Socket(HOST, PUERTO);
            //Establece mecanismo de comunicacion con el servidor - Lectura..
            System.out.println("Estableciendo comunicacion de lectura con el server...");
            conexionEntrada = cliente.getInputStream();
            flujoLectura = new ObjectInputStream(conexionEntrada);
            System.out.println("Estableciendo comunicacion de escritura con el server...");
            conexionSalida = cliente.getOutputStream();
            flujoEscritura = new ObjectOutputStream(conexionSalida);

            // procesar la gestion a solicitar
            flujoEscritura.writeObject(obj);
            flujoEscritura.flush();
            
            // recupera la respuesta del servidor...
            obj = (ObjetoComunicador) flujoLectura.readObject();

            flujoEscritura.close();
            flujoLectura.close();
            cliente.close();
        } catch (ClassNotFoundException  ex) {
            System.out.println("Conectandose a un servidor desconocido");
        }
        catch (UnknownHostException ex) {
            System.out.println("Conectandose a un servidor desconocido");
        } catch (IOException ex) {
            System.out.println("Problemas con los flujos de entrada / salida");
        }



        return obj;
    }




}
