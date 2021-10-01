package com.ingbootcamp.deliveryservice.business.abstracts;


import com.ingbootcamp.servicecommon.contracts.DeliveryDto;
import com.ingbootcamp.servicecommon.results.DataResult;
import com.ingbootcamp.servicecommon.results.Result;

import java.util.List;

public interface DeliveryService {
    List<DataResult<DeliveryDto>> getAll();
    DataResult<DeliveryDto> get(String id);
    Result add(DeliveryDto deliveryDto);
    Result update(DeliveryDto deliveryDto);
    Result delete(String id);
}
