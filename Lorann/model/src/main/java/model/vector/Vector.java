package model.vector;

/*
 * 	Vector which only works with int values
 */

public class Vector {
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

	public Vector(final Vector vector) {
		this.setX(vector.x);
		this.setY(vector.y);
	}

	public void add(final Vector vector) {
		this.setX(this.getX() + vector.getX());
		this.setY(this.getY() + vector.getY());
	}

	public void div(final int divider) {
		if (divider != 0) {
			this.setX(this.getX() / divider);
			this.setY(this.getY() / divider);
		} else {
			System.out.println("Divided by 0 ! Operation is cancelled.");
		}
	}

	public void div(final Vector divider) {
		if ((divider.getX() != 0) && (divider.getY() != 0)) {
			this.setX(this.getX() / divider.getX());
			this.setY(this.getY() / divider.getY());
		} else {
			System.out.println("Divided by 0 ! Operation is cancelled.");
		}
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void invert() {
		this.setX(-this.getX());
		this.setY(-this.getY());
	}

	public void mult(final int multiplier) {
		this.setX(this.getX() * multiplier);
		this.setY(this.getY() * multiplier);
	}

	public void mult(final Vector multiplier) {
		this.setX(this.getX() * multiplier.getX());
		this.setY(this.getY() * multiplier.getY());
	}

	private void setX(final int x) {
		this.x = x;
	}

	private void setY(final int y) {
		this.y = y;
	}

	public void sub(final Vector vector) {
		this.setX(this.getX() - vector.getX());
		this.setY(this.getY() - vector.getY());
	}

}
