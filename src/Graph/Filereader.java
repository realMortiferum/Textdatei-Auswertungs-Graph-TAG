package Graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Filereader {

	private String pfad;
	private String pfad2;
	private int linenum;
	private int secondlinenum;
	private static List<String> content = new ArrayList<String>();
	private static List<String> secondcontent = new ArrayList<String>();

	/*
	 * Einlesen des Dateiinhaltes, welcher in einer Liste (content)gespeichert
	 * wird
	 * 
	 * @author realMortiferum
	 * 
	 * @date 2017/04/18
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

	/*
	 * Rückgabe der Contentliste
	 * 
	 * @return List
	 * 
	 * @author realMortiferum
	 * 
	 * @date 2017/04/18
	 */
	public List<String> getContent() {
		return content;
	}

	public List<String> getSecondContent() {
		return secondcontent;
	}
}
