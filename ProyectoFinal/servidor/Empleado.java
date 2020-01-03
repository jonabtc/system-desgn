package servidor;

import java.io.Serializable;

public class Empleado implements Serializable{
   
	private static final long serialVersionUID = 1L;
	private String Nombre;
    private String ip;
    private int puerto;

    public Empleado(String Nombre, String ip, int puerto) {
        this.Nombre = Nombre;
        this.ip = ip;
        this.puerto= puerto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }    
}
