import java.util.Scanner;
public class solvePuzzle {
	
	int count = 0;
	String output = "";
	//System.out.println("Entering stage 2");
	public int solve(String a[][])
	{

		//System.out.println("ENTRY 1");
		System.out.println("Enter The cell to be moved");
		Scanner scanner = new Scanner(System.in);
		String b = scanner.nextLine();
		int r = 0;
		int c = 0;
		String letter = b+" ";
		switch (b)
		{
			case "A" : {r = 0;
						c = 0;
						if(a[r][c+1].equals("e"))
	            		{
	            			a[r][c+1] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else if(a[r+1][c].equals("e"))
	            		{
	            			a[r+1][c] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else
	            		{
	            			System.out.println("Please Enter a valid option between A - O");
	            		}
						break;}
			case "B" : r = 0;
						c = 1;
						if(a[r][c-1].equals("e"))
	            		{
	            			a[r][c-1] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else if(a[r][c+1].equals("e"))
	            		{
	            			a[r][c+1] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else if(a[r+1][c].equals("e"))
	            		{
	            			a[r+1][c] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else
	            		{
	            			System.out.println("Please Enter a valid option between A - O");
	            		}
						break;
			case "C" : r = 0;
						c = 2;
						if(a[r][c-1].equals("e"))
	            		{
	            			a[r][c-1] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else if(a[r][c+1].equals("e"))
	            		{
	            			a[r][c+1] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else if(a[r+1][c].equals("e"))
	            		{
	            			a[r+1][c] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else
	            		{
	            			System.out.println("Please Enter a valid option between A - O");
	            		}
						break;
			case "D" : r = 0;
						c = 3;
						if(a[r][c-1].equals("e"))
	            		{
	            			a[r][c-1] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else if(a[r][c+1].equals("e"))
	            		{
	            			a[r][c+1] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else if(a[r+1][c].equals("e"))
	            		{
	            			a[r+1][c] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else
	            		{
	            			System.out.println("Please Enter a valid option between A - O");
	            		}
						break;
			case "E" : r = 0;
						c = 4;
						if(a[r][c-1].equals("e"))
	            		{
	            			a[r][c-1] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else if(a[r+1][c].equals("e"))
	            		{
	            			a[r+1][c] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else
	            		{
	            			System.out.println("Please Enter a valid option between A - O");
	            		}
						break;
			case "F" : r = 1;
						c = 0;
						if(a[r-1][c].equals("e"))
	            		{
	            			a[r-1][c] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            			
	            		}
	            		else if(a[r][c+1].equals("e"))
	            		{
	            			a[r][c+1] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else if(a[r+1][c].equals("e"))
	            		{
	            			a[r+1][c] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else
	            		{
	            			System.out.println("Please Enter a valid option between A - O");
	            		}
						break;
			case "G" : r = 1;
						c = 1;
						if(a[r-1][c].equals("e"))
	            		{
	            			a[r-1][c] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            			
	            		}
	            		else if(a[r][c-1].equals("e"))
	            		{
	            			a[r][c-1] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else if(a[r][c+1].equals("e"))
	            		{
	            			a[r][c+1] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else if(a[r+1][c].equals("e"))
	            		{
	            			a[r+1][c] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else
	            		{
	            			System.out.println("Please Enter a valid option between A - O");
	            		}
						break;
			case "H" : r = 1;
						c = 2;
						if(a[r-1][c].equals("e"))
	            		{
	            			a[r-1][c] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            			
	            		}
	            		else if(a[r][c-1].equals("e"))
	            		{
	            			a[r][c-1] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else if(a[r][c+1].equals("e"))
	            		{
	            			a[r][c+1] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else if(a[r+1][c].equals("e"))
	            		{
	            			a[r+1][c] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else
	            		{
	            			System.out.println("Please Enter a valid option between A - O");
	            		}
						break;
			case "I" : r = 1;
						c = 3;
						if(a[r-1][c].equals("e"))
	            		{
	            			a[r-1][c] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            			
	            		}
	            		else if(a[r][c-1].equals("e"))
	            		{
	            			a[r][c-1] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else if(a[r][c+1].equals("e"))
	            		{
	            			a[r][c+1] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else if(a[r+1][c].equals("e"))
	            		{
	            			a[r+1][c] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else
	            		{
	            			System.out.println("Please Enter a valid option between A - O");
	            		}
						break;
			case "J" : r = 1;
						c = 4;
						if(a[r-1][c].equals("e"))
	            		{
	            			a[r-1][c] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            			
	            		}
	            		else if(a[r][c-1].equals("e"))
	            		{
	            			a[r][c-1] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else if(a[r+1][c].equals("e"))
	            		{
	            			a[r+1][c] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else
	            		{
	            			System.out.println("Please Enter a valid option between A - O");
	            		}
						break;
			case "K" : r = 2;
						c = 0;
						if(a[r-1][c].equals("e"))
	            		{
	            			a[r-1][c] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            			
	            		}
	            		else if(a[r][c+1].equals("e"))
	            		{
	            			a[r][c+1] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else
	            		{
	            			System.out.println("Please Enter a valid option between A - O");
	            		}
						break;
			case "L" : r = 2;
						c = 1;
						if(a[r-1][c].equals("e"))
	            		{
	            			a[r-1][c] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            			
	            		}
	            		else if(a[r][c-1].equals("e"))
	            		{
	            			a[r][c-1] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else if(a[r][c+1].equals("e"))
	            		{
	            			a[r][c+1] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else
	            		{
	            			System.out.println("Please Enter a valid option between A - O");
	            		}
						break;
			case "M" : r = 2;
						c = 2;
						if(a[r-1][c].equals("e"))
	            		{
	            			a[r-1][c] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            			
	            		}
	            		else if(a[r][c-1].equals("e"))
	            		{
	            			a[r][c-1] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else if(a[r][c+1].equals("e"))
	            		{
	            			a[r][c+1] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else
	            		{
	            			System.out.println("Please Enter a valid option between A - O");
	            		}
						break;
			case "N" : r = 2;
						c = 3;
						if(a[r-1][c].equals("e"))
	            		{
	            			a[r-1][c] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            			
	            		}
	            		else if(a[r][c-1].equals("e"))
	            		{
	            			a[r][c-1] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else if(a[r][c+1].equals("e"))
	            		{
	            			a[r][c+1] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else
	            		{
	            			System.out.println("Please Enter a valid option between A - O");
	            		}
						break;
			case "O" : r = 2;
						c = 4;
						if(a[r-1][c].equals("e"))
	            		{
	            			a[r-1][c] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            			
	            		}
	            		else if(a[r][c-1].equals("e"))
	            		{
	            			a[r][c-1] = a[r][c];
	            			a[r][c] = "e";
	            			output = output + letter;
	            			count++;
	            		}
	            		else
	            		{
	            			System.out.println("Please Enter a valid option between A - O");
	            		}
						break;
			default : System.out.println("Please Enter a valid option");			
				
		}// end switch
		/*if(0 < r && r < 3 && 0 < c && c < 3)
		{
    		if(a[r-1][c] == "e")
    		{
    			a[r-1][c] = a[r][c];
    			a[r][c] = "e";
    			output = output + letter;
    			
    		}
    		else if(a[r][c-1] == "e")
    		{
    			a[r][c-1] = a[r][c];
    			a[r][c] = "e";
    			output = output + letter;
    		}
    		else if(a[r][c+1] == "e")
    		{
    			a[r][c+1] = a[r][c];
    			a[r][c] = "e";
    			output = output + letter;
    		}
    		else if(a[r+1][c] == "e")
    		{
    			a[r+1][c] = a[r][c];
    			a[r][c] = "e";
    			output = output + letter;
    		}
    		else
    		{
    			System.out.println("Please Enter a valid option between A - O");
    		}
		}
		else if(r == 0 && c > 0 && c < 3)
		{
			if(a[r][c-1].equals("e"))
    		{
    			a[r][c-1] = a[r][c];
    			a[r][c] = "e";
    			output = output + letter;
    		}
    		else if(a[r][c+1].equals("e"))
    		{
    			a[r][c+1] = a[r][c];
    			a[r][c] = "e";
    			output = output + letter;
    		}
    		else if(a[r+1][c].equals("e"))
    		{
    			a[r+1][c] = a[r][c];
    			a[r][c] = "e";
    			output = output + letter;
    		}
    		else
    		{
    			System.out.println("Please Enter a valid option between A - O");
    		}
			
		}
		else if(r == 3 && c > 0 && c < 3)
		{
			if(a[r][c-1] == "e")
    		{
    			a[r][c-1] = a[r][c];
    			a[r][c] = "e";
    			output = output + letter;
    		}
    		else if(a[r][c+1] == "e")
    		{
    			a[r][c+1] = a[r][c];
    			a[r][c] = "e";
    			output = output + letter;
    		}
    		else if(a[r-1][c] == "e")
    		{
    			a[r+1][c] = a[r][c];
    			a[r][c] = "e";
    			output = output + letter;
    		}
    		else
    		{
    			System.out.println("Please Enter a valid option between A - O");
    		}
		}
		else if(r > 0 && c == 0)
		{
			if(a[r-1][c] == "e")
    		{
    			a[r-1][c] = a[r][c];
    			a[r][c] = "e";
    			output = output + letter;
    			
    		}
    		
    		else if(a[r][c+1] == "e")
    		{
    			a[r][c+1] = a[r][c];
    			a[r][c] = "e";
    			output = output + letter;
    		}
    		else if(a[r+1][c] == "e")
    		{
    			a[r+1][c] = a[r][c];
    			a[r][c] = "e";
    			output = output + letter;
    		}
    		else
    		{
    			System.out.println("Please Enter a valid option between A - O");
    		}
		}*/
		
		for (int i=0;i<3;i++){
            for (int j=0;j<5;j++) {
                //a[i][j]= a1[k];
            	System.out.print(a[i][j] +" ");
            	//k++;
            }
            System.out.println();
          } 
		//System.out.println(count);
		return count;
		}
	//System.out.println(output);
}
