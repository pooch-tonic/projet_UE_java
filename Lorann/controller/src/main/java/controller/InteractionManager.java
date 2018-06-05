/*
 *
 */
package controller;

import modelInterfaces.IEntity;

public class InteractionManager {
    public InteractionManager() {
        // TODO constructor code
    }

    public Interaction getInteractionOnNextPositionBetween(final IEntity entity,
            final IEntity target) {
        final Interaction interaction;

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
            interaction = Interaction.NONE;
            break;
        }
        return interaction;
    }

    public Interaction getInteractionOnCurrentPositionBetween(final IEntity entity,
            final IEntity target) {
        final Interaction interaction;

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
            interaction = Interaction.NONE;
            break;
        }
        return interaction;
    }

    private Interaction getEnemyInteractionOnHisPosition(final IEntity target) {
        final Interaction interaction;

        switch (target.getType()) {
        case PLAYER:
            interaction = Interaction.TARGET_DESTROYED;
            break;
        case SPELL:
            interaction = Interaction.BOTH_DESTROYED;
            break;
        default:
            interaction = Interaction.NONE;
            break;
        }
        return interaction;
    }

    private Interaction getSpellInteractionOnHisPosition(final IEntity target) {
        final Interaction interaction;
        switch (target.getType()) {
        case PLAYER:
            interaction = Interaction.ENTITY_DESTROYED;
            break;
        case ENEMY:
            interaction = Interaction.BOTH_DESTROYED;
            break;
        default:
            interaction = Interaction.NONE;
            break;
        }
        return interaction;
    }

    private Interaction getPlayerInteractionOnHisPosition(final IEntity target) {
        final Interaction interaction;
        switch (target.getType()) {
        case ENEMY:
            interaction = Interaction.ENTITY_DESTROYED;
            break;
        case KEY:
            interaction = Interaction.UNLOCK_DOOR;
            break;
        case LOOT:
            interaction = Interaction.TARGET_DESTROYED;
            break;
        case SPELL:
            interaction = Interaction.TARGET_DESTROYED;
            break;
        default:
            interaction = Interaction.NONE;
            break;
        }
        return interaction;
    }

    private Interaction getEnemyInteractionOnHisNextPosition(final IEntity target) {
        final Interaction interaction;
        switch (target.getType()) {
        case ENEMY:
            interaction = Interaction.BOUNCE;
            break;
        case DOOR_CLOSED:
            interaction = Interaction.BOUNCE;
            break;
        case KEY:
            interaction = Interaction.BOUNCE;
            break;
        case LOOT:
            interaction = Interaction.BOUNCE;
            break;
        case SPELL:
            interaction = Interaction.DODGE;
            break;
        case DOOR_OPEN:
            interaction = Interaction.BOUNCE;
            break;
        case DEAD:
            interaction = Interaction.BOUNCE;
            break;
        default:
            interaction = Interaction.NONE;
            break;
        }
        return interaction;
    }

    private Interaction getSpellInteractionOnHisNextPosition(final IEntity target) {
        final Interaction interaction;
        switch (target.getType()) {
        case KEY:
            interaction = Interaction.BOUNCE;
            break;
        case LOOT:
            interaction = Interaction.BOUNCE;
            break;
        case DOOR_OPEN:
            interaction = Interaction.BOUNCE;
            break;
        case DOOR_CLOSED:
            interaction = Interaction.BOUNCE;
            break;
        case DEAD:
            interaction = Interaction.BOUNCE;
            break;
        default:
            interaction = Interaction.NONE;
            break;
        }
        return interaction;
    }

    private Interaction getPlayerInteractionOnHisNextPosition(final IEntity target) {
        final Interaction interaction;
        switch (target.getType()) {
        case DOOR_OPEN:
            interaction = Interaction.QUIT_LEVEL;
            break;
        case DOOR_CLOSED:
            interaction = Interaction.ENTITY_DESTROYED;
            break;
        case DEAD:
            interaction = Interaction.BOUNCE;
            break;
        default:
            interaction = Interaction.NONE;
            break;
        }
        return interaction;
    }
}
