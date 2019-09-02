import java.io.*;
//import java.security.KeyStore.Entry;
import java.util.*;

//import com.sun.xml.internal.ws.client.sei.ValueSetter;

import mpi.MPI;
//import mpi.comm.intercomm;

import java.lang.Math;

//Shaowen Ren(shaoren)
//Bo Fang(bofang)

public class Distributed_pageRank {
	
	private String inputFile = "";
    private String outputFile = "";
    private int iterations = 10;
    private double df = 0.85,delta = 0.0001;
    
    private int size,rank;
    private int url_size,rank0size,rank1size;
    private int adjMatrix[][];
    private double rankValues[];
	
 	private void parseArgs(String[] args) {
		//mpjrun.sh -np 8 MPIPageRank <input_file_name> <output_file_name> <delta> <damping factor> <iterations>
    	inputFile = args[3];
    	outputFile = args[4];
    	if (args[5] != null) {
    		delta = Double.valueOf(args[5]);
    	}
    	if (args[6] != null) {
    		df = Double.valueOf(args[6]);
    	}
    	if (args[7] != null) {
    		iterations = Integer.valueOf(args[7]);
    	}
	}
	
    @SuppressWarnings("deprecation")
	private void loadInput_and_init() throws IOException {
    	
    	//input from file
    	File f = new File(inputFile);
    	InputStream is = new FileInputStream(f);
    	DataInputStream dis = new DataInputStream(is);
    	
    	ArrayList<String> tempMatrix = new ArrayList<String>();
    	String temp = null;
    	while ((temp = dis.readLine())!=null) {
			tempMatrix.add(temp);
		}
    	dis.close();
    	is.close();
    	
    	//initialize adjMatrix and rankValues
    	url_size = tempMatrix.size();
    	adjMatrix = new int[url_size][];
    	rankValues = new double[url_size];
    	int j = 0;
    	for (String temp1 : tempMatrix) {
    		String[] line = temp1.split(" ");
    		int index = Integer.valueOf(line[0]);
			adjMatrix[index] = new int[line.length -1];
			for (int i = 1; i < line.length; i++) {
				adjMatrix[index][i-1] = Integer.valueOf(line[i]);
			}
			rankValues[j] = 1.0 / url_size;
			j++;
		}
    	
    	//initial localsize
    	if (url_size % size == 0) {
        	//when the urls can be divided evenly
        	rank0size = url_size / size;
        	rank1size = rank0size;
        } else {
        	//when urls cannot be divided evenly, we are finding a most efficient way of allocating
        	int temp1 = url_size;
        	int temp2 = url_size;
        	while (temp1 % size != 0) {
				temp1 ++;
			}
        	while (temp2 % size != 0) {
				temp2 --;
			}
        	if ((temp1 - url_size) <= (url_size - temp2)) {
				rank1size = temp1 / size;
			} else {
				rank1size = temp2 / size;
			}
        	rank0size = url_size - rank1size * (size - 1);
        }
    	if (url_size < size) {
			rank0size = url_size;
			rank1size = 0;
		}
    }
    
    private int getstartpoint(int rank) {
    	if (rank == 0) {
			return 0;
		} else {
			return rank0size + (rank - 1) * rank1size;
		}
    }
    
    private class Node {
    	public int index;
    	public double rValues;
    	
    	public Node clone() {
    		Node n = new Node();
    		n.index = this.index;
    		n.rValues = this.rValues;
    		return n;
    	}
    }
    
    void sort(Node[] s) {
    	HashMap<Integer, Double> rankValues1 = new HashMap<Integer, Double>();
    	for (int i = 0; i < s.length; i++) {
			rankValues1.put(s[i].index, s[i].rValues);
		}
    	
    	List<Map.Entry<Integer, Double>> rank = new ArrayList<Map.Entry<Integer, Double>>(rankValues1.entrySet());
    	Collections.sort(rank, new Comparator<Map.Entry<Integer, Double>>() {
    		public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
    			if (o2.getValue() < o1.getValue()) {
					return -1;
				}
				if (o2.getValue() > o1.getValue()) {
					return 1;
				}
    			return 0;
    		}
		});
	
    	int i = 0;
    	for (Map.Entry<Integer, Double> entry : rank) {
    		s[i].index = entry.getKey();
    		s[i].rValues = entry.getValue();
    		i++;
    	}
    }
    
    private void sort_and_printValues(double unsorted[]) throws IOException {
    	
    	//save the unsorted values into arrays of class: Node
    	Node[] values;
    	if (rank == 0) {
    		values = new Node[rank0size];
		} else {
			values = new Node[rank1size];
		}
    	int n = 0;
    	for (int i = getstartpoint(rank); i < getstartpoint(rank + 1); i++) {
    		values[n] = new Node();
    		values[n].index = i;
    		values[n].rValues = unsorted[i];
    		n++;
		}
    	
    	//first sort the values in each processor
    	sort(values);
    	
    	//then start merge sort
		int[] proc = new int[size];
		for (int i = 0; i < proc.length; i++) {
			proc[i] = i;
		}
		int self = rank;
		
		int tempBuf[] = new int[1];
		double tempBuf2[] = new double[1];
		boolean trash = false;//use trash to mark whether a processor has send its all data
		while (size >= 2) {//when all data still not in rank0
			if (self % 2 == 0) {//every time odd rank send sorted data to even rank
				if (self + 1 != size) {//if even rank has someone send it data
					MPI.COMM_WORLD.Recv(tempBuf, 0, 1, MPI.INT, proc[self + 1], 1);
					int n2 = tempBuf[0];
					Node[] temp = new Node[n + n2];
					int i = 0, in = 0;
					Node freshman = new Node();
					boolean nomorefresh = true;
					while (i < n + n2) {
						if (nomorefresh && i - in < n2) {
							freshman = new Node();
							MPI.COMM_WORLD.Recv(tempBuf, 0, 1, MPI.INT, proc[self + 1], 1);
							freshman.index = tempBuf[0];
							MPI.COMM_WORLD.Recv(tempBuf2, 0, 1, MPI.DOUBLE, proc[self + 1], 1);
							freshman.rValues = tempBuf2[0];
							nomorefresh = false;//when a new data is used, it is no more fresh, and will be covered by new data
						}
						if (in >= n || values[in].rValues < freshman.rValues) {//merge sort here
							temp[i] = freshman;
							nomorefresh = true;
						} else {//always choose a bigger data to store in temp[]
							temp[i] = values[in];
							in++;
						}
						i++;
					}
					values = temp;
					n = n + n2;
				}
				self = self / 2;//mark itself as next merge loop's new sender or receiver
				for (int i = 0; i < size; i = i + 2) {//every loop we cut half of processors. save which of them can still work in proc[]
					proc[i / 2] = proc[i];
				}
			} else {
				if (!trash) {
					tempBuf[0] = values.length;
					MPI.COMM_WORLD.Send(tempBuf, 0, 1, MPI.INT, proc[self - 1], 1);
					for (int i = 0; i < n; i++) {
						tempBuf[0] = values[i].index;
						MPI.COMM_WORLD.Send(tempBuf, 0, 1, MPI.INT, proc[self - 1], 1);
						tempBuf2[0] = values[i].rValues;
						MPI.COMM_WORLD.Send(tempBuf2, 0, 1, MPI.DOUBLE, proc[self - 1], 1);
					}
					//once a process send all its value, it is trash
					trash = true;
				}
			}
			//everytime the whole size become half
			if (size % 2 == 0) {
				size = size / 2;
			} else {
				size = (size + 1) / 2;
			}
		}
		if (rank == 0) {
			File f = new File(outputFile);
	        OutputStream os = new FileOutputStream(f);
	        DataOutputStream dos = new DataOutputStream(os);	
	    	System.out.println("Number of Iterations: "+String.valueOf(iterations));
	    	for (int i = 0; i < n; i++) {
	    		String s = Double.toString(values[i].rValues)+" "+Integer.toString(values[i].index);
	    		if (i<10) {
	    			System.out.println(s);
	    		}
	    		dos.writeBytes(s +"\n");
			}
	    	dos.close();
	    	os.close();
		}
    }
	
	public void mpi(String[] args) throws IOException {
		
		long startTime = System.currentTimeMillis();
		//initial
		MPI.Init(args);
    	rank = MPI.COMM_WORLD.Rank();
        size = MPI.COMM_WORLD.Size();
        
        //parseArgs and save data
        parseArgs(args);
        
        //tempBuf to pass sizes
        int tempBuf[] = new int[3];
        if (rank == 0) {
        	//get all data from file
        	loadInput_and_init();
        	tempBuf[0] = url_size;
        	tempBuf[1] = rank0size;
        	tempBuf[2] = rank1size;
        }
        MPI.COMM_WORLD.Bcast(tempBuf, 0, 3, MPI.INT, 0);
        if (rank != 0) {
        	url_size = tempBuf[0];
            rank0size = tempBuf[1];
            rank1size = tempBuf[2];
            adjMatrix = new int[url_size][];
        	rankValues = new double[url_size];
        	for (int i = 0; i < rank0size; i++) {
				rankValues[i] = 1.0 / url_size;
			}
		}
        
        //now devide urls and send adjmatrix and initial pageranks
        for (int i = 1; i < size; i++) {
			for (int j = getstartpoint(i); j < getstartpoint(i + 1); j++) {
				if (rank == 0) {
					tempBuf[0] = adjMatrix[j].length;
					MPI.COMM_WORLD.Send(tempBuf, 0, 1, MPI.INT, i, 1);
					MPI.COMM_WORLD.Send(adjMatrix[j], 0, adjMatrix[j].length, MPI.INT, i, 1);
				} else {
					if (rank == i) {
						MPI.COMM_WORLD.Recv(tempBuf, 0, 1, MPI.INT, 0, 1);
						adjMatrix[j] = new int[tempBuf[0]];
						MPI.COMM_WORLD.Recv(adjMatrix[j], 0, adjMatrix[j].length, MPI.INT, 0, 1);
					}
					rankValues[j] = 1.0 / url_size;
				}
			}
		}
        
		for (int i = 0; i < iterations; i++) {
			double ranksum[] = new double[url_size];
			for (int j = getstartpoint(rank); j < getstartpoint(rank + 1); j++) {
				if (adjMatrix[j].length == 0) {
					for (int j2 = 0; j2 < url_size; j2++) {
						ranksum[j2] += rankValues[j] / url_size;
					}
				} else {
					for (int j2 = 0; j2 < adjMatrix[j].length; j2++) {
						ranksum[adjMatrix[j][j2]] += rankValues[j] / adjMatrix[j].length;
					}
				}
			}
			
			MPI.COMM_WORLD.Allreduce(ranksum, 0, ranksum, 0, url_size, MPI.DOUBLE, MPI.SUM);
			
			int[] flag = {0};
			if (rank == 0) {
				double tempdelta = 0;
				for (int j = 0; j < url_size; j++) {
					ranksum[j] = (1 - df) / url_size + df * ranksum[j];
					tempdelta += Math.abs(rankValues[j] - ranksum[j]);
					rankValues[j] = ranksum[j];
				}
				if (tempdelta < delta) {
					flag[0] ++;
				}
			}
			MPI.COMM_WORLD.Bcast(flag, 0, 1, MPI.INT, 0);
			MPI.COMM_WORLD.Bcast(rankValues, 0, url_size, MPI.DOUBLE, 0);
			if (flag[0]==1) {
				break;
			}
		}
		
		
		
		long endTime1 = System.currentTimeMillis();

		sort_and_printValues(rankValues);
		
		long endTime2 = System.currentTimeMillis();

		double totalTime = (endTime2 - startTime) * 0.001;
		double sortTime = (endTime2 - endTime1) * 0.001;
		if (rank == 0) {
			// print out the running time here
			System.out.println("The running time is: " + totalTime + " seconds");
			System.out.println("The sorting time is: " + sortTime + " seconds");
			System.out.println("The sorting time percentage is: " + sortTime / totalTime * 100 + "%");	
		}
		
		MPI.Finalize();
		return;
	}
	
	public static void main(String[] args) throws IOException {
		Distributed_pageRank mpiPR = new Distributed_pageRank();
		mpiPR.mpi(args);
	}
}
