package com.tinnova.vehicles.controllers;

import com.tinnova.vehicles.HttpUtils;
import com.tinnova.vehicles.dtos.QuantityPerBrandsDto;
import com.tinnova.vehicles.dtos.VehiclesPatchDto;
import com.tinnova.vehicles.dtos.VehiclesPerDecadeDto;
import com.tinnova.vehicles.models.Vehicle;
import com.tinnova.vehicles.repositorys.VehicleRepository;
import com.tinnova.vehicles.services.VehicleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.tinnova.vehicles.HttpUtils.getList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class VehicleControllerTest {

    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private VehicleRepository vehicleRepository;
    private static final LocalDateTime currencyDate = LocalDateTime.now();

    @Test
    void shouldSearchAllVehicles() {
        // Arrange
        createListVehiclesInDataBase();

        // Act
        List<Vehicle> vehicles = getList("/vehicles", Vehicle[].class);

        // Assert
        assertNotNull(vehicles);
        assertEquals(createListVehicles(), vehicles);
    }

    @Test
    void shouldSearchVehiclesByFilter() {
        // Arrange
        createListVehiclesInDataBase();
        Vehicle vehicleExpect = new Vehicle();
        vehicleExpect.setId(2);
        vehicleExpect.setYearManufacture(1920);
        vehicleExpect.setSold(false);
        vehicleExpect.setDescription("Cruze2");
        vehicleExpect.setBrand("Chevrolet2");
        vehicleExpect.setModificationDate(currencyDate);
        vehicleExpect.setCreationDate(currencyDate);

        // Act
        List<Vehicle> vehiclesActual = getList(
                "/vehicles/filter?brand=Chevrolet2&sold=false&decade=10&registeredLasWeek=false",
                Vehicle[].class
        );

        // Assert
        assertNotNull(vehiclesActual);
        assertEquals(List.of(vehicleExpect), vehiclesActual);
    }

    @Test
    void shouldSearchVehiclesById() {
        // Arrange
        Vehicle vehicleExpect = new Vehicle();
        vehicleExpect.setYearManufacture(1920);
        vehicleExpect.setSold(false);
        vehicleExpect.setDescription("Cruze10");
        vehicleExpect.setBrand("Chevrolet10");
        vehicleExpect.setModificationDate(currencyDate);
        vehicleExpect.setCreationDate(currencyDate);
        vehicleRepository.save(vehicleExpect);

        // Act
        Vehicle vehicleActual = HttpUtils.get(
                "/vehicles/1",
                Vehicle.class
        );

        // Assert
        assertNotNull(vehicleActual);
        assertEquals(vehicleExpect, vehicleActual);
    }

    @Test
    void shouldSaveVehicle() {
        // Arrange
        Vehicle vehicleExpect = new Vehicle();
        vehicleExpect.setYearManufacture(1919);
        vehicleExpect.setSold(false);
        vehicleExpect.setDescription("Cruze9");
        vehicleExpect.setBrand("Chevrolet9");
        vehicleExpect.setModificationDate(currencyDate);
        vehicleExpect.setCreationDate(currencyDate);

        // Act
        Vehicle vehicleActual = HttpUtils.post(
                "/vehicles",
                vehicleExpect,
                Vehicle.class
        );

        // Assert
        assertNotNull(vehicleActual);
        assertEquals(vehicleExpect, vehicleActual);
        assertEquals(vehicleRepository.findAllById(List.of(vehicleActual.getId())), List.of(vehicleActual));
    }

    @Test
    void shouldPatchVehicle() {
        // Arrange
        createListVehiclesInDataBase();
        VehiclesPatchDto vehiclePatchExpect = new VehiclesPatchDto();
        vehiclePatchExpect.setDescription("Cruze5");
        vehiclePatchExpect.setBrand("Chevrolet5");
        vehiclePatchExpect.setYearManufacture(1950);

        // Act
        Vehicle vehicleActual = HttpUtils.patch(
                "/vehicles/2",
                vehiclePatchExpect,
                Vehicle.class
        );

        // Assert
        assertNotNull(vehicleActual);
        assertEquals(vehicleRepository.findAllById(List.of(vehicleActual.getId())), List.of(vehicleActual));
        assertEquals(vehiclePatchExpect.getDescription(), vehicleActual.getDescription());
        assertEquals(vehiclePatchExpect.getYearManufacture(), vehicleActual.getYearManufacture());
        assertEquals(vehiclePatchExpect.getBrand(), vehicleActual.getBrand());
    }

    @Test
    void shouldDeleteVehicle() throws URISyntaxException {
        // Arrange
        Vehicle vehicleExpect = new Vehicle();
        vehicleExpect.setYearManufacture(2000);
        vehicleExpect.setSold(true);
        vehicleExpect.setDescription("Cruze");
        vehicleExpect.setBrand("Chevrolet");
        vehicleExpect.setModificationDate(currencyDate);
        vehicleExpect.setCreationDate(currencyDate);
        vehicleRepository.save(vehicleExpect);

        // Act
        HttpUtils.delete(
                "/vehicles/1"
        );

        // Assert
        assertEquals(new ArrayList<>(), vehicleRepository.findAllById(List.of(1L)));
    }

    @Test
    void shouldSearchBrands() {
        // Arrange
        createListVehiclesInDataBase();

        List<String> brandsExpected = createListVehicles()
                .stream()
                .map(Vehicle::getBrand)
                .toList();

        // Act
        List<String> brandsActual = HttpUtils.getList(
                "/vehicles/brands",
                String[].class
        );

        // Assert
        assertNotNull(brandsActual);
        assertEquals(brandsExpected, brandsActual);
    }

    @Test
    void shouldFindTotalVehiclesPerBrands() {
        // Arrange
        insertDefault();

        List<QuantityPerBrandsDto> quantityPerBrandsDtosExpect = new ArrayList<>();

        quantityPerBrandsDtosExpect.add(
                QuantityPerBrandsDto.builder()
                        .brand("Chevrolet")
                        .quantity(2)
                        .build()
        );

        quantityPerBrandsDtosExpect.add(
                QuantityPerBrandsDto.builder()
                        .brand("Ford")
                        .quantity(1)
                        .build()
        );

        // Act
        List<QuantityPerBrandsDto> quantityPerBrandsDtoActual = HttpUtils.getList(
                "/vehicles/totalVehiclePerBrands",
                QuantityPerBrandsDto[].class
        );

        // Assert
        assertEquals(quantityPerBrandsDtosExpect, quantityPerBrandsDtoActual);
    }

    @Test
    void shouldFindTotalVehiclesPerDecade() {
        // Arrange
        insertDefault();

        List<VehiclesPerDecadeDto> VehiclesPerDecadeDtosExpect = new ArrayList<>();

        VehiclesPerDecadeDtosExpect.add(
                VehiclesPerDecadeDto.builder()
                        .decade(2000)
                        .quantity(2)
                        .build()
        );

        VehiclesPerDecadeDtosExpect.add(
                VehiclesPerDecadeDto.builder()
                        .decade(1980)
                        .quantity(1)
                        .build()
        );

        // Act
        List<VehiclesPerDecadeDto> vehiclesPerDecadeDtoActual =  HttpUtils.getList(
                "/vehicles/totalVehiclePerDecade",
                VehiclesPerDecadeDto[].class
        );

        // Assert
        assertEquals(VehiclesPerDecadeDtosExpect, vehiclesPerDecadeDtoActual);
    }

    private void insertDefault() {
        Vehicle vehicle = new Vehicle();
        vehicle.setYearManufacture(1983);
        vehicle.setSold(true);
        vehicle.setDescription("Cruze");
        vehicle.setBrand("Chevrolet");
        vehicle.setModificationDate(currencyDate);
        vehicle.setCreationDate(currencyDate);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setYearManufacture(2000);
        vehicle2.setSold(true);
        vehicle2.setDescription("Cruze");
        vehicle2.setBrand("Chevrolet");
        vehicle2.setModificationDate(currencyDate);
        vehicle2.setCreationDate(currencyDate);

        Vehicle vehicle3 = new Vehicle();
        vehicle3.setYearManufacture(2000);
        vehicle3.setSold(true);
        vehicle3.setDescription("Cruze");
        vehicle3.setBrand("Ford");
        vehicle3.setModificationDate(currencyDate);
        vehicle3.setCreationDate(currencyDate);

        vehicleRepository.save(vehicle);
        vehicleRepository.save(vehicle2);
        vehicleRepository.save(vehicle3);
    }

    private void createListVehiclesInDataBase() {
        vehicleRepository.saveAll(createListVehicles());
    }

    private List<Vehicle> createListVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            Vehicle vehicle = new Vehicle();
            vehicle.setId(i);
            vehicle.setYearManufacture(1910 + i);
            vehicle.setSold(false);
            vehicle.setDescription("Cruze" + i);
            vehicle.setBrand("Chevrolet" + i);
            vehicle.setModificationDate(currencyDate);
            vehicle.setCreationDate(currencyDate);
            vehicles.add(vehicle);
        }

        return vehicles;
    }
}