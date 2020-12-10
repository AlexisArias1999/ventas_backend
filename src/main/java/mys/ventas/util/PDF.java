package mys.ventas.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.core.io.FileSystemResource;

import mys.ventas.models.entity.Cotizacion;
import mys.ventas.models.entity.Venta;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class PDF {

	private RutasLocal URutas = new RutasLocal();

	private ReportesLocal UReportes = new ReportesLocal();
	
	public FileSystemResource venta_A4_PDF(Venta venta, List<Map<String, Object>> reporte)
			throws FileNotFoundException, JRException, MalformedURLException {
		String ruta = Paths.get(URutas.RESOURCES_STATIC).resolve("Screenshot_1.png").toAbsolutePath().toString();
		Map<String, Object> parametro = new HashMap<String, Object>();
		parametro.put("logo", ruta);
		Path rutaReporte = Paths.get(URutas.REPORTES).resolve(UReportes.REPORTE_VENTA_A4).toAbsolutePath();
		JasperReport jasper = JasperCompileManager.compileReport(rutaReporte.toFile().getAbsolutePath());
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(reporte);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasper, parametro, ds);
		String nombrePDF = venta.getCliente().getId_cliente() + "-" + venta.getNro_documento() + ".pdf";
		Path rutaArchivo = Paths.get(URutas.REPORTE_VENTA_GUARDAR).resolve(nombrePDF).toAbsolutePath();
		JasperExportManager.exportReportToPdfFile(jasperPrint, rutaArchivo.toString());
		FileSystemResource fileSR = new FileSystemResource(new File(rutaArchivo.toString()));
		return fileSR;
	}
	
	public FileSystemResource cotizacion_A4_PDF(Cotizacion cotizacion, List<Map<String, Object>> reporte)
			throws FileNotFoundException, JRException, MalformedURLException {
		String ruta = Paths.get(URutas.RESOURCES_STATIC).resolve("Screenshot_1.png").toAbsolutePath().toString();
		Map<String, Object> parametro = new HashMap<String, Object>();
		parametro.put("logo", ruta);
		Path rutaReporte = Paths.get(URutas.REPORTES).resolve(UReportes.REPORTE_COTIZACION_A4).toAbsolutePath();
		JasperReport jasper = JasperCompileManager.compileReport(rutaReporte.toFile().getAbsolutePath());
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(reporte);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasper, parametro, ds);
		String nombrePDF = cotizacion.getCliente().getId_cliente() + "-" + cotizacion.getNro_documento() + ".pdf";
		Path rutaArchivo = Paths.get(URutas.REPORTE_COTIZACION_GUARDAR).resolve(nombrePDF).toAbsolutePath();
		JasperExportManager.exportReportToPdfFile(jasperPrint, rutaArchivo.toString());
		FileSystemResource fileSR = new FileSystemResource(new File(rutaArchivo.toString()));
		return fileSR;
	}

}
