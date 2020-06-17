package com.ismkr.sort_algo_visualizer.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.concurrent.ThreadLocalRandom;

public class Pole {

    private int length;
    private Point position;
    private Color color = Color.DARK_GRAY;

    public Pole(Point position) {
        this.position = position;
        this.length = ThreadLocalRandom.current().nextInt(1, Constants.MAX_HEIGHT + 1);
    }

    // Getters
    public int getLength() { return length; }
    public Point getPosition() { return position; }

    // Setters
    public void setPosition(Point position) { this.position = position; }
    public void setColor(Color color) { this.color = color; }
    public void setLength(int length) { this.length = length; }

    /**
     * Draws the representation of the pole with a rectangle
     * @param g @Graphics
     */
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(position.x, position.y, Constants.WIDTH, length * Constants.LENGTH_FACTOR);
    }

    /**
     * Generate a new length to the pole & reset color to dark gray
     */
    public void reset() {
        this.length = ThreadLocalRandom.current().nextInt(1, Constants.MAX_HEIGHT + 1);
        setColor(Color.DARK_GRAY);
    }
	
}
