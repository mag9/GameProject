package gameproject;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.Graphics2D;
import static java.lang.Math.pow;

/**
 * A Cell in the game.
 * @author everybody
 */

public class Cell extends Circle
{
        
    /**
     * The color of the cell.
     */
    private final Color color;
    
    private final Color outerColor;
    
    /**
     * The X velocity of the cell.
     */
    private int velocityX;
    
    /**
     * The Y velocity of the cell.
     */
    private int velocityY;
    
    /**
     * The cell's current score.
     */
    private int score;
    
    /**
     * The player's username.
     */
    private final String username;
    
    /**
     * The font to use for drawing.
     */
    private Font font;
    
    /**
     * The player's speed.
     */
    private double speed;
    
    private double fontSize;
    
    /**
     * Constructor
     * @param x The X position of the player/cell.
     * @param y The Y position of the player/cell.
     * @param r The radius of the player/cell.
     * @param c The color(?) of the player/cell.
     */
    public Cell(String username, Color c, int x, int y, int r)
    {
        this.color = c;
        this.x = x;
        this.y = y;
        this.radius = r;
        this.velocityX = 0;
        this.velocityY = 0;
        this.username = username;
        this.outerColor = new Color(19, 158, 25);
        this.fontSize = 8;
        this.font = new Font("Ubuntu", Font.BOLD, (int)fontSize);
        calculateSpeed();
    }
    
    /**
     * Get the player's X position.
     * @return The player's X position.
     */
    public int getX()
    {
        return x;
    }
    
    /**
     * Get the player's Y position.
     * @return The player's Y position.
     */
    public int getY()
    {
        return y;
    }
    
    /**
     * Get the player's speed.
     * @return The player's speed.
     */
    public double getSpeed()
    {
        return this.speed;
    }
    
    /**
     * Get the cell's radius.
     * @return The cell's current radius.
     */
    public int getRadius()
    {
        return (int)radius;
    }
    
    /**
     * Set the cell's radius.
     * @param radius The radius.
     */
    public void setRadius(int radius)
    {
        this.radius = radius;
    }
    
    /**
     * Get the current size of the cell.
     * @return The current size.
     */
    public int getSize()
    {
        return (int)radius * 2;
    }
    
    /**
     * Called when a key is pressed.
     * @param e The key event.
     */
    public void keyPressed(KeyEvent e)
    {
        
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
    
    /**
     * Called when a key is released.
     * @param e The event.
     */
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
    
    /**
     * Draw the cell.
     * @param g The graphics context.
     */
    public void draw(Graphics2D g)
    {
        Graphics2D g2d = (Graphics2D) g;
        
        int radiusInt = (int) radius;
        
        g2d.setColor(color);
        g2d.fillOval(x, y, radiusInt * 2, radiusInt * 2);
        
        g2d.setColor(outerColor);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawOval(x, y, radiusInt * 2, radiusInt * 2);
        
        // Centers and draws the username over the player
        g2d.setColor(Color.black);
        g2d.setFont(font);
        int nameWidth = (int) g2d.getFontMetrics().getStringBounds(username, g2d).getWidth();
        g2d.drawString(username, x - (nameWidth / 2) + (radiusInt), y + radiusInt);
        
        move((int)(velocityX*3*speed), (int)(velocityY*3*speed));
    }
    
    /**
     * Move the cell.
     * @param deltaX The delta X value.
     * @param deltaY The delta Y value.
     */
    public void move(int deltaX, int deltaY)
    {
        x = x + deltaX;
        y = y + deltaY;
    }

    public void consume(NibblyBits next)
    {
        radius += 0.5D;
        fontSize = radius / 2.5;
        font = new Font("Ubuntu", Font.BOLD, (int) fontSize);
        calculateSpeed();
    }
    
    private void calculateSpeed()
    {
        speed = pow((17.0/20), radius - 20);
    }
    
}
