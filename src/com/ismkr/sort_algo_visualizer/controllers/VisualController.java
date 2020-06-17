package com.ismkr.sort_algo_visualizer.controllers;

import java.awt.Color;

import com.ismkr.sort_algo_visualizer.algorithms.BubbleSort;
import com.ismkr.sort_algo_visualizer.algorithms.HeapSort;
import com.ismkr.sort_algo_visualizer.algorithms.InsertionSort;
import com.ismkr.sort_algo_visualizer.algorithms.MergeSort;
import com.ismkr.sort_algo_visualizer.algorithms.QuickSort;
import com.ismkr.sort_algo_visualizer.algorithms.SelectionSort;
import com.ismkr.sort_algo_visualizer.listeners.IActionRequired;
import com.ismkr.sort_algo_visualizer.listeners.IThreadStoped;
import com.ismkr.sort_algo_visualizer.model.Constants;
import com.ismkr.sort_algo_visualizer.views.VisualView;

public class VisualController implements IActionRequired {

	private VisualView visual;
	private static IThreadStoped listener;
    private static Thread algorithmThread = null; // The algorithm thread 
	private static boolean isSorted = false; // The array if sorted
	
	public VisualController(IThreadStoped listener) {
		VisualController.listener = listener;
		
		visual = new VisualView();
	}
	
	public void setColor(int position, Color color) { visual.setColor(position, color); }
	public void setLength(int position, int length) { visual.setLength(position, length); }
	public int getLength(int position) { return visual.getLength(position); }
	public VisualView getView() { return visual; }
	
	public void repaint() { visual.repaint(); }

	@Override
	public void reset() {
		visual.reset();
		isSorted = false;
		visual.repaint();
	}

	/**
	 * Start the sort algorithm if it is not sorted yet
	 * Else it generates a new array
	 * @param speed @Integer
	 * @param algo @String
	 */
	@Override
	public void start(String algorithm, int speed) {
		if(isSorted) { // It is sorted we need first to generate a new unsorted array
			reset();
			isSorted = false;
			listener.threadStoped();
		}
		else { 
			startAlgorithm(this, algorithm, speed);
		}
	}
	
	/**
	 * Start a new thread with the specified algorithm
	 * @param speed @Integer
	 * @param algo @String
	 */
	public static void startAlgorithm(VisualController controller, String algorithm, int speed) {
        if(algorithm.equals(Constants.ALGORITHMS[0])) algorithmThread = new Thread(() -> new BubbleSort(controller, speed));
        else if(algorithm.equals(Constants.ALGORITHMS[1])) algorithmThread = new Thread(() -> new SelectionSort(controller, speed));
        else if(algorithm.equals(Constants.ALGORITHMS[2])) algorithmThread = new Thread(() -> new MergeSort(controller, speed));
        else if(algorithm.equals(Constants.ALGORITHMS[3])) algorithmThread = new Thread(() -> new InsertionSort(controller, speed));
        else if(algorithm.equals(Constants.ALGORITHMS[4])) algorithmThread = new Thread(() -> new QuickSort(controller, speed));
        else if(algorithm.equals(Constants.ALGORITHMS[5])) algorithmThread = new Thread(() -> new HeapSort(controller, speed));
        
        algorithmThread.start();
        waitAlgorithmTillEnd();
	}
	
	/**
	 * Waiting till the end of the thread to notify listener
	 */
	public static void waitAlgorithmTillEnd() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					algorithmThread.join(); // Waiting thread to finish
					listener.threadStoped(); // Notifying lsitener
					isSorted = true; // The array is sorted
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
        }).start();
	}
	
}
