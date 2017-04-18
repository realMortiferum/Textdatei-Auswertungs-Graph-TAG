package Graph;

import java.util.ArrayList;
import java.util.List;

public class Durchschnitt {
	
	private static List<String> loadtime = new ArrayList<String>();
	private int d;
	private static int durchschnitt;

	public void durchschnitt(){
		
		loadtandurl loadurl = new loadtandurl();
		Linenumberreader linnum = new Linenumberreader();
		
		int linenumm = linnum.getLinenum();
		loadtime = loadurl.getloadtime();
		d = 0;
		
		for(int c = 0; c < linenumm-1; c++){
			d = d + Integer.parseInt(loadtime.get(c));
		}
		durchschnitt = d/linenumm;		
	}
	public int getDurchschnitt(){
		return durchschnitt;
	}
}
