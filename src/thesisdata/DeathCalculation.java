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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javafx.application.Application.launch;
import javax.swing.*;
import org.jfree.ui.RefineryUtilities;

public class DeathCalculation extends JFrame{

    TreeMap<Double, String> hash = new TreeMap<>();
    TreeMap<String, String> newsData = new TreeMap<>();
<<<<<<< HEAD
    HashMap<String,String> numcal = new HashMap<>();
=======
>>>>>>> origin/master
    Accident accident = new Accident();
    Murder murder = new Murder();
    Political polics = new Political();
    Crime crime = new Crime();
    JButton b1 = new JButton();
    JLabel label1 = new JLabel();
    JLabel l2 = new JLabel();
    JLabel label3 = new JLabel();
    JLabel l4 = new JLabel();
     JLabel maintext = new JLabel();

    public DeathCalculation() throws IOException {
         super.setSize(400, 500);
       super.setLayout(null);
         b1.setSize(200, 70);
        b1.setBounds(100, 50, 150, 50);
        b1.setText("Analysis Data");
        //For Label
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

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //button is pressed
                System.out.println("You clicked the button");
                l2.setText("Gekki Fycj");
                calculate();
            }
        });
        super.add(b1);
        super.add(label1);
        super.add(l2);
        super.add(label3);
        super.add(l4);
        super.add(maintext);
        super.setVisible(true);
<<<<<<< HEAD
        loadnum();
        
=======
>>>>>>> origin/master

//Read more: http://java67.blogspot.com/2013/08/best-way-to-iterate-over-each-entry-in.html#ixzz3jnSa0S4w
      
    }
<<<<<<< HEAD
    public void loadnum()
    {
         try (BufferedReader br = new BufferedReader(new FileReader("banglanum.txt"))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                String st[];
                st=line.split(" ");
                numcal.put(st[0], st[1]);
        
        }
     }
        catch(Exception ex)
        {
           // return dataset;
        }
    }
    public void calculate()
    {
        
        
=======
    public void calculate()
    {
>>>>>>> origin/master
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
                    String body = eElement.getElementsByTagName("paragraph").item(0).getTextContent();
<<<<<<< HEAD
                    if ((head.contains("দেখুন")) || (head.contains("রাখুন")) || (head.contains("খুনির")) || (head.contains("খুনিকে")) || (head.contains("খুনিদের")) || (head.contains("মৃত্যুবার্ষিকী")) || (head.contains("স্মৃতি")) || (head.contains("স্মরণীয়"))|| (head.contains("স্মরণ")) || (head.contains("মৃত্যুতে")) || (head.contains("মৃত্যুর"))|| (head.contains("খুনের"))|| (head.contains("মৃত্যুঝুঁকি"))) {
=======
                    if ((head.contains("দেখুন")) || (head.contains("রাখুন")) || (head.contains("খুনির")) || (head.contains("খুনিকে")) || (head.contains("খুনিদের")) || (head.contains("মৃত্যুবার্ষিকী")) || (head.contains("স্মৃতি")) || (head.contains("স্মরণীয়"))|| (head.contains("স্মরণ"))) {
>>>>>>> origin/master

                    } else {
                        newsData.put(head, body);

                        //   System.out.println(head+"\nAccident "+accidents+"Murder: "+murders+"Political: "+political);
                    }
                      // avoids ConcurrentModificationException

                }
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }

        getClusterdData();
    }

    public void getClusterdData()  {
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
<<<<<<< HEAD
                String num[];
                int flag=0;
                num=head.split(" ");
                for(int i=0;i<num.length;i++)
                {
                if((num[i].contains("১"))||(num[i].contains("২"))||(num[i].contains("৩"))||(num[i].contains("৪"))||(num[i].contains("৫"))||(num[i].contains("৬"))||(num[i].contains("৭"))||(num[i].contains("৮"))||(num[i].contains("৯"))||(num[i].contains("০")))
                {
                    int val= numconverter(num[i]);
                    taccident+=val;
                    flag=1;
                }
                 else if(numcal.get(num[i]) != null)
                {
                    taccident+=Integer.parseInt(numcal.get(num[i]));
                    flag =1;
                }
                }
                if(flag==0)
                {
                taccident++;
                }
                
            } else if (category_final.equals("political")) {
                 String num[];
                int flag=0;
                num=head.split(" ");
                for(int i=0;i<num.length;i++)
                {
                    
                if((num[i].contains("১"))||(num[i].contains("২"))||(num[i].contains("৩"))||(num[i].contains("৪"))||(num[i].contains("৫"))||(num[i].contains("৬"))||(num[i].contains("৭"))||(num[i].contains("৮"))||(num[i].contains("৯"))||(num[i].contains("০")))
                {
                    int val= numconverter(num[i]);
                    tpolitics+=val;
                    flag=1;
                }
                    
                else if(numcal.get(num[i]) != null)
                {
                    tpolitics+=Integer.parseInt(numcal.get(num[i]));
                    flag =1;
                }
               
                }
                if(flag==0)
                {
                tpolitics++;
                }
                
            } 
            else if (category_final.equals("murder")) {
                   String num[];
                int flag=0;
                num=head.split(" ");
                for(int i=0;i<num.length;i++)
                {
                if((num[i].contains("১"))||(num[i].contains("২"))||(num[i].contains("৩"))||(num[i].contains("৪"))||(num[i].contains("৫"))||(num[i].contains("৬"))||(num[i].contains("৭"))||(num[i].contains("৮"))||(num[i].contains("৯"))||(num[i].contains("০")))
                {
                    int val= numconverter(num[i]);
                    tmurder+=val;
                    flag=1;
                }
                 else if(numcal.get(num[i]) != null)
                {
                     tmurder+=Integer.parseInt(numcal.get(num[i]));
                    flag =1;
                }
                }
                if(flag==0)
                {
                tmurder++;
                }
                //tmurder++;
            } else if (category_final.equals("crime")) {
                     String num[];
                int flag=0;
                num=head.split(" ");
                for(int i=0;i<num.length;i++)
                {
                   
                if((num[i].contains("১"))||(num[i].contains("২"))||(num[i].contains("৩"))||(num[i].contains("৪"))||(num[i].contains("৫"))||(num[i].contains("৬"))||(num[i].contains("৭"))||(num[i].contains("৮"))||(num[i].contains("৯"))||(num[i].contains("০")))
                {
                    int val= numconverter(num[i]);
                    tcrime+=val;
                    flag=1;
                }
                 else if(numcal.get(num[i]) != null)
                {
                    tmurder+=Integer.parseInt(numcal.get(num[i]));
                    flag =1;
                }
                }
                if(flag==0)
                {
                tcrime++;
                }
=======
                taccident++;
            } else if (category_final.equals("political")) {
                tpolitics++;
            } else if (category_final.equals("murder")) {
                tmurder++;
            } else if (category_final.equals("crime")) {
                tcrime++;
>>>>>>> origin/master
            }
            

            System.out.printf("\n\n Crime: %d.\n Murder: %d.\n Political: %d.\n Accident: %d", tcrime, tmurder, tpolitics, taccident);

            hash.clear();
            // iterator.remove(); // right way to remove entries from Map, 

<<<<<<< HEAD
        }
          label1.setText("Accident: "+Integer.toString(taccident));
          
        l2.setText("Murder: "+Integer.toString(tmurder));
        label3.setText("Political: "+Integer.toString(tpolitics));
        l4.setText("Crime: "+Integer.toString(tcrime));
    
 try{
      File file = new File("summery.txt");
      // creates the file
      file.createNewFile();
      // creates a FileWriter Object
      FileWriter writer = new FileWriter(file); 
      // Writes the content to the file
      writer.write("Accident "+Integer.toString(taccident)); 
      writer.write("\nMurder "+Integer.toString(tmurder)); 
      writer.write("\nPolitical "+Integer.toString(tpolitics)); 
      writer.write("\nCrime "+Integer.toString(tcrime)); 
      writer.flush();
      writer.close();

 }
 catch (Exception ex)
 {
     
 }

    PieChartDemo1 demo = new PieChartDemo1("Death Causes Detection");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
   
   }
    
    public int numconverter(String str)
    {
        String num = "";
       char[] arr =str.toCharArray();
        for(int i=0; i<arr.length;i++)
        {
           if (arr[i] =='১')
           {
               num=num+"1";
           }
          else  if (arr[i] =='২')
           {
                num=num+"2";
           }
            else if (arr[i] =='৩')
           {
                num=num+"3";
           }
            else  if (arr[i] =='৪')
           {
                num=num+"4";
           }
           else    if (arr[i] =='৫')
           {
                num=num+"5";
           }
            else    if (arr[i] =='৬')
           {
                num=num+"6";
           } 
            else if (arr[i] =='৭')
           {
                num=num+"7";
           }
            else if (arr[i] =='৮')
           {
                num=num+"8";
           }
            else if (arr[i] =='৯')
           {
                num=num+"9";
           }
          else  if (arr[i] =='০')
           {
                num=num+"0";
           }
           else
          {
              
          }
                
        }
      
        int output=Integer.parseInt(num);
       // System.out.println("Hello Output: "+output);
        
        //Character[] charObjectArray = ArrayUtils.toObject(charArray);
      //  return output;
       // int a = ১
        return output;
      
    }
=======
        }
          label1.setText("Accident: "+Integer.toString(taccident));
          
        l2.setText("Murder: "+Integer.toString(tmurder));
        label3.setText("Political: "+Integer.toString(tpolitics));
        l4.setText("Crime: "+Integer.toString(tcrime));
    
 try{
      File file = new File("summery.txt");
      // creates the file
      file.createNewFile();
      // creates a FileWriter Object
      FileWriter writer = new FileWriter(file); 
      // Writes the content to the file
      writer.write("Accident "+Integer.toString(taccident)); 
      writer.write("\nMurder "+Integer.toString(tmurder)); 
      writer.write("\nPolitical "+Integer.toString(tpolitics)); 
      writer.write("\nCrime "+Integer.toString(tcrime)); 
      writer.flush();
      writer.close();

 }
 catch (Exception ex)
 {
     
 }

    PieChartDemo1 demo = new PieChartDemo1("Pie Chart Demo 1");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
   
   }
>>>>>>> origin/master

    public static void main(String args[]) throws IOException {
        new DeathCalculation();
        
<<<<<<< HEAD
        
=======
>>>>>>> origin/master
    }

}
