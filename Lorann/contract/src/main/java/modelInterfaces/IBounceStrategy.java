package modelInterfaces;

/**
 * <h1>The IBounceStrategy interface.</h1> Part of a strategy pattern.
 *
 * @author Ryo SHIINA
 *
 */
public interface IBounceStrategy {

	/**
	 * Strategy pattern method for unit behavior on bounce.
	 * 
	 * @param actor
	 *            the entity executing the action
	 * @param level
	 *            the level containing the actor entity
	 */
	public void bounce(final IEntity actor, final ILevel level);

}
