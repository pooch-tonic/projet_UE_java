package modelInterfaces;

public interface IBounceStrategy {

	/**
	 * strategy pattern method for unit behavior on bounce
	 */
	public void bounce(final IEntity actor, final ILevel level);

}
