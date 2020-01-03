package usuario;

import java.io.Serializable;
import java.util.ArrayList;

public class Reunion implements Serializable{
    
	private static final long serialVersionUID = 1L;
	private String tema;
    private  ArrayList<String> invitados;
    private String creador;
    private String lugar;
    private String fecha_inicio;
    private String fecha_fin;
    private String hora_inicio;
    private String hora_fin;

    public Reunion(String tema, ArrayList<String> invitados, String creador, String lugar, String fecha_inicio, String fecha_fin, String hora_inicio, String hora_fin) {
        this.tema = tema;
        this.invitados = invitados;
        this.creador = creador;
        this.lugar = lugar;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
    }
    
    @Override
    public String toString() {
        String envio;
        envio= tema+","+creador+","+lugar+","+fecha_inicio+","+hora_inicio+","+fecha_fin+","+hora_fin;
        for (String invitado : invitados) {
            envio=envio+","+invitado;
        }
        return envio;
    }
    public void deString(String reunionString){
        String[] vector= reunionString.split(",");
        this.tema=vector[0];
        this.creador=vector[1];
        this.lugar=vector[2];
        this.fecha_inicio=vector[3];
        this.hora_inicio=vector[4];
        this.fecha_fin=vector[5];
        this.hora_fin=vector[6];
        ArrayList<String> invi = new ArrayList<String>();
        for (int i = 7; i < vector.length; i++) {
            invi.add(vector[i]);
        }
        this.invitados=invi;
        
    }
    
    public void agregarInvitado(String invitado){
        invitados.add(invitado);
    }
    public boolean verificarInvidato(String invitadoVer){
        for (String invitado : invitados) {
            if (invitado==invitadoVer) {
                return true;
            }
        }
        return false;
    }
    public void eliminarInvitado(String invitado){
        if (verificarInvidato(invitado)) {
               invitados.remove(invitado);
        }
    }
    public String getTema() {
        return tema;
    }
    public void setTema(String tema) {
        this.tema = tema;
    }
    public  ArrayList<String> getInvitados() {
        return invitados;
    }
    public void setInvitados( ArrayList<String> invitados) {
        this.invitados = invitados;
    }
    public String getCreador() {
        return creador;
    }
    public void setCreador(String creador) {
        this.creador = creador;
    }
    public String getLugar() {
        return lugar;
    }
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    public String getFecha_inicio() {
        return fecha_inicio;
    }
    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }
    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
    public String getHora_inicio() {
        return hora_inicio;
    }
    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }
    public String getHora_fin() {
        return hora_fin;
    }
    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }
}

