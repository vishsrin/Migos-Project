import java.util.ArrayList;

public class songCleaner {
	private ArrayList<String> song;
	private ArrayList<String> expletives;
	private ArrayList<String> newExpletives;
	
	public songCleaner(ArrayList<String> song) throws Exception
	{
		this.song = song;
		filetoArrayList converter = new filetoArrayList("/Users/vishnu/Documents/GitHub/Migos-Project/AnalysisProject/POS/Expletives.txt");
		expletives = converter.getArrayList();
		filetoArrayList newconverter = new filetoArrayList("/Users/vishnu/Documents/GitHub/Migos-Project/AnalysisProject/POS/cleanExpletives.txt");
		newExpletives = newconverter.getArrayList();
	}
	
	public ArrayList<String> getCleanVersion()
	{
		ArrayList<String> toReturn = new ArrayList<String>();
		
		for(int i = 0; i < song.size(); i++)
		{
			String currWord = song.get(i);
			if(expletives.contains(currWord))
			{
				toReturn.add(newExpletives.get(expletives.indexOf(currWord)));
			}
			else
			{
				toReturn.add(currWord);
			}
		}
		return toReturn;
		
	}

}
