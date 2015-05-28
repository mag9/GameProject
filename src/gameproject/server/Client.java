/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject.server;

import net.allgofree.blitzio.BlitzStream;
import net.allgofree.blitzio.engine.AbstractClient;

/**
 * A client.
 * @author Ryan Rule-Hoffman <ryan.rulehoffman@icloud.com>
 */
public class Client extends AbstractClient
{

    /**
     * Creates a new Client.
     * @param stream The network connection of the client.
     */
    public Client(BlitzStream stream)
    {
        super(stream);
        System.out.println("Connection from " + stream.getInetAddress());
    }
    
}
