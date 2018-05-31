package controller;

import java.sql.SQLException;
import java.util.List;

import controllerInterfaces.IController;
import controllerInterfaces.IOrderStacker;
import controllerInterfaces.IUserOrder;
import modelInterfaces.Example;
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

    private IBoard board;

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
     * Start.
     *
     * @throws SQLException
     *             the SQL exception
     */
    public void start() throws SQLException {
        this.getView()
                .displayMessage(this.getModel().getExampleById(1).toString());

        this.getView().displayMessage(
                this.getModel().getExampleByName("Example 2").toString());

        final List<Example> examples = this.getModel().getAllExamples();
        final StringBuilder message = new StringBuilder();
        for (final Example example : examples) {
            message.append(example);
            message.append('\n');
        }
        this.getView().displayMessage(message.toString());
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    public IView getView() {
        return this.view;
    }

    public void setView(final IView view) {
        this.view = view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel() {
        return this.model;
    }

    @Override
    public void stackOrder(final IUserOrder userOrder) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setBoard(final IBoard board) {
        // TODO Auto-generated method stub
        this.board = board;
    }
}
