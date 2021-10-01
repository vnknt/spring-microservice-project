package com.ingbootcamp.deliveryservice.business.concretes;

import com.ingbootcamp.deliveryservice.business.abstracts.DeliveryService;
import com.ingbootcamp.deliveryservice.entity.Delivery;
import com.ingbootcamp.deliveryservice.repository.DeliveryRepository;
import com.ingbootcamp.deliveryservice.utilities.DeliveryConverter;
import com.ingbootcamp.servicecommon.contracts.DeliveryDto;
import com.ingbootcamp.servicecommon.results.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final ModelMapper modelMapper;
    private final DeliveryConverter deliveryConverter;

    @Override
    public DataResult<List<DeliveryDto>> getAll() {
        List<Delivery> deliveries = deliveryRepository.findAll();
        return new SuccessDataResult<>(deliveryConverter.deliveriesToList(deliveries));
    }

    @Override
    public DataResult<DeliveryDto> get(String id) {
        DeliveryDto deliveryDto ;
        try{
            Delivery delivery = deliveryRepository.getById(id);
            deliveryDto = modelMapper.map(delivery,DeliveryDto.class);
        }catch (Exception e){
            return new ErrorDataResult<>("An error occured while getting delivery object");
        }
        return new SuccessDataResult<>(deliveryDto);
    }

    @Override
    public Result add(DeliveryDto deliveryDto) {
        try{
            Delivery delivery = modelMapper.map(deliveryDto,Delivery.class);
            delivery.setCreated_at(new Date());
            deliveryRepository.save(delivery);
        }catch (Exception e){
            return new ErrorResult("An error occured while addng delivery object");
        }
        return new SuccessResult();
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
