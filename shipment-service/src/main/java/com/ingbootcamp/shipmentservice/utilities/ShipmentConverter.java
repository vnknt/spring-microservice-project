package com.ingbootcamp.shipmentservice.utilities;

import com.ingbootcamp.servicecommon.contracts.AccountDto;
import com.ingbootcamp.servicecommon.contracts.ShipmentDto;
import com.ingbootcamp.shipmentservice.entity.Shipment;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;
import java.util.List;


@RequiredArgsConstructor
@Component
public class ShipmentConverter {
    private final ModelMapper modelMapper;

    public List<ShipmentDto> shipmentsToDtos(List<Shipment> shipments){
        TypeToken<List<ShipmentDto>> shipmentDtoType = new TypeToken<>(){};
        return this.modelMapper.map(shipments,shipmentDtoType.getType());
    }
}
