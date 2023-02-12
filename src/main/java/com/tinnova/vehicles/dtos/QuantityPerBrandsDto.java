package com.tinnova.vehicles.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class QuantityPerBrandsDto {
    String brand;
    long quantity;
}
