package Lastfinding.scalability;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void savaImage(Map<String, List<String>> capitalCities) throws FileNotFoundException, IOException
	{
//		Map<String, String> ldapContent =capitalCities;
		Properties properties = new Properties();

		for (Map.Entry<String,List<String>> entry : capitalCities.entrySet()) {
			String listString = entry.getValue().stream().map(Object::toString).collect(Collectors.joining(" "));
			properties.put(entry.getKey(), listString);
		}

		properties.store(new FileOutputStream("data.properties"), null);
	}
	public static Map<String, List<String>> loadimage() throws FileNotFoundException, IOException
	{
		Map<String, List<String>> ldapContent = new HashMap<String, List<String>>();
		Properties properties = new Properties();
		properties.load(new FileInputStream("data.properties"));

		for (String key : properties.stringPropertyNames()) {
			String a=properties.get(key).toString();
			ldapContent.put(key, Arrays.asList(properties.get(key).toString().split(" ")));
		System.out.println(key+" "+properties.get(key).toString());
		}
		return ldapContent;
	}
    public static void main( String[] args ) throws FileNotFoundException, IOException
    {
        System.out.println( "Hello World!" );
        HashMap<String, List<String>> capitalCities = new HashMap<>();
        // Add keys and values (Country, City)
        List<String> al=new ArrayList<String>();  
        al.add("Amit");  
        al.add("Vijay");  
        al.add("Kumar");  
        al.add(1,"Sachin");  
        capitalCities.put("England", al);
        capitalCities.put("Germany", al);
        capitalCities.put("Norway", al);
        capitalCities.put("USA", al);
        savaImage(capitalCities);
        loadimage();
        
    }
}
