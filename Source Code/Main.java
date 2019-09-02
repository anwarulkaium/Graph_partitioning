package Lastfinding.scalability;

public class Main {
	
	//List<Integer> bufferList = new LinkedList<>();
	static int numberofMachine=0;
	
	
	public static void main(String[] args) {
		//Determine the number of machine
	//	predictionModel();
		// launch the machines 
	//	 launchMachine();
		// Start partitioning 
	//	 partitioner();
		 // Run the application 
		// pageRank();
		 try {
			CreatWorker.createNewWorker();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	// Determine the number of machine 
	public static int  predictionModel() {
		numberofMachine =0;
		
		
		return numberofMachine;
	}
	// launch machine based on the prediction
/*	public static void launchMachine() {
		for(int x=0; x<numberofMachine;x++) {
		try{
            String command = "java Worker";
            String host = "43.240.96.247";
            String user = "ubuntu";
           // String password = "35:1e:34:31:3e:58:26:fb:2a:39:d9:25:50:e2:4f:45";
            String privateKey = "C:/Users/mpatwary/OneDrive - University of Tasmania/From Desktop/NewKey.ppk";
            //String privateKey = "NewKey.ppk";

            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, 22);
            Properties config = new Properties();
            
            jsch.addIdentity(privateKey);
            System.out.println("identity added "); 
            
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);;
            //session.setPassword(password);
            session.connect();
             
            Channel channel = session.openChannel("exec");
            ((ChannelExec)channel).setCommand(command);
            channel.setInputStream(null);
            ((ChannelExec)channel).setErrStream(System.err);
             
            //InputStream input = channel.getInputStream();
            channel.connect();
           }catch(Exception e){
        	   System.out.println(e);
		}   
	}
	}*/
	
	// method to provision/de-provision 
	public void autoScaling() {
		
		
		
	}
	
	// to check the partition capacity
	public void checkPartition() {
		
		
	}
	
	public static int partitioner() {
		int index =0;
		
		return index;
	}
	
	public static void pageRank() {
		
		
	}

}
