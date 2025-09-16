package br.com.automica.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.automica.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID>  {

}
