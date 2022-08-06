package com.mike.parking.service;

import com.mike.parking.model.Parking;
import com.mike.parking.repository.ParkingRespository;
import com.mike.parking.service.exception.ParkingNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private static Map<String, Parking> parkingMap = new HashMap<>();

    private final ParkingRespository parkingRespository;

    public ParkingService(ParkingRespository parkingRespository) {
        this.parkingRespository = parkingRespository;
    }

    public List<Parking> findAll(){
        return parkingRespository.findAll();
    }

    private static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Parking findById(String id) {
       return parkingRespository.findById(id).orElseThrow( () ->
                new ParkingNotFoundException(id));
    }

    @Transactional
    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingRespository.save(parkingCreate);
        return parkingCreate;
    }

    @Transactional
    public void delete(String id) {
        findById(id);
        parkingRespository.deleteById(id);
    }

    @Transactional
    public Parking update(String id, Parking parkingCreate) {
        Parking parking = findById(id);
        parking.setColor(parkingCreate.getColor());
        parking.setState(parkingCreate.getState());
        parking.setModel(parkingCreate.getModel());
        parking.setLicense(parkingCreate.getLicense());
        parkingRespository.save(parking);
        return parking;
    }

    @Transactional
    public Parking checkOut(String id){
        Parking parking = findById(id);
        parking.setExitDate(LocalDateTime.now());

        parking.setBill(ParkingCheckout.getBill(parking));

        parkingRespository.save(parking);

        return parking;

    }

}
