import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		

		filetoArrayList chorusconverter = new filetoArrayList(
				"/Users/vishnu/Desktop/AnalysisProject/Lyrics/Culture/0.Fulls/Chorus.txt");
		ArrayList<String> chorus = chorusconverter.getArrayList();

		filetoArrayList quavoconverter = new filetoArrayList(
				"/Users/vishnu/Desktop/AnalysisProject/Lyrics/Culture/0.Fulls/Quavo.txt");
		ArrayList<String> quavo = quavoconverter.getArrayList();

		filetoArrayList offsetconverter = new filetoArrayList(
				"/Users/vishnu/Desktop/AnalysisProject/Lyrics/Culture/0.Fulls/Offset.txt");
		ArrayList<String> offset = offsetconverter.getArrayList();
		
		filetoArrayList takeoffconverter = new filetoArrayList(
				"/Users/vishnu/Desktop/AnalysisProject/Lyrics/Culture/0.Fulls/Takeoff.txt");
		ArrayList<String> takeoff = takeoffconverter.getArrayList();
		
//		lyricAnalyzer analyzer = new lyricAnalyzer(takeoff);
//		analyzer.makeWordBanks();
		
//		POStoWord converter = new POStoWord();
//		System.out.println(converter.getWord("noun"));
//		
		songGenerator generator = new songGenerator(chorus, quavo, offset, takeoff);
		generator.printSong();
		

//		verseGenerator Chorusgenerator = new verseGenerator(chorus);
//
//		ArrayList<String> Chorus = Chorusgenerator.generateVerse(30, 130);
//		System.out.println("Chorus length: " + Chorus.size());

//		for (int i = 0; i < Chorus.size(); i++) {
//			if (Chorus.get(i).equalsIgnoreCase("endline") || Chorus.get(i).equalsIgnoreCase("endverse")) {
//				System.out.println();
//			}
//
//			else {
//				System.out.print(Chorus.get(i) + " ");
//			}
//		}
//
//		System.out.println();
//
//		verseGenerator Quavogenerator = new verseGenerator(quavo);
//
//		ArrayList<String> Quavo = Quavogenerator.generateVerse(100, 270);
//		System.out.println("quavo length: " + Quavo.size());
//
//		for (int i = 0; i < Quavo.size(); i++) {
//			if (Quavo.get(i).equalsIgnoreCase("endline") || Quavo.get(i).equalsIgnoreCase("endverse")) {
//				System.out.println();
//			}
//
//			else {
//				System.out.print(Quavo.get(i) + " ");
//			}
//		}
//
//		System.out.println();
//
//		verseGenerator Offsetgenerator = new verseGenerator(offset);
//
//		ArrayList<String> Offset = Offsetgenerator.generateVerse(100, 276);
//		System.out.println("Offset length: " + Offset.size());
//
//		for (int i = 0; i < Offset.size(); i++) {
//			if (Offset.get(i).equalsIgnoreCase("endline") || Offset.get(i).equalsIgnoreCase("endverse")) {
//				System.out.println();
//			}
//
//			else {
//				System.out.print(Offset.get(i) + " ");
//			}
//		}
//
//		System.out.println();
//
//		verseGenerator Takeoffgenerator = new verseGenerator(takeoff);
//
//		ArrayList<String> Takeoff = Takeoffgenerator.generateVerse(100, 278);
//		System.out.println("Takeoff length: " + Takeoff.size());
//
//		for (int i = 0; i < Takeoff.size(); i++) {
//			if (Takeoff.get(i).equalsIgnoreCase("endline") || Takeoff.get(i).equalsIgnoreCase("endverse")) {
//				System.out.println();
//			}
//
//			else {
//				System.out.print(Takeoff.get(i) + " ");
//			}
//		}

	}

}
