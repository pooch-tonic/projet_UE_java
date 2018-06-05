/*
 *
 */
package controller;

import modelinterfaces.IEntity;

/**
 * <h1>The InteractionManager class.</h1> Allows to manage interactions between
 * 2 entities.
 *
 * @author Ryo SHIINA
 *
 */
public class InteractionManager {
    public InteractionManager() {
    }

    /**
     * Defines the interaction to choose depending on the moving entity and the
     * target entity at destination.
     * 
     * @param entity
     *            the moving entity
     * @param target
     *            the target entity
     * @return the defined interaction between the entities
     */
    public InteractionEnum getInteractionOnNextPositionBetween(final IEntity entity,
            final IEntity target) {
        final InteractionEnum interaction;

        switch (entity.getType()) {
        case ENEMY:
            interaction = this.getEnemyInteractionOnHisNextPosition(target);
            break;
        case SPELL:
            interaction = this.getSpellInteractionOnHisNextPosition(target);
            break;
        case PLAYER:
            interaction = this.getPlayerInteractionOnHisNextPosition(target);
            break;
        default:
            interaction = InteractionEnum.NONE;
            break;
        }
        return interaction;
    }

    /**
     * Defines the interaction to choose for the main entity and another entity on
     * the same position.
     * 
     * @param entity
     *            the main entity
     * @param target
     *            the other entity at the same position
     * @return the defined interaction between the entities.
     */
    public InteractionEnum getInteractionOnCurrentPositionBetween(final IEntity entity,
            final IEntity target) {
        final InteractionEnum interaction;

        switch (entity.getType()) {
        case ENEMY:
            interaction = this.getEnemyInteractionOnHisPosition(target);
            break;
        case SPELL:
            interaction = this.getSpellInteractionOnHisPosition(target);
            break;
        case PLAYER:
            interaction = this.getPlayerInteractionOnHisPosition(target);
            break;
        default:
            interaction = InteractionEnum.NONE;
            break;
        }
        return interaction;
    }

    /**
     * Defines the interaction of an enemy on the target entity.
     * 
     * @param target
     *            the target entity
     * @return the defined interaction between the enemy and the target
     */
    private InteractionEnum getEnemyInteractionOnHisPosition(final IEntity target) {
        final InteractionEnum interaction;

        switch (target.getType()) {
        case PLAYER:
            interaction = InteractionEnum.TARGET_DESTROYED;
            break;
        case SPELL:
            interaction = InteractionEnum.BOTH_DESTROYED;
            break;
        default:
            interaction = InteractionEnum.NONE;
            break;
        }
        return interaction;
    }

    /**
     * Defines the interaction of a spell on the target entity.
     * 
     * @param target
     *            the target entity
     * @return the defined interaction between the spell and the target
     */
    private InteractionEnum getSpellInteractionOnHisPosition(final IEntity target) {
        final InteractionEnum interaction;
        switch (target.getType()) {
        case PLAYER:
            interaction = InteractionEnum.ENTITY_DESTROYED;
            break;
        case ENEMY:
            interaction = InteractionEnum.BOTH_DESTROYED;
            break;
        default:
            interaction = InteractionEnum.NONE;
            break;
        }
        return interaction;
    }

    /**
     * Defines the interaction of the player on the target entity.
     * 
     * @param target
     *            the target entity
     * @return the defined interaction between the player and the target.
     */
    private InteractionEnum getPlayerInteractionOnHisPosition(final IEntity target) {
        final InteractionEnum interaction;
        switch (target.getType()) {
        case ENEMY:
            interaction = InteractionEnum.ENTITY_DESTROYED;
            break;
        case KEY:
            interaction = InteractionEnum.UNLOCK_DOOR;
            break;
        case LOOT:
            interaction = InteractionEnum.TARGET_DESTROYED;
            break;
        case SPELL:
            interaction = InteractionEnum.TARGET_DESTROYED;
            break;
        default:
            interaction = InteractionEnum.NONE;
            break;
        }
        return interaction;
    }

    /**
     * Defines the interaction of the enemy on its next position.
     * 
     * @param target
     *            the target entity
     * @return the interaction of the enemy on its next position
     */
    private InteractionEnum getEnemyInteractionOnHisNextPosition(final IEntity target) {
        final InteractionEnum interaction;
        switch (target.getType()) {
        case ENEMY:
            interaction = InteractionEnum.BOUNCE;
            break;
        case DOOR_CLOSED:
            interaction = InteractionEnum.BOUNCE;
            break;
        case KEY:
            interaction = InteractionEnum.BOUNCE;
            break;
        case LOOT:
            interaction = InteractionEnum.BOUNCE;
            break;
        case SPELL:
            interaction = InteractionEnum.DODGE;
            break;
        case DOOR_OPEN:
            interaction = InteractionEnum.BOUNCE;
            break;
        case DEAD:
            interaction = InteractionEnum.BOUNCE;
            break;
        default:
            interaction = InteractionEnum.NONE;
            break;
        }
        return interaction;
    }

    /**
     * Defines the interaction of the spell on its next position.
     * 
     * @param target
     *            the target entity
     * @return the defined interaction of the spell on its next position
     */
    private InteractionEnum getSpellInteractionOnHisNextPosition(final IEntity target) {
        final InteractionEnum interaction;
        switch (target.getType()) {
        case KEY:
            interaction = InteractionEnum.BOUNCE;
            break;
        case LOOT:
            interaction = InteractionEnum.BOUNCE;
            break;
        case DOOR_OPEN:
            interaction = InteractionEnum.BOUNCE;
            break;
        case DOOR_CLOSED:
            interaction = InteractionEnum.BOUNCE;
            break;
        case DEAD:
            interaction = InteractionEnum.BOUNCE;
            break;
        default:
            interaction = InteractionEnum.NONE;
            break;
        }
        return interaction;
    }

    /**
     * Defines the interaction of the player on its next position.
     * 
     * @param target
     *            the target entity
     * @return the defined interaction of the player on its next position.
     */
    private InteractionEnum getPlayerInteractionOnHisNextPosition(final IEntity target) {
        final InteractionEnum interaction;
        switch (target.getType()) {
        case DOOR_OPEN:
            interaction = InteractionEnum.QUIT_LEVEL;
            break;
        case DOOR_CLOSED:
            interaction = InteractionEnum.ENTITY_DESTROYED;
            break;
        case DEAD:
            interaction = InteractionEnum.BOUNCE;
            break;
        default:
            interaction = InteractionEnum.NONE;
            break;
        }
        return interaction;
    }
}
