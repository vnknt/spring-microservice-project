package com.ingbootcamp.shipmentservice.business.concretes;

import com.ingbootcamp.servicecommon.clients.AccountServiceClient;
import com.ingbootcamp.servicecommon.contracts.AccountDto;
import com.ingbootcamp.servicecommon.contracts.ShipmentDto;
import com.ingbootcamp.servicecommon.results.*;
import com.ingbootcamp.servicecommon.utils.BusinessRules;
import com.ingbootcamp.shipmentservice.business.abstracts.ShipmentService;
import com.ingbootcamp.shipmentservice.entity.Shipment;
import com.ingbootcamp.shipmentservice.repository.ShipmentRepository;
import com.ingbootcamp.shipmentservice.utilities.ShipmentConverter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class ShipmentServiceImpl implements ShipmentService {
    private final ShipmentRepository shipmentRepository;
    private final ModelMapper modelMapper;
    private final ShipmentConverter shipmentConverter;
    private final AccountServiceClient accountServiceClient;


    @Override
    public DataResult<List<ShipmentDto>> getAll() {
        List<Shipment> shipments = shipmentRepository.findAll();
        List<ShipmentDto> shipmentDtos = shipmentConverter.shipmentsToDtos(shipments);
        return new SuccessDataResult<>(shipmentDtos);
    }

    @Override
    public DataResult<ShipmentDto> get(String id) {

        Shipment shipment = shipmentRepository.findById(id).orElseGet(()->null);
        if(shipment ==null){
            return new ErrorDataResult<>("Shipment couldn't be found");
        }
        ShipmentDto shipmentDto = modelMapper.map(shipment,ShipmentDto.class);
        return new SuccessDataResult<>(shipmentDto);

    }

    @Override
    public Result add(ShipmentDto shipmentDto) {
        Result businessResult = BusinessRules.run(
                checkIsEmpty(shipmentDto.getSender()),
                checkIsEmpty(shipmentDto.getReciever())
        );

        if(!businessResult.isSuccess()){
            return businessResult;
        }

        businessResult = BusinessRules.run(
                checkAccountId(shipmentDto.getSender()),
                checkAccountId(shipmentDto.getReciever())
        );
        if(!businessResult.isSuccess()){
            return businessResult;
        }



        shipmentDto.setSended_at(new Date());
        try{
            Shipment shipment = modelMapper.map(shipmentDto,Shipment.class);
            shipmentRepository.save(shipment);
        }catch (Exception e){
            return new ErrorResult("Shipment couldn't save");
        }
        return new SuccessResult("Successfully saved");
    }

    @Override
    public Result delete(String id) {
        try{
            shipmentRepository.deleteById(id);
        }catch (Exception e){
            return new ErrorResult("Shipment couldn't deleted");
        }
        return new SuccessResult("Successfully deleted");
    }

    @Override
    public Result update(ShipmentDto shipmentDto) {
        return null;
    }


    private Result checkAccountId(String id) {
        ResponseEntity<DataResult<AccountDto>> response = accountServiceClient.get(id);

        if(!response.getBody().isSuccess()){
            return new ErrorResult();
        }
        return new SuccessResult();
    }




    private Result checkIsEmpty(String str){

        if(str.trim().isEmpty()){
            return new ErrorResult("Id cannot be null");
        }
        return new SuccessResult();
    }



}
