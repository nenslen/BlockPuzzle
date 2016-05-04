
package BlockPuzzlePkg;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author Nic
 */
public class Piece1x5 extends Piece {
    // Piece shape (X marks origin)
    // 
    // [ ][ ][X][ ][ ]
    
    public Piece1x5() {
        super(Color.green);
        squares = new Point[5];
        squares[0] = new Point(0, -2);
        squares[1] = new Point(0, -1);
        squares[2] = new Point(0, 0);
        squares[3] = new Point(0, 1);
        squares[4] = new Point(0, 2);
    }
}