package com.ingbootcamp.servicecommon.clients;

import com.ingbootcamp.servicecommon.contracts.ShipmentDto;
import com.ingbootcamp.servicecommon.results.DataResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("shipment-service")
public interface ShipmentServiceClient {
    @RequestMapping("shipments/{id}")
    ResponseEntity<DataResult<ShipmentDto>> get(@PathVariable String id);
}
