package usuario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.util.ArrayList;

public class Empleado implements IEmpleado{
    Cliente comCLiente;
    Servidor comServidor;
    ServidorCentral servidorCentral;
    private String nombre;
    private int puerto;
    private String ip;
    private ArrayList<Reunion> reunionesCreadas;
    private ArrayList<Reunion> reunionesInvitado;
     
    public Empleado(String  nombre, int puerto,ServidorCentral serCent) throws FileNotFoundException, IOException, ClassNotFoundException{
        servidorCentral=serCent;
        this.nombre=nombre;
        this.puerto= puerto;
        comCLiente= new Cliente(serCent.getIp());
        comServidor= new Servidor(this);
        File fichero= new File(nombre);
        reunionesCreadas=new ArrayList<Reunion>();
        reunionesInvitado=new ArrayList<Reunion>();
        ip=InetAddress.getLocalHost().getHostAddress();
        if (fichero.exists()){
            cargarArchivo();
            
        }else{
            actualizarArchivo();
        }
        Registrar();
        comServidor.start();
    }
    public synchronized void actualizarArchivo() throws FileNotFoundException, IOException{
            FileOutputStream fos = new FileOutputStream(nombre);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(getReunionesCreadas());
            out.writeObject(reunionesInvitado);
            out.close();
            fos.close();
    }
    public void cargarArchivo() throws FileNotFoundException, IOException, ClassNotFoundException{
             FileInputStream fis = new FileInputStream(nombre);
            ObjectInputStream in = new ObjectInputStream(fis);
            setReunionesCreadas((ArrayList<Reunion>)in.readObject());
            reunionesInvitado=(ArrayList<Reunion>)in.readObject();
            in.close();
            fis.close();
    }
    @Override
    public void envia(String ip, int puerto, String mensaje) {
        try {
            comCLiente.setPuerto(puerto);
            comCLiente.setIp(ip);
            comCLiente.enviar(mensaje);
        } catch (IOException ex) {
            System.err.println("Error enviar mensaje");
        }
    }

    @Override
    public void recibe(int puerto) {
        comServidor.start();
    }

    public Cliente getComCLiente() {
        return comCLiente;
    }

    public void setComCLiente(Cliente comCLiente) {
        this.comCLiente = comCLiente;
    }

    public Servidor getComServidor() {
        return comServidor;
    }

    public void setComServidor(Servidor comServidor) {
        this.comServidor = comServidor;
    }

    public ServidorCentral getServidorCentral() {
        return servidorCentral;
    }

    public void setServidorCentral(ServidorCentral servidorCentral) {
        this.servidorCentral = servidorCentral;
    }
    public void crearReunionServidor(Reunion reunion){
        envia(servidorCentral.getIp(), servidorCentral.getPuerto(), "1*"+reunion.toString());
        
    }
    public void Registrar(){
        envia(servidorCentral.getIp(), servidorCentral.getPuerto(), "3*"+this.ip+","+this.puerto+","+this.nombre);
    }
    public void crearReunion(Reunion reunion) throws IOException, ReunionDuplicadaException{
        if (!this.tieneReunion(reunion.getTema())) {
            getReunionesCreadas().add(reunion);
            actualizarArchivo();
        }else{
                throw new ReunionDuplicadaException("Ya temeos una reunion con ese tema. Si desea la puede modificar");
            }
        
    }
    public void agregarReunionInvitado(Reunion reunion) throws IOException, ReunionDuplicadaException{
        if (!this.tieneReunion(reunion.getTema())) {
            reunionesInvitado.add(reunion);
            actualizarArchivo();
        }else{
                throw new ReunionDuplicadaException("Ya temeos una reunion con ese tema. Si desea la puede modificar");
            }
    }
    public synchronized void modificarReunionServidor(Reunion reunion){
        envia(servidorCentral.getIp(), servidorCentral.getPuerto(), "2*"+reunion.toString());
    }
    public boolean tieneReunion(String tema){
        for (Reunion reunion1 : reunionesCreadas) {
            if (reunion1.getTema().equals(tema)) {
              return true;
            }
        }
        for (Reunion reunion1 : reunionesInvitado) {
            if (reunion1.getTema().equals(tema)) {
              return true;
            }
        }
        return false;
    }
    public Reunion obtnerReunion(String tema){
        for (Reunion reunion1 : reunionesCreadas) {
            if (reunion1.getTema().equals(tema)) {
              return reunion1;
            }
        }
        for (Reunion reunion1 : reunionesInvitado) {
            if (reunion1.getTema().equals(tema)) {
              return reunion1;
            }
        }
        return null;
    }
    public synchronized void modificarReunionCreada(String tema, Reunion reunion) throws IOException{
        for (Reunion reunionCreada :getReunionesCreadas()) {
            if (reunionCreada.getTema().equals(tema)){
                getReunionesCreadas().remove(reunionCreada);
                getReunionesCreadas().add(reunion);
                
            }
        }
        actualizarArchivo();
    }
    public void modificarReunionInvitado(String tema, Reunion reunion) throws IOException{
        for (Reunion reunionInvitado : reunionesInvitado) {
            if (reunionInvitado.getTema().equals(tema)){
                getReunionesCreadas().remove(reunionInvitado);
                getReunionesCreadas().add(reunion);
            }
        }
        actualizarArchivo();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public synchronized ArrayList<Reunion> getReunionesCreadas() {
        return reunionesCreadas;
    }

    public synchronized void setReunionesCreadas(ArrayList<Reunion> reunionesCreadas) {
        this.reunionesCreadas = reunionesCreadas;
    }

    public ArrayList<Reunion> getReunionesInvitado() {
        return reunionesInvitado;
    }

    public void setReunionesInvitado(ArrayList<Reunion> reunionesInvitado) {
        this.reunionesInvitado = reunionesInvitado;
    }    
}

