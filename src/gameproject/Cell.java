package gameproject;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.Graphics2D;

/**
 * A Cell in the game.
 * @author everybody
 */

public class Cell
{
        
    /**
     * The color of the cell.
     */
    private final Color color;
    
    /**
     * The X location of the cell.
     */
    private int x;
    
    /**
     * The Y location of the cell.
     */
    private int y;
    
    /**
     * The radius of the cell.
     */
    private int radius;
    
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
     * Get the cell's radius.
     * @return The cell's current radius.
     */
    public int getRadius()
    {
        return radius;
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
        return radius * 2;
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
        
        g2d.setColor(color);
        g2d.fillOval(x, y, radius * 2, radius * 2);
        
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawOval(x, y, radius * 2, radius * 2);
        
        // Centers and draws the username over the player
        int nameWidth = (int) g2d.getFontMetrics().getStringBounds(username, g2d).getWidth();
        g2d.drawString(username, x - (nameWidth / 2) + (radius), y - 5);
        
        move(velocityX*3, velocityY*3);
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
    
}
