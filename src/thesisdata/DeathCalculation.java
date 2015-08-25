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
import org.jsoup.Jsoup;
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
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeathCalculation extends JFrame {

    JButton b1 = new JButton();
    JLabel label1 = new JLabel();
    JLabel l2 = new JLabel();
    JLabel label3 = new JLabel();
    JLabel l4 = new JLabel();

    public DeathCalculation() throws IOException {
        Accident a = new Accident();

       
        super.setSize(400, 500);
       
         b1.setSize(200, 70);
        b1.setBounds(100, 50, 150, 50);
        b1.setText("Analysis Data");
        //For Label
        label1.setBounds(20, 140, 250, 40);
        l2.setBounds(20, 190, 250, 40);
        label3.setBounds(20, 240, 250, 40);
        l4.setBounds(20, 290, 250, 40);

        label1.setText("Larum spum");
        l2.setText("Larum spum Hello");
        label3.setText("Larum spum  22");
        l4.setText("Hello world");

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //button is pressed
                System.out.println("You clicked the button");
                l2.setText("Gekki Fycj");
            }
        });
        super.add(b1);
        super.add(label1);
        super.add(l2);
        super.add(label3);
        super.add(l4);
        super.setVisible(true);
        try {

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
                    float f = a.sendScore(head);
                    System.out.println(head + " Final Output: " + f);
                }
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }

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
