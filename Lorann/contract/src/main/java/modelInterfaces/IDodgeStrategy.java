package modelInterfaces;

/**
 * <h1>The IDodgeStrategy interface.</h1> Part of a strategy pattern.
 *
 * @author Ryo SHIINA
 *
 */
public interface IDodgeStrategy {

	/**
	 * Strategy pattern method for unit behavior on dodge.
	 * 
	 * @param actor
	 *            the entity executing the action
	 * @param level
	 *            the level containing the actor entity
	 */
	public void dodge(final IEntity actor, final ILevel level);

}
