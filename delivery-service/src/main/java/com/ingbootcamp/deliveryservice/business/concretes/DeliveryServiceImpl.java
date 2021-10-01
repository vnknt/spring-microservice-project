package com.ingbootcamp.deliveryservice.business.concretes;

import com.ingbootcamp.deliveryservice.business.abstracts.DeliveryService;
import com.ingbootcamp.servicecommon.contracts.DeliveryDto;
import com.ingbootcamp.servicecommon.results.DataResult;
import com.ingbootcamp.servicecommon.results.Result;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Override
    public DataResult<List<DeliveryDto>> getAll() {
        return null;
    }

    @Override
    public DataResult<DeliveryDto> get(String id) {
        return null;
    }

    @Override
    public Result add(DeliveryDto deliveryDto) {
        return null;
    }

    @Override
    public Result update(DeliveryDto deliveryDto) {
        return null;
    }

    @Override
    public Result delete(String id) {
        return null;
    }
}
