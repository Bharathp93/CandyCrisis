import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class solvePuzzleAuto extends ArrayClass{
	
	public int count = 0;
	//IF ANY ERROR CHECK HASHMAP :D
	//public static HashMap<Integer,String> closedSet_hOfn_movemade = new HashMap<Integer,String>();
	//public static HashMap<Integer,HashMap<Integer,String>> closedSet_gOfn = new HashMap<Integer,HashMap<Integer,String>>();
	//public static HashMap<String, HashMap<Integer,HashMap<Integer,String>>> closedSet_parentNode = new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>();
	//public static HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>> closedSet_presentConfig = new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>();
	public HashMap<String, HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>> closedSet_Node = new HashMap<String ,HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>>();
	
	//public static HashMap<Integer,String> openSet_hOfn_movemade = new HashMap<Integer,String>();
	//public static HashMap<Integer,HashMap<Integer,String>> openSet_gOfn = new HashMap<Integer,HashMap<Integer,String>>();
	//public static HashMap<String, HashMap<Integer,HashMap<Integer,String>>> openSet_parentNode = new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>();
	//public static HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>> openSet_presentConfig = new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>();
	public HashMap<String, HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>> openSet_Node = new HashMap<String ,HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>>();
	public String a[][];
	public int sh;
	int nodeCount = 0;
	public solvePuzzleAuto(String a[][], int sh)
	{
		this.a = a;	
		this.sh = sh;
	}
	public String[] parse(String input, String regex) //changed
	{
		String parts[] = input.split(regex);
		return parts;
	}
	
	
	//checking the top and the bottom rows for the Heuristics h(n)
	public int check_top_bottom(String a1[][])
	{
		int i = 0;
		int result = 0;
		//System.out.println("Entering stage 2");
		for(int j = 0; j<5; j++)
		{
			//System.out.println("Entering stage 4");
			if(a1[i][j].equals(a1[i+2][j]))
			{
				//System.out.println("Entering stage 5");
				result = result + 1;
			}
		//System.out.println("running loop");
		}
		return (5 - result);
	}
	
	//Convert matrix to String
	public String nodeToString(String a2[][])
	{
		String presentString = "";
		for (int i=0;i<3;i++){
	        for (int j=0;j<5;j++) {
	        	presentString = presentString + a2[i][j] +" ";
	        }
	      }
		return presentString.trim();
	}
	
	//function to return index of cell
	public String cellIndex(int i, int j)
	{
		String result = "";
		if(i == 0)
		{
			if(j == 0)
			{
				result = "A";
			}
			else if(j == 1)
			{
				result = "B";
			}
			else if(j == 2)
			{
				result = "C";
			}
			else if(j == 3)
			{
				result = "D";
			}
			else if(j == 4)
			{
				result = "E";
			}
		}
		else if(i == 1)
		{
			if(j == 0)
			{
				result = "F";
			}
			else if(j == 1)
			{
				result = "G";
			}
			else if(j == 2)
			{
				result = "H";
			}
			else if(j == 3)
			{
				result = "I";
			}
			else if(j == 4)
			{
				result = "J";
			}
		}
		else if(i == 2)
		{
			if(j == 0)
			{
				result = "K";
			}
			else if(j == 1)
			{
				result = "L";
			}
			else if(j == 2)
			{
				result = "M";
			}
			else if(j == 3)
			{
				result = "N";
			}
			else if(j == 4)
			{
				result = "O";
			}
		}
		return result.trim();
	}
	
	
	//getting gOfn of parent
	public int node_gOfn_closed(String a4[][])
	{
		int g = 0;
		String toStringOfNode = nodeToString(a4);
		if(!closedSet_Node.isEmpty()){
			Set<String> setd= closedSet_Node.keySet();
	 		   //System.out.println("====================");
			Iterator itd=setd.iterator();
			 while (itd.hasNext()) {
	 		    String nodeValue = (String)itd.next();
	 		   //System.out.println("node value: "+nodeValue);
	    		Set<String> s = closedSet_Node.get(nodeValue).keySet();
	 		   	Iterator it =  s.iterator();
	 		    while (it.hasNext()) {
	 		    	String str = (String)it.next();
	 		    	//System.out.println(str);
	 		    	if(toStringOfNode.equals(str))
					{
	 		    		Set<String> s1 = closedSet_Node.get(nodeValue).get(toStringOfNode).keySet();
		 		    	Iterator it1 = s1.iterator();
		 		    	while (it1.hasNext()){
		 		    		String str1 = (String)it1.next();
		 	 	 		   	//System.out.println(str1);
		 		    		Set<Integer> i1 = closedSet_Node.get(nodeValue).get(toStringOfNode).get(str1).keySet();
				 		    Iterator it2 = i1.iterator();
				 		    while (it2.hasNext()){
				 		    	int int1 = (int)it2.next();
				 		    	g = int1;
				 		    }
		 		    	}
					}
	 		    }
			 }
		    }
		return g;
	}
	public int node_gOfn_open(String a4[][])
	{
		int g = 0;
		String toStringOfNode = nodeToString(a4);
		if(!openSet_Node.isEmpty()){
			Set<String> setd= openSet_Node.keySet();
			Iterator itd=setd.iterator();
			 while (itd.hasNext()) {
	 		    String nodeValue = (String)itd.next();
	    		Set<String> s = openSet_Node.get(nodeValue).keySet();
	 		   	Iterator it =  s.iterator();
	 		    while (it.hasNext()) {
	 		    	String str = (String)it.next();
	 		    	if(toStringOfNode.equals(str))
					{
	 		    		Set<String> s1 = openSet_Node.get(nodeValue).get(toStringOfNode).keySet();
		 		    	Iterator it1 = s1.iterator();
		 		    	while (it1.hasNext()){
		 		    		String str1 = (String)it1.next();
		 		    		Set<Integer> i1 = openSet_Node.get(nodeValue).get(toStringOfNode).get(str1).keySet();
				 		    Iterator it2 = i1.iterator();
				 		    while (it2.hasNext()){
				 		    	int int1 = (int)it2.next();
				 		    	g = int1;
				 		    }
		 		    	}
					}
	 		    }
			 }
		    }
		return g;
	}
	
	//obtaining the h(n) of the node
	public int node_hOfn(String a4[][])
	{
		int g = 0;
		String toStringOfNode = nodeToString(a4);
		if(!closedSet_Node.isEmpty()){
			Set<String> setd= closedSet_Node.keySet();
			Iterator itd=setd.iterator();
			 while (itd.hasNext()) {
	 		    String nodeValue = (String)itd.next();
	    		Set<String> s = closedSet_Node.get(nodeValue).keySet();
	 		   	Iterator it =  s.iterator();
	 		    while (it.hasNext()) {
	 		    	String str = (String)it.next();
	 		    	if(toStringOfNode.equals(str))
					{
	 		    		Set<String> s1 = closedSet_Node.get(nodeValue).get(toStringOfNode).keySet();
		 		    	Iterator it1 = s1.iterator();
		 		    	while (it1.hasNext()){
		 		    		String str1 = (String)it1.next();
		 		    		Set<Integer> i1 = closedSet_Node.get(nodeValue).get(toStringOfNode).get(str1).keySet();
				 		    Iterator it2 = i1.iterator();
				 		    while (it2.hasNext()){
				 		    	int int1 = (int)it2.next();
				 		    	Set<Integer> i2 = closedSet_Node.get(nodeValue).get(toStringOfNode).get(str1).get(int1).keySet();
					 		    Iterator it3 = i2.iterator();
					 		    while (it3.hasNext()){
					 		    	int int2 = (int)it3.next();
					 		    	g = int2;
					 		    }
				 		    }
		 		    	}
					}
	 		    }
			 }
		    }
		return g;
	}
	
	//getting the node ID
	public String Node_Id(String a4[][])
	{
		String g = "";
		String toStringOfNode = nodeToString(a4);
		if(!closedSet_Node.isEmpty()){
			Set<String> setd= closedSet_Node.keySet();
			Iterator itd=setd.iterator();
			 while (itd.hasNext()) {
	 		    String nodeValue = (String)itd.next();
	    		Set<String> s = closedSet_Node.get(nodeValue).keySet();
	 		   	Iterator it =  s.iterator();
	 		    while (it.hasNext()) {
	 		    	String str = (String)it.next();
	 		    	if(toStringOfNode.equals(str))
					{
	 		    		g = nodeValue;
					}
	 		    }
			 }
		    }
		return g.trim();
	}
	
	// getting the parent node 
	public String parent_NodeId(String a4)
	{
		String g = "";
		if(!openSet_Node.isEmpty()){
			Set<String> setd= openSet_Node.keySet();
			Iterator itd=setd.iterator();
			 while (itd.hasNext()) {
	 		    String nodeValue = (String)itd.next();
		 		//System.out.println("node value: "+nodeValue);
	 		    if(nodeValue.equals(a4))
	 		    {
		    		Set<String> s = openSet_Node.get(nodeValue).keySet();
		 		   	Iterator it =  s.iterator();
		 		    while (it.hasNext()) {
		 		    	String str = (String)it.next();
		 	 		   	//System.out.println("string: "+str);
		 		    	Set<String> s1 = openSet_Node.get(nodeValue).get(str).keySet();
			 		    Iterator it1 = s1.iterator();
			 		    while (it1.hasNext()){
			 		    	String str2 = (String)it1.next();
			 	 		   	//System.out.println("parent node: "+str2);
			 		    	g = str2;	
				    	}
					}
	 		    }
	 	    }
		}
		return g.trim();
	}
	
	
	public String node_Config(String a4)
	{
		String g = "";
		if(!openSet_Node.isEmpty()){
			Set<String> setd= openSet_Node.keySet();
			Iterator itd=setd.iterator();
			 while (itd.hasNext()) {
	 		    String nodeValue = (String)itd.next();
		 		//System.out.println("node value: "+nodeValue);
	 		   if(nodeValue.equals(a4))
	 		    {
		    		Set<String> s = openSet_Node.get(nodeValue).keySet();
		 		   	Iterator it =  s.iterator();
		 		    while (it.hasNext()) {
		 		    	String str = (String)it.next();
		 	 		   	//System.out.println("string: "+str);;
			 	 		   	//System.out.println("parent node: "+str2);
			 		    	g = str;	
				    	
					}
	 		    }
	 	    }
		}
		return g.trim();
	}
	
	public boolean isPresent_closedSet(String input)
	{
		boolean result = false;
		if(!closedSet_Node.isEmpty()){
			Set<String> setd= closedSet_Node.keySet();
			Iterator itd=setd.iterator();
			 while (itd.hasNext()) {
	 		    String nodeValue = (String)itd.next();
		    		Set<String> s = closedSet_Node.get(nodeValue).keySet();
		 		   	Iterator it =  s.iterator();
		 		    while (it.hasNext()) {
		 		    	String str = (String)it.next();
		 		    	if(input.equals(str))
			 		    {
			 		    	result = true;
			 		    }
		 		    }
	 	    }
		}
		return result;
		
	}
	
	
	public boolean isPresent_openSet(String input)
	{
		boolean result = false;
		if(!openSet_Node.isEmpty()){
			Set<String> setd= openSet_Node.keySet();
			Iterator itd=setd.iterator();
			 while (itd.hasNext()) {
	 		    String nodeValue = (String)itd.next();
		    		Set<String> s = openSet_Node.get(nodeValue).keySet();
		 		   	Iterator it =  s.iterator();
		 		    while (it.hasNext()) {
		 		    	String str = (String)it.next();
		 		    	if(input.equals(str))
			 		    {
			 		    	result = true;
			 		    }
		 		    }
	 	    }
		}
		return result;
		
	}
	
	
	public String node_Id(String input)
	{
		String result = "";
		if(!closedSet_Node.isEmpty()){
			Set<String> setd= closedSet_Node.keySet();
			Iterator itd=setd.iterator();
			 while (itd.hasNext()) {
	 		    String nodeValue = (String)itd.next();
		    		Set<String> s = closedSet_Node.get(nodeValue).keySet();
		 		   	Iterator it =  s.iterator();
		 		    while (it.hasNext()) {
		 		    	String str = (String)it.next();
		 		    	if(input.equals(str))
			 		    {
			 		    	result = nodeValue;
			 		    }
		 		    }
	 	    }
		}
		return result.trim();
		
	}
	
	
	public String node_Id_open(String input)
	{
		String result = "";
		if(!openSet_Node.isEmpty()){
			Set<String> setd= openSet_Node.keySet();
			Iterator itd=setd.iterator();
			 while (itd.hasNext()) {
	 		    String nodeValue = (String)itd.next();
		    		Set<String> s = openSet_Node.get(nodeValue).keySet();
		 		   	Iterator it =  s.iterator();
		 		    while (it.hasNext()) {
		 		    	String str = (String)it.next();
		 		    	if(input.equals(str))
			 		    {
			 		    	result = nodeValue;
			 		    }
		 		    }
	 	    }
		}
		return result.trim();
		
	}
	//==================================================A* implementation================================
	public String A_star()
	{	
		String output = "";
		//System.out.println("ENTRY 4");
		while (!openSet_Node.isEmpty())
		{
			
			//checking open set for node with minimum fOfn
			int minimum_fOfn = 100*99*333;
	        String child_Node = "";
	        String child_config = "";
	        String child_Parent = "";
	        int child_hOfn = -1;
	        int child_gOfn = -1;
	        String child_moveMade = "";
			if(!openSet_Node.isEmpty()){
				Set<String> setd= openSet_Node.keySet();
				Iterator itd=setd.iterator();
				 while (itd.hasNext()) {
		 		    String nodeValue = (String)itd.next();
		    		Set<String> s = openSet_Node.get(nodeValue).keySet();
		 		   	Iterator it =  s.iterator();
		 		    while (it.hasNext()) {
		 		    	String str = (String)it.next();
		 		    	Set<String> s1 = openSet_Node.get(nodeValue).get(str).keySet();
			 		    Iterator it1 = s1.iterator();
			 		    while (it1.hasNext()){
			 		    	String str2 = (String)it1.next();
			 		    	Set<Integer> i1 = openSet_Node.get(nodeValue).get(str).get(str2).keySet();
				 		    Iterator it2 = i1.iterator();
				 		    while (it2.hasNext()){
				 		    	int int1 = (int)it2.next();
				 		    	Set<Integer> i2 = openSet_Node.get(nodeValue).get(str).get(str2).get(int1).keySet();
					 		    Iterator it3 = i2.iterator();
					 		    while (it3.hasNext()){
					 		    	int int2 = (int)it3.next();
					 		    	
					 		    	
					 		    	if(int2 == 0)
					 		    	{
					 		    		/*System.out.println("****************************************");
					 		    		minimum_fOfn = int2 + int1;
					 		    		child_Node = nodeValue;
					 			        child_config = str;
					 			        child_Parent = str2;
					 			        child_gOfn = int1;
					 			        child_hOfn = int2;
					 			        child_moveMade = openSet_Node.get(nodeValue).get(str).get(str2).get(int1).get(int2);
					 			       System.out.println("NODE: "+child_Node);
						 		    	System.out.println("CONFIG: "+child_config);
						 		    	System.out.println("PARENT: "+child_Parent);
						 		    	System.out.println("g(n): "+child_gOfn);
						 		    	System.out.println("h(n): "+child_hOfn);
						 		    	System.out.println("move: " +child_moveMade);
					 		    		System.out.println("SYSTEM OUT");
					 		    		System.out.println("****************************************");*/
					 		    		output = nodeValue;
					 		    		return output;
					 		    	
					 		    	}
					 		    	else if((int2 + int1) < minimum_fOfn)/// WE NEED min H(N) not f(n)
					 		    	{
					 		    		//System.out.println("ENTRY 5");
					 		    		minimum_fOfn = int2 + int1;
					 		    		child_Node = nodeValue;
					 			        child_config = str;
					 			        child_Parent = str2;
					 			        child_gOfn = int1;
					 			        child_hOfn = int2;
					 			        child_moveMade = openSet_Node.get(nodeValue).get(str).get(str2).get(int1).get(int2);
					 			       /*System.out.println("NODE: "+child_Node);
						 		    	System.out.println("CONFIG: "+child_config);
						 		    	System.out.println("PARENT: "+child_Parent);
						 		    	System.out.println("g(n): "+child_gOfn);
						 		    	System.out.println("h(n): "+child_hOfn);
						 		    	System.out.println("move: " +child_moveMade);*/
					 			        //String int3 = openSet_Node.get(nodeValue).get(str).get(str2).get(int1).get(int2);
							 		    //Iterator it1 = s1.iterator();
							 		    //while (it1.hasNext()){
							 		    	//int int1 = (int)it1.next();
							 		    //}
					 		    	}
					 		    }
				 		    }	
				    	}
					}
		 	    }
			}
			
			
			//else//check if else needed
			//System.out.println(child_Node);
			if(child_Node != null)
			{
				int i = 0, j = 0;
				int hOfn_b1, hOfn_b2 ,hOfn_b3 ,hOfn_b4 ,gOfn_b1 ,gOfn_b2 ,gOfn_b3 ,gOfn_b4;
		        String nodeToStr_b1 = "" ,nodeToStr_b2 = "" ,nodeToStr_b3 = "" ,nodeToStr_b4 = "" ;
		        int nodeCount_b1 ,nodeCount_b2,nodeCount_b3 ,nodeCount_b4;
		        
				closedSet_Node.put(child_Node, new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
				closedSet_Node.get(child_Node).put(child_config, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
				closedSet_Node.get(child_Node).get(child_config).put(child_Parent, new HashMap<Integer,HashMap<Integer,String>>());
				closedSet_Node.get(child_Node).get(child_config).get(child_Parent).put(child_gOfn, new HashMap<Integer,String>());
				closedSet_Node.get(child_Node).get(child_config).get(child_Parent).get(child_gOfn).put(child_hOfn, child_moveMade);
				openSet_Node.remove(child_Node);
				
				//System.out.println("ENTRY 6");
				//get the next possible moves for the current added node
				String parsed[] = parse(child_config.trim(), " ");
				String[][] arr = new String [3][5];
				//System.out.println("ENTRY 6.1");
		    	int k = 0;
		        for (int p=0;p<3;p++){
		            for (int q=0;q<5;q++) {
		                arr[p][q]= parsed[k].trim();
		                if(parsed[k].equals("e"))
		                {
		                	i = p;
		                	j = q;
		                }
		            	k++;
		            	
		            }
		        }
		      /*  System.out.println(node_Id(child_config));
		      for (int x=0;x<3;x++){
	                for (int y=0;y<5;y++) {
	                    
	                	System.out.print(arr[x][y] +" ");
	                }
	                System.out.println();
		        }

                System.out.println("================");*/
		        //System.out.println("ENTRY 6.2");
		        String parentNode = child_Node;   
		        if(i == 0)
				{ //System.out.println("ENTRY 7");
					if(j == 0)
					{
						String b1[][] = new String[3][5];
						String b2[][] = new String[3][5];
				        for (int i1 = 0; i1 < 3; i1++) 
				        	for (int j1 = 0; j1 < 5; j1++){
				        		b1[i1][j1] = arr[i1][j1];
				        		b2[i1][j1] = arr[i1][j1];
				        }
				        
				        b1[0][0] = b1[0][1];
				        b1[0][1] = "e";
				        b2[0][0] = b2[1][0];
				        b2[1][0] = "e";
				       
				        
				        hOfn_b1 = check_top_bottom(b1);
				        hOfn_b2 = check_top_bottom(b2);
				        gOfn_b1 = node_gOfn_closed(arr) + 1;
				        gOfn_b2 = node_gOfn_closed(arr) + 1;
				        nodeToStr_b1 = nodeToString(b1);
				        nodeToStr_b2 = nodeToString(b2);
				        nodeCount_b1 = nodeCount + 1;
				        nodeCount++;
				        nodeCount_b2 = nodeCount + 1;
				        nodeCount++;
				        
				        if(!isPresent_closedSet(nodeToStr_b1) && !isPresent_openSet(nodeToStr_b1))
				        {
				        	openSet_Node.put(Integer.toString(nodeCount_b1), new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).put(nodeToStr_b1, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).get(nodeToStr_b1).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).get(nodeToStr_b1).get(parentNode).put(gOfn_b1, new HashMap<Integer,String>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).get(nodeToStr_b1).get(parentNode).get(gOfn_b1).put(hOfn_b1, "B");
							
				        }
				        else if(!isPresent_closedSet(nodeToStr_b1) && isPresent_openSet(nodeToStr_b1))
				        {
				        	if(node_gOfn_open(b1) > gOfn_b1)
				        	{
				        		String Id = node_Id_open(nodeToStr_b1);
				        		openSet_Node.remove(Id);
				        		openSet_Node.put(Id, new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
								openSet_Node.get(Id).put(nodeToStr_b1, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
								openSet_Node.get(Id).get(nodeToStr_b1).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
								openSet_Node.get(Id).get(nodeToStr_b1).get(parentNode).put(gOfn_b1, new HashMap<Integer,String>());
								openSet_Node.get(Id).get(nodeToStr_b1).get(parentNode).get(gOfn_b1).put(hOfn_b1, "B");
								
				        	}
				        }
				        
				        if(!isPresent_closedSet(nodeToStr_b2) && !isPresent_openSet(nodeToStr_b2))
				        {
				        	openSet_Node.put(Integer.toString(nodeCount_b2), new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).put(nodeToStr_b2, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).get(nodeToStr_b2).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).get(nodeToStr_b2).get(parentNode).put(gOfn_b2, new HashMap<Integer,String>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).get(nodeToStr_b2).get(parentNode).get(gOfn_b2).put(hOfn_b2, "F");
							
				        }
				        else if(!isPresent_closedSet(nodeToStr_b2) && isPresent_openSet(nodeToStr_b2))
				        {
				        	if(node_gOfn_open(b2) > gOfn_b2)
				        	{
				        		String Id = node_Id_open(nodeToStr_b2);
				        		openSet_Node.remove(Id);
				        		openSet_Node.put(Id, new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
								openSet_Node.get(Id).put(nodeToStr_b2, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
								openSet_Node.get(Id).get(nodeToStr_b2).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
								openSet_Node.get(Id).get(nodeToStr_b2).get(parentNode).put(gOfn_b2, new HashMap<Integer,String>());
								openSet_Node.get(Id).get(nodeToStr_b2).get(parentNode).get(gOfn_b2).put(hOfn_b2, "F");
								
				        	}
				        }
				        
				        
				        
						
					}
						
				        
					
					else if(j>=1 && j<=3)
					{
						String b1[][] = new String[3][5];
						String b2[][] = new String[3][5];
						String b3[][] = new String[3][5];
						int i_b1 = -1, j_b1 = -1,i_b2 = -1, j_b2 = -1,i_b3 = -1, j_b3 = -1;
				        for (int i1 = 0; i1 < 3; i1++) 
				        	for (int j1 = 0; j1 < 5; j1++){
				        		b1[i1][j1] = arr[i1][j1];
				        		b2[i1][j1] = arr[i1][j1];
				        		b3[i1][j1] = arr[i1][j1];
				        }
				        
				        for (int m=0;m<3;m++){
					        for (int n=0;n<5;n++) {
					        	//presentString = presentString + a2[i][j] +" ";
					        	if(arr[m][n].equals("e"))
					        	{
					        		b1[m][n] = b1[m][n-1];
					 		        b1[m][n-1] = "e";
					 		        i_b1 = m;
					 		        j_b1 = n-1;
					 		        b2[m][n] = b2[m][n+1];
					 		        b2[m][n+1] = "e";
					 		        i_b2 = m;
					 		        j_b2 = n+1;
					 		        b3[m][n] = b3[m+1][n];
					 		        b3[m+1][n] = "e";
					 		        i_b3 = m+1;
					 		        j_b3 = n;
					        		break;
					        	}
					        }
					     }
				        String taken_b1 = cellIndex(i_b1, j_b1);
				        String taken_b2 = cellIndex(i_b2, j_b2);
				        String taken_b3 = cellIndex(i_b3, j_b3);
				       //System.out.println("values"+taken_b1 +taken_b2 +taken_b3);
				        
				        hOfn_b1 = check_top_bottom(b1);
				        hOfn_b2 = check_top_bottom(b2);
				        hOfn_b3 = check_top_bottom(b3);
				        gOfn_b1 = node_gOfn_closed(arr) + 1;
				        gOfn_b2 = node_gOfn_closed(arr) + 1;
				        gOfn_b3 = node_gOfn_closed(arr) + 1;
				        nodeToStr_b1 = nodeToString(b1);
				        nodeToStr_b2 = nodeToString(b2);
				        nodeToStr_b3 = nodeToString(b3);
				        nodeCount_b1 = nodeCount + 1;
				        nodeCount++;
				        nodeCount_b2 = nodeCount + 1;
				        nodeCount++;
				        nodeCount_b3 = nodeCount + 1;
				        nodeCount++;
				       
				        if(!isPresent_closedSet(nodeToStr_b1) && !isPresent_openSet(nodeToStr_b1))
				        {
				        	openSet_Node.put(Integer.toString(nodeCount_b1), new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).put(nodeToStr_b1, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).get(nodeToStr_b1).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).get(nodeToStr_b1).get(parentNode).put(gOfn_b1, new HashMap<Integer,String>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).get(nodeToStr_b1).get(parentNode).get(gOfn_b1).put(hOfn_b1, taken_b1);
							
				        }
				        else if(!isPresent_closedSet(nodeToStr_b1) && isPresent_openSet(nodeToStr_b1))
				        {
				        	if(node_gOfn_open(b1) > gOfn_b1)
				        	{
				        		String Id = node_Id_open(nodeToStr_b1);
				        		openSet_Node.remove(Id);
				        		openSet_Node.put(Id, new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
								openSet_Node.get(Id).put(nodeToStr_b1, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
								openSet_Node.get(Id).get(nodeToStr_b1).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
								openSet_Node.get(Id).get(nodeToStr_b1).get(parentNode).put(gOfn_b1, new HashMap<Integer,String>());
								openSet_Node.get(Id).get(nodeToStr_b1).get(parentNode).get(gOfn_b1).put(hOfn_b1, taken_b1);
								
				        	}
				        }
				        
				        if(!isPresent_closedSet(nodeToStr_b2) && !isPresent_openSet(nodeToStr_b2))
				        {
				        	openSet_Node.put(Integer.toString(nodeCount_b2), new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).put(nodeToStr_b2, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).get(nodeToStr_b2).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).get(nodeToStr_b2).get(parentNode).put(gOfn_b2, new HashMap<Integer,String>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).get(nodeToStr_b2).get(parentNode).get(gOfn_b2).put(hOfn_b2, taken_b2);
							
				        }
				        else if(!isPresent_closedSet(nodeToStr_b2) && isPresent_openSet(nodeToStr_b2))
				        {
				        	if(node_gOfn_open(b2) > gOfn_b2)
				        	{
				        		String Id = node_Id_open(nodeToStr_b2);
				        		openSet_Node.remove(Id);
				        		openSet_Node.put(Id, new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
								openSet_Node.get(Id).put(nodeToStr_b2, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
								openSet_Node.get(Id).get(nodeToStr_b2).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
								openSet_Node.get(Id).get(nodeToStr_b2).get(parentNode).put(gOfn_b2, new HashMap<Integer,String>());
								openSet_Node.get(Id).get(nodeToStr_b2).get(parentNode).get(gOfn_b2).put(hOfn_b2, taken_b2);
								
				        	}
				        }
				        
				        if(!isPresent_closedSet(nodeToStr_b3) && !isPresent_openSet(nodeToStr_b3))
				        {
				        	openSet_Node.put(Integer.toString(nodeCount_b3), new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
							openSet_Node.get(Integer.toString(nodeCount_b3)).put(nodeToStr_b3, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
							openSet_Node.get(Integer.toString(nodeCount_b3)).get(nodeToStr_b3).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
							openSet_Node.get(Integer.toString(nodeCount_b3)).get(nodeToStr_b3).get(parentNode).put(gOfn_b3, new HashMap<Integer,String>());
							openSet_Node.get(Integer.toString(nodeCount_b3)).get(nodeToStr_b3).get(parentNode).get(gOfn_b3).put(hOfn_b3, taken_b3);
							
				        }
				        else if(!isPresent_closedSet(nodeToStr_b3) && isPresent_openSet(nodeToStr_b3))
				        {
				        	if(node_gOfn_open(b3) > gOfn_b3)
				        	{
				        		String Id = node_Id_open(nodeToStr_b3);
				        		openSet_Node.remove(Id);
				        		openSet_Node.put(Id, new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
								openSet_Node.get(Id).put(nodeToStr_b3, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
								openSet_Node.get(Id).get(nodeToStr_b3).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
								openSet_Node.get(Id).get(nodeToStr_b3).get(parentNode).put(gOfn_b3, new HashMap<Integer,String>());
								openSet_Node.get(Id).get(nodeToStr_b3).get(parentNode).get(gOfn_b3).put(hOfn_b3, taken_b3);
								
				        	}
				        }
				        
				        
					}
					
					else if(j ==4)
					{
						String b1[][] = new String[3][5];
						String b2[][] = new String[3][5];
				        for (int i1 = 0; i1 < 3; i1++) 
				        	for (int j1 = 0; j1 < 5; j1++){
				        		b1[i1][j1] = arr[i1][j1];
				        		b2[i1][j1] = arr[i1][j1];
				        }
				        
				        b1[0][4] = b1[0][3];
				        b1[0][3] = "e";
				        b2[0][4] = b2[1][4];
				        b2[1][4] = "e";
				        
				        hOfn_b1 = check_top_bottom(b1);
				        hOfn_b2 = check_top_bottom(b2);
				        gOfn_b1 = node_gOfn_closed(arr) + 1;
				        gOfn_b2 = node_gOfn_closed(arr) + 1;
				        nodeToStr_b1 = nodeToString(b1);
				        nodeToStr_b2 = nodeToString(b2);
				        nodeCount_b1 = nodeCount + 1;
				        nodeCount++;
				        nodeCount_b2 = nodeCount + 1;
				        nodeCount++;
				        
				        if(!isPresent_closedSet(nodeToStr_b1) && !isPresent_openSet(nodeToStr_b1))
				        {
				        	openSet_Node.put(Integer.toString(nodeCount_b1), new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).put(nodeToStr_b1, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).get(nodeToStr_b1).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).get(nodeToStr_b1).get(parentNode).put(gOfn_b1, new HashMap<Integer,String>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).get(nodeToStr_b1).get(parentNode).get(gOfn_b1).put(hOfn_b1, "D");
							
				        }
				        else if(!isPresent_closedSet(nodeToStr_b1) && isPresent_openSet(nodeToStr_b1))
				        {
				        	if(node_gOfn_open(b1) > gOfn_b1)
				        	{
				        		String Id = node_Id_open(nodeToStr_b1);
				        		openSet_Node.remove(Id);
				        		openSet_Node.put(Id, new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
								openSet_Node.get(Id).put(nodeToStr_b1, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
								openSet_Node.get(Id).get(nodeToStr_b1).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
								openSet_Node.get(Id).get(nodeToStr_b1).get(parentNode).put(gOfn_b1, new HashMap<Integer,String>());
								openSet_Node.get(Id).get(nodeToStr_b1).get(parentNode).get(gOfn_b1).put(hOfn_b1, "D");
								
				        	}
				        }
				        
				        if(!isPresent_closedSet(nodeToStr_b2) && !isPresent_openSet(nodeToStr_b2))
				        {
				        	openSet_Node.put(Integer.toString(nodeCount_b2), new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).put(nodeToStr_b2, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).get(nodeToStr_b2).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).get(nodeToStr_b2).get(parentNode).put(gOfn_b2, new HashMap<Integer,String>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).get(nodeToStr_b2).get(parentNode).get(gOfn_b2).put(hOfn_b2, "J");
							
				        }
				        else if(!isPresent_closedSet(nodeToStr_b2) && isPresent_openSet(nodeToStr_b2))
				        {
				        	if(node_gOfn_open(b2) > gOfn_b2)
				        	{
				        		String Id = node_Id_open(nodeToStr_b2);
				        		openSet_Node.remove(Id);
				        		openSet_Node.put(Id, new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
								openSet_Node.get(Id).put(nodeToStr_b2, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
								openSet_Node.get(Id).get(nodeToStr_b2).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
								openSet_Node.get(Id).get(nodeToStr_b2).get(parentNode).put(gOfn_b2, new HashMap<Integer,String>());
								openSet_Node.get(Id).get(nodeToStr_b2).get(parentNode).get(gOfn_b2).put(hOfn_b2, "J");
								
				        	}
				        }
				        
					}
				}
				
				/*-------MIDDLE ROW-----*/
				
				
				else if(i == 1)
				{
					if(j == 0)
					{
						String b1[][] = new String[3][5];
						String b2[][] = new String[3][5];
						String b3[][] = new String[3][5];
				        for (int i1 = 0; i1 < 3; i1++) 
				        	for (int j1 = 0; j1 < 5; j1++){
				        		b1[i1][j1] = arr[i1][j1];
				        		b2[i1][j1] = arr[i1][j1];
				        		b3[i1][j1] = arr[i1][j1];
				        }
				        
				        b1[1][0] = b1[0][0];
				        b1[0][0] = "e";
				        b2[1][0] = b2[1][1];
				        b2[1][1] = "e";
				        b3[1][0] = b3[2][0];
				        b3[2][0] = "e";
				        
				        
				        hOfn_b1 = check_top_bottom(b1);
				        hOfn_b2 = check_top_bottom(b2);
				        hOfn_b3 = check_top_bottom(b3);
				        gOfn_b1 = node_gOfn_closed(arr) + 1;
				        gOfn_b2 = node_gOfn_closed(arr) + 1;
				        gOfn_b3 = node_gOfn_closed(arr) + 1;
				        nodeToStr_b1 = nodeToString(b1);
				        nodeToStr_b2 = nodeToString(b2);
				        nodeToStr_b3 = nodeToString(b3);
				        nodeCount_b1 = nodeCount + 1;
				        nodeCount++;
				        nodeCount_b2 = nodeCount + 1;
				        nodeCount++;
				        nodeCount_b3 = nodeCount + 1;
				        nodeCount++;
				       
				        if(!isPresent_closedSet(nodeToStr_b1) && !isPresent_openSet(nodeToStr_b1))
				        {
				        	openSet_Node.put(Integer.toString(nodeCount_b1), new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).put(nodeToStr_b1, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).get(nodeToStr_b1).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).get(nodeToStr_b1).get(parentNode).put(gOfn_b1, new HashMap<Integer,String>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).get(nodeToStr_b1).get(parentNode).get(gOfn_b1).put(hOfn_b1, "A");
							
				        }
				        else if(!isPresent_closedSet(nodeToStr_b1) && isPresent_openSet(nodeToStr_b1))
				        {
				        	if(node_gOfn_open(b1) > gOfn_b1)
				        	{
				        		String Id = node_Id_open(nodeToStr_b1);
				        		openSet_Node.remove(Id);
				        		openSet_Node.put(Id, new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
								openSet_Node.get(Id).put(nodeToStr_b1, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
								openSet_Node.get(Id).get(nodeToStr_b1).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
								openSet_Node.get(Id).get(nodeToStr_b1).get(parentNode).put(gOfn_b1, new HashMap<Integer,String>());
								openSet_Node.get(Id).get(nodeToStr_b1).get(parentNode).get(gOfn_b1).put(hOfn_b1, "A");
								
				        	}
				        }
				        
				        if(!isPresent_closedSet(nodeToStr_b2) && !isPresent_openSet(nodeToStr_b2))
				        {
				        	openSet_Node.put(Integer.toString(nodeCount_b2), new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).put(nodeToStr_b2, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).get(nodeToStr_b2).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).get(nodeToStr_b2).get(parentNode).put(gOfn_b2, new HashMap<Integer,String>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).get(nodeToStr_b2).get(parentNode).get(gOfn_b2).put(hOfn_b2, "G");
							
				        }
				        else if(!isPresent_closedSet(nodeToStr_b2) && isPresent_openSet(nodeToStr_b2))
				        {
				        	if(node_gOfn_open(b2) > gOfn_b2)
				        	{
				        		String Id = node_Id_open(nodeToStr_b2);
				        		openSet_Node.remove(Id);
				        		openSet_Node.put(Id, new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
								openSet_Node.get(Id).put(nodeToStr_b2, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
								openSet_Node.get(Id).get(nodeToStr_b2).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
								openSet_Node.get(Id).get(nodeToStr_b2).get(parentNode).put(gOfn_b2, new HashMap<Integer,String>());
								openSet_Node.get(Id).get(nodeToStr_b2).get(parentNode).get(gOfn_b2).put(hOfn_b2, "G");
								
				        	}
				        }
				        
				        if(!isPresent_closedSet(nodeToStr_b3) && !isPresent_openSet(nodeToStr_b3))
				        {
				        	openSet_Node.put(Integer.toString(nodeCount_b3), new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
							openSet_Node.get(Integer.toString(nodeCount_b3)).put(nodeToStr_b3, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
							openSet_Node.get(Integer.toString(nodeCount_b3)).get(nodeToStr_b3).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
							openSet_Node.get(Integer.toString(nodeCount_b3)).get(nodeToStr_b3).get(parentNode).put(gOfn_b3, new HashMap<Integer,String>());
							openSet_Node.get(Integer.toString(nodeCount_b3)).get(nodeToStr_b3).get(parentNode).get(gOfn_b3).put(hOfn_b3, "K");
							
				        }
				        else if(!isPresent_closedSet(nodeToStr_b3) && isPresent_openSet(nodeToStr_b3))
				        {
				        	if(node_gOfn_open(b3) > gOfn_b3)
				        	{
				        		String Id = node_Id_open(nodeToStr_b3);
				        		openSet_Node.remove(Id);
				        		openSet_Node.put(Id, new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
								openSet_Node.get(Id).put(nodeToStr_b3, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
								openSet_Node.get(Id).get(nodeToStr_b3).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
								openSet_Node.get(Id).get(nodeToStr_b3).get(parentNode).put(gOfn_b3, new HashMap<Integer,String>());
								openSet_Node.get(Id).get(nodeToStr_b3).get(parentNode).get(gOfn_b3).put(hOfn_b3, "K");
								
				        	}
				        }
				        
				        
						
						
					}
						
				        
					
					else if(j>=1 && j<=3)
					{
						String b1[][] = new String[3][5];
						String b2[][] = new String[3][5];
						String b3[][] = new String[3][5];
						String b4[][] = new String[3][5];
						int i_b1 = -1, j_b1 = -1,i_b2 = -1, j_b2 = -1,i_b3 = -1, j_b3 = -1,i_b4 = -1, j_b4 = -1;
				        for (int i1 = 0; i1 < 3; i1++) 
				        	for (int j1 = 0; j1 < 5; j1++){
				        		b1[i1][j1] = arr[i1][j1];
				        		b2[i1][j1] = arr[i1][j1];
				        		b3[i1][j1] = arr[i1][j1];
				        		b4[i1][j1] = arr[i1][j1];
				        }
				        
				        for (int m=0;m<3;m++){
					        for (int n=0;n<5;n++) {
					        	//presentString = presentString + a2[i][j] +" ";
					        	if(arr[m][n].equals("e"))
					        	{
					        		b1[m][n] = b1[m][n-1];
					 		        b1[m][n-1] = "e";
					 		        i_b1 = m;
					 		        j_b1 = n-1;
					 		        b2[m][n] = b2[m][n+1];
					 		        b2[m][n+1] = "e";
					 		        i_b2 = m;
					 		        j_b2 = n+1;
					 		        b3[m][n] = b3[m+1][n];
					 		        b3[m+1][n] = "e";
					 		        i_b3 = m+1;
					 		        j_b3 = n;
					 		        b4[m][n] = b4[m-1][n];
					 		        b4[m-1][n] = "e";
					 		        i_b4 = m-1;
					 		        j_b4 = n;
					        		break;
					        	}
					        }
					     }
				        String taken_b1 = cellIndex(i_b1, j_b1);
				        String taken_b2 = cellIndex(i_b2, j_b2);
				        String taken_b3 = cellIndex(i_b3, j_b3);
				        String taken_b4 = cellIndex(i_b4, j_b4);
					       //System.out.println("values"+taken_b1 +taken_b2 +taken_b3 +taken_b4);
				        
				        hOfn_b1 = check_top_bottom(b1);
				        hOfn_b2 = check_top_bottom(b2);
				        hOfn_b3 = check_top_bottom(b3);
				        hOfn_b4 = check_top_bottom(b4);
				        gOfn_b1 = node_gOfn_closed(arr) + 1;
				        gOfn_b2 = node_gOfn_closed(arr) + 1;
				        gOfn_b3 = node_gOfn_closed(arr) + 1;
				        gOfn_b4 = node_gOfn_closed(arr) + 1;
				        nodeToStr_b1 = nodeToString(b1);
				        nodeToStr_b2 = nodeToString(b2);
				        nodeToStr_b3 = nodeToString(b3);
				        nodeToStr_b4 = nodeToString(b4);
				        nodeCount_b1 = nodeCount + 1;
				        nodeCount++;
				        nodeCount_b2 = nodeCount + 1;
				        nodeCount++;
				        nodeCount_b3 = nodeCount + 1;
				        nodeCount++;
				        nodeCount_b4 = nodeCount + 1;
				        nodeCount++;
				        
				        if(!isPresent_closedSet(nodeToStr_b1) && !isPresent_openSet(nodeToStr_b1))
				        {
				        	openSet_Node.put(Integer.toString(nodeCount_b1), new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).put(nodeToStr_b1, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).get(nodeToStr_b1).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).get(nodeToStr_b1).get(parentNode).put(gOfn_b1, new HashMap<Integer,String>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).get(nodeToStr_b1).get(parentNode).get(gOfn_b1).put(hOfn_b1, taken_b1);
							
				        }
				        else if(!isPresent_closedSet(nodeToStr_b1) && isPresent_openSet(nodeToStr_b1))
				        {
				        	if(node_gOfn_open(b1) > gOfn_b1)
				        	{
				        		String Id = node_Id_open(nodeToStr_b1);
				        		openSet_Node.remove(Id);
				        		openSet_Node.put(Id, new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
								openSet_Node.get(Id).put(nodeToStr_b1, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
								openSet_Node.get(Id).get(nodeToStr_b1).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
								openSet_Node.get(Id).get(nodeToStr_b1).get(parentNode).put(gOfn_b1, new HashMap<Integer,String>());
								openSet_Node.get(Id).get(nodeToStr_b1).get(parentNode).get(gOfn_b1).put(hOfn_b1, taken_b1);
								
				        	}
				        }
				        
				        if(!isPresent_closedSet(nodeToStr_b2) && !isPresent_openSet(nodeToStr_b2))
				        {
				        	openSet_Node.put(Integer.toString(nodeCount_b2), new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).put(nodeToStr_b2, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).get(nodeToStr_b2).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).get(nodeToStr_b2).get(parentNode).put(gOfn_b2, new HashMap<Integer,String>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).get(nodeToStr_b2).get(parentNode).get(gOfn_b2).put(hOfn_b2, taken_b2);
							
				        }
				        else if(!isPresent_closedSet(nodeToStr_b2) && isPresent_openSet(nodeToStr_b2))
				        {
				        	if(node_gOfn_open(b2) > gOfn_b2)
				        	{
				        		String Id = node_Id_open(nodeToStr_b2);
				        		openSet_Node.remove(Id);
				        		openSet_Node.put(Id, new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
								openSet_Node.get(Id).put(nodeToStr_b2, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
								openSet_Node.get(Id).get(nodeToStr_b2).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
								openSet_Node.get(Id).get(nodeToStr_b2).get(parentNode).put(gOfn_b2, new HashMap<Integer,String>());
								openSet_Node.get(Id).get(nodeToStr_b2).get(parentNode).get(gOfn_b2).put(hOfn_b2, taken_b2);
								
				        	}
				        }
				        
				        if(!isPresent_closedSet(nodeToStr_b3) && !isPresent_openSet(nodeToStr_b3))
				        {
				        	openSet_Node.put(Integer.toString(nodeCount_b3), new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
							openSet_Node.get(Integer.toString(nodeCount_b3)).put(nodeToStr_b3, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
							openSet_Node.get(Integer.toString(nodeCount_b3)).get(nodeToStr_b3).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
							openSet_Node.get(Integer.toString(nodeCount_b3)).get(nodeToStr_b3).get(parentNode).put(gOfn_b3, new HashMap<Integer,String>());
							openSet_Node.get(Integer.toString(nodeCount_b3)).get(nodeToStr_b3).get(parentNode).get(gOfn_b3).put(hOfn_b3, taken_b3);
							
				        }
				        else if(!isPresent_closedSet(nodeToStr_b3) && isPresent_openSet(nodeToStr_b3))
				        {
				        	if(node_gOfn_open(b3) > gOfn_b3)
				        	{
				        		String Id = node_Id_open(nodeToStr_b3);
				        		openSet_Node.remove(Id);
				        		openSet_Node.put(Id, new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
								openSet_Node.get(Id).put(nodeToStr_b3, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
								openSet_Node.get(Id).get(nodeToStr_b3).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
								openSet_Node.get(Id).get(nodeToStr_b3).get(parentNode).put(gOfn_b3, new HashMap<Integer,String>());
								openSet_Node.get(Id).get(nodeToStr_b3).get(parentNode).get(gOfn_b3).put(hOfn_b3, taken_b3);
								
				        	}
				        }
				        
				        if(!isPresent_closedSet(nodeToStr_b4) && !isPresent_openSet(nodeToStr_b4))
				        {
				        	openSet_Node.put(Integer.toString(nodeCount_b4), new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
							openSet_Node.get(Integer.toString(nodeCount_b4)).put(nodeToStr_b4, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
							openSet_Node.get(Integer.toString(nodeCount_b4)).get(nodeToStr_b4).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
							openSet_Node.get(Integer.toString(nodeCount_b4)).get(nodeToStr_b4).get(parentNode).put(gOfn_b4, new HashMap<Integer,String>());
							openSet_Node.get(Integer.toString(nodeCount_b4)).get(nodeToStr_b4).get(parentNode).get(gOfn_b4).put(hOfn_b4, taken_b4);
							
				        }
				        else if(!isPresent_closedSet(nodeToStr_b4) && isPresent_openSet(nodeToStr_b4))
				        {
				        	if(node_gOfn_open(b4) > gOfn_b4)
				        	{
				        		String Id = node_Id_open(nodeToStr_b4);
				        		openSet_Node.remove(Id);
				        		openSet_Node.put(Id, new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
								openSet_Node.get(Id).put(nodeToStr_b4, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
								openSet_Node.get(Id).get(nodeToStr_b4).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
								openSet_Node.get(Id).get(nodeToStr_b4).get(parentNode).put(gOfn_b4, new HashMap<Integer,String>());
								openSet_Node.get(Id).get(nodeToStr_b4).get(parentNode).get(gOfn_b4).put(hOfn_b4, taken_b4);
								
				        	}
				        }
				        
				        
				        
				        
					}
					else if(j ==4)
					{
						String b1[][] = new String[3][5];
						String b2[][] = new String[3][5];
						String b3[][] = new String[3][5];
				        for (int i1 = 0; i1 < 3; i1++) 
				        	for (int j1 = 0; j1 < 5; j1++){
				        		b1[i1][j1] = arr[i1][j1];
				        		b2[i1][j1] = arr[i1][j1];
				        		b3[i1][j1] = arr[i1][j1];
				        }
				        
				        b1[1][4] = b1[0][4];
				        b1[0][4] = "e";
				        b2[1][4] = b2[1][3];
				        b2[1][3] = "e";
				        b3[1][4] = b3[2][4];
				        b3[2][4] = "e";
				        
				        
				        hOfn_b1 = check_top_bottom(b1);
				        hOfn_b2 = check_top_bottom(b2);
				        hOfn_b3 = check_top_bottom(b3);
				        gOfn_b1 = node_gOfn_closed(arr) + 1;
				        gOfn_b2 = node_gOfn_closed(arr) + 1;
				        gOfn_b3 = node_gOfn_closed(arr) + 1;
				        nodeToStr_b1 = nodeToString(b1);
				        nodeToStr_b2 = nodeToString(b2);
				        nodeToStr_b3 = nodeToString(b3);
				        nodeCount_b1 = nodeCount + 1;
				        nodeCount++;
				        nodeCount_b2 = nodeCount + 1;
				        nodeCount++;
				        nodeCount_b3 = nodeCount + 1;
				        nodeCount++;
				        
				        if(!isPresent_closedSet(nodeToStr_b1) && !isPresent_openSet(nodeToStr_b1))
				        {
				        	openSet_Node.put(Integer.toString(nodeCount_b1), new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).put(nodeToStr_b1, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).get(nodeToStr_b1).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).get(nodeToStr_b1).get(parentNode).put(gOfn_b1, new HashMap<Integer,String>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).get(nodeToStr_b1).get(parentNode).get(gOfn_b1).put(hOfn_b1, "E");
							
				        }
				        else if(!isPresent_closedSet(nodeToStr_b1) && isPresent_openSet(nodeToStr_b1))
				        {
				        	if(node_gOfn_open(b1) > gOfn_b1)
				        	{
				        		String Id = node_Id_open(nodeToStr_b1);
				        		openSet_Node.remove(Id);
				        		openSet_Node.put(Id, new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
								openSet_Node.get(Id).put(nodeToStr_b1, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
								openSet_Node.get(Id).get(nodeToStr_b1).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
								openSet_Node.get(Id).get(nodeToStr_b1).get(parentNode).put(gOfn_b1, new HashMap<Integer,String>());
								openSet_Node.get(Id).get(nodeToStr_b1).get(parentNode).get(gOfn_b1).put(hOfn_b1, "E");
								
				        	}
				        }
				        
				        if(!isPresent_closedSet(nodeToStr_b2) && !isPresent_openSet(nodeToStr_b2))
				        {
				        	openSet_Node.put(Integer.toString(nodeCount_b2), new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).put(nodeToStr_b2, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).get(nodeToStr_b2).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).get(nodeToStr_b2).get(parentNode).put(gOfn_b2, new HashMap<Integer,String>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).get(nodeToStr_b2).get(parentNode).get(gOfn_b2).put(hOfn_b2, "I");
							
				        }
				        else if(!isPresent_closedSet(nodeToStr_b2) && isPresent_openSet(nodeToStr_b2))
				        {
				        	if(node_gOfn_open(b2) > gOfn_b2)
				        	{
				        		String Id = node_Id_open(nodeToStr_b2);
				        		openSet_Node.remove(Id);
				        		openSet_Node.put(Id, new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
								openSet_Node.get(Id).put(nodeToStr_b2, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
								openSet_Node.get(Id).get(nodeToStr_b2).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
								openSet_Node.get(Id).get(nodeToStr_b2).get(parentNode).put(gOfn_b2, new HashMap<Integer,String>());
								openSet_Node.get(Id).get(nodeToStr_b2).get(parentNode).get(gOfn_b2).put(hOfn_b2, "I");
								
				        	}
				        }
				        
				        if(!isPresent_closedSet(nodeToStr_b3) && !isPresent_openSet(nodeToStr_b3))
				        {
				        	openSet_Node.put(Integer.toString(nodeCount_b3), new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
							openSet_Node.get(Integer.toString(nodeCount_b3)).put(nodeToStr_b3, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
							openSet_Node.get(Integer.toString(nodeCount_b3)).get(nodeToStr_b3).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
							openSet_Node.get(Integer.toString(nodeCount_b3)).get(nodeToStr_b3).get(parentNode).put(gOfn_b3, new HashMap<Integer,String>());
							openSet_Node.get(Integer.toString(nodeCount_b3)).get(nodeToStr_b3).get(parentNode).get(gOfn_b3).put(hOfn_b3, "O");
							
				        }
				        else if(!isPresent_closedSet(nodeToStr_b3) && isPresent_openSet(nodeToStr_b3))
				        {
				        	if(node_gOfn_open(b3) > gOfn_b3)
				        	{
				        		String Id = node_Id_open(nodeToStr_b3);
				        		openSet_Node.remove(Id);
				        		openSet_Node.put(Id, new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
								openSet_Node.get(Id).put(nodeToStr_b3, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
								openSet_Node.get(Id).get(nodeToStr_b3).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
								openSet_Node.get(Id).get(nodeToStr_b3).get(parentNode).put(gOfn_b3, new HashMap<Integer,String>());
								openSet_Node.get(Id).get(nodeToStr_b3).get(parentNode).get(gOfn_b3).put(hOfn_b3, "O");
								
				        	}
				        }
				        
				        
					}     
				        
				}
				
				
				/*-------LAST ROW---------*/
				
				else if(i == 2)
				{
					if(j == 0)
					{
						String b1[][] = new String[3][5];
						String b2[][] = new String[3][5];
				        for (int i1 = 0; i1 < 3; i1++) 
				        	for (int j1 = 0; j1 < 5; j1++){
				        		b1[i1][j1] = arr[i1][j1];
				        		b2[i1][j1] = arr[i1][j1];
				        }
				        
				        b1[2][0] = b1[2][1];
				        b1[2][1] = "e";
				        b2[2][0] = b2[1][0];
				        b2[1][0] = "e";
				        
				        
				        hOfn_b1 = check_top_bottom(b1);
				        hOfn_b2 = check_top_bottom(b2);
				        gOfn_b1 = node_gOfn_closed(arr) + 1;
				        gOfn_b2 = node_gOfn_closed(arr) + 1;
				        nodeToStr_b1 = nodeToString(b1);
				        nodeToStr_b2 = nodeToString(b2);
				        nodeCount_b1 = nodeCount + 1;
				        nodeCount++;
				        nodeCount_b2 = nodeCount + 1;
				        nodeCount++;
				       
				        if(!isPresent_closedSet(nodeToStr_b1) && !isPresent_openSet(nodeToStr_b1))
				        {
				        	openSet_Node.put(Integer.toString(nodeCount_b1), new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).put(nodeToStr_b1, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).get(nodeToStr_b1).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).get(nodeToStr_b1).get(parentNode).put(gOfn_b1, new HashMap<Integer,String>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).get(nodeToStr_b1).get(parentNode).get(gOfn_b1).put(hOfn_b1, "L");
							
				        }
				        else if(!isPresent_closedSet(nodeToStr_b1) && isPresent_openSet(nodeToStr_b1))
				        {
				        	if(node_gOfn_open(b1) > gOfn_b1)
				        	{
				        		String Id = node_Id_open(nodeToStr_b1);
				        		openSet_Node.remove(Id);
				        		openSet_Node.put(Id, new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
								openSet_Node.get(Id).put(nodeToStr_b1, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
								openSet_Node.get(Id).get(nodeToStr_b1).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
								openSet_Node.get(Id).get(nodeToStr_b1).get(parentNode).put(gOfn_b1, new HashMap<Integer,String>());
								openSet_Node.get(Id).get(nodeToStr_b1).get(parentNode).get(gOfn_b1).put(hOfn_b1, "L");
								
				        	}
				        }
				        
				        if(!isPresent_closedSet(nodeToStr_b2) && !isPresent_openSet(nodeToStr_b2))
				        {
				        	openSet_Node.put(Integer.toString(nodeCount_b2), new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).put(nodeToStr_b2, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).get(nodeToStr_b2).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).get(nodeToStr_b2).get(parentNode).put(gOfn_b2, new HashMap<Integer,String>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).get(nodeToStr_b2).get(parentNode).get(gOfn_b2).put(hOfn_b2, "F");
							
				        }
				        else if(!isPresent_closedSet(nodeToStr_b2) && isPresent_openSet(nodeToStr_b2))
				        {
				        	if(node_gOfn_open(b2) > gOfn_b2)
				        	{
				        		String Id = node_Id_open(nodeToStr_b2);
				        		openSet_Node.remove(Id);
				        		openSet_Node.put(Id, new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
								openSet_Node.get(Id).put(nodeToStr_b2, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
								openSet_Node.get(Id).get(nodeToStr_b2).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
								openSet_Node.get(Id).get(nodeToStr_b2).get(parentNode).put(gOfn_b2, new HashMap<Integer,String>());
								openSet_Node.get(Id).get(nodeToStr_b2).get(parentNode).get(gOfn_b2).put(hOfn_b2, "F");
								
				        	}
				        }
				        
				        
						
					}
						
				        
					
					else if(j>=1 && j<=3)
					{
						String b1[][] = new String[3][5];
						String b2[][] = new String[3][5];
						String b3[][] = new String[3][5];
						int i_b1 = -1, j_b1 = -1,i_b2 = -1, j_b2 = -1,i_b3 = -1, j_b3 = -1;
				        for (int i1 = 0; i1 < 3; i1++) 
				        	for (int j1 = 0; j1 < 5; j1++){
				        		b1[i1][j1] = arr[i1][j1];
				        		b2[i1][j1] = arr[i1][j1];
				        		b3[i1][j1] = arr[i1][j1];
				        }
				       
				        
		                
				        for (int m=0;m<3;m++){
					        for (int n=0;n<5;n++) {
					        	//presentString = presentString + a2[i][j] +" ";
					        	if(arr[m][n].equals("e"))
					        	{
					        		b1[m][n] = b1[m][n-1];
					 		        b1[m][n-1] = "e";
					 		        i_b1 = m;
					 		        j_b1 = n-1;
					 		        b2[m][n] = b2[m][n+1];
					 		        b2[m][n+1] = "e";
					 		        i_b2 = m;
					 		        j_b2 = n+1;
					 		        b3[m][n] = b3[m-1][n];//CHANGED
					 		        b3[m-1][n] = "e";
					 		        i_b3 = m-1;
					 		        j_b3 = n;
					        		break;
					        	}
					        }
					     }
				        String taken_b1 = cellIndex(i_b1, j_b1);
				        String taken_b2 = cellIndex(i_b2, j_b2);
				        String taken_b3 = cellIndex(i_b3, j_b3);
					       //System.out.println("values"+taken_b1 +taken_b2 +taken_b3);
				        
				       /* for (int x=0;x<3;x++){
			                for (int y=0;y<5;y++) {
			                    
			                	System.out.print(b1[x][y] +" ");
			                	k++;
			                }
			                System.out.println();
				        }
				        System.out.println("=====================");
				        for (int x=0;x<3;x++){
			                for (int y=0;y<5;y++) {
			                    
			                	System.out.print(arr[x][y] +" ");
			                	k++;
			                }
			                System.out.println();
				        }*/
				        
				        hOfn_b1 = check_top_bottom(b1);
				        hOfn_b2 = check_top_bottom(b2);
				        hOfn_b3 = check_top_bottom(b3);
				        gOfn_b1 = node_gOfn_closed(arr) + 1;
				        gOfn_b2 = node_gOfn_closed(arr) + 1;
				        gOfn_b3 = node_gOfn_closed(arr) + 1;
				        nodeToStr_b1 = nodeToString(b1);
				        nodeToStr_b2 = nodeToString(b2);
				        nodeToStr_b3 = nodeToString(b3);
				        nodeCount_b1 = nodeCount + 1;
				        nodeCount++;
				        nodeCount_b2 = nodeCount + 1;
				        nodeCount++;
				        nodeCount_b3 = nodeCount + 1;
				        nodeCount++;
				        
				        if(!isPresent_closedSet(nodeToStr_b1) && !isPresent_openSet(nodeToStr_b1))
				        {
				        	openSet_Node.put(Integer.toString(nodeCount_b1), new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).put(nodeToStr_b1, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).get(nodeToStr_b1).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).get(nodeToStr_b1).get(parentNode).put(gOfn_b1, new HashMap<Integer,String>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).get(nodeToStr_b1).get(parentNode).get(gOfn_b1).put(hOfn_b1, taken_b1);
							
				        }
				        else if(!isPresent_closedSet(nodeToStr_b1) && isPresent_openSet(nodeToStr_b1))
				        {
				        	if(node_gOfn_open(b1) > gOfn_b1)
				        	{
				        		String Id = node_Id_open(nodeToStr_b1);
				        		openSet_Node.remove(Id);
				        		openSet_Node.put(Id, new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
								openSet_Node.get(Id).put(nodeToStr_b1, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
								openSet_Node.get(Id).get(nodeToStr_b1).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
								openSet_Node.get(Id).get(nodeToStr_b1).get(parentNode).put(gOfn_b1, new HashMap<Integer,String>());
								openSet_Node.get(Id).get(nodeToStr_b1).get(parentNode).get(gOfn_b1).put(hOfn_b1, taken_b1);
								
				        	}
				        }
				        
				        if(!isPresent_closedSet(nodeToStr_b2) && !isPresent_openSet(nodeToStr_b2))
				        {
				        	openSet_Node.put(Integer.toString(nodeCount_b2), new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).put(nodeToStr_b2, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).get(nodeToStr_b2).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).get(nodeToStr_b2).get(parentNode).put(gOfn_b2, new HashMap<Integer,String>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).get(nodeToStr_b2).get(parentNode).get(gOfn_b2).put(hOfn_b2, taken_b2);
							
				        }
				        else if(!isPresent_closedSet(nodeToStr_b2) && isPresent_openSet(nodeToStr_b2))
				        {
				        	if(node_gOfn_open(b2) > gOfn_b2)
				        	{
				        		String Id = node_Id_open(nodeToStr_b2);
				        		openSet_Node.remove(Id);
				        		openSet_Node.put(Id, new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
								openSet_Node.get(Id).put(nodeToStr_b2, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
								openSet_Node.get(Id).get(nodeToStr_b2).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
								openSet_Node.get(Id).get(nodeToStr_b2).get(parentNode).put(gOfn_b2, new HashMap<Integer,String>());
								openSet_Node.get(Id).get(nodeToStr_b2).get(parentNode).get(gOfn_b2).put(hOfn_b2, taken_b2);
								
				        	}
				        }
				        
				        if(!isPresent_closedSet(nodeToStr_b3) && !isPresent_openSet(nodeToStr_b3))
				        {
				        	openSet_Node.put(Integer.toString(nodeCount_b3), new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
							openSet_Node.get(Integer.toString(nodeCount_b3)).put(nodeToStr_b3, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
							openSet_Node.get(Integer.toString(nodeCount_b3)).get(nodeToStr_b3).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
							openSet_Node.get(Integer.toString(nodeCount_b3)).get(nodeToStr_b3).get(parentNode).put(gOfn_b3, new HashMap<Integer,String>());
							openSet_Node.get(Integer.toString(nodeCount_b3)).get(nodeToStr_b3).get(parentNode).get(gOfn_b3).put(hOfn_b3, taken_b3);
							
				        }
				        else if(!isPresent_closedSet(nodeToStr_b3) && isPresent_openSet(nodeToStr_b3))
				        {
				        	if(node_gOfn_open(b3) > gOfn_b3)
				        	{
				        		String Id = node_Id_open(nodeToStr_b3);
				        		openSet_Node.remove(Id);
				        		openSet_Node.put(Id, new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
								openSet_Node.get(Id).put(nodeToStr_b3, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
								openSet_Node.get(Id).get(nodeToStr_b3).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
								openSet_Node.get(Id).get(nodeToStr_b3).get(parentNode).put(gOfn_b3, new HashMap<Integer,String>());
								openSet_Node.get(Id).get(nodeToStr_b3).get(parentNode).get(gOfn_b3).put(hOfn_b3, taken_b3);
								
				        	}
				        }
				        
				        
				        
				       
					}
					else if(j ==4)
					{
						String b1[][] = new String[3][5];
						String b2[][] = new String[3][5];
				        for (int i1 = 0; i1 < 3; i1++) 
				        	for (int j1 = 0; j1 < 5; j1++){
				        		b1[i1][j1] = arr[i1][j1];
				        		b2[i1][j1] = arr[i1][j1];
				        }
				       

				        b1[2][4] = b1[2][3];
				        b1[2][3] = "e";
				        b2[2][4] = b2[1][4];
				        b2[1][4] = "e";
				        
				        
				        hOfn_b1 = check_top_bottom(b1);
				        hOfn_b2 = check_top_bottom(b2);
				        gOfn_b1 = node_gOfn_closed(arr) + 1;
				        gOfn_b2 = node_gOfn_closed(arr) + 1;
				        nodeToStr_b1 = nodeToString(b1);
				        nodeToStr_b2 = nodeToString(b2);
				        nodeCount_b1 = nodeCount + 1;
				        nodeCount++;
				        nodeCount_b2 = nodeCount + 1;
				        nodeCount++;
				        
				        
				        if(!isPresent_closedSet(nodeToStr_b1) && !isPresent_openSet(nodeToStr_b1))
				        {
				        	openSet_Node.put(Integer.toString(nodeCount_b1), new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).put(nodeToStr_b1, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).get(nodeToStr_b1).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).get(nodeToStr_b1).get(parentNode).put(gOfn_b1, new HashMap<Integer,String>());
							openSet_Node.get(Integer.toString(nodeCount_b1)).get(nodeToStr_b1).get(parentNode).get(gOfn_b1).put(hOfn_b1, "N");
							
				        }
				        else if(!isPresent_closedSet(nodeToStr_b1) && isPresent_openSet(nodeToStr_b1))
				        {
				        	if(node_gOfn_open(b1) > gOfn_b1)
				        	{
				        		String Id = node_Id_open(nodeToStr_b1);
				        		openSet_Node.remove(Id);
				        		openSet_Node.put(Id, new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
								openSet_Node.get(Id).put(nodeToStr_b1, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
								openSet_Node.get(Id).get(nodeToStr_b1).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
								openSet_Node.get(Id).get(nodeToStr_b1).get(parentNode).put(gOfn_b1, new HashMap<Integer,String>());
								openSet_Node.get(Id).get(nodeToStr_b1).get(parentNode).get(gOfn_b1).put(hOfn_b1, "N");
								
				        	}
				        }
				        
				        if(!isPresent_closedSet(nodeToStr_b2) && !isPresent_openSet(nodeToStr_b2))
				        {
				        	openSet_Node.put(Integer.toString(nodeCount_b2), new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).put(nodeToStr_b2, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).get(nodeToStr_b2).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).get(nodeToStr_b2).get(parentNode).put(gOfn_b2, new HashMap<Integer,String>());
							openSet_Node.get(Integer.toString(nodeCount_b2)).get(nodeToStr_b2).get(parentNode).get(gOfn_b2).put(hOfn_b2, "J");
							
				        }
				        else if(!isPresent_closedSet(nodeToStr_b2) && isPresent_openSet(nodeToStr_b2))
				        {
				        	if(node_gOfn_open(b2) > gOfn_b2)
				        	{
				        		String Id = node_Id_open(nodeToStr_b2);
				        		openSet_Node.remove(Id);
				        		openSet_Node.put(Id, new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
								openSet_Node.get(Id).put(nodeToStr_b2, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
								openSet_Node.get(Id).get(nodeToStr_b2).put(parentNode, new HashMap<Integer,HashMap<Integer,String>>());
								openSet_Node.get(Id).get(nodeToStr_b2).get(parentNode).put(gOfn_b2, new HashMap<Integer,String>());
								openSet_Node.get(Id).get(nodeToStr_b2).get(parentNode).get(gOfn_b2).put(hOfn_b2, "J");
								
				        	}
				        }
				        
				        
				        
				        
				        
				        
				        
					}
				}
		        
				
			}


		}
		
		
		
		
		return output;
		
	}
	
	
	public void solve()
	{
		long startTime = System.currentTimeMillis();
		String path = "";
		
		/*for (int x=0;x<3;x++){
            for (int y=0;y<5;y++) {
                
            	System.out.print(a[x][y] +" ");
            }
            System.out.println();
        }*/
		//converting input matrix to a string
		//System.out.println("ENTRY 1"); 	
		int start_hOfn = check_top_bottom(a);
		String nodeToStr = nodeToString(a);
		openSet_Node.put("start", new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
		openSet_Node.get("start").put(nodeToStr, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
		openSet_Node.get("start").get(nodeToStr).put("start", new HashMap<Integer,HashMap<Integer,String>>());
		openSet_Node.get("start").get(nodeToStr).get("start").put(0, new HashMap<Integer,String>());
		openSet_Node.get("start").get(nodeToStr).get("start").get(0).put(start_hOfn, "");
		//System.out.println(start_hOfn);
		//System.out.println("===================================================");
		
		if(start_hOfn == 0)
		{
			path = "ALREADY SOLVED";
		}
		else
		{
			//adding start node from closed set
			//closedSet_Node.put("start", new HashMap<String, HashMap<String, HashMap<Integer,HashMap<Integer,String>>>>());
			//closedSet_Node.get("start").put(nodeToStr, new HashMap<String, HashMap<Integer,HashMap<Integer,String>>>());
			//closedSet_Node.get("start").get(nodeToStr).put(null, new HashMap<Integer,HashMap<Integer,String>>());
			//closedSet_Node.get("start").get(nodeToStr).get(null).put(0, new HashMap<Integer,String>());
			//closedSet_Node.get("start").get(nodeToStr).get(null).get(0).put(start_hOfn, null);
			//removing start node from open set
			//openSet_Node.remove("start");
			//System.out.println("ENTRY 2");
			String goal = A_star();
			if(goal != null)
			{ //System.out.println("ENTRY 8");
				String parent = parent_NodeId(goal);
				//System.out.println(parent);
				
				
				//printing the final configuration
				int io=0, jo=0;
				String parsed1[] = parse(node_Config(goal).trim(), " ");
				String[][] arr1 = new String [3][5];
				//System.out.println("ENTRY 6.1");
		    	int k = 0;
		        for (int p=0;p<3;p++){
		            for (int q=0;q<5;q++) {
		                arr1[p][q]= parsed1[k].trim();
		                if(parsed1[k].equals("e"))
		                {
		                	io = p;
		                	jo = q;
		                }
		            	k++;
		            	
		            }
		        }
		       /* System.out.println("********************************");
		        
				for (int x=0;x<3;x++){
	                for (int y=0;y<5;y++) {
	                    
	                	System.out.print(arr1[x][y] +" ");
	                }
	                System.out.println();
		        }
				
				System.out.println("*********************************");*/
				
				
				if(!openSet_Node.isEmpty()){
					Set<String> setd= openSet_Node.keySet();
					Iterator itd=setd.iterator();
					 while (itd.hasNext()) {
			 		    String nodeValue = (String)itd.next();
			 		   if(nodeValue.equals(goal))
			 		    {
				 		   //System.out.println("node: "+nodeValue);
				    		Set<String> s = openSet_Node.get(nodeValue).keySet();
				 		   	Iterator it =  s.iterator();
				 		    while (it.hasNext()) {
				 		    	String str = (String)it.next();
						 		  // System.out.println("string: "+str);
				 		    	Set<String> s1 = openSet_Node.get(nodeValue).get(str).keySet();
					 		    Iterator it1 = s1.iterator();
					 		    while (it1.hasNext()){
					 		    	String str2 = (String)it1.next();
							 		   //System.out.println("parent: "+str2);
					 		    	Set<Integer> i1 = openSet_Node.get(nodeValue).get(str).get(str2).keySet();
						 		    Iterator it2 = i1.iterator();
						 		    while (it2.hasNext()){
						 		    	int int1 = (int)it2.next();
								 		   //System.out.println("gOfn: "+int1);
						 		    	Set<Integer> i2 = openSet_Node.get(nodeValue).get(str).get(str2).get(int1).keySet();
							 		    Iterator it3 = i2.iterator();
							 		    while (it3.hasNext()){
							 		    	int int2 = (int)it3.next();
									 		  // System.out.println("hOfn: "+int2);
									 		   path = openSet_Node.get(nodeValue).get(str).get(str2).get(int1).get(int2);
									 		   count++;
							 		    }
							 		    }
						 		    }	
						    	}
							}
					 	}
			 	    }
				
				
				
				while(!parent.equals("start"))
				{ //System.out.println("ENTRY 8.1");
					// write function to get move made and move node to the id in parent ID column
					if(!closedSet_Node.isEmpty()){
						Set<String> setd= closedSet_Node.keySet();
						Iterator itd=setd.iterator();
						 while (itd.hasNext()) {
				 		    String nodeValue = (String)itd.next();
				 		    if(nodeValue.equals(parent))
				 		    {
					    		Set<String> s = closedSet_Node.get(nodeValue).keySet();
					 		   	Iterator it =  s.iterator();
					 		    while (it.hasNext()) {
					 		    	String str = (String)it.next();
					 		    	Set<String> s1 = closedSet_Node.get(nodeValue).get(str).keySet();
						 		    Iterator it1 = s1.iterator();
						 		    while (it1.hasNext()){
						 		    	String str2 = (String)it1.next();
						 		    	Set<Integer> i1 = closedSet_Node.get(nodeValue).get(str).get(str2).keySet();
							 		    Iterator it2 = i1.iterator();
							 		    while (it2.hasNext()){
							 		    	int int1 = (int)it2.next();
							 		    	Set<Integer> i2 = closedSet_Node.get(nodeValue).get(str).get(str2).get(int1).keySet();
								 		    Iterator it3 = i2.iterator();
								 		    while (it3.hasNext()){
								 		    	int int2 = (int)it3.next();
								 		    	String moveMade = closedSet_Node.get(nodeValue).get(str).get(str2).get(int1).get(int2) + " ";
								 		    	parent = str2;
								 		    	path = moveMade + path;
								 		    	if(!nodeValue.equals("start"))
								 		    		count++;
								 	 		  // 	System.out.println("path: "+path);
								 	 		   	
								 	 		   	}
								 		    }
							 		    }	
							    	}
								}
						 	}
				 	    }
					}
				}
			}
			
			
		closedSet_Node.clear();
		openSet_Node.clear();
		long endTime = System.currentTimeMillis();
		String time = (endTime - startTime)+" ms";
		//w.write(time);
		superArr[sh][0] = path.trim();
		superArr[sh][1] = time;
		Count[sh] = count;
		//System.out.println("sh:" +path.trim() +time);
		
	}
	
	
}
