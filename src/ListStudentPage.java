import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.util.*;
public class ListStudentPage extends Container{
    private JButton back;
    private JTextArea area;
    private JTable table;
    private String columnNames[] = {"id", "lastname", "firstname", "course", "gpa"};
    public ListStudentPage(){
        setSize(600,600);
        setLayout(null);

        back = new JButton("BACK");
        back.setSize(200,30);
        back.setLocation(250,450);
        add(back);

        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Main.frame.showMenuPage();
            }
        });
    }

    public void fillArea(){
        PackageData response = Main.getPackage();
        ArrayList<Students> students = response.getStudents();
        Object values[][]= new Object[students.size()][5];
        for(int i=0;i<students.size();i++){
            values[i][0] =students.get(i).getId();
            values[i][1] = students.get(i).getLastName();
            values[i][2] = students.get(i).getFirstName();
            values[i][3] = students.get(i).getCourse();
            values[i][4] = students.get(i).getGpa();
        }

        table = new JTable(values, columnNames);

        table.setSize(575,400);
        table.setLocation(10,10);

        add(table);
    }
}