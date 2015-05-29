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
    protected double x;
    
    /**
     * The Y location of the cell.
     */
    protected double y;
    
    /**
     * The radius of the cell.
     */
    protected double radius;
    
    public double getCenterX()
    {
        return getX() + getRadius();
    }
    
    public double getCenterY()
    {
        return getY() + getRadius();
    }
    
    public boolean collidesWith(Circle other)
    {
        double dx = getCenterX() - other.getCenterX();
        double dy = getCenterY() - other.getCenterY();
        double distance = dx * dx + dy * dy;
        double radiusSum = getRadius() + other.getRadius();
        return distance < radiusSum * radiusSum;
    }

    /**
     * @return the x
     */
    public double getX()
    {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x)
    {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY()
    {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y)
    {
        this.y = y;
    }

    /**
     * @return the radius
     */
    public double getRadius()
    {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(double radius)
    {
        this.radius = radius;
    }
}
