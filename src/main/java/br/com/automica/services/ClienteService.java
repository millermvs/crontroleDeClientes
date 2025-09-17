package br.com.automica.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.automica.dtos.CadastrarClienteRequestDto;
import br.com.automica.dtos.CadastrarClienteResponseDto;
import br.com.automica.dtos.ConsultarCpfRequestDto;
import br.com.automica.dtos.ConsultarCpfResponseDto;
import br.com.automica.entities.Cliente;
import br.com.automica.entities.Endereco;
import br.com.automica.exceptions.CpfNaoEncontradoException;
import br.com.automica.repositories.ClienteRepository;
import br.com.automica.repositories.EnderecoRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public CadastrarClienteResponseDto cadastrarCliente(CadastrarClienteRequestDto request) {

		var cliente = new Cliente();
		cliente.setNome(request.getNome());
		cliente.setCpf(request.getCpf());
		cliente.setDataNasc(LocalDate.parse(request.getDataNasc()));
		cliente.setWhatsapp(request.getWhatsapp());
		cliente.setClienteAtivo(false);
		clienteRepository.save(cliente);

		var endereco = new Endereco();
		endereco.setCep(request.getCep());
		endereco.setRua(request.getRua());
		endereco.setNumero(request.getNumero());
		endereco.setBairro(request.getBairro());
		endereco.setCidade(request.getCidade());
		endereco.setEstado(request.getEstado());
		endereco.setPais(request.getPais());
		endereco.setComplemento(request.getComplemento());
		endereco.setCliente(cliente);

		enderecoRepository.save(endereco);

		var response = new CadastrarClienteResponseDto();
		response.setId(cliente.getId());
		response.setNome(cliente.getNome());
		response.setIdEndereco(endereco.getId());

		return response;

	}

	public ConsultarCpfResponseDto consultarCpf(ConsultarCpfRequestDto request) {
		if (clienteRepository.findCpf(request.getCpf()) == null) {
			throw new CpfNaoEncontradoException();
			
		} else {
			var cliente = clienteRepository.findCpf(request.getCpf());

			var response = new ConsultarCpfResponseDto();
			response.setId(cliente.getId());
			response.setCpf(cliente.getCpf());
			response.setNome(cliente.getNome());

			return response;
		}
	}
}
