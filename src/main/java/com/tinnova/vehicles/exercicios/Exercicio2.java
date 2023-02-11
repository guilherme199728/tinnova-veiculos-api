package com.tinnova.vehicles.exercicios;

public class Exercicio2 {
	public static Integer[] ordenaNumerosComBubbleSort(Integer numerosParaOrdenar[]) {
	    	 
        for (int i = numerosParaOrdenar.length; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                if (numerosParaOrdenar[j - 1] > numerosParaOrdenar[j]) {
                    int aux = numerosParaOrdenar[j];
                    numerosParaOrdenar[j] = numerosParaOrdenar[j - 1];
                    numerosParaOrdenar[j - 1] = aux;
                }
            }
        }
        
        return numerosParaOrdenar;
	}
}
	
