package org.cibertec.edu.pe.controller;

import java.util.ArrayList;
import java.util.List;

import org.cibertec.edu.pe.interfaceService.ICiudadService;
import org.cibertec.edu.pe.interfaceService.IDetalleVentaService;
import org.cibertec.edu.pe.interfaceService.IVentaService;
import org.cibertec.edu.pe.modelo.Ciudad;
import org.cibertec.edu.pe.modelo.DetalleVenta;
import org.cibertec.edu.pe.modelo.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"boletosAgregados", "venta"})
public class VuelosControlador {

    @Autowired
    private ICiudadService ciudadRepository;

    @Autowired
    private IDetalleVentaService detalleVentaService;

    @Autowired
    private IVentaService ventaService;
	
		
	@GetMapping("/")
	    public String listar(Model modelo) {
	        List<Ciudad> ciudades = ciudadRepository.Listado();
	        modelo.addAttribute("ciudades", ciudades);
	        modelo.addAttribute("venta", new Venta()); // Agregar un objeto Venta vacío para el formulario
	        return "index";
	    }
	
	@PostMapping("/agregar-boleto")
    public String agregarBoleto(@ModelAttribute("detalleVenta") DetalleVenta detalleVenta,
                                @ModelAttribute("venta") Venta venta,
                                Model modelo) {
		DetalleVenta nuevoDetalle = new DetalleVenta();
		
		detalleVenta.setCiudadOrigen(nuevoDetalle.getCiudadOrigen());
		detalleVenta.setCiudadDestino(nuevoDetalle.getCiudadDestino());		
		detalleVenta.setFechaViaje(nuevoDetalle.getFechaViaje());
		detalleVenta.setFechaRetorno(nuevoDetalle.getFechaRetorno());
		
	    // Configurar la relación con la venta
	    nuevoDetalle.setVenta(venta);
	    detalleVenta.setCantidad(detalleVenta.getCantidad());
	    // Paso 3: Calcular el subtotal (Ejemplo: cantidad * precioUnitario)
	    Double precioUnitario = 50.0; // Reemplaza con la lógica real para obtener el precio unitario
	    detalleVenta.setSubTotal(detalleVenta.getCantidad() * precioUnitario);
        
        // Agregar detalleVenta a la lista en sesión
        List<DetalleVenta> detallesAgregados = (List<DetalleVenta>) modelo.getAttribute("boletosAgregados");
        if (detallesAgregados == null) {
            detallesAgregados = new ArrayList<>();
            modelo.addAttribute("boletosAgregados", detallesAgregados);
        }
        detallesAgregados.add(detalleVenta);
        // Limpiar detalleVenta para el próximo boleto
        modelo.addAttribute("detalleVenta", new DetalleVenta());
        return "index"; // Redirige a la página principal después de agregar un boleto
    }

}
