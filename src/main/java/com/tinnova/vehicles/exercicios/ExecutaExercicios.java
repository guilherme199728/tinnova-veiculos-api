package com.tinnova.vehicles.exercicios;

public class ExecutaExercicios {
	public static void main(String[] args) {
		Integer numerosParaOrdenar[] = new Integer[8];
		numerosParaOrdenar[0] = 5;
		numerosParaOrdenar[1] = 3;
		numerosParaOrdenar[2] = 2;
		numerosParaOrdenar[3] = 4;
		numerosParaOrdenar[4] = 7;
		numerosParaOrdenar[5] = 1;
		numerosParaOrdenar[6] = 0;
		numerosParaOrdenar[7] = 6;
		
		executaExercicio1();
		executaExercicio2(numerosParaOrdenar);
		executaExercicio3(numerosParaOrdenar);
		executaExercicio4();
	}
	
	public static void executaExercicio1() {
		System.out.println("Exercicio - 1 | Votos em relação ao total de eleitores");
		
		System.out.println("Votos validos: " + Exercicio1.calcPercentualDeVotosValidos() + "%");
		System.out.println("Votos em branco: " + Exercicio1.calcPercentualDeVotosBrancos() + "%");
		System.out.println("Votos em nulos: " + Exercicio1.calcPercentualDeVotosNulos() + "%");
		
		System.out.println("----------------------------------------------------------------------------------");
	}
	
	public static void executaExercicio2(Integer numerosParaOrdenar[]) {
		System.out.println("Exercicio - 2 | Algoritimo de ordenação Bubble sort");
		
		System.out.print("Desordenado: ");
		for (Integer numero : numerosParaOrdenar) {
			System.out.print(numero + ", ");
		}
		
		System.out.println();
		
		System.out.print("Ordenado: ");
		for (Integer numero : Exercicio2.ordenaNumerosComBubbleSort(numerosParaOrdenar)) {
			System.out.print(numero + ", ");
		}
		System.out.println();
		
		System.out.println("----------------------------------------------------------------------------------");
	}
	
	public static void executaExercicio3(Integer numerosParaOrdenar[]) {
		System.out.println("Exercicio - 3 | Fatorial");
		
		for (Integer numero : Exercicio2.ordenaNumerosComBubbleSort(numerosParaOrdenar)) {
			System.out.println("!" + numero + " = " + Exercicio3.calcFatorial(numero));
		}
		
		System.out.println("----------------------------------------------------------------------------------");
	}
	
	public static void executaExercicio4() {
		System.out.println("Exercicio - 4 | Soma dos multiplos de 3 ou 5");
		Integer exemplo = 10;
		
		System.out.println("Exemplo com numero: " + exemplo);
		System.out.println("Soma: " + Exercicio4.getSomaMultiplosDeTresECinco(exemplo));
		
		System.out.println("----------------------------------------------------------------------------------");
	}
}
