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
    
    /**
     * The constructor.
     */
    public NibblyBits()
    {
        this(Random.randomInt(0, GameProject.WIDTH), Random.randomInt(0, GameProject.HEIGHT), Random.getRandomColor());
    }
    
    /**
     * The constructor.
     * @param x The X location of the bits.
     * @param y The Y location of the bits.
     * @param color The color of the bits.
     */
    public NibblyBits(int x, int y, Color color)
    {
        this.x = x;
        this.y = y;
        this.color = color;
        this.size = 1;
        this.radius = 10;
    }
    
    public Color getColor()
    {
        return color;
    }
    
    public void draw(Graphics2D g)
    {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(color);
        g2d.fillOval((int) getX(), (int) getY(), size * 10, size  * 10);
        
        /*if(checkCollision() == false)
        {
            g2d.setColor(color);
            g2d.fillOval(x, y, size * 10, size  * 10);
        } else {
            g2d.dispose();
        }*/
    }
    
}
