package Lastfinding.scalability;

import java.util.Properties;
import java.util.UUID;
import org.jclouds.ContextBuilder;
import org.jclouds.logging.slf4j.config.SLF4JLoggingModule;
import org.jclouds.openstack.nova.v2_0.NovaApi;
import org.jclouds.openstack.nova.v2_0.domain.ServerCreated;
import org.jclouds.openstack.nova.v2_0.features.ServerApi;
import org.jclouds.openstack.nova.v2_0.options.CreateServerOptions;
import com.google.common.collect.ImmutableSet;
import com.google.inject.Module; 

public class CreatWorker {

	public static String createNewWorker() throws InterruptedException {

//		System.out.println("No. of tasks= "+b);

//		String userdata = "#!/bin/bash \n" + "cd /home/ubuntu/" +"\n"+"sudo java Worker > Test";
//		Iterable<Module> modules = ImmutableSet.<Module>of(new SLF4JLoggingModule());
//		 ServerApi serverApi=null;
//		NovaApi novaApi =ContextBuilder.newBuilder("openstack-nova")
//		.endpoint("http://keystone.rc.nectar.org.au:5000/v2.0/")
//		.credentials("Graph:mdanwarulkaium.patwary@utas.edu.au","NDkwNzhlODU1NDEwYzg0")
//		.modules(modules)
//		.buildApi(NovaApi.class);
//		System.out.println("hi");
//		//MGRhYjE3NTExNmI4YjZl
		
		
		String userdata = "#!/bin/bash \n" + "cd /home/ubuntu/" +"\n"+"sudo java Worker > Test";
		Iterable<Module> modules = ImmutableSet.<Module>of(new SLF4JLoggingModule());
		 ServerApi serverApi=null;
		NovaApi novaApi =ContextBuilder.newBuilder("openstack-nova")
		.endpoint("https://keystone.rc.nectar.org.au:5000/v2.0")
		.credentials("Graph:mdanwarulkaium.patwary@utas.edu.au","ZGQ2N2NjNmI3MmNjZjUz")
		.modules(modules)
		.buildApi(NovaApi.class);
		System.out.println("hi");
		
		serverApi = novaApi.getServerApi("tasmania");

		String imageid= "3f39e5dc-81e8-497e-bd27-81a9aaccd383";
		String flavorid =null;

	//	if(b<6 && s<5) {

		flavorid="639b8b2a-a5a6-4aa2-8592-ca765ee7af63";
	//	}
		//else {
		//flavorid="885227de-b7ee-42af-a209-2f1ff59bc330";
		//}

		/*
		regions = novaApi.getConfiguredRegions();
		for (String region : regions) {
		ServerApi serverApi = novaApi.getServerApi(region);

		System.out.println("Servers in " + region);

		for (Server server : serverApi.listInDetail().concat()) {
		System.out.println(" " + server.getImage());
		}

		}
		*/

		String a=UUID.randomUUID().toString();
		CreateServerOptions options1= CreateServerOptions.Builder.keyPairName("Graph").
		availabilityZone("tasmania").securityGroupNames("default").userData(userdata.getBytes()); 

		//ServerApi serverApi = novaApi.getServerApi("Melbourne");
		//CreateServerOptions createNodeOptions = new CreateServerOptions();
		//createNodeOptions.keyPairName("testSparkCloud");
		// instance type is m1.small as default 
		ServerCreated screa=null;
		try {
		screa=serverApi.create(a,imageid,flavorid,options1);
		}catch(Exception e) {
			System.out.println(e.toString());
		return null;
		}

		System.out.println("serverid "+screa.getId());
		//ServerCreated serverCreated = serverApi.create("Test", "124ac81e-1878-4282-be0c-55f46c67a6d0", "1", createNodeOptions);
		while(serverApi.get(screa.getId()).getStatus().toString()!="ACTIVE")
		{
			Thread.sleep(80000);
			//System.out.println("Please have some patience");
		}
		Thread.sleep(35000);
		if(serverApi.get(screa.getId()).getAccessIPv4()!=null)
		{
		String ipaddress=serverApi.get(screa.getId()).getAccessIPv4(); 
		System.out.println("Created");
		return ipaddress+"ID_"+screa.getId();
		}
		else
		return null;
		}

	public static String createMediumNewWorker() throws InterruptedException {

//		System.out.println("No. of tasks= "+b);

		String userdata = "#!/bin/bash \n" + "cd /home/ubuntu/" +"\n"+"sudo java Worker > Test";
		Iterable<Module> modules = ImmutableSet.<Module>of(new SLF4JLoggingModule());
		 ServerApi serverApi=null;
		NovaApi novaApi =ContextBuilder.newBuilder("openstack-nova")
		.endpoint("https://keystone.rc.nectar.org.au:5000/v2.0/")
		.credentials("Graph:mdanwarulkaium.patwary@utas.edu.au","ZGQ2N2NjNmI3MmNjZjUz")
		.modules(modules)
		.buildApi(NovaApi.class);
		System.out.println("hi");

		serverApi = novaApi.getServerApi("Melbourne");

		String imageid= "3f39e5dc-81e8-497e-bd27-81a9aaccd383";
		String flavorid =null;

	//	if(b<6 && s<5) {

		//flavorid="639b8b2a-a5a6-4aa2-8592-ca765ee7af63";
	//	}
		//else {
		flavorid="885227de-b7ee-42af-a209-2f1ff59bc330";
		//}

		/*
		regions = novaApi.getConfiguredRegions();
		for (String region : regions) {
		ServerApi serverApi = novaApi.getServerApi(region);

		System.out.println("Servers in " + region);

		for (Server server : serverApi.listInDetail().concat()) {
		System.out.println(" " + server.getImage());
		}

		}
		*/

		String a=UUID.randomUUID().toString();
		CreateServerOptions options1= CreateServerOptions.Builder.keyPairName("Graph").
		availabilityZone("NCI").securityGroupNames("default").userData(userdata.getBytes()); 

		//ServerApi serverApi = novaApi.getServerApi("Melbourne");
		//CreateServerOptions createNodeOptions = new CreateServerOptions();
		//createNodeOptions.keyPairName("testSparkCloud");
		// instance type is m1.small as default 
		ServerCreated screa=null;
		try {
		screa=serverApi.create(a,imageid,flavorid,options1);
		}catch(Exception e) {
		return null;
		}

		System.out.println("serverid "+screa.getId());
		//ServerCreated serverCreated = serverApi.create("Test", "124ac81e-1878-4282-be0c-55f46c67a6d0", "1", createNodeOptions);
		while(serverApi.get(screa.getId()).getStatus().toString()!="ACTIVE")
		{
			Thread.sleep(80000);
			//System.out.println("Please have some patience");
		}
		Thread.sleep(35000);
		if(serverApi.get(screa.getId()).getAccessIPv4()!=null)
		{
		String ipaddress=serverApi.get(screa.getId()).getAccessIPv4(); 
		System.out.println("Created");
		return ipaddress+"ID_"+screa.getId();
		}
		else
		return null;
		}
	
	
	public static void main(String a[]) throws InterruptedException {
		createNewWorker();
	}

}
