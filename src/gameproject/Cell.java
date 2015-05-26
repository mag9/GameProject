package gameproject;

import java.awt.event.KeyEvent;
import java.awt.Graphics2D;

/**
 *
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
    
    
    public Cell(int x, int y, int r, String c)
    {
        this.x = x;
        this.y = y;
        this.radius = r;
        this.color = c;
        this.velocityX = 0;
        this.velocityY = 0;
    }
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public void keyPressed(KeyEvent e)
    {
    
    }
    
    public void keyReleased(KeyEvent e)
    {
        
    }
    
    public void draw(Graphics2D g)
    {
        
    }
    
}
