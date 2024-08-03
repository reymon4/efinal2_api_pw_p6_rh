package com.reymon.pw.api.repository;

import java.util.List;

import com.reymon.pw.api.repository.model.Vehiculo;

public interface IVehiculoRepository {
	
	public void insert(Vehiculo vehiculo);
	public Vehiculo search(String placa);
	
	public List<Vehiculo> searchAll();
	
	public void delete(String placa);
	
	public void update(Vehiculo vehiculo);

}
