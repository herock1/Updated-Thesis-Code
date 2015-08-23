/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewsCluster;

/**
 *
 * @author Herock
 */
import info.debatty.java.stringsimilarity.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Political {
     ArrayList<String> murder = new ArrayList<String>();
    public Political()
    {
        
        try (BufferedReader br = new BufferedReader(new FileReader("Grammer/accident.txt"))) {
            String line;
            int counter = 0, counter1 = 0;
            while ((line = br.readLine()) != null) {
               // System.out.println(line);
              murder.add(line);
            }
        } catch (Exception ex) {

        }
        
    }
  public float sendScore(String newsdata) {
       Cosine cosine = new Cosine();
       float match=(float) 0.00;
        float temp;
        for(int i=0;i<murder.size();i++)
        {
             
          temp =(float) cosine.similarity(murder.get(i), newsdata);
           // System.out.println(temp);
          if(temp>match)
          {
              match=temp;
          }
       
        }
        
        return match;
    }
}
