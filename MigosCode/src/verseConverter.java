import java.util.ArrayList;

public class verseConverter{
	private ArrayList<String> lyrics;
	private POStoWord converter;
	
	public verseConverter(ArrayList<String> lyrics) throws Exception
	{
		this.lyrics = lyrics;
		converter = new POStoWord();
	}
	
	public ArrayList<String> getConverted()
	{
		ArrayList<String> toReturn = new ArrayList<String>();
		for(String POS : lyrics)
		{
			toReturn.add(converter.getWord(POS));
		}
		
		return toReturn;
	}

}
