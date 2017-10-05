import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;

public clacc BeatBox {
    JPanel mainPanel;
    ArrayList<JCheckBox> checkboxList;  //store the checkboxes in an ArrayList
    Sequencer sequenser;
    Sequence sequence;
    Track track;
    JFrame theFrame;
    
    String[] instrumentNames={"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat"?
        "Acoustic Snare", "Crash Cymbal", "Hand Clap", "High Tom", 
        "Hi Bongo", "Maracas", "Wistle", "Low Conga", "Cowbell", 
        "Vibraslap", "Low-mid Tom", "High Agogo", "Open Hi Conga"};
    int[] instruments={35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};

    public static void main (String[] args) {
        new BeatBox2().buildGUI();
    }
    
    public void buildGUI() {
        theFrame=new JFrame("Cyber BeatBox");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout=new BorderLayout();
        JPanel background=new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10)); 
        // gives us a margin between the edges of the panel and where the components are placed
        
        checkboxList=new ArrayList<JCheckBox>();
        Box buttonBox=new Box(BoxLayout.Y_AXIS);
        
        JButton start=new JButton("Start");
        start.addActionListener(new MyStartListener());
        buttonBox.add(start);
        
        JButton stop=new JButton("Stop");        
        stop.addActionListener(new MyStopListener());        
        buttonBox.add(stop);
        
        JButton upTempo=new JButton("Tempo Up");
        upTempo.addActionListener(new MyUpTempoListener());                
        buttonBox.add(upTempo);
        
        JButton downTempo=new JButton("Tempo Down");
        downTempo.addActionListener(new MyDownTempoListener());
        buttonBox.add(downTempo);
        
        Box nameBox=new Box(BoxLayout.Y_AXIS);
        for (int i=0;i<16;i++) {
            nameBox.add(new Label(instrumentNames[i]));
        }
        
        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);
        
        theFrame.getContentPane().add(background);
        
        GridLayout grid=new GridLayout(16,16);
        grid.setVgap(1);
        grid.setHgap(2); //or you may use the constructor GridLayout(16,16,1,1)
        mainPanel=new JPanel(grid)
        background.add(BorderLayout.CENTER, mainPanel);
        
        for (int i=0;i<256;i++) {
            JCheckBox c=new JCheckBox();
            c.setSelected(false);
            checboxList.add(c);
            mainPanel.add(c);
        }//end loop
        
        setUpMidi();
        
        theFrame.setBounds(50,50,300,300);
        theFrame.pack();
        theFrame.setVisible(true);
        }//close method
    
    public void setUpMidi() {
      try {
        sequencer=MidiSystem.getSequencer();
        sequencer.open();
        sequence=new Sequence(Sequence.PPQ,4);
        track=sequence.createTrack();
        sequencer.setTempoInBPM(120);
        
      } catch (Exception e) {e.printStackTrace();}
    }//close method
}