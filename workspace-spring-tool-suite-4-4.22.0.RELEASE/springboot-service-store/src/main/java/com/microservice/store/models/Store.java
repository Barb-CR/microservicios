package com.microservice.store.models;

public class Store {

	private Celular cel;
	
	private Integer cantidad;
	
	public Store() {
		
	}

	public Celular getCel() {
		return cel;
	}

	public void setCel(Celular cel) {
		this.cel = cel;
	}

	public Store(Celular cel, Integer cantidad) {
		super();
		this.cel = cel;
		this.cantidad = cantidad;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
}
