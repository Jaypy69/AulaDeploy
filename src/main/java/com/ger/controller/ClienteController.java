package com.ger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ger.entities.Cliente;
import com.ger.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Controle de clientes")
@RestController
@RequestMapping("/cliente")
public class ClienteController {
	private final ClienteService clienteService;
	
	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	@Operation(summary="Trazer cliente por Id")
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscaClienteControlId(@PathVariable Long id) {
		Cliente cliente = clienteService.buscaClienteById(id);
		if (cliente != null) {
			return ResponseEntity.ok(cliente);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Cliente>> buscaTodosClienteControl() {
		List<Cliente> Cliente = clienteService.buscaTodosCliente();
		return ResponseEntity.ok(Cliente);
	}

	@PostMapping("/{id}")
	public ResponseEntity<Cliente> alterarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
		Cliente alterarCliente = clienteService.alterarCliente(id, cliente);
		if (alterarCliente != null) {
			return ResponseEntity.ok(alterarCliente);

		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Cliente> apagarCLiente(@PathVariable Long id) {
		boolean apagar = clienteService.apagarCliente(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}


