/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject.server;
import net.allgofree.blitzio.authentication.Authenticator;
import net.allgofree.blitzio.engine.AbstractEngine;
import net.allgofree.blitzio.netty.NettyLife;

/**
 * The engine of the server.
 * @author Ryan Rule-Hoffman <ryan.rulehoffman@icloud.com>
 */
public class ServerEngine extends AbstractEngine
{
    
    /**
     * The port to listen on.
     */
    public static final int PORT = 20325;
    
    /**
     * The manager for all of the connected game clients.
     */
    private final ClientManager clientManager;
    
    /**
     * The listener for the network connections.
     */
    private final NettyLife listener;

    /**
     * Creates a new ServerEngine.
     */
    public ServerEngine()
    {
        super(100);
        
        // Create a new ClientManager
        clientManager = new ClientManager(this, getMasterTickRate());
        
        // Create our listener object and tell it what port to listen on
        listener = new NettyLife();
        listener.addPort(PORT);
    }
    
    /**
     * Called right before the server starts.
     */
    @Override
    public void prepareToStart()
    {
        // Create a new factory for our authentication objects
        AuthFactory authFactory = new AuthFactory(this, getMasterTickRate());
        
        // Create a new authenticator that takes in connections from our 
        // listener and sends them to our factory
        Authenticator authenticator = new Authenticator(getMasterTickRate(), listener, authFactory);
        
        // Add both the ClientManager and Authenticator to our updater
        // so that they actually do work!
        getUpdater().addUpdate(clientManager);
        getUpdater().addUpdate(authenticator);
        getUpdater().addUpdate(clientManager.getWorld());
        
        // Start the listener
        listener.startLifeThread();
        
        // Let the user know the server is running!
        System.out.println("Server started!");
    }
    
    /**
     * Get the client manager.
     * @return The client manager.
     */
    public ClientManager getClientManager()
    {
        return clientManager;
    }
    
    /**
     * The main method.
     * @param args The command line arguments.
     */
    public static void main(String[] args)
    {
        // Create a new instance of our engine
        ServerEngine engine = new ServerEngine();
        
        // Start the server
        engine.start();
    }
    
}
