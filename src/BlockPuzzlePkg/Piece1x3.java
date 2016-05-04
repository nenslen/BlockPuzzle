
package BlockPuzzlePkg;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author Nic
 */
public class Piece1x3 extends Piece {
    // Piece shape (X marks origin)
    //
    // [ ][X][ ]
    
    public Piece1x3() {
        super(Color.yellow);
        squares = new Point[3];
        squares[0] = new Point(0, -1);
        squares[1] = new Point(0, 0);
        squares[2] = new Point(0, 1);
    }
}