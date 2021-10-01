package com.ingbootcamp.deliveryservice.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import java.util.UUID;

public class Delivery {
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id ;
    private String shipment;
    private DeliveryStatus status;
}
