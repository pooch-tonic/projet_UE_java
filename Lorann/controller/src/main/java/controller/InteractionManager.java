/*
 *
 */
package controller;

import modelinterfaces.IEntity;

public class InteractionManager {
    public InteractionManager() {
        // TODO constructor code
    }

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
