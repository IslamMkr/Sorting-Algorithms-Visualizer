package com.ismkr.sort_algo_visualizer.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

public class App extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4968883493807251846L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public App() {
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
		
		Visual visual = new Visual();
		visual.setBounds(200, 0, 631, 461);
		contentPane.add(visual);
		
		Menu menu = new Menu(visual);
		menu.setBounds(0, 0, 200, 500);
		contentPane.add(menu);
		
		visual.setListener(menu);
	}
}
