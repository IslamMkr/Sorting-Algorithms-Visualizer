package com.ismkr.sort_algo_visualizer.algorithms;

import java.awt.Color;

import com.ismkr.sort_algo_visualizer.ui.Visual;

public class BubbleSort {

	private final Visual visual;
	private final int speed;

    public BubbleSort(Visual visual, int speed) {
        this.visual = visual;
        this.speed = speed;
        start();
    }

    private void start() {
        boolean end;

        for (int i=0; i < Visual.POLES_NUMBER - 1; i++) {
            end = true;
            for (int j = 0; j < Visual.POLES_NUMBER - i - 1; j++) {
                Visual.poles[j].setColor(Color.MAGENTA);
                Visual.poles[j + 1].setColor(Color.orange);
                try {
                    visual.repaint();
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (Visual.poles[j].getLength() > Visual.poles[j + 1].getLength()) {
                    // Swaping lenghts
                    int temp = Visual.poles[j].getLength();
                    Visual.poles[j].setLength(Visual.poles[j + 1].getLength());
                    Visual.poles[j + 1].setLength(temp);
                    // Swaping colors
                    Visual.poles[j].setColor(Color.orange);
                    Visual.poles[j + 1].setColor(Color.MAGENTA);
                    end = false;
                }
                try {
                    visual.repaint();
                    Thread.sleep(speed);
                    Visual.poles[j].setColor(Color.darkGray);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (end) break;
        }
    }
	
}
