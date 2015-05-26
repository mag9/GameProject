package gameproject;

import javax.swing.*;

/**
 *
 * @author jeremystark, blackalek,The Meowseph Stalin, mrMcMonigle, and Cingel.
 */
public class GameProject
{

    private final String title = "Agar 2.0";
    public static int WIDTH = 800;
    public static int HEIGHT = 600;
    private final int width = 800;
    private final int height = 600;
    
    /**
     * Constructor
     */
    public GameProject()
    {
        JFrame f = new JFrame();
        f.add(new TitleScreen());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setTitle(title);
        f.setSize(WIDTH, HEIGHT);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        GameProject gp = new GameProject("Game");
    }
    
}
