package gameproject;

import java.awt.*;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author jeremystark
 **/

public class GameScreen extends JPanel implements ActionListener 
{
    private final Cell player;
    
    private Image backgroundImage;
    
    public GameScreen()
    {
        addKeyListener(new GameKeyListener());
        
        player = new Cell(20, 20, 20, "Color.GREEN");
        
        backgroundImage = new ImageIcon(getClass().getResource("/gameproject/res/graphics/back.png")).getImage();
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        player.move(-1, -1);
        
        repaint();
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw the background.
        g2d.drawImage(backgroundImage, 0, 0, null);
        
        // Draw the player.
        g2d.fillOval(player.getX(), player.getY(), player.getRadius(), player.getRadius());
    }
    
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
