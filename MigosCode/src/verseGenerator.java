import java.util.ArrayList;

public class verseGenerator {
	private ArrayList<String> lyrics;
	private ArrayList<Double> adjectives;
	private ArrayList<Double> adlibs;
	private ArrayList<Double> adverbs;
	private ArrayList<Double> articles;
	private ArrayList<Double> conjunctions;
	private ArrayList<Double> negatives;
	private ArrayList<Double> nouns;
	private ArrayList<Double> prepositions;
	private ArrayList<Double> pronouns;
	private ArrayList<Double> propernouns;
	private ArrayList<Double> verbs;
	private ArrayList<Double> endlines;
	private ArrayList<Double> endverses;

	public verseGenerator(ArrayList<String> lyrics) throws Exception {
		this.lyrics = lyrics;
		lyricAnalyzer analyzer = new lyricAnalyzer(lyrics);
		double[][] probMatrix = analyzer.getProbs();
		// for(int i = 0; i < 13; i++)
		// {
		// for(int j = 0; j < 13; j++)
		// {
		// System.out.print(probMatrix[i][j] + " ");
		// }
		// System.out.println();
		// }
		adjectives = analyzer.getRow(probMatrix, 0);
		adlibs = analyzer.getRow(probMatrix, 1);
		adverbs = analyzer.getRow(probMatrix, 2);
		articles = analyzer.getRow(probMatrix, 3);
		conjunctions = analyzer.getRow(probMatrix, 4);
		negatives = analyzer.getRow(probMatrix, 5);
		nouns = analyzer.getRow(probMatrix, 6);
		prepositions = analyzer.getRow(probMatrix, 7);
		pronouns = analyzer.getRow(probMatrix, 8);
		propernouns = analyzer.getRow(probMatrix, 9);
		verbs = analyzer.getRow(probMatrix, 10);
		endlines = analyzer.getRow(probMatrix, 11);
		endverses = analyzer.getRow(probMatrix, 12);
	}

	public ArrayList<String> generateVerse(int lowestBound, int highestBound) throws Exception {
		ArrayList<String> generatedChorus = new ArrayList<String>();
		int firstPOSnum = generatePOS(12);
		String nextPOSname = getPOSname(firstPOSnum);
		generatedChorus.add(nextPOSname);

		for (int i = 1; getPOSnum(generatedChorus.get(i - 1)) < 12; i++) {
			String lastPOSname = generatedChorus.get(i - 1);
			int lastPOSnum = getPOSnum(lastPOSname);
			int nextPOSnum = generatePOS(lastPOSnum);
			if (nextPOSnum == 12 && generatedChorus.size() < lowestBound) {
				nextPOSnum = generatePOS(lastPOSnum);
			}

			if (generatedChorus.size() > highestBound) {
				nextPOSnum = 12;
			}
			nextPOSname = getPOSname(nextPOSnum);
			generatedChorus.add(nextPOSname);
		}

		return generatedChorus;
	}

	public int generateIndex(ArrayList<Double> probList) {
		double key = Math.random();
		double probCheck = 0;
		for (int i = 0; i < 13; i++) {
			probCheck = probCheck + probList.get(i);
			// System.out.println("key: " + key);
			// System.out.println("probcheck: " + probCheck);
			// System.out.println(probList);

			if (key < probCheck) {
				return i;
			}
		}
		return 143;
	}

	// 1: Adjective
	// 2: Adlib
	// 3: Adverb
	// 4: Article
	// 5: Conjunction
	// 6: Negative
	// 7: Noun
	// 8: Preposition
	// 9: Pronoun
	// 10: Proper noun
	// 11: Verb
	// 12: Endline

	public int getPOSnum(String POS) {
		if (POS.equalsIgnoreCase("adjective")) {
			return 0;
		}

		else if (POS.equalsIgnoreCase("adlib")) {
			return 1;
		}

		else if (POS.equalsIgnoreCase("adverb")) {
			return 2;
		}

		else if (POS.equalsIgnoreCase("article")) {
			return 3;
		}

		else if (POS.equalsIgnoreCase("conjunction")) {
			return 4;
		}

		else if (POS.equalsIgnoreCase("negative")) {
			return 5;
		}

		else if (POS.equalsIgnoreCase("noun")) {
			return 6;
		}

		else if (POS.equalsIgnoreCase("preposition")) {
			return 7;
		}

		else if (POS.equalsIgnoreCase("pronoun")) {
			return 8;
		}

		else if (POS.equalsIgnoreCase("propernoun")) {
			return 9;
		}

		else if (POS.equalsIgnoreCase("verb")) {
			return 10;
		}

		else if (POS.equalsIgnoreCase("endline")) {
			return 11;
		}

		else if (POS.equalsIgnoreCase("endverse")) {
			return 12;
		}

		else
			return 69;
	}

	public String getPOSname(int POS) {
		if (POS == 0) {
			return "adjective";
		}

		else if (POS == 1) {
			return "adlib";
		}

		else if (POS == 2) {
			return "adverb";
		}

		else if (POS == 3) {
			return "article";
		}

		else if (POS == 4) {
			return "conjunction";
		}

		else if (POS == 5) {
			return "negative";
		}

		else if (POS == 6) {
			return "noun";
		}

		else if (POS == 7) {
			return "preposition";
		}

		else if (POS == 8) {
			return "pronoun";
		}

		else if (POS == 9) {
			return "propernoun";
		} else if (POS == 10) {
			return "verb";
		}

		else if (POS == 11) {
			return "endline";
		}

		else if (POS == 12) {
			return "endverse";
		}

		// else System.out.println(POS);
		return "hmmsomethingwrong";

	}

	public int generatePOS(int currentPOS) {
		if (currentPOS == 0) {
			return generateIndex(adjectives);
		} else if (currentPOS == 1) {
			return generateIndex(adlibs);
		} else if (currentPOS == 2) {
			return generateIndex(adverbs);
		} else if (currentPOS == 3) {
			return generateIndex(articles);
		} else if (currentPOS == 4) {
			return generateIndex(conjunctions);
		} else if (currentPOS == 5) {
			return generateIndex(negatives);
		} else if (currentPOS == 6) {
			return generateIndex(nouns);
		} else if (currentPOS == 7) {
			return generateIndex(prepositions);
		} else if (currentPOS == 8) {
			return generateIndex(pronouns);
		} else if (currentPOS == 9) {
			return generateIndex(pronouns);
		} else if (currentPOS == 10) {
			return generateIndex(verbs);
		} else if (currentPOS == 11) {
			return generateIndex(endlines);
		}

		else if (currentPOS == 12) {
			return generateIndex(endverses);
		}

		else {
			return 13;
		}

	}

}
