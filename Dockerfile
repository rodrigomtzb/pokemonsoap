# Usa Ubuntu 22.04.5 LTS como base
FROM ubuntu:22.04

# Mantenedor de la imagen
LABEL maintainer="tu_email@example.com"

# Actualiza los paquetes y asegura que los scripts se ejecuten sin interacción
ENV DEBIAN_FRONTEND=noninteractive

# Actualiza e instala los paquetes necesarios
RUN apt-get update && apt-get install -y \
    openjdk-11-jdk wget unzip && \
    apt-get clean

# Establece la variable de entorno JAVA_HOME
ENV JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
ENV PATH="$JAVA_HOME/bin:$PATH"

# Descarga y descomprime Apache Tomcat 9.0.98
RUN wget https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.98/bin/apache-tomcat-9.0.98.tar.gz -P /tmp && \
    tar -xvzf /tmp/apache-tomcat-9.0.98.tar.gz -C /opt && \
    rm /tmp/apache-tomcat-9.0.98.tar.gz

# Renombra el directorio de Tomcat para facilitar su referencia
RUN mv /opt/apache-tomcat-9.0.98 /opt/tomcat

# Copia el archivo pokemonsoap.war al directorio webapps de Tomcat
COPY target/pokemonsoap-0.0.1-SNAPSHOT.war /opt/tomcat/webapps/pokemonsoap.war

# Establece permisos de ejecución para los scripts de Tomcat
RUN chmod +x /opt/tomcat/bin/*.sh

# Establece la variable de entorno CATALINA_HOME
ENV CATALINA_HOME=/opt/tomcat
ENV PATH="$CATALINA_HOME/bin:$PATH"

# Exponer el puerto 8180
EXPOSE 8180

# Cambia el puerto de Tomcat a 8180
RUN sed -i 's/port="8080"/port="8180"/g' /opt/tomcat/conf/server.xml

# Comando para iniciar Tomcat
CMD ["/opt/tomcat/bin/catalina.sh", "run"]
