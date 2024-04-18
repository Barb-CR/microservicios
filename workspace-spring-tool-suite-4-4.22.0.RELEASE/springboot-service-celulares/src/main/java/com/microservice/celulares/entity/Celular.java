package com.microservice.celulares.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "celulares")
public class Celular implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8550556477721078417L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	/** Inicio de declarcion de atributos */
	
	private String name;	
	
	private String marca;	/** Final de declarcion de atributos */
	
	@Column(name= "created_at")
	@Temporal(TemporalType.TIMESTAMP) /** Pone limite mas preciso de dia y tiempo*/
	private Date createdAt;

	@Transient /** Variable que no afecta a la base de datos*/
	private Integer port;
	
	
	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}
	

	public Long getId() {
		return id;		/** Gets and sets, para ponerlo facil click derecho al primer atributo, 
							source--> generate Getters and Setters*/
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
