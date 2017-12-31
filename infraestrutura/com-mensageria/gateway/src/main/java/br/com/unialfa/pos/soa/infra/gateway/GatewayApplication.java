package br.com.unialfa.pos.soa.infra.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/usuarios/**")
					.rewritePath("/usuarios/(?<parteQueMeInteressa>.*)", "/${parteQueMeInteressa}")
					.uri("lb://usuarios"))
				.route(r -> r.path("/tarefas/**")
					.rewritePath("/tarefas/(?<parteQueMeInteressa>.*)", "/${parteQueMeInteressa}")
					.uri("lb://tarefas"))
//				.route(r -> r.path("/mensageria/**")
//						.rewritePath("/mensageria/(?<parteQueMeInteressa>.*)", "/${parteQueMeInteressa}")
//						.uri("ws://localhost:8800"))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
