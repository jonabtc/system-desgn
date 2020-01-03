package usuario;


public class ServidorCentral {
    private int puerto;
    private String ip;

    public ServidorCentral(String ip,int puerto ) {
        this.puerto = puerto;
        this.ip = ip;
    }
    public int getPuerto() {
        return puerto;
    }
    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }    
}

