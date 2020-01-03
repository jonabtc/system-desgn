package usuario;

public interface IEmpleado {
    public void envia(String ip, int puerto, String mensaje);
    public void recibe(int puerto);
    
}