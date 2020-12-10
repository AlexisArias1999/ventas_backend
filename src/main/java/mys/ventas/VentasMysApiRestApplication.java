package mys.ventas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class VentasMysApiRestApplication implements CommandLineRunner{

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(VentasMysApiRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String password1 = "administrador";
		String password2 = "optometra";
		for(int i = 0; i < 1; i++) {
			String pass1 = bCryptPasswordEncoder.encode(password1);
			System.out.println(pass1); 
		}
		for(int j = 0; j < 1; j++) {
			String pass2 = bCryptPasswordEncoder.encode(password2);
			System.out.println(pass2);
		}
	}
	
}
