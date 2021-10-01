package com.ingbootcamp.shipmentservice.business.abstracts;

import com.ingbootcamp.servicecommon.contracts.ShipmentDto;
import com.ingbootcamp.servicecommon.results.DataResult;
import com.ingbootcamp.servicecommon.results.Result;

import java.util.List;

public interface ShipmentService {

    DataResult<List<ShipmentDto>> getAll();
    DataResult<ShipmentDto> get(String id);
    Result add (ShipmentDto shipmentDto);
    Result delete(String id);
    Result update(ShipmentDto shipmentDto);

}
