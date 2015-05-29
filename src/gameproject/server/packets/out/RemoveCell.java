/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject.server.packets.out;

import gameproject.server.Client;
import net.allgofree.blitzio.OutgoingPacket;
import net.allgofree.blitzio.PacketCreator;

/**
 *
 * @author Ryan Rule-Hoffman <ryan.rulehoffman@icloud.com>
 */
public class RemoveCell implements PacketCreator
{
    public static final int ID = 5;

    @Override
    public void write(OutgoingPacket packet, Object... parameters)
    {
        Client cell = (Client)parameters[0];
        packet.writeStringAGF(cell.getUsername());
    }

    @Override
    public int getId()
    {
        return ID;
    }
}
