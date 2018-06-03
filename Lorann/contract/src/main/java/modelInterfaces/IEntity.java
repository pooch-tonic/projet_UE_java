/*
 * 
 */
package modelInterfaces;

import enums.DirectionEnum;
import enums.Type;
import showboard.IPawn;
import vector.IVector;

public interface IEntity extends IPawn {
    public void destroy();

    public IVector getDirection();

    public void move(DirectionEnum direction);

    void setDirection(IVector direction);

    public Type getType();

    void update();
}
