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

public class DeathCalculation {

    public DeathCalculation() throws IOException {
        Accident a = new Accident();
       
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
                    System.out.println(head+" Final Output: "+f);
                }
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }

    }

    public static void main(String args[]) throws IOException {
        new DeathCalculation();
    }

}
