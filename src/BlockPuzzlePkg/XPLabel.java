
package BlockPuzzlePkg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Nic
 */
public class XPLabel extends JLabel {
    
    private Timer tmr;
    private int xp;
    private int x;
    private int y;
    private int ttl = 20; // How many ticks until this object dies
    public boolean destroy = false;
    
    
    public XPLabel(int _xp, int _x, int _y) {
        tmr = new Timer(50, tmrTick);
        tmr.setDelay(50);
        tmr.start();
        
        xp = _xp;
        x = _x;
        y = _y;
        
        
        // Sets properties
        setText("+" + xp);
        
        setBackground(Color.cyan);
        Font newFont = new Font("Agency FB", Font.BOLD, 23);
        setFont(newFont);
        setBounds(x - this.getWidth(), y, 87, 26);
        setForeground(new Color(0, 102, 204));
    }
    
    
    
    
    /**
     * Timer for the XPLabel
     */
    ActionListener tmrTick = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
            if(ttl-- <= 0) {
                destroy = true;
                tmr.stop();
            }
            else {
                setBounds(x, --y, 87, 26);
            }
        }
    };
        
}
