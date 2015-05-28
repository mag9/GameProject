/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

/**
 *
 * @author Ryan Rule-Hoffman <ryan.rulehoffman@icloud.com>
 */
public class Circle
{
    /**
     * The X location of the cell.
     */
    protected int x;
    
    /**
     * The Y location of the cell.
     */
    protected int y;
    
    /**
     * The radius of the cell.
     */
    protected double radius;
    
    public int getCenterX()
    {
        return x + (int)radius;
    }
    
    public int getCenterY()
    {
        return y + (int)radius;
    }
    
    public boolean collidesWith(Circle other)
    {
        double dx = getCenterX() - other.getCenterX();
        double dy = getCenterY() - other.getCenterY();
        double distance = dx * dx + dy * dy;
        double radiusSum = radius + other.radius;
        return distance < radiusSum * radiusSum;
    }
}
