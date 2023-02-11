package com.tinnova.vehicles.repositorys.filter;

public class VehicleFilter {
	private String veiculoMarca;
	private boolean veiculoVendido;
	private Integer decada;
	private boolean registradoUtimaSemana;
	
	public String getVeiculoMarca() {
		return veiculoMarca;
	}
	
	public void setVeiculoMarca(String veiculoMarca) {
		this.veiculoMarca = veiculoMarca;
	}

	public boolean isVeiculoVendido() {
		return veiculoVendido;
	}
	
	public void setVeiculoVendido(boolean veiculoVendido) {
		this.veiculoVendido = veiculoVendido;
	}

	public Integer getDecada() {
		return decada;
	}

	public void setDecada(Integer decada) {
		this.decada = decada;
	}

	public boolean isRegistradoUtimaSemana() {
		return registradoUtimaSemana;
	}

	public void setRegistradoUtimaSemana(boolean registradoUtimaSemana) {
		this.registradoUtimaSemana = registradoUtimaSemana;
	}
	
	
}
