import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class MenuPage extends Container{
    private JButton listSt;
    public MenuPage(){

        setSize(600,600);
        setLayout(null);


        listSt = new JButton("LIST STUDENT");
        listSt.setSize(200,30);
        listSt.setLocation(200,150);
        listSt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Students s = new Students();
                PackageData pd = new PackageData("list", s);
                Main.sendPackage(pd);
                Main.frame.showListStudentPage();
            }
        });
        add(listSt);

    }
}