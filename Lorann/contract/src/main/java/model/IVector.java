package model;

import java.util.Vector;

public interface IVector {
	public int getY();
	public int getX();
	public void add(Vector vector);
	public void sub(Vector vector);
	public void mult(Vector multiplier );
	public void div(Vector divider );
	public void invert();
}
 