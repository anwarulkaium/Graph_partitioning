
import mpi.MPI;

public class GatherExample {

	public static void main(String[] args) {
		int i, rank, size;
		int root, count;
		int buffer[] = new int[4];
		//int buffer1[] = new int [4];
		int data[] = new int[4];
		MPI.Init(args);
		rank = MPI.COMM_WORLD.Rank();
		size = MPI.COMM_WORLD.Size();
		root = 0;
		count = 4;
		
		for(int y =0; y<2;y++) {
		if (rank == root) {
			for (i = 0; i < count; i++) {
				buffer[i] = i;
				
			}
			System.out.println(buffer[3]);
		} else {
			for (int x=0;x<data.length;x++) {
			data[x] =10+y;
			
			}
		}
		//MPI.COMM_WORLD.Bcast(buffer, 0, count, MPI.INT, root);
		for(int x =0;x<size;x++){
		//System.out.println(" Before --- Rank is " + rank + " Value at buffer " + (count - 1) + " is " + buffer[x]);//buffer[count - 1]);
		System.out.println("Before-- Rank is " + rank + " Value at buffer " + x + " is " + buffer[x]+ " in "+ y);//buffer[count - 1]);
		
		//System.out.println(" Rank is " + rank + " Value at buffer " + (count - 1) + " is " + buffer[count - 1]);
		}
		//MPI.COMM_WORLD.Bcast(buffer, 0, count, MPI.INT, root);
		//if (rank!=root) {
			//buffer1[0] = 10;
		//}
		
		/*for (int x =0;x<buffer.length;x++) {
			System.out.println(" buffer "+ buffer[x]);
		}*/
			
		//MPI.COMM_WORLD.Barrier();
		//gather output matrix from all the nodes
			
		MPI.COMM_WORLD.Allgather(data, 0, 1, MPI.INT, buffer, 0, 1, MPI.INT);
		//MPI.COMM_WORLD.Gather(data, 0, 1, MPI.INT, buffer, 0,1, MPI.INT, root);	
		//MPI.COMM_WORLD.Gather(data, 1, 1, MPI.INT, buffer, 0,1, MPI.INT, root);
		for(int x=0;x<size;x++){
		//System.out.println("After-- Rank is " + rank + " Value at buffer " + (count - 1) + " is " + buffer[x]);//buffer[count - 1]);
		System.out.println("After-- Rank is " + rank + " Value at buffer " + x + " is " + buffer[x]+ " in "+ y);//buffer[count - 1]);
		}
		
		
		}
		MPI.Finalize();
	}

}