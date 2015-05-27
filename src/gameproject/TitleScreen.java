package gameproject;

import java.awt.*;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

/**
 * The title screen.
 * @author jeremystark
 **/

public class TitleScreen extends JPanel implements ActionListener 
{
    /**
     * The start button.
     */
    private final JButton startButton;
    
    /**
     * The exit button.
     */
    private final JButton exitButton;
    
    /**
     * The text field.
     */
    private final JTextField userName;
    
    /**
     * The width of a button.
     */
    private static final int BUTTON_WIDTH = 300;
    
    /**
     * Text field width constant.
     * 
     */
    private static final int FIELD_WIDTH = 150;

    /**
     *  Logo for the game
     */
    private final Image logo;
    
    /**
     * The instance of the game.
     */
    private final GameProject game;
    
    /**
     * Constructor
     * @param game The game.
     */
    public TitleScreen(GameProject game)
    {
        this.game = game;
        logo = new ImageIcon(getClass().getResource("/gameproject/res/graphics/logo.png")).getImage();
        
        setLayout(null);
        
        userName = new HintTextField("Username");
        userName.setLocation(GameProject.WIDTH / 2 - (FIELD_WIDTH / 2), 230);
        userName.setSize(FIELD_WIDTH, 30);
        add(userName);
        
        startButton = new JButton("Start");
        startButton.setLocation(GameProject.WIDTH / 2 - (BUTTON_WIDTH / 2), 280);
        startButton.setSize(BUTTON_WIDTH, 100);
        add(startButton);
        startButton.addActionListener(this);
        
        exitButton = new JButton("Exit");
        exitButton.setLocation(GameProject.WIDTH / 2 - (BUTTON_WIDTH / 2), 400);
        exitButton.setSize(BUTTON_WIDTH, 100);
        add(exitButton);
        exitButton.addActionListener(this);
        
        startButton.requestFocusInWindow();
    }
    
    /**
     * Called when a button is pressed.
     * @param e The event.
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        // If the exit button is pressed, the game exits.
        if(e.getSource() == exitButton)
        {
            System.exit(0);
        }
        else if(e.getSource() == startButton)
        {
            // Start the game!
            setVisible(false);
            game.startGame();
        }
    }
    
    /**
     * Paint the title screen.
     * @param g The graphics context.
     */
    @Override
    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, GameProject.WIDTH, GameProject.HEIGHT);
        
        super.paint(g);
        
        g2d.drawImage(logo, (GameProject.WIDTH / 2) - (logo.getWidth(this) / 2), 0, null);
    }

    public JButton getStartButton()
    {
        return startButton;
    }

}
