
//Shortest sub Segment

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
/**
 *
 * @author SURAJKA
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.HashMap;

/**
 *
 * @author SURAJKA
 */
 class ShortestSegment {
    

    int beginStr;
    int endStr;
    int length;
    int minimumWindowLen=200000000;
    HashMap<String,Integer>needtofind=new HashMap<String, Integer>();
    HashMap<String,Integer>hasfound=new HashMap<String, Integer>();
    
    void decrementHasFoundmap(String str)
    {
        
         
        if(hasfound.containsKey(str))
        {
            
            int i=hasfound.get(str);
            hasfound.put(str, i-1);
            
        }
    }
    void incermentHasFound(String str)
    {
        
         
        if(hasfound.containsKey(str))
        {
            
            int i=hasfound.get(str);
            hasfound.put(str, i+1);
            
        }
    else
        hasfound.put(str,1);
    }
    void initialiseMaps(String str)
    {
        
        if(needtofind.containsKey(str))
        {
            
            int i=needtofind.get(str);
            needtofind.put(str, i+1);
            
        }
        else
        needtofind.put(str,1);
    }
    
    
    void findminimumWindow(String str)
    {
        
       
        String strArray[]=str.split(" ");
        int count=0;
        
        
        int begin=0,end=0;
        for(begin=0,end=0;end<strArray.length;end++)
        {
            
            if(!needtofind.containsKey(strArray[end]))
                continue;
            incermentHasFound(strArray[end]);
            if(hasfound.get(strArray[end])<=needtofind.get(strArray[end]))
                count++;
            
            if(count==length)
            {
                while(needtofind.get(strArray[begin])==null||hasfound.get(strArray[begin])>needtofind.get(strArray[begin]))
                {
                   
                    if(needtofind.get(strArray[begin])!=null&&hasfound.get(strArray[begin])>needtofind.get(strArray[begin]))
                      decrementHasFoundmap(strArray[begin]);
                       begin++;
                }
                    
             
                int windowlength=end-begin+1;
                if(windowlength<minimumWindowLen)
                {
                    minimumWindowLen=windowlength;
                    beginStr=begin;
                    endStr=end;
                }
            
            }
            
        }
        
    }

}

public class Solution {
    
    
    public static void main(String args[])throws Exception
    {
        ShortestSegment obj=new ShortestSegment();
        File fil=new File("abc");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        String line = br.readLine();
        int noofwords=Integer.parseInt(br.readLine());
        obj.length=noofwords;
        for(int i=0;i<noofwords;i++)
        {
            obj.initialiseMaps(br.readLine().toUpperCase());
            
        }
        
        
        line=line.replaceAll("[^a-zA-Z]", " ");
        line=line.replaceAll("  ", " ");
        while(line.indexOf("  ")>-1)
        {
          line=line.replaceAll("  ", " ");  
        }
        obj.findminimumWindow(line.toUpperCase());
        String strArray[]=line.split(" ");
        
        
        if(obj.endStr==0)
        {
            System.out.println("NO SUBSEGMENT FOUND");
        }
        else
        for(int i=obj.beginStr;i<=obj.endStr;i++)
        {
            System.out.print(strArray[i]+" ");
        }
    }
    
}
