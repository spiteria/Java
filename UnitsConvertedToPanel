/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forceonanobjectatdepth;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author AndrewSpiteri
 */
public class UnitsConvertedToPanel extends JPanel {
    protected JRadioButton mmRButton2 = new JRadioButton("millimeters",true);
    protected JRadioButton cmRButton2 = new JRadioButton("centimeters",true);
    protected JRadioButton mRButton2 = new JRadioButton("meters");
    protected JRadioButton kmRButton2 = new JRadioButton("kilometers");
    protected JRadioButton inRButton2 = new JRadioButton("inches");
    protected JRadioButton ftRButton2 = new JRadioButton("feet");
    protected JRadioButton ydRButton2 = new JRadioButton("yards");
    protected JRadioButton miRButton2 = new JRadioButton("miles");
    private ButtonGroup unitsConvertedTo = new ButtonGroup();
    private Border raisedBevConvertTo = BorderFactory.createRaisedBevelBorder();
    private TitledBorder titledConvertTo = BorderFactory.createTitledBorder(raisedBevConvertTo, "Convert To");
    
    public UnitsConvertedToPanel(){
        setLayout(new GridLayout(8,1));
        
        titledConvertTo.setTitleJustification(TitledBorder.LEFT);
        
        unitsConvertedTo.add(mmRButton2);
        unitsConvertedTo.add(cmRButton2);
        unitsConvertedTo.add(mRButton2);
        unitsConvertedTo.add(kmRButton2);
        unitsConvertedTo.add(inRButton2);
        unitsConvertedTo.add(ftRButton2);
        unitsConvertedTo.add(ydRButton2);
        unitsConvertedTo.add(miRButton2);
        
        setBorder(titledConvertTo);
        
        add(mmRButton2);
        add(cmRButton2);
        add(mRButton2);
        add(kmRButton2);
        add(inRButton2);
        add(ftRButton2);
        add(ydRButton2);
        add(miRButton2);
    }
}
