package modelInterfaces;

public interface IMoveStrategy {

	/**
	 * strategy pattern method for unit behavior on movement
	 */
	public void move(final IEntity actor, final ILevel level);

}
