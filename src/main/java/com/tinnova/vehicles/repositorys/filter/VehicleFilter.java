package com.tinnova.vehicles.repositorys.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleFilter {
	private String brand;
	private boolean sold;
	private Integer decade;
	private boolean registeredLasWeek;
}
