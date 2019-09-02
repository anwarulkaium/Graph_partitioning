package algorithm;

import java.io.FileReader;
import java.io.Reader;
import java.util.Random;
import java.util.Scanner;

class Program
{
    static int propevictions = 0;
    static int existevictions = 0;
    static int appno12 = 0;
    static int averagelen=0;
    static Random r = new Random();
    static int datanodes = 11;
    static int users = 101;
    static int apps = 100;
    static int files = 101;
    static int blocks = 26;
    static int averagesess = 0;
    static int[] R4;
    static int[] cache = new int[     500];
    static int[] ssd = new int[10000];
    static int[] disk = new int[200000];
    static String[] popfilelist;
    static String blocksin = "";
    static int[] frequency1 = new int[files];

    static int appcount31 = 0;
    static String log;
    static String cliname;
    static String Uname;
    static String Aname;
    static String filename;

    static int counter = 0;
   
    static int dlocaa = 0;
    static int dn1dskaa = 0;
    static Thread t = null;
    static Thread t1 = null;
    static Thread t2 = null;
    static Thread t3 = null;
    static int dn2 = 0;
    static double waccesstimea = 0;
    static double waccesstimeaa = 0;
    static double waccesstime = 0;

    static double avgwaccesstimea = 0;

    static double avgwaccesstimeaa = 0;
    static double avgwaccesstime = 0;
    static double raccesstimea = 0;
    static double raccesstimeaa = 0;
    static double raccesstime = 0;
    static double avgraccesstimea = 0;
    static double avgraccesstimeaa = 0;
    static double avgraccesstime = 0;


    static String[] spglobalcache = new String[5001];
    static String[] splocalcache = new String[5001];
    static String[] spneighbourcache = new String[5001];
    static int dngoc = 0;

    static String[] apglobalcache = new String[6001];
    static String[] aplocalcache = new String[601];
    static String[] apneighbourcache = new String[601];

    static String[] agglobalcache = new String[6001];
    static String[] aglocalcache = new String[601];
    static String[] agneighbourcache = new String[601];

    static String[] writemodification = new String[2001];

    static int[] readfiles = new int[600000];
    static int[] readblocks = new int[600000];
    static int[] writefiles = new int[600000];
    static int[] writeblocks = new int[600000];

    static int dn10 = 0;
    static int dn1 = 0;
   
    static int dn3 = 0;
    static int dn4 = 0;
    static int dn5 = 0;
    static int dn6 = 0;
    static int dn7 = 0;
    static int dn8 = 0;
    static int dn9 = 0;

    static int dn10a = 0;
    static int dn1a = 0;
    static int dn2a = 0;
    static int dn3a = 0;
    static int dn4a = 0;
    static int dn5a = 0;
    static int dn6a = 0;
    static int dn7a = 0;
    static int dn8a = 0;
    static int dn9a = 0;



    static boolean mod = false;
    static int found = 0;
    static int i = 0;
    static int sploci = 0;
    static int spnoci = 0;
    static int spgoci = 0;

    static int splochit = 0;
    static int spnochit = 0;
    static int spgochit = 0;
    static int spdiskhit = 0;

    static int aplochit = 0;
    static int apnochit = 0;
    static int apgochit = 0;
    static int apdiskhit = 0;

    static int aglochit = 0;
    static int agnochit = 0;
    static int aggochit = 0;
    static int agdiskhit = 0;


    static int aploci = 0;
    static int apnoci = 0;
    static int apgoci = 0;

    static int agloci = 0;
    static int agnoci = 0;
    static int aggoci = 0;

    static double spaccesstime = 0.0;
    static double spavgaccesstime = 0.0;
    static double sptotalaccesstime = 0.0;

    static double apaccesstime = 0.0;
    static double apavgaccesstime = 0.0;
    static double aptotalaccesstime = 0.0;

    static double agaccesstime = 0.0;
    static double agavgaccesstime = 0.0;
    static double agtotalaccesstime = 0.0;

    static double cpu1clock;
    static double cpu2clock;
    static double networkclock;
    static double ioclock;

    static int count1 = 0;
    static int count2 = 0;
    static int count3 = 0;
    static int count4 = 0;
    static int count5 = 0;
    static int count6 = 0;
    static int count7 = 0;
    static int count8 = 0;
    static int count9 = 0;
    static int count10 = 0;
    static int count11 = 0;
    static int count12 = 0;
    static int count13 = 0;
    static int count14 = 0;
    static int count15 = 0;
    static int count16 = 0;
    static int count17 = 0;
    static int count18 = 0;
    static int count19 = 0;
    static int count20 = 0;
    static int count21 = 0;
    static int count22 = 0;
    static int count23 = 0;


    static int count1a = 0;
    static int count2a = 0;
    static int count3a = 0;
    static int count4a = 0;
    static int count5a = 0;
    static int count6a = 0;
    static int count7a = 0;
    static int count8a = 0;
    static int count9a = 0;
    static int count10a = 0;
    static int count11a = 0;

    static int count12a = 0;
    static int count13a = 0;
    static int count14a = 0;
    static int count15a = 0;
    static int count16a = 0;
    static int count17a = 0;
    static int count18a = 0;
    static int count19a = 0;
    static int count20a = 0;
    static int count21a = 0;
    static int count22a = 0;
    static int count23a = 0;

    static int count12aa = 0;
    static int count13aa = 0;
    static int count14aa = 0;
    static int count15aa = 0;
    static int count16aa = 0;
    static int count17aa = 0;
    static int count18aa = 0;
    static int count19aa = 0;
    static int count20aa = 0;
    static int count21aa = 0;
    static int count22aa = 0;
    static int count23aa = 0;

    static String[] DN1 = new String[500];
    static String[] DN2 = new String[500];
    static String[] DN3 = new String[500];
    static String[] DN4 = new String[500];
    static String[] DN5 = new String[500];
    static String[] DN6 = new String[500];
    static String[] DN7 = new String[500];
    static String[] DN8 = new String[500];
    static String[] DN9 = new String[500];
    static String[] DN10 = new String[500];



    static String[] DN1b = new String[500];
    static String[] DN2b = new String[500];
    static String[] DN3b = new String[500];
    static String[] DN4b = new String[500];
    static String[] DN5b = new String[500];
    static String[] DN6b = new String[500];
    static String[] DN7b = new String[500];
    static String[] DN8b = new String[500];
    static String[] DN9b = new String[500];
    static String[] DN10b = new String[500];


    static String[] DN1a = new String[500];
    static String[] DN2a = new String[500];
    static String[] DN3a = new String[500];
    static String[] DN4a = new String[500];
    static String[] DN5a = new String[500];
    static String[] DN6a = new String[500];
    static String[] DN7a = new String[500];
    static String[] DN8a = new String[500];
    static String[] DN9a = new String[500];
    static String[] DN10a = new String[500];


    static String[] DN1DSK = new String[10000];
    static String[] DN2DSK = new String[10000];
    static String[] DN3DSK = new String[10000];
    static String[] DN4DSK = new String[10000];
    static String[] DN5DSK = new String[10000];
    static String[] DN6DSK = new String[10000];
    static String[] DN7DSK = new String[10000];
    static String[] DN8DSK = new String[10000];
    static String[] DN9DSK = new String[10000];
    static String[] DN10DSK = new String[10000];


    static String[] DN1DSKa = new String[10000];
    static String[] DN2DSKa = new String[10000];
    static String[] DN3DSKa = new String[10000];
    static String[] DN4DSKa = new String[10000];
    static String[] DN5DSKa = new String[10000];
    static String[] DN6DSKa = new String[10000];
    static String[] DN7DSKa = new String[10000];
    static String[] DN8DSKa = new String[10000];
    static String[] DN9DSKa = new String[10000];
    static String[] DN10DSKa = new String[10000];

    static String[] DN1DSKaa = new String[10000];
    static String[] DN2DSKaa = new String[10000];
    static String[] DN3DSKaa = new String[10000];
    static String[] DN4DSKaa = new String[10000];
    static String[] DN5DSKaa = new String[10000];
    static String[] DN6DSKaa = new String[10000];
    static String[] DN7DSKaa = new String[10000];
    static String[] DN8DSKaa = new String[10000];
    static String[] DN9DSKaa = new String[10000];
    static String[] DN10DSKaa = new String[10000];


    static String[] DN1DSK2 = new String[10000];
    static String[] DN2DSK2 = new String[10000];
    static String[] DN3DSK2 = new String[10000];
    static String[] DN4DSK2 = new String[10000];
    static String[] DN5DSK2 = new String[10000];
    static String[] DN6DSK2 = new String[10000];
    static String[] DN7DSK2 = new String[10000];
    static String[] DN8DSK2 = new String[10000];
    static String[] DN9DSK2 = new String[10000];
    static String[] DN10DSK2 = new String[10000];


    static String[] global1 = new String[2000];
    static String[] global1a = new String[2000];
    static String file1path;
    static String file1path1;
    static String file1path2;


    public Program()
    {
        //            InitializeComponent();

        ////System.out.println("Enter file path of disk");
        //file1path = Console.readLine();
        //System.out.println("Enter file path of local cache");
        file1path1 = Console.readLine();
        //System.out.println("Enter file path of global cache");
        file1path2 = Console.readLine();
    }

    public static void Main(String[] args)
    {
       String ch = "y";
       Scanner Console = new Scanner(System.in);

//           //System.out.println("Enter file path of disk");
//         file1path = Console.readLine();
        System.out.println("Enter file path of local cache");
        file1path1 = Console.nextLine();
        System.out.println("Enter file path of global cache");
        file1path2 = Console.nextLine();

        cacheoperation();
        Diskfilling();
        globalcachefilling();
        t.Join();
        t2.Join();
        while (ch == "y")
        {
            AverageReadWriteAccesstime();
            t3.Join();
            System.out.println("Do You Want to Continue Press y");
           ch= Console.readLine();
        }
        }

    //private void button1_Click(object sender, EventArgs e)
    public static void cacheoperation()
    {
        t2 = new Thread();
        t2.start();
    }
    public static void cachefillng()
    {
     //   using (StreamReader sr = File.OpenText(file1path1))
    	Reader sr = new FileReader(file1path1);

        {
            String s = "";
            while ((s = sr.readLine()) != null)
            {
                String[] spl = s.Split(' ');
                for (int k = 2; k < spl.Length; k++)
                {

                    String Datanode = spl[0];
                    switch (Datanode)
                    {
                        case "DN1":

                            if (count1 != -1)
                            {
                                DN1[count1] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                                //DN1[count1] = spl[1] + "B" + spl[k];
                                count1++;
                            }
                            else
                            {
                                Array.Sort(DN1);
                                DN1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                            }

                            if (count1 == 500)
                            {
                                count1 = -1;
                            }
                            break;

                        case "DN2":

                            if (count2 != -1)
                            {
                                DN2[count2] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];


                                count2++;
                            }
                            else
                            {
                                Array.Sort(DN2);
                                DN2[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];
                            }

                            if (count2 == 500)
                            {
                                count2 = -1;
                            }
                            break;

                        /*DN2[count2] = spl[1] + "B" + spl[k];
                        count2++;
                        //DN2DSK[count13] = spl[1] + "B" + spl[k];
                        //count13++;

                        //if (count13 == 50000)
                        //{
                        //    count13 = 0;
                        //}

                        if (count2    == 500)
                        {
                            count2 = 0;
                        }

                        break;*/
                        case "DN3":

                            if (count3 != -1)
                            {
                                DN1[count3] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                                //DN1[count1] = spl[1] + "B" + spl[k];
                                count3++;
                            }
                            else
                            {
                                Array.Sort(DN3);
                                DN3[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                            }

                            if (count3    == 500)
                            {
                                count3 = -1;
                            }
                            break;



                        /*                                DN3[count3] = spl[1] + "B" + spl[k];
                                                        count3++;
                                                        //DN3DSK[count14] = spl[1] + "B" + spl[k];
                                                        //count14++;

                                                        //if (count14 == 50000)
                                                        //{
                                                        //    count14 = 0;
                                                        //}

                            
                                                        if (count3    == 500)
                                                        {
                                                            count3 = 0;
                                                        }

                                                        break;*/
                        case "DN4":

                            if (count4 != -1)
                            {
                                DN4[count4] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                                //DN1[count1] = spl[1] + "B" + spl[k];
                                count4++;
                            }
                            else
                            {
                                Array.Sort(DN4);
                                DN4[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                            }

                            if (count4    == 500)
                            {
                                count4 = -1;
                            }
                            break;

                        /*                                DN4[count4] = spl[1] + "B" + spl[k];
                                                        count4++;

                                                        //DN4DSK[count15] = spl[1] + "B" + spl[k];
                                                        //count15++;

                                                        //if (count15 == 50000)
                                                        //{
                                                        //    count15 = 0;
                                                        //}

                                                        if (count4    == 500)
                                                        {
                                                            count4 = 0;
                                                        }

                                                        break;*/
                        case "DN5":

                            if (count5 != -1)
                            {
                                DN5[count5] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                                //DN1[count1] = spl[1] + "B" + spl[k];
                                count5++;
                            }
                            else
                            {
                                Array.Sort(DN5);
                                DN5[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                            }

                            if (count5    == 500)
                            {
                                count5 = -1;
                            }
                            break;

                        /*
                        DN5[count5] = spl[1] + "B" + spl[k];
                        count5++;
                        //DN5DSK[count16] = spl[1] + "B" + spl[k];
                        //count16++;

                        //if (count16 == 50000)
                        //{
                        //    count16 = 0;
                        //}

                        if (count5    == 500)
                        {
                            count5 = 0;
                        }

                        break;*/
                        case "DN6":

                            if (count6 != -1)
                            {
                                DN6[count6] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                                //DN1[count1] = spl[1] + "B" + spl[k];
                                count6++;
                            }
                            else
                            {
                                Array.Sort(DN6);
                                DN6[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                            }

                            if (count6    == 500)
                            {
                                count6 = -1;
                            }
                            break;

                        /*
                        DN6[count6] = spl[1] + "B" + spl[k];
                        count6++;
                        //DN6DSK[count17] = spl[1] + "B" + spl[k];
                        //count17++;

                        //if (count17 == 50000)
                        //{
                        //    count17 = 0;
                        //}

                        if (count6    == 500)
                        {
                            count6 = 0;
                        }

                        break;*/
                        case "DN7":
                            if (count7 != -1)
                            {
                                DN7[count7] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                                //DN1[count1] = spl[1] + "B" + spl[k];
                                count7++;
                            }
                            else
                            {
                                Array.Sort(DN7);
                                DN7[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                            }

                            if (count7    == 500)
                            {
                                count7 = -1;
                            }
                            break;

                        /*
                        DN7[count7] = spl[1] + "B" + spl[k];
                        count7++;
                        //DN7DSK[count18] = spl[1] + "B" + spl[k];
                        //count18++;

                        //if (count18 == 50000)
                        //{
                        //    count18 = 0;
                        //}

                        if (count7    == 500)
                        {
                            count7 = 0;
                        }

                        break;*/
                        case "DN8":

                            if (count8 != -1)
                            {
                                DN8[count8] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                                //DN1[count1] = spl[1] + "B" + spl[k];
                                count8++;
                            }
                            else
                            {
                                Array.Sort(DN8);
                                DN8[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                            }

                            if (count8    == 500)
                            {
                                count8 = -1;
                            }
                            break;

                        /*
                        DN8[count8] = spl[1] + "B" + spl[k];
                        count8++;
                        //DN8DSK[count19] = spl[1] + "B" + spl[k];
                        //count19++;

                        //if (count19 == 50000)
                        //{
                        //    count19 = 0;
                        //}

                        if (count8    == 500)
                        {
                            count8 = 0;
                        }

                        break;*/
                        case "DN9":

                            if (count9 != -1)
                            {
                                DN9[count9] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                                //DN1[count1] = spl[1] + "B" + spl[k];
                                count9++;
                            }
                            else
                            {
                                Array.Sort(DN9);
                                DN9[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                            }

                            if (count9    == 500)
                            {
                                count9 = -1;
                            }
                            break;

                        /*
                        DN9[count9] = spl[1] + "B" + spl[k];
                        count9++;
                        //DN9DSK[count20] = spl[1] + "B" + spl[k];
                        //count20++;

                        //if (count20 == 50000)
                        //{
                        //    count20 = 0;
                        //}

                        if (count9    == 500)
                        {
                            count9 = 0;
                        }

                        break;*/
                        case "DN10":
                            if (count10    == 500)
                            {
                                count10 = -1;
                            }
                            
                            if (count10 != -1)
                            {
                                DN10[count10] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                                //DN1[count1] = spl[1] + "B" + spl[k];
                                count10++;
                            }
                            else
                            {
                                Array.Sort(DN10);
                                DN10[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                            }

                            break;

                        /*
                        DN10[count10] = spl[1] + "B" + spl[k];
                        count10++;
                        //DN10DSK[count21] = spl[1] + "B" + spl[k];
                        //count21++;

                        //if (count21 == 50000)
                        //{
                        //    count21 = 0;
                        //}

                        if (count10    == 500)
                        {
                            count10 = 0;
                        }

                        break;*/
                    }


                }
            }
        }
        //MessageBox.Show("local cache Successfull");
        System.out.println("local cache Successfull");
    }
    public static void cachefillng1()
    {
        using (StreamReader sr = File.OpenText("e:\\DataNode.txt"))
        {
            String s = String.Empty;
            while ((s = sr.readLine()) != null)
            {
                String[] spl = s.Split(' ');
                for (int k = 2; k < spl.Length; k++)
                {

                    String Datanode = spl[0];
                    switch (Datanode)
                    {
                        case "DN1":

                            if (count1 != -1)
                            {
                                DN1[count1] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                                //DN1[count1] = spl[1] + "B" + spl[k];
                                count1++;
                            }
                            else
                            {
                                Array.Sort(DN1);
                                DN1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                            }

                            if (count1    == 500)
                            {
                                count1 = -1;
                            }
                            break;

                        case "DN2":

                            if (count2 != -1)
                            {
                                DN2[count2] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];


                                count2++;
                            }
                            else
                            {
                                Array.Sort(DN2);
                                DN2[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];
                            }

                            if (count2    == 500)
                            {
                                count2 = -1;
                            }
                            break;

                        /*DN2[count2] = spl[1] + "B" + spl[k];
                        count2++;
                        //DN2DSK[count13] = spl[1] + "B" + spl[k];
                        //count13++;

                        //if (count13 == 50000)
                        //{
                        //    count13 = 0;
                        //}

                        if (count2    == 500)
                        {
                            count2 = 0;
                        }

                        break;*/
                        case "DN3":

                            if (count3 != -1)
                            {
                                DN1[count3] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                                //DN1[count1] = spl[1] + "B" + spl[k];
                                count3++;
                            }
                            else
                            {
                                Array.Sort(DN3);
                                DN3[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                            }

                            if (count3    == 500)
                            {
                                count3 = -1;
                            }
                            break;



                        /*                                DN3[count3] = spl[1] + "B" + spl[k];
                                                        count3++;
                                                        //DN3DSK[count14] = spl[1] + "B" + spl[k];
                                                        //count14++;

                                                        //if (count14 == 50000)
                                                        //{
                                                        //    count14 = 0;
                                                        //}

                            
                                                        if (count3    == 500)
                                                        {
                                                            count3 = 0;
                                                        }

                                                        break;*/
                        case "DN4":

                            if (count4 != -1)
                            {
                                DN4[count4] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                                //DN1[count1] = spl[1] + "B" + spl[k];
                                count4++;
                            }
                            else
                            {
                                Array.Sort(DN4);
                                DN4[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                            }

                            if (count4    == 500)
                            {
                                count4 = -1;
                            }
                            break;

                        /*                                DN4[count4] = spl[1] + "B" + spl[k];
                                                        count4++;

                                                        //DN4DSK[count15] = spl[1] + "B" + spl[k];
                                                        //count15++;

                                                        //if (count15 == 10000)
                                                        //{
                                                        //    count15 = 0;
                                                        //}

                                                        if (count4    == 500)
                                                        {
                                                            count4 = 0;
                                                        }

                                                        break;*/
                        case "DN5":

                            if (count5 != -1)
                            {
                                DN5[count5] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                                //DN1[count1] = spl[1] + "B" + spl[k];
                                count5++;
                            }
                            else
                            {
                                Array.Sort(DN5);
                                DN5[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                            }

                            if (count5    == 500)
                            {
                                count5 = -1;
                            }
                            break;

                        /*
                        DN5[count5] = spl[1] + "B" + spl[k];
                        count5++;
                        //DN5DSK[count16] = spl[1] + "B" + spl[k];
                        //count16++;

                        //if (count16 == 10000)
                        //{
                        //    count16 = 0;
                        //}

                        if (count5    == 500)
                        {
                            count5 = 0;
                        }

                        break;*/
                        case "DN6":

                            if (count6 != -1)
                            {
                                DN6[count6] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                                //DN1[count1] = spl[1] + "B" + spl[k];
                                count6++;
                            }
                            else
                            {
                                Array.Sort(DN6);
                                DN6[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                            }

                            if (count6    == 500)
                            {
                                count6 = -1;
                            }
                            break;

                        /*
                        DN6[count6] = spl[1] + "B" + spl[k];
                        count6++;
                        //DN6DSK[count17] = spl[1] + "B" + spl[k];
                        //count17++;

                        //if (count17 == 10000)
                        //{
                        //    count17 = 0;
                        //}

                        if (count6    == 500)
                        {
                            count6 = 0;
                        }

                        break;*/
                        case "DN7":
                            if (count7 != -1)
                            {
                                DN7[count7] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                                //DN1[count1] = spl[1] + "B" + spl[k];
                                count7++;
                            }
                            else
                            {
                                Array.Sort(DN7);
                                DN7[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                            }

                            if (count7    == 500)
                            {
                                count7 = -1;
                            }
                            break;

                        /*
                        DN7[count7] = spl[1] + "B" + spl[k];
                        count7++;
                        //DN7DSK[count18] = spl[1] + "B" + spl[k];
                        //count18++;

                        //if (count18 == 10000)
                        //{
                        //    count18 = 0;
                        //}

                        if (count7    == 500)
                        {
                            count7 = 0;
                        }

                        break;*/
                        case "DN8":

                            if (count8 != -1)
                            {
                                DN8[count8] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                                //DN1[count1] = spl[1] + "B" + spl[k];
                                count8++;
                            }
                            else
                            {
                                Array.Sort(DN8);
                                DN8[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                            }

                            if (count8    == 500)
                            {
                                count8 = -1;
                            }
                            break;

                        /*
                        DN8[count8] = spl[1] + "B" + spl[k];
                        count8++;
                        //DN8DSK[count19] = spl[1] + "B" + spl[k];
                        //count19++;

                        //if (count19 == 10000)
                        //{
                        //    count19 = 0;
                        //}

                        if (count8    == 500)
                        {
                            count8 = 0;
                        }

                        break;*/
                        case "DN9":

                            if (count9 != -1)
                            {
                                DN9[count9] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                                //DN1[count1] = spl[1] + "B" + spl[k];
                                count9++;
                            }
                            else
                            {
                                Array.Sort(DN9);
                                DN9[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                            }

                            if (count9    == 500)
                            {
                                count9 = -1;
                            }
                            break;

                        /*
                        DN9[count9] = spl[1] + "B" + spl[k];
                        count9++;
                        //DN9DSK[count20] = spl[1] + "B" + spl[k];
                        //count20++;

                        //if (count20 == 10000)
                        //{
                        //    count20 = 0;
                        //}

                        if (count9    == 500)
                        {
                            count9 = 0;
                        }

                        break;*/
                        case "DN10":
                            if (count10 != -1)
                            {
                                DN10[count10] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                                //DN1[count1] = spl[1] + "B" + spl[k];
                                count10++;
                            }
                            else
                            {
                                Array.Sort(DN10);
                                DN10[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                            }

                            if (count10    == 500)
                            {
                                count10 = -1;
                            }
                            break;

                        /*
                        DN10[count10] = spl[1] + "B" + spl[k];
                        count10++;
                        //DN10DSK[count21] = spl[1] + "B" + spl[k];
                        //count21++;

                        //if (count21 == 10000)
                        //{
                        //    count21 = 0;
                        //}

                        if (count10    == 500)
                        {
                            count10 = 0;
                        }

                        break;*/
                    }


                }
            }
        }
        //MessageBox.Show("local cache Successfull");
        System.out.println("local cache Successfull");
    }

    // private void button2_Click(object sender, EventArgs e)

    public static void AverageReadWriteAccesstime()
    {

        t3 = new Thread(AverageReadWriteAccesstime1);
        t3.Start();
    }
     public static void AverageReadWriteAccesstime1()
    {
    

        Random random1 = new Random();

        splochit = 0;
        spnochit = 0;
        spgochit = 0;
        spdiskhit = 0;

        aplochit = 0;
        apnochit = 0;
        apgochit = 0;
        apdiskhit = 0;

        aglochit = 0;
        agnochit = 0;
        aggochit = 0;
        agdiskhit = 0;
        dngoc = 0;
        dn1 = 0;
        dn2 = 0;
        dn3 = 0;
        dn4 = 0;
        dn5 = 0;
        dn6 = 0;
        dn7 = 0;
        dn8 = 0;
        dn9 = 0;
        dn10 = 0;
        dn1a = 0;
        dn2a = 0;
        dn3a = 0;
        dn4a = 0;
        dn5a = 0;
        dn6a = 0;
        dn7a = 0;
        dn8a = 0;
        dn9a = 0;
        dn10a = 0;

        int dn1loc = 0;
        int dn2loc = 0;
        int dn3loc = 0;
        int dn4loc = 0;
        int dn5loc = 0;
        int dn6loc = 0;
        int dn7loc = 0;
        int dn8loc = 0;
        int dn9loc = 0;
        int dn10loc = 0;


        int dn1dsk = 0;
        int dn2dsk = 0;
        int dn3dsk = 0;
        int dn4dsk = 0;
        int dn5dsk = 0;
        int dn6dsk = 0;
        int dn7dsk = 0;
        int dn8dsk = 0;
        int dn9dsk = 0;
        int dn10dsk = 0;



        int dn1loca = 0;
        int dn2loca = 0;
        int dn3loca = 0;
        int dn4loca = 0;
        int dn5loca = 0;
        int dn6loca = 0;
        int dn7loca = 0;
        int dn8loca = 0;
        int dn9loca = 0;
        int dn10loca = 0;


        int dn1dska = 0;
        int dn2dska = 0;
        int dn3dska = 0;
        int dn4dska = 0;
        int dn5dska = 0;
        int dn6dska = 0;
        int dn7dska = 0;
        int dn8dska = 0;
        int dn9dska = 0;
        int dn10dska = 0;

        waccesstime = 0;
        waccesstimea = 0;
        waccesstimeaa = 0;
        raccesstime = 0;
        raccesstimea = 0;
        raccesstimeaa = 0;
        int dn1ndsk = 0;
        spaccesstime = 0.0;
        spavgaccesstime = 0.0;
        sptotalaccesstime = 0.0;
        avgraccesstime = 0;
        avgraccesstimea = 0;
        avgraccesstimeaa = 0;
        avgwaccesstime = 0;
        avgwaccesstimea = 0;
        avgwaccesstimeaa = 0;

        apaccesstime = 0.0;
        apavgaccesstime = 0.0;
        aptotalaccesstime = 0.0;
        raccesstime = 0;
        raccesstimea = 0;
        raccesstimeaa = 0;
        waccesstime = 0;
        waccesstimea = 0;
        waccesstimeaa = 0;

        agaccesstime = 0.0;
        agavgaccesstime = 0.0;
        agtotalaccesstime = 0.0;

        int bno1 = 0;
        int fno1 = 0;
        int lc = 0;
        int proc = 0;
        int proc2 = 0;
        int blocks = 0;
        int appno = 0;
        System.out.println("Enter No.of Processes");
        int tot1 = Convert.ToInt32(Console.readLine());
        ////System.out.println("Enter No.of Write Processes");
        //int wapps = Convert.ToInt32(Console.readLine());
        
         int apps=8*(tot1/10);
         int wapps = 2 * (tot1 / 10);

         int km = 0;
        while (km < wapps)
        {
            int ticks = random1.Next(100)+1;
            bno1 = random1.Next(100)+1;
            writefiles[km] = ticks;
            writeblocks[km] = bno1;
            km++;
        }

        km = 0;
        while (km < apps)
        {
            int ticks = random1.Next(100)+1;
            bno1 = random1.Next(100)+1;
            readfiles[km] = ticks;
            readblocks[km] = bno1;
            km++;
        }

        int kl = 0;
        int tot = wapps + apps;
        int[] rw = new int[tot];
        int rws = 0;
        int rwcount = 0;
        int rcount = 0;
         int gcount=0;
        while (kl < tot)
        {
            rws = random1.Next(3)+1;
            if ((rws == 1 || rws == 2) )
            {
                if (rwcount < 8)
                {
                    rwcount++;
                    rw[kl] = 1;
                    kl++;
                    gcount++;
                }
            }
            else
            {
                if (rcount < 2)
                {
                    rcount++;
                    rw[kl] = 0;
                    kl++;
                    gcount++;
                   
                }
            }
            if (gcount >= 10 && rcount >= 2)
            {
                gcount = 0;
                rcount = 0;
                rwcount = 0;
            }
            if (gcount >= 10 && rwcount >= 8)
            {
                gcount = 0;
                rwcount = 0;
                rcount = 0;
            }

         
        }


        proc = 0;
        int appcount = 0;
        int write1 = 0;
        // while (proc < wapps)
        while (appcount < tot)
        {
            if (appcount % 10000 == 0)
            {
                System.out.println("appn0:" + appcount);
            }
            if (rw[appcount] == 0)
            {
                write1++;
                proc++;
                mod = false;
                int loc = 0;
                int dloc = 0;
                int noc = 0;
                int goc = 0;
                appno = random1.Next(10)+1;
                String cliname = "DN" + appno;
                String filename = "F" + writefiles[proc];
                int proc1 = proc;
                String blocknum = "B" + writeblocks[proc1];
                int check = 0;
                String request = filename + blocknum;
                boolean validation = false;

                int check2 = 0;
                while (check2 < DN1DSKaa.Length && DN1DSKaa[check2] != null)
                {
                    if (DN1DSKaa[check2] == request)
                    {
                        validation = true;
                        check2 = DN1DSKaa.Length + 1;
                    }
                    check2++;
                    ////System.out.println("DN1DSKaa");
                }

                check2 = 0;
                while (check2 < DN2DSKaa.Length && DN2DSKaa[check2] != null)
                {
                    if (DN2DSKaa[check2] == request)
                    {
                        validation = true;
                        check2 = DN2DSKaa.Length + 1;
                    }
                    check2++;
                    ////System.out.println("DN2DSKaa");

                }



                check2 = 0;
                while (check2 < DN3DSKaa.Length && DN3DSKaa[check2] != null)
                {
                    if (DN3DSKaa[check2] == request)
                    {
                        validation = true;
                        check2 = DN3DSKaa.Length + 1;
                    }
                    check2++;
                    ////System.out.println("DN3DSKaa");

                }



                check2 = 0;
                while (check2 < DN4DSKaa.Length && DN4DSKaa[check2] != null)
                {
                    if (DN4DSKaa[check2] == request)
                    {
                        validation = true;
                        check2 = DN4DSKaa.Length + 1;
                    }
                    check2++;

                    ////System.out.println("DN4DSKaa");

                }


                check2 = 0;
                while (check2 < DN5DSKaa.Length && DN5DSKaa[check2] != null)
                {
                    if (DN5DSKaa[check2] == request)
                    {
                        validation = true;
                        check2 = DN5DSKaa.Length + 1;
                    }
                    check2++;

                    ////System.out.println("DN5DSKaa");

                }


                check2 = 0;
                while (check2 < DN6DSKaa.Length && DN6DSKaa[check2] != null)
                {
                    if (DN6DSKaa[check2] == request)
                    {
                        validation = true;
                        check2 = DN6DSKaa.Length + 1;
                    }
                    check2++;
                    ////System.out.println("DN6DSKaa");
                }


                check2 = 0;
                while (check2 < DN7DSKaa.Length && DN7DSKaa[check2] != null)
                {
                    if (DN7DSKaa[check2] == request)
                    {
                        validation = true;
                        check2 = DN7DSKaa.Length + 1;
                    }
                    check2++;
                    ////System.out.println("DN7DSKaa");
                }


                check2 = 0;
                while (check2 < DN8DSKaa.Length && DN8DSKaa[check2] != null)
                {
                    if (DN8DSKaa[check2] == request)
                    {
                        validation = true;
                        check2 = DN8DSKaa.Length + 1;
                    }
                    check2++;
                    ////System.out.println("DN8DSKaa");
                }


                check2 = 0;
                while (check2 < DN9DSKaa.Length && DN9DSKaa[check2] != null)
                {
                    if (DN9DSKaa[check2] == request)
                    {
                        validation = true;
                        check2 = DN9DSKaa.Length + 1;
                    }
                    check2++;
                    ////System.out.println("DN9DSKaa");
                }


                check2 = 0;
                while (check2 < DN10DSKaa.Length && DN10DSKaa[check2] != null)
                {
                    if (DN10DSKaa[check2] == request)
                    {
                        validation = true;
                        check2 = DN10DSKaa.Length + 1;
                    }
                    check2++;
                    ////System.out.println("DN10DSKaa");
                }



                if (validation == true)
                {
                    waccesstimeaa += 50.130;

                }

                else
                {
                    waccesstimeaa += 46.125;

                    int replica = 0;
                    while (replica <= 2)
                    {
                        replica++;
                        switch (cliname)
                        {
                            case "DN1":
                                ////System.out.println("DN1DSKaa1");
                                if (count12aa == 10000)
                                {
                                    count12aa = 0;
                                }

                                DN1DSKaa[count12aa] = request;
                                count12aa++;
                                if (replica == 1)
                                {
                                    int rep1 = random1.Next(5)+1;
                                    while (rep1 == 1)
                                    {
                                        rep1 = random1.Next(5)+1;
                                    }
                                    cliname = "DN" + rep1;
                                }
                                if (replica == 2)
                                {
                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;
                                    cliname = "DN" + rep2;

                                }
                                break;




                            case "DN2":
                                ////System.out.println("DN2DSKaa1");

                                if (count13aa == 10000)
                                {
                                    count13aa = 0;
                                }

                                DN3DSKaa[count13aa] = request;
                                count13aa++;
                                if (replica == 1)
                                {
                                    int rep1 = random1.Next(5)+1;
                                    while (rep1 == 1)
                                    {
                                        rep1 = random1.Next(5)+1;
                                    }
                                    cliname = "DN" + rep1;
                                }
                                if (replica == 2)
                                {
                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;
                                    cliname = "DN" + rep2;

                                }
                                break;


                            case "DN3":
                                ////System.out.println("DN3DSKaa1");

                                if (count14aa == 10000)
                                {
                                    count14aa = 0;
                                }

                                DN3DSKaa[count14aa] = request;
                                count14aa++;
                                if (replica == 1)
                                {
                                    int rep1 = random1.Next(5)+1;
                                    while (rep1 == 1)
                                    {
                                        rep1 = random1.Next(5)+1;
                                    }
                                    cliname = "DN" + rep1;
                                }
                                if (replica == 2)
                                {
                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;
                                    cliname = "DN" + rep2;

                                }
                                break;

                            case "DN4":
                                ////System.out.println("DN4DSKaa1");

                                if (count15aa == 10000)
                                {
                                    count15aa = 0;
                                }

                                DN4DSKaa[count15aa] = request;
                                count15aa++;
                                if (replica == 1)
                                {
                                    int rep1 = random1.Next(5)+1;
                                    while (rep1 == 1)
                                    {
                                        rep1 = random1.Next(5)+1;
                                    }
                                    cliname = "DN" + rep1;
                                }
                                if (replica == 2)
                                {
                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;
                                    cliname = "DN" + rep2;

                                }
                                break;

                            case "DN5":
                                ////System.out.println("DN5DSKaa1");

                                if (count16aa == 10000)
                                {
                                    count16aa = 0;
                                }

                                DN5DSKaa[count16aa] = request;
                                count16aa++;
                                if (replica == 1)
                                {
                                    int rep1 = random1.Next(5)+1;
                                    while (rep1 == 1)
                                    {
                                        rep1 = random1.Next(5)+1;
                                    }
                                    cliname = "DN" + rep1;
                                }
                                if (replica == 2)
                                {
                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;
                                    cliname = "DN" + rep2;

                                }
                                break;

                            case "DN6":
                                ////System.out.println("DN6DSKaa1");

                                if (count17aa == 10000)
                                {
                                    count17aa = 0;
                                }

                                DN6DSKaa[count17aa] = request;
                                count17aa++;
                                if (replica == 1)
                                {
                                    int rep1 = random1.Next(5)+1;
                                    while (rep1 == 1)
                                    {
                                        rep1 = random1.Next(5)+1;
                                    }
                                    cliname = "DN" + rep1;
                                }
                                if (replica == 2)
                                {
                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;
                                    cliname = "DN" + rep2;

                                }
                                break;


                            case "DN7":
                                ////System.out.println("DN7DSKaa1");

                                if (count18aa == 10000)
                                {
                                    count18aa = 0;
                                }

                                DN7DSKaa[count18aa] = request;
                                count18aa++;
                                if (replica == 1)
                                {
                                    int rep1 = random1.Next(5)+1;
                                    while (rep1 == 1)
                                    {
                                        rep1 = random1.Next(5)+1;
                                    }
                                    cliname = "DN" + rep1;
                                }
                                if (replica == 2)
                                {
                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;
                                    cliname = "DN" + rep2;

                                }
                                break;



                            case "DN8":
                                ////System.out.println("DN8DSKaa1");

                                if (count19aa == 10000)
                                {
                                    count19aa = 0;
                                }

                                DN8DSKaa[count19aa] = request;
                                count19aa++;
                                if (replica == 1)
                                {
                                    int rep1 = random1.Next(5)+1;
                                    while (rep1 == 1)
                                    {
                                        rep1 = random1.Next(5)+1;
                                    }
                                    cliname = "DN" + rep1;
                                }
                                if (replica == 2)
                                {
                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;
                                    cliname = "DN" + rep2;

                                }
                                break;



                            case "DN9":
                                ////System.out.println("DN9DSKaa1");

                                if (count20aa == 10000)
                                {
                                    count20aa = 0;
                                }

                                DN9DSKaa[count20aa] = request;
                                count20aa++;
                                if (replica == 1)
                                {
                                    int rep1 = random1.Next(5)+1;
                                    while (rep1 == 1)
                                    {
                                        rep1 = random1.Next(5)+1;
                                    }
                                    cliname = "DN" + rep1;
                                }
                                if (replica == 2)
                                {
                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;
                                    cliname = "DN" + rep2;

                                }
                                break;


                            case "DN10":
                                ////System.out.println("DN10DSKaa1");

                                if (count21aa == 10000)
                                {
                                    count21aa = 0;
                                }

                                DN10DSKaa[count21aa] = request;
                                count21aa++;
                                if (replica == 1)
                                {
                                    int rep1 = random1.Next(5)+1;
                                    while (rep1 == 1)
                                    {
                                        rep1 = random1.Next(5)+1;
                                    }
                                    cliname = "DN" + rep1;
                                }
                                if (replica == 2)
                                {
                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;
                                    cliname = "DN" + rep2;

                                }
                                break;
                        }
                    }
                }










































                //waccesstimea += 46.140;

                validation = false;
                while (check < DN1a.Length && DN1a[check] != null)
                {
                    String[] filerequest = DN1a[check].Split(':');
                    if (filerequest[1] == request)
                    {
                        validation = true;
                        DN1a[check] = "X:X";
                        check2 = 0;
                        while (check2 < DN1DSKa.Length && DN1DSKa[check2] != null)
                        {
                            if (DN1DSKa[check2] == request)
                            {
                                DN1a[check] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                check2 = DN1DSKa.Length + 1;
                            }
                            check2++;

                        }

                    }
                    ////System.out.println("DN1DSKa1");

                    check++;

                }


                check = 0;
                while (check < DN2a.Length && DN2a[check] != null)
                {
                    String[] filerequest = DN2a[check].Split(':');
                    if (filerequest[1] == request)
                    {
                        validation = true;
                        DN2a[check] = "X:X";
                        check2 = 0;
                        while (check2 < DN2DSKa.Length && DN2DSKa[check2] != null)
                        {
                            if (DN2DSKa[check2] == request)
                            {
                                DN2a[check] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                check2 = DN2DSKa.Length + 1;
                            }
                            check2++;
                        }

                    }
                    check++;

                    ////System.out.println("DN2DSKa1");

                }



                check = 0;
                while (check < DN3a.Length && DN3a[check] != null)
                {
                    String[] filerequest = DN3a[check].Split(':');
                    if (filerequest[1] == request)
                    {
                        validation = true;
                        DN3a[check] = "X:X";
                        check2 = 0;
                        while (check2 < DN3DSKa.Length && DN3DSKa[check2] != null)
                        {
                            if (DN3DSKa[check2] == request)
                            {
                                DN3a[check] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                check2 = DN3DSKa.Length + 1;
                            }
                            check2++;
                        }

                    }
                    check++;

                    ////System.out.println("DN3DSKa1");

                }



                check = 0;
                while (check < DN4a.Length && DN4a[check] != null)
                {
                    String[] filerequest = DN4a[check].Split(':');
                    if (filerequest[1] == request)
                    {
                        validation = true;
                        DN4a[check] = "X:X";
                        check2 = 0;
                        while (check2 < DN4DSKa.Length && DN4DSKa[check2] != null)
                        {
                            if (DN4DSKa[check2] == request)
                            {
                                DN4a[check] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                check2 = DN4DSKa.Length + 1;
                            }
                            check2++;
                        }

                    }
                    check++;

                    ////System.out.println("DN4DSKa1");

                }



                check = 0;
                while (check < DN5a.Length && DN5a[check] != null)
                {
                    String[] filerequest = DN5a[check].Split(':');
                    if (filerequest[1] == request)
                    {
                        validation = true;
                        DN5a[check] = "X:X";
                        check2 = 0;
                        while (check2 < DN5DSKa.Length && DN5DSKa[check2] != null)
                        {
                            if (DN5DSKa[check2] == request)
                            {
                                DN5a[check] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                check2 = DN5DSKa.Length + 1;
                            }
                            check2++;
                        }

                    }
                    check++;

                    ////System.out.println("DN5DSKa1");

                }



                check = 0;
                while (check < DN6a.Length && DN6a[check] != null)
                {
                    String[] filerequest = DN6a[check].Split(':');
                    if (filerequest[1] == request)
                    {
                        validation = true;
                        DN6a[check] = "X:X";
                        check2 = 0;
                        while (check2 < DN6DSKa.Length && DN6DSKa[check2] != null)
                        {
                            if (DN6DSKa[check2] == request)
                            {
                                DN6a[check] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                check2 = DN6DSKa.Length + 1;
                            }
                            check2++;
                        }

                    }
                    check++;

                    ////System.out.println("DN6DSKa1");

                }



                check = 0;
                while (check < DN7a.Length && DN7a[check] != null)
                {
                    String[] filerequest = DN7a[check].Split(':');
                    if (filerequest[1] == request)
                    {
                        validation = true;
                        DN7a[check] = "X:X";
                        check2 = 0;
                        while (check2 < DN7DSKa.Length && DN7DSKa[check2] != null)
                        {
                            if (DN7DSKa[check2] == request)
                            {
                                DN7a[check] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                check2 = DN7DSKa.Length + 1;
                            }
                            check2++;
                        }

                    }
                    check++;

                    ////System.out.println("DN8DSKa1");

                }



                check = 0;
                while (check < DN8a.Length && DN8a[check] != null)
                {
                    String[] filerequest = DN8a[check].Split(':');
                    if (filerequest[1] == request)
                    {
                        validation = true;
                        DN8a[check] = "X:X";
                        check2 = 0;
                        while (check2 < DN8DSKa.Length && DN8DSKa[check2] != null)
                        {
                            if (DN8DSKa[check2] == request)
                            {
                                DN8a[check] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                check2 = DN8DSKa.Length + 1;
                            }
                            check2++;
                        }

                    }
                    check++;

                    ////System.out.println("DN8DSKa1");

                }



                check = 0;
                while (check < DN9a.Length && DN9a[check] != null)
                {
                    String[] filerequest = DN9a[check].Split(':');
                    if (filerequest[1] == request)
                    {
                        validation = true;
                        DN1a[check] = "X:X";
                        check2 = 0;
                        while (check2 < DN9DSKa.Length && DN9DSKa[check2] != null)
                        {
                            if (DN9DSKa[check2] == request)
                            {
                                DN9a[check] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                check2 = DN9DSKa.Length + 1;
                            }
                            check2++;
                        }

                    }
                    check++;

                    ////System.out.println("DN9DSKa1");

                }



                check = 0;
                while (check < DN10a.Length && DN10a[check] != null)
                {
                    String[] filerequest = DN10a[check].Split(':');
                    if (filerequest[1] == request)
                    {
                        validation = true;
                        DN10a[check] = "X:X";
                        check2 = 0;
                        while (check2 < DN10DSKa.Length && DN10DSKa[check2] != null)
                        {
                            if (DN10DSKa[check2] == request)
                            {
                                DN10a[check] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                check2 = DN10DSKa.Length + 1;
                            }
                            check2++;
                        }

                    }
                    check++;

                    ////System.out.println("DN10DSKa1");

                }







                /*
                check = 0;
                while (check < DN2a.Length && DN2a[check] != null)
                {
                    if (DN2a[check] == request)
                    {
                        validation = true;
                        DN2a[check] = "X:X";
                    }
                    check++;

                }

                check = 0;
                while (check < DN3a.Length && DN3a[check] != null)
                {
                    if (DN3a[check] == request)
                    {
                        validation = true;
                        DN3a[check] = "X:X";
                    }
                    check++;

                }

                check = 0;
                while (check < DN4a.Length && DN4a[check] != null)
                {
                    if (DN4a[check] == request)
                    {
                        validation = true;
                        DN4a[check] = "X:X";
                    }
                    check++;

                }

                check = 0;
                while (check < DN5a.Length && DN5a[check] != null)
                {
                    if (DN5a[check] == request)
                    {
                        validation = true;
                        DN5a[check] = "X:X";
                    }
                    check++;

                }

                check = 0;
                while (check < DN6a.Length && DN6a[check] != null)
                {
                    if (DN6a[check] == request)
                    {
                        validation = true;
                        DN6a[check] = "X:X";
                    }
                    check++;

                }

                check = 0;
                while (check < DN7a.Length && DN7a[check] != null)
                {
                    if (DN7a[check] == request)
                    {
                        validation = true;
                        DN7a[check] = "X:X";
                    }
                    check++;

                }

                check = 0;
                while (check < DN8a.Length && DN8a[check] != null)
                {
                    if (DN8a[check] == request)
                    {
                        validation = true;
                        DN8a[check] = "X:X";
                    }
                    check++;

                }

                check = 0;
                while (check < DN9a.Length && DN9a[check] != null)
                {
                    if (DN9a[check] == request)
                    {
                        validation = true;
                        DN9a[check] = "X:X";
                    }
                    check++;

                }

                check = 0;
                while (check < DN10a.Length && DN10a[check] != null)
                {
                    if (DN10a[check] == request)
                    {
                        validation = true;
                        DN10a[check] = "X:X";
                    }
                    check++;

                }*/
                if (validation == true)
                {
                    waccesstimea += 58.260;
                }

                if (validation == false)
                {
                    waccesstimea += 46.130;
                    int replica = 0;
                    while (replica <= 2)
                    {

                        ////System.out.println(cliname+":"+appcount+":"+request+":"+replica);

                        replica++;
                        switch (cliname)
                        {
                            case "DN1":

                                ////System.out.println("DN11DSKa1");


                                if (count1a    == 500)
                                {
                                    count1a = -1;
                                }




                                if (count12a == 10000)
                                {
                                    count12a = 0;
                                }

                                DN1DSKa[count12a] = request;
                                count12a++;
                                if (replica == 1)
                                {
                                    
                                if (count1a != -1)
                                {
                                    DN1a[count1a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count1a++;

                                }
                                else
                                {
                                    Array.Sort(DN1a);
                                    DN1a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                }

                                    int rep1 = random1.Next(5)+1;
                                    while (rep1 == 1)
                                    {
                                        rep1 = random1.Next(5)+1;
                                    }
                                    cliname = "DN" + rep1;
                                }
                                if (replica == 2)
                                {

                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;
                                    cliname = "DN" + rep2;

                                }
                                break;

                            case "DN2":

                                ////System.out.println("DN12DSKa1");



                                if (count2a    == 500)
                                {
                                    count2a = -1;
                                }




                                if (count13a == 10000)
                                {
                                    count13a = 0;
                                }

                                DN2DSKa[count13a] = request;
                                count13a++;
                                if (replica == 1)
                                {
                                                                        if (count2a != -1)
                                {
                                    DN2a[count2a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count2a++;

                                }
                                else
                                {
                                    Array.Sort(DN2a);
                                    DN2a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                }

                                    int rep1 = random1.Next(5)+1;
                                    while (rep1 == 2)
                                    {
                                        rep1 = random1.Next(5)+1;
                                    }
                                    cliname = "DN" + rep1;
                                }
                                if (replica == 2)
                                {

                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;
                                    cliname = "DN" + rep2;

                                }
                                break;
                            case "DN3":

                                ////System.out.println("DN13DSKa1");


                                if (count3a    == 500)
                                {
                                    count3a = -1;
                                }



                                if (count14a == 10000)
                                {
                                    count14a = 0;
                                }

                                DN3DSKa[count14a] = request;
                                count14a++;
                                if (replica == 1)
                                {
                                                                        if (count3a != -1)
                                {
                                    DN3a[count3a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count3a++;

                                }
                                else
                                {
                                    Array.Sort(DN3a);
                                    DN3a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                }


                                    int rep1 = random1.Next(5)+1;
                                    while (rep1 == 3)
                                    {
                                        rep1 = random1.Next(5)+1;
                                    }
                                    cliname = "DN" + rep1;
                                }
                                if (replica == 2)
                                {

                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;
                                    cliname = "DN" + rep2;

                                }

                                break;
                            case "DN4":

                                ////System.out.println("DN14DSKa1");

                                if (count4a    == 500)
                                {
                                    count4a = -1;
                                }



                                if (count15a == 10000)
                                {
                                    count15a = 0;
                                }

                                DN4DSKa[count15a] = request;
                                count15a++;

                                if (replica == 1)
                                {

                                    
                                if (count4a != -1)
                                {
                                    DN4a[count4a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count4a++;

                                }
                                else
                                {
                                    Array.Sort(DN4a);
                                    DN4a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                }




                                    int rep1 = random1.Next(5)+1;
                                    while (rep1 == 4)
                                    {
                                        rep1 = random1.Next(5)+1;
                                    }
                                    cliname = "DN" + rep1;
                                }
                                if (replica == 2)
                                {

                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;
                                    cliname = "DN" + rep2;

                                }

                                break;

                            case "DN5":


                                ////System.out.println("DN15DSKa1");



                                if (count5a    == 500)
                                {
                                    count5a = -1;
                                }




                                DN5DSKa[count16a] = request;




                                count16a++;

                                if (count16a == 10000)
                                {
                                    count16a = 0;
                                }
                                if (replica == 1)
                                {
                                    
                                if (count5a != -1)
                                {
                                    DN5a[count5a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count5a++;

                                }
                                else
                                {
                                    Array.Sort(DN5a);
                                    DN5a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                }


                                    int rep1 = random1.Next(5)+1;
                                    while (rep1 == 5)
                                    {
                                        rep1 = random1.Next(5)+1;
                                    }
                                    cliname = "DN" + rep1;
                                }
                                if (replica == 2)
                                {

                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;
                                    cliname = "DN" + rep2;

                                }


                                break;
                            case "DN6":

                                ////System.out.println("DN16DSKa1");





                                if (count6a    == 500)
                                {
                                    count6a = -1;
                                }


                                DN6DSKa[count17a] = request;
                                count17a++;

                                if (count17a == 10000)
                                {
                                    count17a = 0;
                                }

                                if (replica == 1)
                                {
                                                                        if (count6a != -1)
                                {
                                    DN6a[count6a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count6a++;

                                }
                                else
                                {
                                    Array.Sort(DN6a);
                                    DN6a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                }

                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;

                                    while (rep2 == 6)
                                    {
                                        rep = random1.Next(5)+1;
                                        rep2 = rep + 5;
                                    }

                                    cliname = "DN" + rep2;

                                }
                                if (replica == 2)
                                {
                                    int rep1 = random1.Next(5)+1;
                                    cliname = "DN" + rep1;

                                }

                                break;
                            case "DN7":


                                ////System.out.println("DN17DSKa1");




                                if (count7a >= 500)
                                {
                                    count7a = -1;
                                }


                                DN7DSKa[count18a] = request;
                                count18a++;

                                if (count18a == 10000)
                                {
                                    count18a = 0;
                                }

                                //if (count7    == 500)
                                //{
                                //    count7 = 0;
                                //}


                                if (replica == 1)
                                {
                                                                        if (count7a != -1)
                                {
                                    DN7a[count7a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count7a++;

                                }
                                else
                                {
                                    Array.Sort(DN7a);
                                    DN7a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                }


                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;

                                    while (rep2 == 7)
                                    {
                                        rep = random1.Next(5)+1;
                                        rep2 = rep + 5;
                                    }

                                    cliname = "DN" + rep2;

                                }
                                if (replica == 2)
                                {
                                    int rep1 = random1.Next(5)+1;
                                    cliname = "DN" + rep1;

                                }


                                break;
                            case "DN8":

                                ////System.out.println("DN18DSKa1");



                                if (count8a >= 500)
                                {
                                    count8a = -1;
                                }


                                //DN8[count8] = spl[1] + "B" + spl[k];
                                //count8++;
                                DN8DSKa[count19a] = request;
                                count19a++;

                                if (count19a == 10000)
                                {
                                    count19a = 0;
                                }

                                //if (count8    == 500)
                                //{
                                //    count8 = 0;
                                //}

                                if (replica == 1)
                                {

                                                                        if (count8a != -1)
                                {
                                    DN8a[count8a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count8a++;

                                }
                                else
                                {
                                    Array.Sort(DN8a);
                                    DN8a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                }



                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;

                                    while (rep2 == 8)
                                    {
                                        rep = random1.Next(5)+1;
                                        rep2 = rep + 5;
                                    }

                                    cliname = "DN" + rep2;

                                }
                                if (replica == 2)
                                {
                                    int rep1 = random1.Next(5)+1;
                                    cliname = "DN" + rep1;

                                }

                                break;
                            case "DN9":

                                ////System.out.println("DN19DSKa1");



                                if (count9a >= 500)
                                {
                                    count9a = -1;
                                }



                                //DN9[count9] = spl[1] + "B" + spl[k];
                                //count9++;
                                DN9DSKa[count20a] = request;
                                count20a++;

                                if (count20a == 10000)
                                {
                                    count20a = 0;
                                }

                                //if (count9    == 500)
                                //{
                                //    count9 = 0;
                                //}

                                if (replica == 1)
                                {
                                    
                                if (count9a != -1)
                                {
                                    DN9a[count9a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count9a++;

                                }
                                else
                                {
                                    Array.Sort(DN9a);
                                    DN9a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                }


                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;

                                    while (rep2 == 9)
                                    {
                                        rep = random1.Next(5)+1;
                                        rep2 = rep + 5;
                                    }

                                    cliname = "DN" + rep2;

                                }
                                if (replica == 2)
                                {
                                    int rep1 = random1.Next(5)+1;
                                    cliname = "DN" + rep1;

                                }

                                break;
                            case "DN10":

                                ////System.out.println("DN20DSKa1");


                                if (count10a >= 500)
                                {
                                    count10a = -1;
                                }



                                //DN10[count10] = spl[1] + "B" + spl[k];
                                //count10++;
                                DN10DSKa[count21a] = request;
                                count21a++;

                                if (count21a == 10000)
                                {
                                    count21a = 0;
                                }

                                //if (count10    == 500)
                                //{
                                //    count10 = 0;
                                //}

                                if (replica == 1)
                                {
                                                                        if (count10a != -1)
                                {
                                    DN10a[count10a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count10a++;

                                }
                                else
                                {
                                    Array.Sort(DN10a);
                                    DN10a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                }




                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;

                                    while (rep2 == 10)
                                    {
                                        rep = random1.Next(5)+1;
                                        rep2 = rep + 5;
                                    }

                                    cliname = "DN" + rep2;

                                }
                                if (replica == 2)
                                {
                                    int rep1 = random1.Next(5)+1;
                                    cliname = "DN" + rep1;

                                }

                                break;
                        }

                    }

                    //if (count11a != -1)
                    //{
                    //    //System.out.println("DN21DSKa1");

                    //    global1[count11a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                    //    count11a++;
                    //}

                    //else
                    //{

                    //    //System.out.println("DN22DSKa1");

                    //    Array.Sort(global1a);
                    //    global1a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                    //}

                    //if (count11a    == 500)
                    //{
                    //    count11a = -1;
                    //}






                    //avgwaccesstimea = waccesstimea / wapps;

                }
                //Up hadoop+ General cache





                //check = 0;
                //Haoop + sequential patterns


                validation = false;
                check = 0;
                while (check < DN1.Length && DN1[check] != null)
                {

                    //System.out.println("DN23DSKa1");

                    String[] filerequest = DN1[check].Split(':');
                    if (filerequest[1] == request)
                    {
                        validation = true;
                        DN1[check] = "X:X";
                        check2 = 0;
                        while (check2 < DN1DSK.Length && DN1DSK[check2] != null)
                        {
                            if (DN1DSK[check2] == request)
                            {
                                DN1[check] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                check2 = DN1DSK.Length + 1;
                            }
                            check2++;
                        }

                    }
                    check++;

                }


                check = 0;
                while (check < DN2.Length && DN2[check] != null)
                {

                    //System.out.println("DN24DSKa1");

                    String[] filerequest = DN2[check].Split(':');
                    if (filerequest[1] == request)
                    {
                        validation = true;
                        DN2[check] = "X:X";
                        check2 = 0;
                        while (check2 < DN2DSK.Length && DN2DSK[check2] != null)
                        {
                            if (DN2DSK[check2] == request)
                            {
                                DN2[check] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                check2 = DN2DSK.Length + 1;
                            }
                            check2++;
                        }

                    }
                    check++;

                }



                check = 0;
                while (check < DN3.Length && DN3[check] != null)
                {

                    ////System.out.println("DN25DSKa1");

                    String[] filerequest = DN3[check].Split(':');
                    if (filerequest[1] == request)
                    {
                        validation = true;
                        DN3[check] = "X:X";
                        check2 = 0;
                        while (check2 < DN3DSK.Length && DN3DSK[check2] != null)
                        {
                            if (DN3DSK[check2] == request)
                            {
                                DN3[check] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                check2 = DN3DSK.Length + 1;
                            }
                            check2++;
                        }

                    }
                    check++;

                }



                check = 0;
                while (check < DN4.Length && DN4[check] != null)
                {

                    ////System.out.println("DN26DSKa1");

                    String[] filerequest = DN4[check].Split(':');
                    if (filerequest[1] == request)
                    {
                        validation = true;
                        DN4[check] = "X:X";
                        check2 = 0;
                        while (check2 < DN4DSK.Length && DN4DSK[check2] != null)
                        {
                            if (DN4DSK[check2] == request)
                            {
                                DN4[check] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                check2 = DN4DSK.Length + 1;
                            }
                            check2++;
                        }

                    }
                    check++;

                }



                check = 0;
                while (check < DN5.Length && DN5[check] != null)
                {

                    ////System.out.println("DN27DSKa1");

                    String[] filerequest = DN5[check].Split(':');
                    if (filerequest[1] == request)
                    {
                        validation = true;
                        DN5[check] = "X:X";
                        check2 = 0;
                        while (check2 < DN5DSK.Length && DN5DSK[check2] != null)
                        {
                            if (DN5DSK[check2] == request)
                            {
                                DN5[check] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                check2 = DN5DSK.Length + 1;
                            }
                            check2++;
                        }

                    }
                    check++;

                }



                check = 0;
                while (check < DN6.Length && DN6[check] != null)
                {
                    ////System.out.println("DN28DSKa1");

                    String[] filerequest = DN6[check].Split(':');
                    if (filerequest[1] == request)
                    {
                        validation = true;
                        DN6[check] = "X:X";
                        check2 = 0;
                        while (check2 < DN6DSK.Length && DN6DSK[check2] != null)
                        {
                            if (DN6DSK[check2] == request)
                            {
                                DN6[check] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                check2 = DN6DSK.Length + 1;
                            }
                            check2++;
                        }

                    }
                    check++;

                }



                check = 0;
                while (check < DN7.Length && DN7[check] != null)
                {
                    ////System.out.println("DN29DSKa1");

                    String[] filerequest = DN7[check].Split(':');
                    if (filerequest[1] == request)
                    {
                        validation = true;
                        DN7[check] = "X:X";
                        check2 = 0;
                        while (check2 < DN7DSK.Length && DN7DSK[check2] != null)
                        {
                            if (DN7DSK[check2] == request)
                            {
                                DN7[check] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                check2 = DN7DSK.Length + 1;
                            }
                            check2++;
                        }

                    }
                    check++;

                }



                check = 0;
                while (check < DN8.Length && DN8[check] != null)
                {
                    ////System.out.println("DN30DSKa1");

                    String[] filerequest = DN8[check].Split(':');
                    if (filerequest[1] == request)
                    {
                        validation = true;
                        DN8[check] = "X:X";
                        check2 = 0;
                        while (check2 < DN8DSK.Length && DN8DSK[check2] != null)
                        {
                            if (DN8DSK[check2] == request)
                            {
                                DN8[check] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                check2 = DN8DSK.Length + 1;
                            }
                            check2++;
                        }

                    }
                    check++;

                }



                check = 0;
                while (check < DN9.Length && DN9[check] != null)
                {
                    ////System.out.println("DN31DSKa1");

                    String[] filerequest = DN9[check].Split(':');
                    if (filerequest[1] == request)
                    {
                        validation = true;
                        DN1[check] = "X:X";
                        check2 = 0;
                        while (check2 < DN9DSK.Length && DN9DSK[check2] != null)
                        {
                            if (DN9DSK[check2] == request)
                            {
                                DN9[check] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                check2 = DN9DSK.Length + 1;
                            }
                            check2++;
                        }

                    }
                    check++;

                }



                check = 0;
                while (check < DN10.Length && DN10[check] != null)
                {
                    ////System.out.println("DN32DSKa1");
                    String[] filerequest = DN10[check].Split(':');
                    if (filerequest[1] == request)
                    {
                        validation = true;
                        DN10[check] = "X:X";
                        check2 = 0;
                        while (check2 < DN10DSK.Length && DN10DSK[check2] != null)
                        {
                            if (DN10DSK[check2] == request)
                            {
                                DN10[check] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                check2 = DN10DSK.Length + 1;
                            }
                            check2++;
                        }

                    }
                    check++;

                }


                /*while (check < DN1.Length && DN1[check] != null)
                        {
                            if (DN1[check] == request)
                            {
                                validation = true;
                                DN1[check] = "X:X";
                            }
                            check++;

                        }

                        check = 0;
                        while (check < DN2.Length && DN2[check] != null)
                        {
                            if (DN2[check] == request)
                            {
                                validation = true;
                                DN2[check] = "X:X";
                            }
                            check++;

                        }

                        check = 0;
                        while (check < DN3.Length && DN3[check] != null)
                        {
                            if (DN3[check] == request)
                            {
                                validation = true;
                                DN3[check] = "X:X";
                            }
                            check++;

                        }

                        check = 0;
                        while (check < DN4.Length && DN4[check] != null)
                        {
                            if (DN4[check] == request)
                            {
                                validation = true;
                                DN4[check] = "X:X";
                            }
                            check++;

                        }

                        check = 0;
                        while (check < DN5.Length && DN5[check] != null)
                        {
                            if (DN5[check] == request)
                            {
                                validation = true;
                                DN5[check] = "X:X";
                            }
                            check++;

                        }

                        check = 0;
                        while (check < DN6.Length && DN6[check] != null)
                        {
                            if (DN6[check] == request)
                            {
                                validation = true;
                                DN6[check] = "X:X";
                            }
                            check++;

                        }

                        check = 0;
                        while (check < DN7.Length && DN7[check] != null)
                        {
                            if (DN7[check] == request)
                            {
                                validation = true;
                                DN7[check] = "X:X";
                            }
                            check++;

                        }

                        check = 0;
                        while (check < DN8.Length && DN8[check] != null)
                        {
                            if (DN8[check] == request)
                            {
                                validation = true;
                                DN8[check] = "X:X";
                            }
                            check++;

                        }

                        check = 0;
                        while (check < DN9.Length && DN9[check] != null)
                        {
                            if (DN9[check] == request)
                            {
                                validation = true;
                                DN9[check] = "X:X";
                            }
                            check++;

                        }

                        check = 0;
                        while (check < DN10.Length && DN10[check] != null)
                        {
                            if (DN10[check] == request)
                            {
                                validation = true;
                                DN10[check] = "X:X";
                            }
                            check++;

                        }*/

                waccesstime += 58.260;
                if (validation == false)
                {
                    waccesstime += 46.130;
              
                    int replica = 0;
                    while (replica <= 2)
                    {
                        replica++;
                        switch (cliname)
                        {
                            case "DN1":


                                ////System.out.println("DN32DSKa1");



                                if (count1    == 500)
                                {
                                    count1 = -1;
                                }


                                if (count12 == 10000)
                                {
                                    count12 = 0;
                                }

                                DN1DSK[count12] = request; ;
                                count12++;
                                if (replica == 1)
                                {
                                                                        if (count1 != -1)
                                {

                                    //DN1[count1] = spl[1] + "B" + spl[k];
                                    // count1++;
                                    DN1[count1] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count1++;
                                }
                                else
                                {
                                    Array.Sort(DN1);
                                    //DN1[0] = spl[1] + "B" + spl[k];
                                    // count1++;
                                    DN1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                }

                                    int rep1 = random1.Next(5)+1;
                                    while (rep1 == 1)
                                    {
                                        rep1 = random1.Next(5)+1;
                                    }
                                    cliname = "DN" + rep1;
                                }
                                if (replica == 2)
                                {

                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;
                                    cliname = "DN" + rep2;

                                }
                                break;

                            case "DN2":


                                ////System.out.println("DN33DSKa1");


                                if (count2    == 500)
                                {
                                    count2 = -1;
                                }


                                if (count13 == 10000)
                                {
                                    count13 = 0;
                                }

                                DN2DSK[count13] = request;
                                count13++;
                                if (replica == 1)
                                {
                                    
                                if (count2 != -1)
                                {

                                    //DN2[count2] = spl[1] + "B" + spl[k];
                                    // count2++;
                                    DN2[count2] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count2++;
                                }
                                else
                                {
                                    Array.Sort(DN2);
                                    //DN2[0] = spl[1] + "B" + spl[k];
                                    // count2++;
                                    DN2[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                }

                                    int rep1 = random1.Next(5)+1;
                                    while (rep1 == 2)
                                    {
                                        rep1 = random1.Next(5)+1;
                                    }
                                    cliname = "DN" + rep1;
                                }
                                if (replica == 2)
                                {

                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;
                                    cliname = "DN" + rep2;

                                }


                                break;
                            case "DN3":


                                ////System.out.println("DN34DSKa1");



                                if (count3    == 500)
                                {
                                    count3 = -1;
                                }


                                if (count14 == 10000)
                                {
                                    count14 = 0;
                                }

                                DN3DSK[count14] = request;
                                count14++;
                                if (replica == 1)
                                {
                                                                        if (count3 != -1)
                                {

                                    //DN3[count3] = spl[1] + "B" + spl[k];
                                    // count3++;
                                    DN3[count3] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count3++;
                                }
                                else
                                {
                                    Array.Sort(DN3);
                                    //DN3[0] = spl[1] + "B" + spl[k];
                                    // count3++;
                                    DN3[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                }

                                    int rep1 = random1.Next(5)+1;
                                    while (rep1 == 3)
                                    {
                                        rep1 = random1.Next(5)+1;
                                    }
                                    cliname = "DN" + rep1;
                                }
                                if (replica == 2)
                                {

                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;
                                    cliname = "DN" + rep2;

                                }

                                break;
                            case "DN4":


                                ////System.out.println("DN35DSKa1");



                                if (count4    == 500)
                                {
                                    count4 = -1;
                                }



                                if (count15 == 10000)
                                {
                                    count15 = 0;
                                }

                                DN4DSK[count15] = request;
                                count15++;

                                if (replica == 1)
                                {
                                                                        if (count4 != -1)
                                {

                                    //DN4[count4] = spl[1] + "B" + spl[k];
                                    // count4++;
                                    DN4[count4] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count4++;
                                }
                                else
                                {
                                    Array.Sort(DN4);
                                    //DN4[0] = spl[1] + "B" + spl[k];
                                    // count4++;
                                    DN4[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                }

                                    int rep1 = random1.Next(5)+1;
                                    while (rep1 == 4)
                                    {
                                        rep1 = random1.Next(5)+1;
                                    }
                                    cliname = "DN" + rep1;
                                }
                                if (replica == 2)
                                {

                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;
                                    cliname = "DN" + rep2;

                                }

                                break;

                            case "DN5":



                                //System.out.println("DN36DSKa1");


                                if (count5    == 500)
                                {
                                    count5 = -1;
                                }


                                DN5DSK[count16] = request;
                                count16++;

                                if (count16 == 10000)
                                {
                                    count16 = 0;
                                }
                                if (replica == 1)
                                {
                                                                        if (count5 != -1)
                                {

                                    //DN5[count5] = spl[1] + "B" + spl[k];
                                    // count5++;
                                    DN5[count5] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count5++;
                                }
                                else
                                {
                                    Array.Sort(DN5);
                                    //DN5[0] = spl[1] + "B" + spl[k];
                                    // count5++;
                                    DN5[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                }

                                    int rep1 = random1.Next(5)+1;
                                    while (rep1 == 5)
                                    {
                                        rep1 = random1.Next(5)+1;
                                    }
                                    cliname = "DN" + rep1;
                                }
                                if (replica == 2)
                                {

                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;
                                    cliname = "DN" + rep2;

                                }


                                break;
                            case "DN6":


                                //System.out.println("DN37DSKa1");

                                if (count6    == 500)
                                {
                                    count6 = -1;
                                }



                                DN6DSK[count17] = request;
                                count17++;

                                if (count17 == 10000)
                                {
                                    count17 = 0;
                                }

                                if (replica == 1)
                                {
                                    
                                if (count6 != -1)
                                {

                                    //DN6[count6] = spl[1] + "B" + spl[k];
                                    // count6++;
                                    DN6[count6] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count6++;
                                }
                                else
                                {
                                    Array.Sort(DN6);
                                    //DN6[0] = spl[1] + "B" + spl[k];
                                    // count6++;
                                    DN6[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                }

                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;

                                    while (rep2 == 6)
                                    {
                                        rep = random1.Next(5)+1;
                                        rep2 = rep + 5;
                                    }

                                    cliname = "DN" + rep2;

                                }
                                if (replica == 2)
                                {
                                    int rep1 = random1.Next(5)+1;
                                    cliname = "DN" + rep1;

                                }

                                break;
                            case "DN7":


                                //System.out.println("DN38DSKa1");


                                if (count7    == 500)
                                {
                                    count7 = -1;
                                }



                                DN7DSK[count18] = request;
                                count18++;

                                if (count18 == 10000)
                                {
                                    count18 = 0;
                                }

                                //if (count7    == 500)
                                //{
                                //    count7 = 0;
                                //}


                                if (replica == 1)
                                {
                                    
                                if (count7 != -1)
                                {

                                    //DN7[count7] = spl[1] + "B" + spl[k];
                                    // count7++;
                                    DN7[count7] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count7++;
                                }
                                else
                                {
                                    Array.Sort(DN7);
                                    //DN7[0] = spl[1] + "B" + spl[k];
                                    // count7++;
                                    DN7[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                }

                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;

                                    while (rep2 == 7)
                                    {
                                        rep = random1.Next(5)+1;
                                        rep2 = rep + 5;
                                    }

                                    cliname = "DN" + rep2;

                                }
                                if (replica == 2)
                                {
                                    int rep1 = random1.Next(5)+1;
                                    cliname = "DN" + rep1;

                                }


                                break;
                            case "DN8":



                                //System.out.println("DN39DSKa1");

                                if (count8    == 500)
                                {
                                    count8 = -1;
                                }


                                //DN8[count8] = spl[1] + "B" + spl[k];
                                //count8++;
                                DN8DSK[count19] = request;
                                count19++;

                                if (count19 == 10000)
                                {
                                    count19 = 0;
                                }

                                //if (count8    == 500)
                                //{
                                //    count8 = 0;
                                //}

                                if (replica == 1)
                                {
                                    
                                if (count8 != -1)
                                {

                                    //DN8[count8] = spl[1] + "B" + spl[k];
                                    // count8++;
                                    DN8[count8] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count8++;
                                }
                                else
                                {
                                    Array.Sort(DN8);
                                    //DN8[0] = spl[1] + "B" + spl[k];
                                    // count8++;
                                    DN8[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                }

                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;

                                    while (rep2 == 8)
                                    {
                                        rep = random1.Next(5)+1;
                                        rep2 = rep + 5;
                                    }

                                    cliname = "DN" + rep2;

                                }
                                if (replica == 2)
                                {
                                    int rep1 = random1.Next(5)+1;
                                    cliname = "DN" + rep1;

                                }

                                break;
                            case "DN9":

                                //System.out.println("DN40DSKa1");



                                if (count9    == 500)
                                {
                                    count9 = -1;
                                }



                                //DN9[count9] = spl[1] + "B" + spl[k];
                                //count9++;
                                DN9DSK[count20] = request;
                                count20++;

                                if (count20 == 10000)
                                {
                                    count20 = 0;
                                }

                                //if (count9    == 500)
                                //{
                                //    count9 = 0;
                                //}

                                if (replica == 1)
                                {
                                    
                                if (count9 != -1)
                                {

                                    //DN9[count9] = spl[1] + "B" + spl[k];
                                    // count9++;
                                    DN9[count9] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count9++;
                                }
                                else
                                {
                                    Array.Sort(DN9);
                                    //DN9[0] = spl[1] + "B" + spl[k];
                                    // count9++;
                                    DN9[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                }

                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;

                                    while (rep2 == 9)
                                    {
                                        rep = random1.Next(5)+1;
                                        rep2 = rep + 5;
                                    }

                                    cliname = "DN" + rep2;

                                }
                                if (replica == 2)
                                {
                                    int rep1 = random1.Next(5)+1;
                                    cliname = "DN" + rep1;

                                }

                                break;
                            case "DN10":


                                //System.out.println("DN41DSKa1");



                                if (count10    == 500)
                                {
                                    count10 = -1;
                                }


                                //DN10[count10] = spl[1] + "B" + spl[k];
                                //count10++;
                                DN10DSK[count21] = request;
                                count21++;

                                if (count21 == 10000)
                                {
                                    count21 = 0;
                                }

                                //if (count10    == 500)
                                //{
                                //    count10 = 0;
                                //}

                                if (replica == 1)
                                {
                                                                        if (count10 != -1)
                                {

                                    //DN10[count10] = spl[1] + "B" + spl[k];
                                    // count10++;
                                    DN10[count10] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count10++;
                                }
                                else
                                {
                                    Array.Sort(DN10);
                                    //DN10[0] = spl[1] + "B" + spl[k];
                                    // count10++;
                                    DN10[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                }

                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;

                                    while (rep2 == 10)
                                    {
                                        rep = random1.Next(5)+1;
                                        rep2 = rep + 5;
                                    }

                                    cliname = "DN" + rep2;

                                }
                                if (replica == 2)
                                {
                                    int rep1 = random1.Next(5)+1;
                                    cliname = "DN" + rep1;

                                }

                                break;
                        }
                    }

                    if (count11 != -1)
                    {

                        global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                        count11++;
                    }

                    else
                    {
                        Array.Sort(global1);
                        global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                    }


                    if (count11    == 2000)
                    {
                        count11 = -1;
                    }



                }

                avgwaccesstime = waccesstime / wapps;
                avgwaccesstimea = waccesstimea / wapps;
                avgwaccesstimeaa = waccesstimeaa / wapps;





                //label42.Text = avgwaccesstime + "";
                //label44.Text = avgwaccesstimea + "";
                //label53.Text = avgwaccesstimeaa + "";

            }



           // proc = 0;
            // while (proc < apps)
            else
            {
                /*mod = false;
                int loc = 0;
                int dlocaa = 0;
                int dloca = 0;
                int dloc = 0;
                int found = 0;
                int goc = 0;
                appno = random1.Next(10)+1;
                String cliname = "DN" + appno;
                String filename = "f" + readfiles[proc2];
                int proc3 = proc2;
                String blocknum = "B" + readblocks[proc3];
                int check = 0;
                String request = filename + blocknum;
                */
                mod = false;
                int loc = 0;
                int dlocaa = 0;
                int dloca = 0;
                int dloc = 0;
                int found = 0;
                int goc = 0;

                //int appno1 = random1.Next(45) + 5;
             
                counter++;
                if (counter == 1)
                {
                    appno12= random1.Next(20) + 5;
                    appno = random1.Next(10) + 1;
                    cliname = "DN" + appno;
                    appno = random1.Next(100) + 1;
                    Uname = "U" + appno;
                    appno = random1.Next(109) + 1;
                    Aname = "A" + appno;
                    filename = "F" + readfiles[proc2];
                    log = cliname + " " + Uname + " " + Aname + " " + filename + " ";
                }
                if (counter == appno12)
                {
                    using (StreamWriter sw =
                      File.AppendText("e:\\newlogs.txt"))
                    {
                        sw.WriteLine(log);
                        sw.Close();
                    }
                    log = "";
                    counter = 0;
                }
                int proc3 = proc2;
                String blocknum = "B" + readblocks[proc3];
                log += blocknum + " ";
                int check = 0;
                String request = filename + blocknum;


                switch (cliname)
                {
                    case "DN1":

                        //System.out.println("DN42DSKa1");

                        check = 0;
                        while (check < DN1DSKaa.Length && DN1DSKaa[check] != null)
                        {
                            int check2 = check + 1;
                            if (DN1DSKaa[check] == request)
                            {
                                raccesstimeaa += 12.135;
                                dlocaa = 1;
                                dn1dskaa++;
                                check = DN1DSKaa.Length + 1;
                            }
                            check++;

                        }

                        break;


                    case "DN2":

                        //System.out.println("DN43DSKa1");

                        check = 0;
                        while (check < DN2DSKaa.Length && DN2DSKaa[check] != null)
                        {
                            int check2 = check + 1;
                            if (DN2DSKaa[check] == request)
                            {
                                raccesstimeaa += 12.135;
                                dlocaa = 1;
                                dn1dskaa++;
                                check = DN2DSKaa.Length + 1;
                            }
                            check++;

                        }

                        break;


                    case "DN3":

                        //System.out.println("DN44DSKa1");

                        check = 0;
                        while (check < DN3DSKaa.Length && DN3DSKaa[check] != null)
                        {
                            int check2 = check + 1;
                            if (DN3DSKaa[check] == request)
                            {
                                raccesstimeaa += 12.135;
                                dlocaa = 1;
                                dn1dskaa++;
                                check = DN3DSKaa.Length + 1;
                            }
                            check++;

                        }

                        break;


                    case "DN4":

                        //System.out.println("DN45DSKa1");

                        check = 0;
                        while (check < DN4DSKaa.Length && DN4DSKaa[check] != null)
                        {
                            int check2 = check + 1;
                            if (DN4DSKaa[check] == request)
                            {
                                raccesstimeaa += 12.135;
                                dlocaa = 1;
                                dn1dskaa++;
                                check = DN4DSKaa.Length + 1;
                            }
                            check++;

                        }

                        break;


                    case "DN5":

                        //System.out.println("DN46DSKa1");

                        check = 0;
                        while (check < DN5DSKaa.Length && DN5DSKaa[check] != null)
                        {
                            int check2 = check + 1;
                            if (DN5DSKaa[check] == request)
                            {
                                raccesstimeaa += 12.135;
                                dlocaa = 1;
                                dn1dskaa++;
                                check = DN5DSKaa.Length + 1;
                            }
                            check++;

                        }

                        break;


                    case "DN6":

                        //System.out.println("DN47DSKa1");

                        check = 0;
                        while (check < DN6DSKaa.Length && DN6DSKaa[check] != null)
                        {
                            int check2 = check + 1;
                            if (DN6DSKaa[check] == request)
                            {
                                raccesstimeaa += 12.135;
                                dlocaa = 1;
                                dn1dskaa++;
                                check = DN6DSKaa.Length + 1;
                            }
                            check++;

                        }

                        break;


                    case "DN7":

                        //System.out.println("DN48DSKa1");

                        check = 0;
                        while (check < DN7DSKaa.Length && DN7DSKaa[check] != null)
                        {
                            int check2 = check + 1;
                            if (DN7DSKaa[check] == request)
                            {
                                raccesstimeaa += 12.135;
                                dlocaa = 1;
                                dn1dskaa++;
                                check = DN7DSKaa.Length + 1;
                            }
                            check++;

                        }

                        break;


                    case "DN8":

                        //System.out.println("DN49DSKa1");

                        check = 0;
                        while (check < DN8DSKaa.Length && DN8DSKaa[check] != null)
                        {
                            int check2 = check + 1;
                            if (DN8DSKaa[check] == request)
                            {
                                raccesstimeaa += 12.135;
                                dlocaa = 1;
                                dn1dskaa++;
                                check = DN8DSKaa.Length + 1;
                            }
                            check++;

                        }

                        break;


                    case "DN9":

                        //System.out.println("DN50DSKa1");

                        check = 0;
                        while (check < DN9DSKaa.Length && DN9DSKaa[check] != null)
                        {
                            int check2 = check + 1;
                            if (DN9DSKaa[check] == request)
                            {
                                raccesstimeaa += 12.135;
                                dlocaa = 1;
                                dn1dskaa++;
                                check = DN9DSKaa.Length + 1;
                            }
                            check++;

                        }

                        break;


                    case "DN10":

                        //System.out.println("DN51DSKa1");

                        check = 0;
                        while (check < DN10DSKaa.Length && DN10DSKaa[check] != null)
                        {
                            int check2 = check + 1;
                            if (DN10DSKaa[check] == request)
                            {
                                raccesstimeaa += 12.135;
                                dlocaa = 1;
                                dn1dskaa++;
                                check = DN10DSKaa.Length + 1;
                            }
                            check++;

                        }

                        break;
                }

                if (dlocaa == 0)
                {

                    //System.out.println("DN52DSKa1");

                    //MessageBox.Show("Found in Disk");
                    found = 0;
                    //     agaccesstime = 0.125 + 0.125 + 12 + 0.0006 + 4.0012 + 0.0006; 
                    check = 0;
                    while (check < DN1DSKaa.Length && DN1DSKaa[check] != null && found == 0)
                    {

                        if (DN1DSKaa[check] == request)
                        {
                            raccesstimeaa += 12.135;
                            found = 1;
                            dn1dskaa++;
                            check = DN1DSKaa.Length + 1;
                        }
                        check++;
                    }


                    check = 0;
                    while (check < DN2DSKaa.Length && DN2DSKaa[check] != null && found == 0)
                    {
                        if (DN2DSKaa[check] == request)
                        {
                            raccesstimeaa += 12.135;
                            found = 2;
                            dn1dskaa++;
                            check = DN2DSKaa.Length + 1;
                        }
                        check++;

                        //System.out.println("DN53DSKa1");

                    }

                    check = 0;
                    while (check < DN3DSKaa.Length && DN3DSKaa[check] != null && found == 0)
                    {
                        if (DN3DSKaa[check] == request)
                        {
                            raccesstimeaa += 12.135;
                            found = 3;
                            dn1dskaa++;
                            check = DN3DSKaa.Length + 1;
                        }
                        check++;

                        //System.out.println("DN54DSKa1");

                    }

                    check = 0;
                    while (check < DN4DSKaa.Length && DN4DSKaa[check] != null && found == 0)
                    {
                        if (DN4DSKaa[check] == request)
                        {
                            raccesstimeaa += 12.135;
                            found = 4;
                            dn1dskaa++;
                            check = DN4DSKaa.Length + 1;
                        }
                        check++;

                        //System.out.println("DN55DSKa1");

                    }

                    check = 0;
                    while (check < DN5DSKaa.Length && DN5DSKaa[check] != null && found == 0)
                    {
                        if (DN5DSKaa[check] == request)
                        {
                            raccesstimeaa += 12.135;
                            found = 5;
                            dn1dskaa++;
                            check = DN5DSKaa.Length + 1;
                        }
                        check++;

                        //System.out.println("DN56DSKa1");

                    }

                    check = 0;
                    while (check < DN6DSKaa.Length && DN6DSKaa[check] != null && found == 0)
                    {
                        if (DN6DSKaa[check] == request)
                        {
                            raccesstimeaa += 12.135;
                            found = 6;
                            dn1dskaa++;
                            check = DN6DSKaa.Length + 1;
                        }
                        check++;

                        //System.out.println("DN57DSKa1");

                    }

                    check = 0;
                    while (check < DN7DSKaa.Length && DN7DSKaa[check] != null && found == 0)
                    {
                        if (DN7DSKaa[check] == request)
                        {
                            raccesstimeaa += 12.135;
                            found = 7;
                            dn1dskaa++;
                            check = DN7DSKaa.Length + 1;
                        }
                        check++;

                        //System.out.println("DN58DSKa1");

                    }

                    check = 0;
                    while (check < DN8DSKaa.Length && DN8DSKaa[check] != null && found == 0)
                    {
                        if (DN8DSKaa[check] == request)
                        {
                            raccesstimeaa += 12.135;
                            found = 8;
                            dn1dskaa++;
                            check = DN8DSKaa.Length + 1;
                        }
                        check++;

                        //System.out.println("DN59DSKa1");

                    }

                    check = 0;
                    while (check < DN9DSKaa.Length && DN9DSKaa[check] != null && found == 0)
                    {
                        if (DN9DSKaa[check] == request)
                        {
                            raccesstimeaa += 12.135;
                            found = 9;
                            dn1dskaa++;
                            check = DN9DSKaa.Length + 1;
                        }
                        check++;

                        //System.out.println("DN60DSKa1");

                    }

                    check = 0;
                    while (check < DN10DSKaa.Length && DN10DSKaa[check] != null && found == 0)
                    {
                        if (DN10DSKaa[check] == request)
                        {
                            raccesstimeaa += 12.135;
                            found = 10;
                            dn1dskaa++;
                            check = DN10DSKaa.Length + 1;
                        }
                        check++;
                        //System.out.println("DN61DSKa1");

                    }

                    if (appno <= 5 && found > 5 || appno > 5 && found <= 5)
                    {
                        //System.out.println("DN62DSKa1");

                        raccesstimeaa += 6;
                        //apaccesstime = 2 + 0.125 + 0.125 + 12 + 0.005 + 4.00 + 0.005 + 0.005;

                        //different switch add switch delay also
                    }
                    else if (found != 0)
                    {
                        //System.out.println("DN63DSKa1");

                        raccesstimeaa += 4;

                        //apaccesstime = 0.125 + 0.125 + 12 + 0.005 + 4.00 + 0.005 + 0.005;
                    }
                    else
                    {
                        //System.out.println("DN64DSKa1");

                        raccesstimeaa +=12.130;
                        //   MessageBox.Show("File not found");
                    }


                    //System.out.println(raccesstimeaa);
                }



                dloc = 0;
                found = 0;
                loc = 0;
                switch (cliname)
                {
                    case "DN1":
                        //System.out.println("DN65DSKa1");

                        check = 0;
                        while (check < DN1a.Length && DN1a[check] != null)
                        {
                            int check2 = check + 1;
                            String[] filerequest = DN1a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                loc = 1;
                                raccesstimea += 0.01;
                                //                        agaccesstime = 0.125 + 0.006
                                // agaccesstime = 0.125;
                                //apaccesstime = 0.125 + 0.005;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                // aglochit++;
                                dn1loca++;
                                check = DN1a.Length + 1;
                            }
                            check++;

                        }


                     /*   check = 0;

                        while (check < global1a.Length && global1a[check] != null && loc == 0)
                        {
                            //System.out.println("DN66DSKa1");

                            int check2 = check + 1;
                            String[] filerequest = global1a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                goc = 1;
                                raccesstimea += 4.005;
                                //                                
                                aglocalcache[agloci] = filename;
                                //                              agloci++;
                                //                            aglocalcache[agloci] = blocknum;
                                //agloci++;
                                //                        agaccesstime = 0.125 + 4.0012 + 0.0006;
                                //agaccesstime = 0.125 + 4.01;
                                //apaccesstime = 0.125 + 0.125 + 4.00 + 0.005;
                                //aggochit++;
                                dngoc++;
                                //MessageBox.Show("Found in Global Cache" + check + "" + goci);
                                check = global1a.Length + 1;

                            }
                            check++;

                        }*/

                        check = 0;

                        while (check < DN1DSKa.Length && DN1DSKa[check] != null && loc == 0 && goc == 0)
                        {
                            //System.out.println("DN67DSKa1");

                            int check2 = check + 1;
                            if (DN1DSKa[check] == request)
                            {

                                raccesstimea += 12.135;
                                dloc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                if (count1a    == 500)
                                {
                                    count1a = -1;
                                }

                                if (count1a != -1)
                                {
                                    DN1a[count1a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count1a++;
                                  

                                }
                                else
                                {
                                    Array.Sort(DN1a);
                                    //DN1a[0] = request;
                                    // count1a++;
                                    DN1a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    existevictions++;
                                }


                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005 + 12;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                dn1dska++;
                                check = DN1DSKa.Length + 1;
                            }
                            check++;

                        }

                        break;
                    case "DN2":

                        check = 0;
                        while (check < DN2a.Length && DN2a[check] != null)
                        {
                            //System.out.println("DN68DSKa1");

                            int check2 = check + 1;
                            String[] filerequest = DN2a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstimea += 0.01;

                                loc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                //aglochit++;
                                dn2loca++;
                                check = DN2a.Length + 1;
                            }
                            check++;

                        }


                        check = 0;

                        //while (check < global1a.Length && global1a[check] != null && loc == 0)
                        //{
                        //    //System.out.println("DN69DSKa1");

                        //    int check2 = check + 1;
                        //    String[] filerequest = global1a[check].Split(':');
                        //    if (filerequest[1] == request)
                        //    {
                        //        raccesstimea += 4.005;

                        //        goc = 1;
                        //        //                                aglocalcache[agloci] = filename;
                        //        //                              agloci++;
                        //        //                            aglocalcache[agloci] = blocknum;
                        //        //agloci++;
                        //        //                        agaccesstime = 0.125 + 4.0012 + 0.0006;
                        //        agaccesstime = 0.125 + 4.01;
                        //        apaccesstime = 0.125 + 0.125 + 4.00 + 0.005;
                        //        //aggochit++;
                        //        dngoc++;
                        //        //MessageBox.Show("Found in Global Cache" + check + "" + goci);
                        //        check = global1a.Length + 1;

                        //    }
                        //    check++;

                        //}

                        check = 0;


                        while (check < DN2DSKa.Length && DN2DSKa[check] != null && loc == 0 && goc == 0)
                        {
                            //System.out.println("DN70DSKa1");

                            int check2 = check + 1;
                            if (DN2DSKa[check] == request)
                            {
                                raccesstimea += 12.135;

                                dloc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005 + 12;
                                if (count2a    == 500)
                                {
                                    count2a = -1;
                                }

                                if (count2a != -1)
                                {
                                    DN2a[count2a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count2a++;

                                }
                                else
                                {
                                    Array.Sort(DN2a);
                                    //DN2a[0] = request;
                                    // count2a++;
                                    DN2a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    existevictions++;
                                }


                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                // aglochit++;
                                dn2dska++;
                                check = DN2DSKa.Length + 1;
                            }
                            check++;

                        }

                        break;
                    case "DN3":
                        //System.out.println("DN71DSKa1");

                        check = 0;
                        while (check < DN3a.Length && DN3a[check] != null)
                        {
                            int check2 = check + 1;
                            String[] filerequest = DN3a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstimea += 0.01;

                                loc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                //aglochit++;
                                dn3loca++;
                                check = DN3a.Length + 1;
                            }
                            check++;

                        }


                        //check = 0;

                        //while (check < global1a.Length && global1a[check] != null && loc == 0)
                        //{
                        //    //System.out.println("DN72DSKa1");

                        //    int check2 = check + 1;
                        //    if (global1a[check] == request)
                        //    {
                        //        raccesstimea += 4.005;

                        //        goc = 1;
                        //        //                                aglocalcache[agloci] = filename;
                        //        //                              agloci++;
                        //        //                            aglocalcache[agloci] = blocknum;
                        //        //agloci++;
                        //        //                        agaccesstime = 0.125 + 4.0012 + 0.0006;
                        //        agaccesstime = 0.125 + 4.01;
                        //        apaccesstime = 0.125 + 0.125 + 4.00 + 0.005;
                        //        //aggochit++;
                        //        dngoc++;
                        //        //MessageBox.Show("Found in Global Cache" + check + "" + goci);
                        //        check = global1a.Length + 1;

                        //    }
                        //    check++;

                        //}


                        check = 0;



                        while (check < DN3DSKa.Length && DN3DSKa[check] != null && loc == 0 && goc == 0)
                        {
                            //System.out.println("DN73DSKa1");

                            int check2 = check + 1;
                            if (DN3DSKa[check] == request)
                            {
                                raccesstimea += 12.135;

                                if (count3a    == 500)
                                {
                                    count3a = -1;
                                }

                                if (count3a != -1)
                                {
                                    DN3a[count3a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count3a++;

                                }
                                else
                                {
                                    Array.Sort(DN3a);
                                    //DN3a[0] = request;
                                    // count3a++;
                                    DN3a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    existevictions++;
                                }


                                dloc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005 + 12;

                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                // aglochit++;
                                dn3dska++;
                                check = DN3DSKa.Length + 1;
                            }
                            check++;

                        }

                        break;
                    case "DN4":

                        check = 0;
                        while (check < DN4a.Length && DN4a[check] != null)
                        {
                            //System.out.println("DN74DSKa1");

                            int check2 = check + 1;
                            String[] filerequest = DN4a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstimea += 0.01;

                                loc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                // aglochit++;
                                dn4loca++;
                                check = DN4a.Length + 1;
                            }
                            check++;

                        }


                        check = 0;

                        //while (check < global1a.Length && global1a[check] != null && loc == 0)
                        //{
                        //    //System.out.println("DN75DSKa1");

                        //    int check2 = check + 1;
                        //    String[] filerequest = global1a[check].Split(':');
                        //    if (filerequest[1] == request)
                        //    {
                        //        raccesstimea += 4.005;

                        //        goc = 1;
                        //        //                                aglocalcache[agloci] = filename;
                        //        //                              agloci++;
                        //        //                            aglocalcache[agloci] = blocknum;
                        //        //agloci++;
                        //        //                        agaccesstime = 0.125 + 4.0012 + 0.0006;
                        //        agaccesstime = 0.125 + 4.01;
                        //        apaccesstime = 0.125 + 0.125 + 4.00 + 0.005;
                        //        //aggochit++;
                        //        dngoc++;
                        //        //MessageBox.Show("Found in Global Cache" + check + "" + goci);
                        //        check = global1a.Length + 1;

                        //    }
                        //    check++;

                        //}

                        check = 0;


                        while (check < DN4DSKa.Length && DN4DSKa[check] != null && loc == 0 && goc == 0)
                        {
                            //System.out.println("DN76DSKa1");

                            int check2 = check + 1;
                            if (DN4DSKa[check] == request)
                            {
                                raccesstimea += 12.135;

                                dloc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                if (count4a    == 500)
                                {
                                    count4a = -1;
                                }

                                if (count4a != -1)
                                {
                                    DN4a[count4a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count4a++;

                                }
                                else
                                {
                                    Array.Sort(DN4a);
                                    //DN4a[0] = request;
                                    // count4a++;
                                    DN4a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    existevictions++;
                                }


                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005 + 12;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                //aglochit++;
                                check = DN4DSKa.Length + 1;
                                dn4dska++;
                            }
                            check++;

                        }

                        break;
                    case "DN5":
                        //System.out.println("DN77DSKa1");

                        check = 0;
                        while (check < DN5a.Length && DN5a[check] != null)
                        {
                            int check2 = check + 1;
                            String[] filerequest = DN5a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstimea += 0.01;

                                loc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                //aglochit++;
                                dn5loca++;
                                check = DN5a.Length + 1;
                            }
                            check++;

                        }

                        //check = 0;

                        //while (check < global1a.Length && global1a[check] != null && loc == 0)
                        //{
                        //    //System.out.println("DN78DSKa1");

                        //    int check2 = check + 1;
                        //    String[] filerequest = global1a[check].Split(':');
                        //    if (filerequest[1] == request)
                        //    {
                        //        raccesstimea += 4.005;

                        //        goc = 1;
                        //        //                                aglocalcache[agloci] = filename;
                        //        //                              agloci++;
                        //        //                            aglocalcache[agloci] = blocknum;
                        //        //agloci++;
                        //        //                        agaccesstime = 0.125 + 4.0012 + 0.0006;
                        //        agaccesstime = 0.125 + 4.01;
                        //        apaccesstime = 0.125 + 0.125 + 4.00 + 0.005;
                        //        //aggochit++;
                        //        dngoc++;
                        //        //MessageBox.Show("Found in Global Cache" + check + "" + goci);
                        //        check = global1a.Length + 1;

                        //    }
                        //    check++;

                        //}


                        check = 0;

                        while (check < DN5DSKa.Length && DN5DSKa[check] != null && loc == 0 && goc == 0)
                        {
                            //System.out.println("DN79DSKa1");

                            int check2 = check + 1;
                            if (DN5DSKa[check] == request)
                            {
                                raccesstimea += 12.135;
                                if (count5a    == 500)
                                {
                                    count5a = -1;
                                }

                                if (count5a != -1)
                                {
                                    DN5a[count5a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count5a++;

                                }
                                else
                                {
                                    Array.Sort(DN5a);
                                    //DN5a[0] = request;
                                    // count5a++;
                                    DN5a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    existevictions++;
                                }


                                dloc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005 + 12;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                //agdskit++;
                                dn5dska++;
                                check = DN5DSKa.Length + 1;
                            }
                            check++;

                        }

                        break;
                    case "DN6":
                        //System.out.println("DN80DSKa1");

                        check = 0;
                        while (check < DN6a.Length && DN6a[check] != null)
                        {
                            //System.out.println("DN81DSKa1");

                            int check2 = check + 1;
                            String[] filerequest = DN6a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstimea += 0.01;

                                loc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                //  aglochit++;
                                check = DN6a.Length + 1;
                                dn6loca++;
                            }
                            check++;

                        }

                        //check = 0;

                        //while (check < global1a.Length && global1a[check] != null && loc == 0)
                        //{
                        //    //System.out.println("DN82DSKa1");

                        //    int check2 = check + 1;
                        //    String[] filerequest = global1a[check].Split(':');
                        //    if (filerequest[1] == request)
                        //    {
                        //        raccesstimea += 4.005;

                        //        goc = 1;
                        //        //                                aglocalcache[agloci] = filename;
                        //        //                              agloci++;
                        //        //                            aglocalcache[agloci] = blocknum;
                        //        //agloci++;
                        //        //                        agaccesstime = 0.125 + 4.0012 + 0.0006;
                        //        agaccesstime = 0.125 + 4.01;
                        //        apaccesstime = 0.125 + 0.125 + 4.00 + 0.005;
                        //        //aggochit++;
                        //        dngoc++;
                        //        //MessageBox.Show("Found in Global Cache" + check + "" + goci);
                        //        check = global1a.Length + 1;

                        //    }
                        //    check++;

                        //}


                        check = 0;


                        while (check < DN6DSKa.Length && DN6DSKa[check] != null && loc == 0 && goc == 0)
                        {

                            //System.out.println("DN83DSKa1");

                            int check2 = check + 1;
                            if (DN6DSKa[check] == request)
                            {
                                raccesstimea += 12.135;
                                if (count6a    == 500)
                                {
                                    count6a = -1;
                                }

                                if (count6a != -1)
                                {
                                    DN6a[count6a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count6a++;

                                }
                                else
                                {
                                    Array.Sort(DN6a);
                                    //DN6a[0] = request;
                                    // count6a++;
                                    DN6a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    existevictions++;
                                }


                                dloc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005 + 12;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                //aglochit++;
                                dn6dska++;
                                check = DN6DSKa.Length + 1;
                            }
                            check++;

                        }

                        break;
                    case "DN7":
                        check = 0;
                        while (check < DN7a.Length && DN7a[check] != null)
                        {
                            //System.out.println("DN84DSKa1");

                            int check2 = check + 1;
                            String[] filerequest = DN7a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstimea += 0.01;

                                loc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                //aglochit++;
                                dn7loca++;
                                check = DN7a.Length + 1;
                            }
                            check++;

                        }


                        //check = 0;

                        //while (check < global1a.Length && global1a[check] != null && loc == 0)
                        //{

                        //    //System.out.println("DN85DSKa1");

                        //    int check2 = check + 1;
                        //    String[] filerequest = global1a[check].Split(':');
                        //    if (filerequest[1] == request)
                        //    {
                        //        raccesstimea += 4.005;

                        //        goc = 1;
                        //        //                                aglocalcache[agloci] = filename;
                        //        //                              agloci++;
                        //        //                            aglocalcache[agloci] = blocknum;
                        //        //agloci++;
                        //        //                        agaccesstime = 0.125 + 4.0012 + 0.0006;
                        //        agaccesstime = 0.125 + 4.01;
                        //        apaccesstime = 0.125 + 0.125 + 4.00 + 0.005;
                        //        //aggochit++;
                        //        dngoc++;
                        //        //MessageBox.Show("Found in Global Cache" + check + "" + goci);
                        //        check = global1a.Length + 1;

                        //    }
                        //    check++;

                        //}



                        check = 0;

                        while (check < DN7DSKa.Length && DN7DSKa[check] != null && loc == 0 && goc == 0)
                        {

                            //System.out.println("DN86DSKa1");

                            int check2 = check + 1;
                            if (DN7DSKa[check] == request)
                            {
                                raccesstimea += 12.135;
                                if (count7a    == 500)
                                {
                                    count7a = -1;
                                }

                                if (count7a != -1)
                                {
                                    DN7a[count7a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count7a++;

                                }
                                else
                                {
                                    Array.Sort(DN7a);
                                    //DN7a[0] = request;
                                    // count7a++;
                                    DN7a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    existevictions++;
                                }


                                dloc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005 + 12;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                // aglochit++;
                                dn7dska++;
                                check = DN7DSKa.Length + 1;
                            }
                            check++;

                        }

                        break;
                    case "DN8":
                        check = 0;
                        while (check < DN8a.Length && DN8a[check] != null)
                        {

                            //System.out.println("DN88DSKa1");

                            int check2 = check + 1;
                            String[] filerequest = DN8a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstimea += 0.01;

                                loc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                // aglochit++;
                                dn8loca++;
                                check = DN8a.Length + 1;
                            }
                            check++;

                        }


                        //check = 0;

                        //while (check < global1a.Length && global1a[check] != null && loc == 0)
                        //{

                        //    //System.out.println("DN89DSKa1");

                        //    int check2 = check + 1;
                        //    String[] filerequest = global1a[check].Split(':');
                        //    if (filerequest[1] == request)
                        //    {
                        //        raccesstimea += 4.005;

                        //        goc = 1;
                        //        //                                aglocalcache[agloci] = filename;
                        //        //                              agloci++;
                        //        //                            aglocalcache[agloci] = blocknum;
                        //        //agloci++;
                        //        //                        agaccesstime = 0.125 + 4.0012 + 0.0006;
                        //        agaccesstime = 0.125 + 4.01;
                        //        apaccesstime = 0.125 + 0.125 + 4.00 + 0.005;
                        //        //aggochit++;
                        //        dngoc++;
                        //        //MessageBox.Show("Found in Global Cache" + check + "" + goci);
                        //        check = global1a.Length + 1;

                        //    }
                        //    check++;

                        //}

                        check = 0;

                        while (check < DN8DSKa.Length && DN8DSKa[check] != null && loc == 0 && goc == 0)
                        {

                            //System.out.println("DN90DSKa1");

                            int check2 = check + 1;
                            if (DN8DSKa[check] == request)
                            {
                                raccesstimea += 12.135;
                                if (count8a    == 500)
                                {
                                    count8a = -1;
                                }

                                if (count8a != -1)
                                {
                                    DN8a[count8a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count8a++;

                                }
                                else
                                {
                                    Array.Sort(DN8a);
                                    //DN8a[0] = request;
                                    // count8a++;
                                    DN8a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    existevictions++;
                                }


                                dloc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005 + 12;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                //aglochit++;
                                dn8dska++;
                                check = DN8DSKa.Length + 1;
                            }
                            check++;

                        }

                        break;
                    case "DN9":
                        check = 0;
                        while (check < DN9a.Length && DN9a[check] != null)
                        {

                            //System.out.println("DN91DSKa1");

                            int check2 = check + 1;
                            String[] filerequest = DN9a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstimea += 0.01;

                                loc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                // aglochit++;
                                dn9loca++;
                                check = DN9a.Length + 1;
                            }
                            check++;

                        }
                        check = 0;

                        //check = 0;

                        //while (check < global1a.Length && global1a[check] != null && loc == 0)
                        //{

                        //    //System.out.println("DN92DSKa1");

                        //    int check2 = check + 1;
                        //    String[] filerequest = global1a[check].Split(':');
                        //    if (filerequest[1] == request)
                        //    {
                        //        raccesstimea += 4.005;

                        //        goc = 1;
                        //        //                                aglocalcache[agloci] = filename;
                        //        //                              agloci++;
                        //        //                            aglocalcache[agloci] = blocknum;
                        //        //agloci++;
                        //        //                        agaccesstime = 0.125 + 4.0012 + 0.0006;
                        //        agaccesstime = 0.125 + 4.01;
                        //        apaccesstime = 0.125 + 0.125 + 4.00 + 0.005;
                        //        //aggochit++;
                        //        dngoc++;
                        //        //MessageBox.Show("Found in Global Cache" + check + "" + goci);
                        //        check = global1a.Length + 1;

                        //    }
                        //    check++;

                        //}


                        while (check < DN9DSKa.Length && DN9DSKa[check] != null && loc == 0 && goc == 0)
                        {
                            //System.out.println("DN93DSKa1");

                            int check2 = check + 1;
                            if (DN9DSKa[check] == request)
                            {
                                raccesstimea += 12.135;
                                if (count9a    == 500)
                                {
                                    count9a = -1;
                                }

                                if (count9a != -1)
                                {
                                    DN9a[count9a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count9a++;

                                }
                                else
                                {
                                    Array.Sort(DN9a);
                                    //DN9a[0] = request;
                                    // count9a++;
                                    DN9a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    existevictions++;
                                }


                                dloc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005 + 12;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                //  aglochit++;
                                dn9dska++;
                                check = DN9DSKa.Length + 1;
                            }
                            check++;

                        }


                        break;
                    case "DN10":
                        //System.out.println("DN94DSKa1");

                        check = 0;
                        while (check < DN10a.Length && DN10a[check] != null)
                        {
                            int check2 = check + 1;
                            String[] filerequest = DN10a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstimea += 0.01;

                                loc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                // aglochit++;
                                dn10loca++;
                                check = DN10a.Length + 1;
                            }
                            check++;

                        }

                        //check = 0;

                        //while (check < global1a.Length && global1a[check] != null && loc == 0)
                        //{
                        //    //System.out.println("DN9DSKa1");

                        //    int check2 = check + 1;
                        //    String[] filerequest = global1a[check].Split(':');
                        //    if (filerequest[1] == request)
                        //    {
                        //        raccesstimea += 4.005;

                        //        goc = 1;
                        //        //                                aglocalcache[agloci] = filename;
                        //        //                              agloci++;
                        //        //                            aglocalcache[agloci] = blocknum;
                        //        //agloci++;
                        //        //                        agaccesstime = 0.125 + 4.0012 + 0.0006;
                        //        agaccesstime = 0.125 + 4.01;
                        //        apaccesstime = 0.125 + 0.125 + 4.00 + 0.005;
                        //        //aggochit++;
                        //        dngoc++;
                        //        //MessageBox.Show("Found in Global Cache" + check + "" + goci);
                        //        check = global1a.Length + 1;

                        //    }
                        //    check++;

                        //}


                        check = 0;
                        while (check < DN10DSKa.Length && DN10DSKa[check] != null && loc == 0 && goc == 0)
                        {
                            //System.out.println("DN96DSKa1");

                            int check2 = check + 1;
                            if (DN10DSKa[check] == request)
                            {
                                raccesstimea += 12.135;

                                dloc = 1;
                                if (count10a    == 500)
                                {
                                    count10a = -1;
                                }

                                if (count10a != -1)
                                {
                                    DN10a[count10a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count10a++;

                                }
                                else
                                {
                                    Array.Sort(DN10a);
                                    //DN10a[0] = request;
                                    // count10a++;
                                    DN10a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    existevictions++;
                                }


                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005 + 12;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                // aglochit++;
                                dn10dsk++;
                                check = DN10DSKa.Length + 1;
                            }
                            check++;

                        }

                        break;
                }



                if (loc == 0 && goc == 0 && dloc == 0)
                {
                    //System.out.println("DN97DSKa1");

                    //MessageBox.Show("Found in Disk");
                    found = 0;
                    //     agaccesstime = 0.125 + 0.125 + 12 + 0.0006 + 4.0012 + 0.0006; 

                    if (appno <= 5)
                    {
                        check = 0;
                        while (check < DN1a.Length && DN1a[check] != null && found == 0)
                        {
                            //System.out.println("DN98DSKa1");

                            String[] filerequest = DN1a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstimea += 0.010;
                                found = 1;
                                dn1a++;
                                check = DN1a.Length + 1;
                            }
                            check++;
                        }

                        check = 0;
                        while (check < DN1DSKa.Length && DN1DSKa[check] != null && found == 0)
                        {
                            //System.out.println("DN99DSKa1");

                            if (DN1DSKa[check] == request)
                            {
                                raccesstimea += 12.135;
                                found = 1;
                                if (count1a    == 500)
                                {
                                    count1a = -1;
                                }

                                if (count1a != -1)
                                {
                                    DN1a[count1a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count1a++;

                                }
                                else
                                {
                                    Array.Sort(DN1a);
                                    //DN1a[0] = request;
                                    // count1a++;
                                    DN1a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    existevictions++;
                                }


                                dn1dska++;
                                check = DN1DSKa.Length + 1;
                            }
                            check++;
                        }



                        check = 0;
                        while (check < DN2a.Length && DN2a[check] != null && found == 0)
                        {
                            //System.out.println("DN100DSKa1");

                            String[] filerequest = DN2a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 2;
                                raccesstimea += 0.010;
                                dn2a++;
                                check = DN2a.Length + 1;
                            }

                            check++;
                        }

                        check = 0;
                        while (check < DN2DSKa.Length && DN2DSKa[check] != null && found == 0)
                        {
                            //System.out.println("DN101DSKa1");

                            if (DN2DSKa[check] == request)
                            {
                                found = 2;
                                raccesstimea += 12.135;
                                if (count2a    == 500)
                                {
                                    count2a = -1;
                                }

                                if (count2a != -1)
                                {
                                    DN2a[count2a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count2a++;

                                }
                                else
                                {
                                    Array.Sort(DN2a);
                                    //DN2a[0] = request;
                                    // count2a++;
                                    DN2a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    existevictions++;
                                }


                                dn2dska++;
                                check = DN2DSKa.Length + 1;
                            }

                            check++;
                        }






                        check = 0;
                        while (check < DN3a.Length && DN3a[check] != null && found == 0)
                        {
                            //System.out.println("DN102DSKa1");

                            String[] filerequest = DN3a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstimea += 0.010;
                                found = 3;

                                dn3a++;
                                check = DN3a.Length + 1;
                            }

                            check++;
                        }

                        check = 0;
                        while (check < DN3DSKa.Length && DN3DSKa[check] != null && found == 0)
                        {
                            //System.out.println("DN103DSKa1");

                            if (DN3DSKa[check] == request)
                            {
                                found = 3;
                                raccesstimea += 12.135;
                                if (count3a    == 500)
                                {
                                    count3a = -1;
                                }

                                if (count3a != -1)
                                {
                                    DN3a[count3a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count3a++;

                                }
                                else
                                {
                                    Array.Sort(DN3a);
                                    //DN3a[0] = request;
                                    // count3a++;
                                    DN3a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    existevictions++;
                                }


                                dn3dska++;
                                check = DN3DSKa.Length + 1;
                            }

                            check++;
                        }




                        check = 0;
                        while (check < DN4a.Length && DN4a[check] != null && found == 0)
                        {
                            //System.out.println("DN104DSKa1");

                            String[] filerequest = DN4a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 4;
                                raccesstimea += 0.010;
                                dn4a++;
                                check = DN4a.Length + 1;
                            }

                            check++;
                        }

                        check = 0;
                        while (check < DN4DSKa.Length && DN4DSKa[check] != null && found == 0)
                        {
                            //System.out.println("DN105DSKa1");

                            if (DN4DSKa[check] == request)
                            {
                                found = 4;
                                raccesstimea += 12.135;
                                if (count4a    == 500)
                                {
                                    count4a = -1;
                                }

                                if (count4a != -1)
                                {
                                    DN4a[count4a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count4a++;

                                }
                                else
                                {
                                    Array.Sort(DN4a);
                                    //DN4a[0] = request;
                                    // count4a++;
                                    DN4a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    existevictions++;
                                }


                                dn4dska++;
                                check = DN4DSKa.Length + 1;
                            }

                            check++;
                        }

                        check = 0;
                        while (check < DN5a.Length && DN5a[check] != null && found == 0)
                        {
                            //System.out.println("DN106DSKa1");

                            String[] filerequest = DN5a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 5;
                                raccesstimea += 0.010;
                                dn5a++;
                                check = DN5a.Length + 1;
                            }

                            check++;
                        }

                        check = 0;
                        while (check < DN5DSKa.Length && DN5DSKa[check] != null && found == 0)
                        {
                            //System.out.println("DN107DSKa1");

                            if (DN5DSKa[check] == request)
                            {
                                found = 5;
                                raccesstimea += 12.135;
                                dn5dska++;
                                if (count5a    == 500)
                                {
                                    count5a = -1;
                                }

                                if (count5a != -1)
                                {
                                    DN5a[count5a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count5a++;

                                }
                                else
                                {
                                    Array.Sort(DN5a);
                                    //DN5a[0] = request;
                                    // count5a++;
                                    DN5a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    existevictions++;
                                }


                                check = DN5DSKa.Length + 1;
                            }

                            check++;
                        }





                        check = 0;
                        while (check < DN6a.Length && DN6a[check] != null && found == 0)
                        {
                            //System.out.println("DN108DSKa1");

                            String[] filerequest = DN6a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 6;
                                raccesstimea += 0.010;
                                dn6a++;
                                check = DN6a.Length + 1;
                            }

                            check++;
                        }

                        check = 0;
                        while (check < DN6DSKa.Length && DN6DSKa[check] != null && found == 0)
                        {
                            //System.out.println("DN109DSKa1");

                            if (DN6DSKa[check] == request)
                            {
                                found = 6;
                                raccesstimea += 12.135;
                                if (count6a    == 500)
                                {
                                    count6a = -1;
                                }

                                if (count6a != -1)
                                {
                                    DN6a[count6a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count6a++;

                                }
                                else
                                {
                                    Array.Sort(DN6a);
                                    //DN6a[0] = request;
                                    // count6a++;
                                    DN6a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    existevictions++;
                                }


                                dn6dska++;
                                check = DN6DSKa.Length + 1;
                            }

                            check++;
                        }






                        check = 0;
                        while (check < DN7a.Length && DN7a[check] != null && found == 0)
                        {
                            //System.out.println("DN110DSKa1");

                            String[] filerequest = DN7a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 7;
                                raccesstimea += 0.010;
                                dn7a++;
                                check = DN7a.Length + 1;
                            }

                            check++;
                        }

                        check = 0;
                        while (check < DN7DSKa.Length && DN7DSKa[check] != null && found == 0)
                        {
                            //System.out.println("DN111DSKa1");

                            if (DN7DSKa[check] == request)
                            {
                                found = 7;
                                raccesstimea += 12.135;
                                if (count7a    == 500)
                                {
                                    count7a = -1;
                                }

                                if (count7a != -1)
                                {
                                    DN7a[count7a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count7a++;

                                }
                                else
                                {
                                    Array.Sort(DN7a);
                                    //DN7a[0] = request;
                                    // count7a++;
                                    DN7a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    existevictions++;
                                }


                                dn7dska++;
                                check = DN7DSKa.Length + 1;
                            }

                            check++;
                        }




                        check = 0;
                        while (check < DN8a.Length && DN8a[check] != null && found == 0)
                        {
                            //System.out.println("DN112DSKa1");

                            String[] filerequest = DN8a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 8;
                                raccesstimea += 0.010;
                                dn8a++;
                                check = DN8a.Length + 1;
                            }

                            check++;
                        }

                        check = 0;
                        while (check < DN8DSKa.Length && DN8DSKa[check] != null && found == 0)
                        {
                            //System.out.println("DN113DSKa1");

                            if (DN8DSKa[check] == request)
                            {
                                found = 8;
                                raccesstimea += 12.135;
                                dn8dska++;
                                if (count8a    == 500)
                                {
                                    count8a = -1;
                                }

                                if (count8a != -1)
                                {
                                    DN8a[count8a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count8a++;

                                }
                                else
                                {
                                    Array.Sort(DN8a);
                                    //DN8a[0] = request;
                                    // count8a++;
                                    DN8a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    existevictions++;
                                }


                                check = DN8DSKa.Length + 1;
                            }

                            check++;
                        }




                        check = 0;
                        while (check < DN9a.Length && DN9a[check] != null && found == 0)
                        {
                            //System.out.println("DN114DSKa1");

                            String[] filerequest = DN9a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 9;
                                raccesstimea += 0.010;
                                dn9a++;
                                check = DN9a.Length + 1;
                            }

                            check++;
                        }

                        check = 0;
                        while (check < DN9DSKa.Length && DN9DSKa[check] != null && found == 0)
                        {
                            //System.out.println("DN115DSKa1");

                            if (DN9DSKa[check] == request)
                            {
                                found = 9;
                                raccesstimea += 12.135;
                                dn9dska++;
                                if (count9a    == 500)
                                {
                                    count9a = -1;
                                }

                                if (count9a != -1)
                                {
                                    DN9a[count9a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count9a++;

                                }
                                else
                                {
                                    Array.Sort(DN9a);
                                    //DN9a[0] = request;
                                    // count9a++;
                                    DN9a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    existevictions++;
                                }


                                check = DN9DSKa.Length + 1;
                            }

                            check++;
                        }



                        check = 0;
                        while (check < DN10a.Length && DN10a[check] != null && found == 0)
                        {
                            //System.out.println("DN116DSKa1");

                            String[] filerequest = DN10a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 10;
                                raccesstimea += 0.010;
                                dn10a++;
                                check = DN10a.Length + 1;
                            }
                            check++;
                        }


                        check = 0;
                        while (check < DN10DSKa.Length && DN10DSKa[check] != null && found == 0)
                        {
                            //System.out.println("DN117DSKa1");

                            if (DN10DSKa[check] == request)
                            {
                                found = 10;
                                raccesstimea += 12.135;
                                if (count10a    == 500)
                                {
                                    count10a = -1;
                                }

                                if (count10a != -1)
                                {
                                    DN10a[count10a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count10a++;

                                }
                                else
                                {
                                    Array.Sort(DN10a);
                                    //DN10a[0] = request;
                                    // count10a++;
                                    DN10a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    existevictions++;
                                }


                                dn10dska++;
                                check = DN10DSKa.Length + 1;
                            }
                            check++;
                        }
                    }
                    else
                    {

                        check = 0;
                        while (check < DN6a.Length && DN6a[check] != null && found == 0)
                        {
                            //System.out.println("DN108DSKa1");

                            String[] filerequest = DN6a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 6;
                                raccesstimea += 0.010;
                                dn6a++;
                                check = DN6a.Length + 1;
                            }

                            check++;
                        }

                        check = 0;
                        while (check < DN6DSKa.Length && DN6DSKa[check] != null && found == 0)
                        {
                            //System.out.println("DN109DSKa1");

                            if (DN6DSKa[check] == request)
                            {
                                found = 6;
                                raccesstimea += 12.135;
                                if (count6a    == 500)
                                {
                                    count6a = -1;
                                }

                                if (count6a != -1)
                                {
                                    DN6a[count6a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count6a++;

                                }
                                else
                                {
                                    Array.Sort(DN6a);
                                    //DN6a[0] = request;
                                    // count6a++;
                                    DN6a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    existevictions++;
                                }


                                dn6dska++;
                                check = DN6DSKa.Length + 1;
                            }

                            check++;
                        }






                        check = 0;
                        while (check < DN7a.Length && DN7a[check] != null && found == 0)
                        {
                            //System.out.println("DN110DSKa1");

                            String[] filerequest = DN7a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 7;
                                raccesstimea += 0.010;
                                dn7a++;
                                check = DN7a.Length + 1;
                            }

                            check++;
                        }

                        check = 0;
                        while (check < DN7DSKa.Length && DN7DSKa[check] != null && found == 0)
                        {
                            //System.out.println("DN111DSKa1");

                            if (DN7DSKa[check] == request)
                            {
                                found = 7;
                                raccesstimea += 12.135;
                                if (count7a    == 500)
                                {
                                    count7a = -1;
                                }

                                if (count7a != -1)
                                {
                                    DN7a[count7a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count7a++;

                                }
                                else
                                {
                                    Array.Sort(DN7a);
                                    //DN7a[0] = request;
                                    // count7a++;
                                    DN7a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    existevictions++;
                                }


                                dn7dska++;
                                check = DN7DSKa.Length + 1;
                            }

                            check++;
                        }




                        check = 0;
                        while (check < DN8a.Length && DN8a[check] != null && found == 0)
                        {
                            //System.out.println("DN112DSKa1");

                            String[] filerequest = DN8a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 8;
                                raccesstimea += 0.010;
                                dn8a++;
                                check = DN8a.Length + 1;
                            }

                            check++;
                        }

                        check = 0;
                        while (check < DN8DSKa.Length && DN8DSKa[check] != null && found == 0)
                        {
                            //System.out.println("DN113DSKa1");

                            if (DN8DSKa[check] == request)
                            {
                                found = 8;
                                raccesstimea += 12.135;
                                if (count8a    == 500)
                                {
                                    count8a = -1;
                                }

                                if (count8a != -1)
                                {
                                    DN8a[count8a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count8a++;

                                }
                                else
                                {
                                    Array.Sort(DN8a);
                                    //DN8a[0] = request;
                                    // count8a++;
                                    DN8a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    existevictions++;
                                }


                                dn8dska++;
                                check = DN8DSKa.Length + 1;
                            }

                            check++;
                        }




                        check = 0;
                        while (check < DN9a.Length && DN9a[check] != null && found == 0)
                        {
                            //System.out.println("DN114DSKa1");

                            String[] filerequest = DN9a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 9;
                                raccesstimea += 0.010;
                                dn9a++;
                                check = DN9a.Length + 1;
                            }

                            check++;
                        }

                        check = 0;
                        while (check < DN9DSKa.Length && DN9DSKa[check] != null && found == 0)
                        {
                            //System.out.println("DN115DSKa1");

                            if (DN9DSKa[check] == request)
                            {
                                found = 9;
                                raccesstimea += 12.135;
                                if (count9a    == 500)
                                {
                                    count9a = -1;
                                }

                                if (count9a != -1)
                                {
                                    DN9a[count9a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count9a++;

                                }
                                else
                                {
                                    Array.Sort(DN9a);
                                    //DN9a[0] = request;
                                    // count9a++;
                                    DN9a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    existevictions++;
                                }


                                dn9dska++;
                                check = DN9DSKa.Length + 1;
                            }

                            check++;
                        }



                        check = 0;
                        while (check < DN10a.Length && DN10a[check] != null && found == 0)
                        {
                            //System.out.println("DN116DSKa1");

                            String[] filerequest = DN10a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 10;
                                raccesstimea += 0.010;
                                dn10a++;
                                check = DN10a.Length + 1;
                            }
                            check++;
                        }


                        check = 0;
                        while (check < DN10DSKa.Length && DN10DSKa[check] != null && found == 0)
                        {
                            //System.out.println("DN117DSKa1");

                            if (DN10DSKa[check] == request)
                            {
                                found = 10;
                                raccesstimea += 12.135;
                                if (count10a    == 500)
                                {
                                    count10a = -1;
                                }

                                if (count10a != -1)
                                {
                                    DN10a[count10a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count10a++;

                                }
                                else
                                {
                                    Array.Sort(DN10a);
                                    //DN10a[0] = request;
                                    // count10a++;
                                    DN10a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    existevictions++;
                                }


                                dn10dska++;
                                check = DN10DSKa.Length + 1;
                            }
                            check++;
                        }
                        check = 0;
                        while (check < DN1a.Length && DN1a[check] != null && found == 0)
                        {
                            //System.out.println("DN98DSKa1");

                            String[] filerequest = DN1a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstimea += 0.010;
                                found = 1;
                                dn1a++;
                                check = DN1a.Length + 1;
                            }
                            check++;
                        }

                        check = 0;
                        while (check < DN1DSKa.Length && DN1DSKa[check] != null && found == 0)
                        {
                            //System.out.println("DN99DSKa1");

                            if (DN1DSKa[check] == request)
                            {
                                raccesstimea += 12.135;
                                found = 1;
                                if (count1a    == 500)
                                {
                                    count1a = -1;
                                }

                                if (count1a != -1)
                                {
                                    DN1a[count1a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count1a++;

                                }
                                else
                                {
                                    Array.Sort(DN1a);
                                    //DN1a[0] = request;
                                    // count1a++;
                                    DN1a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    existevictions++;
                                }


                                dn1dska++;
                                check = DN1DSKa.Length + 1;
                            }
                            check++;
                        }



                        check = 0;
                        while (check < DN2a.Length && DN2a[check] != null && found == 0)
                        {
                            //System.out.println("DN100DSKa1");

                            String[] filerequest = DN2a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 2;
                                raccesstimea += 0.010;
                                dn2a++;
                                check = DN2a.Length + 1;
                            }

                            check++;
                        }

                        check = 0;
                        while (check < DN2DSKa.Length && DN2DSKa[check] != null && found == 0)
                        {
                            //System.out.println("DN101DSKa1");

                            if (DN2DSKa[check] == request)
                            {
                                found = 2;
                                raccesstimea += 12.135;
                                if (count2a    == 500)
                                {
                                    count2a = -1;
                                }

                                if (count2a != -1)
                                {
                                    DN2a[count2a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count2a++;

                                }
                                else
                                {
                                    Array.Sort(DN2a);
                                    //DN2a[0] = request;
                                    // count2a++;
                                    DN2a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    existevictions++;
                                }


                                dn2dska++;
                                check = DN2DSKa.Length + 1;
                            }

                            check++;
                        }






                        check = 0;
                        while (check < DN3a.Length && DN3a[check] != null && found == 0)
                        {
                            //System.out.println("DN102DSKa1");

                            String[] filerequest = DN3a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstimea += 0.010;
                                found = 3;

                                dn3a++;
                                check = DN3a.Length + 1;
                            }

                            check++;
                        }

                        check = 0;
                        while (check < DN3DSKa.Length && DN3DSKa[check] != null && found == 0)
                        {
                            //System.out.println("DN103DSKa1");

                            if (DN3DSKa[check] == request)
                            {
                                found = 3;
                                raccesstimea += 12.135;
                                if (count3a    == 500)
                                {
                                    count3a = -1;
                                }

                                if (count3a != -1)
                                {
                                    DN3a[count3a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count3a++;

                                }
                                else
                                {
                                    Array.Sort(DN3a);
                                    //DN3a[0] = request;
                                    // count3a++;
                                    DN3a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    existevictions++;
                                }


                                dn3dska++;
                                check = DN3DSKa.Length + 1;
                            }

                            check++;
                        }




                        check = 0;
                        while (check < DN4a.Length && DN4a[check] != null && found == 0)
                        {
                            //System.out.println("DN104DSKa1");

                            String[] filerequest = DN4a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 4;
                                raccesstimea += 0.010;
                                dn4a++;
                                check = DN4a.Length + 1;
                            }

                            check++;
                        }

                        check = 0;
                        while (check < DN4DSKa.Length && DN4DSKa[check] != null && found == 0)
                        {
                            //System.out.println("DN105DSKa1");

                            if (DN4DSKa[check] == request)
                            {
                                found = 4;
                                raccesstimea += 12.135;
                                if (count4a    == 500)
                                {
                                    count4a = -1;
                                }

                                if (count4a != -1)
                                {
                                    DN4a[count4a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count4a++;

                                }
                                else
                                {
                                    Array.Sort(DN4a);
                                    //DN4a[0] = request;
                                    // count4a++;
                                    DN4a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    existevictions++;
                                }


                                dn4dska++;
                                check = DN4DSKa.Length + 1;
                            }

                            check++;
                        }

                        check = 0;
                        while (check < DN5a.Length && DN5a[check] != null && found == 0)
                        {
                            //System.out.println("DN106DSKa1");

                            String[] filerequest = DN5a[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 5;
                                raccesstimea += 0.010;
                                dn5a++;
                                check = DN5a.Length + 1;
                            }

                            check++;
                        }

                        check = 0;
                        while (check < DN5DSKa.Length && DN5DSKa[check] != null && found == 0)
                        {
                            //System.out.println("DN107DSKa1");

                            if (DN5DSKa[check] == request)
                            {
                                found = 5;
                                raccesstimea += 12.135;
                                if (count5a    == 500)
                                {
                                    count5a = -1;
                                }

                                if (count5a != -1)
                                {
                                    DN5a[count5a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count5a++;

                                }
                                else
                                {
                                    Array.Sort(DN5a);
                                    //DN5a[0] = request;
                                    // count5a++;
                                    DN5a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    existevictions++;
                                }


                                dn5dska++;
                                check = DN5DSKa.Length + 1;
                            }

                            check++;
                        }





                    }

                    if (appno <= 5 && found > 5 || appno > 5 && found <= 5)
                    {
                        //System.out.println("DN118DSKa1");

                        raccesstimea += 6;
                        //apaccesstime = 2 + 0.125 + 0.125 + 12 + 0.005 + 4.00 + 0.005 + 0.005;

                        //different switch add switch delay also
                    }
                    else if (found != 0)
                    {
                        //System.out.println("DN119DSKa1");

                        raccesstimea += 4;

                        //apaccesstime = 0.125 + 0.125 + 12 + 0.005 + 4.00 + 0.005 + 0.005;
                    }
                    else
                    {
                        //System.out.println("DN120DSKa1");

                        raccesstimea += 12.135;
                        // MessageBox.Show("File not found");
                    }

                }






                loc = 0;
                goc = 0;
                dloc = 0;
                found = 0;

                // hadoop +sequential read
                switch (cliname)
                {
                    case "DN1":
                        check = 0;
                        while (check < DN1.Length && DN1[check] != null)
                        {
                            int check2 = check + 1;
                            String[] filerequest = DN1[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                loc = 1;
                                raccesstime += 0.010;
                                //                        agaccesstime = 0.125 + 0.006
                                //      agaccesstime = 0.125;
                                //    apaccesstime = 0.125 + 0.005;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                // aglochit++;

                                dn1loc++;
                                check = DN1.Length + 1;
                            }
                            check++;

                        }
                        check = 0;

                        while (check < global1.Length && global1[check] != null && loc == 0)
                        {
                            int check2 = check + 1;
                            String[] filerequest = global1[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                goc = 1;
                                raccesstime += 4.010;
                                //                                aglocalcache[agloci] = filename;
                                //                              agloci++;
                                //                            aglocalcache[agloci] = blocknum;
                                //agloci++;
                                //                        agaccesstime = 0.125 + 4.0012 + 0.0006;
                                agaccesstime = 0.125 + 4.01;
                                apaccesstime = 0.125 + 0.125 + 4.00 + 0.005;
                                //aggochit++;
                                dngoc++;
                                //MessageBox.Show("Found in Global Cache" + check + "" + goci);
                                if (count1    == 500)
                                {
                                    count1 = -1;
                                }

                                if (count1 != -1)
                                {
                                    DN1[count1] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count1++;

                                }
                                else
                                {
                                    Array.Sort(DN1);
                                    //DN1[0] = request1;
                                    // count1++;
                                    DN1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }
                                
                                check = global1.Length + 1;

                            }
                            check++;

                        }

                        check = 0;

                        while (check < DN1DSK.Length && DN1DSK[check] != null && loc == 0 && goc == 0)
                        {
                            int check2 = check + 1;
                            if (DN1DSK[check] == request)
                            {
                                raccesstime += 12.135;
                                dloc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005 + 12;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                dn1dsk++;
                                if (count1    == 500)
                                {
                                    count1 = -1;
                                }

                                if (count1 != -1)
                                {
                                    DN1[count1] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count1++;

                                }
                                else
                                {
                                    Array.Sort(DN1);
                                    //DN1[0] = request;
                                    // count1++;
                                    DN1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                if (count11 != -1)
                                {

                                    global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                    count11++;
                                }

                                else
                                {
                                    Array.Sort(global1);
                                    global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;

                                }


                                if (count11 ==2000)
                                {
                                    count11 = -1;
                                }

                                check = DN1DSK.Length + 1;
                            }
                            check++;

                        }

                        break;
                    case "DN2":

                        check = 0;
                        while (check < DN2.Length && DN2[check] != null)
                        {
                            int check2 = check + 1;
                            String[] filerequest = DN2[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstime += 0.010;
                                loc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                //aglochit++;
                                dn2loc++;
                                check = DN2.Length + 1;
                            }
                            check++;

                        }
                        check = 0;


                        while (check < global1.Length && global1[check] != null && loc == 0)
                        {
                            int check2 = check + 1;
                            String[] filerequest = global1[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstime += 4.010;
                                goc = 1;
                                //  aglocalcache[agloci] = filename;
                                //agloci++;
                                //aglocalcache[agloci] = blocknum;
                                //agloci++;
                                //                        agaccesstime = 0.125 + 4.0012 + 0.0006;
                                agaccesstime = 0.125 + 4.01;
                                apaccesstime = 0.125 + 0.125 + 4.00 + 0.005;
                                // aggochit++;
                                dngoc++;
                                //MessageBox.Show("Found in Global Cache" + check + "" + goci);

                                if (count2    == 500)
                                {
                                    count2 = -1;
                                }

                                if (count2 != -1)
                                {
                                    //DN2[count2] = request1;
                                    // count2++;
                                    DN2[count2] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count2++;
                                }
                                else
                                {
                                    Array.Sort(DN2);
                                    //DN2[0] = request1;
                                    // count2++;
                                    DN2[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }
                                check = global1.Length + 1;

                            }
                            check++;

                        }

                        check = 0;

                        while (check < DN2DSK.Length && DN2DSK[check] != null && loc == 0 && goc == 0)
                        {
                            int check2 = check + 1;
                            if (DN2DSK[check] == request)
                            {
                                raccesstime += 12.135;
                                dloc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005 + 12;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                // aglochit++;
                                dn2dsk++;

                                if (count2    == 500)
                                {
                                    count2 = -1;
                                }

                                if (count2 != -1)
                                {
                                    DN2[count2] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count2++;

                                }
                                else
                                {
                                    Array.Sort(DN2);
                                    //DN2[0] = request;
                                    // count2++;
                                    DN2[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                }


                                if (count11 != -1)
                                {

                                    global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                    count11++;
                                }

                                else
                                {
                                    Array.Sort(global1);
                                    global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;

                                }


                                if (count11 ==2000)
                                {
                                    count11 = -1;
                                }

                                check = DN2DSK.Length + 1;
                            }
                            check++;

                        }

                        break;
                    case "DN3":
                        check = 0;
                        while (check < DN3.Length && DN3[check] != null)
                        {
                            int check2 = check + 1;
                            String[] filerequest = DN3[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstime += 0.010;
                                loc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                //aglochit++;
                                dn3loc++;
                                check = DN3.Length + 1;
                            }
                            check++;

                        }
                        check = 0;

                        while (check < global1.Length && global1[check] != null && loc == 0)
                        {
                            int check2 = check + 1;
                            String[] filerequest = global1[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstime += 4.010;
                                goc = 1;
                                //aglocalcache[agloci] = filename;
                                //agloci++;
                                //aglocalcache[agloci] = blocknum;
                                //agloci++;
                                //                        agaccesstime = 0.125 + 4.0012 + 0.0006;
                                agaccesstime = 0.125 + 4.01;
                                apaccesstime = 0.125 + 0.125 + 4.00 + 0.005;
                                //aggochit++;
                                dngoc++;
                                //MessageBox.Show("Found in Global Cache" + check + "" + goci);

                                if (count3    == 500)
                                {
                                    count3 = -1;
                                }

                                if (count3 != -1)
                                {
                                    //DN3[count3] = request;
                                    // count3++;
                                    DN3[count3] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count3++;
                                }
                                else
                                {
                                    Array.Sort(DN3);
                                    //DN3[0] = request;
                                    // count3++;
                                    DN3[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }
                                check = global1.Length + 1;

                            }
                            check++;

                        }

                        check = 0;

                        while (check < DN3DSK.Length && DN3DSK[check] != null && loc == 0 && goc == 0)
                        {
                            int check2 = check + 1;
                            if (DN3DSK[check] == request)
                            {
                                dloc = 1;
                                raccesstime += 12.135;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005 + 12;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                // aglochit++;
                                dn3dsk++;

                                if (count3    == 500)
                                {
                                    count3 = -1;
                                }

                                if (count3 != -1)
                                {
                                    DN3[count3] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count3++;

                                }
                                else
                                {
                                    Array.Sort(DN3);
                                    //DN3[0] = request;
                                    // count3++;
                                    DN3[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                if (count11 != -1)
                                {

                                    global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                    count11++;
                                }

                                else
                                {
                                    Array.Sort(global1);
                                    global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;

                                }


                                if (count11 ==2000)
                                {
                                    count11 = -1;
                                }

                                check = DN3DSK.Length + 1;
                            }
                            check++;

                        }

                        break;
                    case "DN4":

                        check = 0;
                        while (check < DN4.Length && DN4[check] != null)
                        {
                            int check2 = check + 1;
                            String[] filerequest = DN4[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstime += 0.010;
                                loc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                // aglochit++;
                                dn4loc++;
                                check = DN4.Length + 1;
                            }
                            check++;

                        }
                        check = 0;

                        while (check < global1.Length && global1[check] != null && loc == 0)
                        {
                            int check2 = check + 1;
                            String[] filerequest = global1[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstime += 4.010;
                                goc = 1;
                                // aglocalcache[agloci] = filename;
                                //agloci++;
                                //aglocalcache[agloci] = blocknum;
                                //agloci++;
                                //                        agaccesstime = 0.125 + 4.0012 + 0.0006;
                                agaccesstime = 0.125 + 4.01;
                                apaccesstime = 0.125 + 0.125 + 4.00 + 0.005;
                                aggochit++;
                                //MessageBox.Show("Found in Global Cache" + check + "" + goci);
                                if (count4    == 500)
                                {
                                    count4 = -1;
                                }

                                if (count4 != -1)
                                {
                                    DN4[count4] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count4++;
                                }
                                else
                                {
                                    Array.Sort(DN4);
                                    //DN4[0] = request;
                                    // count4++;
                                    DN4[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }

                                check = global1.Length + 1;
                                dngoc++;
                            }
                            check++;

                        }

                        check = 0;

                        while (check < DN4DSK.Length && DN4DSK[check] != null && loc == 0 && goc == 0)
                        {
                            int check2 = check + 1;
                            if (DN4DSK[check] == request)
                            {
                                raccesstime += 12.135;
                                dloc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005 + 12;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                //aglochit++;
                                if (count4    == 500)
                                {
                                    count4 = -1;
                                }

                                if (count4 != -1)
                                {
                                    DN4[count4] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count4++;

                                }
                                else
                                {
                                    Array.Sort(DN4);
                                    //DN4[0] = request;
                                    // count4++;
                                    DN4[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                if (count11 != -1)
                                {

                                    global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                    count11++;
                                }

                                else
                                {
                                    Array.Sort(global1);
                                    global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;

                                }


                                if (count11 ==2000)
                                {
                                    count11 = -1;
                                }



                                check = DN4DSK.Length + 1;
                                dn4dsk++;
                            }
                            check++;

                        }

                        break;
                    case "DN5":
                        check = 0;
                        while (check < DN5.Length && DN5[check] != null)
                        {
                            int check2 = check + 1;
                            String[] filerequest = DN5[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstime += 0.010;
                                loc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                //aglochit++;
                                dn5loc++;
                                check = DN5.Length + 1;
                            }
                            check++;

                        }
                        check = 0;

                        while (check < global1.Length && global1[check] != null && loc == 0)
                        {
                            int check2 = check + 1;
                            String[] filerequest = global1[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstime += 4.010;
                                goc = 1;
                                //  aglocalcache[agloci] = filename;
                                //agloci++;
                                //aglocalcache[agloci] = blocknum;
                                //agloci++;
                                //                        agaccesstime = 0.125 + 4.0012 + 0.0006;
                                agaccesstime = 0.125 + 4.01;
                                apaccesstime = 0.125 + 0.125 + 4.00 + 0.005;
                                // aggochit++;
                                dngoc++;
                                if (count5    == 500)
                                {
                                    count5 = -1;
                                }

                                if (count5 != -1)
                                {
                                    DN5[count5] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count5++;
                                }

                                else
                                {
                                    Array.Sort(DN5);
                                    //DN5[0] = request;
                                    // count5++;
                                    DN5[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }

                                //MessageBox.Show("Found in Global Cache" + check + "" + goci);
                                check = global1.Length + 1;

                            }
                            check++;

                        }


                        check = 0;

                        while (check < DN5DSK.Length && DN5DSK[check] != null && loc == 0 && goc == 0)
                        {
                            int check2 = check + 1;
                            if (DN5DSK[check] == request)
                            {
                                raccesstime += 12.135;
                                dloc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005 + 12;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                //agdskit++;
                                dn5dsk++;
                                if (count5    == 500)
                                {
                                    count5 = -1;
                                }

                                if (count5 != -1)
                                {
                                    DN5[count5] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count5++;

                                }
                                else
                                {
                                    Array.Sort(DN5);
                                    //DN5[0] = request;
                                    // count5++;
                                    DN5[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                if (count11 != -1)
                                {

                                    global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                    count11++;
                                }

                                else
                                {
                                    Array.Sort(global1);
                                    global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;

                                }


                                if (count11 ==2000)
                                {
                                    count11 = -1;
                                }


                                check = DN5DSK.Length + 1;
                            }
                            check++;

                        }

                        break;
                    case "DN6":
                        check = 0;
                        while (check < DN6.Length && DN6[check] != null)
                        {
                            int check2 = check + 1;
                            String[] filerequest = DN6[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstime += 0.010;
                                loc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                //  aglochit++;
                                check = DN6.Length + 1;
                                dn6loc++;
                            }
                            check++;

                        }
                        check = 0;

                        while (check < global1.Length && global1[check] != null && loc == 0)
                        {
                            int check2 = check + 1;
                            String[] filerequest = global1[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstime += 6.010;
                                goc = 1;
                                //  aglocalcache[agloci] = filename;
                                //agloci++;
                                //aglocalcache[agloci] = blocknum;
                                //agloci++;
                                //                        agaccesstime = 0.125 + 4.0012 + 0.0006;
                                agaccesstime = 0.125 + 4.01;
                                apaccesstime = 0.125 + 0.125 + 4.00 + 0.005;
                                // aggochit++;
                                dngoc++;
                                if (count6    == 500)
                                {
                                    count6 = -1;
                                }

                                if (count6 != -1)
                                {

                                    //DN6[count6] = request;
                                    // count6++;
                                    DN6[count6] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count6++;
                                }
                                else
                                {
                                    Array.Sort(DN6);
                                    //DN6[0] = request;
                                    // count6++;
                                    DN6[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                //MessageBox.Show("Found in Global Cache" + check + "" + goci);
                                check = global1.Length + 1;

                            }
                            check++;

                        }

                        check = 0;

                        while (check < DN6DSK.Length && DN6DSK[check] != null && loc == 0 && goc == 0)
                        {
                            int check2 = check + 1;
                            if (DN6DSK[check] == request)
                            {
                                raccesstime += 12.135;
                                dloc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005 + 12;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                //aglochit++;
                                dn6dsk++;
                                if (count6    == 500)
                                {
                                    count6 = -1;
                                }

                                if (count6 != -1)
                                {
                                    DN6[count6] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count6++;

                                }
                                else
                                {
                                    Array.Sort(DN6);
                                    //DN6[0] = request;
                                    // count6++;
                                    DN6[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                if (count11 != -1)
                                {

                                    global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                    count11++;
                                }

                                else
                                {
                                    Array.Sort(global1);
                                    global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;

                                }


                                if (count11 ==2000)
                                {
                                    count11 = -1;
                                }


                                check = DN6DSK.Length + 1;
                            }
                            check++;

                        }

                        break;
                    case "DN7":
                        check = 0;
                        while (check < DN7.Length && DN7[check] != null)
                        {
                            int check2 = check + 1;
                            String[] filerequest = DN7[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstime += 0.010;
                                loc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                //aglochit++;
                                dn7loc++;
                                check = DN7.Length + 1;
                            }
                            check++;

                        }
                        check = 0;

                        while (check < global1.Length && global1[check] != null && loc == 0)
                        {
                            int check2 = check + 1;
                            String[] filerequest = global1[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstime += 6.010;
                                goc = 1;
                                //aglocalcache[agloci] = filename;
                                //agloci++;
                                //aglocalcache[agloci] = blocknum;
                                //agloci++;
                                ////                        agaccesstime = 0.125 + 4.0012 + 0.0006;
                                agaccesstime = 0.125 + 4.01;
                                apaccesstime = 0.125 + 0.125 + 4.00 + 0.005;
                                //     aggochit++;
                                dngoc++;
                                if (count7    == 500)
                                {
                                    count7 = -1;
                                }

                                if (count7 != -1)
                                {

                                    //DN7[count7] = request;
                                    // count7++;
                                    DN7[count7] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count7++;
                                }
                                else
                                {
                                    Array.Sort(DN7);
                                    //DN7[0] = request;
                                    // count7++;
                                    DN7[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                //MessageBox.Show("Found in Global Cache" + check + "" + goci);
                                check = global1.Length + 1;

                            }
                            check++;

                        }


                        check = 0;

                        while (check < DN7DSK.Length && DN7DSK[check] != null && loc == 0 && goc == 0)
                        {
                            int check2 = check + 1;
                            if (DN7DSK[check] == request)
                            {
                                raccesstime += 12.135;
                                dloc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005 + 12;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                // aglochit++;

                                dn7dsk++;
                                if (count7    == 500)
                                {
                                    count7 = -1;
                                }

                                if (count7 != -1)
                                {
                                    DN7[count7] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count7++;

                                }
                                else
                                {
                                    Array.Sort(DN7);
                                    //DN7[0] = request;
                                    // count7++;
                                    DN7[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                if (count11 != -1)
                                {

                                    global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                    count11++;
                                }

                                else
                                {
                                    Array.Sort(global1);
                                    global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;

                                }


                                if (count11 ==2000)
                                {
                                    count11 = -1;
                                }



                                check = DN7DSK.Length + 1;
                            }
                            check++;

                        }

                        break;
                    case "DN8":
                        check = 0;
                        while (check < DN8.Length && DN8[check] != null)
                        {
                            int check2 = check + 1;
                            String[] filerequest = DN8[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstime += 0.010;
                                loc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                // aglochit++;
                                dn8loc++;
                                check = DN8.Length + 1;
                            }
                            check++;

                        }
                        check = 0;

                        while (check < global1.Length && global1[check] != null && loc == 0)
                        {
                            int check2 = check + 1;
                            String[] filerequest = global1[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstime += 6.010;
                                goc = 1;
                                //aglocalcache[agloci] = filename;
                                //agloci++;
                                //aglocalcache[agloci] = blocknum;
                                //agloci++;
                                //                        agaccesstime = 0.125 + 4.0012 + 0.0006;
                                agaccesstime = 0.125 + 4.01;
                                apaccesstime = 0.125 + 0.125 + 4.00 + 0.005;
                                //  aggochit++;
                                dngoc++;
                                if (count8    == 500)
                                {
                                    count8 = -1;
                                }

                                if (count8 != -1)
                                {

                                    DN8[count8] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count8++;
                                }
                                else
                                {
                                    Array.Sort(DN8);
                                    //DN8[0] = request;
                                    // count8++;
                                    DN8[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }

                                //MessageBox.Show("Found in Global Cache" + check + "" + goci);
                                check = global1.Length + 1;

                            }
                            check++;

                        }

                        check = 0;

                        while (check < DN8DSK.Length && DN8DSK[check] != null && loc == 0 && goc == 0)
                        {
                            int check2 = check + 1;
                            if (DN8DSK[check] == request)
                            {
                                raccesstime += 12.135;
                                dloc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005 + 12;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                //aglochit++;
                                dn8dsk++;
                                if (count8    == 500)
                                {
                                    count8 = -1;
                                }

                                if (count8 != -1)
                                {
                                    DN8[count8] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count8++;

                                }
                                else
                                {
                                    Array.Sort(DN8);
                                    //DN8[0] = request;
                                    // count8++;
                                    DN8[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                if (count11 != -1)
                                {

                                    global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                    count11++;
                                }

                                else
                                {
                                    Array.Sort(global1);
                                    global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;

                                }


                                if (count11 ==2000)
                                {
                                    count11 = -1;
                                }


                                check = DN8DSK.Length + 1;
                            }
                            check++;

                        }

                        break;
                    case "DN9":
                        check = 0;
                        while (check < DN9.Length && DN9[check] != null)
                        {
                            int check2 = check + 1;
                            String[] filerequest = DN9[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstime += 0.010;
                                loc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                // aglochit++;
                                dn9loc++;
                                check = DN9.Length + 1;
                            }
                            check++;

                        }
                        check = 0;

                        while (check < global1.Length && global1[check] != null && loc == 0)
                        {
                            int check2 = check + 1;
                            String[] filerequest = global1[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstime +=6.010;
                                goc = 1;
                                //aglocalcache[agloci] = filename;
                                //agloci++;
                                //aglocalcache[agloci] = blocknum;
                                //agloci++;
                                ////                        agaccesstime = 0.125 + 4.0012 + 0.0006;
                                agaccesstime = 0.125 + 4.01;
                                apaccesstime = 0.125 + 0.125 + 4.00 + 0.005;
                                //aggochit++;
                                if (count9    == 500)
                                {
                                    count9 = -1;
                                }

                                if (count9 != -1)
                                {
                                    //DN9[count9] = request;
                                    // count9++;
                                    DN9[count9] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count9++;
                                }
                                else
                                {
                                    Array.Sort(DN9);
                                    //DN9[0] = request;
                                    // count9++;
                                    DN9[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                dngoc++;
                                //MessageBox.Show("Found in Global Cache" + check + "" + goci);
                                check = global1.Length + 1;

                            }
                            check++;

                        }

                        check = 0;

                        while (check < DN9DSK.Length && DN9DSK[check] != null && loc == 0 && goc == 0)
                        {
                            int check2 = check + 1;
                            if (DN9DSK[check] == request)
                            {
                                raccesstime += 12.135;
                                dloc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005 + 12;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                //  aglochit++;
                                dn9dsk++;
                                if (count9    == 500)
                                {
                                    count9 = -1;
                                }

                                if (count9 != -1)
                                {
                                    DN9[count9] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count9++;

                                }
                                else
                                {
                                    Array.Sort(DN9);
                                    //DN9[0] = request;
                                    // count9++;
                                    DN9[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                if (count11 != -1)
                                {

                                    global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                    count11++;
                                }

                                else
                                {
                                    Array.Sort(global1);
                                    global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;

                                }


                                if (count11 ==2000)
                                {
                                    count11 = -1;
                                }



                                check = DN9DSK.Length + 1;
                            }
                            check++;

                        }


                        break;
                    case "DN10":
                        check = 0;
                        while (check < DN10.Length && DN10[check] != null)
                        {
                            int check2 = check + 1;
                            String[] filerequest = DN10[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstime += 0.010;
                                loc = 1;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                // aglochit++;
                                dn10loc++;
                                check = DN10.Length + 1;
                            }
                            check++;

                        }
                        check = 0;

                        while (check < global1.Length && global1[check] != null && loc == 0)
                        {
                            int check2 = check + 1;
                            String[] filerequest = global1[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstime += 6.010;
                                goc = 1;
                                //aglocalcache[agloci] = filename;
                                //agloci++;
                                //aglocalcache[agloci] = blocknum;
                                //agloci++;
                                ////                        agaccesstime = 0.125 + 4.0012 + 0.0006;
                                agaccesstime = 0.125 + 4.01;
                                apaccesstime = 0.125 + 0.125 + 4.00 + 0.005;
                                //aggochit++;
                                dngoc++;
                                if (count10    == 500)
                                {
                                    count10 = -1;
                                }

                                if (count10 != -1)
                                {

                                    DN10[count10] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count10++;
                                }
                                else
                                {
                                    Array.Sort(DN10);
                                    //DN10[0] = request;
                                    // count10++;
                                    DN10[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }



                                //MessageBox.Show("Found in Global Cache" + check + "" + goci);
                                check = global1.Length + 1;

                            }
                            check++;

                        }

                        check = 0;

                        while (check < DN10DSK.Length && DN10DSK[check] != null && loc == 0 && goc == 0)
                        {

                            int check2 = check + 1;
                            if (DN10DSK[check] == request)
                            {
                                dloc = 1;
                                raccesstime += 12.135;
                                //                        agaccesstime = 0.125 + 0.006
                                agaccesstime = 0.125;
                                apaccesstime = 0.125 + 0.005 + 12;
                                //MessageBox.Show("Found in Local Cache" + check + "" + loci);
                                // aglochit++;
                                dn10dsk++;
                                if (count10    == 500)
                                {
                                    count10 = -1;
                                }

                                if (count10 != -1)
                                {
                                    DN10[count10] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count10++;

                                }
                                else
                                {
                                    Array.Sort(DN10);
                                    //DN10[0] = request;
                                    // count10++;
                                    DN10[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                if (count11 != -1)
                                {

                                    global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                    count11++;
                                }

                                else
                                {
                                    Array.Sort(global1);
                                    global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;

                                }


                                if (count11 ==2000)
                                {
                                    count11 = -1;
                                }




                                check = DN10DSK.Length + 1;
                            }
                            check++;

                        }

                        break;
                }

                if (loc == 0 && goc == 0 && dloc == 0)
                {
                    //MessageBox.Show("Found in Disk");
                    found = 0;
                    //     agaccesstime = 0.125 + 0.125 + 12 + 0.0006 + 4.0012 + 0.0006; 

                    if (appno <= 5)
                    {
                        check = 0;
                        while (check < DN1.Length && DN1[check] != null && found == 0)
                        {
                            String[] filerequest = DN1[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstime += 0.010;

                                //raccesstime += 4.010;
                                found = 1;
                                dn1++;
                                check = DN1.Length + 1;
                            }
                            check++;
                        }
                        check = 0;
                        while (check < DN1DSK.Length && DN1DSK[check] != null && found == 0)
                        {
                            if (DN1DSK[check] == request)
                            {
                                raccesstime += 12.135;
                                found = 1;
                                dn1dsk++;
                                if (count10    == 500)
                                {
                                    count10 = -1;
                                }

                                if (count1 != -1)
                                {
                                    DN1[count1] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count1++;

                                }
                                else
                                {
                                    Array.Sort(DN1);
                                    //DN1[0] = request;
                                    // count1++;
                                    DN1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                if (count11 != -1)
                                {

                                    global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                    count11++;
                                }

                                else
                                {
                                    Array.Sort(global1);
                                    global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;

                                }


                                if (count11 ==2000)
                                {
                                    count11 = -1;
                                }


                                check = DN1DSK.Length + 1;

                            }
                            check++;
                        }


                        check = 0;
                        while (check < DN2.Length && DN2[check] != null && found == 0)
                        {
                            String[] filerequest = DN2[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 2;
                                raccesstime += 0.010;

                                dn2++;
                                check = DN2.Length + 1;
                            }

                            check++;
                        }
                        check = 0;
                        while (check < DN2DSK.Length && DN2DSK[check] != null && found == 0)
                        {
                            if (DN2DSK[check] == request)
                            {
                                found = 2;
                                raccesstime += 12.135;

                                dn2dsk++;
                                if (count10    == 500)
                                {
                                    count10 = -1;
                                }

                                if (count2 != -1)
                                {
                                    DN2[count2] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count2++;

                                }
                                else
                                {
                                    Array.Sort(DN2);
                                    //DN2[0] = request;
                                    // count2++;
                                    DN2[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                if (count11 != -1)
                                {

                                    global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                    count11++;
                                }

                                else
                                {
                                    Array.Sort(global1);
                                    global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;

                                }


                                if (count11 ==2000)
                                {
                                    count11 = -1;
                                }


                                check = DN2DSK.Length + 1;
                            }

                            check++;
                        }





                        check = 0;
                        while (check < DN3.Length && DN3[check] != null && found == 0)
                        {
                            String[] filerequest = DN3[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 3;
                                raccesstime += 0.010;

                                dn3++;
                                check = DN3.Length + 1;
                            }

                            check++;
                        }

                        check = 0;
                        while (check < DN3DSK.Length && DN3DSK[check] != null && found == 0)
                        {
                            if (DN3DSK[check] == request)
                            {
                                found = 3;
                                raccesstime += 12.135;

                                dn3dsk++;
                                if (count10    == 500)
                                {
                                    count10 = -1;
                                }

                                if (count3 != -1)
                                {
                                    DN3[count3] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count3++;

                                }
                                else
                                {
                                    Array.Sort(DN3);
                                    //DN3[0] = request;
                                    // count3++;
                                    DN3[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                if (count11 != -1)
                                {

                                    global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                    count11++;
                                }

                                else
                                {
                                    Array.Sort(global1);
                                    global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;

                                }


                                if (count11 ==2000)
                                {
                                    count11 = -1;
                                }


                                check = DN3DSK.Length + 1;
                            }

                            check++;
                        }



                        check = 0;
                        while (check < DN4.Length && DN4[check] != null && found == 0)
                        {
                            String[] filerequest = DN4[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 4;
                                raccesstime += 0.010;

                                dn4++;
                                check = DN4.Length + 1;
                            }

                            check++;
                        }

                        check = 0;
                        while (check < DN4DSK.Length && DN4DSK[check] != null && found == 0)
                        {
                            //   String[]  filerequest = DN4DSK[check].Split(':');
                            if (DN4DSK[check] == request)
                            {
                                found = 4;
                                raccesstime += 12.135;
                                if (count10    == 500)
                                {
                                    count10 = -1;
                                }

                                if (count4 != -1)
                                {
                                    DN4[count4] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count4++;

                                }
                                else
                                {
                                    Array.Sort(DN4);
                                    //DN4[0] = request;
                                    // count4++;
                                    DN4[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                if (count11 != -1)
                                {

                                    global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                    count11++;
                                }

                                else
                                {
                                    Array.Sort(global1);
                                    global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;

                                }


                                if (count11 ==2000)
                                {
                                    count11 = -1;
                                }


                                dn4dsk++;
                                check = DN4DSK.Length + 1;
                            }

                            check++;
                        }



                        check = 0;
                        while (check < DN5.Length && DN5[check] != null && found == 0)
                        {
                            String[] filerequest = DN5[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 5;
                                raccesstime += 0.010;

                                dn5++;
                                check = DN5.Length + 1;
                            }

                            check++;
                        }

                        check = 0;
                        while (check < DN5DSK.Length && DN5DSK[check] != null && found == 0)
                        {
                            if (DN5DSK[check] == request)
                            {
                                found = 5;
                                raccesstime += 12.135;
                                if (count10    == 500)
                                {
                                    count10 = -1;
                                }

                                if (count5 != -1)
                                {
                                    DN5[count5] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count5++;

                                }
                                else
                                {
                                    Array.Sort(DN5);
                                    //DN5[0] = request;
                                    // count5++;
                                    DN5[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                if (count11 != -1)
                                {

                                    global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                    count11++;
                                }

                                else
                                {
                                    Array.Sort(global1);
                                    global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;

                                }


                                if (count11 ==2000)
                                {
                                    count11 = -1;
                                }


                                dn5dsk++;
                                check = DN5DSK.Length + 1;
                            }

                            check++;
                        }





                        check = 0;
                        while (check < DN6.Length && DN6[check] != null && found == 0)
                        {
                            String[] filerequest = DN6[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 6;
                                raccesstime += 0.010;

                                dn6++;
                                check = DN6.Length + 1;
                            }

                            check++;
                        }

                        check = 0;
                        while (check < DN6DSK.Length && DN6DSK[check] != null && found == 0)
                        {
                            if (DN6DSK[check] == request)
                            {
                                found = 6;
                                raccesstime += 12.135;
                                if (count10    == 500)
                                {
                                    count10 = -1;
                                }

                                if (count6 != -1)
                                {
                                    DN6[count6] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count6++;

                                }
                                else
                                {
                                    Array.Sort(DN6);
                                    //DN6[0] = request;
                                    // count6++;
                                    DN6[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                if (count11 != -1)
                                {

                                    global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                    count11++;
                                }

                                else
                                {
                                    Array.Sort(global1);
                                    global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;

                                }


                                if (count11 ==2000)
                                {
                                    count11 = -1;
                                }


                                dn6dsk++;
                                check = DN6DSK.Length + 1;
                            }

                            check++;
                        }








                        check = 0;
                        while (check < DN7.Length && DN7[check] != null && found == 0)
                        {
                            String[] filerequest = DN7[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 7;
                                raccesstime += 0.010;

                                dn7++;
                                check = DN7.Length + 1;
                            }

                            check++;
                        }

                        check = 0;
                        while (check < DN7DSK.Length && DN7DSK[check] != null && found == 0)
                        {
                            if (DN7DSK[check] == request)
                            {
                                found = 7;
                                raccesstime += 12.135;
                                if (count10    == 500)
                                {
                                    count10 = -1;
                                }

                                if (count7 != -1)
                                {
                                    DN7[count7] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count7++;

                                }
                                else
                                {
                                    Array.Sort(DN7);
                                    //DN7[0] = request;
                                    // count7++;
                                    DN7[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                if (count11 != -1)
                                {

                                    global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                    count11++;
                                }

                                else
                                {
                                    Array.Sort(global1);
                                    global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;

                                }


                                if (count11 ==2000)
                                {
                                    count11 = -1;
                                }


                                dn7dsk++;
                                check = DN7DSK.Length + 1;
                            }

                            check++;
                        }






                        check = 0;
                        while (check < DN8.Length && DN8[check] != null && found == 0)
                        {
                            String[] filerequest = DN8[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 8;
                                raccesstime += 0.010;

                                dn8++;
                                check = DN8.Length + 1;
                            }

                            check++;
                        }


                        check = 0;
                        while (check < DN8DSK.Length && DN8DSK[check] != null && found == 0)
                        {
                            if (DN8DSK[check] == request)
                            {
                                found = 8;
                                raccesstime += 12.135;
                                if (count10    == 500)
                                {
                                    count10 = -1;
                                }

                                if (count8 != -1)
                                {
                                    DN8[count8] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count8++;

                                }
                                else
                                {
                                    Array.Sort(DN8);
                                    //DN8[0] = request;
                                    // count8++;
                                    DN8[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                if (count11 != -1)
                                {

                                    global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                    count11++;
                                }

                                else
                                {
                                    Array.Sort(global1);
                                    global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;

                                }


                                if (count11 ==2000)
                                {
                                    count11 = -1;
                                }


                                dn8dsk++;
                                check = DN8DSK.Length + 1;
                            }

                            check++;
                        }



                        check = 0;
                        while (check < DN9.Length && DN9[check] != null && found == 0)
                        {
                            if (DN9[check] == request)
                            {
                                found = 9;
                                raccesstime += 0.010;

                                dn9++;
                                check = DN9.Length + 1;
                            }

                            check++;
                        }



                        check = 0;
                        while (check < DN9DSK.Length && DN9DSK[check] != null && found == 0)
                        {
                            // String[] filerequest = DN9DSK[check].Split(':');
                            if (DN10DSK[check] == request)
                            {
                                found = 9;
                                raccesstime += 12.135;
                                if (count10    == 500)
                                {
                                    count10 = -1;
                                }

                                if (count9 != -1)
                                {
                                    DN9[count9] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count9++;

                                }
                                else
                                {
                                    Array.Sort(DN9);
                                    //DN9[0] = request;
                                    // count9++;
                                    DN9[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                if (count11 != -1)
                                {

                                    global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                    count11++;
                                }

                                else
                                {
                                    Array.Sort(global1);
                                    global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;

                                }


                                if (count11 ==2000)
                                {
                                    count11 = -1;
                                }


                                dn9dsk++;
                                check = DN9DSK.Length + 1;
                            }

                            check++;
                        }


                        check = 0;
                        while (check < DN10.Length && DN10[check] != null && found == 0)
                        {
                            String[] filerequest = DN10[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 10;
                                raccesstime += 0.010;

                                dn10++;
                                check = DN10.Length + 1;
                            }
                            check++;
                        }


                        check = 0;
                        while (check < DN10DSK.Length && DN10DSK[check] != null && found == 0)
                        {
                            if (DN10DSK[check] == request)
                            {
                                found = 10;
                                raccesstime += 12.135;
                                if (count10    == 500)
                                {
                                    count10 = -1;
                                }

                                if (count10 != -1)
                                {
                                    DN10[count10] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count10++;

                                }
                                else
                                {
                                    Array.Sort(DN10);
                                    //DN10[0] = request;
                                    // count10++;
                                    DN10[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                if (count11 != -1)
                                {

                                    global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                    count11++;
                                }

                                else
                                {
                                    Array.Sort(global1);
                                    global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;

                                }


                                if (count11 ==2000)
                                {
                                    count11 = -1;
                                }


                                dn10dsk++;
                                check = DN10DSK.Length + 1;
                            }
                            check++;
                        }

                    }
                    else
                    {
                        check = 0;
                        while (check < DN6.Length && DN6[check] != null && found == 0)
                        {
                            String[] filerequest = DN6[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 6;
                                raccesstime += 0.010;

                                dn6++;
                                check = DN6.Length + 1;
                            }

                            check++;
                        }

                        check = 0;
                        while (check < DN6DSK.Length && DN6DSK[check] != null && found == 0)
                        {
                            if (DN6DSK[check] == request)
                            {
                                found = 6;
                                raccesstime += 12.135;
                                if (count6    == 500)
                                {
                                    count6 = -1;
                                }

                                if (count6 != -1)
                                {
                                    DN6[count6] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count6++;

                                }
                                else
                                {
                                    Array.Sort(DN6);
                                    //DN6[0] = request;
                                    // count6++;
                                    DN6[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                if (count11 != -1)
                                {

                                    global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                    count11++;
                                }

                                else
                                {
                                    Array.Sort(global1);
                                    global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;

                                }


                                if (count11 ==2000)
                                {
                                    count11 = -1;
                                }


                                dn6dsk++;
                                check = DN6DSK.Length + 1;
                            }

                            check++;
                        }








                        check = 0;
                        while (check < DN7.Length && DN7[check] != null && found == 0)
                        {
                            String[] filerequest = DN7[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 7;
                                raccesstime += 0.010;

                                dn7++;
                                check = DN7.Length + 1;
                            }

                            check++;
                        }

                        check = 0;
                        while (check < DN7DSK.Length && DN7DSK[check] != null && found == 0)
                        {
                            if (DN7DSK[check] == request)
                            {
                                found = 7;
                                raccesstime += 12.135;
                                if (count7    == 500)
                                {
                                    count7 = -1;
                                }

                                if (count7 != -1)
                                {
                                    DN7[count7] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count7++;

                                }
                                else
                                {
                                    Array.Sort(DN7);
                                    //DN7[0] = request;
                                    // count7++;
                                    DN7[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                if (count11 != -1)
                                {

                                    global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                    count11++;
                                }

                                else
                                {
                                    Array.Sort(global1);
                                    global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;

                                }


                                if (count11 ==2000)
                                {
                                    count11 = -1;
                                }



                                dn7dsk++;
                                check = DN7DSK.Length + 1;
                            }

                            check++;
                        }






                        check = 0;
                        while (check < DN8.Length && DN8[check] != null && found == 0)
                        {
                            String[] filerequest = DN8[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 8;
                                raccesstime += 0.010;

                                dn8++;
                                check = DN8.Length + 1;
                            }

                            check++;
                        }


                        check = 0;
                        while (check < DN8DSK.Length && DN8DSK[check] != null && found == 0)
                        {
                            if (DN8DSK[check] == request)
                            {
                                found = 8;
                                raccesstime += 12.135;
                                if (count8    == 500)
                                {
                                    count8 = -1;
                                }

                                if (count8 != -1)
                                {
                                    DN8[count8] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count8++;

                                }
                                else
                                {
                                    Array.Sort(DN8);
                                    //DN1[0] = request;
                                    // count1++;
                                    DN8[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                if (count11 != -1)
                                {

                                    global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                    count11++;
                                }

                                else
                                {
                                    Array.Sort(global1);
                                    global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;

                                }


                                if (count11 ==2000)
                                {
                                    count11 = -1;
                                }


                                dn8dsk++;
                                check = DN8DSK.Length + 1;
                            }

                            check++;
                        }



                        check = 0;
                        while (check < DN9.Length && DN9[check] != null && found == 0)
                        {
                            if (DN9[check] == request)
                            {
                                found = 9;
                                raccesstime += 0.010;

                                dn9++;
                                check = DN9.Length + 1;
                            }

                            check++;
                        }



                        check = 0;
                        while (check < DN9DSK.Length && DN9DSK[check] != null && found == 0)
                        {
                            // String[] filerequest = DN9DSK[check].Split(':');
                            if (DN10DSK[check] == request)
                            {
                                found = 9;
                                raccesstime += 12.135;
                                if (count9    == 500)
                                {
                                    count9 = -1;
                                }

                                if (count9 != -1)
                                {
                                    DN9[count9] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count9++;

                                }
                                else
                                {
                                    Array.Sort(DN9);
                                    //DN1[0] = request;
                                    // count1++;
                                    DN9[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                if (count11 != -1)
                                {

                                    global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                    count11++;
                                }

                                else
                                {
                                    Array.Sort(global1);
                                    global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;

                                }


                                if (count11 ==2000)
                                {
                                    count11 = -1;
                                }


                                dn9dsk++;
                                check = DN9DSK.Length + 1;
                            }

                            check++;
                        }


                        check = 0;
                        while (check < DN10.Length && DN10[check] != null && found == 0)
                        {
                            String[] filerequest = DN10[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 10;
                                raccesstime += 0.010;

                                dn10++;
                                check = DN10.Length + 1;
                            }
                            check++;
                        }


                        check = 0;
                        while (check < DN10DSK.Length && DN10DSK[check] != null && found == 0)
                        {
                            if (DN10DSK[check] == request)
                            {
                                found = 10;
                                raccesstime += 12.135;
                                if (count10    == 500)
                                {
                                    count10 = -1;
                                }

                                if (count10 != -1)
                                {
                                    DN10[count10] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count10++;

                                }
                                else
                                {
                                    Array.Sort(DN10);
                                    //DN1[0] = request;
                                    // count1++;
                                    DN10[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                if (count11 != -1)
                                {

                                    global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                    count11++;
                                }

                                else
                                {
                                    Array.Sort(global1);
                                    global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;

                                }


                                if (count11 ==2000)
                                {
                                    count11 = -1;
                                }


                                dn10dsk++;
                                check = DN10DSK.Length + 1;
                            }
                            check++;
                        }
                        check = 0;
                        while (check < DN1.Length && DN1[check] != null && found == 0)
                        {
                            String[] filerequest = DN1[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                raccesstime += 0.010;

                                //raccesstime += 4.010;
                                found = 1;
                                dn1++;
                                check = DN1.Length + 1;
                            }
                            check++;
                        }
                        check = 0;
                        while (check < DN1DSK.Length && DN1DSK[check] != null && found == 0)
                        {
                            if (DN1DSK[check] == request)
                            {
                                raccesstime += 12.135;
                                found = 1;
                                if (count1    == 500)
                                {
                                    count1 = -1;
                                }

                                if (count1 != -1)
                                {
                                    DN1[count1] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count1++;

                                }
                                else
                                {
                                    Array.Sort(DN1);
                                    //DN1[0] = request;
                                    // count1++;
                                    DN1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                if (count11 != -1)
                                {

                                    global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                    count11++;
                                }

                                else
                                {
                                    Array.Sort(global1);
                                    global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;

                                }


                                if (count11 ==2000)
                                {
                                    count11 = -1;
                                }


                                dn1dsk++;
                                check = DN1DSK.Length + 1;
                            }
                            check++;
                        }


                        check = 0;
                        while (check < DN2.Length && DN2[check] != null && found == 0)
                        {
                            String[] filerequest = DN2[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 2;
                                raccesstime += 0.010;

                                dn2++;
                                check = DN2.Length + 1;
                            }

                            check++;
                        }
                        check = 0;
                        while (check < DN2DSK.Length && DN2DSK[check] != null && found == 0)
                        {
                            if (DN2DSK[check] == request)
                            {
                                found = 2;
                                raccesstime += 12.135;
                                if (count2    == 500)
                                {
                                    count2 = -1;
                                }

                                if (count2 != -1)
                                {
                                    DN2[count2] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count2++;

                                }
                                else
                                {
                                    Array.Sort(DN2);
                                    //DN2[0] = request;
                                    // count2++;
                                    DN2[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                if (count11 != -1)
                                {

                                    global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                    count11++;
                                }

                                else
                                {
                                    Array.Sort(global1);
                                    global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;

                                }


                                if (count11 ==2000)
                                {
                                    count11 = -1;
                                }


                                dn2dsk++;
                                check = DN2DSK.Length + 1;
                            }

                            check++;
                        }





                        check = 0;
                        while (check < DN3.Length && DN3[check] != null && found == 0)
                        {
                            String[] filerequest = DN3[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 3;
                                raccesstime += 0.010;

                                dn3++;
                                check = DN3.Length + 1;
                            }

                            check++;
                        }

                        check = 0;
                        while (check < DN3DSK.Length && DN3DSK[check] != null && found == 0)
                        {
                            if (DN3DSK[check] == request)
                            {
                                found = 3;
                                raccesstime += 12.135;
                                if (count3    == 500)
                                {
                                    count3 = -1;
                                }

                                if (count3 != -1)
                                {
                                    DN3[count3] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count3++;

                                }
                                else
                                {
                                    Array.Sort(DN3);
                                    //DN3[0] = request;
                                    // count3++;
                                    DN3[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                if (count11 != -1)
                                {

                                    global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                    count11++;
                                }

                                else
                                {
                                    Array.Sort(global1);
                                    global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;

                                }


                                if (count11 ==2000)
                                {
                                    count11 = -1;
                                }


                                dn3dsk++;
                                check = DN3DSK.Length + 1;
                            }

                            check++;
                        }



                        check = 0;
                        while (check < DN4.Length && DN4[check] != null && found == 0)
                        {
                            String[] filerequest = DN4[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 4;
                                raccesstime += 0.010;

                                dn4++;
                                check = DN4.Length + 1;
                            }

                            check++;
                        }

                        check = 0;
                        while (check < DN4DSK.Length && DN4DSK[check] != null && found == 0)
                        {
                            //   String[]  filerequest = DN4DSK[check].Split(':');
                            if (DN4DSK[check] == request)
                            {
                                found = 4;
                                raccesstime += 12.135;
                                if (count4    == 500)
                                {
                                    count4 = -1;
                                }

                                if (count4 != -1)
                                {
                                    DN4[count4] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count4++;

                                }
                                else
                                {
                                    Array.Sort(DN4);
                                    //DN4[0] = request;
                                    // count4++;
                                    DN4[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                if (count11 != -1)
                                {

                                    global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                    count11++;
                                }

                                else
                                {
                                    Array.Sort(global1);
                                    global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;

                                }


                                if (count11 ==2000)
                                {
                                    count11 = -1;
                                }


                                dn4dsk++;
                                check = DN4DSK.Length + 1;
                            }

                            check++;
                        }



                        check = 0;
                        while (check < DN5.Length && DN5[check] != null && found == 0)
                        {
                            String[] filerequest = DN5[check].Split(':');
                            if (filerequest[1] == request)
                            {
                                found = 5;
                                raccesstime += 0.010;

                                dn5++;
                                check = DN5.Length + 1;
                            }

                            check++;
                        }

                        check = 0;
                        while (check < DN5DSK.Length && DN5DSK[check] != null && found == 0)
                        {
                            if (DN5DSK[check] == request)
                            {
                                found = 5;
                                raccesstime += 12.135;
                                if (count5    == 500)
                                {
                                    count5 = -1;
                                }

                                if (count5 != -1)
                                {
                                    DN5[count5] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    count5++;

                                }
                                else
                                {
                                    Array.Sort(DN5);
                                    //DN5[0] = request;
                                    // count5++;
                                    DN5[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;
                                }


                                if (count11 != -1)
                                {

                                    global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;

                                    count11++;
                                }

                                else
                                {
                                    Array.Sort(global1);
                                    global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request;
                                    propevictions++;

                                }


                                if (count11 ==2000)
                                {
                                    count11 = -1;
                                }


                                dn5dsk++;
                                check = DN5DSK.Length + 1;
                            }

                            check++;
                        }



                    }

                    if (appno <= 5 && found > 5 || appno > 5 && found <= 5)
                    {
                        raccesstime += 6;

                        //                        apaccesstime = 2+0.125 + 0.125 + 12 + 0.005 + 4.00 + 0.005 + 0.005;

                        //different switch add switch delay also
                    }
                    else if (found != 0)
                    {
                        raccesstime += 4;

                        //apaccesstime = 0.125 + 0.125 + 12 + 0.005 + 4.00 + 0.005 + 0.005;
                    }
                    else
                    {
                        raccesstime += 12;
                        // MessageBox.Show("File not found");
                    }
                    //agglobalcache[aggoci] = filename;
                    //aggoci++;
                    //agglobalcache[aggoci] = blocknum;
                    //aggoci++;
                    //aglocalcache[agloci] = filename;
                    //agloci++;
                    //aglocalcache[agloci] = blocknum;
                    //agloci++;
                    agdiskhit++;
                    //       MessageBox.Show(agdiskhit + "");
                }

                aptotalaccesstime += apaccesstime;
                agtotalaccesstime += agaccesstime;

                proc2++;
                if (proc2 >= apps)
                {
                    agavgaccesstime = agtotalaccesstime / apps;
                    apavgaccesstime = aptotalaccesstime / apps;
                    //MessageBox.Show(agavgaccesstime + "");
                }
            }
            appcount++;

            appcount31++;
            if (appcount31 >= 50000)
            {
                int finalaveragea = dn1loc + dn2loc + dn3loc + dn4loc + dn5loc + dn6loc + dn7loc + dn8loc + dn9loc + dn10loc;
                int finalaverage1a = dn1loca + dn2loca + dn3loca + dn4loca + dn5loca + dn6loca + dn7loca + dn8loca + dn9loca + dn10loca;
                int finalaverage2a = dn1 + dn2 + dn3 + dn4 + dn5 + dn6 + dn7 + dn8 + dn9 + dn10;
                int finalaverage3a = dn1a + dn2a + dn3a + dn4a + dn5a + dn6a + dn7a + dn8a + dn9a + dn10a;


                int finaltotal = ((finalaveragea + finalaverage2a + dngoc)*100)/appcount;
                if (finaltotal <= 10)
                {
                    System.out.println("please wait refilling is process");
                    if (File.Exists("e:\\DataNode1.txt"))
                    {
                        File.Delete("e:\\DataNode1.txt");
                        File.Delete("e:\\globallogs1.txt");
                    }
                    calculate();
                    calculateDN();
                    cachefillng1();
                    globalcachefilling1();
                    appcount31 = 0;
                }
            }

        }
        avgraccesstime = raccesstime / apps;
        avgraccesstimea = raccesstimea / apps;
        avgraccesstimeaa = raccesstimeaa / apps;
        /*System.out.println("Avg Write AccessTime" + avgwaccesstime + "");
        System.out.println("Avg old Write AccessTime" + avgwaccesstimea + "");
        System.out.println("Avg hadoop no cahce Write AccessTime" + avgwaccesstimeaa + "");
         */
        System.out.println("Avg Read proposed Cache AccessTime" + avgraccesstime);
        System.out.println("Avg Read Hadoop+Cache AccessTime" + avgraccesstimea + "");
        System.out.println("Avg Read Hadoop+no Cache AccessTime" + avgraccesstimeaa + "");
        System.out.println(dn1dsk + dn2dsk + dn3dsk + dn4dsk + dn5dsk + dn6dsk + dn7dsk + dn8dsk + dn9dsk + dn10dsk);
        int finalaverage = dn1loc + dn2loc + dn3loc + dn4loc + dn5loc + dn6loc + dn7loc + dn8loc + dn9loc + dn10loc;
        int finalaverage1 = dn1loca + dn2loca + dn3loca + dn4loca + dn5loca + dn6loca + dn7loca + dn8loca + dn9loca + dn10loca;
        int finalaverage2 = dn1 + dn2 + dn3 + dn4 + dn5 + dn6 + dn7 + dn8 + dn9 + dn10;
        int finalaverage3 = dn1a + dn2a + dn3a + dn4a + dn5a + dn6a + dn7a + dn8a + dn9a + dn10a;

        double prophit = ((finalaverage + finalaverage2 + dngoc)*100.00000) / appcount;
        double existhit = ((finalaverage1 + finalaverage3) * 100.00000) / appcount;
        System.out.println("local hit proposed:"+dn1loc + dn2loc + dn3loc + dn4loc + dn5loc + dn6loc + dn7loc + dn8loc + dn9loc + dn10loc+"total:"+finalaverage);
        System.out.println("local hit Existing:"+dn1loca + dn2loca + dn3loca + dn4loca + dn5loca + dn6loca + dn7loca + dn8loca + dn9loca + dn10loca+"total:"+finalaverage1);
        System.out.println("collaboratve hit proposed:" + dn1 + dn2 + dn3 + dn4 + dn5 + dn6 + dn7 + dn8 + dn9 + dn10 + "total:" + finalaverage2);
        System.out.println("collaboratve hit Existing:" + dn1a + dn2a + dn3a + dn4a + dn5a + dn6a + dn7a + dn8a + dn9a + dn10a + "total:" + finalaverage3);

        System.out.println("proposed hit ratio:"+prophit);
        System.out.println("Existing hit ratio:" + existhit);

        System.out.println("Existing LRU Evictions:" + existevictions);
        System.out.println("Proposed LRU Evictions:" + propevictions);

      //  //System.out.println("DN1lochit "+dn1loca+"  :: DN2lochit "+dn2loca+" :: DN3lochit "+dn3loca);
       // //System.out.println(" :: DN4lochit " + dn4loca + " :: DN5lochit " + dn5loca + " :: DN6lochit " + dn6loca );
        ////System.out.println(" :: DN7lochit " + dn7loca + " :: DN8lochit " + dn8loca + " :: DN9lochit " + dn9loca + " :: DNl0Lochit " + dn10loca);
       
         ////System.out.println("DN1lochitprop " + dn1loc + "  :: DN2lochit " + dn2loc + " :: DN3lochit " + dn3loc );
         ////System.out.println(" :: DN4lochit " + dn4loc + " :: DN5lochit " + dn5loc + " :: DN6lochit " + dn6loc );
         ////System.out.println(" :: DN7lochit " + dn7loc + " :: DN8lochit " + dn8loc + " :: DN9lochit " + dn9loc + " :: DNl0Lochit " + dn10loc);
   

         System.out.println("Global Cache:"+dngoc);
       //  //System.out.println(

        Console.readLine();
        //label14.Text = avgraccesstime + "";
        //label46.Text = avgraccesstimea + "";
        //label49.Text = avgraccesstimeaa + "";


        //                label9.Text = dn1loc + "";
        //              label20.Text = dn2loc + "";
        ///            label22.Text = dn3loc + "";
        //         label21.Text = dn4loc + "";
        //       label24.Text = dn5loc + "";
        //     label23.Text = dn6loc + "";
        //   label26.Text = dn7loc + "";
        // label25.Text = dn8loc + "";
        //label28.Text = dn9loc + "";
        //            label27.Text = dn10loc + "";

        //          label38.Text = dn1dsk + "";
        //        label37.Text = dn2dsk + "";
        //      label36.Text = dn3dsk + "";
        //    label35.Text = dn4dsk + "";
        //  label34.Text = dn5dsk + "";
        //label33.Text = dn6dsk + "";
        //label32.Text = dn7dsk + "";
        //          label31.Text = dn8dsk + "";
        //        label30.Text = dn9dsk + "";
        //      label29.Text = dn10dsk + "";


        //    label39.Text = dngoc + "";
        /*            label14.Text = sptotalaccesstime + "";
                    label18.Text = aptotalaccesstime + "";
                    label16.Text = agtotalaccesstime + "";

                    label13.Text = spavgaccesstime + "";
                    label17.Text = apavgaccesstime + "";
                    label15.Text = agavgaccesstime + "";

                    label24.Text = splochit + "";
                    label37.Text = spdiskhit + "";

                    label20.Text = aglochit + "";
                    label31.Text = aggochit + "";
                    label35.Text = agdiskhit + "";

                    label22.Text = aglochit + "";
                    //     label21.Text = agnochit + "";
                    label32.Text = aggochit + "";
                    label36.Text = agdiskhit + "";
                    */



    }


    // private void button3_Click(object sender, EventArgs e)
    public static void Diskfilling()
    {
        t = new Thread(filling);
        t.Start();
    }

    public static void filling()
    {
Random random1 = new Random();
int numberoffiles=100;
int numberofblocks=100;
for(int fi=1;fi<numberoffiles;fi++)
{
for(int bi=1;bi<numberofblocks;bi++)
{
int appno = random1.Next(10)+1;
String cliname = "DN" + appno;
String request1="F"+fi+"B"+bi;
int replica = 0;
                    while (replica <= 2)
                    {

                       // //System.out.println(cliname+":"+request1+":"+replica);
////System.out.println(cliname+":rep:"+replica+":request:"+request1);

                        replica++;
                        switch (cliname)
                        {
                            case "DN1":

                                //System.out.println("DN11DSKa1");

                              
if (count12 == 10000)
                            {
                                count12 = 0;
                            }

                            if (count12a == 10000)
                            {
                                count12a = 0;
                            }

                            if (count12aa == 10000)
                            {
                                count12aa = 0;
                            }

                            if (count1    == 500)
                            {
                                count1 = -1;
                            }


                            if (count1a    == 500)
                            {
                                count1a = -1;
                            }

                            DN1DSK[count12] = request1;
                            count12++;
                            DN1DSKa[count12a] = request1;
                            count12a++;
                            DN1DSKaa[count12aa] = request1;
                            count12aa++;
                                if (replica == 1)
                                {
                                    if (count1a != -1)
                                    {
                                        DN1a[count1a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                                        count1a++;
                                    }
                                    else
                                    {
                                        Array.Sort(DN1a);
                                        DN1a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                                    }           
                                    if(count1!=-1)
                                    
                                    { 
                                        DN1[count1] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                                count1++;

                                }
                                else
                                {
                                     Array.Sort(DN1);
                                //DN1[0] = request1;
                                // count1++;
                                DN1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
}

                                    int rep1 = random1.Next(5)+1;
                                    while (rep1 == 1)
                                    {
                                        rep1 = random1.Next(5)+1;
                                    }
                                    cliname = "DN" + rep1;
                                }
                                
                                if (replica == 2)
                                {

                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;
                                    cliname = "DN" + rep2;

                                }
                                break;

                            case "DN2":

                                //System.out.println("DN12DSKa1");

                               
                            DN2DSK[count13] = request1;
                            count13++;
                            DN2DSKa[count13a] = request1;
                            count13a++;
                            DN2DSKaa[count13aa] = request1;
                            count13aa++;

                            if (count13 == 10000)
                            {
                                count13 = 0;
                            }

                            if (count13a == 10000)
                            {
                                count13a = 0;
                            }
                            if (count13aa == 10000)
                            {
                                count13aa = 0;
                            }
                            if (count2    == 500)
                            {
                                count2 = -1;
                            }


                            if (count2a    == 500)
                            {
                                count2a = -1;
                            }
                                if (replica == 1)
                                {
                                    if (count2a != -1)
                                    {
                                        DN2a[count2a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                                        count2a++;
                                    }
                                    else
                                    {
                                        Array.Sort(DN2a);
                                        DN2a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                               
                                    }
                                    if(count2!=-1){
                                //DN2[count2] = request1;
                                // count2++;
                                DN2[count2] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                                count2++;
                                }
                                else
                                {
                                   Array.Sort(DN2);
                                //DN2[0] = request1;
                                // count2++;
                                DN2[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                                 }


                                    int rep1 = random1.Next(5)+1;
                                    while (rep1 == 2)
                                    {
                                        rep1 = random1.Next(5)+1;
                                    }
                                    cliname = "DN" + rep1;
                                }
                                if (replica == 2)
                                {

                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;
                                    cliname = "DN" + rep2;

                                }
                                break;
                            case "DN3":

                                //System.out.println("DN13DSKa1");

                              

                            DN3DSK[count14] = request1;
                            count14++;
                            DN3DSKa[count14a] = request1;
                            count14a++;
                            DN3DSKaa[count14aa] = request1;
                            count14aa++;

                            if (count14 == 10000)
                            {
                                count14 = 0;
                            }

                            if (count14a == 10000)
                            {
                                count14a = 0;
                            }

                            if (count14aa == 10000)
                            {
                                count14aa = 0;
                            }

                            if (count3    == 500)
                            {
                                count3 = -1;
                            }


                            if (count3a    == 500)
                            {
                                count3a = -1;
                            }
                                if (replica == 1)
                                {
   if (count3 != -1)
                            {
                     //DN3[count3] = request1;
                                // count3++;
                                DN3[count3] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                                count3++;
                            }
                                else
   {
       Array.Sort(DN3);
       //DN3[0] = request1;
       // count3++;
       DN3[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
   }

   if (count3a != -1)
   {

       DN3a[count3a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
       count3a++;
   }
   else
   {
       Array.Sort(DN3a);
       DN3a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
   }


                                    int rep1 = random1.Next(5)+1;
                                    while (rep1 == 3)
                                    {
                                        rep1 = random1.Next(5)+1;
                                    }
                                    cliname = "DN" + rep1;
                                }
                                if (replica == 2)
                                {

                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;
                                    cliname = "DN" + rep2;

                                }

                                break;
                            case "DN4":

                                //System.out.println("DN14DSKa1");

                        
               DN4DSK[count15] = request1;
                            count15++;
                            DN4DSKa[count15a] = request1;
                            count15a++;
                            DN4DSKaa[count15aa] = request1;
                            count15aa++;

                            if (count15 == 10000)
                            {
                                count15 = 0;
                            }

                            if (count15a == 10000)
                            {
                                count15a = 0;
                            }

                            if (count15aa == 10000)
                            {
                                count15aa = 0;
                            }

                            if (count4    == 500)
                            {
                                count4 = -1;
                            }


                            if (count4a    == 500)
                            {
                                count4a = -1;
                            }
                                if (replica == 1)
                                {

                                    if (count4a != -1)
                                    {
                                        DN4a[count4a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                                        count4a++;
                                        //DN4[count4] = request1;
                                        // count4++;
                                    }
                                    else
                                    {
                                        Array.Sort(DN4a);
                                        DN4a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                                    }
if (count4 != -1)
{
DN4[count4] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
count4++;
}
else
{
Array.Sort(DN4);
//DN4[0] = request1;
// count4++;
DN4[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
}


                                     int rep1 = random1.Next(5)+1;
                                    while (rep1 == 4)
                                    {
                                        rep1 = random1.Next(5)+1;
                                    }
                                    cliname = "DN" + rep1;
                                }
                                if (replica == 2)
                                {

                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;
                                    cliname = "DN" + rep2;

                                }

                                break;

                            case "DN5":


                                //System.out.println("DN15DSKa1");

                           DN5DSK[count16] = request1;
                            count16++;
                            DN5DSKa[count16a] = request1;
                            count16a++;
                            DN5DSKaa[count16aa] = request1;
                            count16aa++;

                            if (count16 == 10000)
                            {
                                count16 = 0;
                            }

                            if (count16a == 10000)
                            {
                                count16a = 0;
                            }

                            if (count16aa == 10000)
                            {
                                count16aa = 0;
                            }

                            if (count5    == 500)
                            {
                                count5 = -1;
                            }


                            if (count5a    == 500)
                            {
                                count5a = -1;
                            }

                                if (count16a == 10000)
                                {
                                    count16a = 0;
                                }
                                if (replica == 1)
                                {
                                    if (count5a != -1)
                                    {

                                        DN5a[count5a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                                        count5a++;
                                        //DN5[count5] = request1;
                                        // count5++;
                                    }
                                    else
                                    {
                                        Array.Sort(DN5a);
                                        DN5a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                                    
                                    }
                                    if (count5 != -1) {                 
                                        DN5[count5] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                                count5++;
                            }
               
                                    else
                                    {
                                        Array.Sort(DN5);
                                        //DN5[0] = request1;
                                        // count5++;
                                        DN5[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                                    }


                                    int rep1 = random1.Next(5)+1;
                                    while (rep1 == 5)
                                    {
                                        rep1 = random1.Next(5)+1;
                                    }
                                    cliname = "DN" + rep1;
                                }
                                if (replica == 2)
                                {

                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;
                                    cliname = "DN" + rep2;

                                }


                                break;
                            case "DN6":

                                //System.out.println("DN16DSKa1");




DN6DSK[count17] = request1;
                            count17++;
                            DN6DSKa[count17a] = request1;
                            count17a++;
                            DN6DSKaa[count17aa] = request1;
                            count17aa++;

                            if (count17 == 10000)
                            {
                                count17 = 0;
                            }

                            if (count17a == 10000)
                            {
                                count17a = 0;
                            }

                            if (count17aa == 10000)
                            {
                                count17aa = 0;
                            }

                            if (count6    == 500)
                            {
                                count6 = -1;
                            }


                            if (count6a    == 500)
                            {
                                count6a = -1;
                            }

                                if (replica == 1)
                                {
                                    if (count6a != -1)
                                    {

                                        DN6a[count6a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                                        count6a++;
                                    }
                                    else
                                    {
                                        Array.Sort(DN6a);
                                        DN6a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                                    }
                               if (count6 != -1)
                               {

                                //DN6[count6] = request1;
                                // count6++;
                                DN6[count6] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                                count6++;
                            }
                            else
                            {
                                Array.Sort(DN6);
                                //DN6[0] = request1;
                                // count6++;
                                DN6[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                              }


                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;

                                    while (rep2 == 6)
                                    {
                                        rep = random1.Next(5)+1;
                                        rep2 = rep + 5;
                                    }

                                    cliname = "DN" + rep2;

                                }
                                if (replica == 2)
                                {
                                    int rep1 = random1.Next(5)+1;
                                    cliname = "DN" + rep1;

                                }

                                break;
                            case "DN7":


                                //System.out.println("DN17DSKa1");

                               
             DN7DSK[count18] = request1;
                            count18++;
                            DN7DSKa[count18a] = request1;
                            count18a++;
                            DN7DSKaa[count18aa] = request1;
                            count18aa++;

                            if (count18 == 10000)
                            {
                                count18 = 0;
                            }

                            if (count18a == 10000)
                            {
                                count18a = 0;
                            }
                            if (count18aa == 10000)
                            {
                                count18aa = 0;
                            }

                            if (count7    == 500)
                            {
                                count7 = -1;
                            }


                            if (count7a    == 500)
                            {
                                count7a = -1;
                            }


                                if (replica == 1)
                                {
                                    if (count7a != -1)
                                    {

                                        DN7a[count7a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                                        count7a++;
                                    }
                                    else
                                    {
                                        Array.Sort(DN7a);
                                        DN7a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                                            }

if (count7 != -1)
{

                                //DN7[count7] = request1;
                                // count7++;
                                DN7[count7] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                                count7++;
                            }
                            else
                            {
                                Array.Sort(DN7);
                                //DN7[0] = request1;
                                // count7++;
                                DN7[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                               }



                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;

                                    while (rep2 == 7)
                                    {
                                        rep = random1.Next(5)+1;
                                        rep2 = rep + 5;
                                    }

                                    cliname = "DN" + rep2;

                                }
                                if (replica == 2)
                                {
                                    int rep1 = random1.Next(5)+1;
                                    cliname = "DN" + rep1;

                                }


                                break;
                            case "DN8":

                                //System.out.println("DN18DSKa1");

                               
        DN8DSK[count19] = request1;
                            count19++;
                            DN8DSKa[count19a] = request1;
                            count19a++;
                            DN8DSKaa[count19aa] = request1;
                            count19aa++;

                            if (count19 == 10000)
                            {
                                count19 = 0;
                            }

                            if (count19a == 10000)
                            {
                                count19a = 0;
                            }
                            if (count19aa == 10000)
                            {
                                count19aa = 0;
                            }

                            if (count8    == 500)
                            {
                                count8 = -1;
                            }


                            if (count8a    == 500)
                            {
                                count8a = -1;
                            }
                                if (replica == 1)
                                {
if (count8a != -1)
                            {

                                DN8a[count8a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                                count8a++;
                                //DN8[count8] = request1;
                                // count8++;
}
else
{
  Array.Sort(DN8a);
  DN8a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                            
}
if (count8 != -1)
{

                                DN8[count8] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                                count8++;
                            }
                            else
                            {
                                Array.Sort(DN8);
                                //DN8[0] = request1;
                                // count8++;
                                DN8[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                             }


                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;

                                    while (rep2 == 8)
                                    {
                                        rep = random1.Next(5)+1;
                                        rep2 = rep + 5;
                                    }

                                    cliname = "DN" + rep2;

                                }
                                if (replica == 2)
                                {
                                    int rep1 = random1.Next(5)+1;
                                    cliname = "DN" + rep1;

                                }

                                break;
                            case "DN9":

                                //System.out.println("DN19DSKa1");

                                
DN9DSK[count20] = request1;
                            count20++;
                            DN9DSKa[count20a] = request1;
                            count20a++;
                            DN9DSKaa[count20aa] = request1;
                            count20aa++;

                            if (count20 == 10000)
                            {
                                count20 = 0;
                            }

                            if (count20a == 10000)
                            {
                                count20a = 0;
                            }
                            if (count20aa == 10000)
                            {
                                count20aa = 0;
                            }

                            if (count9    == 500)
                            {
                                count9 = -1;
                            }


                            if (count9a    == 500)
                            {
                                count9a = -1;
                            }
                                if (replica == 1)
                                {
                                    if (count9a != -1)
                                    {

                                        DN9a[count9a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                                        count9a++;
                                    }
                                    else
                                    {
                                        Array.Sort(DN9a);
                                        DN9a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                            
                                    }
if (count9 != -1)
{
                                //DN9[count9] = request1;
                                // count9++;
                                DN9[count9] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                                count9++;
                            }
                            else
                            {
                                Array.Sort(DN9);
                                //DN9[0] = request1;
                                // count9++;
                                DN9[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                                }



                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;

                                    while (rep2 == 9)
                                    {
                                        rep = random1.Next(5)+1;
                                        rep2 = rep + 5;
                                    }

                                    cliname = "DN" + rep2;

                                }
                                if (replica == 2)
                                {
                                    int rep1 = random1.Next(5)+1;
                                    cliname = "DN" + rep1;

                                }

                                break;
                            case "DN10":

                                //System.out.println("DN20DSKa1");

                             


DN10DSK[count21] = request1;
                            count21++;
                            DN10DSKa[count21a] = request1;
                            count21a++;
                            DN10DSKaa[count21aa] = request1;
                            count21aa++;

                            if (count21 == 10000)
                            {
                                count21 = 0;
                            }

                            if (count21a == 10000)
                            {
                                count21a = 0;
                            }

                            if (count10    == 500)
                            {
                                count10 = -1;
                            }


                            if (count10a    == 500)
                            {
                                count10a = -1;
                            }

                                if (replica == 1)
                                {
                                    if (count10a != -1)
                                    {

                                        DN10a[count10a] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                                        count10a++;
                                        //DN10[count10] = request1;
                                        // count10++;
                                    }
                                    else
                                    {
                                        Array.Sort(DN10a);
                                        DN10a[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                            
                                    }
                              if (count10 != -1)
                              {

                                  DN10[count10] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                                count10++;
                            }
                            else
                            {
                                Array.Sort(DN10);
                                //DN10[0] = request1;
                                // count10++;
                                DN10[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + request1;
                                }

                                    int rep = random1.Next(5)+1;
                                    int rep2 = rep + 5;

                                    while (rep2 == 10)
                                    {
                                        rep = random1.Next(5)+1;
                                        rep2 = rep + 5;
                                    }

                                    cliname = "DN" + rep2;

                                }
                                if (replica == 2)
                                {
                                    int rep1 = random1.Next(5)+1;
                                    cliname = "DN" + rep1;

                                }

                                break;
                        }
                    }
                   
}
}

         System.out.println("DIsk filling Success");

}

    // private void button4_Click(object sender, EventArgs e)
    public static void globalcachefilling()
    {

        using (StreamReader sr = File.OpenText(file1path2))
        {
            String s = String.Empty;
            while ((s = sr.readLine()) != null)
            {
                String[] spl = s.Split(' ');
                for (int k = 2; k < spl.Length; k++)
                {

                    if (count11 != -1)
                    {

                        global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[0] + "B" + spl[k];

                        count11++;
                    }

                    else
                    {
                        Array.Sort(global1);
                        global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                    }


                    if (count11    == 2000)
                    {
                        count11 = -1;
                    }

                }
            }
        }
        // MessageBox.Show("Successfull");
        System.out.println("Global Cache fill Successfull");

    }
    public static void globalcachefilling1()
    {

        using (StreamReader sr = File.OpenText("e:\\globallogs.txt"))
        {
            String s = String.Empty;
            while ((s = sr.readLine()) != null)
            {
                String[] spl = s.Split(' ');
                for (int k = 2; k < spl.Length; k++)
                {

                    if (count11 != -1)
                    {

                        global1[count11] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[0] + "B" + spl[k];

                        count11++;
                    }

                    else
                    {
                        Array.Sort(global1);
                        global1[0] = DateTime.Now.ToString("yyyyMMddHHmmssffffff") + ":" + spl[1] + "B" + spl[k];

                    }


                    if (count11    == 2000)
                    {
                        count11 = -1;
                    }

                }
            }
        }
        // MessageBox.Show("Successfull");
        System.out.println("Global Cache fill Successfull");

    }

    public static void calculateDN()
    {
        String fcheck = "";
        var list = new List<KeyValuePair<double, String>>();
        int finalfiles = 0;
        System.out.println("please be patient while Support has been calculating");
        String[] frequency = new String[files + 4];
        String[] frequency2 = new String[files + 4];
        String[] frequency3 = new String[files + 4];

        int k = 0;
        int l = 0;
        String[] logsupport = new String[100000];
        using (StreamReader sr = File.OpenText("e:\\newlogs.txt"))
        {
            String s = String.Empty;
            while ((s = sr.readLine()) != null)
            {
                logsupport[l] = s;
                l++;
            }
        }
        int su = 0;
        while (su < 10)
        {
            int dncount = 0;
            list.Clear();
            averagelen = 0;
            su++;
            for (int a = 0; a < l; a++)
            {

                int count = 0;
                k++;
                String[] s11 = logsupport[a].Split(' ');
                if (s11[0] == "DN" + su)
                {
                    dncount++;
                    String requested = s11[3];
                    averagelen += s11.Length;
                    String[] s12 = requested.Split('F');
                    frequency1[Convert.ToInt32(s12[1])] += 1;
                    int s13 = logsupport[a].IndexOf(requested);
                    String s14 = logsupport[a].SubString(s13 + requested.Length + 1);
                    frequency2[Convert.ToInt32(s12[1])] += s14;
                    //frequency[Convert.ToInt32(s12[1])] = frequency1[Convert.ToInt32(s12[1])] + ":F";
                }
            }
            int count5 = 0;
            for (int d = 0; d < frequency1.Length; d++)
            {
                double supp = (frequency1[d] * 100.000000) / 100000.000000;
                if (frequency1[d] > 0)
                    frequency[d] = supp.ToString() + ":" + frequency1[d] + ":F" + d;
                if (frequency2[d] != null)
                {
                    int len = frequency2[d].Length - 1;
                    count5 += len;
                    frequency3[d] = frequency1[d] + " " + len + " " + frequency2[d] + "F" + d;
                }
            }
            int avglen = averagelen / dncount;
            finalfiles = 100 / avglen;
            if (finalfiles == 0)
            {
                finalfiles = 1;
            }
            Array.Sort(frequency);

            int m1 = 0;
            // int count5 = 0;

            //  String[] popblocks = new String[finalfiles];
            popfilelist = new String[finalfiles];
            String[] popblocklist = new String[finalfiles];

            // Array.Sort(frequency);
            String[] finalfileslist = frequency.Distinct().ToArray();
            int n1 = finalfileslist.Length - 1;

            while (m1 < finalfiles)
            {
                String[] popfiles = finalfileslist[n1].Split(':');
                n1--;
                popfilelist[m1] = popfiles[2];

                String[] s13 = popfilelist[m1].Split('F');
                popblocklist[m1] = popfilelist[m1] + " " + frequency3[Convert.ToInt32(s13[1])];
                m1++;
            }
            System.out.println(popfilelist[0]);

            String[] popblocksforfile = new String[count5];
            // String[] popblocksforfile1 = new String[count5];
            int count1 = 0;
            int supp1 = 0;

            for (int o = 0; o < popfilelist.Length; o++)
            {

                String[] supblock = popblocklist[o].TrimEnd().Split(' ');
                for (int p = 3; p < supblock.Length; p++)
                {
                    supp1 = CountStringOccurrences(popblocklist[o].TrimEnd(), supblock[p].Trim());
                    //popblocksforfile[count1] = supblock[0] + " " + supp + " " + supblock[p];
                    double blobsup = (supp1 * 100.0000) / Convert.ToInt32(supblock[1]);

                    // popblocksforfile[count1] = supblock[0] + " " + supblock[1] + " " + supblock[2] + " " + supp + " " + supblock[p];
                    //double blobsup = (supp * 100.0000) / Convert.ToInt32(supblock[1]);
                    averagesess = Convert.ToInt32(supblock[2]) / Convert.ToInt32(supblock[1]);

                    popblocksforfile[count1] = blobsup + " " + supblock[0] + " " + supblock[p] + " " + averagesess + " " + supblock[2];
                    count1++;
                    // list.Add(new KeyValuePair<double, String>(blobsup, supblock[0] + " " + supblock[p] + " " + averagesess + " " + supblock[2]));
                }
                String[] finalfileslist1 = popblocksforfile.Distinct().ToArray();

                for (int mne = 0; mne < finalfileslist1.Length - 1; mne++)
                {
                    String[] res = finalfileslist1[mne].Split(' ');
                    list.Add(new KeyValuePair<double, String>(Convert.ToDouble(res[0]), res[1] + " " + res[2] + " " + res[3] + " " + res[4]));
                }
                count1 = 0;
                Array.Clear(popblocksforfile, 0, popblocksforfile.Length);
                //  list1.Sort(Compare1);
                list.Sort(Compare1);
                String s = list[0].ToString();
                String[] sa = s.Split(' ');
                String log = "DN" + su + " " + sa[1];

                using (StreamWriter sw =
       File.AppendText("e:\\DataNode1.txt"))
                {
                    for (int mo = 0; mo < averagesess; mo++)
                    {
                        String sb = list[mo].ToString();
                        String[] sa1 = sb.Split(' ');
                        String[] sa3 = sa1[2].Split('B');

                        if (log.Contains(sa3[1]))
                        {
                            averagesess++;

                        }
                        else
                        {
                            //           String[] sa2 = sa1[2].Split('B');
                            log += " " + sa3[1];
                        }
                    }
                    sw.WriteLine(log);
                    list.Clear();


                    /*                for (int o = 0; o < popfilelist.Length; o++)
                                    {
                                        fcheck = " ";
                                        String[] supblock = popblocklist[o].TrimEnd().Split(' ');
                                        for (int p = 3; p < supblock.Length; p++)
                                        {
                                            supp1 = CountStringOccurrences(popblocklist[o].TrimEnd(), supblock[p].Trim());
                                            //popblocksforfile[count1] = supblock[0] + " " + supp + " " + supblock[p];
                                            double blobsup = (supp1 * 100.0000) / Convert.ToInt32(supblock[1]);

                                            // popblocksforfile[count1] = supblock[0] + " " + supblock[1] + " " + supblock[2] + " " + supp + " " + supblock[p];
                                            //double blobsup = (supp * 100.0000) / Convert.ToInt32(supblock[1]);
                                            averagesess = Convert.ToInt32(supblock[2]) / Convert.ToInt32(supblock[1]);

                                            popblocksforfile[count1] = blobsup + " " + supblock[0] + " " + supblock[p] + " " + averagesess + " " + supblock[2];
                                            count1++;
                                            list.Add(new KeyValuePair<double, String>(blobsup, supblock[0] + " " + supblock[p] + " " + averagesess + " " + supblock[2]));
                                            list.Distinct();
                                        }
                                        list.Sort(Compare1);
                                        String s = list[0].ToString();
                                        String[] sa = s.Split(' ');
                                        String log = "DN" + su + " " + sa[1];
                                        if (fcheck.Contains(sa[1]))
                                        {
                                            o--;
                                        }
                                        else
                                        {
                                            fcheck += sa[1] + " ";
                                            using (StreamWriter sw =
                                   File.AppendText("e:\\DataNode.txt"))
                                            {
                                                for (int mo = 0; mo < averagesess; mo++)
                                                {
                                                    String sb = list[mo].ToString();
                                                    String[] sa1 = sb.Split(' ');
                                                    String[] sa3 = sa1[2].Split('B');
                                                    if (log.Contains(sa3[1]))
                                                    {
                                                        averagesess++;
                                                    }
                                                    else
                                                    {
                                                        String[] sa2 = sa1[2].Split('B');
                                                        log += " " + sa2[1];
                                                    }
                                                }
                                                sw.WriteLine(log);
                                                list.Clear();
                                            }*/
                }
            }
        }
    }

    public static void calculate()
    {
        var list = new List<KeyValuePair<double, String>>();
        var list1 = new List<KeyValuePair<double, String>>();

        int finalfiles = 0;
        System.out.println("please be patient while Support has been calculating");
        String[] frequency = new String[files + 4];
        String[] frequency2 = new String[files + 4];
        String[] frequency3 = new String[files + 4];

        int k = 0;
        int l = 0;
        String[] logsupport = new String[100000];
        using (StreamReader sr = File.OpenText("e:\\newlogs.txt"))
        {
            String s = String.Empty;
            while ((s = sr.readLine()) != null)
            {
                logsupport[l] = s;
                l++;
            }
        }

        for (int a = 0; a < l; a++)
        {
            list.Clear();
            int count = 0;
            k++;
            String[] s11 = logsupport[a].Split(' ');
            String requested = s11[3];
            averagelen += s11.Length;
            String[] s12 = requested.Split('F');
            frequency1[Convert.ToInt32(s12[1])] += 1;
            int s13 = logsupport[a].IndexOf(requested);
            String s14 = logsupport[a].SubString(s13 + requested.Length + 1);
            frequency2[Convert.ToInt32(s12[1])] += s14;
            //frequency[Convert.ToInt32(s12[1])] = frequency1[Convert.ToInt32(s12[1])] + ":F";
        }
        int count5 = 0;
        for (int d = 0; d < frequency1.Length; d++)
        {
            double supp = (frequency1[d] * 100.000000) / 100000.000000;
            if (frequency1[d] > 0)
                frequency[d] = supp.ToString() + ":" + frequency1[d] + ":F" + d;
            if (frequency2[d] != null)
            {
                int len = frequency2[d].Length - 1;
                count5 += len;
                frequency3[d] = frequency1[d] + " " + len + " " + frequency2[d] + "F" + d;
            }
        }
        int avglen = averagelen / l;
        finalfiles = 1000 / avglen;

        if (finalfiles == 0)
            finalfiles = 2;
        Array.Sort(frequency);

        int m1 = 0;
        // int count5 = 0;

        //  String[] popblocks = new String[finalfiles];
        popfilelist = new String[finalfiles];
        String[] popblocklist = new String[finalfiles];

        // Array.Sort(frequency);
        String[] finalfileslist = frequency.Distinct().ToArray();
        int n1 = finalfileslist.Length - 1;

        while (m1 < finalfiles)
        {
            String[] popfiles = finalfileslist[n1].Split(':');
            n1--;
            popfilelist[m1] = popfiles[2];

            String[] s13 = popfilelist[m1].Split('F');
            popblocklist[m1] = popfilelist[m1] + " " + frequency3[Convert.ToInt32(s13[1])];
            m1++;
        }
        System.out.println(popfilelist[0]);

        String[] popblocksforfile = new String[count5];
        // String[] popblocksforfile1 = new String[count5];
        int count1 = 0;
        int supp1 = 0;
        for (int o = 0; o < popfilelist.Length; o++)
        {

            String[] supblock = popblocklist[o].TrimEnd().Split(' ');
            for (int p = 3; p < supblock.Length; p++)
            {
                supp1 = CountStringOccurrences(popblocklist[o].TrimEnd(), supblock[p].Trim());
                //popblocksforfile[count1] = supblock[0] + " " + supp + " " + supblock[p];
                double blobsup = (supp1 * 100.0000) / Convert.ToInt32(supblock[1]);

                // popblocksforfile[count1] = supblock[0] + " " + supblock[1] + " " + supblock[2] + " " + supp + " " + supblock[p];
                //double blobsup = (supp * 100.0000) / Convert.ToInt32(supblock[1]);
                averagesess = Convert.ToInt32(supblock[2]) / Convert.ToInt32(supblock[1]);

                popblocksforfile[count1] = blobsup + " " + supblock[0] + " " + supblock[p] + " " + averagesess + " " + supblock[2];
                count1++;
                // list.Add(new KeyValuePair<double, String>(blobsup, supblock[0] + " " + supblock[p] + " " + averagesess + " " + supblock[2]));
            }
            String[] finalfileslist1 = popblocksforfile.Distinct().ToArray();

            for (int mne = 0; mne < finalfileslist1.Length - 1; mne++)
            {
                String[] res = finalfileslist1[mne].Split(' ');
                list.Add(new KeyValuePair<double, String>(Convert.ToDouble(res[0]), res[1] + " " + res[2] + " " + res[3] + " " + res[4]));
            }
            count1 = 0;
            Array.Clear(popblocksforfile, 0, popblocksforfile.Length);
            //  list1.Sort(Compare1);
            list.Sort(Compare1);
            String s = list[0].ToString();
            String[] sa = s.Split(' ');
            String log = sa[1];

            using (StreamWriter sw =
   File.AppendText("e:\\globallogs1.txt"))
            {
                for (int mo = 0; mo < averagesess; mo++)
                {
                    String sb = list[mo].ToString();
                    String[] sa1 = sb.Split(' ');
                    String[] sa3 = sa1[2].Split('B');

                    if (log.Contains(sa3[1]))
                    {
                        averagesess++;

                    }
                    else
                    {
                        //           String[] sa2 = sa1[2].Split('B');
                        log += " " + sa3[1];
                    }
                }
                sw.WriteLine(log);
                list.Clear();
            }
        }
        //  Array.Sort(popblocksforfile);
        //Array.Reverse(popblocksforfile);
        //            String[] finalblocks = popblocksforfile.Distinct().ToArray();
        int count12 = 0;
        // String log = "";
        /*    using (StreamWriter sw =
File.AppendText("e:\\globallogs.txt"))
            {
            for(int mn=0;mn<finalblocks.Length;mn++)
            {
                String[] blocksdet = finalblocks[mn].Split(' ');
                count12++;
                if (count12 == Convert.ToInt32(blocksdet[3]))
                {
                    count12 = 0;
                    //q = finalblocks.Length + 1;
                    sw.WriteLine(log);
                }

            }
     
          
            }*/
        /*  for (int a = 0; a < logsupport.Length; a++)
        {
            
            int count = 0;
            k++;
            String[] s11 = logsupport[a].Split(' ');
            String requested = s11[3];
            int c = 0;
            int checking = 1;
            while (c < frequency.Length && frequency[c] != null)
            {
                String[] che = frequency[c].Split(' ');
                if (che.Length > 1 && che[2] == requested)
                {
                    checking = 0;
                    c = frequency.Length + 1;
                }
                else
                {
                    checking = 1;
                }
                c++;
            }

            if (checking == 1)
            {
                for (int b = a; b < logsupport.Length; b++)
                {
                    String[] s1 = logsupport[b].Split(' ');
                    if(a==0)
                    averagelen += s1.Length;
                    if (s1[3] == requested)
                    {
                        count++;
                    }
                }
               
                double supp = (count * 100.000000) / 100000.000000;
                frequency[k] = supp.ToString() + ":" + count + ":" + requested;
            }
        }
        int avglen = averagelen / 100000;
        finalfiles = 5000 / avglen;*/
        /*while (k < files + 1)
            {
               // int averagelen = 0;
                int count = 0;
                k++;

                String requested = "F" + k;
                using (StreamReader sr = File.OpenText("e:\\logsup.txt"))
                {
                    String s = String.Empty;
                    while ((s = sr.readLine()) != null)
                    {
                        String[] s1 = s.Split(' ');
                        averagelen += s1.Length;
                        if (s1[3] == requested)
                        {
                            count++;
                        }
                    }
             for (int b = 0; b < logsupport.Length; b++)
                    {
                        String[] s1 = logsupport[b].Split(' ');
                   
                        averagelen += s1.Length;
                        if (s1[3] == requested)
                        {
                            count++;
                        }
                    }
                    double supp = (count * 100.000000) / 100000.000000;

                    frequency[k] = supp.ToString() + ":" + count + ":" + requested;
                }
                int avglen = averagelen / 100000;
                finalfiles = 5000 / avglen;
            
        Array.Sort(frequency);

        String[] popblocks = new String[finalfiles];
        popfilelist = new String[finalfiles];

        int m = 0;
        int n = frequency.Length - 1;
        int count5 = 0;
        while (m < finalfiles)
        {
            String allblocks = "";
            String[] popfiles = frequency[n].Split(':');
            n--;
            popfilelist[m] = popfiles[2];
            int count2 = 0;
            int avgblocks = 0;
            // using (StreamReader sr = File.OpenText("e:\\logsup.txt"))
            //{
            //String s = String.Empty;
            for (int f = 0; f < logsupport.Length; f++)
            {

                String[] s1 = logsupport[f].Split(' ');
                count5++;
                if (s1[3] == popfiles[2])
                {
                    int count = 4;
                    while (count < s1.Length)
                    {
                        avgblocks += s1.Length;
                        allblocks += s1[count].Trim() + " ";
                        count++;
                        count2++;
                    }


                }
            }
            popblocks[m] = popfiles[2] + " " + count2 + " " + avgblocks + " " + allblocks;
            m++;
        }
        int count1 = 0;
        String[] popblocksforfile = new String[count5];
        String[] popblocksforfile1 = new String[count5];
        for (int o = 0; o < popblocks.Length; o++)
        {
            String[] supblock = popblocks[o].TrimEnd().Split(' ');
            for (int p = 3; p < supblock.Length; p++)
            {
                int supp = CountStringOccurrences(popblocks[o].TrimEnd(), supblock[p].Trim());

                popblocksforfile[count1] = supblock[0] + " " + supblock[1] + " " + supblock[2] + " " + supp + " " + supblock[p];
                double blobsup = (supp * 100.0000) / Convert.ToInt32(supblock[1]);
                averagesess = Convert.ToInt32(supblock[2]) / Convert.ToInt32(supblock[1]);
                popblocksforfile1[count1] = supblock[0] + " " + blobsup + " " + supblock[p] + " " + averagesess;
                count1++;

            }

        }

        Array.Sort(popblocksforfile);
        Array.Reverse(popblocksforfile);

        Array.Sort(popblocksforfile1);
        Array.Reverse(popblocksforfile1);
        String[] finalblocks = popblocksforfile1.Distinct().ToArray();
        int q = 0;
        String log = "";
        int count12 = 0;
        int r = 0;

        while (r < popfilelist.Length)
        {
            log = "";
            boolean success = false;
            q = 0;
            while (q < finalblocks.Length && finalblocks[q] != null)
            {
                String[] blocksdet = finalblocks[q].Split(' ');
                success = true;
                if (popfilelist[r] == blocksdet[0])
                {
                    if (count12 == 0)
                    {
                        log = blocksdet[0] + " ";
                    }
                    else
                    {
                        log += blocksdet[2] + " ";
                    }
                    count12++;
                    if (count12 == Convert.ToInt32(blocksdet[3]))
                    {
                        count12 = 0;
                        success = false;
                        r++;
                        q = finalblocks.Length + 1;
                    }


                }
                q++;
            }
         * */


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
    
    static int Compare1(KeyValuePair<double, String> a, KeyValuePair<double, String> b)
    {
        return b.Key.CompareTo(a.Key);
    }
  

}
