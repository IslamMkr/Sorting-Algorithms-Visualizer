package com.ismkr.sort_algo_visualizer.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import com.ismkr.sort_algo_visualizer.controllers.MenuController;
import com.ismkr.sort_algo_visualizer.listeners.IActionRequired;
import com.ismkr.sort_algo_visualizer.listeners.IThreadStoped;
import com.ismkr.sort_algo_visualizer.model.Constants;

import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MenuView extends JPanel implements ActionListener {
	
	private JButton startBtn;
	private JButton newArrayBtn;
	private JComboBox<Object> sortAlgoCB;
	private ButtonGroup speedGroup = new ButtonGroup();
	private JRadioButton fastRB;
	private JRadioButton mediumRB;
	
	private MenuController controller;

	/**
	 * Create the panel.
	 */
	public MenuView(MenuController controller) {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		this.controller = controller;
		
		JPanel titelBack = new JPanel();
		titelBack.setBackground(new Color(0, 128, 128));
		titelBack.setBounds(0, 0, 200, 88);
		add(titelBack);
		titelBack.setLayout(null);
		
		JLabel titleLbl = new JLabel("<html>Sorting Algos<br>Visualizer</html>");
		titleLbl.setForeground(new Color(255, 255, 255));
		titleLbl.setBounds(0, 11, 180, 66);
		titelBack.add(titleLbl);
		titleLbl.setBackground(new Color(255, 255, 255));
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setFont(new Font("Century Gothic", Font.BOLD, 25));
		
		JLabel lblNewLabel = new JLabel("Select Algorithm :");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 99, 180, 19);
		add(lblNewLabel);
		
		fastRB = new JRadioButton("Fast");
		fastRB.setBackground(new Color(255, 255, 255));
		fastRB.setSelected(true);
		fastRB.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		fastRB.setBounds(10, 185, 180, 23);
		add(fastRB);
		
		mediumRB = new JRadioButton("Medium");
		mediumRB.setBackground(new Color(255, 255, 255));
		mediumRB.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		mediumRB.setBounds(10, 205, 180, 23);
		add(mediumRB);
		
		JRadioButton lowRB = new JRadioButton("Low");
		lowRB.setBackground(new Color(255, 255, 255));
		lowRB.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lowRB.setBounds(10, 224, 180, 23);
		add(lowRB);
		
		speedGroup.add(fastRB);
		speedGroup.add(mediumRB);
		speedGroup.add(lowRB);
		
		JLabel lblSelectSpeed = new JLabel("Select Speed :");
		lblSelectSpeed.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblSelectSpeed.setBounds(10, 159, 180, 19);
		add(lblSelectSpeed);
		
		startBtn = new JButton("START");
		startBtn.setForeground(new Color(255, 255, 255));
		startBtn.setFont(new Font("Century Gothic", Font.BOLD, 15));
		startBtn.setBackground(new Color(0, 128, 128));
		startBtn.setBounds(10, 418, 180, 30);
		startBtn.addActionListener(this);
		add(startBtn);
		
		newArrayBtn = new JButton("Genrate New Array");
		newArrayBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		newArrayBtn.setBackground(Color.WHITE);
		newArrayBtn.setBounds(10, 267, 180, 30);
		newArrayBtn.addActionListener(this);
		add(newArrayBtn);
		
		sortAlgoCB = new JComboBox<>();
		sortAlgoCB.setFont(new Font("Century Gothic", Font.BOLD, 15));
		sortAlgoCB.setModel(new DefaultComboBoxModel<Object>(Constants.ALGORITHMS));
		sortAlgoCB.setBounds(10, 126, 180, 22);
		add(sortAlgoCB);
	}

	public void enableButtons() {
		startBtn.setEnabled(true);
		newArrayBtn.setEnabled(true);
	}

	private void disableButtons() {
		startBtn.setEnabled(false);
		newArrayBtn.setEnabled(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startBtn) {
			disableButtons();
			String algorithm = sortAlgoCB.getSelectedItem().toString();

			if(fastRB.isSelected()) controller.startButtonClicked(algorithm, Constants.FAST);
			else if(mediumRB.isSelected()) controller.startButtonClicked(algorithm, Constants.MEDIUM);
			else controller.startButtonClicked(algorithm, Constants.LOW);
		} 
		else if(e.getSource() == newArrayBtn) {
			if(newArrayBtn.isEnabled()) controller.generateNewArray();
		}
	}
	
}
