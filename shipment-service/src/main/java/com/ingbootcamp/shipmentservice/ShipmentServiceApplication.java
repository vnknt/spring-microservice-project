package com.ingbootcamp.shipmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@EnableEurekaClient
public class ShipmentServiceApplication {
    public static void main(String[] args){
        SpringApplication.run(ShipmentServiceApplication.class ,args);
    }
}
