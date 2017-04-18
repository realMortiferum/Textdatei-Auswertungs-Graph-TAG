package Graph;

import java.io.IOException;

public class Hauptklasse {

	/* Aufrufen der Klassen -> Ablaufregelung 
	 * 
	 * @author realMortiferum
	 * @date 2017/04/18
	 */
	public static void main(String[] args) throws IOException{
		
		Pathsetter pathset = new Pathsetter();
		Filereader reader = new Filereader();
		loadtandurl loadurl = new loadtandurl();
		createChart createChart = new createChart();
		
		pathset.setPath();
		reader.Reader();
		loadurl.loadtimeurl();
		createChart.creatChart();
		
	}
}
