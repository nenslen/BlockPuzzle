
package BlockPuzzlePkg;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author Nic
 */
public class Piece {
    
    
    protected Color color;
    protected Point[] squares; // The locations of the squares within the piece
    
    
    public Piece() {
        color = Color.black;
    }
    
    
    public Piece(Color clr) {
        color = clr;
    }
    
    
    public Color getColor() {
        return color;
    }
}
