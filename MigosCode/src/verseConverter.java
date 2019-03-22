import java.util.ArrayList;

public class verseConverter{
	private ArrayList<String> lyrics;
	private POStoWord converter;
	
	public verseConverter(ArrayList<String> lyrics, String who) throws Exception
	{
		this.lyrics = lyrics;
		converter = new POStoWord(who);
	}
	
	public ArrayList<String> getConverted()
	{
		ArrayList<String> toReturn = new ArrayList<String>();
		for(String POS : lyrics)
		{
			String word = converter.getWord(POS);
			
			toReturn.add(word);
		}
		
		return toReturn;
	}

}
