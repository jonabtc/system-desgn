package servidor;

import java.io.*;
import java.net.*;

public class Cliente extends Thread{
    private String ip;
    private int puerto;
    private String respuesta;

    public String getRespuesta() {
        return respuesta;
    }
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    public Cliente(String ip, int puerto) {
        this.ip = ip;
        this.puerto=puerto;
    }
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    public void run(){
        try {
            enviar(respuesta);
        } catch (IOException ex) {
            System.err.println("Error al Enviar respuesta");
        }
    }    
    public void enviar(String contenido) throws IOException{
            Socket canalComunicacion = null;
            canalComunicacion = new Socket(getIp(), getPuerto());
            System.out.println(contenido+"llega");
            System.out.println(getIp());
            OutputStream bufferSalida;
            DataOutputStream datos;
            bufferSalida = canalComunicacion.getOutputStream();
            datos = new DataOutputStream(bufferSalida);
            datos.writeUTF(contenido);
            datos.close();
            bufferSalida.close();
            canalComunicacion.close();
    }
    public int getPuerto() {
        return puerto;
    }
    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }
}