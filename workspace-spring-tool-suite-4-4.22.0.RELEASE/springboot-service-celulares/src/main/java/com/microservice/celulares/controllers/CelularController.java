package com.microservice.celulares.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.celulares.entity.Celular;
import com.microservice.celulares.service.CelularService;

@RestController   /** Nos permite hacer inyecciones de dependencias una vez creamos repositorios */
public class CelularController {
	@Autowired
	private CelularService service;
	
	@GetMapping("/list")	/** Busca */
	public List<Celular> list(){
		return service.findAll(); /** Mas a delante se hara la conexion de datos */
		
	}
	
	@DeleteMapping("/celular/{id}")		/** Elimina id*/
	public ResponseEntity<Void> drop(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/celular") /** Post crea un registro nuevo */
	public ResponseEntity<Celular> add(@RequestBody Celular instance){
		Celular cel = service.save(instance);
		return new ResponseEntity<>(cel, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/celular/{id}")	/** actualiza datos */
	public ResponseEntity<Celular> update(@PathVariable Long id, @RequestBody Celular instance){
		if(service.existById(id)) {
			instance.setId(id);
			Celular cel = service.save(instance);
			return new ResponseEntity<>(cel, HttpStatus.OK);

		}else {
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
			
		}
	}
	
}