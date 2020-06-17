package com.ismkr.sort_algo_visualizer.controllers;

import com.ismkr.sort_algo_visualizer.listeners.IActionRequired;
import com.ismkr.sort_algo_visualizer.listeners.IThreadStoped;
import com.ismkr.sort_algo_visualizer.views.MenuView;

public class MenuController implements IThreadStoped {

	private MenuView menu;
	private IActionRequired listener;
	
	public MenuController() {
		menu = new MenuView(this);
	}
	
	public void setListener(IActionRequired listener) { this.listener = listener; }
	public MenuView getView() { return menu; }

	@Override
	public void threadStoped() {
		menu.enableButtons();
	}
	
	public void startButtonClicked(String algorithm, int speed) {
		listener.start(algorithm, speed);
	}
	
	public void generateNewArray() {
		listener.reset();
	}
	
}
