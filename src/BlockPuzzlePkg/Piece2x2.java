
package BlockPuzzlePkg;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author Nic
 */
public class Piece2x2 extends Piece {
    // Piece shape (X marks origin)
    //
    // [X][ ]
    // [ ][ ]
    
    public Piece2x2() {
        super(Color.magenta);
        squares = new Point[4];
        squares[0] = new Point(0, 0);
        squares[1] = new Point(0, 1);
        squares[2] = new Point(1, 0);
        squares[3] = new Point(1, 1);
        
    }
}