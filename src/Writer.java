import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Writer {

	public void write(String i)
	{
		PrintWriter printer;
		try {
			printer = new PrintWriter(new FileWriter("src/output.txt", true));
			if(i.equals("null"))
				printer.println();
			else
				printer.println(i);
			printer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
