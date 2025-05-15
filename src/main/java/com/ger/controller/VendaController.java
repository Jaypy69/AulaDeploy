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

import com.ger.entities.Venda;
import com.ger.service.VendaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Controle de vendas")
@RestController
@RequestMapping("/venda")
public class VendaController {
	private final VendaService vendaService;

	@Autowired
	public VendaController(VendaService vendaService) {
		this.vendaService = vendaService;
	}
	@Operation(summary="Trazer vendas por Id")
	@GetMapping("/{id}")
	public ResponseEntity<Venda> buscaVendaControlId(@PathVariable Long id) {
		Venda venda = vendaService.buscaVendaById(id);
		if (venda != null) {
			return ResponseEntity.ok(venda);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Venda>> buscaTodosVendaControl() {
		List<Venda> Venda = vendaService.buscaTodosVenda();
		return ResponseEntity.ok(Venda);
	}

	@PostMapping("/{id}")
	public ResponseEntity<Venda> alterarVenda(@PathVariable Long id, @RequestBody Venda venda) {
		Venda alterarVenda = vendaService.alterarVenda(id, venda);
		if (alterarVenda != null) {
			return ResponseEntity.ok(alterarVenda);

		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Venda> apagarVenda(@PathVariable Long id) {
		boolean apagar = vendaService.apagarVenda(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}