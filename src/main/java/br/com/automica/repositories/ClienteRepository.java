package br.com.automica.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.automica.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

	@Query("""
			SELECT c FROM Cliente c
			WHERE c.cpf = :pCpf
			""")
	Cliente findCpf(@Param("pCpf") String request);

}
