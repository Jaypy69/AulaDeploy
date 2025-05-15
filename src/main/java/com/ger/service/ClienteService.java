package com.ger.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ger.entities.Cliente;
import com.ger.repository.ClienteRepository;

@Service
public class ClienteService {
	private ClienteRepository clienteRepository;
@Autowired
public ClienteService (ClienteService clienteservice) {
	this.clienteRepository = clienteRepository;
}
public List <Cliente> buscaTodosCliente(){
	return clienteRepository.findAll();
}
public Cliente buscaClienteById(Long id) {
	Optional <Cliente> cliente = clienteRepository.findById(id);
	return cliente.orElse(null);
}
public Cliente salvarCliente (Cliente cliente) {
	return clienteRepository.save(cliente);
}
public Cliente alterarCliente (Long id, Cliente AlterarU) {
	Optional <Cliente> existeCliente = clienteRepository.findById(id);
	if(existeCliente.isPresent()) {
		AlterarU.setId(id);
		return clienteRepository.save(AlterarU);
	}
	return null;
}
public boolean apagarCliente (Long id) {
	Optional <Cliente> existeCliente = clienteRepository.findById(id);
	if(existeCliente.isPresent()) {
		clienteRepository.deleteById(id);
		return true;
	}
	return false;
}
}

