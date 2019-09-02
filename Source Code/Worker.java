package Lastfinding.scalability;

import java.net.*;
import java.util.*;
import java.io.*;
public class Worker {
	Socket s;
	DataInputStream dis;
	DataOutputStream dos;
	static Map<String,List<String>> partitionInfo = new HashMap<>(); 
	static int sx=0;
	public static void main(String [] args) {
		
		if(sx==0) {
			new Thread(new javaServer()).start();
			new Worker();
		}
System.out.println("sx value "+ sx);
		sx++;		
	}
	
	public Worker() {
		try {
			 s= new Socket("43.240.98.226", 3333);
			 dis= new DataInputStream(s.getInputStream());
			 dos= new DataOutputStream(s.getOutputStream());
			
			listenForInput();
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	public void deleteVertex(LinkedList<String> v) {
		 for (List<String> list : partitionInfo.values()) {
	        	
	        	list.removeAll(v);
	        
	        }
		
	}
	
	public void deleteEdges(LinkedList<String> e) {
		
		 for (List<String> list : partitionInfo.values()) {
	        	
	        	list.removeAll(e);
	        }
	}	

public void calculatePageRank() {
	
	
}
	
	
	public void listenForInput() {
		//Scanner scn = new Scanner(System.in);
		while(true) {
			//while(!scn.hasNextLine()) {
				//try {
					//Thread.sleep(10);
				//} catch (InterruptedException e) {
					// TODO Auto-generated catch block
				//	e.printStackTrace();
				//}
			//}
			//String line = scn.nextLine();
			//if(line.equals("quit")) {
			//	break;
			//}
			
			try {
				//dos.writeUTF(line);
				//dos.flush();
				//while(dis.available()==0) {
					//try {
						//Thread.sleep(1);
					//} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					//}
				//}
				
				 while(true){
				String listString= dis.readUTF();
				if(listString=="Shutdown") {
					Runtime run = Runtime.getRuntime();
					Process pro = run.exec("sudo shutdown -h now");
				}
				else if(listString.contains("New"))
				{
					App.savaImage(partitionInfo);
					String[] ip=listString.split(" ");
					if(ip[1]!=null)
					JavaClient.recieve(ip[1]);
					System.out.println("success "+ partitionInfo);
				}
				else {
				System.out.println("data "+ partitionInfo);
				//String to List 
				 List<String> myList = new LinkedList<String>(Arrays.asList(listString.split(" ")));
				//System.out.println(listString);
				//System.out.println(" passing list "+ info);
				// Delete the vertices 
				if(partitionInfo.containsValue(myList.subList(1, myList.size()))) {
					partitionInfo.remove(myList.get(0),myList.subList(1, myList.size()));
					//System.out.println("Deleted ..."+myList+ "Partition size :  "+ partitionInfo.size());
					 
				 }
				
				if(partitionInfo.containsKey(myList.get(0))){
					partitionInfo.get(myList.get(0)).addAll(myList.subList(1, myList.size()));
    			}else {
    			List<String> to = new ArrayList();
				to.addAll(myList.subList(1, myList.size()));
				partitionInfo.put(myList.get(0), to);
    				}	
					
				}	
				}
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
			
		}
		try {
			dos.close();
			dis.close();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}
	
}
