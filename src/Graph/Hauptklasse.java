package Graph;

import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
		Durchschnitt durchschnitt = new Durchschnitt();
		
		JFrame Hauptmenue = new JFrame("Result Tree Analyzer");
		Hauptmenue.setSize(1000,500);
		Hauptmenue.add(new JLabel("Auswahl der Result Tree Datei:"));
		Hauptmenue.setVisible(true);
		
		JDialog sicher = new JDialog();
		sicher.setTitle("Bestätigung");
		sicher.setSize(400,400);
		sicher.setModal(true);
		sicher.add(new JLabel("Sind sie sicher, dass sie die Datei hier speichern wollen?"));
		sicher.setVisible(true);


		
		
		pathset.setPath();
		reader.Reader();
		loadurl.loadtimeurl();
		createChart.creatChart();
		createChart.SavePieChart();
		createChart.SaveBarChart();
		durchschnitt.durchschnitt();
		
		
	}
}
