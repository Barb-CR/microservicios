package com.microservice.celulares.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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
	
	@Autowired
	private Environment env;
	
	@Value("${server.port}")
	private Integer port;
	
	@GetMapping("/list")	/** Busca */
	public List<Celular> list(){
		return service.findAll().stream().map(cel ->{
			cel.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return cel;
		}).collect(Collectors.toList()); /** Mas a delante se hara la conexion de datos */
		
	}
	@GetMapping("/celular/{id}")		/** Elimina id*/
	public Celular detail(@PathVariable Long id){
		
		try {
			Thread.sleep(2000L); /** espera n cantidad de segundos para retornar la peticion que queremos*/
	}catch(InterruptedException e) {
		e.printStackTrace();
		} return service.findById(id);
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
