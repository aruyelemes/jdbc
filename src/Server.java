import java.io.*;
import java.util.*;
import java.net.*;
import java.sql.*;

public class Server{
    private static Connection connection;

    public static void disconnect(){
        try {
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/university?useUnicode=true&serverTimezone=UTC", "root", "87071313236");
        }catch (Exception e) {
            e.printStackTrace();
        }

        try{
            ServerSocket serverSocket = new ServerSocket(1997);

            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                ServerThread st = new ServerThread(socket);
                st.start();

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static ArrayList<Students> getAllStudents(){
        ArrayList<Students> list = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Long id = resultSet.getLong("id");
                String lastName = resultSet.getString("last_name");
                String firstName = resultSet.getString("first_name");
                int course = resultSet.getInt("course");
                double gpa = resultSet.getDouble("gpa");
                list.add(new Students(id, lastName, firstName, course, gpa));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

