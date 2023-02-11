package com.tinnova.vehicles.models;

import com.electronwill.nightconfig.core.conversion.PreserveNotNull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "vehicle")
@Getter
@Setter
public class Vehicle implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@PreserveNotNull
	private String brand;
	
	@PreserveNotNull
	private Integer year;
	
	@PreserveNotNull
	private String description;
	
	@PreserveNotNull
	private boolean sold;
	
	@PreserveNotNull
	@Column(name = "creation_date")
	private Timestamp creationDate;
	
	@PreserveNotNull
	@Column(name = "modification_date")
	private Timestamp modificationDate;
}