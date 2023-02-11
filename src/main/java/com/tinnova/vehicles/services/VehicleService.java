package com.tinnova.vehicles.services;

import com.tinnova.vehicles.models.Vehicle;
import com.tinnova.vehicles.repositorys.VehicleRepository;
import com.tinnova.vehicles.repositorys.filter.VehicleFilter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getAll() {
        return orderById(vehicleRepository.findAll());
    }

    public List<Vehicle> findByFilter(VehicleFilter vehicleFilter) {
        return orderById(vehicleRepository.findByFilter(vehicleFilter));
    }

    public Vehicle save(Vehicle vehicle) {
        vehicle.setModification_date(new Timestamp(System.currentTimeMillis()));
        vehicle.setCreation_date(new Timestamp(System.currentTimeMillis()));
        return vehicleRepository.save(vehicle);
    }

    public Vehicle update(Long id, Vehicle vehicle) {
        Optional<Vehicle> newVehicle = vehicleRepository.findById(id);

        BeanUtils.copyProperties(vehicle, newVehicle.get(), "veiculoCodigo");
        newVehicle.get().setModification_date(new Timestamp(System.currentTimeMillis()));

        return vehicleRepository.save(newVehicle.get());
    }

    public void delete(Long id) {
        vehicleRepository.deleteById(id);
    }

    public List<String> getBrands() {
        return vehicleRepository.getBrands();
    }


    public List<Vehicle> orderById(List<Vehicle> vehicle) {
        vehicle.sort(Comparator.comparingLong(Vehicle::getId));

        return vehicle;
    }
}
