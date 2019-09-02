
import java.util.*;
import java.io.*;
import mpi.*;

public class Mpi_PagerankOrig {

	public static void mpi_read(String filename, HashMap<Integer, ArrayList<Integer>> adjacency_matrix, ArrayList<Integer> am_index, Intracomm communicator, int debug)
	{
		int totalNumOfUrl = 0;
		int totalRank = 0;
		int numOfDivisions = 0;
        int remainder = 0;
        int startIndex = 0;
        int blockSize = 0;
		int rank = communicator.Rank();
		
		if(rank == 0)
		{
			try
			{
				FileInputStream file=new FileInputStream(filename);
		    	DataInputStream datastr = new DataInputStream(file);
		    	BufferedReader urlreader=new BufferedReader(new InputStreamReader(datastr));
		    	String adjmatrix;
		    	
		    	//Read File
		    	if(debug ==1)
			    	System.out.println("Reading from the input file");
		    	
		    	while((adjmatrix=urlreader.readLine())!=null)
		    	{
		    		ArrayList<Integer> target_urls_list=new ArrayList<Integer>();
		    		
		    		//Separates first node from rest of the nodes
		    		String[] nodelist = adjmatrix.split(" ");
		    		for(int i=1;i<nodelist.length;i++)
		    		{
		    			target_urls_list.add(Integer.valueOf(nodelist[i]));
		    		}
		    		
		    	 	adjacency_matrix.put(Integer.valueOf(nodelist[0]),target_urls_list);
		    	}
		    	datastr.close();
		    	
		    	if(debug == 1)
		    	{
		    		System.out.println("Completed reading input file into adjacency_matrix");
		    	}
		    	
		    	//printing adjacency matrix 
		    	if(debug==1)
		    	{
		    		if(rank == 0)
		    		{
		    		
		    			Iterator<Integer> ite= adjacency_matrix.keySet().iterator();
		    			ArrayList<Integer> target_urls_set=new ArrayList<Integer>();
		    			while(ite.hasNext())
		    			{
		    				int src = ite.next().intValue();
		    				System.out.print("Source: "+src+":");
		    				target_urls_set = adjacency_matrix.get(src);
		    				int outd = target_urls_set.size();
		    				for(int k=0;k<outd;k++)
		    				{
		    					System.out.print("\t"+target_urls_set.get(k).intValue());
		    				}
		    				System.out.println("\t");
		    			}
		    		}
		    	}
		    	
			}
			catch(Exception ex)
			{
				System.err.println("Error 1 : "+ ex.getMessage());
			}
			
			totalNumOfUrl = adjacency_matrix.size();
			totalRank = communicator.Size();
			numOfDivisions = (totalNumOfUrl) / totalRank;
		  	remainder = (totalNumOfUrl) % totalRank;
		  	System.out.println("Numberof Divisions:"+numOfDivisions + " and Remainder: "+ remainder);
		  	if(debug==1)
		  		System.out.println("Numberof Divisions:"+numOfDivisions + " and Remainder: "+ remainder);
		  	
		  	ArrayList<Integer> sourceUrls = new ArrayList<Integer>(adjacency_matrix.keySet());
		  	
		  	if(debug==1)
		  	{
		  		for(int a=0; a < sourceUrls.size();a++)
		  		{
		  			System.out.println("SrcUrl:"+ sourceUrls.get(a));
		  		}
		  	}

            int strtIndex = 0, j=0;
            try
            {
	            for (int i = 0; i < totalRank; i++)
		        {
	            	startIndex = strtIndex; 
	                      	
	                int index =0;
	
	                //Calculate block size
		        	if(remainder == 0)
				    {
	                    blockSize = numOfDivisions;
				    }
	                else
	                {
	                	blockSize = (i < remainder) ? (numOfDivisions + 1) : (numOfDivisions);
	                }
	
		        	int [] t_am_index =new int[blockSize*2]; 
	                for (strtIndex = startIndex; strtIndex <= ((startIndex+blockSize)-1); strtIndex++)
		            {
	                	
	                         int source = sourceUrls.get(j++);
	                         ArrayList<Integer> targetUrls =  adjacency_matrix.get(source);
	                         int outdegree = targetUrls.size();
	                         
	                         t_am_index[index++]= source;
	                         t_am_index[index++]= outdegree;
	                         
	                }
	                
	                int[] am_size= new int[1]; 
	                am_size[0]=blockSize*2;
	
	                if(i ==0)
	                {
	                	for (int l=0; l<am_size[0];l++)
	                	{
	                		am_index.add(t_am_index[l]);
	                	}
	                }
	                else
	                {
	                	communicator.Send(am_size, 0, 1, MPI.INT, i, 0);
	                	communicator.Send(t_am_index, 0, am_size[0], MPI.INT, i, 1);
	                }
	                
	                
	                for(int k=0;k<blockSize*2; k =k+2)
	                {
	                    int source = t_am_index[k];
	                    int outdegree = t_am_index[k+1];
	                    int[] targetList= new int[outdegree];
	
	                    ArrayList<Integer> targetUrls = adjacency_matrix.get(source);
	
	                    for(int n=0;n<outdegree;n++)
	                    {
	                    	targetList[n]=targetUrls.get(n);
	                    }
	
	                    if(i!=0)
	                    {
	                    	communicator.Send(targetList, 0, outdegree, MPI.INT, i, 2);
	                    }
	                }
	
		        }
            }
            catch(Exception ex)
            {
            	System.out.println("Error 2 : "+ ex.getMessage());
            }
		}
            
		
		else
		{
			
			    int[] am_size= new int[1];
		        communicator.Recv(am_size, 0, 1, MPI.INT, 0, 0);
		        System.out.println("am_size "+ am_size[0]);
		        int[] t_am_index= new int[am_size[0]];
		        communicator.Recv(t_am_index, 0, am_size[0], MPI.INT, 0, 1);
		        System.out.println("t_am_index "+ t_am_index[0]);
		        for (int l=0; l<am_size[0];l++)
		        {
		            am_index.add(t_am_index[l]);
		        }

		        int no2Urls = am_size[0];
		        System.out.println("no2Urls "+ no2Urls);
		        for(int p=0; p<no2Urls;p=p+2)
		         {
		             int sourceUrl = t_am_index[p];
		             int outdegree = t_am_index[p+1];
		             int[] target= new int[outdegree];
		             communicator.Recv(target, 0, outdegree, MPI.INT, 0, 2);
		             ArrayList<Integer> targetUrls = new ArrayList<Integer>();

		             for(int m=0;m<outdegree;m++)
		             {
		            	 targetUrls.add(target[m]);
		             }

		            adjacency_matrix.put(sourceUrl, targetUrls);
		         }
		        
		}

	}
	
	
	public static void mpi_pagerankfunc(HashMap<Integer,ArrayList<Integer>>adjacencyMatrix,ArrayList<Integer>amIndex, int numUrls, int totalNumUrls, 
			int numIterations, double threshold, double[] FinalRVT, Intracomm communicator, int debug)
	{
		
		try
		{
	    /* Definitions of variables */ 
		double delta = 0.0, dangling=0.0, sum_dangling =0.0, intermediate_rank_value = 0, damping_factor = 0.85;
		int source =0,outdegree = 0, targetUrl, loop = 0;  
		ArrayList<Integer> targetUrls = new ArrayList<Integer>(); 
		
		
		/* Allocate memory and initialize values for local_rank_values_table */ 
		double [] intermediateRV = new double[totalNumUrls]; 
		double [] localRV = new double[totalNumUrls]; 
		double [] danglingArray = new double[1]; 
        double [] sumDangling=new double[1]; 
        double [] deltaArray = new double[1]; 
        deltaArray[0] = 0.0;
        
        /* Get MPI rank */ 
		int rank = communicator.Rank();
			
		 if(rank == 0)
	        	System.out.println("Max_Iterations: "+ numIterations + ", Threshold: "+threshold);
	    /* Start computation loop */ 
	    do 
	    { 
	        /* Compute pagerank and dangling values */ 
			dangling = 0.0;
			
			for(int i = 0; i <amIndex.size();i=i+2) //am_index = anIndex
            {
				source = amIndex.get(i);
				//System.out.println(" adjacencyMatrix.get(source) " + adjacencyMatrix.get(source));
				targetUrls =  adjacencyMatrix.get(source);
				outdegree = targetUrls.size();
				System.out.println(source +" outdegree----- " + outdegree);
				
				for (int j=0;j<outdegree;j++)
				{
					targetUrl = targetUrls.get(j);
					//System.out.println(" localRV[targetUrl] "+ localRV[targetUrl]+ " "+ targetUrl);
					intermediate_rank_value = localRV[targetUrl] +FinalRVT[source] /(double)outdegree;
					localRV[targetUrl] = intermediate_rank_value;
				}
				
				if(outdegree == 0)
				{
					dangling += FinalRVT[source];
				}
            }
			

	        /* Distribute pagerank values */ 
			//System.out.println(" Before "+FinalRVT[0]);
			communicator.Allreduce(localRV,0, FinalRVT,0,totalNumUrls, MPI.DOUBLE, MPI.SUM); 
	 
			
	        /* Distribute dangling values */ 
			danglingArray[0] = dangling;
			communicator.Allreduce(danglingArray,0, sumDangling ,0, 1, MPI.DOUBLE, MPI.SUM); 
			sum_dangling = sumDangling[0];
			if(debug==1 && rank == 0)
				System.out.println("sum_dangling in loop "+ loop +" is: "+ sum_dangling);
			
	        /* Recalculate the page rank values with damping factor 0.85 */ 
	        /* Root(process 0) computes delta to determine to stop or continue */ 
			System.out.println("Total number of URLSSSS "+ totalNumUrls+ " matrix size "+ adjacencyMatrix.size()+ " Rank is "+ rank);
			if(rank ==0)
	         {
				
	        	 double dangling_value_per_page = sum_dangling / totalNumUrls;
	        	 
	        	 for (int i=0;i<totalNumUrls;i++)
                 {
                        FinalRVT[i]=FinalRVT[i]+dangling_value_per_page;
                 }
                
	        	 for (int i=0;i<totalNumUrls;i++)
	        	 {
                        FinalRVT[i]= damping_factor*FinalRVT[i]+(1-damping_factor)*(1.0/(double)totalNumUrls);
	        	 }
	 
	        	 deltaArray[0] = 0.0;
	        	 
	        	 
	        	 for(int i=0;i<totalNumUrls;i++)
	        	 { 
	        		 
	        		 deltaArray[0] += Math.abs(intermediateRV[i] - FinalRVT[i]);
	        		 intermediateRV[i] = FinalRVT[i];
	        	 }
	        		        	         	
	         }
			
			 communicator.Bcast(deltaArray, 0, 1, MPI.DOUBLE, 0);
        	 
	         communicator.Bcast(FinalRVT, 0, totalNumUrls, MPI.DOUBLE, 0); 
	         
	         
	         for (int k = 0; k<totalNumUrls;k++)
			 {
	        	localRV[k] = 0.0;
			 }
	         	         
	         if(rank == 0)
	        	 System.out.println("--Current Iteration: "+ loop + " delta: "+deltaArray[0]);
		 	
	    } while (deltaArray[0] > threshold && ++loop < numIterations); 
	    
		}
		catch(Exception ex)
		{
			System.err.println("Error 3 : "+ex.getMessage());
		}
	}

	//Writing to output file
	private static void mpi_write(String filename, LinkedHashMap<Integer, Double> sortHash, int debug)throws IOException
	{
		try
		{
			
			double sum_of_probabilities=0.0;
		    for(Double val:sortHash.values())
		    {
		    	sum_of_probabilities+=val;
		    }
		    
		    int[] keys=new int[sortHash.size()];
		    double[] values=new double[sortHash.size()];
		    int index=0;
		    for (Map.Entry<Integer, Double> mapEntry : sortHash.entrySet()) 
		    {
		    	//System.out.println(Integer.parseInt(mapEntry.getKey().toString())+"  "+Double.parseDouble(mapEntry.getValue().toString())+"\n");
		    	keys[index] = Integer.parseInt(mapEntry.getKey().toString());
		    	values[index] = Double.parseDouble(mapEntry.getValue().toString());
		    	index++;
		    }
		
		
		    /* Sort the page rank values in ascending order */
	
		    List<Double> page_rank_list=new ArrayList<Double>(sortHash.values());
		    Collections.sort(page_rank_list);
		    ListIterator sorted_page_rank_iterator=page_rank_list.listIterator(page_rank_list.size());
		    int number_web_pages=0;
		    int totalUrls = page_rank_list.size();
	    
    
		    /*File operation to write result to output file */
		    Writer output = null;
		    File toptenurllist = new File(filename);
		    output = new BufferedWriter(new FileWriter(toptenurllist));
	  
	    	/* Header Line in Output File*/
		    if(debug ==1)
		    	System.out.println("Writing to the output file");
	     
		    output.append("\nTop 10 URLs with Highest Page Rank values "+"\n\n"+"--------------------------------------"+"\n");
		    output.append("|\t"+"URL"+"\t\t|\t"+"Page Rank"+"\t\t\t|\n"+"--------------------------------------"+"\n");
		    while(sorted_page_rank_iterator.hasPrevious() && number_web_pages++<10)
		    {
		    	String str =sorted_page_rank_iterator.previous().toString();
		    	double pagerankop = Double.valueOf(str).doubleValue();
		  
		    	/*Get top 10 URLs along with their Page Rank values
		     	*and store this list into external output file
		     	*/
		     
		    	for(int i=0;i<totalUrls;i++)
		    	{
		    		if((values[i]==pagerankop))
		    		{	
		    			output.write("|\t"+keys[i]+"\t\t|\t"+String.format("%2.17f",pagerankop)+"\t|\n");
		    			System.out.println("|\t"+keys[i]+"\t\t|\t"+String.format("%2.17f",pagerankop)+"\t|\n");
		   			 	output.write("---------------------------------------"+"\n");
		   			 //keys[i]=-1;
		   			 	values[i]=-1;
		   				break;
		    		}
		    	}
		    }
			  
		    output.append("\n"+"Cumulative Sum of Page Rank values\n");
		    output.append("--------------------------------------"+"\n");
		    output.write(String.format("%1.16f",sum_of_probabilities)+"\n");
		    
		    try
		    {
		    	if(output!=null)
		    	{	
		    		output.close();
		    	}
		    }	
		    catch(IOException er)
		    {
		    	er.printStackTrace();
		    }
		    
		    if(debug ==1)
		    	System.out.println("Writing to the output file is DONE");
			}
			catch(Exception ex)
			{
				System.err.println("Error 4 : "+ex.getMessage());
			}
	}


    public static void main(String args[]) throws Exception 
    {
    		    	
    	/* Definition of data structure and variables for MPI PageRank */ 
    	HashMap <Integer,ArrayList<Integer>> adjacencyMatrix = new HashMap<Integer, ArrayList<Integer>>();  
    	ArrayList<Integer> am_index = new ArrayList<Integer>();
    	LinkedHashMap<Integer, Double> pagerankvalues = new LinkedHashMap<Integer, Double>();
    	int totalNumUrls; 

        int numUrls; 
        String filename = "pagerank.input";  
        String outfilename ="output.txt"; //default value
        double threshold = 0.001; //default value
        int debug = 0;
       
        int rank,  numIterations = 10; 
        
        long input_start = 0, input_end = 0, comp_start = 0, comp_end = 0, output_start = 0, output_end = 0; 
        
        /* Parse command line arguments */
        try
        {
        
        if(args.length < 4)
        {
        	if(args[3].equalsIgnoreCase("-help"))
        	{
        		System.out.println("Usage: -np [no. of processes] mpi_main [inputfilename] [outputfilename] [num_iterations] [threshold]"); 
        		System.out.println("-np [no. of processes] : it should be a number greater than zero");
        		System.out.println("[inputfilename]      : adjacency matrix input file"); 
        		System.out.println("[outputfilename]     : output file containing top ten URLs");
        		System.out.println("[num_iterations]     : number of iterations"); 
        		System.out.println("[threshold]          : threshold value (default 0.0010)"); 
        		System.out.println("-o                   : output timing results (default yes)"); 
        		System.out.println("-d                   : enable debug mode"); 
        		System.out.println("-help                : print help information"); 
        		System.exit(0);
        	}
        }
        
                
        if(args.length < 7 || Integer.parseInt(args[1])<0 || Integer.parseInt(args[5])<=0 || Double.parseDouble(args[6])<0.0)
		{
        	System.out.println("Usage of mpi_main: -np [no. of processes] mpi_main [inputfilename] [outputfilename] [num_iterations] [threshold]"); 
    		System.out.println("-np [no. of processes] : it should be a number greater than zero");
    		System.out.println("[inputfilename]      : adjacency matrix input file"); 
    		System.out.println("[outputfilename]     : output file containing top ten URLs");
    		System.out.println("[num_iterations]     : number of iterations"); 
    		System.out.println("[threshold]          : threshold value (default 0.0010)"); 
    		System.out.println("-o                   : output timing results (default yes)"); 
    		System.out.println("-d                   : enable debug mode"); 
    		System.out.println("-help                : print help information"); 
    		System.exit(0);
		}
        
        
        
        if(args.length > 7)
        {
        	
        	for(int a=0; a < args.length ; a++)
        	{
        		
        		if(args[a].equalsIgnoreCase("-d"))
        		{
        			debug = 1;
        			System.out.println("Enabled debug mode");
        		}
        		else if(args[a].equalsIgnoreCase("-help"))
        		{
        			
                		System.out.println("Usage: -np [no. of processes] mpi_main [inputfilename] [outputfilename] [num_iterations] [threshold]"); 
                		System.out.println("-np [no. of processes] : it should be a number greater than zero");
                		System.out.println("[inputfilename]      : adjacency matrix input file"); 
                		System.out.println("[outputfilename]     : output file containing top ten URLs");
                		System.out.println("[num_iterations]     : number of iterations"); 
                		System.out.println("[threshold]          : threshold value (default 0.0010)"); 
                		System.out.println("-o                   : output timing results (default yes)"); 
                		System.out.println("-d                   : enable debug mode"); 
                		System.out.println("-help                : print help information"); 
                		System.exit(0);
                	
        		}
        	}
        }
              

        filename = args[3].toString();
        outfilename = args[4].toString();
        numIterations = Integer.parseInt(args[5]);
        threshold = Double.parseDouble(args[6]); 	  
        
        /* MPI Initialization */ 
        MPI.Init(args); 
        rank = MPI.COMM_WORLD.Rank();
   
        
        /* Read local adjacency matrix from file for each process */ 
        input_start=System.currentTimeMillis();
        mpi_read(filename, adjacencyMatrix, am_index, MPI.COMM_WORLD, debug);
        if(rank == 0)
           	input_end=System.currentTimeMillis() - input_start;
        	
        
        
        	        
        /* Set totalNumUrls */
        numUrls = am_index.size()/2;
		int numURL[] = new int[1];
		numURL[0] = numUrls;
		int totalNumUrl[] = new int[1];
		MPI.COMM_WORLD.Allreduce(numURL,0,totalNumUrl,0,1,MPI.INT, MPI.SUM);
		totalNumUrls = totalNumUrl[0];
		double FinalRVT[] = new double[totalNumUrls];
		
		if(rank == 0)
			comp_start=System.currentTimeMillis();

		
		for (int k = 0; k<totalNumUrls;k++)
		{
			FinalRVT[k] = 1.0/ totalNumUrls;
		}
		
		if(debug==1)
		{
			System.out.println("Initialized PageRankTable FinalRVT");
		}
		/* Broadcast the initial rank values to all other compute nodes */ 
	       // MPI_Bcast(rank_values_table, totalNumUrls, MPI_DOUBLE, 0, MPI_COMM_WORLD);        
	     
		
		try
		{
			/* Start the core computation of MPI PageRank */
			mpi_pagerankfunc(adjacencyMatrix, am_index, numUrls, totalNumUrls, numIterations, threshold, FinalRVT, MPI.COMM_WORLD, debug);
			if(debug==1)
				System.out.println("Done with calculating page rank values");
		}
		catch(Exception ex)
		{
			System.err.println("Error 5 : "+ex.getMessage());
		}
		
		if(rank==0)
			comp_end = System.currentTimeMillis() - comp_start;
		
		
		if(debug==1)
		{
			System.out.println("After PageRank Calculation");
		}
			
        /* Save results to a file */ 
		if(rank == 0)
		{
			for(int i=0; i< FinalRVT.length;i++)
			{
				pagerankvalues.put(i, FinalRVT[i]);
			}
			
			if(debug == 1)
			{
				Iterator<Integer> ite= pagerankvalues.keySet().iterator();
				while(ite.hasNext())
				{
					int src = ite.next().intValue();
					System.out.print("Source: "+src+":");
					double pgrank = pagerankvalues.get(src);
					
						System.out.print("\t"+pgrank);
					
					System.out.println("\t");
				} 
			}
			
			output_start = System.currentTimeMillis();
			mpi_write(outfilename, pagerankvalues ,debug);
			output_end = System.currentTimeMillis() - output_start;
			
			System.out.println("Input file : "+args[3]);
			System.out.println("Output file : "+args[4]);
			System.out.println("Number of Iterations: "+args[5]);
			System.out.println("Threshold: "+args[6]);
			System.out.println("Total I/O time taken:"+ (input_end+output_end) +" milliseconds");
			System.out.println("Total Computation time taken:"+comp_end+" milliseconds");
		}
        /* Release resources e.g. free(adjacency_matrix); */ 
	     
	     MPI.Finalize(); 
    }
        catch(NumberFormatException ex)
        {
        	System.out.println("Usage: -np [no. of processes] mpi_main [inputfilename] [outputfilename] [num_iterations] [threshold]"); 
    		System.out.println("-np [no. of processes] : it should be a number greater than zero");
    		System.out.println("[inputfilename]      : adjacency matrix input file"); 
    		System.out.println("[outputfilename]     : output file containing top ten URLs");
    		System.out.println("[num_iterations]     : number of iterations"); 
    		System.out.println("[threshold]          : threshold value (default 0.0010)");
        }
    }
    
}
