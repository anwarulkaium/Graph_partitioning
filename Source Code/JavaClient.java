package Lastfinding.scalability;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
public class JavaClient {
	
	public static void recieve(String ip) throws UnknownHostException, IOException
	{
		
		  Socket sock = new Socket(ip, 9000);
		    byte[] mybytearray = new byte[1024];
		    InputStream is = sock.getInputStream();
		    FileOutputStream fos = new FileOutputStream("data.properties");
		    BufferedOutputStream bos = new BufferedOutputStream(fos);
		    int bytesRead = is.read(mybytearray, 0, mybytearray.length);
		    bos.write(mybytearray, 0, bytesRead);
		    bos.close();
		    sock.close();
		    App.loadimage();
	}

}
