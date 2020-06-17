package com.ismkr.sort_algo_visualizer.algorithms;

import java.awt.Color;

import com.ismkr.sort_algo_visualizer.controllers.VisualController;
import com.ismkr.sort_algo_visualizer.model.Constants;

public class MergeSort {

	private final VisualController controller;
	private final int speed;

    public MergeSort(VisualController controller, int speed) {
        this.controller = controller;
        this.speed = speed;
        start(0, Constants.POLES_NUMBER - 1);
        updateUi();
    }

    private void start(int startIndex, int lastIndex) {
    	if(startIndex < lastIndex) {
    		int middle = (startIndex + lastIndex) / 2; // Middle index in array
    		
			start(startIndex, middle); // Sorting left side of array
    		start(middle + 1, lastIndex); // Sorting right side of array
    		
    		merge(startIndex, middle, lastIndex);
    	}
    }
    
    private void merge(int startIndex, int middle, int lastIndex) {
    	int leftSideLength = middle - startIndex + 1;
    	int rightSideLength = lastIndex - middle;
    	
    	int[] leftSide = new int[leftSideLength]; // Temporary copy of left side
    	int[] rightSide = new int[rightSideLength]; // Temporary copy of right side
    	
    	// Copying values
    	for(int i=0; i < leftSideLength; i++) leftSide[i] = controller.getLength(startIndex + i);
    	for(int i=0; i < rightSideLength; i++) rightSide[i] = controller.getLength(middle + i + 1);
    	
    	int i = 0, j = 0;
    	
    	int tempIndex = startIndex;
    	
    	// Swaping
    	while(i < leftSideLength && j < rightSideLength) {
    		if(leftSide[i] <= rightSide[j]) {
    			controller.setLength(tempIndex, leftSide[i]);
    			i++;
        		tempIndex++;
        		try {
    				Thread.sleep(speed);
    				controller.repaint();
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		} else {
    			controller.setLength(tempIndex, rightSide[j]);
    			j++;
        		tempIndex++;
        		try {
    				Thread.sleep(speed);
    				controller.repaint();
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}
    		
    		controller.setColor(startIndex + i, Color.magenta);
    		controller.setColor(middle + j, Color.magenta);

        	try {
   				controller.repaint();
    			Thread.sleep(speed);
    			controller.setColor(startIndex + i, Color.DARK_GRAY);
        		controller.setColor(middle + j, Color.DARK_GRAY);
   				controller.repaint();
   			} catch (InterruptedException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			}
    	}
    	
    	// Copying any left values
    	while(i < leftSideLength) {
    		controller.setLength(tempIndex, leftSide[i]);
			i++;
    		tempIndex++;
    		try {
				Thread.sleep(speed);
				controller.repaint();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	while(j < rightSideLength) {
    		controller.setLength(tempIndex, rightSide[j]);
			j++;
    		tempIndex++;
    		try {
				Thread.sleep(speed);
				controller.repaint();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	
    }

    private void updateUi() {
		for(int i=0; i < Constants.POLES_NUMBER; i++) {
			try {
				controller.setColor(i, Color.green);
	            controller.repaint();
	            Thread.sleep(speed);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}
	}
	
}
