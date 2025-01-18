# Pokemon-SOAP

¡Bienvenido a **Pokemon-SOAP**!  
Este proyecto implementa un **servicio SOAP** que proporciona información sobre Pokémon a través de los siguientes métodos:

## Métodos Disponibles
- **getAbilities**  
- **getBaseExperience**  
- **getHeldItems**  
- **getId**  
- **getLocationAreaEncounter**  
- **getName**  

### Descripción de los Métodos
Cada uno de estos métodos recibe un objeto que contiene el **nombre del Pokémon** que se desea consultar y devuelve un objeto con la información proporcionada por la API de [PokeAPI](https://pokeapi.co/).

---

## Instrucciones para Ejecutar el Proyecto

Para ejecutar el proyecto correctamente, asegúrate de contar con los siguientes programas instalados:

- **GIT**  
- **MAVEN**  
- **DOCKER**  

### Pasos para Ejecutar el Proyecto

A continuación, se detallan los pasos para ejecutar el proyecto en un entorno Ubuntu:

1. **Clonar el repositorio del proyecto:**
   ```bash
   git clone git@github.com:rodrigomtzb/pokemonsoap.git

2. **Moverse a la carpeta del proyecto:**
   ```bash
   cd pokemonsoap/
3. **Moverse a la carpeta del proyecto:**
   ```bash
   cd pokemonsoap/

4. **Cambiar a la rama master:**
   ```bash
   git checkout master
   
5. **Instalar las dependencias del proyecto:**
   ```bash
   mvn clean install
6. **Copiar los JARs necesarios para Axis2:**
Debido a que el repositorio de Axis2 no está disponible actualmente, copia los JARs proporcionados a la carpeta WEB-INF/lib del proyecto:
   ```bash
   cp -f src/main/webapp/allowed-jars/axis2-* src/main/webapp/WEB-INF/lib/

7. **Volver a instalar las dependencias y generar el archivo WAR:**
   ```bash
   mvn clean install

8. **Crear la imagen Docker usando el Dockerfile incluido:**
   ```bash
   sudo docker build -t ubuntu-tomcat-pokemonsoap .

9. **Crear y ejecutar el contenedor Docker:**
   ```bash
   sudo docker run -d -p 8180:8180 --name pokemonsoap-container ubuntu-tomcat-pokemonsoap

10. **Acceder al WSDL del servicio SOAP:**

Una vez que el contenedor esté ejecutándose, puedes obtener el WSDL del servicio en la siguiente URL:

[http://localhost:8180/pokemonsoap/services/PokemonService?wsdl](http://localhost:8180/pokemonsoap/services/PokemonService?wsdl)

---
### Información Adicional
Este proyecto utiliza la API pública de PokeAPI para proporcionar la información de los Pokémon.

Si encuentras problemas o tienes preguntas, no dudes en crear un Issue en el repositorio del proyecto en GitHub.

¡Gracias por usar Pokemon-SOAP! 🐾

