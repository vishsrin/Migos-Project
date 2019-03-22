import java.util.ArrayList;

public class verseConverter {
	private ArrayList<String> lyrics;
	private POStoWord converter;
	ArrayList<String> toReturn = new ArrayList<String>();

	public verseConverter(ArrayList<String> lyrics, String who) throws Exception {
		this.lyrics = lyrics;
		converter = new POStoWord(who);
	}

	public ArrayList<String> getConverted() {
		for (int i = 0; i < lyrics.size(); i++) {
			
			if(lyrics.get(i).equalsIgnoreCase("adlib"))
			{
				toReturn.add(getAdlib(i));
			}
			else
			{
			

			String POS = lyrics.get(i);
			String word = converter.getWord(POS);

			toReturn.add(word);
			}
			
		}

		return toReturn;
	}
	
	public String getAdlib(int i)
	{
		if(i == 0)
		{
			String word = converter.getWord("adlib");

			return word;
		}
		
		if(lyrics.get(i - 1).equalsIgnoreCase("endline"))
		{
			String word = converter.getWord("adlib");

			return word;
		}
		
		else if(lyrics.get(i - 1).equalsIgnoreCase("endverse"))
		{
			String word = converter.getWord("adlib");

			return word;
		}
		
		else if(lyrics.get(i - 1).equalsIgnoreCase("adlib"))
		{
			String word = converter.getWord("adlib");

			return word;
		}
		
		else if(Math.random() > 0.45){
			return "(" + toReturn.get(i - 1) + ")";
		}
		
		else{
			String word = converter.getWord("adlib");

			return word;
		}
	}
	
}
