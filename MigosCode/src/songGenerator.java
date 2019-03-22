import java.util.ArrayList;

public class songGenerator {
	ArrayList<String> title;
	ArrayList<String> chorus;
	ArrayList<String> quavo;
	ArrayList<String> offset;
	ArrayList<String> takeoff;

	public songGenerator(ArrayList<String> chorusLyrics, ArrayList<String> quavoLyrics, ArrayList<String> offsetLyrics,
			ArrayList<String> takeoffLyrics) throws Exception {
		verseGenerator chorus = new verseGenerator(chorusLyrics);
		this.chorus = chorus.generateVerse(30, 130);
		verseConverter chorusConverter = new verseConverter(this.chorus, "Chorus");
		this.chorus = chorusConverter.getConverted();

		title = getTitle();

		verseGenerator quavo = new verseGenerator(quavoLyrics);
		this.quavo = quavo.generateVerse(70, 270);
		verseConverter quavoConverter = new verseConverter(this.quavo, "Quavo");
		this.quavo = quavoConverter.getConverted();

		verseGenerator offset = new verseGenerator(offsetLyrics);
		this.offset = offset.generateVerse(30, 130);
		verseConverter offsetConverter = new verseConverter(this.offset, "Offset");
		this.offset = offsetConverter.getConverted();

		verseGenerator takeoff = new verseGenerator(takeoffLyrics);
		this.takeoff = takeoff.generateVerse(30, 130);
		verseConverter takeoffConverter = new verseConverter(this.takeoff, "Takeoff");
		this.takeoff = takeoffConverter.getConverted();
	}

	public ArrayList<String> getTitle() {
		ArrayList<String> title = new ArrayList<String>();
		// if(chorus.get(0).equalsIgnoreCase("endline"))
		// {
		//
		// title.add(chorus.get(0));
		// title.add("by migos");
		// title.add("endline");
		// return title;
		// }

		if (chorus.get(1).equalsIgnoreCase("endline")) {

			title.add(chorus.get(0));
			title.add("by migos");
			title.add("endline");
			return title;
		}

		if (chorus.get(2).equalsIgnoreCase("endline")) {

			title.add(chorus.get(0));
			title.add(chorus.get(1));
			title.add("by migos");
			title.add("endline");
			return title;
		}

		for (int i = 0; i < chorus.size(); i++) {
			if (chorus.get(i + 3).equalsIgnoreCase("endline")) {

				title.add(chorus.get(i));
				title.add(chorus.get(i + 1));
				title.add(chorus.get(i + 2));
				title.add("by migos");
				title.add("endline");
				return title;
			}
		}

		return title;
	}

	public void printSong() throws Exception {
		ArrayList<String> song = getSong();

		for (int i = 0; i < song.size(); i++) {
			if (song.get(i).equalsIgnoreCase("endline") || song.get(i).equalsIgnoreCase("endverse")) {
				System.out.println();
			}

			else {
				System.out.print(song.get(i) + " ");
			}
		}

		System.out.println(song.size());

	}

	public ArrayList<String> getSong() throws Exception {

		ArrayList<String> song = new ArrayList<String>();
		int titleLength = title.size();
		int chorusLength = chorus.size();
		int quavoLength = quavo.size();
		int offsetLength = offset.size();
		int takeoffLength = takeoff.size();

		for (int i = 0; i < titleLength; i++) {
			song.add(title.get(i));
		}

		song.add("endline");

		for (int i = 0; i < chorusLength; i++) {
			song.add(chorus.get(i));
		}
		song.add("endline");
		song.add("Quavo: ");

		song.add("endline");

		for (int i = 0; i < quavoLength; i++) {

			song.add(quavo.get(i));
		}

		song.add("endline");

		for (int i = 0; i < chorusLength; i++) {
			song.add(chorus.get(i));
		}
		
		song.add("endline");
		song.add("Takeoff: ");
		song.add("endline");

		for (int i = 0; i < takeoffLength; i++) {

			song.add(takeoff.get(i));
		}
		
		song.add("endline");

		for (int i = 0; i < chorusLength; i++) {
			song.add(chorus.get(i));
		}
		
		song.add("endline");
		song.add("Offset: ");
		song.add("endline");

		for (int i = 0; i < offsetLength; i++) {

			song.add(offset.get(i));
		}


		song.add("endline");

		for (int i = 0; i < chorusLength; i++) {
			song.add(chorus.get(i));
		}

		return song;
	}

}
