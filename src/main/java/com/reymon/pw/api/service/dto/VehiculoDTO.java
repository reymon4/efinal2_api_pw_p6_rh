package com.reymon.pw.api.service.dto;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class VehiculoDTO extends RepresentationModel<VehiculoDTO> implements Serializable{

	private static final long serialVersionUID = 2L;

	private String placa;

	private String modelo;
	private String marca;
	
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
	
}
