import javax.swing.*;       // graphics package for some of the objects
import java.awt.*;          // another graphics package
import java.awt.event.*;    // for clicks and keyboard

public class EmailClientComposeMessage implements ActionListener
{

    private JFrame frame = null;

    private JPanel panel1 = null;
    private JPanel panel2 = null;
    private JPanel panel3 = null;

    //Panel 1 Initialization
    private JLabel recieverLabel = null;
    private JTextField reciever = null;
    private JLabel subjectLabel = null;
    private JTextField subject = null;

    //Panel 2 Initialization
    private JTextArea messageText = null;
    private JScrollPane scroll = null;

    //Panel 3 Initialization
    private JButton send = null;
    private JButton cancel = null;

    //Frame Settings
    public EmailClientComposeMessage ()
    {

	frame = new JFrame ("Compose Message - ICS3U TOPS Afternoon");
	frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	frame.setLocation (180, 160);
	frame.setResizable (false);

	//Container Set-up
	Container contentPane = frame.getContentPane ();
	BoxLayout contentPaneLayout = new BoxLayout (contentPane, BoxLayout.Y_AXIS);
	contentPane.setLayout (contentPaneLayout);

	panel1 = new JPanel ();
	panel2 = new JPanel ();
	panel3 = new JPanel ();

	contentPane.add (panel1);
	contentPane.add (panel2);
	contentPane.add (panel3);

	//First Panel Set-up
	FlowLayout panel1Layout = new FlowLayout (FlowLayout.CENTER);
	panel1.setLayout (panel1Layout);

	recieverLabel = new JLabel ("To:");
	panel1.add (recieverLabel);
	reciever = new JTextField (9);
	panel1.add (reciever);
	reciever.setFont (new Font ("Arial", Font.PLAIN, 14));

	subjectLabel = new JLabel ("Subject:");
	panel1.add (subjectLabel);
	subject = new JTextField (51);
	panel1.add (subject);

	//Second Panel Set-up
	FlowLayout panel2Layout = new FlowLayout (FlowLayout.CENTER);
	panel2.setLayout (panel2Layout);

	messageText = new JTextArea (10, 69);
	scroll = new JScrollPane (messageText);
	panel2.add (scroll);
	messageText.setLineWrap (true);
	messageText.setWrapStyleWord (true);
	messageText.setBorder (BorderFactory.createLineBorder (Color.pink));

	//Third Panel Set-up
	FlowLayout panel3Layout = new FlowLayout (FlowLayout.CENTER);
	panel2.setLayout (panel2Layout);

	send = new JButton ("Send");
	cancel = new JButton ("Cancel");

	panel3.add (send);
	panel3.add (cancel);

	send.addActionListener (this);
	cancel.addActionListener (this);

	//Make the Window visible
	frame.pack ();
	frame.setVisible (true);

    }


    //Button Action
    public void actionPerformed (ActionEvent event)
    {

	Object buttonPressed = event.getSource ();

	if (buttonPressed == send)
	{

	    String senderId = NetIO.myUserName ();

	    senderId = Utils.leftPad (senderId, Globals.SENDER_LEN, '0');

	    if (senderId.length () == Globals.SENDER_LEN && Utils.isANumber (senderId))
	    {

		String receiverId = reciever.getText().toLowerCase();
		if (receiverId.length () != 0)
		{

		    if (receiverId.length () <= Globals.RECEIVER_LEN)
		    {
			receiverId = Utils.leftPad (receiverId, Globals.RECEIVER_LEN, '0');

			String entireMessage = Globals.SEND_MESSAGE + senderId +
			    receiverId +
			    Utils.leftPad (Globals.STR_NULL, Globals.DATE_TIME_LEN, '0') +
			    Globals.FIRST_RECORD_OF_MESSAGE +
			    subject.getText () +
			    Globals.END_OF_SUBJECT_MARKER +
			    messageText.getText ();

			int errorCode = NetIO.sendRequest (entireMessage, Globals.SERVER_IP_ADDRESS);
			if (errorCode == Globals.NET_OK)
			{
			    frame.dispose ();
			}
			else
			{
			    JOptionPane.showMessageDialog (null,
				    "Message not sent",
				    "ICS3U3 Error information box",
				    JOptionPane.ERROR_MESSAGE);
			}



		    }
		    else
		    {
			JOptionPane.showMessageDialog (null,
				"A receiver ID must be 9 characters or less",
				"ICS3U3 Error information box",
				JOptionPane.ERROR_MESSAGE);
		    }
		}
		else
		{
		    JOptionPane.showMessageDialog (null,
			    "A receiver ID must be specified",
			    "ICS3U3 Error information box",
			    JOptionPane.ERROR_MESSAGE);

		}
	    }
	    else
	    {
		JOptionPane.showMessageDialog (null,
			"Sender identification must be a 9-digit number",
			"ICS3U3 Error information box",
			JOptionPane.ERROR_MESSAGE);

	    }
	}
	else if (buttonPressed == cancel)
	{
	    frame.dispose ();
	}

    }


    public static void main (String[] args)
    {

	EmailClientComposeMessage e = new EmailClientComposeMessage ();

    }
}

