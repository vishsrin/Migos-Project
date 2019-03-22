import java.util.ArrayList;

public class POStoWord {
	private String path = "/Users/vishnu/Documents/GitHub/Migos-Project/AnalysisProject/WordBanks/";
	private ArrayList<String> adjectives;
	private ArrayList<String> adlibs;
	private ArrayList<String> articles;
	private ArrayList<String> conjunctions;
	private ArrayList<String> negatives;
	private ArrayList<String> nouns;
	private ArrayList<String> prepositions;
	private ArrayList<String> pronouns;
	private ArrayList<String> propernouns;
	private ArrayList<String> verbs;
	private ArrayList<String> adverbs;

	public POStoWord(String whom) throws Exception {
		adjectives = (new filetoArrayList(path + whom + "/" + "Adjectives.txt")).getArrayList();
//		adlibs = (new filetoArrayList(path + whom + "/" +  "Adlibs.txt")).getArrayList();
		adverbs = (new filetoArrayList(path + whom + "/" +  "Adverbs.txt")).getArrayList();
		articles = (new filetoArrayList(path + whom + "/" +  "Articles.txt")).getArrayList();
		conjunctions = (new filetoArrayList(path + whom + "/" +  "Conjunctions.txt")).getArrayList();
		negatives = (new filetoArrayList(path + whom + "/" +  "Negatives.txt")).getArrayList();
		nouns = (new filetoArrayList(path + whom + "/" +  "Nouns.txt")).getArrayList();
		prepositions = (new filetoArrayList(path + whom + "/" +  "Prepositions.txt")).getArrayList();
		pronouns = (new filetoArrayList(path + whom + "/" +  "Pronouns.txt")).getArrayList();
		propernouns = (new filetoArrayList(path + whom + "/" +  "Propernouns.txt")).getArrayList();
		verbs = (new filetoArrayList(path + whom + "/" +  "Verbs.txt")).getArrayList();

	}

	public String getWord(String type) {
		switch (type.toLowerCase()) {
		case "adjective":
			return adjectives.get((int) (Math.random() * adjectives.size()));
		case "adverb":
			return adverbs.get((int) (Math.random() * adverbs.size()));
		case "adlib":
			return "adlib";
//			return adlibs.get((int) (Math.random() * adlibs.size()));
		case "preposition":
			return prepositions.get((int) (Math.random() * prepositions.size()));
		case "article":
			return articles.get((int) (Math.random() * articles.size()));
		case "conjunction":
			return conjunctions.get((int) (Math.random() * conjunctions.size()));
		case "pronoun":
			return pronouns.get((int) (Math.random() * pronouns.size()));
		case "negative":
			return negatives.get((int) (Math.random() * negatives.size()));
		case "noun":
			return nouns.get((int) (Math.random() * nouns.size()));
		case "verb":
			return verbs.get((int) (Math.random() * verbs.size()));
		case "propernoun":
			return propernouns.get((int) (Math.random() * propernouns.size()));
		default:
			return type;
		}
	}

}