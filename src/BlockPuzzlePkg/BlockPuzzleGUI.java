package BlockPuzzlePkg;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.border.AbstractBorder;

/**
 *
 * @author Nic
 */
public class BlockPuzzleGUI extends javax.swing.JFrame {

    
    private Tile grid[][];          // The grid of game tiles
    private Tile currPieceGrid[][]; // Preview of current piece
    private Tile nextPieceGrid[][]; // Preview of next piece
    
    private int gridsize = 10;             // The gridsize
    private final int NUM_OF_PIECES = 16;  // The # of different types of pieces
    private int gridThickness = 3;  // The thickness of the gridlines
    private int gridRadii = 12;     // How round the grid tiles are
    private final Color GRIDLINE_COLOR = Color.black; // Default gridline color
    private final Color DEFAULT_TILE_COLOR = new Color(100, 100, 100); // Default tile background color
    
    private AbstractBorder defaultBorder = new TextBubbleBorder(GRIDLINE_COLOR,gridThickness,gridRadii,0);
    private AbstractBorder defaultPreviewBorder = new TextBubbleBorder(GRIDLINE_COLOR,2,4,0);
    
    private Piece selectedPiece = null; // The currently selected piece
    private Piece nextPiece = null;     // The next piece
    
    private Timer tmr;
    
    private int totalXP = 0;
    private int currXP = 0;
    private final int BASE_XP = 1; // The base xp for erasing 1 tile
    private List<XPLabel> XPLabels = new ArrayList<XPLabel>(); // The XP Labels
    
    private boolean gameover = false;
    
    
    /**
     * Creates new form BlockPuzzleGUI
     */
    public BlockPuzzleGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGrid = new javax.swing.JPanel();
        pnlSettings = new javax.swing.JPanel();
        sliderGridSize = new javax.swing.JSlider();
        lblGridSize = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        pnlStats = new javax.swing.JPanel();
        lblXP = new javax.swing.JLabel();
        pnlNextPiece = new javax.swing.JPanel();
        pnlCurrentPiece = new javax.swing.JPanel();
        lblCurrentPiece = new javax.swing.JLabel();
        lblNextPiece = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(805, 560));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlGrid.setBackground(new java.awt.Color(0, 0, 0));
        pnlGrid.setMaximumSize(new java.awt.Dimension(1000, 1000));
        pnlGrid.setMinimumSize(new java.awt.Dimension(250, 250));
        pnlGrid.setPreferredSize(new java.awt.Dimension(500, 500));
        pnlGrid.setLayout(new java.awt.GridLayout(10, 10, 4, 4));

        pnlSettings.setBackground(new java.awt.Color(0, 0, 0));
        pnlSettings.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Settings", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 0, 36), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlSettings.setForeground(new java.awt.Color(255, 255, 255));
        pnlSettings.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N

        sliderGridSize.setBackground(new java.awt.Color(0, 0, 0));
        sliderGridSize.setForeground(new java.awt.Color(255, 255, 255));
        sliderGridSize.setMajorTickSpacing(10);
        sliderGridSize.setMaximum(50);
        sliderGridSize.setMinimum(5);
        sliderGridSize.setMinorTickSpacing(1);
        sliderGridSize.setPaintTicks(true);
        sliderGridSize.setValue(10);
        sliderGridSize.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderGridSizeStateChanged(evt);
            }
        });

        lblGridSize.setBackground(new java.awt.Color(0, 0, 0));
        lblGridSize.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        lblGridSize.setForeground(new java.awt.Color(255, 255, 255));
        lblGridSize.setText("Grid Size - 10x10");

        javax.swing.GroupLayout pnlSettingsLayout = new javax.swing.GroupLayout(pnlSettings);
        pnlSettings.setLayout(pnlSettingsLayout);
        pnlSettingsLayout.setHorizontalGroup(
            pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sliderGridSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlSettingsLayout.createSequentialGroup()
                        .addComponent(lblGridSize)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlSettingsLayout.setVerticalGroup(
            pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGridSize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderGridSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnReset.setBackground(new java.awt.Color(0, 0, 0));
        btnReset.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        pnlStats.setBackground(new java.awt.Color(0, 0, 0));
        pnlStats.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Stats", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 0, 36), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlStats.setForeground(new java.awt.Color(255, 255, 255));

        lblXP.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        lblXP.setForeground(new java.awt.Color(255, 255, 255));
        lblXP.setText("XP: 0");

        pnlNextPiece.setBackground(new java.awt.Color(0, 0, 0));
        pnlNextPiece.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlNextPiece.setLayout(new java.awt.GridLayout(5, 5, 1, 1));

        pnlCurrentPiece.setBackground(new java.awt.Color(0, 0, 0));
        pnlCurrentPiece.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlCurrentPiece.setLayout(new java.awt.GridLayout(5, 5, 1, 1));

        lblCurrentPiece.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        lblCurrentPiece.setForeground(new java.awt.Color(255, 255, 255));
        lblCurrentPiece.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCurrentPiece.setText("Current Piece");

        lblNextPiece.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        lblNextPiece.setForeground(new java.awt.Color(255, 255, 255));
        lblNextPiece.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNextPiece.setText("Next Piece");

        javax.swing.GroupLayout pnlStatsLayout = new javax.swing.GroupLayout(pnlStats);
        pnlStats.setLayout(pnlStatsLayout);
        pnlStatsLayout.setHorizontalGroup(
            pnlStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblXP)
                    .addGroup(pnlStatsLayout.createSequentialGroup()
                        .addGroup(pnlStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblCurrentPiece, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(pnlCurrentPiece, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlNextPiece, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNextPiece, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlStatsLayout.setVerticalGroup(
            pnlStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblXP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurrentPiece)
                    .addComponent(lblNextPiece))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlNextPiece, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlCurrentPiece, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlSettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlStats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlSettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlStats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * Initializes the game
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        getContentPane().setBackground(Color.black);
        
        
        // Initializes the main grid
        grid = new Tile[gridsize][gridsize];
        
        for(int i = 0; i < gridsize; i++)
        {
            for(int j = 0; j < gridsize; j++)
            {
                grid[i][j] = new Tile(DEFAULT_TILE_COLOR);
                grid[i][j].setVisible(true);
                grid[i][j].setPos(i, j);
                grid[i][j].setBorder(defaultBorder);
                grid[i][j].setBackground(DEFAULT_TILE_COLOR);
                TileMouseHandler mh = new TileMouseHandler();
                grid[i][j].addMouseListener(mh);
                pnlGrid.add(grid[i][j]);
            }
        }
        
        
        // Initializes the current piece preview grid
        currPieceGrid = new Tile[5][5];
        
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                currPieceGrid[i][j] = new Tile(DEFAULT_TILE_COLOR);
                currPieceGrid[i][j].setVisible(true);
                currPieceGrid[i][j].setPos(i, j);
                currPieceGrid[i][j].setBorder(defaultPreviewBorder);
                currPieceGrid[i][j].setBackground(DEFAULT_TILE_COLOR);
                pnlCurrentPiece.add(currPieceGrid[i][j]);
            }
        }
        
        
        // Initializes the next piece preview grid
        nextPieceGrid = new Tile[5][5];
        
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                nextPieceGrid[i][j] = new Tile(DEFAULT_TILE_COLOR);
                nextPieceGrid[i][j].setVisible(true);
                nextPieceGrid[i][j].setPos(i, j);
                nextPieceGrid[i][j].setBorder(defaultPreviewBorder);
                nextPieceGrid[i][j].setBackground(DEFAULT_TILE_COLOR);
                pnlNextPiece.add(nextPieceGrid[i][j]);
            }
        }
        
        
        // Sets starting game pieces
        selectedPiece = getRandomPiece();
        nextPiece = getRandomPiece();
        
        
        // Adjusts the panel size
        pnlGrid.setLayout(new java.awt.GridLayout(gridsize, gridsize, 1, 1));
        
        
        // Initializes timer
        tmr = new Timer(1, tmrTick);
        tmr.start();
        
        
        // Shows previews for selected and next piece
        showPreviews();
        
        
        // Refreshes the panel
        pnlGrid.revalidate();
        pnlGrid.repaint();
    }//GEN-LAST:event_formWindowOpened

    
    /**
     * Changes the grid size label 
     */
    private void sliderGridSizeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderGridSizeStateChanged
        int size = sliderGridSize.getValue();
        lblGridSize.setText("Grid Size - " + size + "x" + size);
    }//GEN-LAST:event_sliderGridSizeStateChanged

    
    /**
     * Starts or resets a game
     */
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        
        // Resets XP
        currXP = 0;
        totalXP = 0;
        lblXP.setText("XP: 0");
        
        
        // Sets gridThickness & gridRadii depending on the gridsize
        gridsize = sliderGridSize.getValue();
        if (gridsize < 15) {
            gridThickness = 3;
            gridRadii = 12;
        }
        if (gridsize >= 15) {
            gridThickness = 2;
            gridRadii = 8;
        }
        if (gridsize >= 20) {
            gridThickness = 1;
            gridRadii = 4;
        }
        defaultBorder = new TextBubbleBorder(GRIDLINE_COLOR,gridThickness,gridRadii,0);
        
        
        // Clears components from panel
        pnlGrid.removeAll();
        GridLayout gl = new GridLayout(gridsize, gridsize);
        pnlGrid.setLayout(gl);
        
        
        // Initializes the game tiles
        grid = null;
        grid = new Tile[gridsize][gridsize];
        
        for(int i = 0; i < gridsize; i++)
        {
            for(int j = 0; j < gridsize; j++)
            {
                grid[i][j] = new Tile(DEFAULT_TILE_COLOR);
                grid[i][j].setVisible(true);
                grid[i][j].setPos(i, j);
                grid[i][j].setBorder(defaultBorder);
                grid[i][j].setBackground(DEFAULT_TILE_COLOR);
                TileMouseHandler mh = new TileMouseHandler();
                grid[i][j].addMouseListener(mh);
                pnlGrid.add(grid[i][j]);
            }
        }
        
        
        // Sets starting game piece
        selectedPiece = getRandomPiece();
        nextPiece = getRandomPiece();
        showPreviews();
        
        
        // Adjusts the panel size
        pnlGrid.setLayout(new java.awt.GridLayout(gridsize, gridsize, 1, 1));
        
        
        gameover = false;
        
        
        // Refreshes the panel
        pnlGrid.revalidate();
        pnlGrid.repaint();
    }//GEN-LAST:event_btnResetActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Dark Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BlockPuzzleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BlockPuzzleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BlockPuzzleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BlockPuzzleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BlockPuzzleGUI().setVisible(true);
            }
        });
        
    }

  
    /**
     * Checks if a piece can fit on the board with a given tile as its origin
     */
    public boolean validMove(Tile tle, Piece pce) {
        
        int r = 0;
        int c = 0;
        
        for (Point p : pce.squares) {
            
            // Uses the relative x,y positions of the current piece point to its origin block to get a real tile on the grid
            r = tle.getRow() + p.x;
            c = tle.getCol() + p.y;
            
            // Makes sure point is within the grid and no other piece is on that tile
            if(!((r >= 0 && r < gridsize) && (c >= 0 && c < gridsize)) || grid[r][c].getUsed()) {
                return false;
            }
        }
        
        return true;
    }
    
    
    /**
     * Checks if any valid moves exist for a given piece anywhere on the grid
     */
    public boolean movesExist(Piece pce) {
        
        boolean isvalid = false;
        
        for(int i = 0; i < gridsize; i++) {
            for(int j = 0; j < gridsize; j++) {
                if(validMove(grid[i][j], pce)) {
                    isvalid = true;
                    break;
                }
            }
            if(isvalid) {
                break;
            }
        }
        
        return isvalid;
    }
    
    
    /**
     * Highlights or de-highlights the borders of the tiles where the selected piece will go
     */
    public void highlightMove(Tile tle, boolean highlight) {
        
        int r = 0;
        int c = 0;
        
        for (Point p : selectedPiece.squares) {
            
            // Uses the relative x,y positions of the current piece point to its origin block to get a real tile on the grid
            r = tle.getRow() + p.x;
            c = tle.getCol() + p.y;
            
            // Makes sure point is within the grid
            if((r >= 0 && r < gridsize) && (c >= 0 && c < gridsize)) {
                // Changes the tile's border color to match the selected piece or reverts to default color
                if(highlight) {
                    AbstractBorder brdr = new TextBubbleBorder(selectedPiece.getColor(),gridThickness,gridRadii,0);
                    grid[r][c].setBorder(brdr);
                }
                else {
                    grid[r][c].setBorder(defaultBorder);
                }
            }
        }
    }
    
    
    /**
     * Puts the piece on the grid, with origin 'tle'
     */
    public void setPiece(Tile tle) {
        
        int r = 0;
        int c = 0;
        
        for (Point p : selectedPiece.squares) {
            
            // Uses the relative x,y positions of the current piece point to its origin block to get a real tile on the grid
            r = tle.getRow() + p.x;
            c = tle.getCol() + p.y;
            
            // Sets piece as used and changes its color
            grid[r][c].setUsed(true);
            grid[r][c].setColor(selectedPiece.getColor());
            grid[r][c].setBorder(defaultBorder);
        }
    }
    
    
    /**
     * Clears all of the full lines on the grid
     */
    public void clearLines() {
        
        boolean fullHor = true;
        boolean fullVert = true;
        
        for(int i = 0; i < gridsize; i++) {
            fullHor = true;
            fullVert = true;
            
            // Sets fullLine to false if any of the tiles are unused
            for(int j = 0; j < gridsize; j++) {
                
                // Horizontal
                if(grid[i][j].getUsed() == false) {
                    fullHor = false;
                }
                
                // Vertical
                if(grid[j][i].getUsed() == false) {
                    fullVert = false;
                }
            }
            
           
            // Marks horizontal tiles for deletion
            if(fullHor) {
                for(int j = 0; j < gridsize; j++) {
                    currXP += BASE_XP;
                    grid[i][j].setMarkForDelete(true);
                }
            }
            
            // Marks vertical tiles for deletion
            if(fullVert) {
                for(int j = 0; j < gridsize; j++) {
                    currXP += BASE_XP;
                    grid[j][i].setMarkForDelete(true);
                }
            }
        }
        
        // Deletes all tiles marked for deletion
        for(int i = 0; i < gridsize; i++) {
            for(int j = 0; j < gridsize; j++) {
                if(grid[i][j].getMarkForDelete() == true) {
                    grid[i][j].setUsed(false);
                    grid[i][j].setBorder(defaultBorder);
                }
            }
        }
    }
    
    
    /**
     * Gets a random piece
     */
    public Piece getRandomPiece() {
        
        Piece pc = null;
        
        Random generator = new Random(); 
        int i = generator.nextInt(NUM_OF_PIECES);
        
        switch(i) {
            case 0:
                pc = new Piece2x2();
                break;
            case 1:
                pc = new Piece3x3();
                break;
            case 2:
                pc = new Piece1x1();
                break;
            case 3:
                pc = new Piece2x1();
                break;
            case 4:
                pc = new Piece3x1();
                break;
            case 5:
                pc = new Piece4x1();
                break;
            case 6:
                pc = new PieceSmallL();
                break;
            case 7:
                pc = new PieceBigL();
                break;
            case 8:
                pc = new PieceS();
                break;
            case 9:
                pc = new Piece1x2();
                break;
            case 10:
                pc = new Piece1x3();
                break;
            case 11:
                pc = new PieceHorJ();
                break;
            case 12:
                pc = new Piece1x5();
                break;
            case 13:
                pc = new PieceVertJ();
                break;
            case 14:
                pc = new PieceT();
                break;
            case 15:
                pc = new Piece4x1();
                break;
        }
        
        return pc;
    }
    
    
    /**
     * Shows previews for the selected piece and the next piece, in the
     * small 5x5 grids in the bottom right of the screen
     */
    private void showPreviews() {
        
        int r = 0;
        int c = 0;
        
        
        // Clears both preview grids
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                currPieceGrid[i][j].setColor(DEFAULT_TILE_COLOR);
                currPieceGrid[i][j].setVisible(false);
                nextPieceGrid[i][j].setColor(DEFAULT_TILE_COLOR);
                nextPieceGrid[i][j].setVisible(false);
            }
        }
        
        
        // Selected piece preview
        for (Point p : selectedPiece.squares) {
            
            // Uses the relative x,y positions of the current piece point to its origin block to get a real tile on the grid
            r = 2 + p.x;
            c = 2 + p.y;
            
            // Sets piece as used and changes its color
            currPieceGrid[r][c].setColor(selectedPiece.getColor());
            currPieceGrid[r][c].setBorder(defaultPreviewBorder);
            currPieceGrid[r][c].setVisible(true);
        }
        
        
        // Next piece preview
        for (Point p : nextPiece.squares) {
            
            // Uses the relative x,y positions of the current piece point to its origin block to get a real tile on the grid
            r = 2 + p.x;
            c = 2 + p.y;
            
            // Sets piece as used and changes its color
            nextPieceGrid[r][c].setColor(nextPiece.getColor());
            nextPieceGrid[r][c].setBorder(defaultPreviewBorder);
            nextPieceGrid[r][c].setVisible(true);
        }
    }
    
    
    /**
     * Handles when the mouse hovers over a panel
     */
    private class TileMouseHandler implements MouseListener {
        
        @Override
        public void mouseEntered(MouseEvent e) {
            if(gameover) { return; }
            
            Tile tle = null;
            tle = (Tile)e.getSource();
            highlightMove(tle, true);
        }
        
        @Override
        public void mouseExited(MouseEvent e) {
            if(gameover) { return; }
            
            Tile tle = null;
            tle = (Tile)e.getSource();
            highlightMove(tle, false);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(gameover) { return; }
            
            Tile tle = null;
            tle = (Tile)e.getSource();
            
            
            if(validMove(tle, selectedPiece)) {
                
                // Places the piece and clears any lines
                setPiece(tle);
                clearLines();
                
                
                // Gets new piece and shows previews
                selectedPiece = nextPiece;
                nextPiece = getRandomPiece();
                showPreviews();
                
                
                // Checks for game over
                if(!movesExist(selectedPiece)) {
                    gameover = true;
                }
                
                
                // Shows xp
                if(currXP > 0) {
                    totalXP += currXP;
                    lblXP.setText("XP: " + totalXP);
                    
                    XPLabel xp = new XPLabel(currXP, lblXP.getX() + lblXP.getWidth(), lblXP.getY());
                    pnlStats.add(xp, 0);
                    XPLabels.add(xp);
                    
                    currXP = 0;
                }
            }
            else {
                highlightMove(tle, false);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    
    /**
     * Timer for fading blocks
     */
    ActionListener tmrTick = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
            
            int r1 = DEFAULT_TILE_COLOR.getRed();
            int g1 = DEFAULT_TILE_COLOR.getGreen();
            int b1 = DEFAULT_TILE_COLOR.getRed();
            
            int r2 = 0;
            int g2 = 0;
            int b2 = 0;
            
            // Fades tiles that are marked for delete (main grid)
            for(int i = 0; i < gridsize; i++) {
                for(int j = 0; j < gridsize; j++) {
                    if(grid[i][j].getMarkForDelete() == true) {
                        r2 = grid[i][j].getColor().getRed();
                        g2 = grid[i][j].getColor().getGreen();
                        b2 = grid[i][j].getColor().getBlue();

                        if(r2 < r1) { r2 += 2; }
                        if(g2 < g1) { g2 += 2; }
                        if(b2 < b1) { b2 += 2; }

                        if(r2 > r1) { r2 -= 2; }
                        if(g2 > g1) { g2 -= 2; }
                        if(b2 > b1) { b2 -= 2; }

                        // Refreshes the panel
                        grid[i][j].setColor(new Color(r2, g2, b2));
                        grid[i][j].revalidate();
                        grid[i][j].repaint();

                        // Checks if color of tile is within 10 units of the default color
                        if(Math.abs(r1 - r2) < 10 && Math.abs(g1 - g2) < 10 && Math.abs(b1 - b2) < 10) {
                            grid[i][j].setColor(DEFAULT_TILE_COLOR);
                            grid[i][j].setMarkForDelete(false);
                        }
                    }
                }
            }
            
            
            // Removes any expired XP labels
            for(int i = 0; i < XPLabels.size(); i++) {
                if(XPLabels.get(i).destroy == true) {
                    pnlStats.remove(XPLabels.get(i));
                    XPLabels.remove(i);
                    System.gc();
                    
                    // Repaints the stats panel
                    pnlStats.revalidate();
                    pnlStats.repaint();
                }
            }
            
            
            if(gameover == false) { return; }
            
            
            // Fades tiles that are marked for delete (preview grids)
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    r2 = currPieceGrid[i][j].getColor().getRed();
                    g2 = currPieceGrid[i][j].getColor().getGreen();
                    b2 = currPieceGrid[i][j].getColor().getBlue();

                    if(r2 < r1) { r2 += 1; }
                    if(g2 < g1) { g2 += 1; }
                    if(b2 < b1) { b2 += 1; }

                    if(r2 > r1) { r2 -= 1; }
                    if(g2 > g1) { g2 -= 1; }
                    if(b2 > b1) { b2 -= 1; }

                    // Refreshes the panel
                    currPieceGrid[i][j].setColor(new Color(r2, g2, b2));
                    currPieceGrid[i][j].revalidate();
                    currPieceGrid[i][j].repaint();

                    // Checks if color of tile is within 10 units of the default color
                    if(Math.abs(r1 - r2) < 10 && Math.abs(g1 - g2) < 10 && Math.abs(b1 - b2) < 10) {
                        currPieceGrid[i][j].setColor(DEFAULT_TILE_COLOR);
                        currPieceGrid[i][j].setMarkForDelete(false);
                    }
                }
            }
            
            
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    r2 = nextPieceGrid[i][j].getColor().getRed();
                    g2 = nextPieceGrid[i][j].getColor().getGreen();
                    b2 = nextPieceGrid[i][j].getColor().getBlue();

                    if(r2 < r1) { r2 += 1; }
                    if(g2 < g1) { g2 += 1; }
                    if(b2 < b1) { b2 += 1; }

                    if(r2 > r1) { r2 -= 1; }
                    if(g2 > g1) { g2 -= 1; }
                    if(b2 > b1) { b2 -= 1; }

                    // Refreshes the panel
                    nextPieceGrid[i][j].setColor(new Color(r2, g2, b2));
                    nextPieceGrid[i][j].revalidate();
                    nextPieceGrid[i][j].repaint();

                    // Checks if color of tile is within 10 units of the default color
                    if(Math.abs(r1 - r2) < 10 && Math.abs(g1 - g2) < 10 && Math.abs(b1 - b2) < 10) {
                        nextPieceGrid[i][j].setColor(DEFAULT_TILE_COLOR);
                        nextPieceGrid[i][j].setMarkForDelete(false);
                    }
                }
            }
        }
    };
            
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblCurrentPiece;
    private javax.swing.JLabel lblGridSize;
    private javax.swing.JLabel lblNextPiece;
    private javax.swing.JLabel lblXP;
    private javax.swing.JPanel pnlCurrentPiece;
    private javax.swing.JPanel pnlGrid;
    private javax.swing.JPanel pnlNextPiece;
    private javax.swing.JPanel pnlSettings;
    private javax.swing.JPanel pnlStats;
    private javax.swing.JSlider sliderGridSize;
    // End of variables declaration//GEN-END:variables
}