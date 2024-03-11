package org.cibertec.edu.pe.service;

import java.util.List;

import org.cibertec.edu.pe.interfaceService.ICiudadService;
import org.cibertec.edu.pe.repository.CiudadRepository;
import org.cibertec.edu.pe.modelo.Ciudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CiudadService implements ICiudadService{
	@Autowired
	private CiudadRepository ciudadRepository;
	
	@Override
	public List<Ciudad> Listado() {
		return (List<Ciudad>)ciudadRepository.findAll();
	}			
}
