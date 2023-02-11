package com.tinnova.vehicles.repositorys;

import com.tinnova.vehicles.models.Vehicle;
import com.tinnova.vehicles.repositorys.veiculos.VehicleRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>, VehicleRepositoryQuery {

    @Query("select distinct vehicles.brand from Vehicle vehicles")
    List<String> getBrands();

}
