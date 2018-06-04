package main;

import java.util.TimerTask;

import controller.ControllerFacade;

public class UpdateTask extends TimerTask{
	private ControllerFacade controller;
	
	public UpdateTask(ControllerFacade controller) {
		this.controller = controller;
	}

	@Override
	public void run() {
		controller.update();
	}
}
