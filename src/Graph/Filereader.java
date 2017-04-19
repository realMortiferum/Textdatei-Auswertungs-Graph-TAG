package Graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Filereader {

	private String pfad;
	private String pfad2;
	private static int linenum;
	private int secondlinenum;
	private int highestThread;
	private static List<String> content = new ArrayList<String>();
	private static List<String> secondcontent = new ArrayList<String>();
	private static List<String> splittedcontent = new ArrayList<String>();

	/**
	 * Einlesen des Dateiinhaltes, welcher in einer Liste (content)gespeichert
	 * wird
	 * 
	 * @author realMortiferum
	 * 
	 * @exception IOException
	 *                wenn die Datei nicht eingelsen werden kann
	 */
	public void Reader() throws IOException {
		Hauptklasse main = new Hauptklasse();
		Linenumberreader linenumread = new Linenumberreader();

		pfad = main.getPfad();
		linenumread.linereader();
		linenum = linenumread.getLinenum();

		FileReader fileread = new FileReader(pfad);
		BufferedReader buffread = new BufferedReader(fileread);

		for (int c = 0; c < linenum; c++) {
			content.add(buffread.readLine());
		}
		buffread.close();
	}

	/**
	 * Einlesen der Daten des zweiten Result Trees
	 * 
	 * @throws IOException
	 *             wenn nicht eingelesen werden kann
	 */
	public void SecondReader() throws IOException {
		Hauptklasse main = new Hauptklasse();
		Linenumberreader linenumread = new Linenumberreader();

		pfad2 = main.getPfad2();
		linenumread.Secondlinereader();
		secondlinenum = linenumread.getSecondLinenum();

		FileReader fileread = new FileReader(pfad2);
		BufferedReader buffread = new BufferedReader(fileread);

		for (int c = 0; c < secondlinenum; c++) {
			secondcontent.add(buffread.readLine());
		}
		buffread.close();
	}

	/**
	 * Rückgabe der Contentliste
	 * 
	 * @return List
	 * 
	 * @author realMortiferum
	 * 
	 * 
	 */
	public List<String> getContent() {
		return content;
	}

	/**
	 * Rückgabe der Contentliste des zweiten Result Trees
	 * @return List
	 */
	public List<String> getSecondContent() {
		return secondcontent;
	}

	/**
	 * Splittet den Gesamtconten in Threatcontent
	 */
	public void ThreadSplitter() {
		
		createChart createChar = new createChart();
		highestThread = createChar.gethighestThread();
	
		for (int u = 0; u < highestThread; u++) {
             
			for (int d = 1; d < linenum; d++){
				String Test = content.get(d);
				String[] myStrings = Test.split(",");
				String threadnummer =  myStrings[5];
				threadnummer = threadnummer.substring(Math.max(threadnummer.length() - 4, 0));
				threadnummer = threadnummer.substring(threadnummer.indexOf("-") + 1);
				
				if(Integer.parseInt(threadnummer)== u+1){
					String load = myStrings[1];
					String thread = myStrings[5];
					String url = myStrings[13];
					String loadthreadurl = load+thread+url;
					splittedcontent.add(loadthreadurl);
				}
			}
		}
	}

	/**
	 * Gibt den Result Tree nach Threads geordnet aber ohne commata und nur mit load,thread und url zurück
	 * @return List
	 */
	public List<String> getSplittedThreads() {
		return splittedcontent;

	}
}
