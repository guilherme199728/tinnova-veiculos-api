package com.tinnova.vehicles.repositorys.veiculos;

import com.tinnova.vehicles.dtos.QuantityPerBrandsDto;
import com.tinnova.vehicles.models.Vehicle;
import com.tinnova.vehicles.repositorys.filter.VehicleFilter;

import java.util.List;

public interface VehicleRepositoryQuery {
    List<Vehicle> findByFilter(VehicleFilter vehicleFilter);

    List<QuantityPerBrandsDto> findTotalQuantityPerBrands();
}
