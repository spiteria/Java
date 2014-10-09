/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forceonanobjectatdepth;
import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.awt.event.*;

/**
 *
 * @author AndrewSpiteri
 */
public class ForceOnAnObjectAtDepth extends JFrame{

    /**
     * @param args the command line arguments
     */
    private final int WINDOW_WIDTH  = 500;
    private final int WINDOW_HEIGHT = 420;    
    
    private final double MM2CM_CONVERSION = .1;
    private final double MM2M_CONVERSION  = .001;
    private final double MM2KM_CONVERSION = .000001;
    private final double CM2MM_CONVERSION = 10;
    private final double CM2M_CONVERSION  = .01;
    private final double CM2KM_CONVERSION = .00001;
    private final double M2MM_CONVERSION  = 1000;
    private final double M2CM_CONVERSION  = 100;
    private final double M2KM_CONVERSION  = 1000;
    private final double KM2MM_CONVERSION = 1000000;
    private final double KM2CM_CONVERSION = 100000;
    private final double KM2M_CONVERSION  = 1000;
    private final double IN2FT_CONVERSION = .08333;
    private final double IN2YD_CONVERSION = .02777;
    private final double IN2MI_CONVERSION = .00001578;
    private final double FT2IN_CONVERSION = 12;
    private final double FT2YD_CONVERSION = .33333;
    private final double FT2MI_CONVERSION = .00018939;
    private final double YD2IN_CONVERSION = 36;
    private final double YD2FT_CONVERSION = 3;
    private final double YD2MI_CONVERSION = .00056818;
    private final double MI2IN_CONVERSION = 63360;
    private final double MI2FT_CONVERSION = 5280;
    private final double MI2YD_CONVERSION = 1760;
    
    private JButton conversionButton               = new JButton("Convert");
    private JButton volumeButton                   = new JButton ("Volume");
    private JPanel buttonPanel                     = new JPanel();
    private JPanel overarchingPanel                = new JPanel();
    private UnitsPanel unitsEntered                = new UnitsPanel();
    private UnitsConvertedToPanel unitsConvertedTo = new UnitsConvertedToPanel();
    private EntryFormFields entryforms             = new EntryFormFields();
    private GroupLayout forceFrameLayout           = new GroupLayout(overarchingPanel);
    
    public ForceOnAnObjectAtDepth(){
        setTitle("Force Calculator");
        
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        overarchingPanel.setLayout(forceFrameLayout);
    
        buildButtonPanel();
        
        forceFrameLayout.setVerticalGroup(
            forceFrameLayout.createSequentialGroup()
                .addComponent(entryforms)
                .addGroup(forceFrameLayout.createParallelGroup()
                    .addComponent(unitsEntered)
                    .addComponent(unitsConvertedTo))
                .addComponent(buttonPanel)
        );
        
        forceFrameLayout.setHorizontalGroup(
            forceFrameLayout.createParallelGroup()
                .addComponent(entryforms)
                .addGroup(forceFrameLayout.createSequentialGroup()
                    .addComponent(unitsEntered)
                    .addComponent(unitsConvertedTo))
                .addComponent(buttonPanel));
        
        add(overarchingPanel);
        
        setVisible(true);
    }
    
    private void buildButtonPanel(){
        conversionButton.addActionListener(new ConversionListener());
        volumeButton.addActionListener(new VolumeListener());
    
        buttonPanel.add(conversionButton);
        buttonPanel.add(volumeButton);  
    }
    
    private class ConversionListener /*extends UnitsPanel*/ implements ActionListener{
        //mmRButton.addItemListener();
        
        //private class RButton Listener implements ItemSelectable{
        
        public void actionPerformed(ActionEvent e){
            DecimalFormat uF = new DecimalFormat(".###");
            DecimalFormat longF = new DecimalFormat(".#########");
            String convert1 = e.getActionCommand();
            String depthInput, widthInput, lengthInput, thickInput;
            depthInput = entryforms.depthText.getText();
            widthInput = entryforms.widthText.getText();
            lengthInput = entryforms.lengthText.getText();
            thickInput = entryforms.thickText.getText();
            double depth, width, length, thick;            
            
            if(unitsEntered.mmRButton.isSelected() && unitsConvertedTo.mmRButton2.isSelected()){
                JOptionPane.showMessageDialog(null, "Why do you want to convert" 
                    + " millimeters to millimeters?", "Millimeters to Millimeters", JOptionPane.QUESTION_MESSAGE);
            }            
            else if(unitsEntered.mmRButton.isSelected() && unitsConvertedTo.cmRButton2.isSelected()){
                depth = Double.parseDouble(depthInput) * MM2CM_CONVERSION;
                width = Double.parseDouble(widthInput) * MM2CM_CONVERSION;
                length = Double.parseDouble(lengthInput) * MM2CM_CONVERSION;
                thick = Double.parseDouble(thickInput) * MM2CM_CONVERSION;
                JOptionPane.showMessageDialog(null, "Depth is: " + uF.format(depth) + 
                        "cm.  Width is: " + uF.format(width) + "cm.  Length is: "
                        + uF.format(length) + "cm.  Thickness is: " + uF.format(thick)
                        + " cm.", "Millimeters to Centimeters", JOptionPane.PLAIN_MESSAGE);
            }
            else if(unitsEntered.mmRButton.isSelected() && unitsConvertedTo.mRButton2.isSelected()){
                depth = Double.parseDouble(depthInput) * MM2M_CONVERSION;
                width = Double.parseDouble(widthInput) * MM2M_CONVERSION;
                length = Double.parseDouble(lengthInput) * MM2M_CONVERSION;
                thick = Double.parseDouble(thickInput) * MM2M_CONVERSION;
                JOptionPane.showMessageDialog(null, "Depth is: " + uF.format(depth) + 
                        " m.  Width is: " + uF.format(width) + " m.  Length is: "
                        + uF.format(length) + " m.  Thickness is: " + uF.format(thick)
                        + " m.", "Millimeters to Meters", JOptionPane.PLAIN_MESSAGE);
            }
            else if(unitsEntered.mmRButton.isSelected() && unitsConvertedTo.kmRButton2.isSelected()){
                depth = Double.parseDouble(depthInput) * MM2KM_CONVERSION;
                width = Double.parseDouble(widthInput) * MM2KM_CONVERSION;
                length = Double.parseDouble(lengthInput) * MM2KM_CONVERSION;
                thick = Double.parseDouble(thickInput) * MM2KM_CONVERSION;
                JOptionPane.showMessageDialog(null, "Depth is: " + longF.format(depth) + 
                        " km.  Width is: " + longF.format(width) + " km.  Length is: "
                        + longF.format(length) + " km.  Thickness is: " + longF.format(thick)
                        + " km.", "Millimeters to Kilometers", JOptionPane.PLAIN_MESSAGE);
            }
            else if(unitsEntered.cmRButton.isSelected() && unitsConvertedTo.mmRButton2.isSelected()){
                depth = Double.parseDouble(depthInput) * CM2MM_CONVERSION;
                width = Double.parseDouble(widthInput) * CM2MM_CONVERSION;
                length = Double.parseDouble(lengthInput) * CM2MM_CONVERSION;
                thick = Double.parseDouble(thickInput) * CM2MM_CONVERSION;
                JOptionPane.showMessageDialog(null, "Depth is: " + uF.format(depth) + 
                        " mm.  Width is: " + uF.format(width) + " mm.  Length is: "
                        + uF.format(length) + " mm.  Thickness is: " + uF.format(thick)
                        + " mm.", "Centimeters to Millimeters", JOptionPane.PLAIN_MESSAGE);
            }
            else if(unitsEntered.cmRButton.isSelected() && unitsConvertedTo.cmRButton2.isSelected()){
                JOptionPane.showMessageDialog(null, "Why do you want to convert" 
                    + " centimeters to centimeters?", "Centimeters to Centimeters", JOptionPane.QUESTION_MESSAGE);
            }
            else if(unitsEntered.cmRButton.isSelected() && unitsConvertedTo.mRButton2.isSelected()){
                depth = Double.parseDouble(depthInput) * CM2M_CONVERSION;
                width = Double.parseDouble(widthInput) * CM2M_CONVERSION;
                length = Double.parseDouble(lengthInput) * CM2M_CONVERSION;
                thick = Double.parseDouble(thickInput) * CM2M_CONVERSION;
                JOptionPane.showMessageDialog(null, "Depth is: " + uF.format(depth) + 
                        " m.  Width is: " + uF.format(width) + " m.  Length is: "
                        + uF.format(length) + " m.  Thickness is: " + uF.format(thick)
                        + " m.", "Centimeters to Meters", JOptionPane.PLAIN_MESSAGE);
            }
            else if(unitsEntered.cmRButton.isSelected() && unitsConvertedTo.kmRButton2.isSelected()){
                depth = Double.parseDouble(depthInput) * CM2KM_CONVERSION;
                width = Double.parseDouble(widthInput) * CM2KM_CONVERSION;
                length = Double.parseDouble(lengthInput) * CM2KM_CONVERSION;
                thick = Double.parseDouble(thickInput) * CM2KM_CONVERSION;
                JOptionPane.showMessageDialog(null, "Depth is: " + longF.format(depth) + 
                        " km.  Width is: " + longF.format(width) + " km.  Length is: "
                        + longF.format(length) + " km.  Thickness is: " + longF.format(thick)
                        + " km.", "Centimeters to Kilometers", JOptionPane.PLAIN_MESSAGE);
            }
            else if(unitsEntered.mRButton.isSelected() && unitsConvertedTo.mmRButton2.isSelected()){
                depth = Double.parseDouble(depthInput) * M2MM_CONVERSION;
                width = Double.parseDouble(widthInput) * M2MM_CONVERSION;
                length = Double.parseDouble(lengthInput) * M2MM_CONVERSION;
                thick = Double.parseDouble(thickInput) * M2MM_CONVERSION;
                JOptionPane.showMessageDialog(null, "Depth is: " + uF.format(depth) + 
                        " mm.  Width is: " + uF.format(width) + " mm.  Length is: "
                        + uF.format(length) + " mm.  Thickness is: " + uF.format(thick)
                        + " mm.", "Meters to Millimeters", JOptionPane.PLAIN_MESSAGE);
            }
            else if(unitsEntered.mRButton.isSelected() && unitsConvertedTo.cmRButton2.isSelected()){
                depth = Double.parseDouble(depthInput) * M2CM_CONVERSION;
                width = Double.parseDouble(widthInput) * M2CM_CONVERSION;
                length = Double.parseDouble(lengthInput) * M2CM_CONVERSION;
                thick = Double.parseDouble(thickInput) * M2CM_CONVERSION;
                JOptionPane.showMessageDialog(null, "Depth is: " + uF.format(depth) + 
                        " cm.  Width is: " + uF.format(width) + " cm.  Length is: "
                        + uF.format(length) + " cm.  Thickness is: " + uF.format(thick)
                        + " cm.", "Meters to Centimeters", JOptionPane.PLAIN_MESSAGE);
            }
            else if(unitsEntered.mRButton.isSelected() && unitsConvertedTo.mRButton2.isSelected()){
                JOptionPane.showMessageDialog(null, "Why do you want to convert" 
                    + " meters to meters?", "Meters to Meters", JOptionPane.QUESTION_MESSAGE);
            }
            else if(unitsEntered.mRButton.isSelected() && unitsConvertedTo.kmRButton2.isSelected()){
                depth = Double.parseDouble(depthInput) * M2KM_CONVERSION;
                width = Double.parseDouble(widthInput) * M2KM_CONVERSION;
                length = Double.parseDouble(lengthInput) * M2KM_CONVERSION;
                thick = Double.parseDouble(thickInput) * M2KM_CONVERSION;
                JOptionPane.showMessageDialog(null, "Depth is: " + uF.format(depth) + 
                        " km.  Width is: " + uF.format(width) + " km.  Length is: "
                        + uF.format(length) + " km.  Thickness is: " + uF.format(thick)
                        + " km.", "Meters to Kilometers", JOptionPane.PLAIN_MESSAGE);
            }
            else if(unitsEntered.kmRButton.isSelected() && unitsConvertedTo.mmRButton2.isSelected()){
                depth = Double.parseDouble(depthInput) * KM2MM_CONVERSION;
                width = Double.parseDouble(widthInput) * KM2MM_CONVERSION;
                length = Double.parseDouble(lengthInput) * KM2MM_CONVERSION;
                thick = Double.parseDouble(thickInput) * KM2MM_CONVERSION;
                JOptionPane.showMessageDialog(null, "Depth is: " + uF.format(depth) + 
                        " mm.  Width is: " + uF.format(width) + " mm.  Length is: "
                        + uF.format(length) + " mm.  Thickness is: " + uF.format(thick)
                        + " mm.", "Kilometers to Millimeters", JOptionPane.PLAIN_MESSAGE);
            }
            else if(unitsEntered.kmRButton.isSelected() && unitsConvertedTo.cmRButton2.isSelected()){
                depth = Double.parseDouble(depthInput) * KM2CM_CONVERSION;
                width = Double.parseDouble(widthInput) * KM2CM_CONVERSION;
                length = Double.parseDouble(lengthInput) * KM2CM_CONVERSION;
                thick = Double.parseDouble(thickInput) * KM2CM_CONVERSION;
                JOptionPane.showMessageDialog(null, "Depth is: " + uF.format(depth) + 
                        " cm.  Width is: " + uF.format(width) + " cm.  Length is: "
                        + uF.format(length) + " cm.  Thickness is: " + uF.format(thick)
                        + " cm.", "Kilometers to Centimeters", JOptionPane.PLAIN_MESSAGE);
            }
            else if(unitsEntered.kmRButton.isSelected() && unitsConvertedTo.mRButton2.isSelected()){
                depth = Double.parseDouble(depthInput) * KM2M_CONVERSION;
                width = Double.parseDouble(widthInput) * KM2M_CONVERSION;
                length = Double.parseDouble(lengthInput) * KM2M_CONVERSION;
                thick = Double.parseDouble(thickInput) * KM2M_CONVERSION;
                JOptionPane.showMessageDialog(null, "Depth is: " + uF.format(depth) + 
                        " m.  Width is: " + uF.format(width) + " m.  Length is: "
                        + uF.format(length) + " m.  Thickness is: " + uF.format(thick)
                        + " m.", "Kilometers to Meters", JOptionPane.PLAIN_MESSAGE);
            }
            else if(unitsEntered.kmRButton.isSelected() && unitsConvertedTo.kmRButton2.isSelected()){
                JOptionPane.showMessageDialog(null, "Why do you want to convert" 
                    + " kilometers to kilometers?", "Kilometers to Kilometers", JOptionPane.QUESTION_MESSAGE);
            }
            else if(unitsEntered.inRButton.isSelected() && unitsConvertedTo.inRButton2.isSelected()){
                JOptionPane.showMessageDialog(null, "Why do you want to convert"
                        + " inches to inches?", "Inches to Inches", JOptionPane.QUESTION_MESSAGE);
            }
            else if(unitsEntered.inRButton.isSelected() && unitsConvertedTo.ftRButton2.isSelected()){
                depth = Double.parseDouble(depthInput) * IN2FT_CONVERSION;
                width = Double.parseDouble(widthInput) * IN2FT_CONVERSION;
                length = Double.parseDouble(lengthInput) * IN2FT_CONVERSION;
                thick = Double.parseDouble(thickInput) * IN2FT_CONVERSION;
                JOptionPane.showMessageDialog(null, "Depth is: " + longF.format(depth) + 
                        " ft.  Width is: " + longF.format(width) + " ft.  Length is: "
                        + longF.format(length) + " ft.  Thickness is: " + longF.format(thick)
                        + " ft.", "Inches to Feet", JOptionPane.PLAIN_MESSAGE);
            }
            else if(unitsEntered.inRButton.isSelected() && unitsConvertedTo.ydRButton2.isSelected()){
                depth = Double.parseDouble(depthInput) * IN2YD_CONVERSION;
                width = Double.parseDouble(widthInput) * IN2YD_CONVERSION;
                length = Double.parseDouble(lengthInput) * IN2YD_CONVERSION;
                thick = Double.parseDouble(thickInput) * IN2YD_CONVERSION;
                JOptionPane.showMessageDialog(null, "Depth is: " + longF.format(depth) + 
                        " yd.  Width is: " + longF.format(width) + " yd.  Length is: "
                        + longF.format(length) + " yd.  Thickness is: " + longF.format(thick)
                        + " yd.", "Inches to Yards", JOptionPane.PLAIN_MESSAGE);
            }
            else if(unitsEntered.inRButton.isSelected() && unitsConvertedTo.miRButton2.isSelected()){
                depth = Double.parseDouble(depthInput) * IN2MI_CONVERSION;
                width = Double.parseDouble(widthInput) * IN2MI_CONVERSION;
                length = Double.parseDouble(lengthInput) * IN2MI_CONVERSION;
                thick = Double.parseDouble(thickInput) * IN2MI_CONVERSION;
                JOptionPane.showMessageDialog(null, "Depth is: " + longF.format(depth) + 
                        " mi.  Width is: " + longF.format(width) + " mi.  Length is: "
                        + longF.format(length) + " mi.  Thickness is: " + longF.format(thick)
                        + " mi.", "Inches to Miles", JOptionPane.PLAIN_MESSAGE);
            }
            else if(unitsEntered.ftRButton.isSelected() && unitsConvertedTo.inRButton2.isSelected()){
                depth = Double.parseDouble(depthInput) * FT2IN_CONVERSION;
                width = Double.parseDouble(widthInput) * FT2IN_CONVERSION;
                length = Double.parseDouble(lengthInput) * FT2IN_CONVERSION;
                thick = Double.parseDouble(thickInput) * FT2IN_CONVERSION;
                JOptionPane.showMessageDialog(null, "Depth is: " + uF.format(depth) + 
                        " in.  Width is: " + uF.format(width) + " in.  Length is: "
                        + uF.format(length) + " in.  Thickness is: " + uF.format(thick)
                        + " in.", "Feet to Inches", JOptionPane.PLAIN_MESSAGE);
            }
            else if(unitsEntered.ftRButton.isSelected() && unitsConvertedTo.ftRButton2.isSelected()){
                JOptionPane.showMessageDialog(null, "Why do you want to convert" 
                    + " feet to feet?", "Feet to Feet", JOptionPane.QUESTION_MESSAGE);
            }
            else if(unitsEntered.ftRButton.isSelected() && unitsConvertedTo.ydRButton2.isSelected()){
                depth = Double.parseDouble(depthInput) * FT2YD_CONVERSION;
                width = Double.parseDouble(widthInput) * FT2YD_CONVERSION;
                length = Double.parseDouble(lengthInput) * FT2YD_CONVERSION;
                thick = Double.parseDouble(thickInput) * FT2YD_CONVERSION;
                JOptionPane.showMessageDialog(null, "Depth is: " + longF.format(depth) + 
                        " yd.  Width is: " + longF.format(width) + " yd.  Length is: "
                        + longF.format(length) + " yd.  Thickness is: " + longF.format(thick)
                        + " yd.", "Feet to Yards", JOptionPane.PLAIN_MESSAGE);
            }
            else if(unitsEntered.ftRButton.isSelected() && unitsConvertedTo.miRButton2.isSelected()){
                depth = Double.parseDouble(depthInput) * FT2MI_CONVERSION;
                width = Double.parseDouble(widthInput) * FT2MI_CONVERSION;
                length = Double.parseDouble(lengthInput) * FT2MI_CONVERSION;
                thick = Double.parseDouble(thickInput) * FT2MI_CONVERSION;
                JOptionPane.showMessageDialog(null, "Depth is: " + longF.format(depth) + 
                        " mi.  Width is: " + longF.format(width) + " mi.  Length is: "
                        + longF.format(length) + " mi.  Thickness is: " + longF.format(thick)
                        + " mi.", "Feet to Miles", JOptionPane.PLAIN_MESSAGE);
            }
            else if(unitsEntered.ydRButton.isSelected() && unitsConvertedTo.inRButton2.isSelected()){
                depth = Double.parseDouble(depthInput) * YD2IN_CONVERSION;
                width = Double.parseDouble(widthInput) * YD2IN_CONVERSION;
                length = Double.parseDouble(lengthInput) * YD2IN_CONVERSION;
                thick = Double.parseDouble(thickInput) * YD2IN_CONVERSION;
                JOptionPane.showMessageDialog(null, "Depth is: " + uF.format(depth) + 
                        " in.  Width is: " + uF.format(width) + " in.  Length is: "
                        + uF.format(length) + " in.  Thickness is: " + uF.format(thick)
                        + " in.", "Yards to Inches", JOptionPane.PLAIN_MESSAGE);
            }
            else if(unitsEntered.ydRButton.isSelected() && unitsConvertedTo.ftRButton2.isSelected()){
                depth = Double.parseDouble(depthInput) * YD2FT_CONVERSION;
                width = Double.parseDouble(widthInput) * YD2FT_CONVERSION;
                length = Double.parseDouble(lengthInput) * YD2FT_CONVERSION;
                thick = Double.parseDouble(thickInput) * YD2FT_CONVERSION;
                JOptionPane.showMessageDialog(null, "Depth is: " + uF.format(depth) + 
                        " ft.  Width is: " + uF.format(width) + " ft.  Length is: "
                        + uF.format(length) + " ft.  Thickness is: " + uF.format(thick)
                        + " ft.", "Yards to Feet", JOptionPane.PLAIN_MESSAGE);
            }
            else if(unitsEntered.ydRButton.isSelected() && unitsConvertedTo.ydRButton2.isSelected()){
                JOptionPane.showMessageDialog(null, "Why do you want to convert" 
                    + " yards to yards?", "Yards to Yards", JOptionPane.QUESTION_MESSAGE);
            }
            else if(unitsEntered.ydRButton.isSelected() && unitsConvertedTo.miRButton2.isSelected()){
                depth = Double.parseDouble(depthInput) * YD2MI_CONVERSION;
                width = Double.parseDouble(widthInput) * YD2MI_CONVERSION;
                length = Double.parseDouble(lengthInput) * YD2MI_CONVERSION;
                thick = Double.parseDouble(thickInput) * YD2MI_CONVERSION;
                JOptionPane.showMessageDialog(null, "Depth is: " + longF.format(depth) + 
                        " mi.  Width is: " + longF.format(width) + " mi.  Length is: "
                        + longF.format(length) + " mi.  Thickness is: " + longF.format(thick)
                        + " mi.", "Yards to Miles", JOptionPane.PLAIN_MESSAGE);
            }
            else if(unitsEntered.miRButton.isSelected() && unitsConvertedTo.inRButton2.isSelected()){
                depth = Double.parseDouble(depthInput) * MI2IN_CONVERSION;
                width = Double.parseDouble(widthInput) * MI2IN_CONVERSION;
                length = Double.parseDouble(lengthInput) * MI2IN_CONVERSION;
                thick = Double.parseDouble(thickInput) * MI2IN_CONVERSION;
                JOptionPane.showMessageDialog(null, "Depth is: " + uF.format(depth) + 
                        " in.  Width is: " + uF.format(width) + " in.  Length is: "
                        + uF.format(length) + " in.  Thickness is: " + uF.format(thick)
                        + " in.", "Miles to Inches", JOptionPane.PLAIN_MESSAGE);
            }
            else if(unitsEntered.miRButton.isSelected() && unitsConvertedTo.ftRButton2.isSelected()){
                depth = Double.parseDouble(depthInput) * MI2FT_CONVERSION;
                width = Double.parseDouble(widthInput) * MI2FT_CONVERSION;
                length = Double.parseDouble(lengthInput) * MI2FT_CONVERSION;
                thick = Double.parseDouble(thickInput) * MI2FT_CONVERSION;
                JOptionPane.showMessageDialog(null, "Depth is: " + uF.format(depth) + 
                        " ft.  Width is: " + uF.format(width) + " ft.  Length is: "
                        + uF.format(length) + " ft.  Thickness is: " + uF.format(thick)
                        + " ft.", "Miles to Feet", JOptionPane.PLAIN_MESSAGE);
            }
            else if(unitsEntered.miRButton.isSelected() && unitsConvertedTo.ydRButton2.isSelected()){
                depth = Double.parseDouble(depthInput) * MI2YD_CONVERSION;
                width = Double.parseDouble(widthInput) * MI2YD_CONVERSION;
                length = Double.parseDouble(lengthInput) * MI2YD_CONVERSION;
                thick = Double.parseDouble(thickInput) * MI2YD_CONVERSION;
                JOptionPane.showMessageDialog(null, "Depth is: " + uF.format(depth) + 
                        " yd.  Width is: " + uF.format(width) + " yd.  Length is: "
                        + uF.format(length) + " yd.  Thickness is: " + uF.format(thick)
                        + " yd.", "Miles to Yards", JOptionPane.PLAIN_MESSAGE);
            }
            else if(unitsEntered.miRButton.isSelected() && unitsConvertedTo.miRButton2.isSelected()){
                JOptionPane.showMessageDialog(null, "Why do you want to convert" 
                    + " miles to miles?", "Miles to Miles", JOptionPane.QUESTION_MESSAGE);
            }            
        }    
    }
    
    private class VolumeListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        ForceOnAnObjectAtDepth force = new ForceOnAnObjectAtDepth();
    }
    
}
