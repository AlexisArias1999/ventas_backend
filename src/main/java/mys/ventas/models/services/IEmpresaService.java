package mys.ventas.models.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import mys.ventas.models.entity.Empresa;

public interface IEmpresaService {

	public List<Empresa> findAll();
	
	public Empresa save(Empresa empresa);
	
	public Empresa findById(Long id_empresa);
	
	public ResponseEntity<?> uploadLogo(MultipartFile archivo, Long id_empresa);
	
}
