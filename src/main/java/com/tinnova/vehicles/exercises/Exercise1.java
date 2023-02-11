package com.tinnova.vehicles.exercises;

public class Exercise1 {
	
    private static final float totalOfVoters = 1000;
    private static final float valid = 800;
    private static final float white = 150;
    private static final float nulls = 50;

	public static float calcPercentageOfValidVotes() {
		return calculatePercentage(valid);
	}
	
	public static float calcPercentageOfWhiteVotes() {
		return calculatePercentage(white);
	}
	
	public static float calcPercentageOfNullVotes() {
		return calculatePercentage(nulls);
	}
	
	private static float calculatePercentage(float nulls) {
		return nulls / Exercise1.totalOfVoters;
	}
	
}
