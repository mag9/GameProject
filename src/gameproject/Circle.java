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
    protected int radius;
    
    public int getCenterX()
    {
        return x + radius;
    }
    
    public int getCenterY()
    {
        return y + radius;
    }
    
    public boolean collidesWith(Circle other)
    {
        float dx = getCenterX() - other.getCenterX();
        float dy = getCenterY() - other.getCenterY();
        float distance = dx * dx + dy * dy;
        float radiusSum = radius + other.radius;
        return distance < radiusSum * radiusSum;
    }
}
