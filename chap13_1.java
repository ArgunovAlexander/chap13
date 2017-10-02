import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextArea1 implements ActionListener {

  JTextArea text;
  
  public static void main (String [] args) {
    TextArea1 gui=new TextArea1();
    gui.go();
  }//close main()

  public void go() {
  JFrame frame=new JFrame();
  JPanel panel=new JPanel();
  JButton button=new JButton("Just click it");
  button.addActionListener(this);
  text=new JTextArea(10,20);
  text.setLineWrap(true);
  
  JScrollPane scroller=new JScrollPane(text);
  scroller.setVerticalScrollBarPolicy(ScrollPaneConsists.VERTICAL_SCROLLBAR_ALWAYS);
  scroller.setHorizontalScrollBarPolicy(ScrollPaneConsists.HORIZONTAL_SCROLLBAR_NEVER);
  
  panel.add(scroller);
   
  frame.getContentPane().add(BorderLayout.CENTER,panel);
  frame.getContentPane().add(BorderLayout.SOUTH,button);
  
  frame.setSize(350,300);
  frame.setVisible(true);
}//close go()
  
public void actionPerformed(ActionEvent ev) {
  text.append("button clicked \n ");
}
}//close TextArea1

