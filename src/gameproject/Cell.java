package gameproject;

import java.awt.event.KeyEvent;

/**
 *
 * @author everybody
 */
public class Cell
{
    private int x = 0;
    private int y = 0;
    private int radius = 0;
    private int velocityX = 0; 
    private int velocityY = 0;
    
    
    public Cell(int x, int y, int r)
    {
        this.x = x;
        this.y = y;
        this.radius = r;
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
    
    
}
