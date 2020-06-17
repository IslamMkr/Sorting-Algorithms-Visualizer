package com.ismkr.sort_algo_visualizer.algorithms;

import java.awt.Color;

import com.ismkr.sort_algo_visualizer.controllers.VisualController;
import com.ismkr.sort_algo_visualizer.model.Constants;

public class SelectionSort {

	private final VisualController controller;
	private final int speed;

    public SelectionSort(VisualController controller, int speed) {
        this.controller = controller;
        this.speed = speed;
        start();
        updateUi();
    }

    private void start() {
        for (int i = 0; i < Constants.POLES_NUMBER-1; i++) {
        	controller.setColor(i, Color.magenta);
            int index = i;
            for (int j = i+1; j < Constants.POLES_NUMBER; j++) {
            	controller.setColor(j, Color.orange);
                if (controller.getLength(j) < controller.getLength(index)) {
                    index = j;
                }
                try {
                	controller.repaint();
                    Thread.sleep(speed);
                	controller.setColor(j, Color.darkGray);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
            	controller.setColor(index, Color.orange);
                controller.repaint();
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int temp = controller.getLength(index);
			controller.setLength(index, controller.getLength(i));
			controller.setLength(i, temp);

            try {
                if (index != i) 
                	controller.setColor(index, Color.darkGray);
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
