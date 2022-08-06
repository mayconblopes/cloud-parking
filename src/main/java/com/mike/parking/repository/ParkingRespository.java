package com.mike.parking.repository;

import com.mike.parking.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRespository extends JpaRepository<Parking, String> {

}
