
package BlockPuzzlePkg;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Nic
 */
public class Tile extends javax.swing.JPanel {
    
    protected int row;
    protected int col;
    protected boolean used;
    protected boolean markForDelete;
    protected Color bgcolor;
    protected Color defaultColor;
    
    
    public Tile(Color defaultClr) {
        used = false;
        markForDelete = false;
        bgcolor = defaultClr;
        defaultColor = defaultClr;
        setBackground(bgcolor);
    }
    
    
    public void setPos(int r, int c) {
        row = r;
        col = c;
    }
    
    
    public int getRow() {
        return row;
    }
    
    
    public int getCol() {
        return col;
    }
    
    
    public boolean getUsed() {
        return used;
    }
    
    
    public void setUsed(boolean isUsed) {
        used = isUsed;
    }
    
    
    public void setColor(Color clr) {
        bgcolor = clr;
        setBackground(bgcolor);
    }
    
    
    public Color getColor() {
        return bgcolor;
    }
    
    
    public void setMarkForDelete(boolean delete) {
        markForDelete = delete;
    }
    
    
    public boolean getMarkForDelete() {
        return markForDelete;
    }
    
}
