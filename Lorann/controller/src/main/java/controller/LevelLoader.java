package controller;


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
	public void loadLevel(final int idLevel, IModel model, IView view) {
		
		model.loadLevel(idLevel);
		ISquare[][] squares = model.getLevel().getSquare();
		for(int x = 0 ; x < squares.length; x++) {
			for(int y = 0 ; y < squares[0].length ; y++) {
				view.getBoardFrame().addSquare(squares[x][y], x, y);
			}
		}
		
		for (IPawn entity : model.getLevel().getEntities()) {
			view.getBoardFrame().addPawn(entity);
		}
	}

	/**
	 * @param model
	 * @param view
	 */
	public void loadNextLevel(IModel model, IView view) {
		this.loadLevel(model.getLevel().getId()+1, model, view);
	}

}
