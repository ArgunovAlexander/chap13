import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JList1 implements ListSelectionListener {

  JList list;
  
  public static void main (String [] args) {
    JList1 gui=new JList1();
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
}//close go()
  
public void itemStateChange(ItemEvent ev) {
  String onOrOff="off";
  if (check.isSelected()) onOrOff="on";
  System.out.println("CheckBox is "+onOrOff);
}
}//close CheckBox1

