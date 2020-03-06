package co.simplon.aliment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

// TODO
// Security
// https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api

@SpringBootApplication
@EnableSwagger2WebMvc
// TODO check impact of commenting out the following annotation
@Import(SpringDataRestConfiguration.class)
public class AlimentApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlimentApplication.class, args);
    }

}
