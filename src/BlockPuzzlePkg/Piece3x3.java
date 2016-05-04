
package BlockPuzzlePkg;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author Nic
 */
public class Piece3x3 extends Piece {
    // Piece shape (X marks origin)
    //
    // [ ][ ][ ]
    // [ ][X][ ]
    // [ ][ ][ ]
    
    public Piece3x3() {
        super(Color.magenta);
        squares = new Point[9];
        squares[0] = new Point(-1, -1);
        squares[1] = new Point(-1, 0);
        squares[2] = new Point(-1, 1);
        squares[3] = new Point(0, -1);
        squares[4] = new Point(0, 0);
        squares[5] = new Point(0, 1);
        squares[6] = new Point(1, -1);
        squares[7] = new Point(1, 0);
        squares[8] = new Point(1, 1);
    }
}