Feature: Probar métodos de PokemonService
  Como desarrollador
  Quiero asegurarme de que los métodos de PokemonService funcionan correctamente
  Usando mocks para simular PokemonAPIService

  Scenario: Obtener las habilidades de un Pokémon
    Given un Pokémon llamado "pikachu"
    When solicito las habilidades del Pokémon
    Then debería recibir una respuesta con las habilidades "static" y "lightning-rod"

  Scenario: Obtener la experiencia base de un Pokémon
    Given un Pokémon llamado "charizard"
    When solicito la experiencia base del Pokémon
    Then debería recibir una respuesta con la experiencia base 240
