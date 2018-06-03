/*
 *
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import controllerInterfaces.IController;
import controllerInterfaces.IOrderPerformer;
import controllerInterfaces.IOrderStacker;
import enums.DirectionEnum;
import enums.OrderEnum;
import modelInterfaces.IEntity;
import modelInterfaces.IModel;
import modelInterfaces.IUnit;
import showboard.IBoard;
import vector.IVector;
import vector.Vector;
import viewInterfaces.IView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller
 * component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IController, IOrderStacker, IOrderPerformer {

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

    private ArrayList<OrderEnum> stackOrder;

    /**
     * Instantiates a new ControllerFacade
     *
     * @param model
     */
    public ControllerFacade(final IModel model) {
        // TODO mettre super() si ca marche pas
        this.model = model;
        this.setBoard(null);
        this.setInteractionManager(new InteractionManager());
        this.setLevelLoader(new LevelLoader());
        this.setStackOrder(new ArrayList<>());
    }

    /**
     * Start.
     *
     * @throws SQLException
     *             the SQL exception
     */
    public void start() throws SQLException {
        this.loadLevel(1);
    }

    /*
     * (non-Javadoc)
     *
     * @see controllerInterfaces.IController#update()
     */
    @Override
    public void update() {
        // TODO Auto-generated method stub
        this.updateEntities();
        this.setStackOrder(new ArrayList<>());
    }

    /**
     * Update the entities of the model
     */
    private void updateEntities() {
        this.performOrder();
        for (final IEntity entity : this.getModel().getLevel().getEntities()) {
            IEntity target;
            if (this.getNextTile(entity) != null) {
                entity.bounce();
            } else {
                // TODO change and use getAddResult
                final IVector targetPosition = new Vector(entity.getPosition());
                targetPosition.add(entity.getDirection());
                target = this.getModel().getLevel().getEntityOn(targetPosition);

                this.performInteraction(entity, target, this.getInteractionManager()
                        .getInteractionOnNextPositionBetween(entity, target));
            }
            target = this.getModel().getLevel().getEntityOn(entity.getPosition());

            this.performInteraction(entity, target, this.getInteractionManager()
                    .getInteractionOnCurrentPositionBetween(entity, target));
            entity.update();
        }
    }

    private IUnit getNextTile(final IEntity entity) {
        return this.getModel().getLevel().getUnits()[entity.getX()
                + entity.getDirection().getX()][entity.getY() + entity.getDirection().getY()];
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
    public void nextlevel() {
        this.getLevelLoader().loadNextLevel(this.getModel(), this.getView());
    }

    /*
     * (non-Javadoc)
     *
     * @see controllerInterfaces.IOrderStacker#stackOrder(enums.OrderEnum)
     */
    @Override
    public void stackOrder(final OrderEnum order) {
        // TODO Auto-generated method stub
        this.getStackOrder().add(order);
    }

    /*
     * (non-Javadoc)
     *
     * @see controllerInterfaces.IOrderPerformer#performOrder()
     */
    @Override
    public void performOrder() {
        // TODO Auto-generated method stub
        final OrderEnum order = this.getStackOrder().get(this.getStackOrder().size() - 1);

        switch (order) {
        case UP:
            this.getModel().setPlayerDirection(DirectionEnum.UP);
            break;
        case UPLEFT:
            this.getModel().setPlayerDirection(DirectionEnum.UPLEFT);
            break;
        case UPRIGHT:
            this.getModel().setPlayerDirection(DirectionEnum.UPRIGHT);
            break;
        case LEFT:
            this.getModel().setPlayerDirection(DirectionEnum.LEFT);
            break;
        case RIGHT:
            this.getModel().setPlayerDirection(DirectionEnum.RIGHT);
            break;
        case DOWN:
            this.getModel().setPlayerDirection(DirectionEnum.DOWN);
            break;
        case DOWNLEFT:
            this.getModel().setPlayerDirection(DirectionEnum.DOWNLEFT);
            break;
        case DOWNRIGHT:
            this.getModel().setPlayerDirection(DirectionEnum.DOWNRIGHT);
            break;
        case CAST:
            // TODO call cast method
            this.getModel().setPlayerDirection(DirectionEnum.NONE);
            break;
        default:
            this.getModel().setPlayerDirection(DirectionEnum.NONE);
            break;
        }
    }

    private void performInteraction(final IEntity entity, final IEntity target,
            final Interaction interaction) {
        switch (interaction) {
        case ENTITY_DESTROYED:
            break;
        case TARGET_DESTROYED:
            break;
        case BOTH_DESTROYED:
            break;
        case BOUNCE:
            break;
        case DODGE:
            break;
        case UNLOCK_DOOR:
            break;
        case QUIT_LEVEL:
            this.nextlevel();
            break;
        default:
            break;
        }
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

    /**
     * Gets the stackOrder
     *
     * @return the stackOrder
     */
    private ArrayList<OrderEnum> getStackOrder() {
        return this.stackOrder;
    }

    /**
     * Sets the stackOrder
     *
     * @param stackOrder
     */
    private void setStackOrder(final ArrayList<OrderEnum> stackOrder) {
        this.stackOrder = stackOrder;
    }
}
