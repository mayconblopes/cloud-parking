package com.mike.parking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Parking {
    private String id;
    private String license;
    private String state;
    private String model;
    private String color;

    private LocalDateTime entryDate;
    private LocalDateTime exitDateentryDateentryDate;
    private Double bill;

    public Parking() {
    }

    public Parking(String id, String license, String state, String model, String color) {
        this.id = id;
        this.license = license;
        this.state = state;
        this.model = model;
        this.color = color;
    }
}
