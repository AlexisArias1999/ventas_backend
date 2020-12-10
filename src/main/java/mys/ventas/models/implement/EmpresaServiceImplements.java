package mys.ventas.models.implement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import mys.ventas.models.dao.IEmpresaDAO;
import mys.ventas.models.entity.Empresa;
import mys.ventas.models.services.IEmpresaService;
import mys.ventas.util.RutasLocal;

@Service
public class EmpresaServiceImplements implements IEmpresaService{

	@Autowired
	private IEmpresaDAO empresaDAO;
	
	private RutasLocal RUTAS;
	
	@Override
	@Transactional(readOnly = true)
	public List<Empresa> findAll() {
		return (List<Empresa>)empresaDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Empresa findById(Long id_empresa) {
		return empresaDAO.findById(id_empresa).orElse(null);
	}

	@Override
	public Empresa save(Empresa empresa) {
		return empresaDAO.save(empresa);
	}

	@Override
	public ResponseEntity<?> uploadLogo(MultipartFile archivo, Long id_empresa) {
		Map<String, Object> response = new HashMap<>();
		Empresa empresa = empresaDAO.findById(id_empresa).orElse(null);
		String nombreArchivo = empresa.getRuc() + "_" + archivo.getOriginalFilename().replace(" ", "");
		Path rutaAchivo = Paths.get(RUTAS.EMPRESA_UPLOAD_LOGO).resolve(nombreArchivo).toAbsolutePath();
		if (!archivo.isEmpty()) {
			if (empresa.getImagen().isEmpty() || !empresa.getImagen().equals(rutaAchivo.toString())) {
				File ruta = rutaAchivo.toFile();
				if (ruta.exists()) {
					ruta.delete();
				}
				try {
					Files.copy(archivo.getInputStream(), rutaAchivo);
				} catch (IOException e) {
					response.put("mensaje", "Error al subir la imagen");
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				}
				String nombreFotoAnterior = empresa.getImagen();
				if (nombreFotoAnterior != null && nombreFotoAnterior.length() > 0) {
				Path rutaFotoAnterior = Paths.get(RUTAS.EMPRESA_UPLOAD_LOGO).resolve(nombreFotoAnterior).toAbsolutePath();
					File ArchivoAnterior = rutaFotoAnterior.toFile();
					if (ArchivoAnterior.exists() && ArchivoAnterior.canRead()) {
						ArchivoAnterior.delete();
					}
				}
				empresa.setImagen(rutaAchivo.toString());
				empresaDAO.save(empresa);
				response.put("empresa", empresa);
				response.put("mensaje", "Has subido correctamente la imagen: " + nombreArchivo);
			}
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
