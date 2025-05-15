package com.ger.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ger.entities.Venda;
import com.ger.repository.VendaRepository;

@Service
public class VendaService {
	private VendaRepository vendaRepository;
	@Autowired
	public VendaService (VendaService vendaservice) {
		this.vendaRepository = vendaRepository;
	}
	public List <Venda> buscaTodosVenda(){
		return vendaRepository.findAll();
	}
	public Venda buscaVendaById(Long id) {
		Optional <Venda> venda = vendaRepository.findById(id);
		return venda.orElse(null);
	}
	public Venda salvarVenda (Venda venda) {
		return vendaRepository.save(venda);
	}
	public Venda alterarVenda (Long id, Venda AlterarU) {
		Optional <Venda> existeVenda = vendaRepository.findById(id);
		if(existeVenda.isPresent()) {
			AlterarU.setId(id);
			return vendaRepository.save(AlterarU);
		}
		return null;
	}
	public boolean apagarVenda (Long id) {
		Optional <Venda> existeVenda = vendaRepository.findById(id);
		if(existeVenda.isPresent()) {
			vendaRepository.deleteById(id);
			return true;
		}
		return false;
	}
}