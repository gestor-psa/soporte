package psa.soporte.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import psa.soporte.modelo.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}