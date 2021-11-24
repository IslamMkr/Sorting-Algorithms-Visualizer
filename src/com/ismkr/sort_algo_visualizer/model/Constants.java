package com.ismkr.sort_algo_visualizer.model;

public class Constants {

	private Constants() {}
	
	public static final int FAST = 5;
	public static final int MEDIUM = 20;
	public static final int LOW = 500;

	public static final int POLES_NUMBER = 21;
	
	public static final int LENGTH_FACTOR = 2; // Variable to multiply length with..
	public static final int MAX_HEIGHT = 220; // Max length of pole
    public static final int WIDTH = 20; // Width of pole

	public static final Object[] ALGORITHMS = new String[] {
			"Bubble Sort", "Selection Sort", "Merge Sort", "Insertion Sort",
			"Quick Sort" , "Heap Sort"
		};
	
}
