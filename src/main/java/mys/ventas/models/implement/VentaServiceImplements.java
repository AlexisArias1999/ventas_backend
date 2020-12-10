package mys.ventas.models.implement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mys.ventas.models.dao.IVentaDAO;
import mys.ventas.models.entity.Venta;
import mys.ventas.models.services.IVentaService;
import mys.ventas.util.Email;
import mys.ventas.util.PDF;
import net.sf.jasperreports.engine.JRException;
@Service
public class VentaServiceImplements implements IVentaService {

	@Autowired
	private IVentaDAO ventaDAO;

	@Autowired
	private JavaMailSender javaMailSender;

	private Email UEmail = new Email();

	private PDF UPdf = new PDF();

	@Override
	@Transactional(readOnly = true)
	public List<Venta> findAll() {
		return (List<Venta>) ventaDAO.findAll();
	}

	@Override
	public Venta save(Venta venta) throws FileNotFoundException, JRException, MalformedURLException {
		Venta DVenta = ventaDAO.save(venta);
		List<Map<String, Object>> findVentaReporte = ventaDAO.FindVentaIdReporte(DVenta.getId_venta());
		FileSystemResource fileSR = UPdf.venta_A4_PDF(DVenta, findVentaReporte);
		UEmail.EmailVenta(fileSR, DVenta, "Gracias.", javaMailSender);
		return DVenta;
	}

	@Override
	public Venta findById(Long id_venta) {
		return ventaDAO.findById(id_venta).orElse(null);
	}

	@Override
	public List<Map<String, Object>> findAllVentasRecibos() {
		return ventaDAO.findAllVentasRecibos();
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<Resource> FindVentaIdReporteDescargarA4(Long id_venta)
			throws FileNotFoundException, JRException, MalformedURLException {
		Venta venta = ventaDAO.findById(id_venta).orElse(null);
		String nombrePDF = venta.getCliente().getId_cliente() + "-" + venta.getNro_documento() + "-"
				+ venta.getDocumento().getId_documento() + ".pdf";
//		Path rutaArchivo = Paths.get("src/main/resources/static/ventas/pdf/A4").resolve(nombrePDF).toAbsolutePath();
		Path rutaArchivo = Paths.get("../ventas/PDF/").resolve(nombrePDF).toAbsolutePath();
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + rutaArchivo + "\"");
		return new ResponseEntity<Resource>(new UrlResource(rutaArchivo.toUri()), headers, HttpStatus.OK);
	}

	@Override
	public Page<Map<String, Object>> PaginacionVentasRecibos(Pageable pageable) {
		return ventaDAO.PaginacionVentasRecibos(pageable);
	}

	@Override
	public void VisualizarPDFVentaA4(HttpServletResponse response, Long id_venta) throws IOException {
		response.setContentType("application/pdf");
		Venta venta = ventaDAO.findById(id_venta).orElse(null);
		String nombrePDF = venta.getCliente().getId_cliente() + "-" + venta.getNro_documento() + "-"
				+ venta.getDocumento().getId_documento() + ".pdf";
		Path rutaArchivo = Paths.get("src/main/resources/static/ventas/pdf/A4").resolve(nombrePDF).toAbsolutePath();
		InputStream inputStream = new FileInputStream(new File(rutaArchivo.toString()));
		int nRead;
		while ((nRead = inputStream.read()) != -1) {
			response.getWriter().write(nRead);
		}
	}

}
