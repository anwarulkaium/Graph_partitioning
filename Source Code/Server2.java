package ownProgram;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.print.attribute.standard.PresentationDirection;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class Server2 {
	
	final static int PORT = 3333;
	ServerSocket serverSocket;
	static ArrayList<Socket> connection = new ArrayList<Socket>();
	
	static Map<Integer, List<String>> partitionInfo = new HashMap<>();
	static List<Integer> imbInfo = new ArrayList<>();
	
	//static ArrayList <InetAddress> workerList = new ArrayList<InetAddress>();
	static InetAddress presentAddress = null;
	static Socket s = null;
	static int i =0;
	static ServerConnection2 sc = null;
	static ArrayList<String> hostList = new ArrayList<String>();
	static Map<Integer, Integer> edgeLoad = new HashMap<>();
	static Map<Integer, Integer> edgeCutMap = new HashMap<>();
	boolean shouldRun= true;
	static int minPartition=0;
	static int maxPartition=0;
	static int imbcount=0;	
	static int minPartitionEdge=0;
	static int maxLoad=0;
	static int minLoad=0;
	static int partitionOneCount=0;
	static final int MAX_CAP=60000;
	static int p=0;
	static List<String> l = new LinkedList<>();
	
	
	static int edgeCutCountValue=0;
	static int edgeCount=0;
	static int deleteCount=0;
	static int addedCount =0;
	static long start=0;
	static long end =0;
	static long executionTime=0;
	static double average =0.0;
	static double deviation=0.0;
	static int countMapValue=0;
	static final int addPercentage=25;
	static int addPart =0;
	static final int deletePercentage=10;
	static int deletePart =0;
	static int totalVertex= 36692;
	
	public static void main (String [] arghs) throws IOException {
		hostList();
		new Server2();
		//edgeCutCount();
	}
	
	public static void hostList() {
		addPart = (totalVertex*addPercentage)/100;
		deletePart= (totalVertex*deletePercentage)/100;
		hostList.add("43.240.96.247");
		hostList.add("43.240.97.145");
		hostList.add("43.240.97.214");
		hostList.add("43.240.97.113");
		hostList.add("43.240.97.210");
		hostList.add("43.240.96.166"); // worker 7
		hostList.add("43.240.96.212"); // worker 8
	}
public static void addNew(){
		try{
	            
				
				String command = "java Worker > out";
	            //String host = "43.240.96.247";
	            String user = "ubuntu";
	            //String privateKey = "C:/Users/mpatwary/OneDrive - University of Tasmania/From Desktop/NewKey.ppk";
	            String privateKey = "NewKey.ppk";
	            presentAddress=InetAddress.getByName(hostList.get(0));
	            if(!connection.contains(s)) {
	           //connection.add(s);
	           // workerList.add(presentAddress);
	            }
	            
				JSch jsch = new JSch();
	            Session session = jsch.getSession(user, hostList.get(0), 22);
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
	            hostList.remove(0);
	           }catch(Exception e){
	        	   System.out.println(e);
			}   
		}
public static void edgeCutCount(List<String> edgeList, int index){
	//System.out.println(" List is  : "+ edgeList+" Index is "+ index);
	for (int x = 1; x <edgeList.size(); x++) {

		for (Map.Entry<Integer, List<String>> entry :Server2.partitionInfo.entrySet()) {
			if (entry.getKey() == index) {
				continue;
			}
			for(int t=0;t<entry.getValue().size();t++) {
			//System.out.println("----"+entry.getValue().get(t)+ " "+ edgeList.get(x) );
				//if (edgeList.get(x).equals(entry.getValue().get(t))) {
			if (entry.getValue().get(t).equals(edgeList.get(x))) {
				edgeCutCountValue++;
				//System.out.println(" entry.getValue().get(t) : "+ entry.getValue().get(t)+" edgeList.get(x) "+ edgeList.get(x));
			}
			}
		}
	
	}		
}
	
// vertex Assigning Algorithm 

public static int vertexAssign(List<String> list) {
	//Random r = new Random();
	//int value = r.nextInt(partitionIndex);
	// equal partition left
	int partitionIndex;

	HashMap<Integer, Integer> countMaximum = new HashMap<>();
	int max=0;
	  for (Map.Entry<Integer, List<String>> entry : Server2.partitionInfo.entrySet())
        {     	
        	int count=0;	
        	//System.out.println("Input List==== "+ inputList.get(count));
        	for (int a =1; a<list.size();a++) {
        		for(int i =0; i<entry.getValue().size(); i++) {
        			if(entry.getValue().get(i).equals(list.get(a)))
        			{
        			//System.out.println(" partition Index : "+entry.getKey());
        				count++;
            	///keySet.add(entry.getKey());
        			}
        		}
        		countMaximum.put(entry.getKey(), count);
            //count++;
        }
        max=Collections.max(countMaximum.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        }
	  partitionIndex = max;				
	  ///System.out.println("Partition Index in Algorithm --"+ partitionIndex);
	
	  return partitionIndex; 
	
	 // System.out.println("returning from vertex assign "+ value);
	//  return value; 
}

public static double loadImBalance() {
	
	Map<Integer,Integer> countEdge = new HashMap<>();
	// Calculate the population standard deviation of partitions
	//double deviation = 0.0;
	double sum = 0, mean = 0;
	 for (Map.Entry<Integer, Integer> entry :Server2.edgeLoad.entrySet())
        {     			
        	sum+= entry.getValue();
        	countEdge.put(entry.getKey(), entry.getValue());
        }
	 
	//finding the key with the lowest value in edge load
	minPartitionEdge = Collections.min(countEdge.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
	//-----------------------------------------------------------------------------------
	mean = sum / Server2.edgeLoad.size();
	sum = 0;
	double[] temp = new double[Server2.edgeLoad.size()];
	
	 for (Map.Entry<Integer, Integer> entry1 : Server2.edgeLoad.entrySet())
        {     
		 //if(entry1.getKey()< temp.length) {
        	temp[entry1.getKey()] = Math.pow(entry1.getValue() - mean, 2);
        	sum+= temp[entry1.getKey()];	
		 //}
        }
	mean = sum / Server2.edgeLoad.size();
	deviation = Math.sqrt(mean);
	//System.out.println("Load Imbalance "+deviation );
	return deviation;
}



// Standard deviation calculation 
public static double loadBalance() {
		double deviation=0.0;
		double threasHold = 0.0;
		double weightedDeviation = 0.0;
		// Calculate the population standard deviation of partitions
		//double deviation = 0.0;
		double sum = 0, mean = 0;
		 for (Map.Entry<Integer, List<String>> entry :Server2.partitionInfo.entrySet())
	        {     	
	        	int count=0;	
	        	sum+= entry.getValue().size();	
	        }
		mean = sum / Server2.partitionInfo.size();
		sum = 0;
		double[] temp = new double[Server2.partitionInfo.size()];
		
		 for (Map.Entry<Integer, List<String>> entry1 : Server2.partitionInfo.entrySet())
	        {     	
	        	temp[entry1.getKey()] = Math.pow(entry1.getValue().size() - mean, 2);
	        	sum+= temp[entry1.getKey()];		
	        }
		mean = sum / Server2.partitionInfo.size();
		deviation = Math.sqrt(mean);
		//System.out.println("Load Imbalance : " + deviation);
		//System.out.println("Server2.edgeCount : " + edgeCount);
		//System.out.println("Server2.edgeCutCount : " + edgeCutCount);
		// Finding  weighted deviation 
		
		//System.out.println("edge count "+ edgeCount);
		
		//System.out.println("edge cut count "+ edgeCutCount);
		
		//System.out.println("deviation  "+ deviation);
		
		if((edgeCount!=0)&&(edgeCutCountValue!=0)) { 
		weightedDeviation =  (edgeCount/edgeCutCountValue)*deviation;
		}
		//System.out.println("weightedDeviation : " + weightedDeviation);
		// Finding the threshold
		
		//System.out.println("weightedDeviation  "+ weightedDeviation);
		
		threasHold =  weightedDeviation -deviation;
		
		//System.out.println(" Threshold in load balance "+ threasHold);
		return threasHold;
	}

public static double averageLoad() {
	
	//System.out.println("Average load");
	Map<Integer, Integer> countMaximum = new HashMap<>();
	List<Integer> partitionList = new LinkedList<>();
	
	
	//int maxValue = (Collections.max(partition.values()));
	for (Entry<Integer, List<String>> entry1 : Server2.partitionInfo.entrySet()) {
	
	countMaximum.put(entry1.getKey(), entry1.getValue().size());
	partitionList.add(entry1.getValue().size());
	
	}
	
	 //finding the key with the highest value
	 //maxPartition=Collections.max(countMaximum.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
	 //System.out.println(" Max PArtition "+maxPartition );
		//max=Collections.max(countMaximum.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
	 
	//finding the key with the lowest value
	 minPartition = Collections.min(countMaximum.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
	 //System.out.println(" Min Partition Index "+minPartition );
	 
	 //finding maximum load of a partition
	 maxLoad = Collections.max(partitionList);
	 //System.out.println(" Max Partition load "+maxLoad );
	 
	//finding minimum load of a partition
	 minLoad = Collections.min(partitionList);
	 //System.out.println(" Min Partition load "+minLoad );
	 
	 
	average = (maxLoad-minLoad)/Server2.partitionInfo.size();
	
	//System.out.println(" The average is  "+average);
	return average;
}



public static void graphInfo (List<String> info, int partitionIndex) {
 
	//System.out.println(" passing list "+ info);
	if(Server2.partitionInfo.containsKey(partitionIndex)){
		Server2.partitionInfo.get(partitionIndex).add(info.get(0));
	}else {
		List<String> to = new ArrayList();
		to.add(info.get(0));
		Server2.partitionInfo.put(partitionIndex, to);
	}
	//info.get()
	
	//System.out.println(" Partitioning info : "+Server2.partitionInfo);
}	
	public Server2() {
		
		try {
			serverSocket  = new ServerSocket(PORT);
			while(shouldRun) {
				System.out.println("Starting ....");
				s = serverSocket.accept();
				sc = new ServerConnection2(s,this);
				if(connection.size()<1) {
				sc.start();
				}
				//if(!connection.contains(s)&&!workerList.contains(s.getInetAddress())) {
				
				connection.add(s);
				//presentAddress = s.getInetAddress();
				//workerList.add(s.getInetAddress());
			//}
				//System.out.println("adding new " +connection.size()+ "Connection " + sc.getName());
				//if(connection.size()==1){
				//
				//addNew();
				//}
				
				
			}	
			}catch (Exception e) {
				e.printStackTrace();
			}
		
	
	}


}

class ServerConnection2 extends Thread {
	
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	Server2 server;
	boolean shouldRun = true;
	
	
	
	public ServerConnection2(Socket socket, Server2 server) {
		super("ServerConnectionThread");
		this.socket = socket;
		this.server = server;
	}



	public void sendStringtoClient(String in) {
		
		try {
			dos.writeUTF(in);
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteVertex(String v) {
		//System.out.println(" Deleting ... ");
		Server2.deleteCount++;
		 List<String> edgeList = new LinkedList<String>(Arrays.asList(v.split(" ")));
		   List<Integer> deleteList;
   
		
		// get the index of a vertex 
		   int key=0;
		   for(Map.Entry<Integer, List<String>> en: Server2.partitionInfo.entrySet()) {
				for(int y=0;y<en.getValue().size();y++) {
				//	System.out.println(" Deleting partitiong "+ en.getValue().get(y)+ " edgeList.get(0) "+ edgeList.get(0));
				if(en.getValue().get(y).contentEquals(edgeList.get(0))) {
					key = en.getKey();
					
					int newEdgeAmount = Server2.edgeLoad.get(key)- (edgeList.size()-1);
					Server2.edgeLoad.put(key,newEdgeAmount);
				//System.out.println(" matchd" + key);
				 Socket sc = server.connection.get(key);
					try {
						dis = new DataInputStream(sc.getInputStream());
						dos = new  DataOutputStream(sc.getOutputStream());
						dos.writeUTF(v);
						dos.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				}
			} 
		   
		  
		   for (List<String> actualVal : Server2.partitionInfo.values()) {
	        	deleteList = new LinkedList<Integer>();
	        	actualVal.remove(edgeList.get(0));    	
	        	//System.out.println("Deleting...");
		   }
		   // Sending to the partition to delete the vertex
		
		   //if(Server2.partitionInfo.get(key).size()<Server2.MAX_CAP)
		   //{
			 //  Server2.imbInfo.add(key);
			   //System.out.println(" Imbalance index : "+Server2.imbInfo);
		   //}
		   
	}
	public void sendStringtoAllClients(String in) {
		
		int vertices=0;
		int criteria=0;
		//Server2.l.add("2");
		
		// count total number of vertices in all partition 
				for (Map.Entry<Integer, Integer> entry : Server2.edgeLoad.entrySet()) {
					vertices = vertices +entry.getValue();
					
				}
				//System.out.println("Edge load map  "+Server2.edgeLoad );
				//System.out.println("Partition info map  "+Server2.partitionInfo.keySet() );
				//finding the key with the lowest value in edge load
				if(!Server2.edgeLoad.isEmpty()) {
				Server2.minPartitionEdge = Collections.min(Server2.edgeLoad.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
					
				}
				//-----------------------------------------------------------------------------------
				
				//for(int x=0;x<Server2.partitionInfo.size();x++) {
					//System.out.println(" Connectionnssss "+server.connection.get(x));	
					//sc.sendStringtoClient(in);
					//System.out.println(" Each partition Size: "+Server2.partitionInfo.get(x).size()+ "Index "+ x);	
					//}
				//System.out.println("Edge map in sending----- : "+Server2.edgeLoad);	
				
		//New partition adding criteria		
		criteria = vertices/server.connection.size();
		//convert the String to list
		List<String> edgeList = new LinkedList<String>(Arrays.asList(in.split(" ")));
		
		// couting edge
		Server2.edgeCount = Server2.edgeCount+(edgeList.size()-1);
		//System.out.println(" Edge count "+Server2.edgeCount);
		//System.out.println("Edge map in : "+Server2.edgeLoad);
		
		//System.out.println("edge cut count "+ Server2.edgeCutCount);
  		List<String> tempList = new ArrayList<>();
		tempList.add(" ");
   		
		Server2.addedCount++;
		
		//System.out.println("Counting Edge "+Server2.edgeCount + " vertex:  "+Server2.addedCount+ " list size "+ (edgeList.size()-1)+ "String size "+ edgeList.size() );
		
   		if(Server2.MAX_CAP<=criteria) {
   			//criteria=0;
 			System.out.println ("Adding New");
 			Server2.addNew();
 			System.out.println(" Edge count "+Server2.edgeCount);
 			System.out.println("edge cut count "+ Server2.edgeCutCountValue);
 			System.out.println("Delete vertex count "+ Server2.deleteCount);
 			System.out.println("Added vertex count "+ Server2.addedCount);
 			//Server2.deleteCount =0;
 			//Server2.loadImBalance();
 			//System.out.println(" The average is-----  "+Server2.average);
 			
 			
 			System.out.println(" ---------------------------------------------------------  ");
 			//Server2.graphInfo(null, Server2.p);
 			if(!server.connection.contains(socket)) {
 				server.connection.add(socket);
 				
 	           // workerList.add(presentAddress);
 	            }
 			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		//sendStringtoAllClients(listString);
 			
 			Server2.p++;
 			Server2.countMapValue = 0;
 			System.out.println("Server2.p-----------  "+ Server2.p);
 			//Server2.partitionInfo.put(Server2.p,Server2.l);
 			//System.out.println(" P is "+Server2.p+" "+Server2.partitionInfo.put(Server2.p,null));
 			}
   		/*for(int x=0;x<server.connection.size();x++) {
			System.out.println(" Connectionnssss "+server.connection.get(x));	
			//sc.sendStringtoClient(in);
			}*/

		/*for(int x=0;x<Server2.partitionInfo.size();x++) {
			//System.out.println(" Connectionnssss "+server.connection.get(x));	
			//sc.sendStringtoClient(in);
			System.out.println(" Each partition Size "+Server2.partitionInfo.get(x).size()+ "Index "+ x);	
			
			}*/
		//System.out.println("Connection Size "+server.connection.size() );
		//System.out.println("Connections areeee  "+Server2.workerList);
   		//Server2.loadImBalance();
		if ((server.connection.size() == 1)) {
			//Counting edge-cut for each partition 
			Server2.graphInfo(edgeList, 0);
			
			
			// Counting the internal and external edges for each partition 
			int edges = 0; 
			if(!Server2.edgeLoad.containsKey(0)) {
			edges = (edgeList.size()-1);
			Server2.edgeLoad.put(0,edges);
			} else {
				edges = Server2.edgeLoad.get(0)+(edgeList.size()-1);
				Server2.edgeLoad.put(0,edges);
			}
			//----------------------------------------------------------	
			
			if((Server2.edgeLoad.get(0)<Server2.MAX_CAP)) 
			{
			///System.out.println("First Partition Size "+Server2.partitionInfo.get(0).size());
			//Server2.edgeCutCount(edgeList, 0);
				
				
				
			Socket sc = server.connection.get(0);
			
			//System.out.println ("Server connectionsss in if "+ sc);
			
			try {
				dis = new DataInputStream(sc.getInputStream());
				dos = new  DataOutputStream(sc.getOutputStream());
				dos.writeUTF(in);
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			//Server2.partitionOneCount++;
			//System.out.println("partitionOneCount-----------------------------------------"+Server2.partitionOneCount);			
		} else if (server.connection.size() == 2){
			if(Server2.partitionInfo.size()!=2) {
				Server2.graphInfo(edgeList, 1);
			}
			if(Server2.edgeLoad.size()!=2) {
				Server2.edgeLoad.put(1,edgeList.size()-1);
			}
			
			
			//System.out.println(" Second partition size : "+Server2.partitionInfo.get(1).size()+" Min partition"+ Server2.minPartition);
			if(Server2.edgeLoad.get(1)<Server2.MAX_CAP) 
			{
				
			// Counting the internal and external edges for each partition 
			int edges = 0; 
			if(!Server2.edgeLoad.containsKey(1)) {
			edges = (edgeList.size()-1);
			Server2.edgeLoad.put(1,edges);
			//System.out.println("--------- "+Server2.edgeLoad);
			} else {
				edges = Server2.edgeLoad.get(1)+(edgeList.size()-1);
				Server2.edgeLoad.put(1,edges);
				//System.out.println("-yes"+Server2.edgeLoad);
			}
				//----------------------------------------------------------	
			Server2.graphInfo(edgeList, 1);
			Server2.edgeCutCount(edgeList, 1);
			Socket sc = server.connection.get(1);
			//System.out.println (" Sending ....in partition 2  "+ sc);
			try {
				dis = new DataInputStream(sc.getInputStream());
				dos = new  DataOutputStream(sc.getOutputStream());
				dos.writeUTF(in);
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}else {
				double thresHold = Server2.loadBalance();
				double avgLoad = Server2.averageLoad();
				
				//double edgeLoad = Server2.loadImBalance();
				
				// Counting the internal and external edges for each partition 
				int edge = 0; 
				if(!Server2.edgeLoad.containsKey(Server2.minPartitionEdge)) {
				edge = (edgeList.size()-1);
				Server2.edgeLoad.put(Server2.minPartitionEdge,edge);
				} else {
					edge = Server2.edgeLoad.get(Server2.minPartitionEdge)+(edgeList.size()-1);
					Server2.edgeLoad.put(Server2.minPartitionEdge,edge);
				}
				//----------------------------------------------------------
				
				//Storing the graph information in each partition 
				Server2.graphInfo(edgeList, Server2.minPartitionEdge);
				
				// counting the total edge-cut
				Server2.edgeCutCount(edgeList,Server2.minPartitionEdge);
				
				//getting the particular partition from the connection list
				Socket sc = server.connection.get(Server2.minPartitionEdge);
				
				//System.out.println (" Sending ....in mininum partition  (2)  "+ Server2.minPartition+ ""+ sc);
				try {
					dis = new DataInputStream(sc.getInputStream());
					dos = new  DataOutputStream(sc.getOutputStream());
					dos.writeUTF(in);
					dos.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
		} else {
			// get the partition index
			double thresHold = Server2.loadBalance();
			double avgLoad = Server2.averageLoad();
			
			//double edgeLoad = Server2.loadImBalance();
			//System.out.println(" Threshold "+ thresHold);
			//System.out.println(" avgLoad "+ avgLoad);
			
			//System.out.println("Partition Index in Sending " + index);
			// for(int i =0; i<server.connection.size(); i++) {
			/*if (avgLoad < thresHold) {
				//System.out.println("In condition " + Server2.minPartition);
				// Counting the internal and external edges for each partition 
				int edges = 0; 
				if(!Server2.edgeLoad.containsKey(Server2.minPartitionEdge)) {
				edges = (edgeList.size()-1);
				Server2.edgeLoad.put(Server2.minPartitionEdge,edges);
				} else {
					edges = Server2.edgeLoad.get(Server2.minPartitionEdge)+(edgeList.size()-1);
					Server2.edgeLoad.put(Server2.minPartitionEdge,edges);
				}
				//----------------------------------------------------------


				Server2.graphInfo(edgeList, Server2.minPartitionEdge);
				Server2.edgeCutCount(edgeList, Server2.minPartitionEdge);
				Socket sc = server.connection.get(Server2.minPartitionEdge);
				//System.out.println ("Server connections in else "+ sc);
				try {
					dis = new DataInputStream(sc.getInputStream());
					dos = new  DataOutputStream(sc.getOutputStream());
					dos.writeUTF(in);
					dos.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//ServerConnection1 sc = server.connection.get(Server2.minPartition);
				//sc.sendStringtoClient(in);
			} else {*/
				//System.out.println("New Partition Index " + Server2.p);
				//System.out.println("New Partition Index in " + Server2.p);
				//System.out.println("New Partition Index and connections ");
				
				// Counting the internal and external edges for each partition 
		
		
			int z=0;
				int edges = 0;
				//System.out.println("Imbalance info : "+Server2.imbInfo );
				/*if(Server2.imbInfo.size()>0)
				{
			int index= Server2.imbInfo.get(0);				
			Server2.imbInfo.remove(0);
			Server2.p=index;
			//System.out.println(" Imbalance index--- : "+index);	
				}*/
				if(!Server2.edgeLoad.containsKey(Server2.p)) {
					edges = (edgeList.size()-1);
				Server2.edgeLoad.put(Server2.p,edges);
				Socket sc=null;
				Server2.graphInfo(edgeList, Server2.p);
				Server2.edgeCutCount(edgeList, Server2.p);
				
				//System.out.println(" Edge cut "+ Server2.edgeCutCountValue);
			sc = server.connection.get(Server2.p);
				
				//System.out.println("New Partition Index and connections " + sc);
				//System.out.println ("Server connectionsss in inside"+ sc);
				try {
					dis = new DataInputStream(sc.getInputStream());
					dos = new  DataOutputStream(sc.getOutputStream());
					dos.writeUTF(in);
					dos.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
					} else {
					
					int index = Server2.vertexAssign(edgeList);	
				//System.out.println("In vertex assign "+ index);
					if(Server2.edgeLoad.get(index)<Server2.MAX_CAP) {
						z=10;
					edges = Server2.edgeLoad.get(index)+(edgeList.size()-1);
					Server2.edgeLoad.put(index,edges);
					Socket sc=null;
//					if(Server2.imbcount==1)
//					{
//					int index = Server2.vertexAssign(edgeList);
//					//System.out.println("Index is--------- "+ index + "Server2.p ----------------"+ Server2.p);
//					Server2.graphInfo(edgeList, index);
//					Server2.edgeCutCount(edgeList, index);
//					sc = server.connection.get(index);
//					System.out.println(" Imbalance index--- : "+index);	
//					}
//					else
//					{
					
					Server2.graphInfo(edgeList, index);
					Server2.edgeCutCount(edgeList, index);
					
					//System.out.println(" Edge cut "+ Server2.edgeCutCountValue);
				sc = server.connection.get(index);
					
					//System.out.println("New Partition Index and connections " + sc);
					//System.out.println ("Server connectionsss in inside"+ sc);
					try {
						dis = new DataInputStream(sc.getInputStream());
						dos = new  DataOutputStream(sc.getOutputStream());
						dos.writeUTF(in);
						dos.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}else {
						int edge = 0; 
						if(!Server2.edgeLoad.containsKey(Server2.minPartitionEdge)) {
						edge = (edgeList.size()-1);
						Server2.edgeLoad.put(Server2.minPartitionEdge,edge);
						} else {
							edge = Server2.edgeLoad.get(Server2.minPartitionEdge)+(edgeList.size()-1);
							Server2.edgeLoad.put(Server2.minPartitionEdge,edge);
						}
						//----------------------------------------------------------
						
						//Storing the graph information in each partition 
						Server2.graphInfo(edgeList, Server2.minPartitionEdge);
						
						// counting the total edge-cut
						Server2.edgeCutCount(edgeList,Server2.minPartitionEdge);
						
						//getting the particular partition from the connection list
						Socket sc = server.connection.get(Server2.minPartitionEdge);
						
						//System.out.println (" Sending ....in mininum partition  (2)  "+ Server2.minPartition+ ""+ sc);
						try {
							dis = new DataInputStream(sc.getInputStream());
							dos = new  DataOutputStream(sc.getOutputStream());
							dos.writeUTF(in);
							dos.flush();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
					}
					}
				//----------------------------------------------------------

			}
				//ServerConnection1 sc = server.connection.get(index);
				//sc.sendStringtoClient(in);
			//}
		//} 
			} 
		/*int index = Server2.vertexAssign(edgeList);
		System.out.println("In condition " + index);
		Server2.graphInfo(edgeList, index);
		Server2.edgeCutCount(edgeList, index);
		Socket sc = server.connection.get(index);
		//System.out.println ("Server connectionsss in else "+ sc);
		try {
			dis = new DataInputStream(sc.getInputStream());
			dos = new  DataOutputStream(sc.getOutputStream());
			dos.writeUTF(in);
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//System.out.println (" partition size "+vertices);
	//System.out.println ("connections are "+ server.workerList);
		//System.out.println("Edge cut count "+ Server2.edgeCutCount);
	


	public void run() {
		try {
		//while(shouldRun) {
			//while(dis.available()==0) {
				//Thread.sleep(1);	
			//}	
			//String textIn = dis.readUTF();
			Server2.start = System.currentTimeMillis();
			// Reading data and checking balance then call addNew method to add a new machine
			try{
				 BufferedReader addVertex= new BufferedReader(new FileReader("/home/ubuntu/Source/C-Email-Enron.txt"));
  				 BufferedReader deleteVertex = new BufferedReader(new FileReader("/home/ubuntu/Source/C-Email-Enron.txt"));
  				//BufferedReader addVertex = new BufferedReader(new FileReader("C:\\Users\\mpatwary\\Desktop\\Source\\test1.txt"));
                  
                //String add, deleteOne, deleteTwo;;
                
                String add = addVertex.readLine();
                String deleteOne = deleteVertex.readLine();
                
                int x =0;
                while((add != null)&&(deleteOne!=null)) {
                	 //Random r = new Random();
			    	  //int x = r.nextInt(10);
			    	  // Add vertex----------------------------------------------------------
					if (x < Server2.addPart) {
						x++;
						List<Integer> list = new LinkedList<Integer>();
						add = addVertex.readLine();
						//System.out.println("in Add vertex " + add);
						StringTokenizer token = new StringTokenizer(add);
						while (token.hasMoreTokens()) {
							String st = token.nextToken();
							int element = Integer.parseInt(st);
							list.add(element);
						}

						// converting list to String
						String listString = list.stream().map(Object::toString).collect(Collectors.joining(" "));
						sendStringtoAllClients(listString);
						if(x==Server2.addPart) {
							System.out.println("Execution time for every -------------"+x+ " : "+  Server2.executionTime);
							System.out.println(" Edge count for every --------------- "+x+ " :  "+Server2.edgeCount);
							System.out.println(" The average load in every ----------- "+x+" : "+Server2.loadImBalance());
							System.out.println("Edge cut count for every--------------- : "+x+ " : "+Server2.edgeCutCountValue );
						}
					} else {
						if ((x >= Server2.addPart) && (x<Server2.addPart+Server2.deletePart)) {
							x++;
							if(x==(Server2.addPart+Server2.deletePart)) {
								x=0;
								System.out.println("Delete vertex count after "+ Server2.edgeCutCountValue);
								System.out.println("Delete vertex count for every "+ Server2.deleteCount);
							}
								
						// Delete Vertex
						deleteOne = deleteVertex.readLine();
						LinkedList<Integer> list = new LinkedList<Integer>();
						//System.out.println("delete vertex   " + deleteOne);
						StringTokenizer token = new StringTokenizer(deleteOne);
						while (token.hasMoreTokens()) {
							String s = token.nextToken();
							int element = Integer.parseInt(s);
							list.add(element);
						}
						String listString = list.stream().map(Object::toString).collect(Collectors.joining(" "));
						deleteVertex(listString);
						// sending the list
					}
					}	    
			}
             
		}catch(Exception e){
		} 
			//List<String> list = new ArrayList<String>(); 		
		//}
		//dis.close();
		//dos.close();
			
			Server2.end = System.currentTimeMillis();
			
			Server2.executionTime= Server2.end - Server2.start;
			System.out.println("Execution time "+ Server2.executionTime);
			System.out.println(" Edge count "+Server2.edgeCount);
			
			System.out.println("Delete vertex count "+ Server2.deleteCount);
			System.out.println(" The average is in main  "+Server2.loadImBalance());
			System.out.println(" Final edge cut count "+ Server2.edgeCutCountValue);
			System.out.println("Final Added vertex count "+ Server2.addedCount);
			
			System.out.println("Edge map : "+Server2.edgeLoad);
			
			for(int x=0;x<Server2.partitionInfo.size();x++) {
				//System.out.println(" Connectionnssss "+server.connection.get(x));	
				//sc.sendStringtoClient(in);
				System.out.println(" Each partition Size: "+Server2.partitionInfo.get(x).size()+ "Index "+ x);	
				}
		}catch(Exception e) {
		e.printStackTrace();	
		}
	}

}



