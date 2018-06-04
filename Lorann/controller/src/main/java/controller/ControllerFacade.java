/*
 *
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import controllerInterfaces.IController;
import controllerInterfaces.IOrderPerformer;
import controllerInterfaces.IOrderStacker;
import enums.DirectionEnum;
import enums.OrderEnum;
import enums.Type;
import modelInterfaces.IEntity;
import modelInterfaces.IModel;
import modelInterfaces.IUnit;
import showboard.IBoard;
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

    private Iterator<IEntity> entityIterator;

    private ArrayList<IEntity> entitiesToDestroy;

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
        this.setEntitiesToDestroy(new ArrayList<>());
    }

    /**
     * Start.
     *
     * @throws SQLException
     *             the SQL exception
     */
    public void start() throws SQLException {
        this.nextlevel();
    }

    /*
     * (non-Javadoc)
     *
     * @see controllerInterfaces.IController#update()
     */
    @Override
    public void update() {
        this.getModel().update();
        this.setEntityIterator(this.getModel().getLevel().getEntities());
        this.performOrder();
        this.updateEntities();
        this.killEntities();
        this.setStackOrder(new ArrayList<>());
        this.setEntitiesToDestroy(new ArrayList<>());
    }

    private void killEntities() {
        for (final IEntity entity : this.getEntitiesToDestroy()) {
            this.getModel().destroyEntity(entity);
            this.getView().removePawnFromBoard(entity);
        }
    }

    /**
     * Update the entities of the model
     */
    private void updateEntities() {
        IEntity entity, target;
        while (this.getEntityIterator().hasNext()) {
            entity = this.getEntityIterator().next();
            // }
            // for (final IEntity entity : this.getModel().getLevel().getEntities()) {
            if (this.getNextTile(entity).getType() == Type.WALL) {
                entity.bounce(this.getModel().getLevel());
            } else if ((entity.getDirection().getX() != 0) || (entity.getDirection().getY() != 0)) {
                // TODO change and use getAddResult
                if ((target = this.getModel().getLevel().getEntityOn(
                        entity.getPosition().getAddResult(entity.getDirection()))) != null) {
                    this.performInteraction(entity, target, this.getInteractionManager()
                            .getInteractionOnNextPositionBetween(entity, target));
                    System.out.println(entity.getDirection().getX() + " : "
                            + entity.getDirection().getY() + " : " + entity);
                }

            }
            if ((target = this.getModel().getLevel().getEntityOverlapping(entity)) != null) {
                this.performInteraction(entity, target, this.getInteractionManager()
                        .getInteractionOnCurrentPositionBetween(entity, target));
            }
            entity.update();
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

    private IUnit getNextTile(final IEntity entity) {
        return this.getModel().getUnitOn(entity.getX() + entity.getDirection().getX(),
                entity.getY() + entity.getDirection().getY());
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
    public void nextlevel() {
        this.getLevelLoader().loadNextLevel(this.getModel(), this.getView());
    }

    private synchronized void performInteraction(final IEntity entity, final IEntity target,
            final Interaction interaction) {
        System.out.println(entity + " : " + interaction);
        switch (interaction) {
        case ENTITY_DESTROYED:
            this.getEntitiesToDestroy().add(entity);
            break;
        case TARGET_DESTROYED:
            this.getEntitiesToDestroy().add(target);
            break;
        case BOTH_DESTROYED:
            this.getEntitiesToDestroy().add(entity);
            this.getEntitiesToDestroy().add(target);
            break;
        case BOUNCE:
            entity.bounce(this.getModel().getLevel());
            break;
        case DODGE:
            entity.dodge(this.getModel().getLevel());
            break;
        case UNLOCK_DOOR:
            this.getEntitiesToDestroy().add(target);
            this.getModel().getExit().setType(Type.DOOR_OPEN);
            break;
        case QUIT_LEVEL:
            entity.bounce(this.getModel().getLevel());
            this.nextlevel();
            break;
        default:
            break;
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see controllerInterfaces.IOrderPerformer#performOrder()
     */
    @Override
    public void performOrder() {
        // TODO Auto-generated method stub
        OrderEnum order = OrderEnum.NONE;

        if (!this.getStackOrder().isEmpty()) {
            order = this.getStackOrder().get(this.getStackOrder().size() - 1);
        }

        switch (order) {
        case UP:
            System.out.println("yes");
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
            this.getModel().castSpell();
            this.getBoard().addPawn(this.getModel().getSpell());
            this.getModel().setPlayerDirection(DirectionEnum.NONE);
            break;
        default:
            this.getModel().setPlayerDirection(DirectionEnum.NONE);
            break;
        }
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
     * Sets the stackOrder
     *
     * @param stackOrder
     */
    private void setStackOrder(final ArrayList<OrderEnum> stackOrder) {
        this.stackOrder = stackOrder;
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
    public void stackOrder(final OrderEnum order) {
        // TODO Auto-generated method stub
        this.getStackOrder().add(order);
    }

    /**
     * Gets the entityIterator
     *
     * @return the entityIterator
     */
    private Iterator<IEntity> getEntityIterator() {
        return this.entityIterator;
    }

    /**
     * Sets the entityIterator
     *
     * @param entities
     */
    private void setEntityIterator(final ArrayList<IEntity> entities) {
        this.entityIterator = entities.iterator();
    }

    /**
     * Gets the entitiesToDestroy
     *
     * @return the entitiesToDestroy
     */
    private ArrayList<IEntity> getEntitiesToDestroy() {
        return this.entitiesToDestroy;
    }

    /**
     * Sets the entitiesToDestroy
     *
     * @param entitiesToDestroy
     */
    private void setEntitiesToDestroy(final ArrayList<IEntity> entitiesToDestroy) {
        this.entitiesToDestroy = entitiesToDestroy;
    }

}
