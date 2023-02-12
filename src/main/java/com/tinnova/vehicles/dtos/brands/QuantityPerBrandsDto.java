package com.tinnova.vehicles.dtos.brands;

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
