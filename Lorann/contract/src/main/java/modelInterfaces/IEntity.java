/*
 *
 */
package modelInterfaces;

import enums.Type;
import enums.TypeEnum;
import showboard.IPawn;
import vector.IVector;

public interface IEntity extends IPawn {
    public void destroy();

    public IVector getDirection();

    public Type getType();

    void setDirection(IVector direction);

    void setPosition(final IVector position);

    void update();

    void setType(TypeEnum type);
}
