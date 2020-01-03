package servidor;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

public class ServidorCentral implements IServidor {
	public static ServidorCentral intansia;
	private int puerto;
	private String ip;
	private HashMap<String, Empleado> empleadosOn = new HashMap<String, Empleado>();

	private Cliente clienteCom;
	private Servidor servidorCom;

	private ServidorCentral() throws UnknownHostException {
		this.puerto = 8989;
		this.ip = InetAddress.getLocalHost().getHostAddress();
		servidorCom = new Servidor(puerto);
		servidorCom.start();
	}

	public static ServidorCentral getIntansia() throws UnknownHostException {
		if (intansia == null) {
			intansia = new ServidorCentral();
		}
		return intansia;
	}

	public HashMap<String, Empleado> getEmpleadosOn() {
		return empleadosOn;
	}

	public void setEmpleadosOn(HashMap<String, Empleado> empleadosOn) {
		this.empleadosOn = empleadosOn;
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

	@Override
	public void registrar(Empleado empleado) {
		empleadosOn.put(empleado.getNombre(), empleado);
	}

	@Override
	public void envia(String nombre, String respuesta) {
		if (empleadosOn.containsKey(nombre)) {
			Empleado empleado = empleadosOn.get(nombre);
			clienteCom = new Cliente(empleado.getIp(), empleado.getPuerto());
			try {
				System.out.println("enviador " + respuesta + " a " + empleado.getNombre() + " " + empleado.getIp() + " "
						+ empleado.getPuerto());

				clienteCom.enviar(respuesta);
				return;
			} catch (IOException ex) {
				System.err.println("Imposible enviar respuesta " + ex.getCause() + " " + ex.getMessage());
				return;
			}
		}
		System.err.println("El usuario no existe");
	}
}
