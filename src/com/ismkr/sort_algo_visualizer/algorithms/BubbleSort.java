package com.ismkr.sort_algo_visualizer.algorithms;

import java.awt.Color;

import com.ismkr.sort_algo_visualizer.controllers.VisualController;
import com.ismkr.sort_algo_visualizer.model.Constants;

public class BubbleSort {

	private VisualController controller;
	private int speed;

    public BubbleSort(VisualController controller, int speed) {
        this.controller = controller;
        this.speed = speed;
        start();
        updateUi();
    }

    private void start() {
        boolean end;

        for (int i=0; i < Constants.POLES_NUMBER - 1; i++) {
            end = true;
            for (int j = 0; j < Constants.POLES_NUMBER - i - 1; j++) {
            	controller.setColor(j, Color.MAGENTA);
            	controller.setColor(j + 1, Color.orange);
                try {
                	controller.repaint();
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (controller.getLength(j) > controller.getLength(j + 1)) {
                    // Swaping lenghts
                    int temp = controller.getLength(j);
                    controller.setLength(j, controller.getLength(j + 1));
                    controller.setLength(j + 1, temp);
                    // Swaping colors
                    controller.setColor(j, Color.orange);
                    controller.setColor(j + 1, Color.MAGENTA);
                    end = false;
                }
                try {
                	controller.repaint();
                    Thread.sleep(speed);
                    controller.setColor(j, Color.darkGray);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (end) break;
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
