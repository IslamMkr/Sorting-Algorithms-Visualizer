package com.ismkr.sort_algo_visualizer.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

public class MainView extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MainView(MenuView menu, VisualView visual) {
		setType(Type.POPUP);
		setTitle("Sorting Algorithms Visualizer");
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 500);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		visual.setBounds(200, 0, 631, 461);
		contentPane.add(visual);
		
		menu.setBounds(0, 0, 200, 500);
		contentPane.add(menu);
	}

}
