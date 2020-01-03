package servidor;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread {
	private int puerto;

	Servidor(int puerto){
		this.puerto = puerto;
	}
	public void run() {
		try {
			ServerSocket puerto = null;
			Socket canalComunicacion = null;
			InputStream bufferEntrada;
			DataInputStream datos;
			puerto = new ServerSocket(this.getPuerto());
			System.out.println("Start server...");
			while (true) {
				canalComunicacion = puerto.accept();
				bufferEntrada = canalComunicacion.getInputStream();
				datos = new DataInputStream(bufferEntrada);
				String cadena = null;
				cadena = new String(datos.readUTF());
				String[] vect1 = cadena.split("\\*");
				if (vect1[0].equals("3")) {
					String[] vect2 = vect1[1].split(",");
					Empleado empleado = new Empleado(vect2[2], vect2[0], Integer.parseInt(vect2[1]));
					ServidorCentral.getIntansia().registrar(empleado);
					System.out.println("Registrado " + empleado.getNombre());
				} else {
					String[] vector = vect1[1].split(",");
					for (Empleado empleado : ServidorCentral.getIntansia().getEmpleadosOn().values()) {
						for (int i = 7; i < vector.length; i++) {
							if (ServidorCentral.getIntansia().getEmpleadosOn().containsKey(vector[i])) {
								ServidorCentral.getIntansia().envia(vector[i], cadena);
							}
						}
						ServidorCentral.getIntansia().envia(vector[1], cadena);
					}
				}
				datos.close();
				bufferEntrada.close();
				canalComunicacion.close();
				puerto.close();
			}
		} catch (IOException ex) {
			System.err.println("No se pudo iniciar la conexión con el puerto: " + puerto + ex.getCause());
		}
	}
	public int getPuerto() {
		return puerto;
	}
	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}	
}