/*
 * 
 */
package main;

import java.awt.Dimension;
import java.sql.SQLException;

import controller.ControllerFacade;
import model.ModelFacade;
import view.ViewFacade;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        final ModelFacade model = new ModelFacade();
        final ControllerFacade controller = new ControllerFacade(model);
        final ViewFacade view = new ViewFacade(controller, controller, model,
                new Dimension(640, 384));
        controller.setView(view);

        try {
            controller.start();
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
    }

}
