package io.github.MatheusFSantos.logistica.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.MatheusFSantos.logistica.domain.model.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@GetMapping
	public ResponseEntity<List<Cliente>> get() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		clientes.add(new Cliente(1L, "Matheus", "matheus.fs.contato@gmail.com", "111111111"));
		clientes.add(new Cliente(2L, "Lucas", "lucas@gmail.com", "222222222"));
		clientes.add(new Cliente(3L, "Joao", "joao@gmail.com", "333333333"));
		clientes.add(new Cliente(4L, "Antonio", "antonio@gmail.com", "444444444"));
		clientes.add(new Cliente(5L, "Miguel", "miguel@gmail.com", "555555555"));
		
		return ResponseEntity.ok().body(clientes);
	}
}