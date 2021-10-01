package com.ingbootcamp.shipmentservice.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document
public class Shipment {
    private String id;
    private String sender;
    private String reciever;
    private Date sended_at;
}
