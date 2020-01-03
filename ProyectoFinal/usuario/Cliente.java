package usuario;


import java.io.*;
import java.net.*;

public class Cliente {
    private String ip;
    private int puerto;

    public Cliente(String ip) {
        this.ip = ip;
        this.puerto=8989;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    
    public void enviar(String contenido) throws IOException{
            Socket canalComunicacion = null;
            canalComunicacion = new Socket(getIp(), getPuerto());
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