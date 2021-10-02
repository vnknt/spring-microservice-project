package com.ingbootcamp.deliveryservice.business.concretes;

import com.ingbootcamp.deliveryservice.business.abstracts.DeliveryService;
import com.ingbootcamp.deliveryservice.entity.Delivery;
import com.ingbootcamp.deliveryservice.repository.DeliveryRepository;
import com.ingbootcamp.deliveryservice.utilities.DeliveryConverter;
import com.ingbootcamp.servicecommon.clients.ShipmentServiceClient;
import com.ingbootcamp.servicecommon.contracts.DeliveryDto;
import com.ingbootcamp.servicecommon.contracts.DeliveryStatus;
import com.ingbootcamp.servicecommon.contracts.Notification;
import com.ingbootcamp.servicecommon.contracts.ShipmentDto;
import com.ingbootcamp.servicecommon.messaging.NotificationPublisher;
import com.ingbootcamp.servicecommon.results.*;
import com.ingbootcamp.servicecommon.utils.BusinessRules;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final ModelMapper modelMapper;
    private final DeliveryConverter deliveryConverter;
    private final NotificationPublisher notificationPublisher;
    private final ShipmentServiceClient shipmentServiceClient;
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

        Result businessResult = BusinessRules.run(
                checkShipment(deliveryDto.getShipment())
        );

        if(!businessResult.isSuccess()){
            return businessResult;
        }

        try{
            Delivery delivery = modelMapper.map(deliveryDto,Delivery.class);
            delivery.setCreated_at(new Date());
            deliveryRepository.save(delivery);
        }catch (Exception e){
            return new ErrorResult("An error occured while addng delivery object");
        }
        Notification notification = new Notification();
        if(deliveryDto.getStatus() == DeliveryStatus.DELIVERED ){
            notification.setTitle("Shipment is Delivered sucessfully");
        }else if(deliveryDto.getStatus().equals(DeliveryStatus.UNDELIVERED)) {
            notification.setTitle("Shipment is NOT Delivered");
        }
        notificationPublisher.sendNotification(notification);

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


    private Result checkShipment(String id){
        ResponseEntity<DataResult<ShipmentDto>> response = shipmentServiceClient.get(id);
        if(!response.getBody().isSuccess()){
            return new ErrorResult("Unavailable shipment");
        }
        return new SuccessResult();
    }



}
