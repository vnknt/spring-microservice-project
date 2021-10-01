package com.ingbootcamp.servicecommon.contracts;


import lombok.Data;

import java.util.Date;
@Data
public class DeliveryDto {
    private String id ;
    private String shipment;
    private DeliveryStatus status;
    private Date created_at;
}
