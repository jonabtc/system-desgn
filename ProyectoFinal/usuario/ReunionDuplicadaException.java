package usuario;

public class ReunionDuplicadaException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ReunionDuplicadaException(String mensaje) {
		super(mensaje);
	}
}
