package Lastfinding.scalability;

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class Server extends Thread{
	
	final static int PORT = 3333;
	static ServerSocket serverSocket;
	static ArrayList<Socket> connection = new ArrayList<Socket>();
	
	static Map<Integer, List<String>> partitionInfo = new HashMap<Integer, List<String>>();
	//static ArrayList <InetAddress> workerList = new ArrayList<InetAddress>();
	static InetAddress presentAddress = null;
	static Socket s = null; //ew Socket[10];
	static int i =0;
	static ServerConnection sc = null;
	static ArrayList<String> hostListSmall = new ArrayList<String>();
	static ArrayList<String> hostListMedium = new ArrayList<String>();
	static ArrayList<String> hostListLarge = new ArrayList<String>();
	static Map<Integer, Integer> edgeLoad = new HashMap<Integer, Integer>();
	static Map<Integer, Integer> edgeCutMap = new HashMap<Integer, Integer>();
	public static Map<String, List<String>> partition[];
	boolean shouldRun= true;
	static int minPartition=0;
	static int maxPartition=0;
	static int maxLoad=0;
	static int minLoad=0;
	static int partitionOneCount=0;
	static int p=0;
	static List<String> l = new LinkedList<String>();
	
	
	static int edgeCutCount=0;
	static int edgeCount=0;
	static int deleteCount=0;
	static int addedCount =0;
	static long start=0;
	static long end =0;
	static long executionTime=0;
	static double average =0.0;
	static double deviation=0.0;
	
	static int mediumchange=0;
	static final int addPercentage=90;
	static int addPartSmall =0;
	static int addPartMedium=0;
	static final int deletePercentage=5;
	static int deletePart =0;
	static int MAXCAP_SMALL=4000;
	static int MAXCAP_MEDIUM=8000;
	static final int totalVertex=18772;
	static int provisionThresholdSmall = 0;
	static int is=0;
	static int numpartition=0;
	static int provisionPartition =0;
	static int indexMedium =0;
	
	static List<String> instanceType = new LinkedList<>();
	
	public static void main (String [] arghs) throws IOException {
		
		if(is==0)
		hostList();
		is++;
		Thread thread = new Thread(new Runnable()
		{
		public void run()
		{
			new Server();
		}
		});
		thread.start();
		addNew();
System.out.println("Number of Instances "+ instanceType);
		
		
		//edgeCutCount();
	}
	
	
	public static int numberOfPartition() {
		
		numpartition =4;
		partition = new HashMap[numpartition];
		for (int x = 0; x < numpartition; x++) {
			partition[x] = new HashMap<>();
			instanceType.add("S");
		}
		
		
		return numpartition;
	}
	
	public static void hostList() {
		numpartition = numberOfPartition();
		
		//addPart = (totalVertex*addPercentage)/100;
		//deletePart= (totalVertex*deletePercentage)/100;
		
		//list of Small machine 
		hostListSmall.add("43.240.98.187");//2
		hostListSmall.add("43.240.98.205");//3
		hostListSmall.add("43.240.96.16");//4
		hostListSmall.add("43.240.98.83");//5
		hostListSmall.add("43.240.97.170");//6
		hostListSmall.add("43.240.98.119"); // worker 7
		hostListSmall.add("43.240.98.218"); // worker 8	
		
		//List of Medium Machine 
		hostListMedium.add("43.240.98.62");
		hostListMedium.add("43.240.98.147");
		hostListMedium.add("43.240.98.247");
		hostListMedium.add("43.240.98.196");
		hostListMedium.add("43.240.98.84");

		// List of Large machine 
		hostListLarge.add("43.240.98.131");
		hostListLarge.add("43.240.98.246");			
	}


			public static void addNew(){
		try{
	            
				for(int x=0;x<numpartition;x++) {
				System.out.println(Thread.currentThread().getName()+"Thread"+x);
					String command = "java Worker > out";
	            //String host = "43.240.96.247";
	            String user = "ubuntu";
	            //String privateKey = "C:/Users/mpatwary/OneDrive - University of Tasmania/From Desktop/NewKey.ppk";
	            String privateKey = "NewKey.ppk";
	            presentAddress=InetAddress.getByName(hostListSmall.get(x));
	           // if(!connection.contains(s)) {
	          // connection.add(s);
	           // workerList.add(presentAddress);
	          //  }
	            
				JSch jsch = new JSch();
	            Session session = jsch.getSession(user, hostListSmall.get(x), 22);
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
	           // hostListSmall.remove(0);
	            sleep(8000);
				}
	            
	           }catch(Exception e){
	        	   System.out.println(e);
			}   
		}
	
	public static void addMedium() {
		
		
		try{
            
			
			String command = "java Worker > out";
            //String host = "43.240.96.247";
            String user = "ubuntu";
            //String privateKey = "C:/Users/mpatwary/OneDrive - University of Tasmania/From Desktop/NewKey.ppk";
            String privateKey = "NewKey.ppk";
            presentAddress=InetAddress.getByName(hostListMedium.get(0));
           // if(!connection.contains(s)) {
           //connection.add(s);
           // workerList.add(presentAddress);
          //  }
            
			JSch jsch = new JSch();
            Session session = jsch.getSession(user, hostListMedium.get(0), 22);
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
           // hostListSmall.remove(0);
            sleep(5000);
			
            
           }catch(Exception e){
        	   System.out.println(e);
		}  
		
		
		
		
	} 
		
// vertex Assigning Algorithm 

public static int vertexAssign(String list) {
	//Random r = new Random();
	//int value = r.nextInt(partitionIndex);
	// equal partition left
	// String to list
	
	 
	List<String> edgeList = new LinkedList<String>(Arrays.asList(list.split(" ")));
	
	long s = System.currentTimeMillis();
	Random random = new Random();
	int Low = 0;
	int High = numpartition;
	double maxValue=0;
	int partitionIndex =0;
	int partIndexMin=0;
	//System.out.println("From List "+ t.list.subList(1, (t.list.size())));
	int partitionNumber = 0;
	ArrayList<Integer> argmax = new ArrayList<Integer>();
	ArrayList<Integer> argmin = new ArrayList<Integer>();
	
	List<String> candidateEdges = edgeList.subList(1, edgeList.size());
	List<Integer> balance1 = new ArrayList<Integer>();
	// TODO Auto-generated method stub
	// for(Map.Entry<Integer, ArrayList<Integer>> entry : edges.entrySet()){
	
	//System.out.println(" the list value " + t.list.subList(1, (t.list.size())));
	//Map.Entry<Integer, Set<Integer>> entry = t.list.entrySet().iterator().next();
	//System.out.println("Partition in specific"+partition[3] );
	
	for (int x = 0; x < numpartition; x++) {
		Set<String> set = new HashSet<String>(partition[x].keySet());
		set.retainAll(candidateEdges);
		double weight = 1-(partition[x].size()/1000);
		double intersect = set.size()*weight;
		if (intersect > maxValue) {
			maxValue = intersect;
			partitionIndex = x;
			//balance1.clear();
			///balance1.add(x);
			//System.out.println("Index in if is "+CandidateIndex);
			
		} else if (intersect == maxValue) {
			//partIndexMin =balanced();
			//partitionIndex=partIndexMin;
			partitionIndex = random.nextInt(numpartition);
			/*balance1.add(x);
			int min = partition[balance1.get(0)].size();
			for (int b = 0; b < balance1.size(); b++) {
				if (partition[balance1.get(b)].size() < min) {
					min = partition[balance1.get(b)].size();
					CandidateIndex = balance1.get(b);
				}
			}*/
			//System.out.println("Index in elseif is----------- "+CandidateIndex);
		} else {
			
			//partitionIndex = random.nextInt(numpartition);
			//System.out.println("Index in else is "+CandidateIndex);
		}
		//partition[CandidateIndex].put(list.get(0),candidateEdges);
	}
	
	int count = 0;
	//System.out.println("Each vertex "+entry2.getKey());
	for(int y=0;y<numpartition; y++) {
		if (!partition[y].containsKey(edgeList.get(0))) {
			count++;
		//System.out.println(entry2.getKey());
		}
	}
	if(count==numpartition) {
		//if(instanceType.get(Server.provisionPartition)=="M")
		partition[partitionIndex].put(edgeList.get(0),candidateEdges);
	}
	
	System.out.println(" partitionin Index -----------"+partitionIndex);
	// sending to the respective machines 
	ServerConnection.sendStringtoAllClients(list,partitionIndex);
	
//System.out.println("Candidate Index "+CandidateIndex+ "Candidate Vertex "+ list.get(0)+ "Candidate Edges "+ candidateEdges );
	/*double d = Math.random();
	if (d < .5)
		return 0;*/
	//Set<Integer> temp = new HashSet<Integer>(t.list.subList(1, (t.list.size())));
	//System.out.println("Partition innnnnn "+partition[partitionNumber] );
	//partition[partitionNumber].put(t.list.get(0));
	
	//System.out.println("Partitioned "+partitionNumber+" value : "+partition[partitionNumber]);
	//long e = System.currentTimeMillis();
	
	//long total = e- s;
	
	//System.out.println("partitioining time : " +total);
	//System.out.println("Partition number : " + partitionNumber);
	//return partitionNumber;
	return partitionIndex; 
	
	 // System.out.println("returning from vertex assign "+ value);
	//  return value; 
}

public static int balanced(){
	
	int partIndexMin = 0;
	int partitionValue = partition[0].size();
	for (int x = 0; x < numpartition; x++) {
		if (partitionValue > partition[x].size()) {
			partIndexMin = x;
		}
	}
	return partIndexMin;
}
// determine the overloaded machine
public static int checkPartition() {
	// compute 
	int partitionIndex=0;
	int largeMachine =0;
	int smallMachine =0;
	int mediumMachine =0; 
	double arrivalRate = 1/60;
int average=	totalVertex/numpartition;

// Small machine capacity
if(average<=MAXCAP_SMALL)
{
	addPartSmall = (average*addPercentage)/100;
}
else
	addPartSmall = (MAXCAP_SMALL*addPercentage)/100;
//	MAXCAP_SMALL = totalVertex/numpartition;


// medium machine capacity 
if(average<=MAXCAP_MEDIUM)
{	
	addPartMedium = (MAXCAP_MEDIUM*addPercentage)/100;
}
else
	addPartMedium = (average*addPercentage)/100;
//	MAXCAP_SMALL = totalVertex/numpartition;

	
	
	
	//System.out.println("MAXCAP "+MAXCAP_SMALL);
	System.out.println("Number of Instances "+ instanceType);
	System.out.println("addPart "+addPartSmall);
	
	for(int x=0; x<numpartition; x++) 
	{
		System.out.println("Partition size "+ partition[x].size());
		
		if(addPartSmall<=partition[x].size()&&Server.instanceType.get(x)=="S")
		{
		provisionThresholdSmall = partition[x].size();
		partitionIndex =x;
		} else if (addPartMedium<=partition[x].size()&&Server.instanceType.get(x)=="M") {
			//provisionThreshold = partition[x].size();
			//partitionIndex =x;
			
		}
	}
	return partitionIndex;
}

//@Override
//public void run()
//{

//}
	public Server() {
		
		try {
			serverSocket  = new ServerSocket(PORT);
			while(shouldRun) {
				System.out.println("Starting ....");
				System.out.println(" host size "+ hostListSmall.size());
				System.out.println(" connection size "+ connection.size());
				
				
				s = serverSocket.accept();
				sc = new ServerConnection(s,this);
				
				
				synchronized(connection) {
					connection.add(s);
					}
				System.out.println(" connection size "+ connection.size()+ " host "+ hostListSmall.size());
				if(hostListSmall.size()==connection.size()) {
					System.out.println("Started ...");
					
				sc.start();
				}	
				
				
				
			}	
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		
	//	start();
	
	}
}

class ServerConnection extends Thread {
	
	static Socket socket;
	static DataInputStream dis;
	static DataOutputStream dos;
	static Server server;
	boolean shouldRun = true;
	
	
	
	public ServerConnection(Socket socket, Server server) {
		super("ServerConnectionThread");
		ServerConnection.socket = socket;
		ServerConnection.server = server;
	}
	
	public void deleteVertex(String v) {
		Server.deleteCount++;
		List<String> edgeList = new LinkedList<String>(Arrays.asList(v.split(" ")));
		   List<Integer> deleteList;
     
		   for (List<String> actualVal : Server.partitionInfo.values()) {
	        	deleteList = new LinkedList<Integer>();
	        	actualVal.remove(edgeList.get(0));
	        	
	        	//System.out.println("Deleting...");
		   }
		// get the index of a vertex 
		   int key=0;
		   for(Map.Entry<Integer, List<String>> en: Server.partitionInfo.entrySet()) 
		   {
				for(int y=0;y<en.getValue().size();y++) {
				if(en.getValue().get(y)==edgeList.get(0)) {
					key = en.getKey();
				}
				}
			} 
		   // Sending to the partition to delete the vertex
		   Socket sc = Server.connection.get(key);
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
	
	public static void changePartitionAssign(int index, String list) {
		System.out.println("In change partition ");
		
		List<String> edgeList = new LinkedList<String>(Arrays.asList(list.split(" ")));
		
		List<String> candidateEdges = edgeList.subList(1, edgeList.size());
		
		
		Server.partition[index].put(edgeList.get(0),candidateEdges);
		
		
		
	}
	
	public static void sendStringtoAllClients(String in, int index) {
		int vertices=0;
		int criteria=0;
		//Server1.l.add("2");
		// count total number of vertices in all partition 
				//for (Map.Entry<Integer, List<String>> entry : Server1.partitionInfo.entrySet()) {
					//vertices = vertices +entry.getValue().size();
				//}
		
		//New partition adding criteria		
		//criteria = vertices/server.connection.size();
		//convert the String to list
		List<String> edgeList = new LinkedList<String>(Arrays.asList(in.split(" ")));
		
		//Server1.edgeCount = Server1.edgeCount+(edgeList.size()-1);
		//System.out.println(" Edge count "+Server1.edgeCount);
		
		
		//System.out.println("edge cut count "+ Server1.edgeCutCount);
  		List<String> tempList = new ArrayList<>();
		tempList.add(" ");
		
		//System.out.println("criteria  "+criteria );
		//Random r = new Random();
		//int n = r.nextInt(Server1.connection.size());

		Socket sc = Server.connection.get(index);
		
		//System.out.println ("Server connectionsss in if "+ sc);
		System.out.println("Sending to partition"+ index);
		try {
			dis = new DataInputStream(sc.getInputStream());
			dos = new  DataOutputStream(sc.getOutputStream());
			dos.writeUTF(in);
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println("e.printStackTrace() "+ e);
		}

	}
	
	@Override
	public void run() {
		try {
	
			Server.start = System.currentTimeMillis();
			
			
			// Reading data and checking balance then call addNew method to add a new machine
			try{
				 //BufferedReader addVertex= new BufferedReader(new FileReader("/home/ubuntu/Source/4elt.graph.txt"));
  				 //BufferedReader deleteVertex = new BufferedReader(new FileReader("/home/ubuntu/Source/4elt.graph.txt"));
                
				Scanner addVertex = new Scanner(new File("/home/ubuntu/Source/C-Email-Enron.txt"));
				
                String add ="";// = addVertex.readLine();
              //  String deleteOne = deleteVertex.readLine();
                int x =0;
                // get the partition 
               
                System.out.println("Checking ..............");
                
                while(addVertex.hasNextLine()) {
                //while((add != null)&&(deleteOne!=null)) {
                	
                	List<Integer> list = new LinkedList<Integer>();
					add = addVertex.nextLine();
					//System.out.println("in Add vertex " + add);
					StringTokenizer token = new StringTokenizer(add);
					while (token.hasMoreTokens()) {
						String st = token.nextToken();
						int element = Integer.parseInt(st);
						list.add(element);
					}
					if(Server.mediumchange==0) {
                	if ((Server.provisionThresholdSmall==Server.addPartSmall)&&(Server.provisionThresholdSmall!=0)){
                		System.out.println("provisionThreshold " + Server.provisionThresholdSmall);		
                        System.out.println("Server1.addPart " + Server.addPartSmall);
                        System.out.println("Shut down the partition "+ Server.provisionPartition);
    						//if (Server1.edgeLoad.get(0).SIZE < Server1.addPart) {
                			// Sending new machine ip to the machine need to migrated from
                			System.out.println("Start changing the machine type"); 
                    		
                			//System.out.println(" Host list Small ")
                			//System.out.println("Start changing the machine type "+Server.hostListSmall.get(Server.provisionPartition)); 
                			
    						//String ip=Server.hostListSmall.get(Server.provisionPartition);
    						Server.mediumchange=1;
    						Socket sc = Server.connection.get(Server.provisionPartition);
    						//System.out.println ("Server connections in if "+ sc);
    						String newip = Server.hostListMedium.get(0);
    						Server.indexMedium = Server.provisionPartition;
    						//String newip=CreatWorker.createMediumNewWorker();
    						//String newip="130.56.248.55";
    						sleep(10000);
    						try {
    							dis = new DataInputStream(sc.getInputStream());
    							dos = new  DataOutputStream(sc.getOutputStream());
    							dos.writeUTF("New "+newip);
    							System.out.println(newip);
    							dos.flush();
    						} catch (IOException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    						}
    						
    						// update HostList 
    						System.out.println("Done changing the machine type and updating the machine list in server"); 
    						//Server.hostListSmall.set(Server.provisionPartition,newip);
    						//Server.hostListSmall.remove(Server.provisionPartition);
    						//Server.connection.remove(Server.provisionPartition);
    						Server.addMedium();
    						Server.hostListMedium.remove(0);
    						Server.instanceType.set(Server.provisionPartition,"M");
    						
    						System.out.println("Changes to ---------------------------"+Server.s );
    						Server.connection.set(Server.provisionPartition,Server.s);
    						//partition[Server.provisionPartition].put()
    						System.out.println("Server.provisionPartition----------------"+ Server.provisionPartition);
    						//sleep(50000);
    						//hostList.add(newip);
    						System.out.println("Done updating the machine list");	
    						Server.provisionThresholdSmall=0;
    						Server.end = System.currentTimeMillis();
    						Server.executionTime= Server.end - Server.start;
    						
    					}
                	else
                	{
                		String listString = list.stream().map(Object::toString).collect(Collectors.joining(" "));
                		Server.vertexAssign(listString);
                		System.out.println("provisionThreshold " + Server.provisionThresholdSmall);
    					Server.provisionPartition = Server.checkPartition();
    					x++; 
    					Server.mediumchange=0;
    					System.out.println("X value "+x);
                	}
					}
                	else {
                	//Random r = new Random();
			    	//int x = r.nextInt(10);
			    	// Add vertex----------------------------------------------------------
                	
					System.out.println("Started Partitioing "+ list); 
					
					// converting list to String
					String listString = list.stream().map(Object::toString).collect(Collectors.joining(" "));
					System.out.println("Server.provisionPartition----------------"+ Server.indexMedium);
					System.out.println("Server.addPartMedium"+Server.addPartMedium+"Server.partition[Server.provisionPartition].size()"+ Server.partition[Server.provisionPartition].size()+ "Server.instanceType.get(Server.provisionPartition)"+ Server.instanceType.get(Server.provisionPartition));
					if(Server.addPartMedium>=Server.partition[Server.indexMedium].size()) 
					changePartitionAssign(Server.indexMedium, listString);
					
					else{
						Server.mediumchange=0;
						Server.vertexAssign(listString);}
					System.out.println("provisionThreshold " + Server.provisionThresholdSmall);
					Server.provisionPartition = Server.checkPartition();
					x++; 
					System.out.println("X value "+x); 
                	}
                	
                	
                
			}
                
             
		}catch(Exception e){
			
			//e.getStackTrace()[0].getLineNumber();
			StackTraceElement[] stackTrace = e.getStackTrace();
	         for (int i = 0; i < stackTrace.length; i++)
	         {
	            System.err.println("Exception thrown from " + 
	                               stackTrace[i].getMethodName() + " in class " + 
	                               stackTrace[i].getClassName() + " on line " + 
	                               stackTrace[i].getLineNumber() + " of file " + 
	                               stackTrace[i].getFileName());
	            System.err.println();
	         }
		} 
			//List<String> list = new ArrayList<String>(); 		
		//}
		//dis.close();
		//dos.close();
			
			/*Server1.end = System.currentTimeMillis();
			
			Server1.executionTime= Server1.end - Server1.start;

			System.out.println("Execution time "+ Server1.executionTime);
			System.out.println(" Edge count "+Server1.edgeCount);
			
			System.out.println("Delete vertex count "+ Server1.deleteCount);
			System.out.println(" The average is in main  "+Server1.loadImBalance());
			System.out.println("edge cut count "+ Server1.edgeCutCount);
			System.out.println("Final Added vertex count "+ Server1.addedCount);
			
			System.out.println("Edge map : "+Server1.edgeLoad);
			
			for(int x=0;x<Server1.partitionInfo.size();x++) {
				//System.out.println(" Connectionnssss "+server.connection.get(x));	
				//sc.sendStringtoClient(in);
				System.out.println(" Each partition Size: "+Server1.partitionInfo.get(x).size()+ "Index "+ x);	
				
				}*/
		}catch(Exception e) {
		e.printStackTrace();	
		}
	}

}






























