/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject.server;

import net.allgofree.blitzio.BlitzStream;
import net.allgofree.blitzio.Packet;
import net.allgofree.blitzio.PacketOutStream;
import net.allgofree.blitzio.authentication.AuthChain;
import net.allgofree.blitzio.authentication.AuthContext;
import net.allgofree.blitzio.authentication.AuthStep;
import net.allgofree.blitzio.authentication.AuthStepResponse;
import net.allgofree.blitzio.authentication.AuthenticationException;
import net.allgofree.blitzio.engine.AbstractAuthFactory;

/**
 * The object that creates authentication objects.
 * @author Ryan Rule-Hoffman <ryan.rulehoffman@icloud.com>
 */
public class AuthFactory extends AbstractAuthFactory
{
    
    /**
     * The authentication chain.
     */
    private final AuthChain chain;

    /**
     * Creates a new AuthFactory.
     * @param engine The engine of the server.
     * @param tickRate The tick rate of the server.
     */
    public AuthFactory(final ServerEngine engine, long tickRate)
    {
        super(tickRate);
        
        // Create a new chain of steps required for a player
        // to login
        chain = new AuthChain();
        
        // Add one step, which just logs the player in
        chain.add(new AuthStep()
        {

            @Override
            public AuthStepResponse execute(BlitzStream stream, Packet packet, PacketOutStream stream1, AuthContext ac) throws AuthenticationException
            {
                engine.getClientManager().add(new Client(stream));
                return AuthStepResponse.AUTH_FINISHED;
            }
        });
    }

    /**
     * Get the authentication chain.
     * @return The chain.
     */
    @Override
    protected AuthChain getChain()
    {
        return chain;
    }
    
}
