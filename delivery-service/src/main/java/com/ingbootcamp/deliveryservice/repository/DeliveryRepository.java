package com.ingbootcamp.deliveryservice.repository;

import com.ingbootcamp.deliveryservice.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery,String> {

}
