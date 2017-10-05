import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JCheckBox1 implements ItemListener {
JList list;

	public static void main (String [] args) {
		JList1 gui=new JList1();
		gui.go();
	}//close main() 

    public void go() {    
	    JFrame frame=new JFrame();
	    JPanel panel=new JPanel();
	    String [] listEntries={"1111111111","222222222","33333333","4444444444",
	    "555555555","666666666","7777777777"};
	    list=new Jlist(listEntries);
	    list.setVisibleRowCount(4);	list.setSelectionMode(ListSelectionMode.SINGLE_SELECTION);
        list.addListSelectionListener(this);
    
        JScrollPane scroller=new JScrollPane(list);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    
        panel.add(scroller);
        frame.getContentPane().add(BorderLayout.CENTER,panel);
        frame.setSize(350,300);
        frame.setVisible(true);
    }//close method

    public void valueChanged(ListSelectionEvent lse) {
        
        if (!lse.getValueIsAdjusting()) {
            String selection=(String) list.getSelectedValue();
            System.out.println(selection);
        };
System.out.println("CheckBox is "+onOrOff);
	}//close method  
}//close class
