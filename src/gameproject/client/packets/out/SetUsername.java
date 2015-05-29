/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject.client.packets.out;

import java.awt.Color;
import net.allgofree.blitzio.OutgoingPacket;
import net.allgofree.blitzio.PacketCreator;

/**
 * Creates the set username packet.
 * @author Ryan Rule-Hoffman <ryan.rulehoffman@icloud.com>
 */
public class SetUsername implements PacketCreator
{
    
    /**
     * The ID of the packet.
     */
    public static final int ID = 1;

    /**
     * Write the packet.
     * @param packet The packet object to write too.
     * @param parameters The parameters of the packet.
     */
    @Override
    public void write(OutgoingPacket packet, Object... parameters)
    {
        packet.writeStringAGF((String)(parameters[0]));
        Color color = (Color)parameters[1];
        packet.writeDWord(color.getRGB());
    }

    /**
     * Get the ID of the packet.
     * @return The ID.
     */
    @Override
    public int getId()
    {
        return ID;
    }
    
}
