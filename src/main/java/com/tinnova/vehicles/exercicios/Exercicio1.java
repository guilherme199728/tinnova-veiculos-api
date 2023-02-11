package com.tinnova.vehicles.exercicios;

public class Exercicio1 {
	
    private static float totalDeEleitores = 1000;
    private static float validos = 800;
    private static float brancos = 150;
    private static float nulos = 50;

	public static float calcPercentualDeVotosValidos() {
		return calculaPercentual(validos, totalDeEleitores);
	}
	
	public static float calcPercentualDeVotosBrancos() {
		return calculaPercentual(brancos, totalDeEleitores);
	}
	
	public static float calcPercentualDeVotosNulos() {
		return calculaPercentual(nulos, totalDeEleitores);
	}
	
	private static float calculaPercentual(float nulos2, float totalDeEleitores2) {
		return nulos2 / totalDeEleitores2;
	}
	
}
