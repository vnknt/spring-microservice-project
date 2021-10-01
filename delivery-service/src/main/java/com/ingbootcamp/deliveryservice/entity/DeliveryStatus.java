package com.ingbootcamp.deliveryservice.entity;

import lombok.Getter;

@Getter
public enum DeliveryStatus {
    DELIVERED("DELIVERED"),
    UNDELIVERED("UNDELIVERED");



    private String label;
    DeliveryStatus(String label){
        this.label = label;
    }
}
