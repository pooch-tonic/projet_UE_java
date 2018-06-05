/*
 *
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;

import controllerInterfaces.IController;
import controllerInterfaces.IOrderPerformer;
import controllerInterfaces.IOrderStacker;
import enums.DirectionEnum;
import enums.OrderEnum;
import enums.Type;
import enums.TypeEnum;
import modelInterfaces.IEntity;
import modelInterfaces.IModel;
import modelInterfaces.IUnit;
import vector.IVector;
import viewInterfaces.IView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller
 * component.</h1>
 *
 * @author Aurélien Dellac
 * @version 5 juin 2018
 */
public class ControllerFacade implements IController, IOrderStacker, IOrderPerformer, Observer {

    /** The view. */
    private IView view;

    /** The model. */
    private final IModel model;

    /** The interaction manager. */
    private InteractionManager interactionManager;

    /** The level loader. */
    private LevelLoader levelLoader;

    private ArrayList<OrderEnum> stackOrder;

    private Iterator<IEntity> entityIterator;

    private ArrayList<IEntity> entitiesToDestroy;

    private HashMap<IVector, TypeEnum> entitiesToSummon;

    /**
     * Instantiates a new ControllerFacade
     *
     * @param model
     */
    public ControllerFacade(final IModel model) {
        // TODO mettre super() si ca marche pas
        this.model = model;
        this.setInteractionManager(new InteractionManager());
        this.setLevelLoader(new LevelLoader());
        this.setStackOrder(new ArrayList<>());
        this.getStackOrder().add(OrderEnum.NONE);
        this.setEntitiesToDestroy(new ArrayList<>());
        this.setEntitiesToSummon(new HashMap<IVector, TypeEnum>());
    }

    /**
     * Start.
     *
     * @throws SQLException
     *             the SQL exception
     */
    public void start() throws SQLException {
        this.getModel().setMaxLevels();
        this.nextLevel();
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
        this.destroyEntities();
        this.summonEntities();
        this.setStackOrder(new ArrayList<>());
        this.getStackOrder().add(OrderEnum.NONE);
        this.setEntitiesToSummon(new HashMap<IVector, TypeEnum>());
    }

    private synchronized void destroyEntities() {
        final ArrayList<IEntity> entitiesDestroyed = new ArrayList<>();

        for (final IEntity entity : this.getEntitiesToDestroy()) {
            if (entity.getDurability() <= 0) {
                this.getModel().destroyEntity(entity);
                this.getView().removePawnFromBoard(entity);
                entitiesDestroyed.add(entity);

            }
        }
        this.getEntitiesToDestroy().removeAll(entitiesDestroyed);

        if (entitiesDestroyed.contains(this.getModel().getSpell())) {
            this.getModel().setSpell(null);
        }
        if (entitiesDestroyed.contains(this.getModel().getPlayer())) {
            this.resetLevel();
        }
    }

    private void summonEntities() {
        IEntity summonedEntity;
        for (final Entry<IVector, TypeEnum> set : this.getEntitiesToSummon().entrySet()) {
            summonedEntity = this.getModel().addEntityToLevel(set.getValue(), set.getKey());

            this.getView().getBoardFrame().addPawn(summonedEntity);

            if (set.getValue() == TypeEnum.DEAD) {
                this.addEntityToEntitiesToDestroy(summonedEntity);
            }
        }
    }

    /**
     * Update the entities of the model
     */
    private void updateEntities() {
        IEntity entity, target;
        while (this.getEntityIterator().hasNext()) {
            entity = this.getEntityIterator().next();
            if (this.getNextTile(entity).getType() == Type.WALL) {
                entity.bounce(this.getModel().getLevel());
            } else if ((entity.getDirection().getX() != 0) || (entity.getDirection().getY() != 0)) {
                // TODO change and use getAddResult
                if ((target = this.getModel().getLevel().getEntityOn(
                        entity.getPosition().getAddResult(entity.getDirection()))) != null) {
                    this.performInteraction(entity, target, this.getInteractionManager()
                            .getInteractionOnNextPositionBetween(entity, target));
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
        if (id <= this.getModel().getMaxLevels()) {
            this.getLevelLoader().loadLevel(id, this.getModel(), this.getView());
        } else {
            this.closeGame();
        }

    }

    /*
     * (non-Javadoc)
     *
     * @see controllerInterfaces.IController#nextLevel()
     */
    @Override
    public void nextLevel() {
        if (!this.gameIsOver()) {
            this.getLevelLoader().loadNextLevel(this.getModel(), this.getView());
        } else {
            this.closeGame();
        }

    }

    /*
     * (non-Javadoc)
     *
     * @see controllerInterfaces.IController#resetLevel()
     */
    @Override
    public void resetLevel() {
        this.getLevelLoader().resetLevel(this.getModel(), this.getView());
    }

    private void performInteraction(final IEntity entity, final IEntity target,
            final Interaction interaction) {
        switch (interaction) {
        case ENTITY_DESTROYED:
            this.addEntityToEntitiesToDestroy(entity);
            break;
        case TARGET_DESTROYED:
            this.addEntityToEntitiesToDestroy(target);
            break;
        case BOTH_DESTROYED:
            this.addEntityToEntitiesToDestroy(entity);
            this.addEntityToEntitiesToDestroy(target);
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
            this.nextLevel();
            break;
        default:
            break;
        }
    }

    private void addEntityToEntitiesToDestroy(final IEntity entity) {
        this.getEntitiesToDestroy().add(entity);
        this.getModel().doNotMoveEntity(entity);

        if (entity.getType() == Type.ENEMY) {
            this.getEntitiesToSummon().put(entity.getPosition(), TypeEnum.DEAD);
        }
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

    /**
     * Gets the entitiesToSummon
     *
     * @return the entitiesToSummon
     */
    private HashMap<IVector, TypeEnum> getEntitiesToSummon() {
        return this.entitiesToSummon;
    }

    /**
     * Sets the entitiesToSummon
     *
     * @param entitiesToSummon
     */
    private void setEntitiesToSummon(final HashMap<IVector, TypeEnum> entitiesToSummon) {
        this.entitiesToSummon = entitiesToSummon;
    }

    private boolean gameIsOver() {
        Boolean isOver = false;
        if (this.getModel().getLevel().getId() == this.getModel().getMaxLevels()) {
            isOver = true;
        }
        return isOver;
    }

    private void closeGame() {
        try {
            this.getView().displayMessage("You reached the last level !\n Your score is : "
                    + this.getModel().getScore().getScoreValue());
        } catch (final Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    /*
     * (non-Javadoc)
     *
     * @see controllerInterfaces.IOrderPerformer#performOrder()
     */
    @Override
    public void performOrder() {
        OrderEnum order = OrderEnum.NONE;

        order = this.getStackOrder().get(this.getStackOrder().size() - 1);

        switch (order) {
        case UP:
            this.getModel().setPlayerDirection(DirectionEnum.UP);
            this.getModel().setPlayerSpriteSetToIndex(3);
            break;
        case UPLEFT:
            this.getModel().setPlayerDirection(DirectionEnum.UPLEFT);
            this.getModel().setPlayerSpriteSetToIndex(2);
            break;
        case UPRIGHT:
            this.getModel().setPlayerDirection(DirectionEnum.UPRIGHT);
            this.getModel().setPlayerSpriteSetToIndex(4);
            break;
        case LEFT:
            this.getModel().setPlayerDirection(DirectionEnum.LEFT);
            this.getModel().setPlayerSpriteSetToIndex(1);
            break;
        case RIGHT:
            this.getModel().setPlayerDirection(DirectionEnum.RIGHT);
            this.getModel().setPlayerSpriteSetToIndex(5);
            break;
        case DOWN:
            this.getModel().setPlayerDirection(DirectionEnum.DOWN);
            this.getModel().setPlayerSpriteSetToIndex(7);
            break;
        case DOWNLEFT:
            this.getModel().setPlayerDirection(DirectionEnum.DOWNLEFT);
            this.getModel().setPlayerSpriteSetToIndex(0);
            break;
        case DOWNRIGHT:
            this.getModel().setPlayerDirection(DirectionEnum.DOWNRIGHT);
            this.getModel().setPlayerSpriteSetToIndex(6);
            break;
        case CAST:
            if (this.getModel().getSpell() == null) {
                IVector position;
                if ((position = this.isSpellSummoningPossible()) != null) {
                    this.getEntitiesToSummon().put(position, TypeEnum.SPELL);
                }
            } else {
                this.getModel().callSpell();
                this.getModel().getSpell().bounce(this.getModel().getLevel());
            }
            this.getModel().setPlayerDirection(DirectionEnum.NONE);
            break;
        default:
            this.getModel().setPlayerDirection(DirectionEnum.NONE);
            break;
        }
    }

    private IVector isSpellSummoningPossible() {
        IVector nextPosition = null;
        final IVector target = this.getModel().getPlayer().getPosition()
                .getAddResult(this.getModel().getPlayer().getLastDirection().getInvertResult());

        if ((this.getModel().getUnitOn(target.getX(), target.getY()).getType() != Type.WALL)
                && (this.getModel().getLevel().getEntityOn(target) == null)) {
            nextPosition = target;
            System.out.println(nextPosition.getX() + " : " + nextPosition.getY());
        }

        return nextPosition;
    }

    public void update(final Observable o, final IEntity entity) {
        this.getEntitiesToDestroy().add(entity);

    }

    @Override
    public void update(final Observable o, final Object arg) {
    }
}
