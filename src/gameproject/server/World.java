/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject.server;

import gameproject.GameProject;
import gameproject.NibblyBits;
import gameproject.Random;
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
     * @param client The client cell.
     */
    public void addCell(Client cell)
    {
        // Send all other cells to the client
        for (Client next : cells)
        {
            
        }
        
        // Send all the bits to the client
        for (NibblyBits next : bits)
        {
            
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
        
    }
}
