/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisdata;

/**
 *
 * @author Herock
 */
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import NewsCluster.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
<<<<<<< HEAD
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DeathCalculation extends JFrame{

    TreeMap<Double, String> hash = new TreeMap<>();
    TreeMap<String, String> newsData = new TreeMap<>();
    Accident accident = new Accident();
    Murder murder = new Murder();
    Political polics = new Political();
    Crime crime = new Crime();
=======
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeathCalculation extends JFrame {

>>>>>>> origin/master
    JButton b1 = new JButton();
    JLabel label1 = new JLabel();
    JLabel l2 = new JLabel();
    JLabel label3 = new JLabel();
    JLabel l4 = new JLabel();
<<<<<<< HEAD
     JLabel maintext = new JLabel();

    public DeathCalculation() throws IOException {
         super.setSize(400, 500);
       super.setLayout(null);
=======

    public DeathCalculation() throws IOException {
        Accident a = new Accident();

       
        super.setSize(400, 500);
       
>>>>>>> origin/master
         b1.setSize(200, 70);
        b1.setBounds(100, 50, 150, 50);
        b1.setText("Analysis Data");
        //For Label
<<<<<<< HEAD
        maintext.setBounds(50, 10, 350, 30);
        label1.setBounds(30, 140, 250, 40);
        l2.setBounds(30, 200, 250, 40);
        label3.setBounds(30, 250, 250, 40);
        l4.setBounds(30, 300, 250, 40);

        label1.setText("Accident: ");
        l2.setText("Murder: ");
        label3.setText("Political: ");
        l4.setText("Crime: ");
        maintext.setText("Death Causes Detection Based On Newspaper Data");
        maintext.setForeground(Color.red);
=======
        label1.setBounds(20, 140, 250, 40);
        l2.setBounds(20, 190, 250, 40);
        label3.setBounds(20, 240, 250, 40);
        l4.setBounds(20, 290, 250, 40);

        label1.setText("Larum spum");
        l2.setText("Larum spum Hello");
        label3.setText("Larum spum  22");
        l4.setText("Hello world");
>>>>>>> origin/master

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //button is pressed
                System.out.println("You clicked the button");
                l2.setText("Gekki Fycj");
<<<<<<< HEAD
                calculate();
=======
>>>>>>> origin/master
            }
        });
        super.add(b1);
        super.add(label1);
        super.add(l2);
        super.add(label3);
        super.add(l4);
<<<<<<< HEAD
        super.add(maintext);
        super.setVisible(true);

//Read more: http://java67.blogspot.com/2013/08/best-way-to-iterate-over-each-entry-in.html#ixzz3jnSa0S4w
      
    }
    public void calculate()
    {
          try {
=======
        super.setVisible(true);
        try {
>>>>>>> origin/master

            File fXmlFile = new File("TestXML.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("staff");

            //System.out.println("----------------------------");
            for (int temp = 0; temp <= nList.getLength() + 1; temp++) {

                Node nNode = nList.item(temp);

                //System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    org.w3c.dom.Element eElement = (org.w3c.dom.Element) nNode;

                    String head = eElement.getElementsByTagName("head").item(0).getTextContent();
<<<<<<< HEAD
                    String body = eElement.getElementsByTagName("paragraph").item(0).getTextContent();
                    if ((head.contains("দেখুন")) || (head.contains("রাখুন")) || (head.contains("খুনির")) || (head.contains("খুনিকে")) || (head.contains("খুনিদের")) || (head.contains("মৃত্যুবার্ষিকী")) || (head.contains("স্মৃতি")) || (head.contains("স্মরণীয়"))) {

                    } else {
                        newsData.put(head, body);

                        //   System.out.println(head+"\nAccident "+accidents+"Murder: "+murders+"Political: "+political);
                    }
                      // avoids ConcurrentModificationException

=======
                    float f = a.sendScore(head);
                    System.out.println(head + " Final Output: " + f);
>>>>>>> origin/master
                }
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }

        getClusterdData();
    }

    public void getClusterdData() {
        int taccident = 0, tpolitics = 0, tmurder = 0, tcrime = 0;
        String category_final = "";
        Iterator<Map.Entry<String, String>> iterator = newsData.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.printf("Key : %s %n", entry.getKey());
            String head = entry.getKey();
           // maintext.setText(head);
            double accidents = accident.sendScore(head);
            double political = polics.sendScore(head);
            double murders = murder.sendScore(head);
            double crimes = crime.sendScore(head);

            hash.put(accidents, "accident");
            hash.put(political, "political");
            hash.put(murders, "murder");
            hash.put(crimes, "crime");
            
            //  System.out.println(hash.size());
            Iterator<Map.Entry<Double, String>> iterator1 = hash.entrySet().iterator();
            while (iterator1.hasNext()) {
                Map.Entry<Double, String> entry1 = iterator1.next();
                //System.out.println(iter);
                System.out.printf("Key : %f and Value: %s %n", entry1.getKey(), entry1.getValue());
                iterator1.remove(); // right way to remove entries from Map, 
                category_final = entry1.getValue();
                
                
            }

            if (category_final.equals("accident")) {
                taccident++;
            } else if (category_final.equals("political")) {
                tpolitics++;
            } else if (category_final.equals("murder")) {
                tmurder++;
            } else if (category_final.equals("crime")) {
                tcrime++;
            }
            

            System.out.printf("\n\n Crime: %d.\n Murder: %d.\n Political: %d.\n Accident: %d", tcrime, tmurder, tpolitics, taccident);

            hash.clear();
            // iterator.remove(); // right way to remove entries from Map, 

        }
          label1.setText("Accident: "+Integer.toString(taccident));
          
        l2.setText("Murder: "+Integer.toString(tmurder));
        label3.setText("Political: "+Integer.toString(tpolitics));
        l4.setText("Crime: "+Integer.toString(tcrime));
   
    }
    /*b1*/

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            System.out.println("Hello World");
        }
    }

    public static void main(String args[]) throws IOException {
        new DeathCalculation();
    }

}
