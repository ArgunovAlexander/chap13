import javax.swing.*;
import java.awt.*;

public class chap13_1 {

  JTextField field;
  JLabel label;

  public static void main (String [] args) {
    chap13_1 gui=new chap13_1();
    gui.go();
    gui.tryMethod();
  }//close main()

  public void go() {
    JFrame frame=new JFrame();
    JPanel panel=new JPanel();
    field=new JTextField("Your name");
    label=new JLabel("Dog's first name");

    panel.add(label);
    panel.add(field);
    panel.setBackground(Color.lightGray);

    frame.getContentPane().add(BorderLayout.WEST,panel);

    frame.setSize(350,100);
    frame.setVisible(true);

  }//close go()

    public void tryMethod() {
        System.out.println(field.getText());//trying getText()
        field.setText("whatever");//trying setText()
        System.out.println(field.getText());//trying getText()
        field.selectAll();
        field.requestFocus();
    }

}//close class
