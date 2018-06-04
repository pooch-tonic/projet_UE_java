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

	/**
	 * @param idLevel
	 * @param model
	 * @param view
	 */

	public LevelLoader() {
		// TODO level loader constructor
	}

	public void loadLevel(final int idLevel, final IModel model, final IView view) {

		try {
			model.loadLevel(idLevel);
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final ISquare[][] squares = model.getLevel().getUnits();
		for (int x = 0; x < squares.length; x++) {
			for (int y = 0; y < squares[0].length; y++) {
				// System.out.println(squares[x][y]); //TODO a supprimer
				view.getBoardFrame().addSquare(squares[x][y], x, y);
			}
		}

		for (final IPawn entity : model.getLevel().getEntities()) {
			view.getBoardFrame().addPawn(entity);
		}
	}

	/**
	 * @param model
	 * @param view
	 */
	public void loadNextLevel(final IModel model, final IView view) {
		this.loadLevel(model.getLevel().getId() + 1, model, view);

	}
}
