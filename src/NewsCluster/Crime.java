/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewsCluster;

import info.debatty.java.stringsimilarity.Cosine;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Herock
 */
public class Crime {
    ArrayList<String> grammer = new ArrayList<String>();
    public Crime()
    {
         
        try (BufferedReader br = new BufferedReader(new FileReader("Grammer/crime.txt"))) {
            String line;
            int counter = 0, counter1 = 0;
            while ((line = br.readLine()) != null) {
               // System.out.println(line);
              grammer.add(line);
            }
        } catch (Exception ex) {

        }

    }
      public float sendScore(String newsdata) {
       Cosine cosine = new Cosine();
       float match=(float) 0.00;
        float temp;
        for(int i=0;i<grammer.size();i++)
        {
             
          temp =(float) cosine.similarity(grammer.get(i), newsdata);
           // System.out.println(temp);
          if(temp>match)
          {
              match=temp;
          }
       
        }
        
        return match;
    }
    
}
