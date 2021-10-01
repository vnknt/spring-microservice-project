package com.ingbootcamp.shipmentservice.api;


import com.ingbootcamp.servicecommon.contracts.AccountDto;
import com.ingbootcamp.servicecommon.contracts.ShipmentDto;
import com.ingbootcamp.servicecommon.results.DataResult;
import com.ingbootcamp.servicecommon.results.Result;
import com.ingbootcamp.shipmentservice.business.abstracts.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shipments")
public class ShipmentApi {

    private ShipmentService shipmentService;
    @Autowired
    public ShipmentApi(ShipmentService shipmentService){
        this.shipmentService = shipmentService;
    }

    @GetMapping
    public ResponseEntity<DataResult<List<ShipmentDto>>> getAll(){
        return ResponseEntity.ok(shipmentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<ShipmentDto>> get(@PathVariable String id){
        return ResponseEntity.ok(shipmentService.get(id));
    }

    @PostMapping
    public ResponseEntity<Result> add(@RequestBody ShipmentDto shipmentDto){
        return ResponseEntity.ok(shipmentService.add(shipmentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable String id){
        return ResponseEntity.ok(shipmentService.delete(id));
    }

    @PutMapping
    public ResponseEntity<Result> update(@RequestBody ShipmentDto shipmentDto){
        return ResponseEntity.ok(shipmentService.update(shipmentDto));
    }



}
