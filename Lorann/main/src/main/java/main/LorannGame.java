package main;

import java.awt.Dimension;
import java.sql.SQLException;

import controller.ControllerFacade;
import model.ModelFacade;
import view.ViewFacade;

public class LorannGame {
	final ModelFacade model = new ModelFacade();
	final ControllerFacade controller = new ControllerFacade(this.model);
	final ViewFacade view = new ViewFacade(this.controller, this.controller, this.model, new Dimension(640, 384));

	LorannGame() {
		this.getController().setView(this.getView());

		try {
			this.getController().start();
		} catch (final SQLException exception) {
			exception.printStackTrace();
		}
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

	/**
	 * @return the view
	 */
	private ViewFacade getView() {
		return this.view;
	}

}
