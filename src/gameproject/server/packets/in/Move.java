/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject.server.packets.in;

import gameproject.server.Client;
import net.allgofree.blitzio.BlitzStream;
import net.allgofree.blitzio.IncomingPacket;
import net.allgofree.blitzio.PacketHandler;

/**
 *
 * @author Ryan Rule-Hoffman <ryan.rulehoffman@icloud.com>
 */
public class Move implements PacketHandler
{

    @Override
    public void handlePacket(IncomingPacket packet, BlitzStream stream)
    {
        Client client = (Client)stream.getAttachment();
        int x = packet.readSignedWord();
        int y = packet.readSignedWord();
        
        client.getCircle().setX(x);
        client.getCircle().setY(y);
        
        client.getWorld().cellMoved(client);
    }

    @Override
    public int[] getBinds()
    {
        return new int[] {2};
    }
    
}
