
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner; 
	
public class filetoArrayList {
	 private File file;
	 
	public filetoArrayList(String fileName)
	{
		file = new File(fileName);
	}
	 
	public ArrayList<String> getArrayList() throws Exception {
		ArrayList<String> toReturn = new ArrayList<String>();
		Scanner sc = new Scanner(file);

		while (sc.hasNext()) {
			toReturn.add(sc.next());
		}

		return toReturn;
	}

}
