package com.ingbootcamp.deliveryservice.utilities;
import com.ingbootcamp.deliveryservice.entity.Delivery;
import com.ingbootcamp.servicecommon.contracts.DeliveryDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DeliveryConverter {


    private final ModelMapper modelMapper;

    public  List<DeliveryDto> deliveriesToList(List<Delivery> deliveries){
        TypeToken<List<DeliveryDto>> deliveryDtoType = new TypeToken<>(){};
        return this.modelMapper.map(deliveries,deliveryDtoType.getType());
    }


}
