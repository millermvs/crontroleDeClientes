package br.com.automica.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.automica.entities.Cliente;
import br.com.automica.entities.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	@Query("""
			SELECT e FROM Endereco e
			WHERE e.cliente = :pcliente
			""")

	List<Endereco> findEnderecos(@Param("pcliente") Cliente cliente_id);
}
