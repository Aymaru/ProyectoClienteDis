/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import administrador.AdmCliente;

/**
 *
 * @author M-01
 */
public class UICliente {
    
    private AdmCliente miAdm;

    public UICliente(){
        miAdm=new AdmCliente();
    }
    /*
    public void registrar(FRCliente ventana) {
        String elLogin=ventana.getTxtUsuario().getText();
        String elHost = ventana.getTxtHost().getText();
        int elPuerto = Integer.parseInt(ventana.getTxtPuerto().getText());
        
        if (miAdm.registrar(elHost, elPuerto, elLogin)){
            ventana.getTaMensaje().setText("Si registro usuario");}
        else{
            ventana.getTaMensaje().setText("No registro usuario");}
    }

    public void ingresar(FRCliente ventana) {
        String elLogin=ventana.getTxtUsuario().getText();
        String elHost = ventana.getTxtHost().getText();
        int elPuerto = Integer.parseInt(ventana.getTxtPuerto().getText());
        if (miAdm.revisar(elHost, elPuerto, elLogin)){
            ventana.getTaMensaje().setText("Si ingreso usuario");}
        else{
            ventana.getTaMensaje().setText("No ingreso usuario");}
    }

    public void desactivar(FRCliente ventana) {
        String elLogin=ventana.getTxtUsuario().getText();
        String elHost = ventana.getTxtHost().getText();
        int elPuerto = Integer.parseInt(ventana.getTxtPuerto().getText());
        if (miAdm.desactivar(elHost, elPuerto, elLogin)){
            ventana.getTaMensaje().setText("Si desactivo usuario");}
        else{
            ventana.getTaMensaje().setText("No desactivo usuario");}
    }

    public void enviarArchivo(FRCliente ventana) {
        
        String nombreArchivo=ventana.getLblArchivo().getText();
        String elLogin=ventana.getTxtUsuario().getText();
        String elHost = ventana.getTxtHost().getText();
        int elPuerto = Integer.parseInt(ventana.getTxtPuerto().getText());
        
        boolean resp = miAdm.enviarArchivo(elHost, elPuerto, elLogin, nombreArchivo);
        String h = ventana.getLblArchivo().getText() ;
        h = (resp ? h+ " Enviado" : h+" No Enviado");
        ventana.getLblArchivo().setText(h);
        
        
    }
    */
}
