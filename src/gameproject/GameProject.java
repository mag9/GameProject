package gameproject;

import java.awt.BorderLayout;
import javax.swing.*;

/**
 *
 * @author jeremystark, blackalek,The Meowseph Stalin, mrMcMonigle, and Cingel.
 */
public class GameProject
{

    /**
     * The title of the window.
     */
    private final String title = "OHS Agar";
    
    /**
     * The width of the game.
     */
    public static int WIDTH = 800;
    
    /**
     * The height of the game.
     */
    public static int HEIGHT = 600;
    
    /**
     * Constructor
     */
    public GameProject()
    {
        // Create a new frame
        JFrame frame = new JFrame();
        
        // Set frame settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle(title);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        
        // Create a new title screen
        TitleScreen titleScreen = new TitleScreen();
        
        // Add the title screen to the frame
        frame.add(titleScreen);
        
        // Make the window visible to the user
        frame.setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        GameProject gp = new GameProject();
    }
    
}
