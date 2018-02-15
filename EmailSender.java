import java.io.*;
import java.net.*;
import java.util.Scanner;

public class EmailSender
{
   public static void main(String[] args) throws Exception
   {
      // Establish a TCP connection with the mail server.
      Scanner myKeyboard = new Scanner(System.in);
      String host1 = "smtp.comcast.net";  //for testing purposes
      String host2 = "mail.virginia.edu";
      String hostname = "";

      System.out.println("Select Host -- [1]:" + host1 + " [2]: " + host2);
      int hostSelect = myKeyboard.nextInt();
      int portNum = 0;
      
      if(hostSelect == 1){
         hostname = host1;
         portNum = 587;
      }else{
         hostname = host2;
         portNum = 25;
      }
      
      //Create Socket
      Socket socket;
      socket = new Socket(hostname, portNum);
      // Create a BufferedReader to read a line at a time.
      InputStream is = socket.getInputStream();
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);

      // Read greeting from the server.
      String response = br.readLine();
      System.out.println(response);

      if (!response.startsWith("220")) {
         throw new Exception("220 reply not received from server.");
      }

      // Get a reference to the socket's output stream.
      OutputStream os = socket.getOutputStream();

      // Send HELO command and get server response.
      String command = "HELO alice\r\n";
      System.out.println(command);
      os.write(command.getBytes("US-ASCII"));

      response = br.readLine();
      System.out.println(response);

      if (!response.startsWith("250")) {
         throw new Exception("250 reply not received from server.");
      }

      // Send MAIL FROM command.
      command = "MAIL FROM: <chd5hq@virginia.edu>\r\n";
      System.out.println(command);
      os.write(command.getBytes("US-ASCII"));

      response = br.readLine();
      System.out.println(response);

      if (!response.startsWith("250")) {
         throw new Exception("250 reply not received from server.");
      }

      // Send RCPT TO command.
      command = "RCPT TO: <chd5hq@virginia.edu>\r\n";
      System.out.println(command);
      os.write(command.getBytes("US-ASCII"));

      response = br.readLine();
      System.out.println(response);

      if (!response.startsWith("250")) {
         throw new Exception("250 reply not received from server.");
      }

      // Send DATA command.
      command = "DATA\r\n";
      System.out.println(command);
      os.write(command.getBytes("US-ASCII"));

      response = br.readLine();
      System.out.println(response);

      if (!response.startsWith("250")) {
         throw new Exception("250 reply not received from server.");
      }


      // Send message data.
      command = "SUBJECT: JAVA-Generated Email!\r\n";
      System.out.println(command);
      os.write(command.getBytes("US-ASCII"));

      response = br.readLine();
      System.out.println(response);

      if (!response.startsWith("250")) {
         throw new Exception("250 reply not received from server.");
      }

      command = "CHASE DEETS\r\n";
      System.out.println(command);
      os.write(command.getBytes("US-ASCII"));

      response = br.readLine();
      System.out.println(response);

      if (!response.startsWith("250")) {
         throw new Exception("250 reply not received from server.");
      }


      // End with line with a single period.
      command = ".\r\n";
      System.out.println(command);
      os.write(command.getBytes("US-ASCII"));

      response = br.readLine();
      System.out.println(response);

      if (!response.startsWith("250")) {
         throw new Exception("250 reply not received from server.");
      }


      // Send QUIT command.
      command = "QUIT\r\n";
      System.out.println(command);
      os.write(command.getBytes("US-ASCII"));

      response = br.readLine();
      System.out.println(response);

      if (!response.startsWith("250")) {
         throw new Exception("250 reply not received from server.");
      }
   }
}
