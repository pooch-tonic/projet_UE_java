/*
*
*/
package controller;

import java.sql.SQLException;

import modelinterfaces.IModel;
import showboard.IPawn;
import showboard.ISquare;
import viewinterfaces.IView;

/**
 * <h1>The LevelLoader class.</h1> Allows to forward the level content to the
 * view's Showboard.
 *
 * @author Ryo
 *
 */
public class LevelLoader {

	/**
	 * Loads the level from the MySQL database to put it into the board.
	 *
	 * @param idLevel
	 *            the level id
	 * @param model
	 *            the model
	 * @param view
	 *            the view
	 */
	public void loadLevel(final int idLevel, final IModel model, final IView view) {

		try {
			model.loadLevel(idLevel);
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		view.removeAllPawnsFromBoard();
		final ISquare[][] squares = model.getLevel().getUnits();
		System.out.println(squares.length);
		System.out.println(squares[0].length);
		for (int x = 0; x < squares.length; x++) {
			for (int y = 0; y < squares[0].length; y++) {
				view.getBoardFrame().addSquare(squares[x][y], x, y);
			}
		}

		for (final IPawn entity : model.getLevel().getEntities()) {
			view.getBoardFrame().addPawn(entity);
		}
	}

	/**
	 * Generates the next level.
	 *
	 * @param model
	 *            the model
	 * @param view
	 *            the view
	 */
	public void loadNextLevel(final IModel model, final IView view) {
		this.loadLevel(model.getLevel().getId() + 1, model, view);

	}

	/**
	 * Regenerates the current level.
	 *
	 * @param model
	 *            the model
	 * @param view
	 *            the view
	 */
	public void resetLevel(final IModel model, final IView view) {
		this.loadLevel(model.getLevel().getId(), model, view);
	}
}
