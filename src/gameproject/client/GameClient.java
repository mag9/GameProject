/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject.client;

import gameproject.server.ServerEngine;
import net.allgofree.blitzio.BlitzStream;
import net.allgofree.blitzio.StreamHandler;
import net.allgofree.blitzio.netty.NettyLife;

/**
 * The game client.
 * @author Ryan Rule-Hoffman <ryan.rulehoffman@icloud.com>
 */
public class GameClient
{
    
    /**
     * The connector.
     */
    private final NettyLife connector;
    
    /**
     * The current connection to the server.
     */
    private BlitzStream stream;
    
    /**
     * Creates a new GameClient.
     */
    public GameClient()
    {
        connector = new NettyLife();
        connector.startLifeThread();
    }
    
    /**
     * Connect to the server.
     */
    public void connect()
    {
        final GameClient client = this;
        
        connector.connect("127.0.0.1", ServerEngine.PORT, 10000, new StreamHandler()
        {

            @Override
            public void handle(BlitzStream stream)
            {
                client.stream = stream;
                System.out.println("Connected to server!");
            }

            @Override
            public void handleFailure(String address, int port)
            {
                System.out.println("Error connecting to server.");
            }
        });
    }
    
    /**
     * Disconnect from the server.
     */
    public void disconnect()
    {
        
    }
}
