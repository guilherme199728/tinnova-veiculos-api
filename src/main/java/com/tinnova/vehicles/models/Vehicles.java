package com.tinnova.vehicles.models;

import com.electronwill.nightconfig.core.conversion.PreserveNotNull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
public class Vehicles implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@PreserveNotNull
	@Column(name = "brand")
	private String brand;
	
	@PreserveNotNull
	@Column(name = "year")
	private Integer year;
	
	@PreserveNotNull
	@Column(name = "description")
	private String description;
	
	@PreserveNotNull
	@Column(name = "sold")
	private boolean sold;
	
	@PreserveNotNull
	@Column(name = "creation_date")
	private Timestamp creation_date;
	
	@PreserveNotNull
	@Column(name = "modification_date")
	private Timestamp modification_date;
}