package model;

import modelInterfaces.IUnit;

public class UnitContainer {
	private IUnit unit;

	/**
	 * Instantiates a new UnitContainer
	 *
	 */
	public UnitContainer() {
		this.setUnit(null);
	}

	/**
	 * Instantiates a new UnitContainer
	 *
	 * @param unit
	 */
	public UnitContainer(final IUnit unit) {
		this.setUnit(unit);
	}

	/**
	 * @return a unit
	 */
	public IUnit getUnit() {
		return this.unit;
	}

	/**
	 * Checks whether a unit is present or not
	 *
	 * @return a false or a true
	 */
	public boolean isEmpty() {
		if (this.getUnit() != null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * remove a unit
	 */
	public void removeUnit() {
		if (!this.isEmpty()) {
			this.setUnit(null);
		}
	}

	/**
	 * @param unit
	 */
	private void setUnit(final IUnit unit) {
		this.unit = unit;
	}

	/**
	 * @param unit
	 */
	public void setUnitIfEmpty(final IUnit unit) {
		if (this.isEmpty()) {
			this.setUnit(unit);
		}
	}
}
