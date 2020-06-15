package com.ismkr.sort_algo_visualizer.algorithms;

import java.awt.Color;

import com.ismkr.sort_algo_visualizer.ui.Visual;

public class SelectionSort {

	private final Visual visual;
	private final int speed;

    public SelectionSort(Visual visual, int speed) {
        this.visual = visual;
        this.speed = speed;
        start();
    }

    private void start() {
        for (int i = 0; i < Visual.POLES_NUMBER-1; i++) {
            Visual.poles[i].setColor(Color.MAGENTA);
            int index = i;
            for (int j = i+1; j < Visual.POLES_NUMBER; j++) {
                Visual.poles[j].setColor(Color.orange);
                if (Visual.poles[j].getLength() < Visual.poles[index].getLength()) {
                    index = j;
                }
                try {
                    visual.repaint();
                    Thread.sleep(speed);
                    Visual.poles[j].setColor(Color.darkGray);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                Visual.poles[index].setColor(Color.orange);
                visual.repaint();
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int temp = Visual.poles[index].getLength();
            Visual.poles[index].setLength(Visual.poles[i].getLength());
            Visual.poles[i].setLength(temp);

            try {
                if (index != i) Visual.poles[index].setColor(Color.darkGray);
                visual.repaint();
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
	
}
