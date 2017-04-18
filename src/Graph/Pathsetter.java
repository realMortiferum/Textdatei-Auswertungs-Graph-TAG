package Graph;

import java.util.Scanner;

public class Pathsetter {

	private static String pfad;

	/* Aufnahme des Dateipfades
	 * 
	 * @author realMortiferum
	 * @date 2017/04/18
	 */
	public void setPath() {

		Scanner pfadinput = new Scanner(System.in);
		System.out.println("Pfad der Datei: ");
		pfad = pfadinput.nextLine();
		pfadinput.close();
	}
	
	/* Rückgabe des Dateipfades
	 * 
	 * @return String
	 * @author realMortiferum
	 * @date 2017/04/18
	 */
	public String getPath(){
		return pfad;
	}
}
