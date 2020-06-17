package com.ismkr.sort_algo_visualizer.algorithms;

import java.awt.Color;

import com.ismkr.sort_algo_visualizer.controllers.VisualController;
import com.ismkr.sort_algo_visualizer.model.Constants;

public class QuickSort {
	
	private final VisualController controller;
	private final int speed;

    public QuickSort(VisualController controller, int speed) {
        this.controller = controller;
        this.speed = speed;
        start(0, Constants.POLES_NUMBER - 1);
        updateUi();
    }

	private void start(int startIndex, int lastIndex) {
    	if(startIndex < lastIndex) {
    		// Index with the good value 
    		// No need to re-evaluate
    		int indexEnd = division(startIndex, lastIndex);
    		
            if(indexEnd - 1 > startIndex) start(startIndex, indexEnd - 1);
    		if(indexEnd + 1 < lastIndex) start(indexEnd + 1, lastIndex);
    	}
    }

	private int division(int startIndex, int lastIndex) {
		//int swapWithPivot = startIndex;
		
		for(int i = startIndex; i < lastIndex; i++) {
			try {
				controller.setColor(i, Color.MAGENTA);
                controller.repaint();
                Thread.sleep(speed);
				controller.setColor(i, Color.darkGray);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
			
			if(controller.getLength(i) < controller.getLength(lastIndex)) {
				try {
					controller.setColor(startIndex, Color.orange);
	                controller.repaint();
	                Thread.sleep(speed);
					controller.setColor(startIndex, Color.darkGray);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
				int temp = controller.getLength(i);
				controller.setLength(i, controller.getLength(startIndex));
				controller.setLength(startIndex, temp);
				startIndex += 1;
			}
		
		}

		int temp = controller.getLength(startIndex);
		controller.setLength(startIndex, controller.getLength(lastIndex));
		controller.setLength(lastIndex, temp);

		try {
            controller.repaint();
            Thread.sleep(speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
		return startIndex;
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
