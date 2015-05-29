/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject.server.packets.out;

import gameproject.NibblyBits;
import net.allgofree.blitzio.OutgoingPacket;
import net.allgofree.blitzio.PacketCreator;

/**
 *
 * @author Ryan Rule-Hoffman <ryan.rulehoffman@icloud.com>
 */
public class RemoveNibblyBit implements PacketCreator
{
    
    public static final int ID = 4;
    
    @Override
    public void write(OutgoingPacket packet, Object... parameters)
    {
        NibblyBits bits = (NibblyBits)parameters[0];
        packet.writeWord((int)bits.getX());
        packet.writeWord((int)bits.getY());
    }

    @Override
    public int getId()
    {
        return ID;
    }
}
