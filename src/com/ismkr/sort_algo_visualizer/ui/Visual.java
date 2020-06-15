package com.ismkr.sort_algo_visualizer.ui;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

import com.ismkr.sort_algo_visualizer.algorithms.*;
import com.ismkr.sort_algo_visualizer.listeners.IActionRequired;
import com.ismkr.sort_algo_visualizer.listeners.IThreadStoped;
import com.ismkr.sort_algo_visualizer.model.Pole;

public class Visual extends JPanel implements IActionRequired {
	
	/**
	 * SV-UID
	 */
	private static final long serialVersionUID = 811748106302318027L;
	
	private IThreadStoped listener;

	public static final int POLES_NUMBER = 89;

    public static Pole[] poles = new Pole[POLES_NUMBER];
    private Thread algorithmThread = null;

    public Visual() {
        for (int i=0; i < POLES_NUMBER; i++) {
            poles[i] = new Pole(new Point(i * (Pole.WIDTH + 2), 0));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Pole pole : poles) pole.draw(g);
    }

	public void setListener(IThreadStoped listener) {
		this.listener = listener;
	}
    
    private void startAlgorithm(int speed, String algo) {
        Visual visual = this;
        
        if(algo.equals(Constants.ALGORITHMS[0])) algorithmThread = new Thread(() -> new BubbleSort(visual, speed));
        else if(algo.equals(Constants.ALGORITHMS[1])) algorithmThread = new Thread(() -> new SelectionSort(visual, speed));
        else if(algo.equals(Constants.ALGORITHMS[2])) algorithmThread = new Thread(() -> new MergeSort(visual, speed));
        
        algorithmThread.start();
        
        new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					algorithmThread.join();
					listener.threadStoped();
					algorithmThread = null;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
        }).start();
    }

	@Override
	public void reset() {
		for(Pole pole : poles) pole.reset();
		this.repaint();
	}

	@Override
	public void start(int speed, String algo) {
		startAlgorithm(speed, algo);
	}

	@Override
	public void stop() { }

}
