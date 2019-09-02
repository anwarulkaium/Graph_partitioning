package algorithm;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

//import org.apache.commons.lang.StringUtils;
public class Project1 {
static	int frequency[]=new int[10000000];

static int i=0;
    static Random rand = new Random();
   static HashMap<String,Integer> hMap = new HashMap<>();
	   static HashMap<String,String> hMaps = new HashMap<>();
    static Map<Integer,List<String>> Systems = new HashMap<Integer,List<String>>();
static int j=0;

    public void filling() throws FileNotFoundException
    {
    	List<String> data=new ArrayList<String>();   
    	Scanner sc = new Scanner(new File("C:\\\\\\\\Users\\\\\\\\mpatwary\\\\\\\\Desktop\\\\\\\\Source\\\\\\\\test1.txt"));
    	int n = rand.nextInt(1)+1; // specify how many vertices should be stored in each system
    	while(sc.hasNext())
    	{
    	if(i==n)
    	{
    		i=0;	
        	Systems.put(j,data); //j is the system number
        	j++;
        //	data.clear();
        	data=new ArrayList<String>();   
        	n=rand.nextInt(1)+2;
    	}
    	data.add(sc.nextLine());
    	i++;
    	//System.out.println(Systems);
    }
    	System.out.println(Systems);
}
    
    public static int CountStringOccurrences(String text, String pattern)
    {
        int count = 0;
        int i = 0;
        if (pattern.length() > 1)
        {
            while ((i = text.indexOf(pattern, i)) != -1)
            {
                i += pattern.length();
                count++;
            }
        }
        return count;
    }
   public static void algorithm() throws FileNotFoundException
   {
	
	   
	   Scanner sc1 = new Scanner(new File("C:\\\\Users\\\\mpatwary\\\\Desktop\\\\Source\\\\requestPattern.txt"));
   	while(sc1.hasNext())
   	{
   		String[] check=sc1.nextLine().split(" ");

   		for(int k=0;k<check.length;k++)
   		{
   			for(int z=0;z<Systems.size();z++)
   			{
   		   List<String> s=Systems.get(z);
   			for(int l=0;l<s.size();l++) {
   				if(s.get(l).contains(check[0]))
   				{
   			int counts = CountStringOccurrences(s.get(l), check[k]+" ");
   			//int counts = StringUtils.countMatches(s.get(l), check[k]+" ");
   					if(hMap.containsKey(check[k])) {
             int count = hMap.get(check[k]);
             String dt=hMaps.get(s.get(l));
             int total=count+counts;
             hMap.put(check[k],total);
             hMaps.put(s.get(l), dt+l+":"+total+" ");
          } else {
             hMap.put(check[k],counts);
             hMaps.put(s.get(l), 1+":"+k+" ");
          }
   		}
   		}}}
   		
   	}
   	   	  
   }
   private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap, final boolean order)
   {
       List<Entry<String, Integer>> list = new LinkedList<>(unsortMap.entrySet());

       // Sorting the list based on values
       list.sort((o1, o2) -> order ? o1.getValue().compareTo(o2.getValue()) == 0
               ? o1.getKey().compareTo(o2.getKey())
               : o1.getValue().compareTo(o2.getValue()) : o2.getValue().compareTo(o1.getValue()) == 0
               ? o2.getKey().compareTo(o1.getKey())
               : o2.getValue().compareTo(o1.getValue()));
       return list.stream().collect(Collectors.toMap(Entry::getKey, Entry::getValue, (a, b) -> b, LinkedHashMap::new));

   }

   
   public  void algorithm1() throws FileNotFoundException
   {
	   Map<String, Integer> myMap ;
	   List<String> finalout=new ArrayList();
	   List<String> finalout1=new ArrayList();
	   Scanner sc1 = new Scanner(new File("C:\\\\Users\\\\mpatwary\\\\Desktop\\\\Source\\\\requestPattern.txt"));
   	int a=0;
	   while(sc1.hasNext())
   	{
   		
   		String clear="";
  			 myMap=new HashMap<String, Integer>();
   		String tot="";
   		String check=sc1.nextLine();
   			for(int z=0;z<Systems.size();z++)
   			{
   				List<String> s=Systems.get(z);
   				for(int l=0;l<s.size();l++) {
   				String s1=lcs(check,s.get(l),check.length(),s.get(l).length());
   			   				tot+=check+":"+s1+"@"+s1.trim().length()+"@@@";
   	 				myMap.put("APP"+a +" System " +z+" "+s.get(l),s1.trim().length());
   				}
   			}
   			//	System.out.println("myMap"+myMap);

   				
  		
  		Map<String, Integer> sortedmyMap=sortByValue(myMap,false);   			
  int i=0;
  String data=""; 	
  if(sortedmyMap.size()>3)
  { 
  for (String name: sortedmyMap.keySet()){
   		if(i<3) {
	  String key =name.toString();
            String value = sortedmyMap.get(name).toString();  
            data+=key+"#"+ value+"*";
            i++;
   		}
}
  
  
  
	finalout.add(tot);
	finalout1.add(data);
   			}
   			a++;
   	}
   	System.out.println("final"+finalout);
   	System.out.println("final1"+finalout1);
   	
   }
   	static String lcs(String X, String Y, int m, int n) 
	{ 
		int[][] L = new int[m+1][n+1]; 

		// Following steps build L[m+1][n+1] in bottom up fashion. Note 
		// that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] 
		for (int i=0; i<=m; i++) 
		{ 
			for (int j=0; j<=n; j++) 
			{ 
				if (i == 0 || j == 0) 
					L[i][j] = 0; 
				else if (X.charAt(i-1) == Y.charAt(j-1)) 
					L[i][j] = L[i-1][j-1] + 1; 
				else
					L[i][j] = Math.max(L[i-1][j], L[i][j-1]); 
			} 
		} 

		// Following code is used to print LCS 
		int index = L[m][n]; 
		int temp = index; 

		// Create a character array to store the lcs string 
		char[] lcs = new char[index+1]; 
		lcs[index] = ' '; // Set the terminating character 

		// Start from the right-most-bottom-most corner and 
		// one by one store characters in lcs[] 
		int i = m, j = n; 
		while (i > 0 && j > 0) 
		{ 
			// If current character in X[] and Y are same, then 
			// current character is part of LCS 
			if (X.charAt(i-1) == Y.charAt(j-1)) 
			{ 
				// Put current character in result 
				lcs[index-1] = X.charAt(i-1); 
				
				// reduce values of i, j and index 
				i--; 
				j--; 
				index--;	 
			} 

			// If not same, then find the larger of two and 
			// go in the direction of larger value 
			else if (L[i-1][j] > L[i][j-1]) 
				i--; 
			else
				j--; 
		} 
		String out="";
		 //Print the lcs 
		//System.out.print("LCS of "+X+" and "+Y+" is "); 
		for(int k=0;k<=temp;k++) 
			out+=lcs[k];
			//System.out.print(lcs[k]); 
	return out;
	} 
	
   
   public static void main(String a[]) throws FileNotFoundException 
   {
	   new Project1().filling();
	   new Project1().algorithm1();
	//   System.out.println("hmap:"+hMap);
	 //  System.out.println("hmap:"+hMaps);
   }
    
}
