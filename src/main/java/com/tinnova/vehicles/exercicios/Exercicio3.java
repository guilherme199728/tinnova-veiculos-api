package com.tinnova.vehicles.exercicios;

public class Exercicio3 {
	
	public static Integer calcFatorial(Integer n) {
	    if (n == 0) {
	        return 1;
	    }
	    Integer resp = n;
	    while (n > 2) {
	        resp *= --n;
	    }
	    return resp;
	}
}
