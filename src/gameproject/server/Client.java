/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject.server;

import gameproject.Cell;
import gameproject.Circle;
import java.awt.Color;
import net.allgofree.blitzio.BlitzStream;
import net.allgofree.blitzio.engine.AbstractClient;

/**
 * A client.
 * @author Ryan Rule-Hoffman <ryan.rulehoffman@icloud.com>
 */
public class Client extends AbstractClient
{
    
    /**
     * The manager of the client.
     */
    protected ClientManager manager;
    
    /**
     * The underlying circle of the client that represents the cell.
     */
    private final Circle circle;
    
    /**
     * The username of the player.
     */
    private String username = null;
    
    /**
     * The color of the cell.
     */
    private Color color;

    /**
     * Creates a new Client.
     * @param stream The network connection of the client.
     */
    public Client(BlitzStream stream)
    {
        super(stream);
        
        circle = new Circle();
        circle.setRadius(Cell.STARTING_RADIUS);
        
        // Attach the client to the stream
        stream.attach(this);
        System.out.println("Connection from " + stream.getInetAddress());
    }
    
    /**
     * Get the world that the client is currently in.
     * @return The world.
     */
    public World getWorld()
    {
        return manager.getWorld();
    }
    
    /**
     * Update the client.
     */
    @Override
    public void update()
    {
        super.update();
    }
    
    public Circle getCircle()
    {
        return circle;
    }

    /**
     * @return the username
     */
    public String getUsername()
    {
        return username;
    }
    
    public Color getColor()
    {
        return color;
    }

    /**
     * @param username the username to set
     * @param color The color to set.
     */
    public void setUsernameAndColor(String username, Color color)
    {
        if (username != null)
        {
            throw new IllegalStateException("Username already set.");
        }
        this.username = username;
        this.color = color;
        
        // Now that we have a username and color, place the cell
        // on the world!
        getWorld().addCell(this);
    }
    
}
