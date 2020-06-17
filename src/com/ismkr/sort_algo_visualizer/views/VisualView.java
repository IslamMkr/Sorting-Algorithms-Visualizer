package com.ismkr.sort_algo_visualizer.views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

import com.ismkr.sort_algo_visualizer.model.Constants;
import com.ismkr.sort_algo_visualizer.model.Pole;

public class VisualView extends JPanel{
	
    private static Pole[] poles; // Array to be sorted

    public VisualView() {
    	poles = new Pole[Constants.POLES_NUMBER];
    	
        for (int i=0; i < Constants.POLES_NUMBER; i++) 
        	poles[i] = new Pole(new Point(i * (Constants.WIDTH + 2), 0));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Pole pole : poles) pole.draw(g);
    }
	
	public void setColor(int position, Color color) { poles[position].setColor(color);}
	public void setLength(int position, int length) { poles[position].setLength(length); }
	public int getLength(int position) { return poles[position].getLength(); }

    /**
     * Generate a new array
     */
	public void reset() { for(Pole pole : poles) pole.reset(); }

}
