package Graph;

import java.util.Scanner;

public class Pathsetter {

	private static String pfad;
	private static String pfadjpg;

	/* Aufnahme des Dateipfades
	 * 
	 * @author realMortiferum
	 * @date 2017/04/18
	 */
	public void setPath() {

		Scanner pfadinput = new Scanner(System.in);
		System.out.println("Pfad der Datei: ");
		pfad = pfadinput.nextLine();
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
	public void Kopierpfad(){
		Scanner pfadinput2 = new Scanner(System.in);
		System.out.println("Wo soll der Graph gespeichert werden: ");
		pfadjpg = pfadinput2.nextLine();
		pfadinput2.close();
	}
	public String getPfadJpg(){
		return pfadjpg;
	}
}
