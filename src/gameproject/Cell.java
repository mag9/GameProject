package gameproject;

import java.awt.*;
import java.awt.event.*;

/**
 * A Cell in the game.
 * @author everybody
 */

public class Cell extends Circle
{
    
    public static final int STARTING_RADIUS = 20;
        
    /**
     * The color of the cell.
     */
    private final Color color;
    
    private final Color outerColor;
    
    /**
     * The X velocity of the cell.
     */
    private double velocityX;
    
    /**
     * The Y velocity of the cell.
     */
    private double velocityY;
    
    /**
     * The friction on the cells movement.
     */
     private final double friction;
     
     /**
      * The max speed.
      */
     private final int speed;
    
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
        this.friction = 0.45;
        this.speed = 3;
        this.username = username;
        this.outerColor = new Color(19, 158, 25);
        this.fontSize = 8;
        this.font = new Font("Ubuntu", Font.BOLD, (int)fontSize);
    }
    
    /**
     * Get the current size of the cell.
     * @return The current size.
     */
    public int getSize()
    {
        return (int)getRadius() * 2;
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
            velocityX *= friction;

        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT)
            velocityX *= friction;

        if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP)
            velocityY *= friction;

        if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN)
            velocityY *= friction;
    }
    
    /**
     * Draw the cell.
     * @param g The graphics context.
     */
    public void draw(Graphics2D g)
    {
        Graphics2D g2d = (Graphics2D) g;
        
        int radiusInt = (int) getRadius();
        
        g2d.setColor(color);
        g2d.fillOval((int) getX(), (int) getY(), radiusInt * 2, radiusInt * 2);
        
        g2d.setColor(outerColor);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawOval((int) getX(), (int) getY(), radiusInt * 2, radiusInt * 2);
        
        // Centers and draws the username in the player
        g2d.setColor(Color.black);
        g2d.setFont(font);
        int nameWidth = (int) g2d.getFontMetrics().getStringBounds(username, g2d).getWidth();
        int nameHeight = (int) g2d.getFontMetrics().getStringBounds(username, g2d).getHeight();
        g2d.drawString(username, (int) getX() + (radiusInt) - (nameWidth / 2), (int) (getY() + radiusInt) + (nameHeight / 4));
        
        move(velocityX * speed, velocityY * speed);
    }
    
    /**
     * Move the cell.
     * @param deltaX The delta X value.
     * @param deltaY The delta Y value.
     */
    public void move(double deltaX, double deltaY)
    {
        setX(getX() + deltaX * friction);
        setY(getY() + deltaY * friction);
    }

    public void consume(NibblyBits next)
    {
        setRadius(getRadius() + 0.5D);
        fontSize = getRadius() / 2.5;
        font = new Font("Ubuntu", Font.BOLD, (int) fontSize);
    }
    
}
