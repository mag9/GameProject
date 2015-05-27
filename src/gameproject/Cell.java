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
    
    public int getSize()
    {
        return radius * 2;
    }
    
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A)
            x = -1;

        if (key == KeyEvent.VK_D)
            x = +1;

        if (key == KeyEvent.VK_W)
            y = -1;

        if (key == KeyEvent.VK_S)
            y = +1;
    }
    
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A)
            x = 0;

        if (key == KeyEvent.VK_D)
            x = 0;

        if (key == KeyEvent.VK_W)
            y = 0;

        if (key == KeyEvent.VK_S)
            y = 0;
    }
    
    public void draw(Graphics2D g)
    {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(Color.GREEN);
        g2d.drawOval(x, y, radius * 2, radius * 2);
    }
    
    public void move(int deltaX, int deltaY)
    {
        x = x - deltaX;
        y = y - deltaY;
    }
    
}
