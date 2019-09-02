import java.util.HashMap;
import java.util.Map;

import mpi.*;

public class SimpleTest {
	
	static Map<Integer, Integer> map[];  

	public static void main(String[] arg) {
		map = new HashMap[2];
		for (int x =0; x<2; x++) {
			map[x] = new HashMap<>();	
		}
		map[0].put(1, 1);
		map[0].put(2, 2);
		map[1].put(3, 3);
		map[1].put(4, 4);
		
		MPI.Init(arg);

		int rank = MPI.COMM_WORLD.Rank();
		int size = MPI.COMM_WORLD.Size();

		
		System.out.println(rank);
		// int value =0;
		if (rank == 0) {
			Object arr[] = new Object[5];
			for (int x = 0; x < arr.length; x++) {
				arr[x] = x;
			}
			
			
			//MPI.COMM_WORLD.Send(arr, 0, arr.length, MPI.OBJECT, 1, 12);
			System.out.println("Senddd " + map[0]);
			// value++;
		} else if (rank == 1) {
		Object arr1[] = new Object[5];
		int x = 3, y = 4;
		//if (x == y) {
			
			MPI.COMM_WORLD.Gather(arr1, 0, arr1.length, MPI.OBJECT, y, y, y, null, y);
			//MPI.COMM_WORLD.Recv(arr1, 0, arr.length, MPI.OBJECT, 0, 12);
				// Object array = new int[5];
				// array = arr1[4];
		//}
		System.out.println(" Receieve " + map[1]);
		System.out.println("I am in process 1 " + arr1[4]);	
		}
		
		//MPI.COMM_WORLD.Bcast(arr, 0, arr.length, MPI.OBJECT, 1);
		MPI.Finalize();
	}

}
