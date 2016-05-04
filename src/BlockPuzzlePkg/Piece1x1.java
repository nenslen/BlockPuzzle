
package BlockPuzzlePkg;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author Nic
 */
public class Piece1x1 extends Piece {
    // Piece shape (X marks origin)
    //
    // [X]
    
    public Piece1x1() {
        super(Color.green);
        squares = new Point[1];
        squares[0] = new Point(0, 0);
    }
}
