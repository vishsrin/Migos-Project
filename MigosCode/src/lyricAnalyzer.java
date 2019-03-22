import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class lyricAnalyzer {
	ArrayList<String> lyrics;
	ArrayList<String> POSlyrics;
	int[][] POSmatrix;
	private ArrayList<String> adjectives;
	private ArrayList<String> adlibs;
	private ArrayList<String> adverbs;
	private ArrayList<String> articles;
	private ArrayList<String> conjunctions;
	private ArrayList<String> negatives;
	private ArrayList<String> nouns;
	private ArrayList<String> prepositions;
	private ArrayList<String> pronouns;
	private ArrayList<String> propernouns;
	private ArrayList<String> verbs;
	private ArrayList<String> endlines;
	private ArrayList<String> endverses;
	wordCounter counter;
	
	public lyricAnalyzer(ArrayList<String> lyrics) throws Exception
	{
		this.lyrics = lyrics;

		filetoArrayList verbsconverter = new filetoArrayList("/Users/vishnu/Documents/GitHub/Migos-Project/AnalysisProject/POS//Verbs.txt");
		ArrayList<String> verbs = verbsconverter.getArrayList();
		filetoArrayList nounsconverter = new filetoArrayList("/Users/vishnu/Documents/GitHub/Migos-Project/AnalysisProject/POS//Nouns.txt");
		ArrayList<String> nouns = nounsconverter.getArrayList();
		filetoArrayList adjsconverter = new filetoArrayList("/Users/vishnu/Documents/GitHub/Migos-Project/AnalysisProject/POS//Adjectives.txt");
		ArrayList<String> adjs = adjsconverter.getArrayList();
		filetoArrayList advsconverter = new filetoArrayList("/Users/vishnu/Documents/GitHub/Migos-Project/AnalysisProject/POS//Adverbs.txt");
		ArrayList<String> adverbs = advsconverter.getArrayList();
		filetoArrayList pronounsconverter = new filetoArrayList("/Users/vishnu/Documents/GitHub/Migos-Project/AnalysisProject/POS//Pronouns.txt");
		ArrayList<String> pronouns = pronounsconverter.getArrayList();
		filetoArrayList prepsconverter = new filetoArrayList("/Users/vishnu/Documents/GitHub/Migos-Project/AnalysisProject/POS//Prepositions.txt");
		ArrayList<String> prepositions = prepsconverter.getArrayList();
		filetoArrayList conjconverter = new filetoArrayList("/Users/vishnu/Documents/GitHub/Migos-Project/AnalysisProject/POS//Conjunctions.txt");
		ArrayList<String> conjunctions = conjconverter.getArrayList();
		filetoArrayList propernounsconverter = new filetoArrayList("/Users/vishnu/Documents/GitHub/Migos-Project/AnalysisProject/POS//Propernouns.txt");
		ArrayList<String> propernouns = propernounsconverter.getArrayList();
		filetoArrayList artsconverter = new filetoArrayList("/Users/vishnu/Documents/GitHub/Migos-Project/AnalysisProject/POS//Articles.txt");
		ArrayList<String> articles = artsconverter.getArrayList();
		filetoArrayList adlsconverter = new filetoArrayList("/Users/vishnu/Documents/GitHub/Migos-Project/AnalysisProject/POS//Adlibs.txt");
		ArrayList<String> adlibs = adlsconverter.getArrayList();
		filetoArrayList negsconverter = new filetoArrayList("/Users/vishnu/Documents/GitHub/Migos-Project/AnalysisProject/POS//Negatives.txt");
		ArrayList<String> negatives = negsconverter.getArrayList();
		
		adjectives = adjs;
		this.adlibs = adlibs;
		this.adverbs = adverbs;
		this.articles = articles;
		this.conjunctions = conjunctions;
		this.negatives = negatives;
		this.nouns = nouns;
		this.prepositions = prepositions;
		this.pronouns = pronouns;
		this.propernouns = propernouns;
		this.verbs = verbs;
		
		counter = new wordCounter(lyrics, adlibs, adjs, adverbs, articles, conjunctions, nouns, negatives, prepositions, pronouns, propernouns, verbs);
		
		lyricstoPOS finalConverter = new lyricstoPOS(lyrics, adlibs, adjs, adverbs, articles, conjunctions, nouns, negatives, prepositions, pronouns, propernouns, verbs);
		POSlyrics = finalConverter.getPOS();
		
		POSmatrix = new int[13][13];
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
	// 13: Endverse
	
	public void makeWordBanks() throws FileNotFoundException, UnsupportedEncodingException
	{
		makeWordBanks bankMaker = new makeWordBanks(lyrics, adlibs, adjectives, adverbs, articles, conjunctions, nouns, negatives, prepositions, pronouns, propernouns, verbs);
		bankMaker.generateWordBanks();

	
	}
	
	
	public void printFreqs()
	{
		for(int i = 0; i < 12; i++)
		{
			for(int j = 0; j < 12; j++)
			{
				int[][] matrix = getFreqs();
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public double rowTotal(int[][] matrix, int rowNum)
	{
		int toReturn = 0;
		for(int i = 0; i < 13; i++)
		{
			toReturn = toReturn + matrix[rowNum][i];
		}
		return toReturn;
	}
	
	public double[][] getProbs()
	{
		double[][] probMatrix = new double[13][13];
		int[][] matrix = getFreqs();
		for(int i = 0; i < 13; i++)
		{
			for(int j = 0; j < 13; j++)
			{
				probMatrix[i][j] = (matrix[i][j]) / rowTotal(matrix, i);
			}
		}
		
		return probMatrix;
	}
	
	public ArrayList<Double> getRow(double[][] array, int rowIndex)
	{
		ArrayList<Double> toReturn = new ArrayList<Double>();
		for(int i = 0; i < 13; i++)
		{
			toReturn.add(array[rowIndex][i]);
		}
		
		return toReturn;
	}
	
	public int[][] getFreqs()
	{
		for(int i = 0; i < POSlyrics.size() - 1; i++)
		{
			if(POSlyrics.get(i).equalsIgnoreCase("adjective"))
			{
				adjectiveCounter(i);
			}
			
			else if(POSlyrics.get(i).equalsIgnoreCase("adlib"))
			{
				adlibCounter(i);
			}
			
			else if(POSlyrics.get(i).equalsIgnoreCase("adverb"))
			{
				adverbCounter(i);				
			}
			
			else if(POSlyrics.get(i).equalsIgnoreCase("article"))
			{
				articleCounter(i);
			}
			
			else if(POSlyrics.get(i).equalsIgnoreCase("conjunction"))
			{
				conjunctionCounter(i);
			}
			
			else if(POSlyrics.get(i).equalsIgnoreCase("negative"))
			{
				negativeCounter(i);
			}
			
			else if(POSlyrics.get(i).equalsIgnoreCase("noun"))
			{
				nounCounter(i);
			}
			
			else if(POSlyrics.get(i).equalsIgnoreCase("preposition"))
			{
				prepositionCounter(i);
			}
			
			else if(POSlyrics.get(i).equalsIgnoreCase("pronoun"))
			{
				pronounCounter(i);
			}
			
			else if(POSlyrics.get(i).equalsIgnoreCase("propernoun"))
			{
				propernounCounter(i);
			}
			
			else if(POSlyrics.get(i).equalsIgnoreCase("verb"))
			{
				verbCounter(i);
			}
			
			else if(POSlyrics.get(i).equalsIgnoreCase("endline"))
			{
				endlineCounter(i);
			}
			
			else if(POSlyrics.get(i).equalsIgnoreCase("endverse"))
			{
				endverseCounter(i);
			}
			
			else{
				System.out.println(POSlyrics.get(i));
			}
			
		}
		
		return POSmatrix;
		
	}
	
	//---------------------------------Counter time
	
	public void adjectiveCounter(int index)
	{
		String nextPOS = POSlyrics.get(index + 1);
		
		if(nextPOS.equalsIgnoreCase("adjective"))
		{
			POSmatrix[0][0]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("adlib"))
		{
			POSmatrix[0][1]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("adverb"))
		{
			POSmatrix[0][2]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("article"))
		{
			POSmatrix[0][3]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("conjunction"))
		{
			POSmatrix[0][4]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("negative"))
		{
			POSmatrix[0][5]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("noun"))
		{
			POSmatrix[0][6]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("preposition"))
		{
			POSmatrix[0][7]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("pronoun"))
		{
			POSmatrix[0][8]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("propernoun"))
		{
			POSmatrix[0][9]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("verb"))
		{
			POSmatrix[0][10]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("endline"))
		{
			POSmatrix[0][11]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("endverse"))
		{
			POSmatrix[0][12]++;
		}
		
	}
	
	public void adlibCounter(int index)
	{
		String nextPOS = POSlyrics.get(index + 1);
		
		if(nextPOS.equalsIgnoreCase("adjective"))
		{
			POSmatrix[1][0]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("adlib"))
		{
			POSmatrix[1][1]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("adverb"))
		{
			POSmatrix[1][2]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("article"))
		{
			POSmatrix[1][3]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("conjunction"))
		{
			POSmatrix[1][4]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("negative"))
		{
			POSmatrix[1][5]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("noun"))
		{
			POSmatrix[1][6]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("preposition"))
		{
			POSmatrix[1][7]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("pronoun"))
		{
			POSmatrix[1][8]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("propernoun"))
		{
			POSmatrix[1][9]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("verb"))
		{
			POSmatrix[1][10]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("endline"))
		{
			POSmatrix[1][11]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("endverse"))
		{
			POSmatrix[1][12]++;
		}
		
	}
	
	public void adverbCounter(int index)
	{
		String nextPOS = POSlyrics.get(index + 1);
		
		if(nextPOS.equalsIgnoreCase("adjective"))
		{
			POSmatrix[2][0]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("adlib"))
		{
			POSmatrix[2][1]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("adverb"))
		{
			POSmatrix[2][2]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("article"))
		{
			POSmatrix[2][3]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("conjunction"))
		{
			POSmatrix[2][4]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("negative"))
		{
			POSmatrix[2][5]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("noun"))
		{
			POSmatrix[2][6]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("preposition"))
		{
			POSmatrix[2][7]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("pronoun"))
		{
			POSmatrix[2][8]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("propernoun"))
		{
			POSmatrix[2][9]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("verb"))
		{
			POSmatrix[2][10]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("endline"))
		{
			POSmatrix[2][11]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("endverse"))
		{
			POSmatrix[2][12]++;
		}
		
	}
	
	public void articleCounter(int index)
	{
		String nextPOS = POSlyrics.get(index + 1);
		
		if(nextPOS.equalsIgnoreCase("adjective"))
		{
			POSmatrix[3][0]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("adlib"))
		{
			POSmatrix[3][1]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("adverb"))
		{
			POSmatrix[3][2]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("article"))
		{
			POSmatrix[3][3]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("conjunction"))
		{
			POSmatrix[3][4]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("negative"))
		{
			POSmatrix[3][5]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("noun"))
		{
			POSmatrix[3][6]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("preposition"))
		{
			POSmatrix[3][7]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("pronoun"))
		{
			POSmatrix[3][8]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("propernoun"))
		{
			POSmatrix[3][9]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("verb"))
		{
			POSmatrix[3][10]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("endline"))
		{
			POSmatrix[3][11]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("endverse"))
		{
			POSmatrix[3][12]++;
		}
		
	}
	
	public void conjunctionCounter(int index)
	{
		String nextPOS = POSlyrics.get(index + 1);
		
		if(nextPOS.equalsIgnoreCase("adjective"))
		{
			POSmatrix[4][0]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("adlib"))
		{
			POSmatrix[4][1]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("adverb"))
		{
			POSmatrix[4][2]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("article"))
		{
			POSmatrix[4][3]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("conjunction"))
		{
			POSmatrix[4][4]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("negative"))
		{
			POSmatrix[4][5]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("noun"))
		{
			POSmatrix[4][6]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("preposition"))
		{
			POSmatrix[4][7]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("pronoun"))
		{
			POSmatrix[4][8]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("propernoun"))
		{
			POSmatrix[4][9]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("verb"))
		{
			POSmatrix[4][10]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("endline"))
		{
			POSmatrix[4][11]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("endverse"))
		{
			POSmatrix[4][12]++;
		}
	}
	
	public void negativeCounter(int index)
	{
		String nextPOS = POSlyrics.get(index + 1);
		
		if(nextPOS.equalsIgnoreCase("adjective"))
		{
			POSmatrix[5][0]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("adlib"))
		{
			POSmatrix[5][1]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("adverb"))
		{
			POSmatrix[5][2]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("article"))
		{
			POSmatrix[5][3]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("conjunction"))
		{
			POSmatrix[5][4]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("negative"))
		{
			POSmatrix[5][5]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("noun"))
		{
			POSmatrix[5][6]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("preposition"))
		{
			POSmatrix[5][7]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("pronoun"))
		{
			POSmatrix[5][8]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("propernoun"))
		{
			POSmatrix[5][9]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("verb"))
		{
			POSmatrix[5][10]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("endline"))
		{
			POSmatrix[5][11]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("endverse"))
		{
			POSmatrix[5][12]++;
		}
		
	}
	
	public void nounCounter(int index)
	{
		String nextPOS = POSlyrics.get(index + 1);
		
		if(nextPOS.equalsIgnoreCase("adjective"))
		{
			POSmatrix[6][0]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("adlib"))
		{
			POSmatrix[6][1]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("adverb"))
		{
			POSmatrix[6][2]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("article"))
		{
			POSmatrix[6][3]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("conjunction"))
		{
			POSmatrix[6][4]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("negative"))
		{
			POSmatrix[6][5]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("noun"))
		{
			POSmatrix[6][6]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("preposition"))
		{
			POSmatrix[6][7]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("pronoun"))
		{
			POSmatrix[6][8]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("propernoun"))
		{
			POSmatrix[6][9]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("verb"))
		{
			POSmatrix[6][10]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("endline"))
		{
			POSmatrix[6][11]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("endverse"))
		{
			POSmatrix[6][12]++;
		}
		
	}
	
	public void prepositionCounter(int index)
	{
		String nextPOS = POSlyrics.get(index + 1);
		
		if(nextPOS.equalsIgnoreCase("adjective"))
		{
			POSmatrix[7][0]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("adlib"))
		{
			POSmatrix[7][1]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("adverb"))
		{
			POSmatrix[7][2]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("article"))
		{
			POSmatrix[7][3]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("conjunction"))
		{
			POSmatrix[7][4]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("negative"))
		{
			POSmatrix[7][5]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("noun"))
		{
			POSmatrix[7][6]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("preposition"))
		{
			POSmatrix[7][7]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("pronoun"))
		{
			POSmatrix[7][8]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("propernoun"))
		{
			POSmatrix[7][9]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("verb"))
		{
			POSmatrix[7][10]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("endline"))
		{
			POSmatrix[7][11]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("endverse"))
		{
			POSmatrix[7][12]++;
		}
	}
	
	public void pronounCounter(int index)
	{
		String nextPOS = POSlyrics.get(index + 1);
		
		if(nextPOS.equalsIgnoreCase("adjective"))
		{
			POSmatrix[8][0]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("adlib"))
		{
			POSmatrix[8][1]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("adverb"))
		{
			POSmatrix[8][2]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("article"))
		{
			POSmatrix[8][3]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("conjunction"))
		{
			POSmatrix[8][4]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("negative"))
		{
			POSmatrix[8][5]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("noun"))
		{
			POSmatrix[8][6]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("preposition"))
		{
			POSmatrix[8][7]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("pronoun"))
		{
			POSmatrix[8][8]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("propernoun"))
		{
			POSmatrix[8][9]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("verb"))
		{
			POSmatrix[8][10]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("endline"))
		{
			POSmatrix[8][11]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("endverse"))
		{
			POSmatrix[8][12]++;
		}
		
	}
	
	public void propernounCounter(int index)
	{
		String nextPOS = POSlyrics.get(index + 1);
		
		if(nextPOS.equalsIgnoreCase("adjective"))
		{
			POSmatrix[9][0]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("adlib"))
		{
			POSmatrix[9][1]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("adverb"))
		{
			POSmatrix[9][2]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("article"))
		{
			POSmatrix[9][3]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("conjunction"))
		{
			POSmatrix[9][4]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("negative"))
		{
			POSmatrix[9][5]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("noun"))
		{
			POSmatrix[9][6]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("preposition"))
		{
			POSmatrix[9][7]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("pronoun"))
		{
			POSmatrix[9][8]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("propernoun"))
		{
			POSmatrix[9][9]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("verb"))
		{
			POSmatrix[9][10]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("endline"))
		{
			POSmatrix[9][11]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("endverse"))
		{
			POSmatrix[9][12]++;
		}
	}
	
	public void verbCounter(int index)
	{
		String nextPOS = POSlyrics.get(index + 1);
		
		if(nextPOS.equalsIgnoreCase("adjective"))
		{
			POSmatrix[10][0]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("adlib"))
		{
			POSmatrix[10][1]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("adverb"))
		{
			POSmatrix[10][2]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("article"))
		{
			POSmatrix[10][3]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("conjunction"))
		{
			POSmatrix[10][4]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("negative"))
		{
			POSmatrix[10][5]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("noun"))
		{
			POSmatrix[10][6]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("preposition"))
		{
			POSmatrix[10][7]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("pronoun"))
		{
			POSmatrix[10][8]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("propernoun"))
		{
			POSmatrix[10][9]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("verb"))
		{
			POSmatrix[10][10]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("endline"))
		{
			POSmatrix[10][11]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("endverse"))
		{
			POSmatrix[10][12]++;
		}
		
	}
	
	public void endlineCounter(int index)
	{
		String nextPOS = POSlyrics.get(index + 1);
		
		if(nextPOS.equalsIgnoreCase("adjective"))
		{
			POSmatrix[11][0]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("adlib"))
		{
			POSmatrix[11][1]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("adverb"))
		{
			POSmatrix[11][2]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("article"))
		{
			POSmatrix[11][3]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("conjunction"))
		{
			POSmatrix[11][4]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("negative"))
		{
			POSmatrix[11][5]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("noun"))
		{
			POSmatrix[11][6]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("preposition"))
		{
			POSmatrix[11][7]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("pronoun"))
		{
			POSmatrix[11][8]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("propernoun"))
		{
			POSmatrix[11][9]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("verb"))
		{
			POSmatrix[11][10]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("endline"))
		{
			POSmatrix[11][11]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("endverse"))
		{
			POSmatrix[11][12]++;
		}
		
	}
	
	public void endverseCounter(int index)
	{
		String nextPOS = POSlyrics.get(index + 1);
		
		if(nextPOS.equalsIgnoreCase("adjective"))
		{
			POSmatrix[12][0]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("adlib"))
		{
			POSmatrix[12][1]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("adverb"))
		{
			POSmatrix[12][2]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("article"))
		{
			POSmatrix[12][3]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("conjunction"))
		{
			POSmatrix[12][4]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("negative"))
		{
			POSmatrix[12][5]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("noun"))
		{
			POSmatrix[12][6]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("preposition"))
		{
			POSmatrix[12][7]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("pronoun"))
		{
			POSmatrix[12][8]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("propernoun"))
		{
			POSmatrix[12][9]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("verb"))
		{
			POSmatrix[12][10]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("endline"))
		{
			POSmatrix[12][11]++;
		}
		
		else if(nextPOS.equalsIgnoreCase("endverse"))
		{
			POSmatrix[12][12]++;
		}
		
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
		
	public void gettotalAdjectives()
	{

	}
	
	public void gettotalAdlibs()
	{

	}
	
	public void gettotalAdverbs()
	{

	}
	
	public void gettotalArticles()
	{

	}
	
	public void gettotalConjunctions()
	{

	}
	
	public void gettotalNegatives()
	{

	}
	
	public void gettotalNouns()
	{
		 counter.printNouns();
	}
	
	public void gettotalPrepositions()
	{

	}
	
	public void gettotalPropernouns()
	{

	}
	
	public void gettotalVerbs()
	{
		
	}

}
