package psa.soporte.excepcion;

public class ClienteNoEncontradoExcepcion extends RuntimeException {

    public ClienteNoEncontradoExcepcion(Long id) {
        super("No se encontró el cliente con id " + id);
    }
}