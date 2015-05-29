/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject.server.packets.out;

import gameproject.NibblyBits;
import gameproject.server.Client;
import net.allgofree.blitzio.OutgoingPacket;
import net.allgofree.blitzio.PacketCreator;

/**
 *
 * @author Ryan Rule-Hoffman <ryan.rulehoffman@icloud.com>
 */
public class AddNibblyBit implements PacketCreator
{
    
    public static final int ID = 2;
    
    @Override
    public void write(OutgoingPacket packet, Object... parameters)
    {
        NibblyBits bits = (NibblyBits)parameters[0];
        packet.writeDWord(bits.getColor().getRGB());
        packet.writeWord((int)bits.getX());
        packet.writeWord((int)bits.getY());
        packet.writeWord((int)bits.getRadius());
    }

    @Override
    public int getId()
    {
        return ID;
    }
}
