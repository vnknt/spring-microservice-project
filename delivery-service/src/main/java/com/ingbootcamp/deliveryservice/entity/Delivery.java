package com.ingbootcamp.deliveryservice.entity;

import com.ingbootcamp.servicecommon.contracts.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "deliveries")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of={"id"})
public class Delivery {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="id")
    private String id ;

    @Column(name="shipment")
    private String shipment;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    @CreatedDate
    @Column(name="created_at")
    private Date created_at;

}
