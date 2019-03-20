import java.util.ArrayList;

public class wordCounter {
	private ArrayList<String> POSlyrics;
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
	
	public wordCounter(ArrayList<String> POSlyrics, ArrayList<String> adlibs, ArrayList<String> adjectives,
			ArrayList<String> adverbs, ArrayList<String> articles, ArrayList<String> conjunctions, ArrayList<String> nouns, ArrayList<String> negatives,
			ArrayList<String> prepositions, ArrayList<String> pronouns,ArrayList<String> propernouns, ArrayList<String> verbs)
	{
		this.POSlyrics = POSlyrics;
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
	
	public void printNouns()
	{
		for(String word : POSlyrics)
		{
			if(nouns.contains(word))
			{
				System.out.print(word + " ");
			}
		}
	}

}
