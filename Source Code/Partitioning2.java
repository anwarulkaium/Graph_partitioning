//package SampleExamples;

	import java.io.File;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;
	import java.util.StringTokenizer;

	import mpi.*;

	public class Partitioning2 {
		static public void main(String[] args) throws Exception {
			try {
				Partitioning2 c = new Partitioning2(args);
				System.out.println("Stat");
			} catch (Exception e) {
			}
		}
		public Partitioning2(){
		}

		public Partitioning2(String[] args) throws Exception {
			int root, i, j, k;
			
			int myself, tasks;
	         //starting MPI
			MPI.Init(args);
			
			//finding rank of current process
			myself = MPI.COMM_WORLD.Rank();
			//finding total number of processes (or tasks)
			tasks = MPI.COMM_WORLD.Size();
			//size of the matrix is assumed to be equal to be number of tasks 
			final int size =tasks;
			Scanner matrixA = new Scanner(new File("C:/Users/mpatwary/Desktop/workspace1/Assignment2/src/sampleExamples/matrixA.txt"));
			Scanner matrixB = new Scanner(new File("C:/Users/mpatwary/Desktop/workspace1/Assignment2/src/sampleExamples/matrixB.txt"));
			//Scanner matrixA = new Scanner(new File("/Users/Anwarul/Documents/workspace/Assignment2/src/SampleExamples/matrixA.txt"));
			//Scanner matrixB = new Scanner(new File("/Users/Anwarul/Documents/workspace/Assignment2/src/SampleExamples/matrixB.txt"));
			
			System.out.println(" ===="+ tasks);
			
			List<Integer> listMatrixA = new ArrayList<Integer>(); 
			List<Integer> listMatrixB = new ArrayList<Integer>(); 
			
			int MatrixA[]=new int[size*size];
			int MatrixB[][]=new int[size][size];// input matrix
			int TransposedB[] = new int [size*size];// After transposing Matrix B
			
			int C[]=new int[size*size];//input matrix..assumed to be already transposed
			
			int in1[] = new int[size];
			int in2[] = new int[size*size];
			int lineCounter = 1;
			String line;
			if (myself == 0)//this is run master node
			{
			while (matrixA.hasNextLine()) {
				line = matrixA.nextLine();
				StringTokenizer token = new StringTokenizer(line);
				while (token.hasMoreTokens()) {
					String element = token.nextToken();
					int value = Integer.parseInt(element);
					//Matrix[]
					listMatrixA.add(value);
				}

				
			}
			while (matrixB.hasNextLine()) {
				line = matrixB.nextLine();
				StringTokenizer token = new StringTokenizer(line);
				while (token.hasMoreTokens()) {
					String element = token.nextToken();
					int value = Integer.parseInt(element);
					listMatrixB.add(value);
				}

				
			}
			for(int x =0; x<MatrixA.length; x++){
				MatrixA[x] = listMatrixA.get(x);	
			}
		
			
			for(i =0; i<MatrixB.length; i++){
				
				for(int y =0;y<MatrixB.length;y++){
				MatrixB[i][y] = listMatrixB.get(y+(MatrixB.length*i));	
			}
			}

			System.out.println("Matrix A");
			for(i=0;i<MatrixA.length;i++)
			{
				System.out.print(MatrixA[i]+" ");
				if((i+1)%4==0)
					System.out.println();
				
			}
			System.out.println("\nMatrix B");
			
			 for (i = 0; i < 4; i++) {
		            for (int y = 0; y < 4; y++) {
		                System.out.printf("%4d", MatrixB[i][y]);
		            }
		            System.out.println();
		        }
			
			//Tranposing Matrix B 
			
			for(i=0;i<MatrixB.length;i++)
			{
				for(int y=i+1;y<MatrixB.length;y++){
					int temp = MatrixB[i][y];
					MatrixB[i][y] = MatrixB[y][i];
					MatrixB[y][i] = temp;
			}
			}
			// print out transposed matrix
	        System.out.println();
	        System.out.println("After Transposing Matrix B");
	        System.out.println("------");
	        for (i = 0; i < MatrixB.length; i++) {
	            for (int y = 0; y < MatrixB.length; y++) {
	                System.out.printf("%4d", MatrixB[i][y]);
	            }
	            System.out.println();
	        }
	        // converting MatrixB into one dimension array
	        for (i = 0; i < MatrixB.length; i++) {
	            for (int y = 0; y < MatrixB.length; y++) {
	            	TransposedB[y+(MatrixB.length*i)] = MatrixB[i][y];  
	            }
	        }
	        System.out.println("After conversion to single dimension array");
	        System.out.println("------");
	        for(i=0;i<TransposedB.length;i++)
			{
				System.out.print(TransposedB[i]+" ");
				if((i+1)%size==0)
					System.out.println();
				
			}
			
			}	
			//scattering the rows of matrix B to all the nodes including master node
			System.out.println("Before scatter");
			///for(int x=0;x<size;x++){
			MPI.COMM_WORLD.Scatter(MatrixA, 0, size, MPI.INT, in2, 0,size, MPI.INT, 0);
			//System.out.println("Array value: "+in2[x]+": "+in2[15]);
			//}
			for (int x =0; x<MatrixA.length;x++){
				System.out.println("   				"+MatrixA[x]);
				
			}
			
			//System.out.println("after scatter");
			
			for(i=0;i<size;i++){
				
				System.out.println("after scatter");
				//send row to 
				//sending A matrix to all the nodes including master node 
				MPI.COMM_WORLD.Bcast(TransposedB,i*size, size, MPI.INT, 0);
				//matrix computation for partitioned data by each individual node(including master)
				
				for(int j1=0;j1<size;j1++){
					System.out.println(myself+" Matrix A:"+TransposedB[j1+i*size]);
					
					in1[i]+=TransposedB[j1+i*size]*in2[j1]; 
					
					System.out.println("process: "+myself+" output : "+in1[i]);
				}
			}
			System.out.println("Complete");
			//syncronisation step
			MPI.COMM_WORLD.Barrier();
			//gather output matrix from all the nodes
			MPI.COMM_WORLD.Gather(in1, 0, size, MPI.INT, C, 0, size, MPI.INT, 0);
			
			if (myself == 0){
				System.out.println("Matrix TEST COMPLETE");
				System.out.println("C:");
				int c=0;
				for(i=0;i<size;i++){
				   for(j=0;j<size;j++)
					 System.out.print(C[i+j*size]+" ");
					System.out.println();
				}
			}
			MPI.Finalize();
		}
	}

