package br.com.aldeir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
//@EnableConfigServer usando para incorporar um servidor,
//agora esse aplicativo é um servidor de aplicação
@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServiceApplication.class, args);
	}

}
