package model;

public interface IVector {
	public void add(final IVector vector);

	public void div(final int divider);

	public void div(final IVector divider);

	public int getX();

	public int getY();

	public void invert();

	public void mult(final int multiplier);

	public void mult(final IVector multiplier);

	public void set(final int x, final int y);

	public void setX(final int x);

	public void setY(final int y);

	public void sub(final IVector vector);
}