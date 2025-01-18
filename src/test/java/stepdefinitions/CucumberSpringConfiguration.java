package stepdefinitions;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

import io.cucumber.spring.CucumberContextConfiguration;

@ComponentScan(basePackages = {"com.pokemonsoap"}) // Escanea todos los beans de tu aplicación
@CucumberContextConfiguration
@ContextConfiguration( classes = CucumberSpringConfiguration.class )
public class CucumberSpringConfiguration {
}