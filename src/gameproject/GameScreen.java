package gameproject;

import java.awt.*;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

/**
 * The game screen.
 * @author jeremystark
 **/

public class GameScreen extends JPanel implements ActionListener
{
    /**
     * The player's cell.
     */
    private final Cell player;
    
    /**
     * The background image.
     */
    private final Image backgroundImage;
    
    /**
     * Creates a new GameScreen.
     */
    public GameScreen()
    {
        addKeyListener(new GameKeyListener());
        setFocusable(true);
        
        player = new Cell(Color.GREEN, 20, 20, 20);
        
        backgroundImage = new ImageIcon(getClass().getResource("/gameproject/res/graphics/back.png")).getImage();
        
        Timer timer = new Timer(1000/60, this);
        timer.start();
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

        // Draw the background.
        g2d.drawImage(backgroundImage, 0, 0, null);
        
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
            player.keyPressed(e);
        }
    }

}
