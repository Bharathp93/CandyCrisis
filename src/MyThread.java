import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MyThread extends Thread{
	
	String a[][] = new String[3][5];
	int i = 0;
	public MyThread(String a[][], int i)
	{
		this.a = a;
		this.i = i;
	}
	public void run()
	{
		solvePuzzleAuto s = new solvePuzzleAuto(a, i);
		s.solve();
		
	}
	
}
