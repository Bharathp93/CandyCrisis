
public class waste {


	
	public String find_sequence(String a[][])
	{
		String desired = "";
		int i = 0;
		for(int j = 0; j<5; j++)
		{
			if(a[i][j].equals(a[i+2][j]))
			{
				desired = desired + a[i][j] +" ";
				a[i][j] = a[i+2][j] = "e";
			}
			else
			{
				int val1_r = 999;
				int val2_r = 999;
				int val_k1_r = 0;
				int val_l1_r = 0;
				int val_k2_r = 0;
				int val_l2_r = 0;
				for(int k = 0; k<3; k++)
				{
					for(int l = 0; l<5; l++)
					{
						if(a[k][l].equals("r"))
						{
							int distance = java.lang.Math.abs(0-k) + java.lang.Math.abs(j-l);
							if(distance < val1_r)
							{
								val1_r = distance;
								val_k1_r = k;
								val_l1_r = l;
								
							}
							
						}
					}
									
				}
				for(int k = 0; k<3; k++)
				{
					for(int l = 0; l<5; l++)
					{
						if(a[k][l].equals("r") && k != val_k1_r && l != val_l1_r)
						{
							int distance = java.lang.Math.abs(2-k) + java.lang.Math.abs(j-l);
							if(distance < val1_r)
							{
								val2_r = distance;
								val_k2_r = k;
								val_l2_r = l;
								
							}
							
						}
					}
						
				}
				int val_r = val1_r+val2_r;
		
			
				int val1_w = 999;
				int val2_w = 999;
				int val_k1_w = 0;
				int val_l1_w = 0;
				int val_k2_w = 0;
				int val_l2_w = 0;
				for(int k = 0; k<3; k++)
				{
					for(int l = 0; l<5; l++)
					{
						if(a[k][l].equals("w"))
						{
							int distance = java.lang.Math.abs(0-k) + java.lang.Math.abs(j-l);
							if(distance < val1_w)
							{
								val1_w = distance;
								val_k1_w = k;
								val_l1_w = l;
								
							}
							
						}
					}
									
				}
				for(int k = 0; k<3; k++)
				{
					for(int l = 0; l<5; l++)
					{
						if(a[k][l].equals("w") && k != val_k1_w && l != val_l1_w)
						{
							int distance = java.lang.Math.abs(2-k) + java.lang.Math.abs(j-l);
							if(distance < val1_w)
							{
								val2_w = distance;
								val_k2_w = k;
								val_l2_w = l;
								
							}
							
						}
					}
						
				}
				int val_w = val1_w+val2_w;
			
			
				
				int val1_b = 999;
				int val2_b = 999;
				int val_k1_b = 0;
				int val_l1_b = 0;
				int val_k2_b = 0;
				int val_l2_b = 0;
				for(int k = 0; k<3; k++)
				{
					for(int l = 0; l<5; l++)
					{
						if(a[k][l].equals("b"))
						{
							int distance = java.lang.Math.abs(0-k) + java.lang.Math.abs(j-l);
							if(distance < val1_b)
							{
								val1_b = distance;
								val_k1_b = k;
								val_l1_b = l;
								
							}
							
						}
					}
									
				}
				for(int k = 0; k<3; k++)
				{
					for(int l = 0; l<5; l++)
					{
						if(a[k][l].equals("b") && k != val_k1_b && l != val_l1_b)
						{
							int distance = java.lang.Math.abs(2-k) + java.lang.Math.abs(j-l);
							if(distance < val1_b)
							{
								val2_b = distance;
								val_k2_b = k;
								val_l2_b = l;
								
							}
							
						}
					}
						
				}
				int val_b = val1_b+val2_b;
				
			
				if(val_r < val_w && val_r < val_b)
				{
					a[val_k1_r][val_l1_r] = "e";
					a[val_k2_r][val_l2_r] = "e";
					desired = desired + "r ";
				}
				if(val_w < val_r && val_w < val_b)
				{
					a[val_k1_w][val_l1_w] = "e";
					a[val_k2_w][val_l2_w] = "e";
					desired = desired + "w ";
				}
				if(val_b < val_w && val_b < val_r)
				{
					a[val_k1_b][val_l1_b] = "e";
					a[val_k2_b][val_l2_b] = "e";
					desired = desired + "b ";
				}
				
				
			}
	
		}
		
		
		
		
		return desired.trim();
	}
	
	
	
	
	
	
}
