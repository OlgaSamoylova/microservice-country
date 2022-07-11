package ru.skillbox.diplom.alpha.microservice.country;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import ru.skillbox.diplom.alpha.library.core.annotation.EnableOpenFeign;
import ru.skillbox.diplom.alpha.library.core.annotation.SecurityCoreConfig;

/**
 * Application
 *
 * @author Olga Samoylova
 */

@EnableCaching
@EnableOpenFeign
@SecurityCoreConfig
@EnableDiscoveryClient
@SpringBootApplication
public class Application{
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
