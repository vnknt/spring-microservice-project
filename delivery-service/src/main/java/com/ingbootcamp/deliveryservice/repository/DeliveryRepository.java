package com.ingbootcamp.deliveryservice.repository;

import com.ingbootcamp.deliveryservice.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery,String> {

}
