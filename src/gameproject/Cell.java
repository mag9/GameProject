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
        
        System.out.println("Key pressed");
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT)
            velocityX = -1;

        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT)
            velocityX = +1;

        if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP)
            velocityY = -1;

        if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN)
            velocityY = +1;
    }
    
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT)
            velocityX = 0;

        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT)
            velocityX = 0;

        if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP)
            velocityY = 0;

        if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN)
            velocityY = 0;
    }
    
    public void draw(Graphics2D g)
    {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(Color.GREEN);
        g2d.fillOval(x, y, radius * 2, radius * 2);
        
        move(velocityX*3, velocityY*3);
    }
    
    public void move(int deltaX, int deltaY)
    {
        x = x + deltaX;
        y = y + deltaY;
    }
    
}
