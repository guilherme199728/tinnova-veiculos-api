package com.tinnova.vehicles.services;

import com.tinnova.vehicles.dtos.vehicles.VehiclesPatchDto;
import com.tinnova.vehicles.exceptions.NotFoundException;
import com.tinnova.vehicles.models.Vehicle;
import com.tinnova.vehicles.repositorys.VehicleRepository;
import com.tinnova.vehicles.repositorys.filter.VehicleFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getAll() {
        Sort sort = Sort.by("id").ascending();
        return vehicleRepository.findAll(sort);
    }

    public Vehicle getById(long id) {
        return vehicleRepository
                .findAllById(List.of(id))
                .stream()
                .findFirst()
                .orElse(null);
    }

    public List<Vehicle> findByFilter(VehicleFilter vehicleFilter) {
        return vehicleRepository.findByFilter(vehicleFilter);
    }

    public Vehicle save(Vehicle vehicle) {
        vehicle.setModificationDate(LocalDateTime.now());
        vehicle.setCreationDate(LocalDateTime.now());
        return vehicleRepository.save(vehicle);
    }

    public Vehicle update(Long id, Vehicle newVehicle) throws NotFoundException {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(NotFoundException::new);
        vehicle.setBrand(newVehicle.getBrand());
        vehicle.setSold(newVehicle.isSold());
        vehicle.setYear(newVehicle.getYear());
        vehicle.setDescription(newVehicle.getDescription());
        vehicle.setModificationDate(LocalDateTime.now());
        vehicle.setBrand(newVehicle.getBrand());

        return vehicleRepository.save(vehicle);
    }

    public Vehicle patch(Long id, VehiclesPatchDto vehiclesPatchDto) throws NotFoundException {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(NotFoundException::new);
        vehicle.setBrand(vehiclesPatchDto.getBrand());
        vehicle.setYear(vehiclesPatchDto.getYear());
        vehicle.setDescription(vehiclesPatchDto.getDescription());
        vehicle.setModificationDate(LocalDateTime.now());

        return vehicleRepository.save(vehicle);
    }

    public void delete(Long id) {
        vehicleRepository.deleteById(id);
    }

    public List<String> getBrands() {
        return vehicleRepository.getBrands();
    }
}
