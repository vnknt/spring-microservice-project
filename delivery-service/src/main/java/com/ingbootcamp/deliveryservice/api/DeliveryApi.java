package com.ingbootcamp.deliveryservice.api;

import com.ingbootcamp.deliveryservice.business.abstracts.DeliveryService;

import com.ingbootcamp.servicecommon.contracts.DeliveryDto;
import com.ingbootcamp.servicecommon.results.DataResult;
import com.ingbootcamp.servicecommon.results.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("deliveries")
public class DeliveryApi {

    private final DeliveryService deliveryService;

    @GetMapping
    public ResponseEntity<DataResult<List<DeliveryDto>>> getAll(){
        DataResult<List<DeliveryDto>> deliveries = this.deliveryService.getAll();
        return ResponseEntity.ok(deliveries);

    }

    @PostMapping
    public ResponseEntity<Result> add(DeliveryDto deliveryDto){
        return ResponseEntity.ok(deliveryService.add(deliveryDto));
    }





}
