package br.com.vl.carteiraamiga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"br.com.vl.carteiraamiga"})
@EntityScan({"br.com.vl.carteiraamiga.domain"})
@EnableJpaRepositories({"br.com.vl.carteiraamiga.infra.repository"})
public class CarteiraAmigaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarteiraAmigaApplication.class, args);
    }

}
