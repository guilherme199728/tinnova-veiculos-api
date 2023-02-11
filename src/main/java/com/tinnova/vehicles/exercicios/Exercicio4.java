package com.tinnova.vehicles.exercicios;

public class Exercicio4 {
	public static Integer getSomaMultiplosDeTresECinco(Integer numero) {
	    Integer soma = 0;
	    		
		for (int i = 0; i < numero; i++) {
			if (isMultiploDe(i, 3) || isMultiploDe(i, 5)) {
				soma += i;
			}
		}
	    
	    return soma;
	}
	
	private static boolean isMultiploDe(Integer numero, Integer multiplo) {
		return numero % multiplo == 0;
	}
}
