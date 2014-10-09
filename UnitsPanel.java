/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forceonanobjectatdepth;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author AndrewSpiteri
 */
public class UnitsPanel extends javax.swing.JPanel {

    /**
     * Creates new form UnitsEnteredPanel
     */
    
    protected JRadioButton mmRButton = new JRadioButton("millimeters",true);
    protected JRadioButton cmRButton = new JRadioButton("centimeters",true);
    protected JRadioButton mRButton = new JRadioButton("meters");
    protected JRadioButton kmRButton = new JRadioButton("kilometers");
    protected JRadioButton inRButton = new JRadioButton("inches");
    protected JRadioButton ftRButton = new JRadioButton("feet");
    protected JRadioButton ydRButton = new JRadioButton("yards");
    protected JRadioButton miRButton = new JRadioButton("miles");
    private ButtonGroup unitsConvertFrom = new ButtonGroup();
    private Border raisedBevConvertFrom = BorderFactory.createRaisedBevelBorder();
    private TitledBorder titledConvertFrom = BorderFactory.createTitledBorder(raisedBevConvertFrom, "Convert From");   
      
    
    public UnitsPanel(){
        setLayout(new GridLayout(8,1));
        
        titledConvertFrom.setTitleJustification(TitledBorder.LEFT);
        
        unitsConvertFrom.add(mmRButton);
        unitsConvertFrom.add(cmRButton);
        unitsConvertFrom.add(mRButton);
        unitsConvertFrom.add(kmRButton);
        unitsConvertFrom.add(inRButton);
        unitsConvertFrom.add(ftRButton);
        unitsConvertFrom.add(ydRButton);
        unitsConvertFrom.add(miRButton);
        
        setBorder(titledConvertFrom);
        
        add(mmRButton);
        add(cmRButton);
        add(mRButton);
        add(kmRButton);
        add(inRButton);
        add(ftRButton);
        add(ydRButton);
        add(miRButton);      
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }                  
}
