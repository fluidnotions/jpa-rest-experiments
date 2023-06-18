package com.example.jpainvestigation.autorest.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "libraryEntityManagerFactory",
        transactionManagerRef = "libraryTransactionManager"
)
public class RepositoryConfig {

    private static final Logger logger = LoggerFactory.getLogger(RepositoryConfig.class);

    @Value("${auto-rest.entity-packages}")
    private String entityPackages;

    @Autowired
    private Environment env;

    @Primary
    @Bean
    public DataSource libraryDataSource() {
        String url = env.getProperty("spring.datasource.url");
        String username = env.getProperty("spring.datasource.username");
        String password = env.getProperty("spring.datasource.password");
        String driverClassName = env.getProperty("spring.datasource.driver-class-name");

        logger.info("DataSource URL: {}", url);
        logger.info("DataSource Username: {}", username);
        // Don't log the password for security reasons
        logger.info("DataSource Driver Class Name: {}", driverClassName);

        return DataSourceBuilder.create()
                .url(url)
                .username(username)
                .password(password)
                .driverClassName(driverClassName)
                .build();
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean libraryEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("libraryDataSource") DataSource dataSource) {

         var factory = builder
                .dataSource(dataSource)
                .packages(entityPackages)
                .persistenceUnit("libraryPersistenceUnit")
                .build();
         return factory;
    }

    @Primary
    @Bean
    public PlatformTransactionManager libraryTransactionManager(@Qualifier("libraryEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Primary
    @Bean
    public EntityManager libraryEntityManager(EntityManagerFactoryBuilder builder) {
        var em = libraryEntityManagerFactory(builder, libraryDataSource()).getObject().createEntityManager();
        return em;
    }

}

