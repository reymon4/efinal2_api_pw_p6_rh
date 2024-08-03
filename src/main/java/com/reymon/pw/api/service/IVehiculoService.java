package com.reymon.pw.api.service;

import java.util.List;

import com.reymon.pw.api.service.dto.VehiculoDTO;
import com.reymon.pw.api.service.to.VehiculoTO;

public interface IVehiculoService {
	
	public void insert(VehiculoTO vehiculo);
	public VehiculoTO search(String placa);
	
	public List<VehiculoDTO> searchAll();
	
	public void delete(String placa);
	
	public void update(VehiculoTO vehiculo);

}
