package com.tinnova.vehicles.exercises;

public class MainExercises {
	public static void main(String[] args) {
		Integer[] numberForOrdination = new Integer[8];
		numberForOrdination[0] = 5;
		numberForOrdination[1] = 3;
		numberForOrdination[2] = 2;
		numberForOrdination[3] = 4;
		numberForOrdination[4] = 7;
		numberForOrdination[5] = 1;
		numberForOrdination[6] = 0;
		numberForOrdination[7] = 6;
		
		runExercise1();
		runExercise2(numberForOrdination);
		runExercise3(numberForOrdination);
		runExercise4();
	}
	
	public static void runExercise1() {
		System.out.println("Exercicio - 1 | Votos em relação ao total de eleitores");
		
		System.out.println("Votos validos: " + Exercise1.calcPercentageOfValidVotes() + "%");
		System.out.println("Votos em branco: " + Exercise1.calcPercentageOfWhiteVotes() + "%");
		System.out.println("Votos em nulos: " + Exercise1.calcPercentageOfNullVotes() + "%");
		
		System.out.println("----------------------------------------------------------------------------------");
	}
	
	public static void runExercise2(Integer[] numberForOrdination) {
		System.out.println("Exercicio - 2 | Algoritimo de ordenação Bubble sort");
		
		System.out.print("Desordenado: ");
		for (Integer number : numberForOrdination) {
			System.out.print(number + ", ");
		}
		
		System.out.println();
		
		System.out.print("Ordenado: ");
		for (Integer number : Exercise2.ordinationWithBubbleSort(numberForOrdination)) {
			System.out.print(number + ", ");
		}
		System.out.println();
		
		System.out.println("----------------------------------------------------------------------------------");
	}
	
	public static void runExercise3(Integer[] numberForOrdination) {
		System.out.println("Exercicio - 3 | Fatorial");
		
		for (Integer number : Exercise2.ordinationWithBubbleSort(numberForOrdination)) {
			System.out.println("!" + number + " = " + Exercise3.factorialCalculation(number));
		}
		
		System.out.println("----------------------------------------------------------------------------------");
	}
	
	public static void runExercise4() {
		System.out.println("Exercicio - 4 | Soma dos multiplos de 3 ou 5");
		Integer exemplar = 10;
		
		System.out.println("Exemplo com numero: " + exemplar);
		System.out.println("Soma: " + Exercise4.getSumMultiplesThreeAndFive(exemplar));
		
		System.out.println("----------------------------------------------------------------------------------");
	}
}
