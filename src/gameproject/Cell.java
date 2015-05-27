package gameproject;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.Graphics2D;

/**
 * @author everybody
 */

public class Cell
{
    private int x;
    private int y;
    private int radius;
    private int velocityX; 
    private int velocityY;
    private String color;
    
    /**
     * Constructor
     * @param x The X position of the player/cell.
     * @param y The Y position of the player/cell.
     * @param r The radius of the player/cell.
     * @param c The color(?) of the player/cell.
     */
    public Cell(int x, int y, int r, String c)
    {
        this.x = x;
        this.y = y;
        this.radius = r;
        this.color = c;
        this.velocityX = 0;
        this.velocityY = 0;
    }
    
    /**
     * @return Returns the player's X position.
     */
    public int getX()
    {
        return x;
    }
    
    /**
     * @return Returns the player's Y position.
     */
    public int getY()
    {
        return y;
    }
    
    /**
     * @return Returns the player's current radius.
     */
    public int getRadius()
    {
        return radius;
    }
    
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT)
            x = -1;

        if (key == KeyEvent.VK_RIGHT)
            x = +1;

        if (key == KeyEvent.VK_UP)
            y = -1;

        if (key == KeyEvent.VK_DOWN)
            y = +1;
    }
    
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT)
            x = 0;

        if (key == KeyEvent.VK_RIGHT)
            x = 0;

        if (key == KeyEvent.VK_UP)
            y = 0;

        if (key == KeyEvent.VK_DOWN)
            y = 0;
    }
    
    public void draw(Graphics2D g)
    {
        g.setColor(Color.GREEN);
        g.drawOval(x, y, radius * 2, radius * 2);
    }
    
}
