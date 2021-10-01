package com.ingbootcamp.shipmentservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document
@Data
public class Shipment {
    @Id
    private String id;
    private String sender;
    private String reciever;
    private Date sended_at;
}
