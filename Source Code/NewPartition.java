/*
 * 
To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *///
package algorithm;

/**
 *
 * @author mpatwary
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Map.Entry;

	public class NewPartition {
	private static final int MAX_ENTRIES =3;
	private static final int numpartition = 2;
	private static final int parameter =150;
	private static int partitionNumber;
	public static Map<Integer, List<Integer>> partition[];
	public static Map<Integer, List<Integer>> tempMap= new HashMap<>();
	public static int edgeCount = 0;
	public static Set<Integer> numOfEdge = new HashSet<>();
	public static double deviation = 0.0;
	public static Map<Integer, Integer> partitionEdge[];
	static public LinkedHashMap<Integer, List<Integer>> window = new LinkedHashMap(MAX_ENTRIES + 1, .75F, false) {
		protected boolean removeEldestEntry(Map.Entry eldest) {
			return size() > MAX_ENTRIES;
		}
	};
	public static void main(String args[]) throws FileNotFoundException {
		partition = new HashMap[numpartition];
		for (int x = 0; x < numpartition; x++) {
			partition[x] = new HashMap<>();
		}
		partitionEdge = new HashMap[numpartition];
		for (int y = 0; y < numpartition; y++) {
			partitionEdge[y] = new HashMap<>();
		}
		
		
		long start = System.currentTimeMillis();
		readFile();
		processRest();
		long stop = System.currentTimeMillis();
		long totalTime = stop - start;
		// getPartition();
		// for(int x=0;x<numpartition;x++){
		// System.out.println("Partition :"+x+" Element: "+ partition[x]);
		// }
		System.out.println(" Window Size: " + MAX_ENTRIES);
		System.out.println(" Balanced parameter : " + parameter);
		System.out.println(" Number of Partition : " + numpartition);
		System.out.println(" Total time taken is " + totalTime);
		// System.out.println("Edge Cut : "+edgeCount);
		/// Standard Deviation
		// find sum
		loadImbalance();
		getEdgeCut();
		
		for (int x = 0; x < numpartition; x++) {
			System.out.println(" partition " + x + " and the size " + partition[x].size());
		}
		//for (int x = 0; x < numpartition; x++) {
			//System.out.println(" partition " + x + " and the Elements are : " + partition[x]);
		//}
	}

	public static boolean check() {
		int count = 0;
		for (int x = 0; x < numpartition; x++) {
			if (partition[x].size() == 0) {
				count++;
			}
		}
		if (count == numpartition) {
			return true;
		} else {
			return false;
		}
	}

	// Finding imbalance
	public static void loadImbalance (){
		double sum = 0, mean = 0;
		for (int i = 0; i < numpartition; i++) // Take input in the array
		{
			sum += partition[i].size(); // sum of all elements
		}
		mean = sum / numpartition;
		sum = 0;
		double[] temp = new double[numpartition];
		for (int i = 0; i < numpartition; i++) // calculate standard deviation
		{
			temp[i] = Math.pow((partition[i].size() - mean), 2);
			sum += temp[i];
		}
		mean = sum / numpartition;
		deviation = Math.sqrt(mean);
		System.out.println("Load Imbalance : " + deviation);	
	}
	public static boolean loadBalance() {
		int max = 0;
		List<Integer> diff = new LinkedList<Integer>();
		for (int x = 0; x < numpartition; x++) {
			if (partition[x].size() > max) {
				max = partition[x].size();
			}
		}
		for (int x = 0; x < numpartition; x++) {
			int value = max - partition[x].size();
			diff.add(value);
		}
		int x = 0;
		x = Collections.max(diff);
		// System.out.println("x value in balance.........................."+x);
		if (x >= parameter) {
			
			//System.out.println("Load Balance x value "+x);
			return true;
			
		} else {
			//System.out.println("Load Balance x value else "+x);
			return false;
		}
	}

	public static void readFile() throws FileNotFoundException {
		// -----------------------------------------------------------------------------------------------------------------------------------------------------Read
		// Input
		//Scanner sc = new Scanner(new File("/Users/Anwarul/Documents/workspace/First_algorithm_stream/src/algorithm/AstroPh.txt"));
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(new File("C:/Users/mpatwary/Desktop/workspace1/graphparr/src/test5.txt"));
		//Scanner sc = new Scanner(new File("/Users/mpatwary/eclipse-workspace/Research/src/algorithm/test4.txt"));
		// read stream
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
			// System.out.println(alist);
			getPartition(alist);
		}
	}
	public static  int getMinimum() {
		int partIndexMin =0;
		int partitionValue = partition[0].size();
		for (int x = 0; x < numpartition; x++) {	
			if (partitionValue > partition[x].size()) {
				partIndexMin = x;
			}
		}
		return partIndexMin;
		
	}
	public static void getPartition(LinkedList<Integer> list) throws FileNotFoundException {

		Random random = new Random();

		int CandidateIndex = 0;
		int BufferedIndex = 0;

	
		/*if (window.containsKey(list.getFirst())) {
			window.get(list.getFirst()).addAll(list.subList(1, list.size()));
		} else {
			List<Integer> to = new ArrayList<Integer>();
			to.addAll(list.subList(1, list.size()));
			window.put(list.getFirst(), to);
		}*/

		 window.put(list.getFirst(), list.subList(1, list.size()));
		int candidateVertex = 0;

		// FIND the partition index with highest number of vertices
		int partindex = 0;
		for (int x = 0; x < numpartition; x++) {
			int newNumber = partition[x].size();
			if (newNumber > partition[partindex].size()) {
				partindex = x;
			}
		}
		//Find the minimum partition
		int partIndexMin =getMinimum();
	/*	int partitionValue = partition[0].size();
		for (int x = 0; x < numpartition; x++) {	
			if (partitionValue > partition[x].size()) {
				partIndexMin = x;
			}
		}*/
		Map.Entry<Integer, List<Integer>> iter = (Entry<Integer, List<Integer>>) window.entrySet().iterator().next();
		// Map.Entry<Integer, List<Integer>> iter = (Entry<Integer,
		// List<Integer>>) window.entrySet().iterator().next();
		candidateVertex = iter.getKey();
		//List<Integer> candidateEdges = new LinkedList<Integer>(window.get(candidateVertex));
		List<Integer>candidateEdges = iter.getValue();
		 //System.out.println("candidate edge "+candidateEdges);
		
		// System.out.println("Window "+ window);
		if (window.size() == MAX_ENTRIES) {
			// Check balance
			// System.out.println("Window "+ window);
			// System.out.println("window"+ window);
			// Map.Entry<Integer, List<Integer>> iter1 = (Entry<Integer,
			// List<Integer>>) window.entrySet().iterator().next();
			// System.out.println("window edge "+ iter1.getValue());
			// loadImbalance();
			boolean checkBalance = loadBalance();
			// System.out.println("Checking balance"+checkBalance);
			// check all the partitions are empty
			boolean checkEmptyPartition = check();
			//System.out.println("checkBalance "+checkBalance);
			//System.out.println("checkEmptyPartition "+checkEmptyPartition);
			//System.out.println(checkEmptyPartition);
			if (checkEmptyPartition == true) {
				// send randomly
				
				//partitionNumber = 0;
				 partitionNumber = random.nextInt(numpartition);
				 System.out.println("in empty section");
			} else if (checkBalance == true) {
				// System.out.println("in empty section");
				// end of else of check partition
				// else send to the partitions except the partition has the
				// highest number of vertices
				// -------------------------------------------------------------
				// System.out.println("In balance is true " + candidateVertex);
				// System.out.println("processing in Balanced section");
				//System.out.println("maximum partition index : " + partindex);
				List<Integer> balance1 = new ArrayList<Integer>();
				//balance1.add(0);
				int maxValue = 0;
				for (int x = 0; x < numpartition; x++) {
					// ignoring the partition with highest number of vertices
					// (need to fix)
					if (x == partindex) {
						continue;
					}
					// intersect the edges between in the partition and the
					// edges
					// with incoming vertex
					//System.out.println("Loop main "+ x);
					Set<Integer> set = new HashSet<Integer>(partition[x].keySet());
					set.retainAll(candidateEdges);
					int intersect = set.size();
					//System.out.println(" x value  : "+x);
					if (intersect > maxValue) {
						maxValue = intersect;
						CandidateIndex = x;
						//partitionNumber= CandidateIndex;
						balance1.clear();
						balance1.add(x);
						//System.out.println("Loop main candidate index inside "+CandidateIndex );
					} else if (intersect == maxValue){
						balance1.add(x);
						int min = partition[balance1.get(0)].size(); 
						//System.out.println(" sizeeeee : "+balance1);
						for(int b=0;b<balance1.size();b++){
						if(partition[balance1.get(b)].size()<min){
							//System.out.println(" x value inside iffff : "+x);
							min = partition[balance1.get(b)].size();
							CandidateIndex = balance1.get(b);
							//partitionNumber= CandidateIndex;
						}
						}
					}/*else {
						int alreadyPickedNumber=partindex; //Number to exclude
						int number=random.nextInt(numpartition);
						while(number==alreadyPickedNumber){
						         number=random.nextInt(numpartition);
						    }
						    CandidateIndex = number;
						   // System.out.println("In random ---"+ CandidateIndex);
						    //partitionNumber = number;
					}*/
				}
				//System.out.println("Loop main candidate index "+CandidateIndex+" Max Value "+maxValue );
				////
				// end of finding index
				// -------End of Finding maximum number of edges and partition
				// index
				// of candidate vertex
				// get the partition number with minimum load
				// int nimumLoad =
				// getMinimumLoad();------------------------------------- (need
				// to fix)
				// finding the buffered vertex of a candidate vertex
				// iterate through whole window
				List<Integer> balance2 = new ArrayList<Integer>();
				List<Integer> removePurpose = new ArrayList<Integer>();
				//balance2.add(0);
				int maxiumBuffered = 0;
				tempMap.put(candidateVertex,candidateEdges);
				for (Map.Entry<Integer, List<Integer>> entry : window.entrySet()) {
					// iterate through the all edges of candidate vertex to find
					// a
					// connection of candidate vertex from the window
					// System.out.println("Candidate Edges
					// "+candidateEdges.size());
					for (int x = 0; x < candidateEdges.size(); x++) {
						//System.out.println(" key "+ entry.getKey()+ " value "+ entry.getValue());
						if (candidateEdges.get(x).equals(entry.getKey())) {
							
							tempMap.put(entry.getKey(),entry.getValue());
							removePurpose.add(entry.getKey());
							
							int intersect = 0;
							for (int a = 0; a < numpartition; a++) {
								if (a == partindex) {
									continue;
								}
								// intersect the edges between in the partition
								// and
								// the edges
								// with incoming vertex
								//System.out.println("Loop buffer "+ a);
								Set<Integer> set = new HashSet<Integer>(partition[a].keySet());
								// System.out.println("---"+entry.getValue());
								set.retainAll(entry.getValue());
								// System.out.println(set);
								intersect = set.size();
								// System.out.println(intersect);
								if (intersect > maxiumBuffered) {
									maxiumBuffered = intersect;
									BufferedIndex = a;
									//partitionNumber= BufferedIndex;
									balance2.clear();
									balance2.add(a);
									//System.out.println("Loop main buffered index inside "+BufferedIndex );
								}else if (intersect == maxiumBuffered){
									balance2.add(a);
									int min = partition[balance2.get(0)].size(); 
									for(int b=0;b<balance2.size();b++){
									if(partition[balance2.get(b)].size()<min){
										min = partition[balance2.get(b)].size();
										BufferedIndex = balance2.get(b);
										//partitionNumber= BufferedIndex;
									}
									}
								}/*else {
									int alreadyPickedNumber=partindex; //Number to exclude
									    int number=random.nextInt(numpartition);
									    while(number==alreadyPickedNumber){
									         number=random.nextInt(numpartition);
									    }
									    BufferedIndex = number;
									    //System.out.println("In random buffered "+BufferedIndex );
									//  partitionNumber = number;
								}*/
							}
							
						}
					}
				}
				
				window.keySet().removeAll(removePurpose);
				removePurpose.clear();
				/*Set<Integer> countVertex = new HashSet<Integer>();
				int maximumVertex=0;
				int newCandidateIndex=0;
				List<Integer> vertexTemp = new ArrayList<Integer> ();
				for (Map.Entry<Integer, List<Integer>> entry : window.entrySet()) {
					// iterate through the all edges of candidate vertex to find a
					// connection of candidate vertex from the window
					// System.out.println("----------yes-----"+entry.getKey());
					for (int x = 0; x < entry.getValue().size(); x++) {
						//System.out.println(entry.getKey());
						if (candidateVertex==entry.getValue().get(x)) {	
							countVertex.add(entry.getKey());			
						}
					}
				}
				System.out.println("Count Vertex " +countVertex);
				for (int a = 0; a < numpartition; a++) {
					// intersect the edges between in the partition and
					// the edges
					// with incoming vertex
					
					if (a == partindex) {
						continue;
					}
					Set<Integer> set = new HashSet<Integer>(partition[a].keySet());
					set.retainAll(countVertex);
					int intersect = set.size();
					System.out.println("Intersect sizeeee in balanced  "+intersect );
					if (intersect > maximumVertex) {
						maximumVertex = intersect;
						newCandidateIndex = a;
						//partitionNumber= BufferedIndex;
						vertexTemp.clear();
						vertexTemp.add(a);
					}else if (intersect == maximumVertex){
						vertexTemp.add(a);
						int min = partition[vertexTemp.get(0)].size();
						for(int b=0;b<vertexTemp.size();b++){
						if(partition[vertexTemp.get(b)].size()<min){
							min = partition[vertexTemp.get(b)].size();
							newCandidateIndex = vertexTemp.get(b);
							//partitionNumber= BufferedIndex;
						}
						}
					}
				}*/
				
				//System.out.println("temp map in main "+ tempMap);
				
				
				//System.out.println("Loop main buffered index "+BufferedIndex+"maxiumBuffered   "+ maxiumBuffered  );
				//System.out.println("In Balanced");				
				// Finding and assigning a vertex to a partition
				 if (maxValue > maxiumBuffered) {
					partitionNumber = CandidateIndex;
				} else if (maxValue < maxiumBuffered) {
					partitionNumber = BufferedIndex;
				} else if ((maxValue == maxiumBuffered)&&(maxValue!=0)&&(maxiumBuffered!=0)) {
					// send to the partition has minimum load
						partitionNumber = CandidateIndex;
				} else if ((maxValue == 0) && (maxiumBuffered == 0)) {
					// send to the partition has minimum load
						partitionNumber = CandidateIndex;
				}/*else {
					/*int alreadyPickedNumber=partindex; //Number to exclude
					int number=random.nextInt(numpartition);
					while(number==alreadyPickedNumber){
					         number=random.nextInt(numpartition);
					    }
					    CandidateIndex = number;
					    System.out.println("In random ---"+ CandidateIndex);
					    
						partitionNumber = CandidateIndex;
					    //partitionNumber = number;
				} */	
			////////////////////////////////////////////////////////////////////////////----------------------- Balanced starts here
		} else {
			// Finding maximum number of edges and partition index of candidate
			// vertex
			// System.out.println("after checking balance");
			// System.out.println(" when balanced here with "+ candidateVertex);
			//System.out.println("maximum partition index : " + partindex);
			List<Integer> nonbalance = new ArrayList<Integer>();
			//nonbalance.add(0);
			int maxValue = 0;
			for (int x = 0; x < numpartition; x++) {
				// intersect the edges between in the partition and the edges
				// with incoming vertex
				Set<Integer> set = new HashSet<Integer>(partition[x].keySet());
				set.retainAll(candidateEdges);
				int intersect = set.size();
				if (intersect > maxValue) {
					maxValue = intersect;
					CandidateIndex = x;
					///partitionNumber= CandidateIndex;
					nonbalance.clear();
					nonbalance.add(x);
				}else if (intersect == maxValue){
					nonbalance.add(x);
					int min = partition[nonbalance.get(0)].size();  
					for(int b=0;b<nonbalance.size();b++){
					if(partition[nonbalance.get(b)].size()<min){
						min = partition[nonbalance.get(b)].size();
						CandidateIndex = nonbalance.get(b);
						//partitionNumber= CandidateIndex;
					}
					}
				}/*else {
					  int number=random.nextInt(numpartition);
					  CandidateIndex = number;
					  //System.out.println("In random - + "+ CandidateIndex);
					  //partitionNumber = number;
				}*/
			}
			// -------End of Finding maximum number of edges and partition index
			// of candidate vertex
			// get the partition number with minimum load
			// int nimumLoad = getMinimumLoad();
			// finding the buffered vertex of a candidate vertex
			// iterate through whole window
			tempMap.put(candidateVertex,candidateEdges);
			List<Integer> nonbalance1 = new ArrayList<Integer>();
			List<Integer> removePurpose = new ArrayList<Integer>();
			
			//nonbalance1.add(0);
			int maxiumBuffered = 0;
			for (Map.Entry<Integer, List<Integer>> entry : window.entrySet()) {
				// iterate through the all edges of candidate vertex to find a
				// connection of candidate vertex from the window
				// System.out.println("----------yes-----"+entry.getKey());
				for (int x = 0; x < candidateEdges.size(); x++) {
					//System.out.println(entry.getKey());
					//System.out.println(" key "+ entry.getKey()+ " value "+ entry.getValue());
					if (candidateEdges.get(x).equals(entry.getKey())) {
						tempMap.put(entry.getKey(),entry.getValue());
						removePurpose.add(entry.getKey());
						
						for (int a = 0; a < numpartition; a++) {
							// intersect the edges between in the partition and
							// the edges
							// with incoming vertex
							//System.out.println("---value -- " + entry.getValue());
							Set<Integer> set = new HashSet<Integer>(partition[a].keySet());
							set.retainAll(entry.getValue());
							int intersect = set.size();
							if (intersect > maxiumBuffered) {
								maxiumBuffered = intersect;
								BufferedIndex = a;
								//partitionNumber= BufferedIndex;
								nonbalance1.clear();
								nonbalance1.add(a);
							}else if (intersect == maxiumBuffered){
								nonbalance1.add(a);
								int min = partition[nonbalance1.get(0)].size();
								for(int b=0;b<nonbalance1.size();b++){
								if(partition[nonbalance1.get(b)].size()<min){
									min = partition[nonbalance1.get(b)].size();
									BufferedIndex = nonbalance1.get(b);
									//partitionNumber= BufferedIndex;
								}
								}
							}/*else {
								    int number=random.nextInt(numpartition);
								    BufferedIndex = number;
								    //partitionNumber = number;
								    //System.out.println("In random buffered -"+BufferedIndex); 
							}*/
						}
						//System.out.println("BufferedIndex in loop " + BufferedIndex);
						
					}
				}
			}
			// New Checking 
			// removing vertex from  the window
			window.keySet().removeAll(removePurpose);
			removePurpose.clear();
			
		/*	Set<Integer> countVertex = new HashSet<Integer>();
			int maximumVertex=0;
			int newCandidateIndex=0;
			List<Integer> vertexTemp = new ArrayList<Integer> ();
			for (Map.Entry<Integer, List<Integer>> entry : window.entrySet()) {
				// iterate through the all edges of candidate vertex to find a
				// connection of candidate vertex from the window
				// System.out.println("----------yes-----"+entry.getKey());
				for (int x = 0; x < entry.getValue().size(); x++) {
					//System.out.println(entry.getKey());
					if (candidateVertex==entry.getValue().get(x)) {	
						countVertex.add(entry.getKey());			
					}
				}
			}
			System.out.println("Count Vertex " +countVertex);
			for (int a = 0; a < numpartition; a++) {
				// intersect the edges between in the partition and
				// the edges
				// with incoming vertex
				//System.out.println("---value -- " + entry.getValue());
				Set<Integer> set = new HashSet<Integer>(partition[a].keySet());
				set.retainAll(countVertex);
				int intersect = set.size();
				System.out.println("Intersect sizeeee in non-balanced  "+intersect );
				if (intersect > maximumVertex) {
					maximumVertex = intersect;
					newCandidateIndex = a;
					//partitionNumber= BufferedIndex;
					vertexTemp.clear();
					vertexTemp.add(a);
				}else if (intersect == maximumVertex){
					vertexTemp.add(a);
					int min = partition[vertexTemp.get(0)].size();
					for(int b=0;b<vertexTemp.size();b++){
					if(partition[vertexTemp.get(b)].size()<min){
						min = partition[vertexTemp.get(b)].size();
						newCandidateIndex = vertexTemp.get(b);
						//partitionNumber= BufferedIndex;
					}
					}
				}
			}*/
			
			//System.out.println("BufferedIndex " + BufferedIndex);
			//System.out.println("BufferedIndex " + BufferedIndex + "maxiumBuffered  " + maxiumBuffered + " Max value"
			//+ maxValue + "candidate Index" + CandidateIndex);
			//find the partition index
			//System.out.println("temp map in main "+ tempMap);
			if (maxValue > maxiumBuffered) {
				partitionNumber = CandidateIndex;
			} else if (maxValue < maxiumBuffered) {
				partitionNumber = BufferedIndex;
			} else if ((maxValue == maxiumBuffered)&&(maxValue!=0)&&(maxiumBuffered!=0)) {
				// send to the partition has minimum load
					partitionNumber = CandidateIndex;
			} else if ((maxValue == 0) && (maxiumBuffered == 0)) {
				// send to the partition has minimum load
				partitionNumber = CandidateIndex;
			}/*else {
			//  int number=random.nextInt(numpartition);
			  //CandidateIndex = number;
			  //System.out.println("In random - + "+ CandidateIndex);
			  partitionNumber = CandidateIndex;
			}*/
		}
		// for(int x=0;x<numpartition;x++){
		// System.out.println("Elements : "+partition[2]+ " size "+
		// partition[2].size());
		// }
			
		//System.out.println("partition number ---------------------------------------------------------------: " + partitionNumber+ "--------"+candidateVertex);
		int count = 0;
		if(tempMap.isEmpty()){
			for (int y = 0; y < numpartition; y++) {
				// for(int i =0; i<=partition[y].size();i++){
				// System.out.println("----"+edgeCount[0].get(i));
				if (!partition[y].containsKey(candidateVertex)) {
					// System.out.println(x);
					count++;
					// partition[partitionNumber].add(candidateVertex);
					// System.out.println(edgeCount[0]);
				}
				// }
			}
			
				if(count == numpartition) {
					if (checkBalance == true) {
					partition[partIndexMin].put(candidateVertex,candidateEdges);
					} else {
					
					partition[partitionNumber].put(candidateVertex,candidateEdges);
				
				}
			
				}
			
		}else {
			for (int y = 0; y < numpartition; y++) {
				// for(int i =0; i<=partition[y].size();i++){
				// System.out.println("----"+edgeCount[0].get(i));
				if(!partition[y].keySet().containsAll(tempMap.keySet())){
				//if (!partition[y].containsKey(tempMap)) {
					// System.out.println(x);
					count++;
					// partition[partitionNumber].add(candidateVertex);
					// System.out.println(edgeCount[0]);
				}
				// }
			}
			//if (count == numpartition) {
				//partition[partitionNumber].putAll(tempMap);
			//}
				if(count == numpartition) {
					
						for (Map.Entry<Integer, List<Integer>> entry2 : tempMap.entrySet()) {
							//checkBalance = loadBalance();
							//partIndexMin=getMinimum();
							if (checkBalance == true) {
							partition[partIndexMin].put(entry2.getKey(), entry2.getValue());
							} else {
							partition[partitionNumber].put(entry2.getKey(), entry2.getValue());
						
						
					}
				}
		}
		}
	
		//System.out.println("Temo map is "+tempMap+" Candidate Vertex is "+candidateVertex);
		tempMap.clear();
	}
	}

	public static void processRest() {
		Random random = new Random();
		int CandidateIndex = 0;
		int BufferedIndex = 0;
		int candidateVertex = 0;
		// FIND the partition index with highest number of vertices
		int partindex = 0;
		for (int x = 0; x < numpartition; x++) {
			int newNumber = partition[x].size();
			if (newNumber > partition[partindex].size()) {
				partindex = x;
			}
		}
		
		/*int partIndexMin =0;
		int partitionValue = partition[0].size();
		for (int x = 0; x < numpartition; x++) {	
			if (partitionValue > partition[x].size()) {
				partIndexMin = x;
			}
		}*/
		
		int partIndexMin =getMinimum();
		System.out.println("minimum index uppp "+partIndexMin );
		Map.Entry<Integer, List<Integer>> iter1 = (Entry<Integer, List<Integer>>) window.entrySet().iterator().next();
		// Map.Entry<Integer, List<Integer>> iter = (Entry<Integer,
		// List<Integer>>) window.entrySet().iterator().next();
		window.remove(iter1.getKey());
		// System.out.println("after removing "+ window);
		for (Map.Entry<Integer, List<Integer>> iter : window.entrySet()) {
			// loadBalance();
			candidateVertex = iter.getKey();
			List<Integer> candidateEdges = iter1.getValue();
			// System.
			// System.out.println("Window "+ window);
			// System.out.println(" process rest "+ candidateVertex);
			// Check balance
				boolean checkBalance = loadBalance();
			// System.out.println("Checking balance--------------
			// "+checkBalance);
			// check all the partitions are empty
			//boolean checkEmptyPartition = check();
			// System.out.println(checkEmptyPartition);
				if (checkBalance == true) {
				// end of else of check partition
				// else send to the partitions except the partition has the
				// highest number of vertices
				// -------------------------------------------------------------				
				// System.out.println("Balanced section process rest");
				List<Integer> balance3 = new ArrayList<Integer>();
				 //balance3.add(0);
				int maxValue = 0;
				for (int x = 0; x < numpartition; x++) {
					// ignoring the partition with highest number of vertices
					// (need to fix)
					if (x == partindex) {
						continue;
					}
					// intersect the edges between in the partition and the
					// edges
					// with incoming vertex
					Set<Integer> set = new HashSet<Integer>(partition[x].keySet());
					set.retainAll(candidateEdges);
					int intersect = set.size();
					if (intersect > maxValue) {
						maxValue = intersect;
						CandidateIndex = x;
						//partitionNumber= CandidateIndex;
						balance3.clear();
						balance3.add(x);
					}else if (intersect == maxValue){
						balance3.add(x);
						int min = partition[balance3.get(0)].size();
						for(int b=0;b<balance3.size();b++){
						if(partition[balance3.get(b)].size()<min){
							min = partition[balance3.get(b)].size();
							CandidateIndex = balance3.get(b);
							//partitionNumber= CandidateIndex;
						}
						}
					} /*else {
						 int alreadyPickedNumber=partindex; //Number to exclude
						    int number=random.nextInt(numpartition);
						    while(number==alreadyPickedNumber){
						         number=random.nextInt(numpartition);
						    }
						    CandidateIndex = number;
						    //partitionNumber = number;
					}*/
				}
				////
				// end of finding index
				// -------End of Finding maximum number of edges and partition
				// index
				// of candidate vertex
				// get the partition number with minimum load
				// int nimumLoad =
				// getMinimumLoad();------------------------------------- (need
				// to fix)
				// finding the buffered vertex of a candidate vertex
				// iterate through whole window
				tempMap.put(candidateVertex,candidateEdges);
				List<Integer> balance4 = new ArrayList<Integer>();
				List<Integer> removePurpose = new ArrayList<Integer>();
				//balance4.add(0);
				int maxiumBuffered = 0;
				for (Map.Entry<Integer, List<Integer>> entry : window.entrySet()) {
					// iterate through the all edges of candidate vertex to find
					// a
					// connection of candidate vertex from the window
					// System.out.println("Candidate Edges
					// "+candidateEdges.size());
					for (int x = 0; x < candidateEdges.size(); x++) {
						//System.out.println(" key in process "+ entry.getKey()+ " value "+ entry.getValue());
						if (candidateEdges.get(x).equals(entry.getKey())) {
							tempMap.put(entry.getKey(), entry.getValue());
							removePurpose.add(entry.getKey());
							//window.remove(entry.getKey());
							int intersect = 0;
							for (int a = 0; a < numpartition; a++) {
								if (a == partindex) {
									continue;
								}
								// intersect the edges between in the partition
								// and
								// the edges
								// with incoming vertex
								Set<Integer> set = new HashSet<Integer>(partition[a].keySet());
								// System.out.println("---"+entry.getValue());
								set.retainAll(entry.getValue());
								// System.out.println(set);
								intersect = set.size();
								// System.out.println(intersect);
								if (intersect > maxiumBuffered) {
									maxiumBuffered = intersect;
									BufferedIndex = a;
									//partitionNumber= BufferedIndex;
									balance4.clear();
									balance4.add(a);
								}else if (intersect == maxiumBuffered){
									balance4.add(a);
									int min = partition[balance4.get(0)].size();
									//System.out.println(balance4.size());
									for(int b=0;b<balance4.size();b++){
									if(partition[balance4.get(b)].size()<min){
										min = partition[balance4.get(b)].size();
										BufferedIndex = balance4.get(b);
										//partitionNumber = BufferedIndex;
									}
									}	
								}/*else {
									 int alreadyPickedNumber=partindex; //Number to exclude
									    int number=random.nextInt(numpartition);
									    while(number==alreadyPickedNumber){
									         number=random.nextInt(numpartition);
									    }
									    BufferedIndex = number;
									    //partitionNumber = number;
								}*/
							}
							//window.remove(entry.getKey());
						}
						//balance4.clear();
					}
				}
				window.keySet().removeAll(removePurpose);
				removePurpose.clear();
				//System.out.println("temp map  "+ tempMap);
				// Finding and assigning a vertex to a partition
				if (maxValue > maxiumBuffered) {
					partitionNumber = CandidateIndex;
				} else if (maxValue < maxiumBuffered) {
					partitionNumber = BufferedIndex;
				} else if ((maxValue == maxiumBuffered)&&(maxValue!=0)&&(maxiumBuffered!=0)) {
					// send to the partition has minimum load
						partitionNumber = CandidateIndex;
				} else if ((maxValue == 0) && (maxiumBuffered == 0)) {
					// send to the partition has minimum load
						partitionNumber = CandidateIndex;
				}/* else {
				/* int alreadyPickedNumber=partindex; //Number to exclude
			    int number=random.nextInt(numpartition);
			    while(number==alreadyPickedNumber){
			         number=random.nextInt(numpartition);
			    }
			    //CandidateIndex = number;
			    partitionNumber = CandidateIndex;
				}*/
				////////////////////////////////////////////////////////////////////////////Balanced Starts 
			} else {
				// Finding maximum number of edges and partition index of
				// candidate
				// vertex
				// System.out.println("after checking balance");
				List<Integer> nonbalance2 = new ArrayList<Integer>();
				//nonbalance2.add(0);
				int maxValue = 0;
				for (int x = 0; x < numpartition; x++) {
					// intersect the edges between in the partition and the edges
					// with incoming vertex
					Set<Integer> set = new HashSet<Integer>(partition[x].keySet());
					set.retainAll(candidateEdges);
					int intersect = set.size();
					if (intersect > maxValue) {
						maxValue = intersect;
						CandidateIndex = x;
						//partitionNumber= CandidateIndex;
						nonbalance2.clear();
						nonbalance2.add(x);
					}else if (intersect == maxValue){
						nonbalance2.add(x);
						int min = partition[nonbalance2.get(0)].size();
						for(int b=0;b<nonbalance2.size();b++){
						if(partition[nonbalance2.get(b)].size()<min){
							min = partition[nonbalance2.get(b)].size();
							CandidateIndex = nonbalance2.get(b);
							//partitionNumber= CandidateIndex;
						}
						}
					}/*else { 
						    int number=random.nextInt(numpartition);
						    CandidateIndex = number;
						    //partitionNumber = number;
					}*/
				}
				// handling if more than one partition ties
				// -------End of Finding maximum number of edges and partition
				// index
				// of candidate vertex
				// get the partition number with minimum load
				// int nimumLoad = getMinimumLoad();
				// finding the buffered vertex of a candidate vertex
				// iterate through whole window
				tempMap.put(candidateVertex,candidateEdges);
				List<Integer> nonbalance3 = new ArrayList<Integer>();
				List<Integer> removePurpose = new ArrayList<Integer>();
				//nonbalance3.add(0);
				int maxiumBuffered = 0;
				for (Map.Entry<Integer, List<Integer>> entry : window.entrySet()) {
					// iterate through the all edges of candidate vertex to find
					// a
					// connection of candidate vertex from the window

					// System.out.println("----------yes-----"+entry.getKey());
					for (int x = 0; x < candidateEdges.size(); x++) {
						//System.out.println(" key in process"+ entry.getKey()+ " value "+ entry.getValue());
						if (candidateEdges.get(x).equals(entry.getKey())) {
							tempMap.put(entry.getKey(),entry.getValue());
							removePurpose.add(entry.getKey());
							for (int a = 0; a < numpartition; a++) {
								// intersect the edges between in the partition
								// and
								// the edges
								// with incoming vertex
								Set<Integer> set = new HashSet<Integer>(partition[a].keySet());
								set.retainAll(entry.getValue());
								int intersect = set.size();
								if (intersect > maxiumBuffered) {
									maxiumBuffered = intersect;
									BufferedIndex = a;
									//partitionNumber= BufferedIndex;
									nonbalance3.clear();
									nonbalance3.add(a);
								}else if (intersect == maxiumBuffered){
									nonbalance3.add(a);
									int min = partition[nonbalance3.get(0)].size(); 
									for(int b=0;b<nonbalance3.size();b++){
									if(partition[nonbalance3.get(b)].size()<min){
										min = partition[nonbalance3.get(b)].size();
										BufferedIndex = nonbalance3.get(b);
										//partitionNumber= BufferedIndex;
									}
									}
								}/*else {
									   int number=random.nextInt(numpartition);
									   //partitionNumber = number;
									    BufferedIndex = number;
								}*/
								// argmaxBuffered.add(a, intersect);
							}
							
						}
					}
				}
				window.keySet().removeAll(removePurpose);
				removePurpose.clear();
				/// new checking 
//System.out.println("temp map "+ tempMap);
				
				// find the partition index
				if (maxValue > maxiumBuffered) {
					partitionNumber = CandidateIndex;
				} else if (maxValue < maxiumBuffered) {
					partitionNumber = BufferedIndex;
				} else if ((maxValue == maxiumBuffered)&&(maxValue!=0)&&(maxiumBuffered!=0)) {
					// send to the partition has minimum load
						partitionNumber = CandidateIndex;	
				} else if ((maxValue == 0) && (maxiumBuffered == 0)) {
					// send to the partition has minimum load
					partitionNumber = CandidateIndex;
				}/* else {
					   //int number=random.nextInt(numpartition);
					   partitionNumber = CandidateIndex;
					   // BufferedIndex = number;
				}*/
			}
			// for(int x=0;x<numpartition;x++){
			// System.out.println("Elements : "+partition[2]+ " size "+
			// partition[2].size());
			// }
			// System.out.println("candidate vertex "+candidateVertex);
			//System.out.println("partition number ------------------------------in rest---------------------------------: "+ partitionNumber+ "--------"+candidateVertex);
			int count = 0;
			if(tempMap.isEmpty()){
				for (int y = 0; y < numpartition; y++) {
					// for(int i =0; i<=partition[y].size();i++){
					// System.out.println("----"+edgeCount[0].get(i));
					if (!partition[y].containsKey(candidateVertex)) {
						// System.out.println(x);
						count++;
						// System.out.println(edgeCount[0]);
					}
					// }
				}
				if (count == numpartition) {
					if (checkBalance == true) {
						partition[partIndexMin].put(candidateVertex,candidateEdges);
						
					} else {
							partition[partitionNumber].put(candidateVertex,candidateEdges);
							
					}
				}
			}else {
				for (int y = 0; y < numpartition; y++) {
					// for(int i =0; i<=partition[y].size();i++){
					// System.out.println("----"+edgeCount[0].get(i));
					if(!partition[y].keySet().containsAll(tempMap.keySet())){
						 //System.out.println(x);
						count++;
						// System.out.println(edgeCount[0]);
					}
					// }
				}
				//System.out.println(" Checking balance "+checkBalance);
				if (count == numpartition) {
						for (Map.Entry<Integer, List<Integer>> entry2 : tempMap.entrySet()) {
							checkBalance = loadBalance();
							partIndexMin =getMinimum();
							if (checkBalance == true) {
								//System.out.println(" Checking balance inside "+checkBalance);
								//System.out.println("Yes 3");
							partition[partIndexMin].put(entry2.getKey(), entry2.getValue());
						  } else {
						 partition[partitionNumber].put(entry2.getKey(), entry2.getValue());
					// System.out.println("Yes 4");
												
					}
				}
				
			}
			}
			
			//System.out.println("Temo map is "+tempMap+" Candidate Vertex is "+candidateVertex);
			tempMap.clear();
			/*
			 * for(int x=0; x<candidateEdges.size();x++){
			 * 
			 * Integer edge1 = candidateEdges.get(x); for(int y=0;
			 * y<numpartition;y++){ if(y==partitionNumber){ continue; }
			 * 
			 * for(Integer i : partition[y].keySet()){
			 * ///System.out.println("Yes"); int element = i;
			 * if(edge1==element){
			 * 
			 * numOfEdge.add(candidateVertex); edgeCount=numOfEdge.size(); //
			 * System.out.println("Yes"); //edgeCount++;
			 * 
			 * }
			 * 
			 * }
			 * 
			 * } }
			 */
		}
	}
	public static void getEdgeCut() {
		for (int a = 0; a < numpartition; a++) {
			for (int y = 0; y < numpartition; y++) {
				if (y == a) {
					continue;
				}
				// System.out.println("a value " + a + "y value " + y);
				for (Map.Entry<Integer, List<Integer>> entry1 : partition[a].entrySet()) {
					// System.out.println("--------"+ a);
					for (Map.Entry<Integer, List<Integer>> entry2 : partition[y].entrySet()) {
						// System.out.println("---2nd---"+ (y));
						for (int x = 0; x < entry2.getValue().size(); x++) {
							// for(int y=0;y<4;y++){
							// System.out.println("value "+entry.getValue());
							if (entry1.getKey().equals(entry2.getValue().get(x))) {
								// if((entry1.getKey().equals(entry.getValue().get(x)))||(entry1.getKey().equals(entry.getValue().get(x)))){
								// System.out.println(" in count " +
								// entry1.getKey());
								if (!partitionEdge[a].containsKey(y)) {
									partitionEdge[a].put((y), 1);
								} else {
									partitionEdge[a].put((y), partitionEdge[a].get(y) + 1);
								}
							}
						}
					}
				}
				// edgeCount[a].add(count1);
			}
			// System.out.println("edgeeeeee "+partitionEdge[a]);
		}
		List<Integer> partEdge1 = new LinkedList<>();
		// List<Integer> partEdge = new LinkedList<>();
		for (int x = 0; x < partitionEdge.length; x++) {
			// int value = partitionEdge[x].values();
			partEdge1.addAll(partitionEdge[x].values());
		}
		int sum = 0;
		for (int x = 0; x < partEdge1.size(); x++) {
			sum = sum + partEdge1.get(x);
		}
		System.out.println("number of edge cut " + sum / 2);
		// for(int x=0; x<numpartition;x++){
		// System.out.println(" partition "+x+" and the size
		// "+partition[x].size());
		// }
		// for(int x=0; x<numpartition;x++){
		// System.out.println(" Element in partition "+x+" "+partition[x]);
		// }
	}///

}
