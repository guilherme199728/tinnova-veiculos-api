package com.tinnova.vehicles.repositorys.filter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class VehicleFilter {
	private String brand;
	private boolean sold;
	private Integer decade;
	private boolean registeredLasWeek;
}
