package Graph;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Linenumberreader {

	private String path;
	private String path2;
	private static int linenumm;
	private static int linenumm2;

	/**
	 * Zeilenlänge der Datei herausfinden
	 * 
	 * @author realMortiferum
	 * @exception IOException wenn die Datei nicht eingelesen werden kann
	 * 
	 */
	public void linereader() throws IOException {
		Hauptklasse main = new Hauptklasse();
		path = main.getPfad();

		LineNumberReader lnr = new LineNumberReader(new FileReader(new File(path)));
		lnr.skip(Long.MAX_VALUE);
		linenumm = lnr.getLineNumber();
		lnr.close();
	}

	public void Secondlinereader() throws IOException {
		Hauptklasse main = new Hauptklasse();
		path2 = main.getPfad2();
		LineNumberReader lnr = new LineNumberReader(new FileReader(new File(path2)));
		lnr.skip(Long.MAX_VALUE);
		linenumm2 = lnr.getLineNumber();
		lnr.close();
	}

	/**
	 * Rückgabe der Zeilenanzahl
	 * 
	 * @return String
	 * 
	 * @author realMortiferum
	 * 
	 * 
	 */
	public int getLinenum() {
		return linenumm;
	}

	public int getSecondLinenum() {
		return linenumm2;
	}
}
