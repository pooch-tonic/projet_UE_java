package model.vector;

import java.awt.Point;

import modelInterfaces.IVector;

/*
 * 	Vector which only works with int values
 */

public class Vector implements IVector {
	private int x;
	private int y;

	public Vector() {
		this.set(0, 0);
	}

	public Vector(final int x, final int y) {
		this.set(x, y);
	}

	public Vector(final IVector vector) {
		this.set(vector.getX(), vector.getY());
	}

	public Vector(final Point point) {
		this.set(point.x, point.y);
	}

	@Override
	public void add(final IVector vector) {
		this.set(this.getX() + vector.getX(), this.getY() + vector.getY());
	}

	@Override
	public void div(final int divider) {
		if (divider != 0) {
			this.set(this.getX() / divider, this.getY() / divider);
		} else {
			System.out.println("Divided by 0 ! Operation is cancelled.");
		}
	}

	@Override
	public void div(final IVector divider) {
		if ((divider.getX() != 0) && (divider.getY() != 0)) {
			this.set(this.getX() / divider.getX(), this.getY() / divider.getY());
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
		this.set(-this.getX(), -this.getY());
	}

	@Override
	public void mult(final int multiplier) {
		this.set(this.getX() * multiplier, this.getY() * multiplier);
	}

	@Override
	public void mult(final IVector multiplier) {
		this.set(this.getX() * multiplier.getX(), this.getY() * multiplier.getY());
	}

	@Override
	public void set(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	public void set(final Point point) {
		this.set(point.x, point.y);
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
		this.set(this.getX() - vector.getX(), this.getY() - vector.getY());
	}

}