package Graph;

import java.util.Scanner;

public class Pathsetter {

	private static String pfad;

	public void setPath() {

		Scanner pfadinput = new Scanner(System.in);
		System.out.println("Pfad der Datei: ");
		pfad = pfadinput.nextLine();
		pfadinput.close();
	}
	
	public String getPath(){
		return pfad;
	}
}
