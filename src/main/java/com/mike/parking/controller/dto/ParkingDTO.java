package com.mike.parking.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL) // valores nulos não serão exibidos no JSON
@Data
public class ParkingDTO {
    private String id;
    private String license;
    private String state;
    private String model;
    private String color;

    private LocalDateTime entryDate;
    private LocalDateTime exitDateentryDateentryDate;
    private Double bill;
}
