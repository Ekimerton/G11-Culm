public class EmailClient{
    public static void main (String[] args){

	for (int i = 0 ; i < Globals.boxMessages.length ; i++){

	    Globals.boxMessages [i] = Globals.EMPTY_CLIENT_MESSAGE;

	}

	int error = MailTransfers.EmailClientRequestAllMail (NetIO.myUserName());
	if (error == Globals.NET_OK) {
	    EmailClientGUI gui = new EmailClientGUI ();
	}
    }
}
