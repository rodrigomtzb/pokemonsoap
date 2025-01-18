package com.pokemonsoap.spring.context.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.pokemonsoap.spring.service.intersector.AspectPokemonService;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.pokemonsoap")
@PropertySource("classpath:application.properties")
@EnableJpaRepositories(basePackages ={"com.pokemonsoap.spring.repository","com.pokemonsoap.spring.entity"})

@EnableAspectJAutoProxy
public class AppConfig {
	
	@Bean
    public AspectPokemonService aspectPokemonService() {
        return new AspectPokemonService(); // Registra el aspecto como un bean de Spring
    }
	
	 @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("org.h2.Driver");
	        dataSource.setUrl("jdbc:h2:~/testdb");
	        dataSource.setUsername("sa");
	        dataSource.setPassword("");
	        return dataSource;
	    }

	    @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
	        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	        em.setDataSource(dataSource);
	        em.setPackagesToScan("com.pokemonsoap.spring.entity");

	        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	        em.setJpaVendorAdapter(vendorAdapter);

	        Properties properties = new Properties();
	        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	        properties.setProperty("hibernate.hbm2ddl.auto", "update");
	        properties.setProperty("hibernate.show_sql", "true");
	        properties.setProperty("hibernate.format_sql", "true");
	        properties.setProperty("hibernate.use_sql_comments", "true");
	        em.setJpaProperties(properties);
	        
	        return em;
	    }

	    @Bean
	    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
	        JpaTransactionManager transactionManager = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(entityManagerFactory);
	        return transactionManager;
	    }
	
}
