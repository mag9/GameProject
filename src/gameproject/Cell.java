package gameproject;

import java.awt.event.KeyEvent;

/**
 *
 * @author blackalek
 */
public class Cell
{
    private int x = 0;
    private int y = 0;
    private int r = 0;
    private int velocityX = 0; 
    private int velocityY = 0;
    
    public Cell(int radius)
    {
        r = radius;
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
