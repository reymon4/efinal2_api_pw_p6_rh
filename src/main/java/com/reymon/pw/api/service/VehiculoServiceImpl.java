package com.reymon.pw.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reymon.pw.api.repository.IVehiculoRepository;
import com.reymon.pw.api.repository.model.Vehiculo;
import com.reymon.pw.api.service.dto.VehiculoDTO;
import com.reymon.pw.api.service.to.VehiculoTO;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

	@Autowired
	private IVehiculoRepository vehiculoRepository;

	@Override
	public void insert(VehiculoTO vehiculo) {
		// TODO Auto-generated method stub
		this.vehiculoRepository.insert(this.converterTO(vehiculo));
	}

	@Override
	public VehiculoTO search(String placa) {
		// TODO Auto-generated method stub
		return this.converter(this.vehiculoRepository.search(placa));
	}

	@Override
	public List<VehiculoDTO> searchAll() {
		// TODO Auto-generated method stub
		List<Vehiculo> list = this.vehiculoRepository.searchAll();
		List<VehiculoDTO> listTO = new ArrayList<>();
			for(Vehiculo e: list) {
				listTO.add(this.converterDTO(e));
			}
		return listTO;
	}

	@Override
	public void delete(String placa) {
		// TODO Auto-generated method stub
		this.vehiculoRepository.delete(placa);
	}

	@Override
	public void update(VehiculoTO vehiculo) {
		// TODO Auto-generated method stub
		this.vehiculoRepository.update(this.converterTO(vehiculo));
	}

	public VehiculoTO converter(Vehiculo vehi) {
		VehiculoTO to = new VehiculoTO();
		to.setColor(vehi.getColor());
		to.setId(vehi.getId());
		to.setMarca(vehi.getMarca());
		to.setModelo(vehi.getModelo());
		to.setPlaca(vehi.getPlaca());
		to.setPrecio(vehi.getPrecio());
		return to;
	}

	public VehiculoDTO converterDTO(Vehiculo vehi) {
		VehiculoDTO to = new VehiculoDTO();

		to.setMarca(vehi.getMarca());
		to.setModelo(vehi.getModelo());
		to.setPlaca(vehi.getPlaca());

		return to;
	}

	public Vehiculo converterTO(VehiculoTO vehi) {

		Vehiculo to = new Vehiculo();
		to.setColor(vehi.getColor());
		to.setId(vehi.getId());
		to.setMarca(vehi.getMarca());
		to.setModelo(vehi.getModelo());
		to.setPlaca(vehi.getPlaca());
		to.setPrecio(vehi.getPrecio());
		return to;
	}

}
