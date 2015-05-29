/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject.server;

import gameproject.GameProject;
import gameproject.NibblyBits;
import gameproject.Random;
import gameproject.server.packets.out.AddCell;
import gameproject.server.packets.out.AddNibblyBit;
import gameproject.server.packets.out.CellMoved;
import gameproject.server.packets.out.RemoveCell;
import java.util.ArrayList;
import net.allgofree.updater.Updatable;

/**
 * A world in the game that contains players, nibby bits, and so on.
 * @author Ryan Rule-Hoffman <ryan.rulehoffman@icloud.com>
 */
public class World implements Updatable
{
    
    /**
     * The maximum amount of bits to spawn in a given world.
     */
    public static final int MAX_BITS = 100;
    
    /**
     * The list of bits in the world.
     */
    private final ArrayList<NibblyBits> bits;
    
    /**
     * The list of cells in the world.
     */
    private final ArrayList<Client> cells;
    
    /**
     * Creates a new World.
     */
    public World()
    {
        bits = new ArrayList<NibblyBits>();
        cells = new ArrayList<Client>();
        
        // Spawn all the initial bits
        for (int i = 0; i < MAX_BITS; i++)
        {
            spawnNewBits();
        }
    }

    /**
     * Get the times when the world should be updated.
     * @return The times.
     */
    @Override
    public long[] updateTimes()
    {
        // Update the world (call updateAction(0)) every 1000 milliseconds, or every second :)
        return new long[] {1000};
    }

    /**
     * Called when the world should be updated.
     * @param index The index of the timer that fired.
     */
    @Override
    public void updateAction(int index)
    {
        // Check if we need to spawn more Nibbly Bits!
        if (bits.size() < MAX_BITS)
        {
            spawnNewBits();
        }
    }
    
    /**
     * Add a new cell.
     * @param cell The client cell.
     */
    public void addCell(Client cell)
    {
        // Send all other cells to the client
        // and the cell to all other clients
        for (Client next : cells)
        {
            cell.write(AddCell.ID, next);
            
            next.write(AddCell.ID, cell);
        }
        
        // Send all the bits to the client
        for (NibblyBits next : bits)
        {
            cell.write(AddNibblyBit.ID, next);
        }
        
        // Add the cell to the game
        cells.add(cell);
    }
    
    /**
     * Remove a cell from the world.
     * @param cell The cell.
     */
    public void removeCell(Client cell)
    {
        cells.remove(cell);
        
        // Broadcast to all other cells
        // that this one has died
        for (Client next : cells)
        {
            if (next == cell)
            {
                continue;
            }
            next.write(RemoveCell.ID, cell);
        }
    }
    
    /**
     * Spawn a new NibblyBits.
     */
    private void spawnNewBits()
    {
        int x = Random.randomInt(0, GameProject.WIDTH);
        int y = Random.randomInt(0, GameProject.HEIGHT);

        NibblyBits newBits = new NibblyBits();
        addBits(newBits);
    }
    
    /**
     * Add bits to the game.
     * @param newBits The new bits.
     */
    private void addBits(NibblyBits newBits)
    {
        bits.add(newBits);
        
        // Send the bits to all cells
        for (Client next : cells)
        {
            next.write(AddNibblyBit.ID, newBits);
        }
    }
    
    /**
     * Print debug text.
     * @param text The text.
     */
    private void debug(String text)
    {
        System.out.println("[World] " + text);
    }

    /**
     * Called when a cell moves.
     * @param client The client that moved.
     */
    public void cellMoved(Client client)
    {
        // Send the movement to all the other cells
        for (Client next : cells)
        {
            if (next == client)
            {
                continue;
            }
            
            next.write(CellMoved.ID, client);
        }
    }
}
