package gameproject;

import gameproject.client.GameClient;
import java.awt.*;
import java.awt.Image;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;

/**
 * The game screen.
 * @author jeremystark
 **/

public class GameScreen extends JPanel implements ActionListener
{
    
    /**
     * The nibbly bits.
     */
    private final ArrayList<NibblyBits> bits;
    
    /**
     * The background image.
     */
    private final Image backgroundImage;
    
    /**
     * The instance of the game.
     */
    private final GameProject game;
    
    /**
     * The list of other cells.
     */
    private final ArrayList<Cell> cells;
    
    /**
     * The player's cell.
     */
    private Cell player;
    
    /**
     * Creates a new GameScreen.
     * @param game The instance of the game.
     */
    public GameScreen(GameProject game)
    {
        this.game = game;
        addKeyListener(new GameKeyListener());
        setFocusable(true);
        
        bits = new ArrayList<NibblyBits>();
        cells = new ArrayList<Cell>();
        
        // "Jerome McCoolSwag"
        backgroundImage = new ImageIcon(getClass().getResource("/gameproject/res/graphics/back.png")).getImage();
        
        Timer timer = new Timer(1000/60, this);
        timer.start();
    }
    
    public void startGame()
    {
        GameClient client = new GameClient();
        client.connect();
        
        cells.clear();
        player = new Cell(game.getTitleScreen().getUsername(), Color.GREEN, 20, 20, 20);
        cells.add(new Cell("Test Cell", Color.RED, 40, 40, 20));
        
        for (int i = 0; i < 200; i++)
        {
            bits.add(new NibblyBits());
        }
    }
    
    /**
     * Called by the timer.
     * @param e The event.
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        repaint();
    }
    
    /**
     * Paint the game screen.
     * @param g The graphics context.
     */
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        // Makes everything that is drawn in the GameScreen anti-aliased!
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Draw the background.
        g2d.drawImage(backgroundImage, 0, 0, null);
       
        //Draw the nibbly bits.
        Iterator<NibblyBits> iterator = bits.iterator();
        
        while (iterator.hasNext())
        {
            NibblyBits next = iterator.next();
            if (next.collidesWith(player))
            {
                // Remove it
                iterator.remove();
                
                player.consume(next);
            }
            {
                next.draw(g2d);
            }
        }
        
        // Draw the other cells
        for (Cell next : cells)
        {
            next.draw(g2d);
        }
        
        // Draw the player.
        player.draw(g2d);
    }
    
    /**
     * The class that listens for key events.
     */
    private class GameKeyListener extends KeyAdapter
    {

        /**
         * Called when a key is released.
         *
         * @param e The event.
         */
        @Override
        public void keyReleased(KeyEvent e)
        {
            player.keyReleased(e);
        }

        /**
         * Called when a key is pressed.
         *
         * @param e The event.
         */
        @Override
        public void keyPressed(KeyEvent e)
        {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
            {
                game.endGame();
            }
            player.keyPressed(e);
        }
    }

}
