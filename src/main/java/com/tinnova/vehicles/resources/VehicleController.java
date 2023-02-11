package com.tinnova.vehicles.resources;

import com.tinnova.vehicles.dtos.vehicles.VehiclesPatchDto;
import com.tinnova.vehicles.exceptions.NotFoundException;
import com.tinnova.vehicles.models.Vehicle;
import com.tinnova.vehicles.repositorys.filter.VehicleFilter;
import com.tinnova.vehicles.services.VehicleService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public List<Vehicle> getAll() {
        return vehicleService.getAll();
    }

    @GetMapping("/filter")
    public List<Vehicle> findByFilter(
            @RequestParam String brand,
            @RequestParam boolean sold,
            @RequestParam Integer decade,
            @RequestParam boolean registeredLasWeek
    ) {
        VehicleFilter vehicleFilter = VehicleFilter.builder()
                .brand(brand)
                .sold(sold)
                .decade(decade)
                .registeredLasWeek(registeredLasWeek)
                .build();

        return vehicleService.findByFilter(vehicleFilter);
    }

    @GetMapping("/{id}")
    public Vehicle getById(@PathVariable Long id) {
        return vehicleService.getById(id);
    }

    @PostMapping
    public void save(@RequestBody Vehicle vehicle, HttpServletResponse httpServletResponse) {
        Vehicle newVehicle = vehicleService.save(vehicle);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(newVehicle.getId()).toUri();
        httpServletResponse.setHeader("Location", uri.toASCIIString());

        ResponseEntity.created(uri).body(newVehicle);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> update(@PathVariable Long id, @RequestBody Vehicle vehicle) throws NotFoundException {
        return ResponseEntity.ok(vehicleService.update(id, vehicle));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Vehicle> patch(@PathVariable Long id, @RequestBody VehiclesPatchDto vehiclesPatchDto) throws NotFoundException {
        return ResponseEntity.ok(vehicleService.patch(id, vehiclesPatchDto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        vehicleService.delete(id);
    }

    @GetMapping("/brands")
    public List<String> getBrands() {
        return vehicleService.getBrands();
    }
}
