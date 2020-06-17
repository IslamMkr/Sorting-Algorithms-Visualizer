package com.ismkr.sort_algo_visualizer.algorithms;

import java.awt.Color;

import com.ismkr.sort_algo_visualizer.controllers.VisualController;
import com.ismkr.sort_algo_visualizer.model.Constants;

public class InsertionSort {

	private final VisualController controller;
	private final int speed;

    public InsertionSort(VisualController controller, int speed) {
        this.controller = controller;
        this.speed = speed;
        start();
        updateUi();
    }

    private void start() {
        for (int i=1; i < Constants.POLES_NUMBER; i++) {
        	int current = controller.getLength(i);
            int j = i - 1;
            
        	try {
        		controller.setColor(i, Color.MAGENTA);
        		controller.repaint();
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        	
        	while(j >= 0 && controller.getLength(j) > current) {
        		controller.setLength(j + 1, controller.getLength(j));
        		j -= 1;

        		try {
        			controller.setColor(j + 1, Color.orange);
                    controller.repaint();
                    Thread.sleep(speed);
        			controller.setColor(j + 1, Color.darkGray);
        			controller.repaint();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        	}

        	controller.setLength(j + 1, current);
        	
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
