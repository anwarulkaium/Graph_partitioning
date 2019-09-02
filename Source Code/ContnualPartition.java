package algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class ContnualPartition {
	
	public static Map<Integer, List<Integer>> mainFile = new HashMap<Integer, List<Integer>>(); 
	public static boolean stop = false;
	public static final int numpartition= 2;
	//public static LinkedList<Integer> partition[];
	public static Map<Integer,Integer> partitionEdge[];
	public static Map<Integer, List<Integer>> partition[];
	public static Map<Integer, List<Integer>>map = new HashMap<>();
	public static Map<Integer,Integer> latency = new HashMap<>();
	public static Map<Integer,List<Integer>> boundaryVertex[];
	public static double deviation=0.0;
	
//public static int numpartition = 3;
	
	static List<Integer> list1 = new LinkedList<Integer>();
	static List<Integer> list2 = new LinkedList<Integer>();
	static List<Integer> list3 = new LinkedList<Integer>();
	static List<Integer> list4 = new LinkedList<Integer>();
	static List<Integer> list5 = new LinkedList<Integer>();
	static List<Integer> list6 = new LinkedList<Integer>();
	static List<Integer> list7 = new LinkedList<Integer>();
	static List<Integer> list8 = new LinkedList<Integer>();
	static List<Integer> list9 = new LinkedList<Integer>();
	public static void main(String [] args) throws FileNotFoundException, InterruptedException{
		
		partition = new HashMap[numpartition];
		for (int x = 0; x < numpartition; x++) {
			partition[x] = new HashMap<>();
		}
		
		partitionEdge = new HashMap[numpartition];
		for(int y =0; y< numpartition;y++){
			
			partitionEdge[y] = new HashMap<>();
		}
		
		boundaryVertex = new HashMap[numpartition];
		for(int y =0; y< numpartition;y++){
			
			boundaryVertex[y] = new HashMap<>();
		}
		
		
		list1.add(3);
		list1.add(5);
		list1.add(2);
		list1.add(6);
		
		list2.add(3);
		list2.add(1);
		list2.add(4);
		list2.add(6);
		
		list3.add(2);
		list3.add(1);
		list3.add(5);
		list3.add(7);
		
		list4.add(2);
		list4.add(5);
		list4.add(6);
		
		list5.add(1);
		list5.add(3);
		list5.add(4);
		list5.add(7);
		
		list6.add(1);
		list6.add(4);
		list6.add(2);
		
		
		
		list7.add(5);
		list7.add(3);
		
		list8.add(4);
		list8.add(5);
		
		list9.add(3);
		list9.add(6);

		partition[0].put(1, list1);
		partition[0].put(2, list2);
		
		partition[1].put(3, list3);
		partition[1].put(4, list4);
		partition[1].put(5, list5);
		
		/*partition[2].put(6, list6);
		partition[2].put(7, list7);
		
		partition[3].put(8, list8);
		partition[3].put(9, list9); 
		
		
		/*partition[4].put(1, list1);
		partition[4].put(2, list2);
		
		partition[5].put(3, list3);
		partition[5].put(4, list4);
		partition[5].put(5, list5);
		
		partition[6].put(6, list6);
		partition[6].put(7, list7);
		
		partition[7].put(8, list8);
		partition[7].put(9, list9);*/
		
		/*map.put(1, list1);
		map.put(2, list2);
		map.put(3, list3);
		map.put(4, list4);
		map.put(5, list5);*/
		//System.out.println(partition[0]);
		//latency.put(key, value);
		long start = System.currentTimeMillis();
		readFile();
		//getPartition();
		getBalance();
		
		vertexDeletion();
		vertexDegree();
		//getPartition();
		long stop = System.currentTimeMillis(); 
        long totalTime = stop - start;
        System.out.println(" Total time taken is "+totalTime );
		getEdgecut();
	}
	public static void readFile() throws FileNotFoundException{

		//Scanner sc = new Scanner(new File("/Users/Anwarul/Documents/workspace/First_algorithm_stream/src/algorithm/test.txt"));
		Scanner sc = new Scanner(new File("C:/Users/mpatwary/Desktop/workspace1/graphparr/src/CA-AstroPh.graph"));
		// read stream
		LinkedList<Integer> alist = null;
		while (sc.hasNextLine()&&!stop)

		{
			alist = new LinkedList<Integer>();
			//map = new HashMap();

			String line = sc.nextLine();
			StringTokenizer token = new StringTokenizer(line);
			while (token.hasMoreTokens()) {
				String element = token.nextToken();
				int value = Integer.parseInt(element);
				alist.add(value);
			}
			//System.out.println(alist);
			mainFile.put(alist.getFirst(), alist.subList(1, alist.size()));
			
			
			//System.out.println(mainFile);
		}
		getPartition(mainFile);
		//System.out.println("yessssss");
		
	}
public static void getPartition(Map<Integer, List<Integer>> map){
		// loop through all the partition
				
				for(int x =0; x<numpartition;x++){
					partition[x].clear();
				}
	int costSum=0;
	int finalCost=0;
	int min =0;
	int edgeCount =0;
	int NoOfcommonEdge =0;
	List <Integer> costFunction = new LinkedList<Integer>();	
	int minRange = 30;
	int maxRange = 90;
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			int count = 0;
			for (int y = 0; y <numpartition; y++) {
				for (int x = 0; x < numpartition; x++) {
					if (x == y) {
						continue;
					}
					//System.out.println("From partition "+ entry.getKey());
					Set<Integer> set = new HashSet(partition[y].keySet());
					set.retainAll(entry.getValue());
					NoOfcommonEdge = set.size();
					//System.out.println("x value " + x+ " Y value is "+y);
					if(partitionEdge[y].get(x)!=null){
					edgeCount = partitionEdge[y].get(x);
					}
					//System.out.println("edgeCount   " + edgeCount);
					int lat = minRange + (int)(Math.random()*maxRange);
					costSum = (edgeCount + NoOfcommonEdge) * lat*(1-(partition[y].size()/3000));
					//costSum = (edgeCount + NoOfcommonEdge) * lat;
					//
					//System.out.println();
					// costSum= costSum+
					// System.out.println(entry.getValue());
					
					//System.out.println("Common Edge " + NoOfcommonEdge);
				//	System.out.println("   cost sum " + costSum+ " and the Y value "+y);
					
					 //min = Collections.min(costFunction);
					// mainCount++;
					finalCost = finalCost + costSum;
				}
			//	System.out.println("final cost of  partition "+y+"   "+  finalCost+"------------------------");
				costFunction.add(y,finalCost);
				finalCost=0;
				//System.out.println(" Cost Function Size "+costFunction.size()+" Y value "+ y);
			}
			
			//System.out.println("min  " + min);
		  //System.out.println("Cost Function " + costFunction);
			//costFunction.clear();
			// insert the vertex to particular partition here
			
			//System.out.println("Cost Function "+costFunction );
			
				/*int partIndexMin = 0;
				int partitionValue = partition[0].size();
				for (int x = 0; x < numpartition; x++) {
					if (partitionValue > partition[x].size()) {
						partIndexMin = x;
					}
				}*/
			
			
			int minIndex=0;
			int newNumber = costFunction.get(0);
			for (int x= 0; x<numpartition; x++){		
				if(newNumber> costFunction.get(x)){
					minIndex = x;
				}
				
			}
			//System.out.println("Inserting into the partition------------------------------------------------------ "+ minIndex+" "+entry.getKey() );
			partition[minIndex].put(entry.getKey(), entry.getValue());
			costFunction.clear();
			// finalCost=0;

		}
		
		//for(int x =0; x<numpartition;x++){
			//partitionEdge[x].clear();
		//}
		/*for (int a = 0; a < numpartition; a++) {
			for (int y = 0; y < numpartition; y++) {
				if (y == a) {
					continue;
				}
				//System.out.println("a value  " + a + "y value " + y);
				for (Map.Entry<Integer, List<Integer>> entry1 : partition[a].entrySet()) {
					// System.out.println("--------"+ a);
					for (Map.Entry<Integer, List<Integer>> entry2 : partition[y].entrySet()) {
						// System.out.println("---2nd---"+ (y));
						for (int x = 0; x < entry2.getValue().size(); x++) {
							// for(int y=0;y<4;y++){
							// System.out.println("value "+entry.getValue());
							if (entry1.getKey().equals(entry2.getValue().get(x))) {
								// if((entry1.getKey().equals(entry.getValue().get(x)))||(entry1.getKey().equals(entry.getValue().get(x)))){
								//System.out.println(" in count " + entry1.getKey());
								if(!partitionEdge[a].containsKey(y)){
									partitionEdge[a].put((y),1);
									}else {
										partitionEdge[a].put((y),partitionEdge[a].get(y)+1);
									}
							}
						}
					}
				}
				
				//edgeCount[a].add(count1);
				
			}
			//System.out.println("edgeeeeee "+partitionEdge[a]);
		}*/
	}

public static void getBalance(){
	// Statndard Deviation  
    double sum=0, mean=0;  
    for (int i=0; i<numpartition; i++) //Take input in the array  
   {  
         sum+=partition[i].size(); //sum of all elements  
   }  
    mean=sum/numpartition;  
    sum=0;       
    double [] temp= new double[numpartition];  
    for (int i=0; i<numpartition; i++) //calculate standard deviation  
   {  
         temp[i]=Math.pow((partition[i].size()-mean),2);  
         sum+=temp[i];  
   }  
    mean=sum/numpartition;  
    deviation=Math.sqrt(mean);  
	  System.out.println("Load Imbalance "+deviation);
	
	
	// number of neighbour of a vertex N(v)
	//pti initial partitioning at time t
	//CE(pj, pi) set of cut edge
}
public static void getEdgecut(){
	
	
	for (int a = 0; a < numpartition; a++) {
		for (int y = 0; y < numpartition; y++) {
			if (y == a) {
				continue;
			}
			//System.out.println("a value  " + a + "y value " + y);
			for (Map.Entry<Integer, List<Integer>> entry1 : partition[a].entrySet()) {
				// System.out.println("--------"+ a);
				for (Map.Entry<Integer, List<Integer>> entry2 : partition[y].entrySet()) {
					// System.out.println("---2nd---"+ (y));
					for (int x = 0; x < entry2.getValue().size(); x++) {
						// for(int y=0;y<4;y++){
						// System.out.println("value "+entry.getValue());
						if (entry1.getKey().equals(entry2.getValue().get(x))) {
							// if((entry1.getKey().equals(entry.getValue().get(x)))||(entry1.getKey().equals(entry.getValue().get(x)))){
							//System.out.println(" in count " + entry1.getKey());
							if(!partitionEdge[a].containsKey(y)){
								partitionEdge[a].put((y),1);
								}else {
									partitionEdge[a].put((y),partitionEdge[a].get(y)+1);
								}
						}
					}
				}
			}
			
			//edgeCount[a].add(count1);
			
		}
		//System.out.println("edgeeeeee "+partitionEdge[a]);
	}
	List<Integer> partEdge1 = new LinkedList<>();
	//List<Integer> partEdge = new LinkedList<>();
	for(int x=0;x<partitionEdge.length;x++){
		//int value = partitionEdge[x].values();
		partEdge1.addAll(partitionEdge[x].values());
	}
	int sum=0;
	for(int x=0;x<partEdge1.size();x++){
		sum = sum + partEdge1.get(x);	
	}
	System.out.println("number of edge cut "+sum/2);
	
	for(int x=0; x<numpartition;x++){
		System.out.println(" partition "+x+" and the size "+partition[x].size());
		
	}
	//for(int x=0; x<numpartition;x++){
		//System.out.println(" Element in partition "+x+"   "+partition[x]);
	//}
	
}
public static void vertexDeletion(){
	
	//partition[0].remove(6);
	// finding the boundary vertex
	for (int a = 0; a < numpartition; a++) {
		for (int y = 0; y < numpartition; y++) {
			if (y == a) {
				continue;
			}
			//System.out.println("a value  " + a + "y value " + y);
			for (Map.Entry<Integer, List<Integer>> entry1 : partition[a].entrySet()) {
				// System.out.println("--------"+ a);
				for (Map.Entry<Integer, List<Integer>> entry2 : partition[y].entrySet()) {
					// System.out.println("---2nd---"+ (y));
					for (int x = 0; x < entry2.getValue().size(); x++) {
						// for(int y=0;y<4;y++){
						// System.out.println("value "+entry.getValue());
						if (entry1.getKey().equals(entry2.getValue().get(x))) {
							boundaryVertex[a].put(entry1.getKey(),entry1.getValue());
							
							// if((entry1.getKey().equals(entry.getValue().get(x)))||(entry1.getKey().equals(entry.getValue().get(x)))){
							//System.out.println(" in count " + entry1.getKey());
							
						}
					}
				}
			}
			
			//edgeCount[a].add(count1);	
		}
	}
	
	
	
	
	
	//System.out.println("Boundary vertex "+boundaryVertex[0]);
		
}

	public static void vertexDegree() {
		// vertex will migrate to the partition where the vertex was deleted
		// vertex will come from the partition with higher capacity
		Random random = new Random();
		Integer randomKey = 0;
		int migratedVertex = 0;
		
		/*for (int p = 0; p < numpartition; p++) {
			List<Integer> keys = new ArrayList<Integer>(partition[p].keySet());
			for (int i = 0; i < 300; i++) {
				if(!partition[p].isEmpty()){
				randomKey = keys.get(random.nextInt(keys.size()));
				// Object randomValue = someHashMap.get(randomKey);
				partition[p].remove(randomKey);
				}
				 }
				 }*/

		for(int c=0;c<300;c++) {
		//while(deviation>300){
				// while (deviation>30){
				int maxPartition = 0;
				int temp = partition[0].size();
				for (int x = 1; x < numpartition; x++) {
					if (temp < partition[x].size()) {
						temp = partition[x].size();
						maxPartition = x;
					}
				}
				int minPartition = 0;
				int temp1 = partition[0].size();
				for (int x = 1; x < numpartition; x++) {
					if (temp1 > partition[x].size()) {
						temp1 = partition[x].size();
						minPartition = x;
					}
				}
				
				Map<Integer, Integer> findMax = new HashMap<>();

				int num = 0;
				
				Set<Integer> migratedEdge = null;
				// List<Integer> migratedEdge = null;
				List<Integer> ls = null;
				// System.out.println("Highest partition "+ maxPartition);
				for (Map.Entry<Integer, List<Integer>> entry : boundaryVertex[maxPartition].entrySet()) {
					ls = new LinkedList<Integer>();
					for (int x = 0; x < numpartition; x++) {

						Set<Integer> set = new HashSet(partition[x].keySet());
						set.retainAll(entry.getValue());
						if (num < set.size()) {
							num = set.size();
							ls.addAll(entry.getValue());
							migratedVertex = entry.getKey();
							migratedEdge = new HashSet<Integer>(ls);
							// migratedEdge = ls;

						}
						// System.out.println("x value " + x+ " Y value is "+y);

					}
				}
				if(migratedEdge!=null){
				List<Integer> lis = new ArrayList<Integer>(migratedEdge);
			// System.out.println("vertex" +migratedVertex+ " with the edge "+ migratedEdge+ " to the partition "+ minPartition );

				partition[minPartition].put(migratedVertex, lis);
					}
				partition[maxPartition].remove(migratedVertex);
				boundaryVertex[maxPartition].remove(migratedVertex);
			//}
				getBalance();
				//for (int x = 0; x < numpartition; x++) {
				//	System.out.println(" Partition Size after migration " + x + "   " + partition[x].size());
				//}
		}

		for (int x = 0; x < numpartition; x++) {
			System.out.println(" Partition Size after migration " + x + "   " + partition[x].size());
		}

		//for (int x = 0; x < numpartition; x++) {
			// System.out.println(" Partition Size after migration "+x+"
			// "+partition[x]);
	//	}
		// }
		
		//getEdgecut();
	}
}
