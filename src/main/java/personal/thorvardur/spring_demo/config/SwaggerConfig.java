package personal.thorvardur.spring_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    /**
     * Define what APIs we want to document.
     * @return A docket for Swagger.
     */
    @Bean
    public Docket restApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("personal.thorvardur.spring_demo"))
                .paths(regex("/api/users.*"))
                .build()
                .apiInfo(apiInfo());
    }

    /**
     * Basic documentation information.
     * @return API information.
     */
    private ApiInfo apiInfo(){
        Contact contact = new Contact("Þorvarður Bergmann Kjartansson", "https://github.com/thoddi", "thoddi@outlook.com");
        return new ApiInfoBuilder()
                .title("Spring Framework Demo API")
                .description("This simple, RESTful api service was created to demonstrate the use of Spring Framework. \nThe project has the simple function of managing accounts for the service.")
                .contact(contact)
                .license("GNU General Public License v3.0")
                .licenseUrl("https://github.com/thoddi/spring_demo/blob/master/LICENSE")
                .version("1.0")
                .build();
    }
}
