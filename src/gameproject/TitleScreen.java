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
     *  Logo for the game
     */
    private final Image logo;
    
    //private final JButton start; 
    
    /**
     * Constructor
     */
    public TitleScreen()
    {
        logo = new ImageIcon(getClass().getResource("/gameproject/res/graphics/logo.png")).getImage();
    }
            
    @Override
    public void actionPerformed(ActionEvent e)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, GameProject.WIDTH, GameProject.HEIGHT);
        
        g2d.drawImage(logo, 0, 0, null);
        
        System.out.println("logo drawn");
    }

}
