package vector;

import java.awt.Point;

/**
 * <h1>A Vector class which only works with integer values.</h1>
 *
 * @author Ryo SHIINA
 */

public class Vector implements IVector {
	private int x;
	private int y;

	/**
	 * The default constructor.
	 */
	public Vector() {
		this.set(0, 0);
	}

	/**
	 * The constructor based on given x and y.
	 *
	 * @param x
	 * @param y
	 */
	public Vector(final int x, final int y) {
		this.set(x, y);
	}

	/**
	 * The constructor based on a given vector.
	 *
	 * @param vector
	 */
	public Vector(final IVector vector) {
		this.set(vector.getX(), vector.getY());
	}

	/**
	 * The constructor based on a given Point object.
	 *
	 * @param point
	 */
	public Vector(final Point point) {
		this.set(point.x, point.y);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see vector.IVector#add(vector.IVector)
	 */
	@Override
	public void add(final IVector vector) {
		this.set(this.getX() + vector.getX(), this.getY() + vector.getY());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see vector.IVector#calculateLength()
	 */
	@Override
	public Float calculateLength() {
		return new Float(Math.sqrt(Math.pow(this.getX(), 2) + (Math.pow(this.getY(), 2))));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see vector.IVector#div(int)
	 */
	@Override
	public void div(final int divider) {
		if (divider != 0) {
			this.set(this.getX() / divider, this.getY() / divider);
		} else {
			System.out.println("Divided by 0 ! Operation is cancelled.");
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see vector.IVector#div(vector.IVector)
	 */
	@Override
	public void div(final IVector divider) {
		if ((divider.getX() != 0) && (divider.getY() != 0)) {
			this.set(this.getX() / divider.getX(), this.getY() / divider.getY());
		} else {
			System.out.println("Divided by 0! Operation is cancelled.");
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see vector.IVector#getAddResult(vector.IVector)
	 */
	@Override
	public IVector getAddResult(final IVector vector) {
		return new Vector(this.getX() + vector.getX(), this.getY() + vector.getY());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see vector.IVector#getDivResult(int)
	 */
	@Override
	public IVector getDivResult(final int divider) {
		return new Vector(this.getX() / divider, this.getY() / divider);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see vector.IVector#getDivResult(vector.IVector)
	 */
	@Override
	public IVector getDivResult(final IVector divider) {
		return new Vector(this.getX() / divider.getX(), this.getY() / divider.getY());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see vector.IVector#getInvertResult()
	 */
	@Override
	public IVector getInvertResult() {
		return new Vector(-this.getX(), -this.getY());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see vector.IVector#getMultResult(int)
	 */
	@Override
	public IVector getMultResult(final int multiplier) {
		return new Vector(this.getX() * multiplier, this.getY() * multiplier);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see vector.IVector#getMultResult(vector.IVector)
	 */
	@Override
	public IVector getMultResult(final IVector multiplier) {
		return new Vector(this.getX() * multiplier.getX(), this.getY() * multiplier.getY());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see vector.IVector#getSubResult(vector.IVector)
	 */
	@Override
	public IVector getSubResult(final IVector vector) {
		return new Vector(this.getX() - vector.getX(), this.getY() - vector.getY());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see vector.IVector#getX()
	 */
	@Override
	public int getX() {
		return this.x;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see vector.IVector#getY()
	 */
	@Override
	public int getY() {
		return this.y;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see vector.IVector#invert()
	 */
	@Override
	public void invert() {
		this.set(-this.getX(), -this.getY());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see vector.IVector#isEqual(int, int)
	 */
	@Override
	public boolean isEqual(final int x, final int y) {
		if ((this.getX() == x) && (this.getY() == y)) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see vector.IVector#isEqual(vector.IVector)
	 */
	@Override
	public boolean isEqual(final IVector vector) {
		if ((this.getX() == vector.getX()) && (this.getY() == vector.getY())) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see vector.IVector#mult(int)
	 */
	@Override
	public void mult(final int multiplier) {
		this.set(this.getX() * multiplier, this.getY() * multiplier);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see vector.IVector#mult(vector.IVector)
	 */
	@Override
	public void mult(final IVector multiplier) {
		this.set(this.getX() * multiplier.getX(), this.getY() * multiplier.getY());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see vector.IVector#normalize()
	 */
	@Override
	public void normalize() {
		this.x = this.getX();
		this.y = this.getY();

		if (this.x != 0) {
			this.setX(this.x / Math.abs(this.x));
		}

		if (this.y != 0) {
			this.setY(this.y / Math.abs(this.y));
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see vector.IVector#set(int, int)
	 */
	@Override
	public void set(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	/*
	 * Sets the x value.
	 *
	 * @param x
	 */

	/*
	 * (non-Javadoc)
	 *
	 * @see vector.IVector#set(java.awt.Point)
	 */
	@Override
	public void set(final Point point) {
		this.set(point.x, point.y);
	}

	public void setX(final int x) {
		this.x = x;
	}

	/*
	 * Sets the y value.
	 *
	 * @param y
	 */
	public void setY(final int y) {
		this.y = y;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see vector.IVector#sub(vector.IVector)
	 */
	@Override
	public void sub(final IVector vector) {
		this.set(this.getX() - vector.getX(), this.getY() - vector.getY());
	}

}