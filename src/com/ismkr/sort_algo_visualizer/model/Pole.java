package com.ismkr.sort_algo_visualizer.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.concurrent.ThreadLocalRandom;

public class Pole {

	private static final int LENGTH_FACTOR = 2;
    private static final int MAX_HEIGHT = 220;
    public static final int WIDTH = 5;
    private int length;
    private Point position;
    private Color color = Color.DARK_GRAY;

    public Pole(Point position) {
        this.position = position;
        this.length = ThreadLocalRandom.current().nextInt(1, MAX_HEIGHT + 1);
    }

    public int getLength() { return length; }
    public Point getPosition() { return position; }

    public void setPosition(Point position) { this.position = position; }
    public void setColor(Color color) { this.color = color; }
    public void setLength(int length) { this.length = length; }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(position.x, position.y, WIDTH, length * LENGTH_FACTOR);

    }

    public void reset() {
        this.length = ThreadLocalRandom.current().nextInt(1, MAX_HEIGHT + 1);
        setColor(Color.DARK_GRAY);
    }
	
}
