package ownProgram;

import java.net.*;
import java.io.*;

import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class ServerConnection extends Thread {
	
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	Server server;
	boolean shouldRun = true;
	
	public ServerConnection(Socket socket, Server server) {
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
	
	public void sendStringtoAllClients(String in) {
		for(int i =0; i<server.connection.size(); i++) {
			ServerConnection sc = server.connection.get(i);
			sc.sendStringtoClient(in);		
			System.out.println ("connections are "+ server.workerList);

		}
		
	}
	
	public void addNew(){
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
	
	public void run() {
		try {
		dis = new DataInputStream(socket.getInputStream());
		dos = new  DataOutputStream(socket.getOutputStream());
		while(shouldRun) {
			while(dis.available()==0) {
				Thread.sleep(1);	
			}	
			String textIn = dis.readUTF(); 
			sendStringtoAllClients(textIn);
			//if(server.connection.size()==1){
				//System.out.println("adding new" +server.connection.size() );
				//addNew();
				//}
		}
		dis.close();
		dos.close();
		}catch(Exception e) {
		e.printStackTrace();	
		}
	}

}
