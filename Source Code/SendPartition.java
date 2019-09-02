import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import mpi.MPI;

public class SendPartition {

	public static void main(String[] args) {
		int z, rank, size;
		int root, count;
		int buffer[] = new int[10];

		Map<Integer, ArrayList<Integer>> map[];
		Map<Integer, ArrayList<Integer>> map1[];
		
		
		// int buffer1[] = new int [4];
		int data[] = new int[4];
		MPI.Init(args);
		rank = MPI.COMM_WORLD.Rank();
		size = MPI.COMM_WORLD.Size();
		root = 0;
		count = 4;
		map = new HashMap[4];
		map1 = new HashMap[4];
		for (int x = 0; x < 4; x++) {

			map[x] = new HashMap();
			map1[x] = new HashMap();
		}
		
		
		Map<Integer, List<Integer>> partition[];
		partition = new HashMap[size - 1];

		ArrayList<Integer> list1 = new ArrayList<Integer>(); // {1,2};
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		ArrayList<Integer> list4 = new ArrayList<Integer>();
		ArrayList<Integer> list5 = new ArrayList<Integer>();
		ArrayList<Integer> list6 = new ArrayList<Integer>();
		ArrayList<Integer> list7 = new ArrayList<Integer>();
		ArrayList<Integer> list8 = new ArrayList<Integer>();
		ArrayList<Integer> list9 = new ArrayList<Integer>();
		ArrayList<Integer> list10 = new ArrayList<Integer>();
		ArrayList<Integer> list11 = new ArrayList<Integer>();
		ArrayList<Integer> list12 = new ArrayList<Integer>();

		list1.add(6);
		list1.add(6);
		list2.add(7);
		list2.add(7);
		list3.add(8);
		list3.add(8);
		list4.add(9);
		list4.add(9);
		list5.add(10);
		list5.add(10);
		list6.add(11);
		list6.add(11);
		list7.add(9);
		list7.add(7);
		list8.add(8);
		list8.add(5);
		list9.add(3);
		list9.add(4);
		list10.add(7);
		list10.add(11);
		list11.add(10);
		list11.add(1);
		list12.add(2);
		list12.add(7);

		map[0].put(0, list1);
		map[0].put(1, list2);
		map[0].put(2, list3);
		map[1].put(3, list4);
		map[1].put(4, list5);
		map[1].put(5, list6);
		map[2].put(6, list7);
		map[2].put(7, list8);
		map[2].put(8, list9);
		map[3].put(9, list10);
		map[3].put(10, list11);
		map[3].put(11, list12);
		double pagerank []= new double[12];
		double localrank[] = new double[12];
		// System.out.println(map[0]);
		// int node [] = new int[3];
		// int recvNode [] = new int [3];
		// int edgeList [] = new int [2];
		if (rank == root) {
			

			for (int y = 1; y < map.length; y++) {
				int partitionSize[] = new int[1];
				partitionSize[0] = map[y].size();
				MPI.COMM_WORLD.Send(partitionSize, 0, 1, MPI.INT, y, 0);
				// Sending the partitions to the worker
				for (Map.Entry<Integer, ArrayList<Integer>> entry : map[y].entrySet()) {
					int edgeNumber[] = new int[1];
					edgeNumber[0] = entry.getValue().size();
					MPI.COMM_WORLD.Send(edgeNumber, 0, 1, MPI.INT, y, 1);
					for (int e = 0; e < entry.getValue().size(); e++) {
						List<Integer> edgeList = new ArrayList<>(entry.getValue());
						int[] edge = new int[entry.getValue().size()];
						edge = edgeList.stream().mapToInt(i -> i).toArray();
						MPI.COMM_WORLD.Send(edge, 0, edge.length, MPI.INT, y, 2);
					}
					List<Integer> list = new ArrayList<>(map[y].keySet());
					int node[] = new int[map[y].size()];
					node = list.stream().mapToInt(i -> i).toArray();
					MPI.COMM_WORLD.Send(node, 0, node.length, MPI.INT, y, 3);
				}
			}
		
		} else {
			
			for (int x = 0; x < size - 1; x++) {
				partition[x] = new HashMap<>();
			}
			// Receiving partitions and inserting them into hashmap
			int numberofNode[] = new int[1];
			MPI.COMM_WORLD.Recv(numberofNode, 0, 1, MPI.INT, root, 0);
			// size of a partition
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
				partition[rank - 1].put(recvNode[x], edgelist);
				// insert initial pagerank of a node
				//pagerank.put(recvNode[x], InitialPageRank);
			}
			// for(int x =0; x<3;x++){
			System.out.println(partition[rank-1] + "Rank " + rank);
			 //}
			// Transpose the hashmap to calculate the pagerank.
		}
		// System.out.println(partition[2] + "Rank " + rank);
		// PAGE RANK CALCULATION 
		//double pagerank [] = new double[36];
		double TempPageRank [] = new double[12];
		//Map<Integer, Double> pagerank = new HashMap();
		//Map<Integer, Double> TempPageRank = new HashMap<>();
		double InitialPageRank = 0.0;
		double dampingFactor = 0.85;
		// double TempPageRank[] = new double[10000];
		int ITERATION_STEP = 0;
		double OutgoingLinks = 0;
		//double totalNodes = 5;
		int k ;
		 for( k=0;k<12;k++){
               pagerank[k]= InitialPageRank;
               }
		while (ITERATION_STEP <= 2) // Iterations
		{
//for (int iter =0; iter<ITERATION_STEP; iter++) {
			
     	  for(k=0;k<12;k++)
     	  {  
     	    TempPageRank[k]=pagerank[k];
     	    pagerank[k]=0;
     	   }
     	  ////-------------
     	  for (int p =0; p<size; p++) {
     	 if(rank==0) {
			for (Entry<Integer, ArrayList<Integer>> entry2 : map[0].entrySet()) {
				//double localrank[] = new double [1]; 
				for (int i = 0; i < entry2.getValue().size(); i++) {
					// System.out.println(entry2.getValue().get(i));

					// OutgoingLinks=outgoingLinks.get(entry2.getValue().get(i));
					//double value = pagerank.get(entry2.getKey());
					//value += TempPageRank.get(entry2.getValue().get(i)) * (1 / entry2.getValue().size());
					//pagerank.put(entry2.getKey(), value);
					System.out.println(" Heloooo in master  "+pagerank[entry2.getKey()]+ " node "+ entry2.getKey()+ " Iteration "+ ITERATION_STEP);
					System.out.println("edge list "+ entry2.getValue().get(i)+ " and rank "+pagerank[entry2.getValue().get(i)] );
					 pagerank[entry2.getKey()]+=TempPageRank[entry2.getValue().get(i)]*(1/entry2.getValue().size());
					 pagerank[entry2.getKey()]= (1-dampingFactor)+ dampingFactor*pagerank[entry2.getKey()];
					 //localrank[entry2.getKey()] = pagerank[entry2.getKey()]; 	
				}
			}
			
		} else {
			 for (Map.Entry<Integer, List<Integer>> entry2 : partition[rank-1].entrySet())
			  { 
				  for(int i =0;i<entry2.getValue().size();i++)
				  {
			  //System.out.println(entry2.getValue().get(i)); 
			  //OutgoingLinks=outgoingLinks.get(entry2.getValue().get(i));
					 //double  value = pagerank.get(entry2.getKey()); 
					// System.out.println("The node is  : " +entry2.getKey());
					 //System.out.println(" entry2.getValue().get(i) : "+entry2.getValue().get(i));
					// if (TempPageRank.get(entry2.getValue().get(i))==null) {
						// double v = 0.0;
						 //TempPageRank.get(entry2.getValue().get(i)) = 0.0;
					 //}
					// System.out.println("TempPageRank.get(entry2.getValue().get(i)) : " +TempPageRank[entry2.getValue().get(i)]+ " Rank "+ rank);
					// System.out.println("entry2.getValue().size() : " +entry2.getValue().get(i));
			  //value +=TempPageRank.get(entry2.getValue().get(i))*(1/entry2.getValue().size());
			  //pagerank.put(entry2.getKey(), value);
			  pagerank[entry2.getKey()]+=TempPageRank[entry2.getValue().get(i)]*(1/entry2.getValue().size()); 
			  
					  pagerank[entry2.getKey()]= (1-dampingFactor)+ dampingFactor*pagerank[entry2.getKey()];
						// localrank[entry2.getKey()] = pagerank[entry2.getKey()]; 
						
			  //System.out.println(" pagerank "+pagerank[entry2.getKey()]+ " Rank "+ rank); 
			//  localrank[i] = i+5;
			  } 
				  //localrank[0] =+9;
				//  MPI.COMM_WORLD.Bcast(localrank, 0, 3, MPI.DOUBLE, rank);
				  
				 // MPI.COMM_WORLD.Allgather(pagerank, 0, 1, MPI.DOUBLE, pagerank, 0,  1, MPI.DOUBLE);
				  }
			
		}
     	MPI.COMM_WORLD.Bcast(pagerank, 0, 12, MPI.DOUBLE, p);
     	 //////////////
		}
			// System.out.printf("\n in Master After "+ITERATION_STEP+"th Step \n");

			 for(k=0;k<12;k++) {
				// System.out.println(" Page Rank of "+k+" is : "+pagerank[k]+" " + " Iteration "+ ITERATION_STEP+ " rank "+ rank);
			 }
			// System.out.println("Partition "+x+ " "+pagerank);
			ITERATION_STEP = ITERATION_STEP + 1;
			
			
			//MPI.COMM_WORLD.Allgather(data, 0, 1, MPI.INT, buffer, 0, 1, MPI.INT);
			
			
		}
		//MPI.COMM_WORLD.Barrier();
		// MPI.COMM_WORLD.Bcast(pagerank, 0, 3, MPI.DOUBLE, root);
		
		///for(k=0;k<12;k++)
		     //   {
		        //  pagerank[k]=(1-dampingFactor)+ dampingFactor*pagerank[k]; 
		          //System.out.println(" pagerank "+pagerank[k] + "Rank " + rank);
		         // localrank[k] = pagerank[k];
		      //    } 
		// MPI.COMM_WORLD.Barrier();
		
		
		//MPI.COMM_WORLD.Alltoall(localrank, 0, 3, MPI.DOUBLE, pagerank, 0, 3, MPI.DOUBLE);
		
		
		
		
		for(int x =0; x<pagerank.length; x++) {
			System.out.println("page rank ------ "+x+ "  " + pagerank[x]+ " Rank "+ rank);
		}
		
		// for (int x =0; x<3; x++) {
		// System.out.println("Map values "+ map1[x] + " Rank "+ rank );
		// System.out.println(" After sending and recieving map "+ node[x]+ " Rank "+
		// rank);
		// }
		// System.out.println(" Before --- Rank is " + rank + " Value at buffer " +
		// (count - 1) + " is " + buffer[count - 1]);
		// for(int x =0;x< map.length;x++) {
		// MPI.COMM_WORLD.Bcast(map[x], 0, count, MPI.INT, root);
		// }
		// System.out.println(" Rank is " + rank + " Value at buffer " + (count - 1) + "
		// is " + buffer[count - 1]);

		// if (rank!=root) {
		// buffer1[0] = 10;
		// }

		/*
		 * for (int x =0;x<buffer.length;x++) { System.out.println(" buffer "+
		 * buffer[x]); }
		 */

		// MPI.COMM_WORLD.Barrier();
		// gather output matrix from all the nodes

		// MPI.COMM_WORLD.Gather(sendbuf, sendoffset, sendcount, sendtype, recvbuf,
		// recvoffset, recvcount, recvtype, root);
		// MPI.COMM_WORLD.Gather(data, 0, 1, MPI.INT, buffer, 0,1, MPI.INT, root);
		// MPI.COMM_WORLD.Gather(data, 1, 1, MPI.INT, buffer, 0,1, MPI.INT, root);
		// System.out.println("After-- Rank is " + rank + " Value at buffer " + (count -
		// 1) + " is " + buffer[count - 1]);
		// System.
		
		MPI.Finalize();

	}

}