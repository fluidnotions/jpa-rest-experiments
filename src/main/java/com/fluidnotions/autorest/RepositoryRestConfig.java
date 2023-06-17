package com.fluidnotions.autorest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.RepositoryDetectionStrategy;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;


@Configuration
public class RepositoryRestConfig {

    private static final Logger logger = LoggerFactory.getLogger(RepositoryRestConfig.class);

    @Value("${auto-rest.rest-repo-package}")
    private String restRepoPackage;


    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer() {
        return new RepositoryRestConfigurer() {
            @Override
            public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
                config.setRepositoryDetectionStrategy(new RepositoryDetectionStrategy(){
                    @Override
                    public boolean isExported(RepositoryMetadata metadata) {
                        var canonicalName = metadata.getRepositoryInterface().getCanonicalName();
                        String packageName = null;
                        int lastDotIndex = canonicalName.lastIndexOf(".");
                        if (lastDotIndex != -1) {
                            packageName = canonicalName.substring(0, lastDotIndex);
                        }
                        logger.info("packageName: {}", packageName);
                        return restRepoPackage.equals(packageName);
                    }
                });
            }
        };
    }
}


