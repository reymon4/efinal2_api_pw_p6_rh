package com.reymon.pw.api.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reymon.pw.api.service.IVehiculoService;
import com.reymon.pw.api.service.dto.VehiculoDTO;
import com.reymon.pw.api.service.to.VehiculoTO;

@Controller
@CrossOrigin
@RequestMapping(path = "/vehiculos")
public class VehiculoControllerRestful {
	//TEST 2
	@Autowired
	private IVehiculoService vehiculoService;

	@GetMapping(path = "/{placa}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VehiculoTO> search(@PathVariable String placa) {
		return ResponseEntity.status(HttpStatus.OK).body(this.vehiculoService.search(placa));

	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VehiculoTO> save(@RequestBody VehiculoTO vehi) {
		this.vehiculoService.insert(vehi);
		return ResponseEntity.status(HttpStatus.OK).body(this.vehiculoService.search(vehi.getPlaca()));

	}

	@DeleteMapping(path = "/{placa}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable String placa) {
		this.vehiculoService.delete(placa);
		return ResponseEntity.status(HttpStatus.OK).body("Eliminado!");

	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VehiculoDTO>> buscarTodos() {
		List<VehiculoDTO> list = this.vehiculoService.searchAll();
		for (VehiculoDTO to : list) {
			Link link = linkTo(methodOn(VehiculoControllerRestful.class).search(to.getPlaca())).withSelfRel();
			to.add(link);
		}
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}

}
