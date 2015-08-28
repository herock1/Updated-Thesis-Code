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
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import static thesisdata.MyApp.printSimilarity;
import NewsCluster.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class XmlReader {
    XmlReader()
    {
        
    
    }
   
      public static double similarity(String s1, String s2) {
        String longer = s1, shorter = s2;
        if (s1.length() < s2.length()) { // longer should always have greater length
            longer = s2; shorter = s1;
        }
        int longerLength = longer.length();
        if (longerLength == 0) { return 1.0; /* both strings are zero length */ }
        /* // If you have StringUtils, you can use it to calculate the edit distance:
        return (longerLength - StringUtils.getLevenshteinDistance(longer, shorter)) /
                                                             (double) longerLength; */
        return (longerLength - editDistance(longer, shorter)) / (double) longerLength;
 
    }
 
    // Example implementation of the Levenshtein Edit Distance
    // See http://r...content-available-to-author-only...e.org/wiki/Levenshtein_distance#Java
    public static int editDistance(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
 
        int[] costs = new int[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            int lastValue = i;
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0)
                    costs[j] = j;
                else {
                    if (j > 0) {
                        int newValue = costs[j - 1];
                        if (s1.charAt(i - 1) != s2.charAt(j - 1))
                            newValue = Math.min(Math.min(newValue, lastValue),
                                    costs[j]) + 1;
                        costs[j - 1] = lastValue;
                        lastValue = newValue;
                    }
                }
            }
            if (i > 0)
                costs[s2.length()] = lastValue;
        }
        return costs[s2.length()];
    }
 
    public static void printSimilarity(String s, String t) {
        System.out.println(String.format(
            "%.3f is the similarity between \"%s\" and \"%s\"", similarity(s, t), s, t));
    }
    
   public static void main(String argv[]) {
   Map<String ,String> map = new HashMap<String,String>();

    try {

	File fXmlFile = new File("TestXML.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
			
	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();

	//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
	NodeList nList = doc.getElementsByTagName("staff");
			
	//System.out.println("----------------------------");

	for (int temp = 0; temp <= nList.getLength()+1; temp++) {

		Node nNode = nList.item(temp);
				
		//System.out.println("\nCurrent Element :" + nNode.getNodeName());
				
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;

//		System.out.println("Staff id : " + eElement.getAttribute("id"));
		//	System.out.println("First Name : " + eElement.getElementsByTagName("head").item(0).getTextContent());
//                        System.out.println("First Name : " + eElement.getElementsByTagName("paragraph").item(0).getTextContent());
//                         
                      String  s=eElement.getElementsByTagName("head").item(0).getTextContent();
                      String  s1=eElement.getElementsByTagName("paragraph").item(0).getTextContent();
                      System.out.println(s);
                      map.put(s, s1);
//                      if((s.contains("দেখুন"))||(s.contains("রাখুন"))||(s.contains("খুনির"))||(s.contains("খুনিকে"))||(s.contains("খুনিদের")))
//                      {
//                          System.out.println("Hello I am not"+s);
//                      }
//                     else if(s.contains("খুন"))
//                      {
//                          System.out.println(s);
//                          // printSimilarity(s, " বিমান নিহত");
//                      }
//                      
                    //System.out.println("Last Name : " + eElement.getElementsByTagName("paragraph").item(0).getTextContent());
                    
			//System.out.println("Last Name : " + eElement.getElementsByTagName("paragraph").item(0).getTextContent());
			

		}
	}
       
    }
    catch (Exception e) {
	//e.printStackTrace();
    }
//       Iterator it = map.entrySet().iterator();
//    while (it.hasNext()) {
//        Map.Entry pair = (Map.Entry)it.next();
//        System.out.println(pair.getKey());
//        it.remove(); // avoids a ConcurrentModificationException
//    }
  }
   
}
