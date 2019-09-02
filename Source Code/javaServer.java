package Lastfinding.scalability;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Map;


public class javaServer extends Thread {

static ServerSocket servsock=null;	
	public void run()
	{
		MigrateData();
	}
	public static void MigrateData()

	{
		System.out.println("Worker 1");
try{

		  servsock = new ServerSocket(9001);
		    File myFile = new File("data.properties");
		    while (true) {
		      Socket sock = servsock.accept();
		      byte[] mybytearray = new byte[(int) myFile.length()];
		      BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myFile));
		      bis.read(mybytearray, 0, mybytearray.length);
		      OutputStream os = sock.getOutputStream();
		      os.write(mybytearray, 0, mybytearray.length);
		      os.flush();
		      sock.close();
		      Worker.partitionInfo= App.loadimage();
		    }
}
catch(IOException e)
{
try {
	servsock .close();
} catch (IOException e1) {
	// TODO Auto-generated catch block
System.out.println("Worker 1");
	e1.printStackTrace();
}
MigrateData();

}
		    
		  }
	}


