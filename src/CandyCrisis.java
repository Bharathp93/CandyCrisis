import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.concurrent.TimeUnit;
public class CandyCrisis extends ArrayClass{
	public static boolean check_top_bottom(String a[][])
	{
		int i = 0, j = 0;
		boolean loop = true;
		boolean result = false;
		//System.out.println("Entering stage 2");
		while(loop) {
			//System.out.println("Entering stage 3");
			if(j < 5)
			{
				//System.out.println("Entering stage 4");
				if(a[i][j].equals(a[i+2][j]))
				{
					//System.out.println("Entering stage 5");
					loop = true;
					result = true;
					j++;
					
				}
				else
				{
					loop = false;
					result = false;
				}
			}
			else
			{
				loop = false;
			}
			//System.out.println("running loop");
		}
		return result;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
        Scanner input;
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/input.txt"));
			input = new Scanner (new File("src/input.txt"));
			//String output = "";
			int count = 0;
			//String a1[] = new String[15];
			//PrintWriter printer = new PrintWriter(new FileWriter("src/output.txt", true));
			Writer w = new Writer();
			System.out.println("Enter 1 to solve it YOURSELF or Enter 2 and we will solve it for you");
			Scanner in1 = new Scanner(System.in);
			int user = in1.nextInt();
			if(user == 1)
			{
				while (input.hasNextLine()){
					long startTime = System.currentTimeMillis();
					String in = input.nextLine();
					String a1[] = in.split(" ");
			        int m = 3;
			        int n = 5;
			        String[][] a = new String [m][n];
			        //while (input.next()!=null){
		        	int k = 0;
		            for (int i=0;i<m;i++){
		                for (int j=0;j<n;j++) {
		                    a[i][j]= a1[k];
		                	//System.out.print(a1[k] +" ");
		                	k++;
		                }
		                //System.out.println();
			          //  }  
			            
			
			        }
		            
	            	//System.out.println("Entering stage 1");
	            	solvePuzzle s = new solvePuzzle();
	            	while(!CandyCrisis.check_top_bottom(a))
	            	{
	
	            		//System.out.println("Entering stage 2");
	
	            		s.solve(a);
	            		
	            	}// end while
	            	long endTime = System.currentTimeMillis();
	            	//printer.println(s.output);
	        		count = count + s.count;
	            	//printer.println(outputAuto);
	        		//printer.println("The time taken to solve this puzzle: "+ (endTime - startTime)+" ms");
	        		String time = (endTime - startTime)+" ms";
	        		w.write(time);
	            		System.out.println("Puzzle solved... Next one...");
	            	
				}
				//printer.println("The total number of moves taken to solve all the puzzles: "+count);
				w.write(Integer.toString(count));
			}
			else if(user == 2)
			{
				int i1 = 0;
				System.out.println("Solving...");
				while (reader.readLine() != null){
					i1++;
					//System.out.println(i1);
				}
				//System.out.println("TW0");
				superArr = new String[i1][2];
				Count = new int[i1];
				for(int f = 0; f < superArr.length; f++)
				{
					//if(!superArr[f][0].equals("null") && !superArr[f][1].equals("null"))
					superArr[f][0] = "null";
					superArr[f][1] = "null";
				}
				//System.out.println("THREE");
				int i2 = 0;
				while (input.hasNextLine()){
					//long startTime = System.currentTimeMillis();
					String in = input.nextLine();
					String a1[] = in.split(" ");
			        int m = 3;
			        int n = 5;
			        String[][] a = new String [m][n];
			        //while (input.next()!=null){
		        	int k = 0;
		            for (int i=0;i<m;i++){
		                for (int j=0;j<n;j++) {
		                    a[i][j]= a1[k];
		                	//System.out.print(a1[k] +" ");
		                	k++;
		                }
		                //System.out.println();
			          //  }  
			            
			
			        }
		            
	            	//System.out.println("Entering stage 1");
	            	//solvePuzzleAuto s = new solvePuzzleAuto(a);
		            MyThread t = new MyThread(a, i2);
		            t.start();
		            i2++;
	            	//while(!CandyCrisis.check_top_bottom(a))
	            	//{
	
	            		//System.out.println("Entering stage 2");
	
	            		//String outputAuto = s.solve();
	            		
	            	//}// end while
	            	//long endTime = System.currentTimeMillis();
	            	//printer.println(s.output);
	        		//count = count + s.count;
	            	//printer.println(outputAuto);
	        		//printer.println("The time taken to solve this puzzle: "+ (endTime - startTime)+" ms");
	            	
	            	
				}
				TimeUnit.MINUTES.sleep(4);
				for(int f = 0; f < superArr.length; f++)
				{
					//if(!superArr[f][0].equals("null") && !superArr[f][1].equals("null"))
						
						w.write(superArr[f][0]);
						w.write(superArr[f][1]);
					
					
				}
				for(int f = 0; f < Count.length; f++)
				{
					count = count + Count[f];
				}

				//printer.println("The total number of moves taken to solve all the puzzles: "+count);
				w.write(Integer.toString(count));
				System.out.println("DONE");
			}
			else{
				System.out.println("Its 1 or 2 nothing else");
			}
            //printer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
	}

		
}
