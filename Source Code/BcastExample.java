import java.util.HashMap;
import java.util.Map;

import mpi.*;

public class BcastExample {

	public static void main(String[] args) throws InterruptedException {
		int rank, size;
		int root, count;
		int pagerank[] =new int [5];;
		//int localBuffer[];
		//String portName = Intracomm.openPort();
		
		//MPI.COMM_WORLD.
		Map map[];
		//int buffer1[] = new int [4];
		
		int data[] = new int[4];
		MPI.Init(args);
		rank = MPI.COMM_WORLD.Rank();
		size = MPI.COMM_WORLD.Size();
		root = 0;
		count = 4;
		map = new HashMap[4];
		
		for (int x =0; x<4; x++) {
			
			map[x] = new HashMap();
		}
		
		map[0].put(1, 1);
		map[0].put(1, 1);
		map[0].put(1, 1);
		map[1].put(2, 2);
		map[1].put(2, 2);
		map[1].put(2, 2);
		map[2].put(3, 3);
		map[2].put(3, 3);
		map[2].put(3, 3);
		map[3].put(4, 4);
		map[3].put(4, 4);
		map[3].put(4, 4);
		for (int y =0; y<2; y++) {
			//MPI.COMM_WORLD.Barrier();
		for (int x=0;x<size; x++) {
				//for(int i =0; i<pagerank.length;i++) {
				if(rank==0) {
				pagerank[1] = 1+y;
				}else {
				pagerank[0] = 8+y;
				pagerank[2] = 8+y;
				pagerank[3] = 8+y;
				pagerank[4] = 8+y;
				//}
				
				
			}
				
				//for (int p=1;p<size;p++) {
					//System.out.println(p);
					//MPI.COMM_WORLD.Barrier();
		MPI.COMM_WORLD.Bcast(pagerank, 0, 5, MPI.INT, x);
		//MPI.COMM_WORLD.Barrier();
				}
		
			
			//}
			
for (int x =0; x<pagerank.length; x++) {
				
				
				System.out.println(pagerank[x]+ "Index is "+x+" Rank is--- "+rank+ " loop "+ y );
			}
			
		}
		
		//if (rank ==0) {
			
			
		//}
			
		
		
		/*
		if (rank == root) {
			//MPI.COMM_WORLD.Barrier();
			//buffer = new int [5];
			//localBuffer = new int[1];
			//System.out.println(buffer[2]);
			//for (i = 0; i < buffer.length; i++) {
			//localBuffer[0] = 6+y;
				pagerank[1] = 8+y;
				//System.out.println(buffer[i]);
			//}
				//MPI.COMM_WORLD.Bcast(pagerank, 0, 5, MPI.INT, 0);
				//MPI.COMM_WORLD.Barrier();
				for(int x =0; x< pagerank.length;x++) {
					System.out.println(pagerank[x]+ " Rank is--- "+rank + " loops "+ y);	
					}
				//MPI.COMM_WORLD.Barrier();
		} else  {
			//MPI.COMM_WORLD.Barrier();
			//buffer = new int [5];
			//localBuffer = new int[5];
			//for (int x=0;x<buffer.length;x++) {
			//if (rank==1) {
				pagerank[0] = 5+y;
			//}else {
				//buffer[1] = 5+y;
				pagerank[2] = 11+y;
				pagerank[3] = 11+y;
				pagerank[4] = 5+y;
			//}
				
				//MPI.COMM_WORLD.Barrier();
				//if (rank == 2)
				
				
				//MPI.COMM_WORLD.Bcast(pagerank, 0, 5, MPI.INT, 1);
				//MPI.COMM_WORLD.Barrier();
				
				for(int x =0; x< pagerank.length;x++) {
					System.out.println(pagerank[x]+ " Rank is "+rank + " loops "+ y);	
					}
				//MPI.COMM_WORLD.Barrier();
		}
		System.out.println(rank);
		MPI.COMM_WORLD.Bcast(pagerank, 0, 5, MPI.INT, 0);
		
		//MPI.COMM_WORLD.Allgather(buffer, 0, 5, MPI.INT, buffer, 0,5, MPI.INT);
		
		//for(int p=0; p<size; p++) {
			//if (b==0) {
			//System.out.println(b);
		
		//System.out.println(" TASK " + rank + " BEFORE BARRIER, TIME = "
				//+ (MPI.Wtime()));
		
		//System.out.println(" TASK " + rank);
		//System.out.println(" TASK " + rank + " After BARRIER, TIME = "
				//+ (MPI.Wtime()));
			//} else {
				//MPI.COMM_WORLD.Bcast(buffer, 1, 4, MPI.INT, b);
			//}
		
		//}
	//	MPI.COMM_WORLD.wait();
		//for(int x =0;x< buffer.length;x++) {
		//	System.out.println(buffer[x]+ " Rank is "+rank );	
		//MPI.COMM_WORLD.Bcast(map[x], 0, count, MPI.INT, root);
		//}
	//	}
	//	MPI.COMM_WORLD.Barrier();
		//MPI.COMM_WORLD.Bcast(pagerank, 0, 5, MPI.INT,rank);
		//MPI.COMM_WORLD.Barrier();
		}
		
		//MPI.COMM_WORLD.Barrier();
		//System.out.println(" Before --- Rank is " + rank + " Value at buffer " + (count - 1) + " is " + buffer[count - 1]);
		//System.out.println(" Rank is " + rank + " Value at buffer " + (count - 1) + " is " + buffer[count - 1]);
		//if (rank!=root) {
			//buffer1[0] = 10;
		//}
		for (int x =0;x<buffer.length;x++) {
			System.out.println(" buffer "+ buffer[x]);
		}
		//MPI.COMM_WORLD.Barrier();
		//gather output matrix from all the nodes
			
		//MPI.COMM_WORLD.Gather(sendbuf, sendoffset, sendcount, sendtype, recvbuf, recvoffset, recvcount, recvtype, root);
		//MPI.COMM_WORLD.Gather(data, 0, 1, MPI.INT, buffer, 0,1, MPI.INT, root);	
		//MPI.COMM_WORLD.Gather(data, 1, 1, MPI.INT, buffer, 0,1, MPI.INT, root);
	//	System.out.println("After-- Rank is " + rank + " Value at buffer " + (count - 1) + " is " + buffer[count - 1]);
		*/
		
		MPI.Finalize();

		}

}