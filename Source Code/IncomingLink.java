package PageRank;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author mpatwary
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class IncomingLink {
    public double pagerank[] = new double[10];
    public static Map<Integer, Integer> outgoingLinks = new HashMap<>();
	public static void main(String [] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("C:\\Users\\mpatwary\\Google Drive\\UTAS\\Program Practice\\PageRank\\src\\InlinkCount\\link.txt"));
		Map<Integer, List<Integer>> graph = new HashMap<>();
		IncomingLink link = new IncomingLink();
				LinkedList<Integer> alist = null;
		while (sc.hasNextLine()) {
			alist = new LinkedList<Integer>();
			// map = new HashMap();
			String line = sc.nextLine();
			StringTokenizer token = new StringTokenizer(line);
			while (token.hasMoreTokens()) {
				String element = token.nextToken();
				int value = Integer.parseInt(element);
				alist.add(value);
			}
			outgoingLinks.put(alist.getFirst(),alist.size()-1);
			//graph.put(alist.getFirst(),alist.subList(1,alist.size()));	

			for (int a = 1; a <= alist.size() - 1; a++) {
				// -------------------------------------------------------------------

				if (graph.containsKey(alist.get(a))) {
					graph.get(alist.get(a)).add(alist.get(0));
					if (graph.get(alist.get(0)) == null) {
						graph.put(alist.get(0), new LinkedList<Integer>());
						
						//graph.get(alist.get(0)).add(0);
					}
				} else {
					List<Integer> to = new LinkedList();
					to.add(alist.get(0));
					graph.put(alist.get(a), to);
					
				}
			}
		
		
		
		
		}
		
		
		link.countInLink(graph);
	}
	
	public void countInLink(Map<Integer,List<Integer>> graph){
		double InitialPageRank;
                double dampingFactor=0.85;
                double TempPageRank[] = new double[10];
                int ITERATION_STEP =1;
                double OutgoingLinks=0;
                double totalNodes=5;
                int k =1;
                InitialPageRank=1/totalNodes;
                //first iteration and insert the initial pagerank value
                
                for(k=1;k<=totalNodes;k++){
                this.pagerank[k]= InitialPageRank;
                }
                //print initial pagerank value 
                for(k=1;k<=totalNodes;k++){
                    System.out.println(" Page rank of "+k+ " is : \t"+ this.pagerank[k]);
                
                }
                
                while(ITERATION_STEP<=2) // Iterations
                {
                	
                	  for(k=1;k<=totalNodes;k++)
                	  {  
                	    TempPageRank[k]=this.pagerank[k];
                	    this.pagerank[k]=0;
                	   }
                	  	
                	
		for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
			
			for(int i =0;i<entry.getValue().size();i++){
	
			
				OutgoingLinks=outgoingLinks.get(entry.getValue().get(i));  
                this.pagerank[entry.getKey()]+=TempPageRank[entry.getValue().get(i)]*(1/OutgoingLinks); 
                
                
		}
			
		   
		}
                
                System.out.printf("\n After "+ITERATION_STEP+"th Step \n");
   
     for(k=1;k<=totalNodes;k++) 
      System.out.printf(" Page Rank of "+k+" is :\t"+this.pagerank[k]+"\n"); 
                ITERATION_STEP = ITERATION_STEP+1;
                }
                
             // Add the Damping Factor to PageRank
                for(k=1;k<=totalNodes;k++)
                {
                  this.pagerank[k]=(1-dampingFactor)+ dampingFactor*this.pagerank[k]; 
                  } 
             // Display PageRank
                System.out.printf("\n Final Page Rank : \n"); 
                for(k=1;k<=totalNodes;k++)
                {
                 System.out.printf(" Page Rank of "+k+" is :\t"+this.pagerank[k]+"\n"); 
                  }
		
	}

	
	public static void inversiion(Map <Integer, List<Integer>> graph) {
		
		
		
	}
}

