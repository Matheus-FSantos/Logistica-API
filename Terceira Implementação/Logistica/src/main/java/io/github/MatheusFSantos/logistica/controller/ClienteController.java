package io.github.MatheusFSantos.logistica.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
		List<Cliente> clientes = clienteRepository.findAll();
		
		if(clientes != null)
			return ResponseEntity.ok().body(clientes);
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getById(@PathVariable Long id) {
		return clienteRepository.findById(id).map(cliente -> ResponseEntity.ok(cliente)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente post(@Valid @RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> put(@Valid @PathVariable Long id, @RequestBody Cliente updateCliente) {
		if(!clienteRepository.existsById(id)) 
			return ResponseEntity.notFound().build();
		
		updateCliente.setId(id);
		clienteRepository.save(updateCliente);
		
		return ResponseEntity.ok().body(updateCliente);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		if(!clienteRepository.existsById(id))
			return ResponseEntity.notFound().build();
		
		clienteRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}