import javax.swing.*;       // graphics package for some of the objects
import java.awt.*;          // another graphics package
import java.awt.event.*;    // for clicks and keyboard

public class EmailClientGUI implements ActionListener {
    
    private JFrame frame = null;
    
    private JPanel panel1 = null;
    private JPanel panel2 = null;
    private JPanel panel3 = null;
    
    private EmailClientPane emailClientPane = null;
    
    private JLabel label = null;
    
    private JButton compose = null;
    private JButton getmail = null;
    private JButton delete = null;
    private JButton inbox = null;
    private JButton outbox = null;
    
    public EmailClientGUI () {
    
    //Frame Set-up
    frame = new JFrame ("Compose Message - ICS3U TOPS Afternoon");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocation(100,50);
    frame.setResizable(false);
    
    //Container Set-up
    Container contentPane = frame.getContentPane();
    BoxLayout contentPaneLayout = new BoxLayout(contentPane, BoxLayout.Y_AXIS);
    contentPane.setLayout(contentPaneLayout);
	
    panel1 = new JPanel();
    panel2 = new JPanel();
    panel3 = new JPanel();
	
    contentPane.add(panel1);
    contentPane.add(panel2);
    contentPane.add(panel3);
    
    //Panel 1 Set-up
    FlowLayout panel1Layout = new FlowLayout(FlowLayout.LEFT);
    panel1.setLayout(panel1Layout);
	
    label = new JLabel(" From:               Date Received:                               Subject");
    panel1.add(label);

    //Panel 2 Set-up
    FlowLayout panel2Layout = new FlowLayout(FlowLayout.LEFT);
    panel2.setLayout(panel2Layout);
    
    emailClientPane = new EmailClientPane();
    panel2.add(emailClientPane.getSplitPane());
    
    //Panel 3 Set-up
    FlowLayout panel3Layout = new FlowLayout(FlowLayout.CENTER);
    panel3.setLayout(panel3Layout);
    
    compose = new JButton("Compose");
    getmail = new JButton("Get Mail");
    delete = new JButton("Delete");
    inbox = new JButton("InBox");
    outbox = new JButton("OutBox");
    
    panel3.add(compose);
    panel3.add(getmail);
    panel3.add(delete);
    panel3.add(inbox);
    panel3.add(outbox);
    
    compose.addActionListener(this);
    getmail.addActionListener(this);
    delete.addActionListener(this);
    inbox.addActionListener(this);
    outbox.addActionListener(this);
    
    //Make the Window visible
    frame.pack();
    frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event) {
    
    }
    
}
