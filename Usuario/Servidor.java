package usuario;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Servidor extends Thread{   
    private Empleado empleado;
    public Servidor(Empleado empleado) {
        this.empleado = empleado;
    }
    public synchronized void run(){       
        try {    
            ServerSocket puerto = null;
            Socket canalComunicacion = null;
            InputStream bufferEntrada;
            DataInputStream datos;            
            puerto = new ServerSocket(empleado.getPuerto()); 
         
            while(true){      
                //Justo en esta parte comienza a escuchar, por eso se coloca el while aquí.
                canalComunicacion = puerto.accept();
                bufferEntrada = canalComunicacion.getInputStream();
                datos = new DataInputStream(bufferEntrada);
                String cadena=null;
                cadena = new String(datos.readUTF());
                String[] vect1;
                vect1 = cadena.split("\\*");
                if (vect1[0].equals("1")){
                    Reunion reunion= new Reunion(null, null, null,null, null, null, null, null);
                    System.out.println(vect1[1]);
                    reunion.deString(vect1[1]);
                    if(reunion.getCreador().endsWith(empleado.getNombre())){
                        if(!empleado.tieneReunion(reunion.getTema())){
                            empleado.crearReunion(reunion);
                        }
                        
                    }else{
                        if(!empleado.tieneReunion(reunion.getTema())){
                            empleado.agregarReunionInvitado(reunion);
                        }
                    }
                    
                }else{
                    Reunion reunion= new Reunion(null, null, null,null, null, null, null, null);
                    reunion.deString(vect1[1]);
                    if (reunion.getCreador().equals(empleado.getNombre())){
                        empleado.modificarReunionCreada(reunion.getTema(), reunion);
                    }else{
                        
                        empleado.modificarReunionInvitado(reunion.getTema(), reunion);
                        
                    }
               }
                datos.close();
                bufferEntrada.close();
                canalComunicacion.close();
            }                                  
            
        } catch (IOException ex) {
            System.err.println("Error al abrir conexioon en el puerto:"+empleado.getPuerto());
        } catch (ReunionDuplicadaException ex) {
            System.err.println(ex.getMessage());
        }
    }        

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

   
   
}
