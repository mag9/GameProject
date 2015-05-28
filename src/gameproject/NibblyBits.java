package gameproject;

import java.awt.*;

/**
 * @author jeremystark
 **/

public class NibblyBits 
{

    /**
     * The size of the NibblyBit.
     * Will always be 1.
     */
    private final int size;
    
    /**
     * The x and y position of the nibbly bit.
     */
    private int x, y;
    
    /**
     * The color of the nibbly bit.
     */
    private final Color color;
    
    /**
     * A random int ranging from 0 - 255.
     */
    private int randomColor;
    
    private Cell cell;
    
    /**
     * The constructor.
     */
    public NibblyBits()
    {
        cell = new Cell(null, Color.BLUE, 10, 10, 10);
        size = 1;
        x = 0 + (int)(Math.random()* GameProject.WIDTH);
        y = 0 + (int)(Math.random()* GameProject.HEIGHT); 
        randomColor = 0 + (int)(Math.random()* 100); 
        color = new Color(randomColor, randomColor, randomColor);
    }
    
    /**
     * Checks for collision with player.
     * @return Returns true if it has collided with player
     * and false otherwise.
     */
    public boolean checkCollision()
    {
        boolean isEaten = false;
        
        if(cell.getX() == this.x)
        {
            if(cell.getY() == this.y)
            {
                isEaten = true;
            }
        }
        
        return isEaten;
    }
    
    public void draw(Graphics2D g)
    {
        Graphics2D g2d = (Graphics2D) g;
        
        if(checkCollision() == false)
        {
            g2d.setColor(color);
            g2d.fillOval(x, y, size * 10, size  * 10);
        } else {
            g2d.dispose();
        }
    }
}
