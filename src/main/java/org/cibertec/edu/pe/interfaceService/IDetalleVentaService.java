package org.cibertec.edu.pe.interfaceService;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.modelo.DetalleVenta;

public interface IDetalleVentaService {
	public List<DetalleVenta> listado();
	public Optional<DetalleVenta> buscar(int idDetalle);	
	public DetalleVenta guardar(DetalleVenta detalle);
	public void Suprimir(int idDetalle);

}
