package com.tinnova.vehicles.exercises;

public class Exercise2 {
	public static Integer[] ordinationWithBubbleSort(Integer[] numberForOrdination) {
	    	 
        for (int i = numberForOrdination.length; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                if (numberForOrdination[j - 1] > numberForOrdination[j]) {
                    int aux = numberForOrdination[j];
                    numberForOrdination[j] = numberForOrdination[j - 1];
                    numberForOrdination[j - 1] = aux;
                }
            }
        }
        
        return numberForOrdination;
	}
}
	
