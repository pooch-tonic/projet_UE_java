/*
 *
 */
package main;

import java.awt.Dimension;
import java.sql.SQLException;

import controller.ControllerFacade;
import model.ModelFacade;
import model.Unit;
import view.ViewFacade;

public class LorannGame {
    public static int      FRAME_WIDTH  = 640;
    public static int      FRAME_HEIGHT = 384;
    public static int      GAME_WIDTH   = FRAME_WIDTH / Unit.getSize();
    public static int      GAME_HEIGHT  = FRAME_HEIGHT / Unit.getSize();
    final ModelFacade      model;
    final ControllerFacade controller;
    final ViewFacade       view;

    LorannGame() {
        this.model = new ModelFacade(new Dimension(LorannGame.GAME_WIDTH, LorannGame.GAME_HEIGHT));
        this.controller = new ControllerFacade(this.model);
        this.view = new ViewFacade(this.controller, this.controller, this.model,
                new Dimension(LorannGame.FRAME_WIDTH, LorannGame.FRAME_HEIGHT), this.model,
                LorannGame.GAME_WIDTH, LorannGame.GAME_HEIGHT);
        this.getController().setView(this.getView());

        try {
            this.getController().start();
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }

        // TODO verifier la bonne pratique
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

    /**
     * @return the view
     */
    private ViewFacade getView() {
        return this.view;
    }

    public void play() {
        // TODO ENLEVER CETTE BOUCLE
        while (true) {
            this.controller.update();
        }
    }

}
