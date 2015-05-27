package gameproject;

import javax.swing.*;

/**
 * The main game project class.
 * @author jeremystark, blackalek,The Meowseph Stalin, mrMcMonigle, and Cingel.
 */
public class GameProject
{
    
    /**
     * The width of the game.
     */
    public static int WIDTH = 800;
    
    /**
     * The height of the game.
     */
    public static int HEIGHT = 600;
    
    /**
     * The game's window.
     */
    private final JFrame frame;
    
    /**
     * The title screen.
     */
    private final TitleScreen titleScreen;
    
    /**
     * The game screen.
     */
    private final GameScreen gameScreen;
    
    /**
     * Constructor
     * @param title The title of the window.
     */
    public GameProject(String title)
    {
        // Create a new frame
        frame = new JFrame(title);
        
        // Set frame settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        
        // Create a new title screen instance.
        titleScreen = new TitleScreen(this);
        
        // Create a new game screen instance.
        gameScreen = new GameScreen(this);
        
        // Add the title screen to the frame
        frame.add(titleScreen);
        
        // Make the window visible to the user
        frame.setVisible(true);
    }
    
    /**
     * Start the game.
     */
    public void startGame()
    {
        frame.add(gameScreen);
        gameScreen.requestFocus();
    }
    
    /**
     * End the game.
     */
    public void endGame()
    {
        frame.remove(gameScreen);
        titleScreen.setVisible(true);
    }
    
    /**
     * The main method.
     * @param args The command line arguments.
     */
    public static void main(String[] args)
    {
        GameProject gp = new GameProject("OHS Agar");
    }
    
}
