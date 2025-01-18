package stepdefinitions;

import com.pokemonsoap.jaxws.beans.*;
import com.pokemonsoap.jaxws.service.PokemonService;
import com.pokemonsoap.spring.service.PokemonAPIService;
import io.cucumber.java.en.*;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = CucumberSpringConfiguration.class) // Usa la configuración de Spring
public class PokemonServiceStepDefinitions {

	
    private PokemonService pokemonService;
    private PokemonSOAPRequest request;
    private AbilitiesResponse abilitiesResponse;
    private BaseExperienceResponse baseExperienceResponse;

    @Given("un Pokémon llamado {string}")
    public void unPokemonLlamado(String pokemonName) {
    	try {
    		System.out.println("El Pokémon recibido en el paso es: " + pokemonName);
	        // Crear una solicitud
	        request = new PokemonSOAPRequest();
	        request.setPokemonName(pokemonName);
	
	        // Mockear el servicio PokemonAPIService
	        PokemonAPIService mockedService = Mockito.mock(PokemonAPIService.class);
	
	        // Configurar comportamiento del mock según el nombre del Pokémon
	        if (pokemonName.equals("pikachu")) {
	            AbilitiesResponse response = new AbilitiesResponse();
	            
	            AbilityDetail abilityDetail = new AbilityDetail();
	            
	            Ability ability = new Ability();
	            ability.setName("static");
	            
	            abilityDetail.setAbility(ability);
	            
	            List<AbilityDetail> abilityDetailLst = new ArrayList<AbilityDetail>();
	            
	            abilityDetailLst.add(abilityDetail);
	            
	            abilityDetail = new AbilityDetail();
	            
	            ability = new Ability();
	            ability.setName("lightning-rod");
	            
	            abilityDetail.setAbility(ability);
	            
	            abilityDetailLst.add(abilityDetail);
	            
	            response.setAbilities(abilityDetailLst);
	            Mockito.when(mockedService.getAbilities(request)).thenReturn(response);
	        }
	
	        if (pokemonName.equals("charizard")) {
	            BaseExperienceResponse response = new BaseExperienceResponse();
	            response.setBase_experience(240);
	            Mockito.when(mockedService.getBaseExperience(request)).thenReturn(response);
	        }
	
	        // Inyectar el mock en PokemonService
	        pokemonService = new PokemonService();
	        pokemonService.service = mockedService;
        
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }

    @When("solicito las habilidades del Pokémon")
    public void solicitoLasHabilidadesDelPokemon() {
        abilitiesResponse = pokemonService.getAbilities(request);
    }

    @When("solicito la experiencia base del Pokémon")
    public void solicitoLaExperienciaBaseDelPokemon() {
        baseExperienceResponse = pokemonService.getBaseExperience(request);
    }

    @Then("debería recibir una respuesta con las habilidades {string} y {string}")
    public void deberiaRecibirUnaRespuestaConLasHabilidades(String habilidad1, String habilidad2) {
    	List<AbilityDetail> abilities = abilitiesResponse.getAbilities();
        assertEquals(habilidad1, abilities.get(0).getAbility().getName());
        assertEquals(habilidad2, abilities.get(1).getAbility().getName());
    }

    @Then("debería recibir una respuesta con la experiencia base {int}")
    public void deberiaRecibirUnaRespuestaConLaExperienciaBase(Integer expectedExperience) {
        assertEquals(expectedExperience, baseExperienceResponse.getBase_experience());
    }
}