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
    public static final int RESIZE_SCALE = 2;
    public static final int GAME_WIDTH   = 20;
    public static final int GAME_HEIGHT  = 12;
    public static int       FRAME_HEIGHT = GAME_HEIGHT * Unit.getSize() * RESIZE_SCALE;
    public static int       FRAME_WIDTH  = GAME_WIDTH * Unit.getSize() * RESIZE_SCALE;
    final ModelFacade       model;
    final ControllerFacade  controller;
    final ViewFacade        view;

    LorannGame() {
        this.model = new ModelFacade(new Dimension(LorannGame.GAME_WIDTH, LorannGame.GAME_HEIGHT));
        this.controller = new ControllerFacade(this.model);
        this.view = new ViewFacade(this.controller, this.controller, this.model,
                new Dimension(LorannGame.FRAME_WIDTH, LorannGame.FRAME_HEIGHT), this.model,
                LorannGame.GAME_WIDTH, LorannGame.GAME_HEIGHT);

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
        final TimerTask task = new UpdateTask(this.getController());
        final Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 100, 115);
    }

}
