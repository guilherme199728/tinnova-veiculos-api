package com.tinnova.vehicles.dtos.vehicles;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehiclesPatchDto {
    private String brand;
    private int year;
    private String description;
}
