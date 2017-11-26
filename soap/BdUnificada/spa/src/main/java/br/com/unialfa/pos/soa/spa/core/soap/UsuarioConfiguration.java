package br.com.unialfa.pos.soa.spa.core.soap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class UsuarioConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("servicos.wsdl");
		return marshaller;
	}

	@Bean
	public UsuariosSoapClient usuariosSoapClient(Jaxb2Marshaller marshaller) {
		UsuariosSoapClient client = new UsuariosSoapClient();
		client.setDefaultUri("http://localhost:9000/ws/usuarios");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
