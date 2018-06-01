package model;

import showboard.IPawn;

public class Square {
	private IPawn unit;
	
	/**
	 * Instantiates a new Square
	 * 
	 */
	public Square() {
		
	}
	
	/**
	 * Instantiates a new Square
	 * 
	 * @param unit
	 */
	public Square(IPawn unit) {
		this.setUnit(unit);
	}

	/**
	 * @return a unit
	 */
	public IPawn getUnit() {
		return unit;
	}

	/**
	 * @param unit
	 */
	private void setUnit(IPawn unit) {
		this.unit = unit;
	}
	
	/**
	 * Checks whether a unit is present or not
	 * 
	 * @return a false or a true
	 */
	public boolean isEmpty() {
		if(this.getUnit() != null) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * @param unit
	 */
	public void setUnitIfEmpty(IPawn unit) {
		if(this.isEmpty()) {
			this.setUnit(unit);
		}
	}
	
	/**
	 * remove a unit
	 */
	public void removeUnit() {
		if(!this.isEmpty()) {
			this.setUnit(null);
		}
	}
}
