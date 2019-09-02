import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mpi.*;
public class HelloMpj {
	public static void main (String [] arg) throws Exception {
		// initialize the MPJ express library
		MPI.Init(arg);
		// rank of the world communicator
		int rank = MPI.COMM_WORLD.Rank();
		// size of the world communicator
		int size = MPI.COMM_WORLD.Size();
		
		
		int [] PageRank = new int[10];
		//int [] PageRank1 = new int[10];
		
		
		
		
		
		if(rank ==0) {
			int sendbuf [] =new int [4];
			
			
			for (int x =0;x<PageRank.length; x++) {
				
				PageRank[x] = x;
			}
			
			/*Map<Integer, Double> PageRank = new HashMap();
			PageRank.put(1, 1.0);
			PageRank.put(2, 1.5);
			PageRank.put(3, 2.0);
			PageRank.put(4, 2.5);
			PageRank.put(5, 3.0);*/
			//for(int x =0;x<5;x++) {
			//MPI.COMM_WORLD.Alltoall(PageRank, 0, 2, MPI.INT, PageRank, 0, 2, MPI.INT);
			//}
			//System.out.println();
			
			//MPI.COMM_WORLD.Allreduce(localRV,0, FinalRVT,0,totalNumUrls, MPI.DOUBLE, MPI.SUM); 
			for(int x =0;x<sendbuf.length; x++) {
				sendbuf[x] = 10;
			}
			//Map<Integer, List<Integer>> map = new HashMap();
			for (int i =1; i<size; i++) {
			//MPI.COMM_WORLD.Send(sendbuf, (i-1)*4,4,MPI.INT,i,100);
			MPI.COMM_WORLD.Send(sendbuf, 0,4,MPI.INT,i,100);
			//
			}
			//for(int i=1;i<size;i++)
				//MPI.COMM_WORLD.Recv(sendbuf, (i-1)*4,4,MPI.INT,i,100);
			//for(int i =0;i<4*(size-1); i++)
			//System.out.print(sendbuf[i]+ " ");
		} else {
			
			for(int x=0;x<10;x++) {
				//System.out.println("Ranks "+ rank + " Size "+ size+ "  "+ PageRank[x] );
			}
			
			int recvbuf[] = new int[4];
			MPI.COMM_WORLD.Recv(recvbuf, 0, 4, MPI.INT, 0,100);
			System.out.println(" recevbuf "+recvbuf[2]);
			
			
			//for(int i =0; i<4; i++) recvbuf[i] = rank;
			
			//MPI.COMM_WORLD.Send(recvbuf,0 , 4, MPI.INT, 0, 100);
		}
		
		//MPI.COMM_WORLD.Bcast(PageRank, 0, 10, MPI.INT, 0);
		
		
		MPI.Finalize();
		
	}

}
