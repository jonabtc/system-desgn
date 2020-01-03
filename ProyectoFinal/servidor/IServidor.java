package servidor;

public interface IServidor {
    public abstract void registrar(Empleado empleado);
    public abstract void envia(String nombre, String mensaje);
}
