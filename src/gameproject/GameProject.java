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
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setSize(800, 600);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    
}
