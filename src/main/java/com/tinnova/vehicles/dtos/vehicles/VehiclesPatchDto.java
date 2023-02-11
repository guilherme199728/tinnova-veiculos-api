package com.tinnova.vehicles.dtos.vehicles;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class VehiclesPatchDto {
    private String brand;
    private int year;
    private String description;
}
