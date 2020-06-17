package com.ismkr.sort_algo_visualizer.algorithms;

import java.awt.Color;

import com.ismkr.sort_algo_visualizer.controllers.VisualController;
import com.ismkr.sort_algo_visualizer.model.Constants;

public class HeapSort {

	private VisualController controller;
	private int speed;

    public HeapSort(VisualController controller, int speed) {
        this.controller = controller;
        this.speed = speed;
        start();
        updateUi();
    }

    private void start() {
        
    	for(int i = Constants.POLES_NUMBER / 2 - 1; i >= 0; i--) 
    		heapDivision(Constants.POLES_NUMBER, i);
   
    	for(int i = Constants.POLES_NUMBER - 1; i > 0; i--) {
    		int temp = controller.getLength(0);
    		controller.setLength(0, controller.getLength(i));
    		controller.setLength(i, temp);
            try {
                controller.repaint();
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            heapDivision(i, 0);
    	}
    	
    }

	private void heapDivision(int length, int i) {
		controller.setColor(i, Color.MAGENTA);
		controller.repaint();
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		
		if(left < length && controller.getLength(left) > controller.getLength(largest))
			largest = left;
		
		if(right < length && controller.getLength(right) > controller.getLength(largest))
			largest = right;
		
		if(largest != i) {
			try {
				controller.setColor(largest, Color.orange);
				controller.repaint();
	            Thread.sleep(speed);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
			
			int temp = controller.getLength(i);
			controller.setLength(i, controller.getLength(largest));
			controller.setLength(largest, temp);
            
			try {
				controller.setColor(largest, Color.darkGray);
				controller.setColor(i, Color.darkGray);
				controller.repaint();
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            heapDivision(length, largest);
		} else {
			try {
				controller.setColor(i, Color.darkGray);
                controller.repaint();
                Thread.sleep(speed);
            } catch (InterruptedException e) {
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
