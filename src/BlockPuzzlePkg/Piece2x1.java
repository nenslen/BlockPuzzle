
package BlockPuzzlePkg;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author Nic
 */
public class Piece2x1 extends Piece {
    // Piece shape (X marks origin)
    //
    // [X]
    // [ ]
    
    public Piece2x1() {
        super(Color.pink);
        squares = new Point[2];
        squares[0] = new Point(0, 0);
        squares[1] = new Point(1, 0);
        
    }
}