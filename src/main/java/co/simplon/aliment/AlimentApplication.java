package co.simplon.aliment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AlimentApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlimentApplication.class, args);
    }

}
