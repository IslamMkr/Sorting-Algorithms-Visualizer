package com.ismkr.sort_algo_visualizer.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import com.ismkr.sort_algo_visualizer.algorithms.Constants;
import com.ismkr.sort_algo_visualizer.listeners.IActionRequired;
import com.ismkr.sort_algo_visualizer.listeners.IThreadStoped;

import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Menu extends JPanel implements IThreadStoped {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6363588429586851223L;
	
	private JButton startBtn;
	private JButton newArrayBtn;
	
	private JComboBox<Object> sortAlgoCB;
	
	private ButtonGroup speedGroup = new ButtonGroup();
	

	private IActionRequired listener;

	/**
	 * Create the panel.
	 */
	public Menu(IActionRequired listener) {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		this.listener = listener;
		
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
		
		JRadioButton fastRB = new JRadioButton("Fast");
		fastRB.setBackground(new Color(255, 255, 255));
		fastRB.setSelected(true);
		fastRB.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		fastRB.setBounds(10, 185, 180, 23);
		add(fastRB);
		
		JRadioButton mediumRB = new JRadioButton("Medium");
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
		add(startBtn);
		startBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newArrayBtn.setEnabled(false);
				startBtn.setEnabled(false);
				String algo = sortAlgoCB.getSelectedItem().toString();
				
				if(fastRB.isSelected()) startBtnClicked(Constants.FAST, algo);
				else if(mediumRB.isSelected()) startBtnClicked(Constants.MEDIUM, algo);
				else startBtnClicked(Constants.LOW, algo);
			}
		});
		
		newArrayBtn = new JButton("Genrate New Array");
		newArrayBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		newArrayBtn.setBackground(Color.WHITE);
		newArrayBtn.setBounds(10, 267, 180, 30);
		add(newArrayBtn);
		newArrayBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(newArrayBtn.isEnabled()) newArrayBtnClicked();
			}
		});
		
		sortAlgoCB = new JComboBox<>();
		sortAlgoCB.setFont(new Font("Century Gothic", Font.BOLD, 15));
		sortAlgoCB.setModel(new DefaultComboBoxModel<Object>(Constants.ALGORITHMS));
		sortAlgoCB.setBounds(10, 126, 180, 22);
		add(sortAlgoCB);
	}

	private void newArrayBtnClicked() {
		listener.reset();
	}

	private void stopBtnClicked() {	
		listener.stop();
	}

	private void startBtnClicked(int speed, String algo) {
		listener.start(speed, algo);
	}

	@Override
	public void threadStoped() {
		startBtn.setEnabled(true);
		newArrayBtn.setEnabled(true);
	}
	
}
