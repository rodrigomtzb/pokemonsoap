
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import stepdefinitions.CucumberSpringConfiguration;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/features", // Ruta donde se encuentran los archivos .feature
    glue = "stepdefinitions",           // Paquete donde están las definiciones de pasos
    plugin = {"pretty", "html:target/cucumber-reports.html"}, // Genera reportes
    monochrome = true                   // Mejora la legibilidad de la salida en consola
)
@ContextConfiguration(classes = CucumberSpringConfiguration.class) // Contexto de Spring
public class RunCucumberTest {
}