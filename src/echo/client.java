package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class client {

   public static void main(String[] args) throws IOException {
       System.out.println("connecting to server");
        Socket s= new Socket("localhost",8080);
        System.out.println("connected to server");

       while(true) {
            BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
            String message= in.readLine();
            if (message.equals("exit")){
                System.out.println("disconected to server");
                break;
            }
           PrintWriter  out= new PrintWriter(s.getOutputStream(),true);
            out.println(message);

            BufferedReader res= new BufferedReader(new InputStreamReader(s.getInputStream()));
            String resMessage= res.readLine();
            System.out.println(resMessage);


        }
    }
}
