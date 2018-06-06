/*
 *
 */
package main;

import java.awt.Dimension;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

import controller.ControllerFacade;
import model.ModelFacade;
import model.Unit;
import view.ViewFacade;

public class LorannGame {
	public static final float RESIZE_SCALE = 1.5f;
	public static final int GAME_WIDTH = 20;
	public static final int GAME_HEIGHT = 12;
	public static int FRAME_HEIGHT = (int) (GAME_HEIGHT * Unit.getSize() * RESIZE_SCALE);
	public static int FRAME_WIDTH = (int) (GAME_WIDTH * Unit.getSize() * RESIZE_SCALE);
	final ModelFacade model;
	final ControllerFacade controller;
	final ViewFacade view;

	LorannGame() {
		this.model = new ModelFacade(new Dimension(LorannGame.GAME_WIDTH, LorannGame.GAME_HEIGHT));
		this.controller = new ControllerFacade(this.getModel());
		this.view = new ViewFacade(this.getController(), this.getController(), this.getModel(),
				new Dimension(LorannGame.FRAME_WIDTH, LorannGame.FRAME_HEIGHT), this.getModel(), LorannGame.GAME_WIDTH,
				LorannGame.GAME_HEIGHT);

		try {
			this.getController().start();
		} catch (final SQLException exception) {
			exception.printStackTrace();
		}

		this.play();
	}

	/**
	 * @return the controller
	 */
	private ControllerFacade getController() {
		return this.controller;
	}

	/**
	 * @return the model
	 */
	private ModelFacade getModel() {
		return this.model;
	}

	public void play() {
		final TimerTask task = new UpdateTask(this.getController());
		final Timer timer = new Timer();
		timer.scheduleAtFixedRate(task, 100, 115);
	}

}
