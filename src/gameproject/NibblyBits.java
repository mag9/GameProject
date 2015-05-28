package gameproject;

import java.awt.*;

/**
 * @author jeremystark
 **/

public class NibblyBits extends Circle
{

    /**
     * The size of the NibblyBit.
     * Will always be 1.
     */
    private final int size;
    
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
        color = new Color(randomInt(0, 255), randomInt(0, 255), randomInt(0, 255));
        radius = 10;
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
        
        g2d.setColor(color);
        g2d.fillOval(x, y, size * 10, size  * 10);
        
        /*if(checkCollision() == false)
        {
            g2d.setColor(color);
            g2d.fillOval(x, y, size * 10, size  * 10);
        } else {
            g2d.dispose();
        }*/
    }
    
    /**
     * Generate a random integer.
     * @param lowestNumber The lowest possible number. (Included)
     * @param highestNumber The highest possible number. (Included)
     * @return The generated number.
     */
    public static int randomInt(int lowestNumber, int highestNumber)
    {
        if (highestNumber < lowestNumber)
        {
            int temp = highestNumber;
            highestNumber = lowestNumber;
            lowestNumber = temp;
        }
        highestNumber++;
        int theRange = highestNumber-lowestNumber;
        return (int)(java.lang.Math.random() * (theRange)) + lowestNumber;
    }
}
