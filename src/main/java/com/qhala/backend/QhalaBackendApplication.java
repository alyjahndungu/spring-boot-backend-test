package com.qhala.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableAspectJAutoProxy
@EnableCaching
@Configuration
@EnableJpaRepositories(basePackages="com.qhala.backend.*")
@SpringBootApplication
public class QhalaBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(QhalaBackendApplication.class, args);
    }

}
