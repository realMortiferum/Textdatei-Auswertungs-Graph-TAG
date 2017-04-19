package Graph;

import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Hauptklasse {

	private static String pfad;
	private static String pfad2;
	private static String savepfad;
	private static int a;
	private static int b;

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

		ChooseResultTree();
		reader.Reader();
		loadurl.loadtimeurl();
		createChart.creatChart();
		SaveFileDialog();

		if (b == 1 && a == 1) {
			ChooseSavefile();
			createChart.SaveBarChart();
		} else if (b == 1 && a == 0) {
			ChooseSavefile();
			createChart.SaveBarChart();
			createChart.SavePieChart();
		}

	}

	/*
	 * JFileChooser zur Auswahl der zu analysierenden Datei
	 * 
	 */
	public static void ChooseResultTree() {
		FileFilter filter = new FileNameExtensionFilter("Textdateien", "txt");
		JFileChooser chooseResultTree = new JFileChooser();
		chooseResultTree.addChoosableFileFilter(filter);
		int rueckgabeWert = chooseResultTree.showOpenDialog(null);
		if (rueckgabeWert == JFileChooser.APPROVE_OPTION) {
			pfad = String.valueOf(chooseResultTree.getSelectedFile());
		}
	}

	/*
	 * JFileChooser zum auswählen einer zweiten zu vergleichenden Datei
	 * 
	 */
	public static void Choose2ResultTree() {
		FileFilter filter2 = new FileNameExtensionFilter("Textdateien", "txt");
		JFileChooser chooseResultTree2 = new JFileChooser();
		chooseResultTree2.addChoosableFileFilter(filter2);
		int rueckgabeWert3 = chooseResultTree2.showOpenDialog(null);
		if (rueckgabeWert3 == JFileChooser.APPROVE_OPTION) {
			pfad2 = String.valueOf(chooseResultTree2.getSelectedFile());
		}
	}

	/*
	 * JFileChooser zum auswählen des Speicherortes der Graphen
	 * 
	 */
	public static void ChooseSavefile() {
		JFileChooser chooseSavePath = new JFileChooser();
		int rueckgabeWert2 = chooseSavePath.showSaveDialog(null);
		if (rueckgabeWert2 == JFileChooser.APPROVE_OPTION) {
			savepfad = String.valueOf(chooseSavePath.getSelectedFile());
		}

	}

	/*
	 * JOptionPaneDialog um zu fragen ob eine zweite Datei mit der ersten
	 * verglichen werden soll
	 * 
	 * @return int
	 */
	public static int Compare2Trees() {
		a = 0;
		if (JOptionPane.showConfirmDialog(null,
				"Wollen sie einen zweiten Result Tree vergleichen?"
						+ "\n Achtung! Werte, welche nur einer der Trees besitzen werden ignoriert!",
				"Vergleich", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			return a = a + 1;
		} else {
			return a;
		}
	}

	/*
	 * JOptionPaneDialog um zu fragen ob die Graphen gespeichert werden sollen
	 * 
	 * @return int
	 */
	public static int SaveFileDialog() {
		b = 0;
		if (JOptionPane.showConfirmDialog(null, "Wollen sie die Graphen speichern?", "Speichern",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			return b = b + 1;
		} else {
			return b;
		}
	}

	/*
	 * Rückgabe des ersten Dateipfades
	 * 
	 * @return String
	 */
	public String getPfad() {
		return pfad;
	}

	/*
	 * Rückgabe des zweiten Dateipfades
	 * 
	 * @return String
	 */
	public String getPfad2() {
		return pfad2;
	}

	/*
	 * Rückgabe des Speicherpfades
	 * 
	 * @return String
	 */
	public String getSavePfad() {
		return savepfad;
	}
}
