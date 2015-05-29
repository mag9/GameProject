/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject.server.packets.in;

import gameproject.server.Client;
import java.awt.Color;
import net.allgofree.blitzio.BlitzStream;
import net.allgofree.blitzio.IncomingPacket;
import net.allgofree.blitzio.PacketHandler;

/**
 * Handles the set username packet.
 * @author Ryan Rule-Hoffman <ryan.rulehoffman@icloud.com>
 */
public class SetUsername implements PacketHandler
{

    @Override
    public void handlePacket(IncomingPacket packet, BlitzStream stream)
    {
        Client client = (Client)stream.getAttachment();
        String username = packet.readStringAGF();
        int rgbColor = packet.readDWord();
        Color color = new Color(rgbColor);
    }

    @Override
    public int[] getBinds()
    {
        return new int[] {1};
    }
    
}
