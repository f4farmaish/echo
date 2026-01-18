package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server extends Thread{


    Socket s;
    public server(Socket s){
        this.s=s;
    }


    @Override
    public void run(){
        BufferedReader in;
        String message;
        PrintWriter out;
        do {
            try {
                in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                message = in.readLine();
                System.out.println("client said to sevrer "+message);
                out = new PrintWriter(s.getOutputStream(), true);
                out.println("server says "+ message);
            }

            catch (IOException e) {
                throw new RuntimeException(e);
            }

        }while(!message.equals("exit"));

    }

   public static void main(String[] arg) throws IOException {

       ServerSocket ss= new ServerSocket(8080);
       System.out.println("server is running");
       Socket s=ss.accept();
       int count=0;
       System.out.println("client " + (count + 1) + " connected");

       while(true){
           server ser= new server(s);
           ser.start();
       }

   }
}
