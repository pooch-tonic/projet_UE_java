/*
 *
 */
package showboard;

import java.awt.Image;
import java.io.IOException;
import java.sql.SQLException;

/**
 * <h1>The Interface ISquare.</h1>
 * <p>
 * A class can implement the ISquare interface when it wants to be show on a
 * IBoard.
 * </p>
 *
 * @author Anne-Emilie DIET
 * @author Aurélien DELLAC
 * @author Ryo SHIINA
 * @version 1.1
 * @see Image
 */
public interface ISquare {

    /**
     * Gets the image.
     *
     * @return the image
     * @throws SQLException
     * @throws IOException
     */
    Image getImage();
}
