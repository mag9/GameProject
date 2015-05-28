/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject.server;

import net.allgofree.blitzio.engine.AbstractClientManager;
import net.allgofree.blitzio.engine.AbstractEngine;

/**
 * Manages all of the clients connected to the server.
 * @author Ryan Rule-Hoffman <ryan.rulehoffman@icloud.com>
 */
public class ClientManager extends AbstractClientManager<Client>
{

    /**
     * Creates a new ClientManager.
     * @param engine The engine of the server.
     * @param tickRate The tick rate of the server.
     */
    public ClientManager(AbstractEngine engine, long tickRate)
    {
        super(engine, tickRate);
    }
    
}
