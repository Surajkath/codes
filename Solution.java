
//Connected Sets

/*
 Enter your code here. Read input from STDIN. Print output to STDOUT
 Your class should be named Solution
*/

import java.io.*;
 class ConnectedSets {

    /**
     * @param args the command line arguments
     */
    
    int n;
    int a[][];
    int visited[][];
    
    
    ConnectedSets(int a[][],int n)
    {
        this.a=a;
        this.n=n;
        visited=new int[n][n];
    }
           
    int connectedComponenet;
    
    public void findConnectedComponenet()
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(a[i][j]==1&&visited[i][j]!=1)
                {
                    connectedComponenet++;
                    findComponenet(i, j);
                }
            }
        }
    
        System.out.println(connectedComponenet);
    }

    private void findComponenet(int i,int j)
    {
        
                
            if(i<0 ||i>=n||j<0||j>=n)
                {
                    return;
                }
        
            if(visited[i][j]==1||a[i][j]==0)
                    return ;
                
                
                
                
                
                visited[i][j]=1;
                
                findComponenet(i-1, j-1);
                findComponenet(i-1, j);
                findComponenet(i-1, j+1);
                findComponenet(i, j-1);
                findComponenet(i, j+1);
                
                findComponenet(i+1, j-1);
                
                
                findComponenet(i+1, j);
                
                
                findComponenet(i+1, j+1);
                
                
                
    
    }
    



}



public class Solution {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for(int i=0;i<N;i++)
        {
            line = br.readLine(); 
            int dimension=Integer.parseInt(line);
            int a[][]=new int[dimension][dimension];
            
            for(int j=0;j<dimension;j++)
            {
                 line = br.readLine(); 
                 String element[]=line.split(" ");
            
                 for(int k=0;k<element.length;k++)
                 {
                     a[j][k]=Integer.parseInt(element[k]);
                 }
            }
            
            ConnectedSets obj=new ConnectedSets(a, dimension);
            obj.findConnectedComponenet();
            
        }
    }
}
