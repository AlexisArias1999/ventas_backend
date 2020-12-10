package mys.ventas.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Sunat {

	private RutasLocal RUTAS;
	
	public ResponseEntity<?> buscarRUC(String ruc) {
		String end_point = RUTAS.SUNAT_RUC + ruc;
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(end_point);			
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			Map<String, Object> mensaje = new HashMap<String, Object>();
			con.setRequestMethod("POST");
			con.setRequestProperty("Accept", "application/json");
			if (con.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP Error code : " + con.getResponseCode());
			}
			InputStreamReader in = new InputStreamReader(con.getInputStream());
			BufferedReader br = new BufferedReader(in);
			String output = "";
			if (br.readLine() == null) {
				mensaje.put("error", "Ruc no encontrado");
				mensaje.put("status", HttpStatus.NOT_FOUND.value());
				return new ResponseEntity<Map<String, Object>>(mensaje, HttpStatus.NOT_FOUND);
			}
			sb.append("{");
			while ((output = br.readLine()) != null) {
				sb.append(output);
			}
			con.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(sb, HttpStatus.OK);
	}
	
}
