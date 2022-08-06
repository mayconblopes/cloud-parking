package com.mike.parking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Parking {
    @Id
    private String id;
    private String license;
    private String state;
    private String model;
    private String color;

    private LocalDateTime entryDate;
    private LocalDateTime exitDate;
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
