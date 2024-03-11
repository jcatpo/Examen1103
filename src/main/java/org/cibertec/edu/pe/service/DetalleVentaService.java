package org.cibertec.edu.pe.service;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.interfaceService.IDetalleVentaService;
import org.cibertec.edu.pe.modelo.DetalleVenta;
import org.springframework.stereotype.Service;

@Service
public class DetalleVentaService implements IDetalleVentaService{

	@Override
	public List<DetalleVenta> listado() {		
		return null;
	}

	@Override
	public Optional<DetalleVenta> buscar(int idDetalle) {		
		return Optional.empty();
	}

	@Override
	public DetalleVenta guardar(DetalleVenta detalle) {		
		return null;
	}

	@Override
	public void Suprimir(int idDetalle) {		
	}

}
