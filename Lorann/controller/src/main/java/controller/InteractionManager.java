/*
 *
 */
package controller;

import modelInterfaces.IEntity;

public class InteractionManager {
    public InteractionManager() {
        // TODO constructor code
    }

    public Interaction defineInteractionBetween(final IEntity entity, final IEntity target) {
        // TODO code
        return Interaction.NONE;
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

    private Interaction getInteractionBetweenPlayerAnd(final IEntity target) {
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
        case DOOR_OPEN:
            interaction = Interaction.QUIT_LEVEL;
            break;
        case DEAD:
            interaction = Interaction.NONE;
            break;
        default:
            interaction = Interaction.NONE;
            break;
        }
        return interaction;
    }

    private Interaction getInteractionBetweenEnemyAnd(final IEntity target) {
        final Interaction interaction;
        switch (target.getType()) {
        case ENEMY:
            interaction = Interaction.BOUNCE;
            break;
        case PLAYER:
            interaction = Interaction.TARGET_DESTROYED;
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

    private Interaction getInteractionBetweenSpellAnd(final IEntity target) {
        final Interaction interaction;
        switch (target.getType()) {
        case ENEMY:
            interaction = Interaction.BOTH_DESTROYED;
            break;
        case PLAYER:
            interaction = Interaction.ENTITY_DESTROYED;
            break;
        case KEY:
            interaction = Interaction.BOUNCE;
            break;
        case LOOT:
            interaction = Interaction.BOUNCE;
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
}
