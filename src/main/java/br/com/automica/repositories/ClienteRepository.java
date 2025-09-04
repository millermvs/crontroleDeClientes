package br.com.automica.repositories;

import br.com.automica.entities.Cliente;
import br.com.automica.entities.Endereco;
import br.com.automica.factories.ConnectionFactory;

public class ClienteRepository {
	public void insert(Cliente cliente, Endereco endereco) throws Exception {

		var sqlEndereco = """
				insert into enderecos (id, cep, rua, numero, bairro, cidade, estado, pais, complemento)
				values (?, ?, ?, ?, ?, ?, ?, ?, ?)
				""";

		var connection = ConnectionFactory.getConnection();

		// Salvando Endereco
		var statementEndereco = connection.prepareStatement(sqlEndereco);

		statementEndereco.setObject(1, endereco.getId());
		statementEndereco.setString(2, endereco.getCep());
		statementEndereco.setString(3, endereco.getRua());
		statementEndereco.setString(4, endereco.getNumero());
		statementEndereco.setString(5, endereco.getBairro());
		statementEndereco.setString(6, endereco.getCidade());
		statementEndereco.setString(7, endereco.getEstado());
		statementEndereco.setString(8, endereco.getPais());
		statementEndereco.setString(9, endereco.getComplemento());
		statementEndereco.execute();

		// Salvando cliente
		var sqlCliente = """
				insert into clientes (id, nome, cpf, data_nasc, telefone, endereco_id)
				values (?, ?, ?, ?, ?, ?)
				 """;

		var statementCliente = connection.prepareStatement(sqlCliente);

		statementCliente.setObject(1, cliente.getId());
		statementCliente.setString(2, cliente.getNome());
		statementCliente.setString(3, cliente.getCpf());
		statementCliente.setDate(4, java.sql.Date.valueOf(cliente.getDataNasc()));
		statementCliente.setString(5, cliente.getTelefone());
		statementCliente.setObject(6, endereco.getId());
		statementCliente.execute();
		connection.close();

	}

}
