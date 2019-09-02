
/*
 * 
To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *///
package PageRank;

import java.io.BufferedWriter;
/**
 *
 * @author mpatwary
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Map.Entry;

import mpi.*;

public class Partition {
	private static final int MAX_ENTRIES = 100;
	private static final int numpartition = 3;
	private static final int parameter =50;
	private static int partitionNumber;
	private static int vertexCount=0;
	public static int rank;
	public static int size;
	public static Map<Integer, List<Integer>> partition[];
	public static Map<Integer, List<Integer>> newPartition[];
	public static Map<Integer, List<Integer>> tempMap = new HashMap<>();
	public static int edgeCount = 0;
	public static Set<Integer> numOfEdge = new HashSet<>();
	public static double deviation = 0.0;
	public static Map<Integer, Integer> partitionEdge[];
	//public static Map<Integer, Double> pagerank = new HashMap();
	//public static double pagerank[] = new double[10000];
	 public static Map<Integer, Integer> outgoingLinks = new HashMap<>();
	static public LinkedHashMap<Integer, List<Integer>> window = new LinkedHashMap(MAX_ENTRIES + 1, .75F, false) {
		protected boolean removeEldestEntry(Map.Entry eldest) {
			return size() > MAX_ENTRIES;
		}
	};

	public static void main(String [] args) throws IOException {
		MPI.Init(args);
		rank = MPI.COMM_WORLD.Rank();
		size = MPI.COMM_WORLD.Size();
		newPartition = new HashMap[numpartition-1];
		partition = new HashMap[numpartition];
		for (int x = 0; x < numpartition; x++) {
			partition[x] = new HashMap<>();
		}
		partitionEdge = new HashMap[numpartition];
		for (int y = 0; y < numpartition; y++) {
			partitionEdge [y] = new HashMap<>();
		}

		long start = System.currentTimeMillis();
		readFile();
		processRest();
		long stop = System.currentTimeMillis();
		long totalTime = stop - start;
		// Page rank calculation
		
		//long startCalculation = System.currentTimeMillis();
		pageRankCalculation();
		//long stopCalculation = System.currentTimeMillis();
		
		//long calculationTime = stopCalculation - startCalculation;
		//getPartition();
		//for(int x=0;x<numpartition;x++){
		//System.out.println("Partition :"+x+" Element: "+ partition[x]);
		//}
		System.out.println(" Window Size: " + MAX_ENTRIES);
		System.out.println(" Balanced parameter : " + parameter);
		System.out.println(" Number of Partition : " + numpartition);
		System.out.println(" Total time taken is " + totalTime);
		
		//System.out.println("Edge Cut : "+edgeCount);
		/// Standard Deviation
		// find sum
		//loadImbalance();
		//getEdgeCut();
		int total =0;
		//for (int x = 0; x < numpartition; x++) {
			//System.out.println(" partition " + x + " and the size " + partition[x].size());
			//total+=partition[x].size();
		//}
		//System.out.println("Total vertices "+total);
		// for (int x = 0; x < numpartition; x++) {
		 //System.out.println(" partition " + x + " and the Elements are : " +
		// partition[x].keySet());
		// }
	
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
	public static void loadImbalance() {
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
		 ///System.out.println("x value in balance.........................."+x);
		if (x >= parameter) {

			 //System.out.println("Load Balance x value "+x);
			return true;

		} else {
			 //System.out.println("Load Balance x value else "+x);
			return false;
		}
	}

	public static void readFile() throws IOException {
		// -----------------------------------------------------------------------------------------------------------------------------------------------------Read
		// Input
		 //Scanner sc = new Scanner(new
		 //File("/Users/Anwarul/Documents/workspace/First_algorithm_stream/src/algorithm/test6.txt"));
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(new File("C:\\Users\\mpatwary\\Desktop\\Source\\twitter.graph"));
		 //Scanner sc = new Scanner(new
		 //File("/Users/mpatwary/eclipse-workspace/Research/src/algorithm/test4.txt"));
		// read stream
		int c=0;
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
			// System.out.println(alist);
			getPartition(alist);
			//System.out.println(c++); 
		}
	}
	
	public static int getMinimum() {
		int partIndexMin = 0;
		int partitionValue = partition[0].size();
		for (int x = 0; x < numpartition; x++) {
			if (partitionValue > partition[x].size()) {
				partIndexMin = x;
			}
		}
		return partIndexMin;
	}

	public static void getPartition(LinkedList<Integer> list) throws IOException {
		
		Random random = new Random(123456789L);

		int CandidateIndex = 0;
		int BufferedIndex = 0;
		
		if(window.containsKey(list.getFirst())){
    		window.get(list.getFirst()).addAll(list.subList(1, list.size()));
    	}else {
    		List<Integer> to = new ArrayList();
			to.addAll(list.subList(1, list.size()));
			window.put(list.getFirst(), to);
    	}
		
		//window.put(list.getFirst(), list.subList(1, list.size()));
		int candidateVertex = 0;

		// FIND the partition index with highest number of vertices
		int partindex = 0;
		for (int x = 0; x < numpartition; x++) {
			int newNumber = partition[x].size();
			if (newNumber > partition[partindex].size()) {
				partindex = x;
			}
		}
		// Find the minimum partition
		int partIndexMin = getMinimum();
		Map.Entry<Integer, List<Integer>> iter = (Entry<Integer, List<Integer>>) window.entrySet().iterator().next();
		candidateVertex = iter.getKey();
		List<Integer> candidateEdges = iter.getValue();
		//System.out.println(window);
		if (window.size() == MAX_ENTRIES) {
			//System.out.println(window);
			boolean checkBalance = loadBalance();
			boolean checkEmptyPartition = check();
			if (checkEmptyPartition == true) {
				// partitionNumber = 0;
				partitionNumber = random.nextInt(numpartition);
				///window.remove(iter.getKey());
				System.out.println("in empty section "+partitionNumber );
			} else if (checkBalance == true) {
				
				List<Integer> balance1 = new ArrayList<Integer>();
				int maxValue = 0;
				for (int x = 0; x < numpartition; x++) {
					if ((x == partindex)&&(numpartition!=2)) {
						continue;
					}
					Set<Integer> set = new HashSet<Integer>(partition[x].keySet());
					set.retainAll(candidateEdges);
					int intersect = set.size();
					if (intersect > maxValue) {
						maxValue = intersect;
						CandidateIndex = x;
						balance1.clear();
						balance1.add(x);
						//System.out.println("Index in if is "+CandidateIndex);
					} else if (intersect == maxValue) {
						balance1.add(x);
						int min = partition[balance1.get(0)].size();
						for (int b = 0; b < balance1.size(); b++) {
							if (partition[balance1.get(b)].size() < min) {
								min = partition[balance1.get(b)].size();
								CandidateIndex = balance1.get(b);
								//System.out.println("Index in else is "+CandidateIndex);
							}
						}
					} /*
						 * else { int alreadyPickedNumber=partindex; //Number to exclude int
						 * number=random.nextInt(numpartition); while(number==alreadyPickedNumber){
						 * number=random.nextInt(numpartition); } CandidateIndex = number; //
						 * System.out.println("In random ---"+ CandidateIndex); //partitionNumber =
						 * number; }
						 */
					
				}
				//System.out.println(" Indexxxx "+CandidateIndex);
				List<Integer> balance2 = new ArrayList<Integer>();
				Set<Integer> removePurpose = new HashSet<Integer>();
				int maxiumBuffered = 0;
				tempMap.put(candidateVertex, candidateEdges);
				//System.out.println("window size "+window.size());				
				for (Map.Entry<Integer, List<Integer>> entry : window.entrySet()) {
					//System.out.println("loop ");
					for (int x = 0; x < candidateEdges.size(); x++) {
						if (candidateEdges.get(x).equals(entry.getKey())) {
							tempMap.put(entry.getKey(), entry.getValue());
							removePurpose.add(entry.getKey());
							int intersect = 0;
							for (int a = 0; a < numpartition; a++) {
								if ((a == partindex)&&(numpartition!=2)) {
									continue;
								}
								Set<Integer> set = new HashSet<Integer>(partition[a].keySet());
								set.retainAll(entry.getValue());
								intersect = set.size();
								if (intersect > maxiumBuffered) {
									maxiumBuffered = intersect;
									BufferedIndex = a;
									balance2.clear();
									balance2.add(a);
								} else if (intersect == maxiumBuffered) {
									balance2.add(a);
									int min = partition[balance2.get(0)].size();
									for (int b = 0; b < balance2.size(); b++) {
										if (partition[balance2.get(b)].size() < min) {
											min = partition[balance2.get(b)].size();
											BufferedIndex = balance2.get(b);

										}
									}
								} /*
									 * else { int alreadyPickedNumber=partindex; //Number to exclude int
									 * number=random.nextInt(numpartition); while(number==alreadyPickedNumber){
									 * number=random.nextInt(numpartition); } BufferedIndex = number;
									 * //System.out.println("In random buffered "+BufferedIndex ); //
									 * partitionNumber = number; }
									 */
							}

						}
					}
				///	System.out.println(" connection size ---- "+tempMap.size());
				}
				//System.out.println("  Remove purpose data "+removePurpose);
				window.remove(candidateVertex);
				window.keySet().removeAll(removePurpose);
				removePurpose.clear();
				// Finding and assigning a vertex to a partition
				if (maxValue > maxiumBuffered) {
					partitionNumber = CandidateIndex;
				} else if (maxValue < maxiumBuffered) {
					partitionNumber = BufferedIndex;
				} else if ((maxValue == maxiumBuffered) && (maxValue != 0) && (maxiumBuffered != 0)) {
					// send to the partition has minimum load
					partitionNumber = CandidateIndex;
				} else if ((maxValue == 0) && (maxiumBuffered == 0)) {
					// send to the partition has minimum load
					partitionNumber = CandidateIndex;
					//System.out.println(CandidateIndex);
				} else {
					partitionNumber = CandidateIndex;
					
				}
				/*
					 * else { /*int alreadyPickedNumber=partindex; //Number to exclude int
					 * number=random.nextInt(numpartition); while(number==alreadyPickedNumber){
					 * number=random.nextInt(numpartition); } CandidateIndex = number;
					 * System.out.println("In random ---"+ CandidateIndex);
					 * 
					 * partitionNumber = CandidateIndex; //partitionNumber = number; }
					 */
				//////////////////////////////////////////////////////////////////////////// -----------------------
				//////////////////////////////////////////////////////////////////////////// Balanced
				//////////////////////////////////////////////////////////////////////////// starts
				//////////////////////////////////////////////////////////////////////////// here
				//System.out.println("Max value "+maxValue+ "maximumBuffered  "+maxiumBuffered);
			} else {
				List<Integer> nonbalance = new ArrayList<Integer>();
				int maxValue = 0;
				for (int x = 0; x < numpartition; x++) {

					Set<Integer> set = new HashSet<Integer>(partition[x].keySet());
					set.retainAll(candidateEdges);
					int intersect = set.size();
					if (intersect > maxValue) {
						maxValue = intersect;
						CandidateIndex = x;
						nonbalance.clear();
						nonbalance.add(x);
						//System.out.println("Index in if is "+CandidateIndex);
					} else if (intersect == maxValue) {
						nonbalance.add(x);
						int min = partition[nonbalance.get(0)].size();
						for (int b = 0; b < nonbalance.size(); b++) {
							if (partition[nonbalance.get(b)].size() < min) {
								min = partition[nonbalance.get(b)].size();
								CandidateIndex = nonbalance.get(b);
								// partitionNumber= CandidateIndex;
								//System.out.println("Index in else is "+CandidateIndex);
							}
						}
					} /*
						 * else { int number=random.nextInt(numpartition); CandidateIndex = number;
						 * //System.out.println("In random - + "+ CandidateIndex); //partitionNumber =
						 * number; }
						 */
				}
				//System.out.println(" Indexxxx "+CandidateIndex);
				tempMap.put(candidateVertex, candidateEdges);
				List<Integer> nonbalance1 = new ArrayList<Integer>();
				Set<Integer> removePurpose = new HashSet<Integer>();
				int count =0;
				// nonbalance1.add(0);
				int maxiumBuffered = 0;
				//System.out.println("----------yes-----"+window);
				//System.out.println("window size "+window.size());	
				for (Map.Entry<Integer, List<Integer>> entry : window.entrySet()) {
					//System.out.println("loop "+ count++);
					// System.out.println("----------yes-----"+entry.getKey());
					//System.out.println(" Candudate edges "+candidateEdges+" and size "+ candidateEdges.size());
					for (int x = 0; x < candidateEdges.size(); x++) {
						if (candidateEdges.get(x).equals(entry.getKey())) {
							tempMap.put(entry.getKey(), entry.getValue());
							removePurpose.add(entry.getKey());	
							for (int a = 0; a < numpartition; a++) {
								Set<Integer> set = new HashSet<Integer>(partition[a].keySet());
								set.retainAll(entry.getValue());
								int intersect = set.size();
								if (intersect > maxiumBuffered) {
									maxiumBuffered = intersect;
									BufferedIndex = a;
									// partitionNumber= BufferedIndex;
									nonbalance1.clear();
									nonbalance1.add(a);
								} else if (intersect == maxiumBuffered) {
									nonbalance1.add(a);
									int min = partition[nonbalance1.get(0)].size();
									for (int b = 0; b < nonbalance1.size(); b++) {
										if (partition[nonbalance1.get(b)].size() < min) {
											min = partition[nonbalance1.get(b)].size();
											BufferedIndex = nonbalance1.get(b);
											// partitionNumber= BufferedIndex;
										}
									}
								} /*
									 * else { int number=random.nextInt(numpartition); BufferedIndex = number;
									 * //partitionNumber = number;
									 * //System.out.println("In random buffered -"+BufferedIndex); }
									 */
							}
							// System.out.println("BufferedIndex in loop " + BufferedIndex);
							//System.out.println(" matched edges " + candidateEdges.get(x)+ " entry.getValue() " + entry.getValue());
							
						}
						
						
						
					}
					//System.out.println(" key in main"+ entry.getKey()+ " value "+
						//	 entry.getValue());
				}
				// New Checking
				// removing vertex from the window
				
				window.remove(candidateVertex);
				//System.out.println("Remove purpose data aaa"+ removePurpose);
				window.keySet().removeAll(removePurpose);
				///System.out.println("----------after remove-----"+window);
				removePurpose.clear();
				//System.out.println("Max value "+maxValue+ "maximumBuffered  "+maxiumBuffered);	
				if (maxValue > maxiumBuffered) {
					partitionNumber = CandidateIndex;
				} else if (maxValue < maxiumBuffered) {
					partitionNumber = BufferedIndex;
				} else if ((maxValue == maxiumBuffered) && (maxValue != 0) && (maxiumBuffered != 0)) {
					// send to the partition has minimum load
					partitionNumber = CandidateIndex;
				} else if ((maxValue == 0) && (maxiumBuffered == 0)) {
					// send to the partition has minimum load
					//System.out.println(CandidateIndex);
					partitionNumber = CandidateIndex;
				} else {
					partitionNumber = CandidateIndex;
					
				} 
				
				
				/*
					 * else { // int number=random.nextInt(numpartition); //CandidateIndex = number;
					 * //System.out.println("In random - + "+ CandidateIndex); partitionNumber =
					 * CandidateIndex; }
					 */
			}
			// for(int x=0;x<numpartition;x++){
			// System.out.println("Elements : "+partition[2]+ " size "+
			// partition[2].size());
			// }

			// System.out.println("partition number
			// ---------------------------------------------------------------: " +
			// partitionNumber+ "--------"+candidateVertex);
			
			//System.out.println("partition number ---------------: "+ partitionNumber+" Vertex "+candidateVertex+ "Candidate Index "+ CandidateIndex+ "Buffered Index "+ BufferedIndex);	
		/*	int count =0;
            for(int y =0; y<numpartition;y++){
		//for(int i =0; i<=partition[y].size();i++){
			//System.out.println("----"+edgeCount[0].get(i));
			if (!partition[y].containsKey(candidateVertex)){
				//System.out.println(x);
				count++;
                                   // partition[partitionNumber].add(candidateVertex);
				//System.out.println(edgeCount[0]);
			} 
		//}
		
	}
	if(count==numpartition){
           partition[partitionNumber].put(candidateVertex,candidateEdges);      
            }*/
			
			//System.out.println(" connection size ---- "+tempMap.size()+ " candidate vertex "+ candidateVertex+ "And temp data "+ tempMap.keySet());
			//System.out.println(" connection size ---- "+tempMap.size()+ " Temp data "+ tempMap+ "Candidate Vertex "+candidateVertex);	
			//int count = 0;
			//try (Writer writer = new BufferedWriter(new OutputStreamWriter(
		             // new FileOutputStream("filename.txt"), "utf-8"))) {
		 
		
			
			if (tempMap.isEmpty()) {
				//for (int y = 0; y < numpartition; y++) {

					//if (!partition[y].containsKey(candidateVertex)) {
						// System.out.println(x);
						//count++;
					//}
					// }
				//}

				//if (count == numpartition) {
					if (checkBalance == true) {
						partition[partIndexMin].put(candidateVertex, candidateEdges);
						
						
						
						vertexCount++;
						
						 // writer.write(new Integer(partIndexMin).toString());
					} else {

						partition[partitionNumber].put(candidateVertex, candidateEdges);
						//writer.write(new Integer(partitionNumber).toString());
						vertexCount++;  

					}

				//}

			} else {
				//for (int y = 0; y < numpartition; y++) {
					//for (Map.Entry<Integer, List<Integer>> entry2 : tempMap.entrySet()) {
					//if (!partition[y].containsKey(entry2.getKey())) {

						//count++;
					//}
					//}
				//}
				//if (count == numpartition) {
			
		//	partition[partitionNumber].putAll(tempMap);
					for (Map.Entry<Integer, List<Integer>> entry2 : tempMap.entrySet()) {
						 checkBalance = loadBalance();
						 partIndexMin=getMinimum();
						int count = 0;
						//System.out.println("Each vertex "+entry2.getKey());
						for(int y=0;y<numpartition; y++) {
							if (!partition[y].containsKey(entry2.getKey())) {
								count++;
							//System.out.println(entry2.getKey());
							}
						}
						if(count == numpartition) {
						if (checkBalance == true) {
							//partition[partIndexMin].put(candidateVertex, candidateEdges);
							//System.out.println("Inserting "+entry2.getKey());
							partition[partIndexMin].put(entry2.getKey(), entry2.getValue());
							//vertexCount++;
							//System.out.println("Insert : "+ entry2.getKey()+ " partition "+ partIndexMin);
							
							//writer.write(new Integer(partIndexMin).toString());
						} else {
							
							//partition[partitionNumber].putAll(tempMap);
							//partition[partitionNumber].put(candidateVertex, candidateEdges);
							//System.out.println("Inserting "+entry2.getKey());
							partition[partitionNumber].put(entry2.getKey(), entry2.getValue());
							//writer.write(new Integer(partitionNumber).toString());
							//vertexCount++;
							//System.out.println("Insert : "+ entry2.getKey()+ " partition "+ partitionNumber);

						}
					}
					}
						//}
						//}
				//}
			}
		//}
			tempMap.clear();
		}
		
		//System.out.println(" vertex count "+vertexCount);
		//getEdgeCut(); 
	}

	public static void processRest() {
		Random random = new Random();
		int CandidateIndex = 0;
		int BufferedIndex = 0;
		int candidateVertex = 0;
		Set<Integer> removePurpose = new HashSet<Integer>();
		
		// FIND the partition index with highest number of vertices
		int partindex = 0;
		for (int x = 0; x < numpartition; x++) {
			int newNumber = partition[x].size();
			if (newNumber > partition[partindex].size()) {
				partindex = x;
			}
		}

		int partIndexMin = getMinimum();
		//System.out.println("minimum index uppp " + partIndexMin);
		//Map.Entry<Integer, List<Integer>> iter1 = (Entry<Integer, List<Integer>>) window.entrySet().iterator().next();
		//Map<Integer,List<Integer>> newWindow = new HashMap<Integer, List<Integer>>(window);
		Iterator<Map.Entry<Integer, List<Integer>>> iter1 = window.entrySet().iterator();
		//System.out.println(window);
		//window.remove(iter1.getKey());
		//System.out.println("After removal : "+window);
		
		while (iter1.hasNext()) {
			
			 Map.Entry<Integer, List<Integer>> entry1 = iter1.next();
			// loadBalance();
			candidateVertex = entry1.getKey();
			List<Integer> candidateEdges = entry1.getValue();
			
			//System.out.println("Key "+ iter.getKey()+ " Value "+ iter.getValue());
			// System.
			// System.out.println("Window "+ window);
			// System.out.println(" process rest "+ candidateVertex);
			// Check balance
			//System.out.println(candidateVertex);
			boolean checkBalance = loadBalance();
			partIndexMin=getMinimum();
			// System.out.println("Checking balance--------------
			// "+checkBalance);
			// check all the partitions are empty
			// boolean checkEmptyPartition = check();
			// System.out.println(checkEmptyPartition);
			
			
			if(!removePurpose.contains(entry1.getKey())){
				
				
			if (checkBalance == true) {
				// end of else of check partition
				// else send to the partitions except the partition has the
				// highest number of vertices
				// -------------------------------------------------------------
				// System.out.println("Balanced section process rest");
				List<Integer> balance3 = new ArrayList<Integer>();
				// balance3.add(0);
				int maxValue = 0;
				for (int x = 0; x < numpartition; x++) {
					// ignoring the partition with highest number of vertices
					// (need to fix)
					if ((x == partindex)&&(numpartition!=2)) {
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
						// partitionNumber= CandidateIndex;
						balance3.clear();
						balance3.add(x);
					} else if (intersect == maxValue) {
						balance3.add(x);
						int min = partition[balance3.get(0)].size();
						for (int b = 0; b < balance3.size(); b++) {
							if (partition[balance3.get(b)].size() < min) {
								min = partition[balance3.get(b)].size();
								CandidateIndex = balance3.get(b);
								// partitionNumber= CandidateIndex;
							}
						}
					} /*
						 * else { int alreadyPickedNumber=partindex; //Number to exclude int
						 * number=random.nextInt(numpartition); while(number==alreadyPickedNumber){
						 * number=random.nextInt(numpartition); } CandidateIndex = number;
						 * //partitionNumber = number; }
						 */
				}
				tempMap.put(candidateVertex, candidateEdges);
				List<Integer> balance4 = new ArrayList<Integer>();
				
				// balance4.add(0);
				int maxiumBuffered = 0;	
				for (Map.Entry<Integer, List<Integer>> entry : window.entrySet()) {
					// iterate through the all edges of candidate vertex to find
					// a
					// connection of candidate vertex from the window
					// System.out.println("Candidate Edges
					// "+candidateEdges.size());
					for (int x = 0; x < candidateEdges.size(); x++) {
						// System.out.println(" key in process "+ entry.getKey()+ " value "+
						// entry.getValue());
						if (candidateEdges.get(x).equals(entry.getKey())) {
							tempMap.put(entry.getKey(), entry.getValue());
							removePurpose.add(entry.getKey());
							
							int intersect = 0;
							for (int a = 0; a < numpartition; a++) {
								if ((a == partindex)&&(numpartition!=2)) {
									continue;
								}
								Set<Integer> set = new HashSet<Integer>(partition[a].keySet());
								// System.out.println("---"+entry.getValue());
								set.retainAll(entry.getValue());
								// System.out.println(set);
								intersect = set.size();
								// System.out.println(intersect);
								if (intersect > maxiumBuffered) {
									maxiumBuffered = intersect;
									BufferedIndex = a;
									// partitionNumber= BufferedIndex;
									balance4.clear();
									balance4.add(a);			
								} else if (intersect == maxiumBuffered) {
									balance4.add(a);
									int min = partition[balance4.get(0)].size();
									// System.out.println(balance4.size());
									for (int b = 0; b < balance4.size(); b++) {
										if (partition[balance4.get(b)].size() < min) 
										{
											min = partition[balance4.get(b)].size();
											BufferedIndex = balance4.get(b);
											// partitionNumber = BufferedIndex;
										}
									}
								} /*
									 * else { int alreadyPickedNumber=partindex; //Number to exclude int
									 * number=random.nextInt(numpartition); while(number==alreadyPickedNumber){
									 * number=random.nextInt(numpartition); } BufferedIndex = number;
									 * //partitionNumber = number; }
									 */
							}
						}
					}
				}
				//window.keySet().removeAll(removePurpose);
				//removePurpose.clear();
				// System.out.println("temp map "+ tempMap);
				// Finding and assigning a vertex to a partition
				//System.out.println("Max value "+maxValue+ "maximumBuffered  "+maxiumBuffered);
				
				if (maxValue > maxiumBuffered) 
				{
					partitionNumber = CandidateIndex;
				} 
				else if (maxValue < maxiumBuffered)
				{
					partitionNumber = BufferedIndex;
				} 
				else if ((maxValue == maxiumBuffered) && (maxValue != 0) && (maxiumBuffered != 0)) 
				{
					// send to the partition has minimum load
					partitionNumber = CandidateIndex;
				}
				else if ((maxValue == 0) && (maxiumBuffered == 0))
				{
					// send to the partition has minimum load
					//System.out.println(CandidateIndex);
					partitionNumber = CandidateIndex;
				} else {
					partitionNumber = CandidateIndex;
					
				}
				
				/*
					 * else { /* int alreadyPickedNumber=partindex; //Number to exclude int
					 * number=random.nextInt(numpartition); while(number==alreadyPickedNumber){
					 * number=random.nextInt(numpartition); } //CandidateIndex = number;
					 * partitionNumber = CandidateIndex; }
					 */
				//////////////////////////////////////////////////////////////////////////// Balanced
				//////////////////////////////////////////////////////////////////////////// Starts
				//System.out.println(" in process  Max value  "+ maxValue+ " buffered value  "+ maxiumBuffered+"Buffered index"+BufferedIndex+" Candidate Vertex  "+ candidateVertex);
			} else {
				List<Integer> nonbalance2 = new ArrayList<Integer>();
				// nonbalance2.add(0);
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
						// partitionNumber= CandidateIndex;
						nonbalance2.clear();
						nonbalance2.add(x);
					} else if (intersect == maxValue) {
						nonbalance2.add(x);
						int min = partition[nonbalance2.get(0)].size();
						for (int b = 0; b < nonbalance2.size(); b++) {
							if (partition[nonbalance2.get(b)].size() < min) {
								min = partition[nonbalance2.get(b)].size();
								CandidateIndex = nonbalance2.get(b);
								// partitionNumber= CandidateIndex;
							}
						}
					} /*
						 * else { int number=random.nextInt(numpartition); CandidateIndex = number;
						 * //partitionNumber = number; }
						 */
				}
				tempMap.put(candidateVertex, candidateEdges);
				List<Integer> nonbalance3 = new ArrayList<Integer>();
				//List<Integer> removePurpose = new ArrayList<Integer>();
				// nonbalance3.add(0);
				int maxiumBuffered = 0;
				//System.out.println("maxiumBuffered------"+maxiumBuffered);
				for (Map.Entry<Integer, List<Integer>> entry : window.entrySet()) {
					// iterate through the all edges of candidate vertex to find
					// a
					// connection of candidate vertex from the window
					// System.out.println("----------yes-----"+entry.getKey());
					//System.out.println(" Candudate edges "+candidateEdges+" and size "+ candidateEdges.size());
					for (int x = 0; x < candidateEdges.size(); x++) {
						if (candidateEdges.get(x).equals(entry.getKey())) {
							tempMap.put(entry.getKey(), entry.getValue());
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
									// partitionNumber= BufferedIndex;
									nonbalance3.clear();
									nonbalance3.add(a);
									///System.out.println("maxiumBuffered----innn--"+maxiumBuffered);
								} else if (intersect == maxiumBuffered) {
									nonbalance3.add(a);
									int min = partition[nonbalance3.get(0)].size();
									for (int b = 0; b < nonbalance3.size(); b++) {
										if (partition[nonbalance3.get(b)].size() < min) {
											min = partition[nonbalance3.get(b)].size();
											BufferedIndex = nonbalance3.get(b);
											// partitionNumber= BufferedIndex;
										}
									}
								} /*
									 * else { int number=random.nextInt(numpartition); //partitionNumber = number;
									 * BufferedIndex = number; }
									 */
								// argmaxBuffered.add(a, intersect);
							}
								//System.out.println("matched  "+candidateEdges.get(x)+ " edges of "+ entry.getValue() );
						}
					}
					//System.out.println(" key in process"+ entry.getKey()+ " value "+
							// entry.getValue());
				}
				//window.keySet().remove(candidateVertex);
		//System.out.println("Max value "+maxValue+ "maximumBuffered  "+maxiumBuffered);
				if (maxValue > maxiumBuffered) 
					{
					partitionNumber = CandidateIndex;
					} 
				else if (maxValue < maxiumBuffered) 
					{
					partitionNumber = BufferedIndex;
					}
				else if ((maxValue == maxiumBuffered) && (maxValue != 0) && (maxiumBuffered != 0)) 
					{
					// send to the partition has minimum load
					partitionNumber = CandidateIndex;
					} 
				else if ((maxValue == 0) && (maxiumBuffered == 0)) 
					{
					// send to the partition has minimum load
					//System.out.println(CandidateIndex);
					partitionNumber = CandidateIndex;
					} 
				else {
						partitionNumber = CandidateIndex;
						
					}
				/*
					 * else { //int number=random.nextInt(numpartition); partitionNumber =
					 * CandidateIndex; // BufferedIndex = number; }
					 */
				//System.out.println(" in process Max value  "+ maxValue+ " buffered value  "+ maxiumBuffered+"Buffered index"+BufferedIndex+" Candidate Vertex  "+ candidateVertex);
			}
			
			//System.out.println(" in process Candidate Index "+ CandidateIndex+ " Partition Number "+ partitionNumber+"Buffered index"+BufferedIndex+" Candidate Vertex  "+ candidateVertex);
			// System.out.println("partition number ------in rest-------------: "+ partitionNumber+" vertexxx : "+candidateVertex+ "Candidate Index "+ CandidateIndex+ "Buffered Index "+ BufferedIndex);
			
			/*int count =0;
            for(int y =0; y<numpartition;y++){
		//for(int i =0; i<=partition[y].size();i++){
			//System.out.println("----"+edgeCount[0].get(i));
			if (!partition[y].containsKey(candidateVertex)){
				//System.out.println(x);
				count++;
                                   // partition[partitionNumber].add(candidateVertex);
				//System.out.println(edgeCount[0]);
			} 
		//}
            }
            if(count==numpartition){
           partition[partitionNumber].put(candidateVertex,candidateEdges);      
            }*/
			
			
			
			//if (tempMap.isEmpty()) {
				//for (int y = 0; y < numpartition; y++) {

					//if (!partition[y].containsKey(candidateVertex)) {
						// System.out.println(x);
						//count++;
					//}
					// }
				//}

				//if (count == numpartition) {
					//if (checkBalance == true) {
						//partition[partIndexMin].put(candidateVertex, candidateEdges);
						//vertexCount++;
						
						 // writer.write(new Integer(partIndexMin).toString());
				//	} else {

					//	partition[partitionNumber].put(candidateVertex, candidateEdges);
						//writer.write(new Integer(partitionNumber).toString());
						//vertexCount++;  
					//}
				//}
			//} else {
				//for (int y = 0; y < numpartition; y++) {
					//for (Map.Entry<Integer, List<Integer>> entry2 : tempMap.entrySet()) {
					//if (!partition[y].containsKey(entry2.getKey())) {
						//count++;
					//}
					//}
				//}

				//if (count == numpartition) {
			
		//	partition[partitionNumber].putAll(tempMap);
			
			//System.out.println("temppppp  "+tempMap);
					for (Map.Entry<Integer, List<Integer>> entry2 : tempMap.entrySet()) {
						int count =0;
						 checkBalance = loadBalance();
						 partIndexMin=getMinimum();
						//System.out.println("Each vertex-- "+entry2.getKey());
						for(int y=0;y<numpartition; y++) {
						if (!partition[y].containsKey(entry2.getKey())) {
							count++;
							//System.out.println(entry2.getKey());
						}
						}
						if(count == numpartition) {
						if (checkBalance == true) {
							//partition[partIndexMin].put(candidateVertex, candidateEdges);
							//System.out.println("Inserting --"+entry2.getKey());
							partition[partIndexMin].put(entry2.getKey(), entry2.getValue());
							//vertexCount++;
						//	System.out.println("Insert --: "+ entry2.getKey()+ " partition "+ partIndexMin);
							
							//writer.write(new Integer(partIndexMin).toString());
						} else {
							
							//partition[partitionNumber].putAll(tempMap);
							//partition[partitionNumber].put(candidateVertex, candidateEdges);
							//System.out.println("Inserting-- "+entry2.getKey());
							partition[partitionNumber].put(entry2.getKey(), entry2.getValue());
							//writer.write(new Integer(partitionNumber).toString());
							//vertexCount++;
							//System.out.println("Insert : "+ entry2.getKey()+ " partition "+ partitionNumber);
						}
					}
					}
						//}
					//}
				//}
			//}
			
			/*int count = 0;
			if (tempMap.isEmpty()) {
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
				//if (count == numpartition) {
					if (checkBalance == true) {
						partition[partIndexMin].put(candidateVertex, candidateEdges);

					} else {
						partition[partitionNumber].put(candidateVertex, candidateEdges);

					}
			//	}
			} else {
				for (int y = 0; y < numpartition; y++) {
					// for(int i =0; i<=partition[y].size();i++){
					// System.out.println("----"+edgeCount[0].get(i));
					if (!partition[y].keySet().containsAll(tempMap.keySet())) {
						// System.out.println(x);
						count++;
						// System.out.println(edgeCount[0]);
					}
					// }
				}
				// System.out.println(" Checking balance "+checkBalance);
				if (count == numpartition) {
					for (Map.Entry<Integer, List<Integer>> entry2 : tempMap.entrySet()) {
						checkBalance = loadBalance();
						partIndexMin = getMinimum();
						if (checkBalance == true) {
							// System.out.println(" Checking balance inside "+checkBalance);
							// System.out.println("Yes 3");
							//partition[partIndexMin].put(candidateVertex, candidateEdges);
							partition[partIndexMin].put(entry2.getKey(), entry2.getValue());
						} else {
							//partition[partitionNumber].put(candidateVertex, candidateEdges);
							partition[partitionNumber].put(entry2.getKey(), entry2.getValue());
							// System.out.println("Yes 4");

						}
					}

				}
			}*/
			
			}
						
						tempMap.clear();
						
					
		}
		
		removePurpose.clear();
		//System.out.println(vertexCount);	
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
	}
	//public static void pageRankCalculation(Map<Integer, List<Integer>> graph) {
		public static void pageRankCalculation() {
			//System.out.println("Out going Links "+outgoingLinks);
			//String portName = Intracomm.		
		
			//System.out.println(" Rank : " + rank);
			//System.out.println(" Size : "+ size );
			int root =0;
			int vertices = 465018;

			// Taking partitioned data and distributing to all the processors 	
			if (rank == root) {
				
				
				for (int y = 1; y < partition.length; y++) {
					
					int partitionSize[] = new int[1];
					partitionSize[0] = partition[y].size();
					MPI.COMM_WORLD.Send(partitionSize, 0, 1, MPI.INT, y, 0);
					// Sending the partitions to the worker
					for (Map.Entry<Integer, List<Integer>> entry : partition[y].entrySet()) {
						int edgeNumber[] = new int[1];
						edgeNumber[0] = entry.getValue().size();
						MPI.COMM_WORLD.Send(edgeNumber, 0, 1, MPI.INT, y, 1);
						for (int e = 0; e < entry.getValue().size(); e++) {
							List<Integer> edgeList = new ArrayList<>(entry.getValue());
							int[] edge = new int[entry.getValue().size()];
							edge = edgeList.stream().mapToInt(i -> i).toArray();
							MPI.COMM_WORLD.Send(edge, 0, edge.length, MPI.INT, y, 2);
						}
						List<Integer> list = new ArrayList<>(partition[y].keySet());
						int node[] = new int[partition[y].size()];
						node = list.stream().mapToInt(i -> i).toArray();
						MPI.COMM_WORLD.Send(node, 0, node.length, MPI.INT, y, 3);
					}
				}
			
			} else {
				for (int x = 0; x < size - 1; x++) {
					newPartition[x] = new HashMap<>();
				}
				// Receiving partitions and inserting them into hashmap
				int numberofNode[] = new int[1];
				MPI.COMM_WORLD.Recv(numberofNode, 0, 1, MPI.INT, root, 0);
				int sizePartition = numberofNode[0];

				for (int x = 0; x < sizePartition; x++) {
					int index = 0;
					List<Integer> edgelist = new ArrayList();
					int numberEdge[] = new int[1];
					MPI.COMM_WORLD.Recv(numberEdge, 0, 1, MPI.INT, root, 1);
					int edgeListSize = numberEdge[0];
					for (int y = 0; y < edgeListSize; y++) {
						int receiveEdge[] = new int[edgeListSize];
						MPI.COMM_WORLD.Recv(receiveEdge, 0, edgeListSize, MPI.INT, root, 2);
					//	System.out.println(" receiveEdge " + receiveEdge[y] + " Rank " + rank);
						// after receiving edges, then put them into a list
						edgelist.add(receiveEdge[y]);
					}
					int recvNode[] = new int[sizePartition];
					MPI.COMM_WORLD.Recv(recvNode, 0, sizePartition, MPI.INT, root, 3);
					//System.out.println(" recvNode " + recvNode[x] + " Rank " + rank);
					newPartition[rank - 1].put(recvNode[x], edgelist);
					// insert initial pagerank of a node
					//pagerank.put(recvNode[x], InitialPageRank);
				}
				// for(int x =0; x<3;x++){
				// System.out.println(partition[rank - 1] + "Rank " + rank);
				// }
				// Transpose the hashmap to calculate the pagerank.
			}
			
			// PAGE RANK CALCULATION 
			long startCalculation = System.currentTimeMillis();
			
			
			double pagerank [] = new double[vertices];
			double TempPageRank [] = new double[vertices];
			//Map<Integer, Double> pagerank = new HashMap();
			//Map<Integer, Double> TempPageRank = new HashMap<>();
			double InitialPageRank = 0.0;
			double dampingFactor = 0.85;
			// double TempPageRank[] = new double[10000];
			int ITERATION_STEP = 0;
			double OutgoingLinks = 0;
			//double totalNodes = 5;
			
			int k ;
			 for( k=0;k<pagerank.length;k++){
	               pagerank[k]= InitialPageRank;
	               }
			while (ITERATION_STEP <= 2) // Iterations
			{
	     	  for(k=0;k<pagerank.length;k++)
	     	  {  
	     	    TempPageRank[k]=pagerank[k];
	     	    pagerank[k]=0;
	     	   }
	     	  ////-------------
			for (int p = 0; p < size; p++) {
				if (rank == root) {
					for (Entry<Integer, List<Integer>> entry2 : partition[0].entrySet()) {
						for (int i = 0; i < entry2.getValue().size(); i++) {
							pagerank[entry2.getKey()] += TempPageRank[entry2.getValue().get(i)]* (1 / entry2.getValue().size());
							pagerank[entry2.getKey()] = (1 - dampingFactor) + dampingFactor * pagerank[entry2.getKey()];
						}
					}
				} else {
					for (Map.Entry<Integer, List<Integer>> entry2 : newPartition[rank - 1].entrySet()) {
						for (int i = 0; i < entry2.getValue().size(); i++) {
							pagerank[entry2.getKey()] += TempPageRank[entry2.getValue().get(i)]* (1 / entry2.getValue().size());
							pagerank[entry2.getKey()] = (1 - dampingFactor) + dampingFactor * pagerank[entry2.getKey()];
						}
					}
				}
				MPI.COMM_WORLD.Bcast(pagerank, 0, pagerank.length, MPI.DOUBLE, p);
			}
				// System.out.printf("\n in Master After "+ITERATION_STEP+"th Step \n");
				ITERATION_STEP = ITERATION_STEP + 1;	
				 //for(k=0;k<pagerank.length;k++) {
					// System.out.println(" Page Rank of "+k+" is : "+pagerank[k]+" " + " Iteration "+ ITERATION_STEP+ " rank "+ rank);
				 //}
			}
			long stopCalculation = System.currentTimeMillis();
			long calculationTime = stopCalculation - startCalculation;
			System.out.println("Total Page Rank calculation time taken : "+calculationTime);
		
	}

}
