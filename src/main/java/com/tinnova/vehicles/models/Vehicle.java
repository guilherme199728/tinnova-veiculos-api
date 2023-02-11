package com.tinnova.vehicles.models;

import com.electronwill.nightconfig.core.conversion.PreserveNotNull;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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
	@JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
	private LocalDateTime creationDate;
	
	@PreserveNotNull
	@Column(name = "modification_date")
	@JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
	private LocalDateTime modificationDate;
}