/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 * A hinted text field.
 *
 * @author ry60003333
 */
public class HintTextField extends JTextField implements FocusListener
{

    /**
     * The hint text.
     */
    private final String hint;

    /**
     * Creates a new HintTextField.
     * @param hint The hint text.
     */
    public HintTextField(final String hint)
    {
        super(hint);
        this.hint = hint;
        super.setForeground(Color.GRAY);
        super.addFocusListener(this);
    }

    /**
     * Called when the field gains focus.
     * @param e The event.
     */
    @Override
    public void focusGained(FocusEvent e)
    {
        super.setForeground(Color.BLACK);
        if (this.getText().isEmpty())
        {
            super.setText("");
        }
    }

    /**
     * Called when the text field loses focus.
     * @param e The event.
     */
    @Override
    public void focusLost(FocusEvent e)
    {
        if (this.getText().isEmpty())
        {
            super.setForeground(Color.GRAY);
            super.setText(hint);
        }
        else
        {
            super.setForeground(Color.BLACK);
        }
    }

    /**
     * Get the text in the field.
     * @return The text.
     */
    @Override
    public String getText()
    {
        String typed = super.getText();
        return typed.equals(hint) ? "" : typed;
    }

}
