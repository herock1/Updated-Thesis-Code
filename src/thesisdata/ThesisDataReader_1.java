/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisdata;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 *
 * @author Herock
 */
public class ThesisDataReader_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("prothomalo/pranhani.txt"))) {
            String line;
            int counter=0;
            while ((line = br.readLine()) != null) {
               // System.out.println(line);
               
                //System.out.println(line);
                // process the line.
                //System.out.println(line);
               try {
                    String url = line;
            //    System.out.println(string1);
             int flag=0;
                    Document doc = Jsoup.connect(url).get();
                    //System.out.println(doc);
                    Elements paragraph1 = doc.select("h1");
                    for (Element p : paragraph1) {
                       
                      //  System.out.println(p.text());
                        // মরণ মারা যাওয়া প্রাণহানি  প্রাণহানি অপমৃত্যু মৃত ইন্তিকাল প্রাণনাশ মরণ অকাল মৃত্যু
                        
                        if(p.text().contains("নিহত")||p.text().contains("মৃত্যু")||p.text().contains("খুন")||p.text().contains("মরণ")||p.text().contains("প্রাণহানি")||p.text().contains("অপমৃত্যু")||p.text().contains("মৃত")||p.text().contains("ইন্তিকাল")||p.text().contains("অপমৃত্যু")||p.text().contains("অকাল মৃত্যু"))
                        {
                             counter++;
                            flag=1;
                         //   System.out.println(url);
                            System.out.println(" <staff id=\""+counter+"\">");
                            System.out.println("<head>"+p.text()+"</head>");
                            
                        }
                        else
                        {
                          ///  System.out.println("Sorry");
                        }
                    }
                    String para="";
                      Elements paragraph = doc.select("p");
                    for (Element p : paragraph) {
                      //  System.out.println(p.text());
                      //  System.out.println(p.text());
                         if((p.text().contains("নিহত")||p.text().contains("মৃত্যু")||p.text().contains("খুন")||p.text().contains("মরণ")||p.text().contains("প্রাণহানি")||p.text().contains("অপমৃত্যু")||p.text().contains("মৃত")||p.text().contains("ইন্তিকাল")||p.text().contains("অপমৃত্যু")||p.text().contains("অকাল মৃত্যু"))&& (flag==1))
                        
                        {
                            //System.out.println(url);
                          flag=2;
                          para+=p.text();
                         }
                        else
                        {
                          ///  System.out.println("Sorry");
                        }
                        
                    }
                    if(flag==2)
                        {
                             System.out.println("<paragraph>"+para+"</paragraph>");
                             System.out.println("</staff>");
                        }
                    else if (flag==1)
                    {
                        System.out.println("<paragraph> </paragraph>");
                        System.out.println("</staff>");
                    }
                   
                   
                    
                    
                } catch (IOException ex) {

                }

               
            }
        } catch (Exception ex) {
                System.out.println(ex);
        }

         
    }
    
  
}
