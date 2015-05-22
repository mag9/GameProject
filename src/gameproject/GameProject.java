package gameproject;

import javax.swing.*;

/**
 *
 * @author jeremystark, blackalek,The Meowseph Stalin, mrMcMonigle, and Cingel.
 */
public class GameProject
{

    private String title = "Game!";
    private int width = 800;
    private int height = 600;
    
    public GameProject()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setTitle(title);
        f.setSize(width, height);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        GameProject gp = new GameProject();
    }
    
}
