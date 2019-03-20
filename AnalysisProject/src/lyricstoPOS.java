import java.util.ArrayList;

public class lyricstoPOS {
	private ArrayList<String> lyrics;
	private ArrayList<String> adlibs;
	private ArrayList<String> adjectives;
	private ArrayList<String> adverbs;
	private ArrayList<String> articles;
	private ArrayList<String> conjunctions;
	private ArrayList<String> nouns;
	private ArrayList<String> negatives;
	private ArrayList<String> prepositions;
	private ArrayList<String> pronouns;
	private ArrayList<String> propernouns;
	private ArrayList<String> verbs;
	
	public lyricstoPOS(ArrayList<String> lyrics, ArrayList<String> adlibs, ArrayList<String> adjectives,
			ArrayList<String> adverbs, ArrayList<String> articles, ArrayList<String> conjunctions, ArrayList<String> nouns, ArrayList<String> negatives,
			ArrayList<String> prepositions, ArrayList<String> pronouns,ArrayList<String> propernouns, ArrayList<String> verbs)
	{
		this.lyrics = lyrics;
		this.adlibs = adlibs;
		this.adjectives = adjectives;
		this.adverbs = adverbs;
		this.articles = articles;
		this.conjunctions = conjunctions;
		this.nouns = nouns;
		this.negatives = negatives;
		this.prepositions = prepositions;
		this.pronouns = pronouns;
		this.propernouns = propernouns;
		this.verbs = verbs;
	}
	
	public ArrayList<String> getPOS()
	{
		ArrayList<String> toReturn = new ArrayList<String>();
		
		for(String word : lyrics)
		{
			if(adlibs.contains(word))
			{
				toReturn.add("adlib");
			}
			
			else if(adjectives.contains(word))
			{
				toReturn.add("adjective");
			}
			
			else if(adverbs.contains(word))
			{
				toReturn.add("adverb");
			}

			else if(articles.contains(word))
			{
				toReturn.add("article");
			}
			
			else if(conjunctions.contains(word))
			{
				toReturn.add("conjunction");
			}
			
			else if(nouns.contains(word))
			{
				toReturn.add("noun");
			}
			
			else if(negatives.contains(word))
			{
				toReturn.add("negative");
			}
			
			else if(prepositions.contains(word))
			{
				toReturn.add("preposition");
			}
			
			else if(pronouns.contains(word))
			{
				toReturn.add("pronoun");
			}
			
			else if(propernouns.contains(word))
			{
				toReturn.add("propernoun");
			}
			
			else if(verbs.contains(word))
			{
				toReturn.add("verb");
			}
			
			else if(word.equalsIgnoreCase("endline"))
			{
				toReturn.add("endline");
			}
			
			else {
				toReturn.add(word);
			}
		}
		
		return toReturn;
	}
	
	public ArrayList<String> getUnsorted()
	{
		Integer i = 0;
		ArrayList<String> toReturn = new ArrayList<String>();
		
		for(String word : lyrics)
		{
			if(adlibs.contains(word))
			{
			
			}
			
			else if(adjectives.contains(word))
			{
				
			}
			
			else if(adverbs.contains(word))
			{
				
			}

			else if(articles.contains(word))
			{
				
			}
			
			else if(conjunctions.contains(word))
			{
				
			}
			
			else if(nouns.contains(word))
			{
				
			}
			
			else if(negatives.contains(word))
			{
				
			}
			
			else if(prepositions.contains(word))
			{
				
			}
			
			else if(pronouns.contains(word))
			{
				
			}
			
			else if(propernouns.contains(word))
			{
				
			}
			
			else if(verbs.contains(word))
			{
				
			}
			
			else if(word.equalsIgnoreCase("endline"))
			{
				
			}
			
			else {
				i++;
				toReturn.add(word);
			}
		}
		
		toReturn.add(i.toString());
		return toReturn;
	}
}
