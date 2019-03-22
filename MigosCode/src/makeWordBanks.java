import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class makeWordBanks {
	private ArrayList<String> lyrics;
	private ArrayList<String> adjectives = new ArrayList<String>();
	private ArrayList<String> adlibs = new ArrayList<String>();
	private ArrayList<String> articles = new ArrayList<String>();
	private ArrayList<String> conjunctions = new ArrayList<String>();
	private ArrayList<String> negatives = new ArrayList<String>();
	private ArrayList<String> nouns = new ArrayList<String>();
	private ArrayList<String> prepositions = new ArrayList<String>();
	private ArrayList<String> pronouns = new ArrayList<String>();
	private ArrayList<String> propernouns = new ArrayList<String>();
	private ArrayList<String> verbs = new ArrayList<String>();
	private ArrayList<String> adverbs = new ArrayList<String>();
	private ArrayList<String> libraryadjectives;
	private ArrayList<String> libraryadlibs;
	private ArrayList<String> libraryarticles;
	private ArrayList<String> libraryconjunctions;
	private ArrayList<String> librarynegatives;
	private ArrayList<String> librarynouns;
	private ArrayList<String> libraryprepositions;
	private ArrayList<String> librarypronouns;
	private ArrayList<String> librarypropernouns;
	private ArrayList<String> libraryverbs;
	private ArrayList<String> libraryadverbs;

	public makeWordBanks(ArrayList<String> wordsToBank, ArrayList<String> adlibs, ArrayList<String> adjectives,
			ArrayList<String> adverbs, ArrayList<String> articles, ArrayList<String> conjunctions,
			ArrayList<String> nouns, ArrayList<String> negatives, ArrayList<String> prepositions,
			ArrayList<String> pronouns, ArrayList<String> propernouns, ArrayList<String> verbs) {
		lyrics = wordsToBank;
		libraryadlibs = adlibs;
		libraryadjectives = adjectives;
		libraryadverbs = adverbs;
		libraryarticles = articles;
		libraryconjunctions = conjunctions;
		librarynouns = nouns;
		librarynegatives = negatives;
		libraryprepositions = prepositions;
		librarypronouns = pronouns;
		librarypropernouns = propernouns;
		libraryverbs = verbs;
	}

	public void init() {
		for (String word : lyrics) {
			if (libraryadlibs.contains(word)) {
				adlibs.add(word);
			}

			else if (libraryadjectives.contains(word)) {
				adjectives.add(word);
			}

			else if (libraryadverbs.contains(word)) {
				adverbs.add(word);
			}

			else if (libraryarticles.contains(word)) {
				articles.add(word);
			}

			else if (libraryconjunctions.contains(word)) {
				conjunctions.add(word);
			}

			else if (librarynouns.contains(word)) {
				nouns.add(word);
			}

			else if (librarynegatives.contains(word)) {
				negatives.add(word);
			}

			else if (libraryprepositions.contains(word)) {
				prepositions.add(word);
			}

			else if (librarypropernouns.contains(word)) {
				propernouns.add(word);
			}

			if (libraryverbs.contains(word)) {
				verbs.add(word);
			}

			else if (librarypronouns.contains(word)) {
				pronouns.add(word);
			}
		}
	}

	public void generateWordBanks() throws FileNotFoundException, UnsupportedEncodingException {

		String path = "/Users/vishnu/Documents/GitHub/Migos-Project/AnalysisProject/WordBanks/Takeoff/";

		init();
		PrintWriter writer = new PrintWriter(path + "Adjectives.txt", "UTF-8");
		for (String word : adjectives) {
			writer.print(word + " ");
		}
		writer.close();

		writer = new PrintWriter(path + "Adlibs.txt", "UTF-8");
		for (String word : adlibs) {
			writer.print(word + " ");
		}
		writer.close();

		writer = new PrintWriter(path + "Adverbs.txt", "UTF-8");
		for (String word : adverbs) {
			writer.print(word + " ");
		}
		writer.close();

		writer = new PrintWriter(path + "Articles.txt", "UTF-8");
		for (String word : articles) {
			writer.print(word + " ");
		}
		writer.close();

		writer = new PrintWriter(path + "Conjunctions.txt", "UTF-8");
		for (String word : conjunctions) {
			writer.print(word + " ");
		}
		writer.close();

		writer = new PrintWriter(path + "Nouns.txt", "UTF-8");
		for (String word : nouns) {
			writer.print(word + " ");
		}
		writer.close();

		writer = new PrintWriter(path + "Negatives.txt", "UTF-8");
		for (String word : negatives) {
			writer.print(word + " ");
		}
		writer.close();

		writer = new PrintWriter(path + "Prepositions.txt", "UTF-8");
		for (String word : prepositions) {
			writer.print(word + " ");
		}
		writer.close();

		writer = new PrintWriter(path + "Pronouns.txt", "UTF-8");
		for (String word : pronouns) {
			writer.print(word + " ");
		}
		writer.close();

		writer = new PrintWriter(path + "Propernouns.txt", "UTF-8");
		for (String word : propernouns) {
			writer.print(word + " ");
		}
		writer.close();

		writer = new PrintWriter(path + "Verbs.txt", "UTF-8");
		for (String word : verbs) {
			writer.print(word + " ");
		}
		writer.close();
	}

}
