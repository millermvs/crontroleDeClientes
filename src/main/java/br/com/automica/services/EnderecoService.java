package br.com.automica.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.automica.dtos.CadastrarEnderecoRequestDto;
import br.com.automica.dtos.CadastrarEnderecoResponseDto;
import br.com.automica.entities.Endereco;
import br.com.automica.exceptions.CpfNaoEncontradoException;
import br.com.automica.repositories.ClienteRepository;
import br.com.automica.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public CadastrarEnderecoResponseDto cadastrarEndereco(CadastrarEnderecoRequestDto request) {

		var clienteFound = clienteRepository.findById(UUID.fromString(request.getIdCliente()));

		if (clienteFound.isEmpty())
			throw new CpfNaoEncontradoException();

		var novoEndereco = new Endereco();

		novoEndereco.setCep(request.getCep());
		novoEndereco.setRua(request.getRua());
		novoEndereco.setNumero(request.getNumero());
		novoEndereco.setBairro(request.getBairro());
		novoEndereco.setCidade(request.getCidade());
		novoEndereco.setEstado(request.getEstado());
		novoEndereco.setPais(request.getPais());
		novoEndereco.setComplemento(request.getComplemento());
		novoEndereco.setCliente(clienteFound.get());

		enderecoRepository.save(novoEndereco);

		var response = new CadastrarEnderecoResponseDto();
		response.setResposta("Novo endereço cadastrado para o cliente.");

		return response;

	}
}
