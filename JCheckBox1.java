import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JCheckBox1 implements ItemListener {
  JCheckBox check;
  
  public static void main (String [] args) {
  JCheckBox1 gui=new JCheckBox1();
  gui.go();
  }//close main()
  
  public void go() {
    JFrame frame=new JFrame();
    JPanel panel=new JPanel();
    check=new JCheckBox("Test for CheckBox");
    check.addItemListener(this);
    panel.add(check);
    frame.getContentPane().add(BorderLayout.CENTER,panel);
    frame.setSize(350,300);
    frame.setVisible(true);
  }//close method
  
  public void itemStateChanged(ItemEvent ev) {
    String onOrOff="off";
    if (check.isSelected())  onOrOff="on";
    System.out.println("CheckBox is "+onOrOff);
    }//close method
  }//close 
