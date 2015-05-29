/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.awt.Color;

/**
 * Contains functions to generate random numbers.
 * @author Ryan Rule-Hoffman <ryan.rulehoffman@icloud.com>
 */
public class Random
{
    /**
     * Generate a random integer.
     * @param lowestNumber The lowest possible number. (Included)
     * @param highestNumber The highest possible number. (Included)
     * @return The generated number.
     */
    public static int randomInt(int lowestNumber, int highestNumber)
    {
        if (highestNumber < lowestNumber)
        {
            int temp = highestNumber;
            highestNumber = lowestNumber;
            lowestNumber = temp;
        }
        highestNumber++;
        int theRange = highestNumber-lowestNumber;
        return (int)(java.lang.Math.random() * (theRange)) + lowestNumber;
    }
    
    /**
     * Get a random color.
     * @return The random color.
     */
    public static Color getRandomColor()
    {
        return new Color(randomInt(0, 255), randomInt(0, 255), randomInt(0, 255));
    }
}
