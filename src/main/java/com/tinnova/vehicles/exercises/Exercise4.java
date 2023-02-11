package com.tinnova.vehicles.exercises;

public class Exercise4 {
	public static Integer getSumMultiplesThreeAndFive(Integer number) {
	    int soma = 0;
	    		
		for (int i = 0; i < number; i++) {
			if (isMultipleOf(i, 3) || isMultipleOf(i, 5)) {
				soma += i;
			}
		}
	    
	    return soma;
	}
	
	private static boolean isMultipleOf(Integer number, Integer multiple) {
		return number % multiple == 0;
	}
}
