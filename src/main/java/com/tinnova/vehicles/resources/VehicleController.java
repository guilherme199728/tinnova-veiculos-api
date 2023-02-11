package com.tinnova.vehicles.resources;

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
@RequestMapping("/veiculos")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping
	public List<Vehicle> getAll() {
		return vehicleService.getAll();
	}
	
	@GetMapping("/find")
	public List<Vehicle> findByFilter(VehicleFilter vehicleFilter) {
		return vehicleService.findByFilter(vehicleFilter);
	}
	
	@GetMapping("/marcas-veiculos")
	public List<String> getBrands() {
		return vehicleService.getBrands();
	}
	
	@PostMapping
	public void save(@RequestBody Vehicle vehicle, HttpServletResponse httpServletResponse) {
		Vehicle newVehicle = vehicleService.save(vehicle);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}").buildAndExpand(newVehicle.getId()).toUri();
		httpServletResponse.setHeader("Location", uri.toASCIIString());
		
		ResponseEntity.created(uri).body(newVehicle);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Vehicle> update(@PathVariable Long id, @RequestBody Vehicle vehicle) {
		return ResponseEntity.ok(vehicleService.update(id, vehicle));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		vehicleService.delete(id);
	}

}
