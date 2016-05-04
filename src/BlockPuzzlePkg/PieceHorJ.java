
package BlockPuzzlePkg;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author Nic
 */
public class PieceHorJ extends Piece {
    // Piece shape (X marks origin)
    // 
    // [ ]
    // [X][ ][ ]
    
    public PieceHorJ() {
        super(Color.yellow);
        squares = new Point[4];
        squares[0] = new Point(-1, 0);
        squares[1] = new Point(0, 0);
        squares[2] = new Point(0, 1);
        squares[3] = new Point(0, 2);
    }
}