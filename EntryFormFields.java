/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forceonanobjectatdepth;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author AndrewSpiteri
 */
public class EntryFormFields extends JPanel{
    private JLabel depthLabel = new JLabel("Enter the depth of the object: ");
    private JLabel widthLabel = new JLabel("Enter the width of the object: ");
    private JLabel lengthLabel = new JLabel("Enter the length of the object: ");
    private JLabel thickLabel = new JLabel("Enter the thickness of the object: ");
    
    protected JTextField depthText = new JTextField("0",10);
    protected JTextField widthText = new JTextField("0",10);
    protected JTextField lengthText = new JTextField("0",10);
    protected JTextField thickText = new JTextField("0",10);
    
    EntryFormFields(){
        setLayout(new GridLayout(4,1));
        
        add(depthLabel);
        add(depthText);
        add(widthLabel);
        add(widthText);
        add(lengthLabel);
        add(lengthText);
        add(thickLabel);
        add(thickText);
    }

