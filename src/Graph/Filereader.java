package Graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Filereader {

	private String pfad;
	private int linenum;
	private static List<String> content = new ArrayList<String>();
	private static List<String> content2 = new ArrayList<String>();

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

	/*
	 * R�ckgabe der Contentliste
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
	public List<String> getContent2() {
		return content2;
	}
}
