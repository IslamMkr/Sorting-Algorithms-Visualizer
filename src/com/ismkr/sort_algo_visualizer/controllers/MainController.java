package com.ismkr.sort_algo_visualizer.controllers;

import java.awt.EventQueue;

import com.ismkr.sort_algo_visualizer.views.MainView;

public class MainController {
	
	private static MainView mainView;
	private static MenuController menuController;
	private static VisualController visualController;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuController = new MenuController();
					visualController = new VisualController(menuController);
					
					menuController.setListener(visualController);
					
					mainView = new MainView(menuController.getView(), visualController.getView());
					mainView.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
}
