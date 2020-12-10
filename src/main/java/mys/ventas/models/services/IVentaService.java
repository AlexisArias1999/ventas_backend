package mys.ventas.models.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import mys.ventas.models.entity.Venta;
import net.sf.jasperreports.engine.JRException;

public interface IVentaService {

	public List<Venta> findAll();

	public List<Map<String, Object>> findAllVentasRecibos();

	public Page<Map<String, Object>> PaginacionVentasRecibos(Pageable pageable);

	public ResponseEntity<Resource> FindVentaIdReporteDescargarA4(Long id_venta)
			throws FileNotFoundException, JRException, MalformedURLException;

//	public void EnviarCorreoVenta(Long id_venta, String mensaje) throws MessagingException, FileNotFoundException, MalformedURLException, JRException;

	public Venta findById(Long id_venta);

	public Venta save(Venta venta) throws FileNotFoundException, MalformedURLException, JRException;

	public void VisualizarPDFVentaA4(HttpServletResponse response, Long id_venta) throws IOException;
}
