package com.tinnova.vehicles.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class VehiclesPerDecadeDto {
    long decade;
    long quantity;
}
