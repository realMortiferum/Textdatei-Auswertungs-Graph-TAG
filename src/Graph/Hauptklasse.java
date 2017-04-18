package Graph;

import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Hauptklasse {

	private static String pfad;
	private static String savepfad;

	/*
	 * Aufrufen der Klassen -> Ablaufregelung
	 * 
	 * @author realMortiferum
	 * 
	 * @date 2017/04/18
	 */
	public static void main(String[] args) throws IOException {

		Filereader reader = new Filereader();
		loadtandurl loadurl = new loadtandurl();
		createChart createChart = new createChart();
		Durchschnitt durchschnitt = new Durchschnitt();

		FileFilter filter = new FileNameExtensionFilter("Textdateien", "txt");

		JFileChooser chooseResultTree = new JFileChooser();

		chooseResultTree.addChoosableFileFilter(filter);

		int rueckgabeWert = chooseResultTree.showOpenDialog(null);
		if (rueckgabeWert == JFileChooser.APPROVE_OPTION) {
			pfad = String.valueOf(chooseResultTree.getSelectedFile());
		}

		reader.Reader();
		loadurl.loadtimeurl();

		JFileChooser chooseSavePath = new JFileChooser();

		int rueckgabeWert2 = chooseSavePath.showSaveDialog(null);
		if (rueckgabeWert2 == JFileChooser.APPROVE_OPTION) {
			savepfad = String.valueOf(chooseSavePath.getSelectedFile());
		}

		createChart.creatChart();
		createChart.SavePieChart();
		createChart.SaveBarChart();
		durchschnitt.durchschnitt();
		int durchschnittint = durchschnitt.getDurchschnitt();
		
		JOptionPane.showMessageDialog(null, "Die Durchschnittliche Ladezeit betrug: " + durchschnittint + " ms.");

	}

	public String getPfad() {
		return pfad;
	}

	public String getSavePfad() {
		return savepfad;
	}
}
