package com.ingbootcamp.servicecommon.contracts;

import lombok.Data;

import java.util.Date;
@Data
public class ShipmentDto {

    private String id;
    private String sender;
    private String reciever;
    private Date sended_at;

}
