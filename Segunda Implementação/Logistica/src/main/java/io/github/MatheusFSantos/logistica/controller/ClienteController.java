package io.github.MatheusFSantos.logistica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.MatheusFSantos.logistica.domain.model.Cliente;
import io.github.MatheusFSantos.logistica.domain.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> get() {
		return ResponseEntity.ok().body(clienteRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Cliente>> getById(@PathVariable Long id) {
		return ResponseEntity.ok().body(clienteRepository.findById(id));
	}
	
	@GetMapping("/nomes/{nome}")
	public ResponseEntity<List<Cliente>> getByName(@PathVariable String nome){
		return ResponseEntity.ok().body(clienteRepository.findByNome(nome));
	}
	
	@GetMapping("/nomes/like/{nome}")
	public ResponseEntity<List<Cliente>> getByNameLike(@PathVariable String nome){
		return ResponseEntity.ok().body(clienteRepository.findByNomeContaining(nome));
	}
}