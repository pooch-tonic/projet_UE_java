/*
*
*/
package controller;

import java.sql.SQLException;

import modelInterfaces.IModel;
import showboard.IPawn;
import showboard.ISquare;
import viewInterfaces.IView;

public class LevelLoader {

	public LevelLoader() {
		// TODO level loader constructor
	}

	/**
	 * @param idLevel
	 * @param model
	 * @param view
	 */
	public void loadLevel(final int idLevel, final IModel model, final IView view) {

		try {
			model.loadLevel(idLevel);
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
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
	 * Generates the next level
	 *
	 * @param model
	 * @param view
	 */
	public void loadNextLevel(final IModel model, final IView view) {
		this.loadLevel(model.getLevel().getId() + 1, model, view);

	}

	/**
	 * Regenerates the current level
	 *
	 * @param model
	 * @param view
	 */
	public void resetLevel(final IModel model, final IView view) {
		this.loadLevel(model.getLevel().getId(), model, view);
	}
}
