package model.vector;

import model.IVector;

/*
 * 	Vector which only works with int values
 */

public class Vector implements IVector {
	private int x;
	private int y;

	public Vector() {
		this.setX(0);
		this.setY(0);
	}

	public Vector(final int x, final int y) {
		this.setX(x);
		this.setY(y);
	}

	public Vector(final IVector vector) {
		this.setX(vector.getX());
		this.setY(vector.getY());
	}

	@Override
	public void add(final IVector vector) {
		this.setX(this.getX() + vector.getX());
		this.setY(this.getY() + vector.getY());
	}

	@Override
	public void div(final int divider) {
		if (divider != 0) {
			this.setX(this.getX() / divider);
			this.setY(this.getY() / divider);
		} else {
			System.out.println("Divided by 0 ! Operation is cancelled.");
		}
	}

	@Override
	public void div(final IVector divider) {
		if ((divider.getX() != 0) && (divider.getY() != 0)) {
			this.setX(this.getX() / divider.getX());
			this.setY(this.getY() / divider.getY());
		} else {
			System.out.println("Divided by 0! Operation is cancelled.");
		}
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	@Override
	public void invert() {
		this.setX(-this.getX());
		this.setY(-this.getY());
	}

	@Override
	public void mult(final int multiplier) {
		this.setX(this.getX() * multiplier);
		this.setY(this.getY() * multiplier);
	}

	@Override
	public void mult(final IVector multiplier) {
		this.setX(this.getX() * multiplier.getX());
		this.setY(this.getY() * multiplier.getY());
	}

	@Override
	public void set(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void setX(final int x) {
		this.x = x;
	}

	@Override
	public void setY(final int y) {
		this.y = y;
	}

	@Override
	public void sub(final IVector vector) {
		this.setX(this.getX() - vector.getX());
		this.setY(this.getY() - vector.getY());
	}

}
