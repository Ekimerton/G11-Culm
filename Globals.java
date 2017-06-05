public class Globals {
    
    public static final int NET_OK = 0;
    public static final int NET_SEND_ERROR = -1;
    public static final int NET_RECIEVE_ERROR = -2;
    public static final int PORT_NUMBER = 5000;
    public static final int TIME_OUT= 10000; //in milliseconds
    public static final int QUEUE_SIZE = 100;
    public static final int MAX_CLIENT_MESSAGES = 500;
    public static final String SERVER_IP_ADDRESS = "10.104.85.61";
    
    public static final int SENDER_LEN = 9;
    public static final int RECEIVER_LEN = 9;
    public static final int DATE_TIME_LEN = 8;
    public static final int LENGTH_OF_INT = 4;
    
    public static final int SENDER_ID = 0;
    public static final int RECEIVER_ID = 1;
    
    public static final char SEND_MESSAGE = 'S';
    public static final char IN_BOX = 'I';
    public static final char OUT_BOX = 'O';
    
    public static final String STR_NULL = "";
    public static final char FIRST_RECORD_OF_MESSAGE = '+';
    public static final char END_OF_SUBJECT_MARKER = '~';
    public static final String EMPTY_CLIENT_MESSAGE = "";
    public static final int END_OF_MESSAGE_TRANSMISSION = -2;
    public static final int END_OF_MESSAGE = -1;
    
    
    public static String[]boxMessages = new String[MAX_CLIENT_MESSAGES];
    
    
}
