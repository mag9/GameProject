package gameproject;

import java.awt.*;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author jeremystark
 **/

public class TitleScreen extends JPanel implements ActionListener 
{
    
    /**
     * The width of a button.
     */
    private static final int BUTTON_WIDTH = 300;

    /**
     *  Logo for the game
     */
    private final Image logo;
    
    /**
     * Constructor
     */
    public TitleScreen()
    {
        logo = new ImageIcon(getClass().getResource("/gameproject/res/graphics/logo.png")).getImage();
        
        setLayout(null);
        JButton startButton = new JButton("Start");
        startButton.setLocation(GameProject.WIDTH / 2 - (BUTTON_WIDTH / 2), 230);
        startButton.setSize(BUTTON_WIDTH, 100);
        add(startButton);
        
        JButton exitButton = new JButton("Exit");
        exitButton.setLocation(GameProject.WIDTH / 2 - (BUTTON_WIDTH / 2), 350);
        exitButton.setSize(BUTTON_WIDTH, 100);
        add(exitButton);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void paint(Graphics g)
    {
        
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, GameProject.WIDTH, GameProject.HEIGHT);
        
        super.paint(g);
        
        g2d.drawImage(logo, (GameProject.WIDTH / 2) - (logo.getWidth(this) / 2), 0, null);
        
        System.out.println("logo drawn");
        
        
    }

}
