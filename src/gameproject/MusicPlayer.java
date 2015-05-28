/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 * Plays music.
 * @author Ryan & Jeremy
 */
public class MusicPlayer implements Runnable
{
    /**
     * Play the music.
     */
    @Override
    public void run()
    {
        try
        {
            InputStream resourceAsStream = getClass().getResourceAsStream("/gameproject/res/music/demo.mp3");
            final Player player = new Player(resourceAsStream);
            while (true)
            {
                player.play();
            }
        } catch (JavaLayerException ex)
        {
            Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
