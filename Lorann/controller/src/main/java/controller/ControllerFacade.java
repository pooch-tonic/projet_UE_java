/*
 *
 */
package controller;

import java.sql.SQLException;

import controllerInterfaces.IController;
import controllerInterfaces.IOrderStacker;
import enums.OrderEnum;
import modelInterfaces.IModel;
import showboard.IBoard;
import viewInterfaces.IView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller
 * component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IController, IOrderStacker {

	/** The view. */
	private IView view;

	/** The model. */
	private final IModel model;

	/** The board. */
	private IBoard board;

	/** The interaction manager. */
	private InteractionManager interactionManager;

	/** The level loader. */
	private LevelLoader levelLoader;

	/**
	 * Instantiates a new ControllerFacade
	 *
	 * @param model
	 */
	public ControllerFacade(final IModel model) {
		super();
		this.model = model;
	}

	/**
	 * @return the board
	 */
	private IBoard getBoard() {
		return this.board;
	}

	/**
	 * @return the interactionManager
	 */
	private InteractionManager getInteractionManager() {
		return this.interactionManager;
	}

	/**
	 * @return the levelLoader
	 */
	private LevelLoader getLevelLoader() {
		return this.levelLoader;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public IModel getModel() {
		return this.model;
	}

	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	public IView getView() {
		return this.view;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see controllerInterfaces.IController#loadLevel(int)
	 */
	@Override
	public void loadLevel(final int id) {
		this.getLevelLoader().loadLevel(id, this.getModel(), this.getView());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see controllerInterfaces.IController#nextlevel(int)
	 */
	@Override
	public void nextlevel(final int currentLevelId) {
		this.getLevelLoader().loadNextLevel(this.getModel(), this.getView());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see controllerInterfaces.IController#setBoard(showboard.IBoard)
	 */
	@Override
	public void setBoard(final IBoard board) {
		// TODO Auto-generated method stub
		this.board = board;
	}

	/**
	 * @param interactionManager
	 *            the interactionManager to set
	 */
	private void setInteractionManager(final InteractionManager interactionManager) {
		this.interactionManager = interactionManager;
	}

	/**
	 * @param levelLoader
	 *            the levelLoader to set
	 */
	private void setLevelLoader(final LevelLoader levelLoader) {
		this.levelLoader = levelLoader;
	}

	/**
	 * @param view
	 */
	public void setView(final IView view) {
		this.view = view;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see controllerInterfaces.IOrderStacker#stackOrder(enums.OrderEnum)
	 */
	@Override
	public void stackOrder(final OrderEnum userOrder) {
		// TODO Auto-generated method stub

	}

	/**
	 * Start.
	 *
	 * @throws SQLException
	 *             the SQL exception
	 */
	public void start() throws SQLException {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see controllerInterfaces.IController#update()
	 */
	@Override
	public void update() {
		// TODO Auto-generated method stub

	}
}
