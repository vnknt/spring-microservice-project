package com.ingbootcamp.shipmentservice.business.concretes;

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
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShipmentServiceImpl implements ShipmentService {
    private final ShipmentRepository shipmentRepository;
    private final ModelMapper modelMapper;
    private final ShipmentConverter shipmentConverter;

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
        TypeToken<DataResult<AccountDto>> accountResponseType = new TypeToken<>(){};

        WebClient accountServiceClient = WebClient.create();
        String response = accountServiceClient.get()
                .uri("http://localhost:8090/accounts/"+id)
                .exchange()
                .block()
                .bodyToMono(String.class)
                .block();

        DataResult<AccountDto> accountDto = modelMapper.map(response,accountResponseType.getType());

        if(accountDto.isSuccess()){
            return new SuccessResult();
        }
        return new ErrorResult();

    }





}
