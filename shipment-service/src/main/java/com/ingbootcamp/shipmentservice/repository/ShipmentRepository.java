package com.ingbootcamp.shipmentservice.repository;

import com.ingbootcamp.shipmentservice.entity.Shipment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends MongoRepository<Shipment,String> {

}
