package Graph;

import java.util.ArrayList;
import java.util.List;

public class Durchschnitt {
	
	private static List<String> loadtime = new ArrayList<String>();
	private int d;

	public void durchschnitt(){
		
		loadtandurl loadurl = new loadtandurl();
		Linenumberreader linnum = new Linenumberreader();
		
		int linenumm = linnum.getLinenum();
		loadtime = loadurl.getloadtime();
		d = 0;
		
		for(int c = 0; c < linenumm-1; c++){
			d = d + Integer.parseInt(loadtime.get(c));
		}
		int durchschnitt = d/linenumm;
		System.out.println("Der Durchschnitt ist: " + durchschnitt + " ms");
		
	}
}
