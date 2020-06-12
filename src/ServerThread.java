import java.io.*;
import java.util.*;
import java.net.*;
import java.sql.*;

public class ServerThread extends Thread{
    private Socket socket;
    public ServerThread(Socket socket){
        this.socket=socket;
    }
    public void run(){
        try{
            ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
            PackageData pd;
            while((pd=(PackageData)inStream.readObject())!=null){
                if (pd.getOperationType().equals("list")) {
                    ArrayList<Students> db = Server.getAllStudents();
                    PackageData response = new PackageData("list", db);
                    outStream.writeObject(response);
                }
            }
        }catch (Exception e) {
                e.printStackTrace();
        }
    }
}