package vector;

import java.awt.Point;

/**
 * The interface used by the Vector class.
 *
 * @author Ryo SHIINA
 *
 */
public interface IVector {
	/**
	 * Adds another vector to the current vector.
	 *
	 * @param vector
	 */
	public void add(final IVector vector);

	/**
	 * Calculates the length of the vector.
	 *
	 * @return The length as a Float.
	 */
	public Float calculateLength();

	/**
	 * Divides this vector by an integer. Prints a console error if the divider is
	 * 0.
	 *
	 * @param divider
	 */
	public void div(final int divider);

	/**
	 * Divides this vector by another vector. Prints a console error if any
	 * attribute of the vector is 0.
	 *
	 * @param divider
	 */
	public void div(final IVector divider);

	/**
	 * Returns the result of an addition without changing the current vector.
	 *
	 * @param vector
	 * @return A new vector containing the values of this vector added to another
	 *         vector.
	 */
	public IVector getAddResult(final IVector vector);

	/**
	 * Returns the result of a division without changing the current vector.
	 *
	 * @param divider
	 * @return A new vector containing the values of this vector divided by an
	 *         integer.
	 */
	public IVector getDivResult(final int divider);

	/**
	 * Returns the result of a division without changing the current vector.
	 *
	 * @param divider
	 * @return A new vector containing the values of this vector divided by another
	 *         vector.
	 */
	public IVector getDivResult(final IVector divider);

	/**
	 * Returns the result of an inversion without changing the current vector.
	 *
	 * @return A new vector containing the values of this vector when inverted.
	 */
	public IVector getInvertResult();

	/**
	 * Returns the result of a multiplication without changing the current vector.
	 *
	 * @param multiplier
	 * @return A new vector containing the values of this vector multiplied by an
	 *         integer.
	 */
	public IVector getMultResult(final int multiplier);

	/**
	 * Returns the result of a multiplication without changing the current vector.
	 *
	 * @param multiplier
	 * @return A new vector containing the values of this vector multiplied by
	 *         another vector.
	 */
	public IVector getMultResult(final IVector multiplier);

	/**
	 * Returns the result of a difference without changing the current vector.
	 *
	 * @param vector
	 * @return A new vector containing the values of this vector substracted by
	 *         another vector.
	 */
	public IVector getSubResult(final IVector vector);

	/**
	 * @return The x value of the vector.
	 */
	public int getX();

	/**
	 * @return The y value of the vector.
	 */
	public int getY();

	/**
	 * Inverts the current vector.
	 */
	public void invert();

	/**
	 * Checks if the current vector has the same values as the given x and y.
	 *
	 * @param x
	 * @param y
	 * @return True if equal, false if not.
	 */
	public boolean isEqual(final int x, final int y);

	/**
	 * Checks if the current vector has the same values as the given vector.
	 *
	 * @param vector
	 * @return True if equal, false if not.
	 */
	public boolean isEqual(IVector vector);

	/**
	 * Multiplies the current vector by an integer.
	 *
	 * @param multiplier
	 */
	public void mult(final int multiplier);

	/**
	 * Multiplies the current vector by another vector.
	 *
	 * @param multiplier
	 */
	public void mult(final IVector multiplier);

	/**
	 * Sets the length of this vector to a single unit length. For example, A(2,5)
	 * becomes A(1,1), B(-5,0) becomes B(-1,0). This isn't the proper normalization
	 * of a real vector since this only uses integers.
	 */
	public void normalize();

	/**
	 * Sets the current vector's values with the given x and y.
	 *
	 * @param x
	 * @param y
	 */
	public void set(final int x, final int y);

	/**
	 * Sets the current vector with the given vector.
	 *
	 * @param point
	 */
	public void set(final Point point);

	/**
	 * Substracts the current vector by another vector.
	 *
	 * @param vector
	 */
	public void sub(final IVector vector);
}