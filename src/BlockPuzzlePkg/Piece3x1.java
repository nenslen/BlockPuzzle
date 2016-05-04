
package BlockPuzzlePkg;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author Nic
 */
public class Piece3x1 extends Piece {
    // Piece shape (X marks origin)
    //
    // [ ]
    // [X]
    // [ ]
    
    public Piece3x1() {
        super(Color.orange);
        squares = new Point[3];
        squares[0] = new Point(-1, 0);
        squares[1] = new Point(0, 0);
        squares[2] = new Point(1, 0);
    }
}