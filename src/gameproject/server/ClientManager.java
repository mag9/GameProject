/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject.server;

import java.util.logging.Level;
import java.util.logging.Logger;
import net.allgofree.blitzio.engine.AbstractClientManager;
import net.allgofree.blitzio.engine.AbstractEngine;

/**
 * Manages all of the clients connected to the server.
 * @author Ryan Rule-Hoffman <ryan.rulehoffman@icloud.com>
 */
public class ClientManager extends AbstractClientManager<Client>
{
    
    /**
     * The single game world.
     */
    private final World world;

    /**
     * Creates a new ClientManager.
     * @param engine The engine of the server.
     * @param tickRate The tick rate of the server.
     */
    public ClientManager(AbstractEngine engine, long tickRate)
    {
        super(engine, tickRate);
        
        world = new World();
        
        try
        {
            getPacketReader().addAllFromPackage("gameproject.server.packets.in");
            getPacketWriter().addAllFromPackage("gameproject.server.packets.out");
        } catch (Exception ex)
        {
            Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Add a client to the manager.
     * @param client The client to add.
     */
    @Override
    public void add(Client client)
    {
        // Set the manager of the client
        client.manager = this;
        
        // Tell our superclass to add the client
        super.add(client);
    }
    
    /**
     * Called when a player disconnects.
     * @param client The client that disconnected.
     */
    @Override
    protected void handleClientDisconnect(Client client)
    {
        world.removeCell(client);
    }
    
    /**
     * Get the game world.
     * @return The game world.
     */
    public World getWorld()
    {
        return world;
    }
    
}
