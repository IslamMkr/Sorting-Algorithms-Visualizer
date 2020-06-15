package com.ismkr.sort_algo_visualizer.algorithms;

import java.awt.Color;

import com.ismkr.sort_algo_visualizer.ui.Visual;

public class MergeSort {

	private final Visual visual;
	private final int speed;

    public MergeSort(Visual visual, int speed) {
        this.visual = visual;
        this.speed = speed;
        start(0, Visual.POLES_NUMBER - 1);
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
    	for(int i=0; i < leftSideLength; i++) leftSide[i] = Visual.poles[startIndex + i].getLength(); 
    	for(int i=0; i < rightSideLength; i++) rightSide[i] = Visual.poles[middle + i + 1].getLength();
    	
    	int i = 0, j = 0;
    	
    	int tempIndex = startIndex;
    	
    	// Swaping
    	while(i < leftSideLength && j < rightSideLength) {
    		if(leftSide[i] <= rightSide[j]) {
    			Visual.poles[tempIndex].setLength(leftSide[i]);
    			i++;
        		tempIndex++;
        		try {
    				Thread.sleep(speed);
    				visual.repaint();
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		} else {
    			Visual.poles[tempIndex].setLength(rightSide[j]);
    			j++;
        		tempIndex++;
        		try {
    				Thread.sleep(speed);
    				visual.repaint();
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}
    		

        	Visual.poles[startIndex + i].setColor(Color.magenta);
        	Visual.poles[middle + j].setColor(Color.magenta);
        	try {
   				visual.repaint();
    			Thread.sleep(speed);
            	Visual.poles[startIndex + i].setColor(Color.DARK_GRAY);
            	Visual.poles[middle + j].setColor(Color.DARK_GRAY);
   				visual.repaint();
   			} catch (InterruptedException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			}
    	}
    	
    	// Copying any left values
    	while(i < leftSideLength) {
			Visual.poles[tempIndex].setLength(leftSide[i]);
			i++;
    		tempIndex++;
    		try {
				Thread.sleep(speed);
				visual.repaint();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	while(j < rightSideLength) {
			Visual.poles[tempIndex].setLength(rightSide[j]);
			j++;
    		tempIndex++;
    		try {
				Thread.sleep(speed);
				visual.repaint();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	
    }
	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
