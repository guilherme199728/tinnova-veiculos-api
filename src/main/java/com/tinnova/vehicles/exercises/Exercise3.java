package com.tinnova.vehicles.exercises;

public class Exercise3 {
	
	public static Integer factorialCalculation(Integer n) {
	    if (n == 0) {
	        return 1;
	    }
	    int resp = n;
	    while (n > 2) {
	        resp *= --n;
	    }
	    return resp;
	}
}
