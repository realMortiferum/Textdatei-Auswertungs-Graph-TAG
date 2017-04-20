package Graph;

import java.io.IOException;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Hauptklasse {

	private static String pfad;
	private static String pfad2;
	private static String savepfad;
	private static String loadvalue;
	private static String threadvalue;
	private static String urlvalue;
	private static int a;
	private static int b;

	/**
	 * Aufrufen der Klassen zur Ablaufregelung
	 * 
	 * @author realMortiferum
	 * @param args
	 *            the user input
	 * @exception IOException
	 *                Wenn die Dateien nicht eingelesen oder geschrieben werden
	 *                können
	 */
	public static void main(String[] args) throws IOException {

		Filereader reader = new Filereader();
		loadtandurl loadurl = new loadtandurl();
		createChart createChart = new createChart();

		ChooseResultTree();
		reader.Reader();
		ChooseCompareValues();
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

	/**
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

	/**
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

	/**
	 * Gibt wieder ob die Threads im Graph getrennt oder zusammen betrachtet werden sollen
	 * @return Integer
	 */
	public static int DontCompareThreads() {
		a = 0;
		if (JOptionPane.showConfirmDialog(null,
				"Wollen sie die Threads vergleichen oder haben sie durchlaufend die Laufzeit getestet?",
				"Vergleich Threads?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			return a = a + 1;
		} else {
			return a;
		}
	}

	/**
	 * Fragt ob die IDs sortiert werden sollen
	 * @return Integer
	 */
	public static int SortIDs() {
		a = 0;
		if (JOptionPane.showConfirmDialog(null,
				"Wollen sie die IDs nach ihrer Größe sortieret angezeigt bekommen?",
				"Sortiere Threads?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			return a = a + 1;
		} else {
			return a;
		}
	}
	
	/**
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

	/**
	 * Nimmt input an, welcher die Stellen definiert an denen die zu vergleichenden Daten stehen
	 */
	public static void ChooseCompareValues() {
		Filereader read = new Filereader();
		List<String> content = read.getContent();
		String example = content.get(1);
		
		JTextField loadField = new JTextField(5);
		JTextField threadField = new JTextField(5);
		JTextField urlField = new JTextField(5);

				
		JPanel myPanel = new JPanel();
		JLabel bsp = new JLabel(" Bsp. Zeile: ");
		JLabel exa = new JLabel(example);
		JLabel load = new JLabel("Load:");
		JLabel thread = new JLabel("Thread:");
		JLabel url = new JLabel("URL:");
		
		
		myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
		myPanel.add(bsp);
		myPanel.add(exa);
		myPanel.add(load);
		myPanel.add(loadField);
		myPanel.add(Box.createHorizontalStrut(15));
		myPanel.add(thread);
		myPanel.add(threadField);
		myPanel.add(Box.createHorizontalStrut(15)); 
		myPanel.add(url);
		myPanel.add(urlField);

		int result = JOptionPane.showConfirmDialog(null, myPanel, "Bitte geben sie die Stellen der zu vergleichenden Werte im Result Tree an! (Die erste Stelle ist die 0)",
				JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			loadvalue = loadField.getText();
			threadvalue = threadField.getText();
			urlvalue = urlField.getText();
		}
	}

	/**
	 * Gibt den Wert der Stelle für die Ladezeit wieder
	 * @return Integer
	 */
	public int getLoadValue(){
		return Integer.parseInt(loadvalue);
	}
	
	/**
	 * Gibt den Wert der Stelle für den Thread wieder	
	 * @return Integer
	 */
	public int getThreadValue(){
		return Integer.parseInt(threadvalue);
	}
	
	/**
	 * Gibt den Wert der Stelle für die URL wieder	
	 * @return Integer
	 */
	public int getUrlValue(){
		return Integer.parseInt(urlvalue);
	}
	
	/**
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

	/**
	 * JOptionPaneDialog um zu fragen ob die Graphen gespeichert werden sollen
	 * 
	 * @return Integer
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

	/**
	 * Rückgabe des ersten Dateipfades
	 * 
	 * @return String
	 */
	public String getPfad() {
		return pfad;
	}

	/**
	 * Rückgabe des zweiten Dateipfades
	 * 
	 * @return String
	 */
	public String getPfad2() {
		return pfad2;
	}

	/**
	 * Rückgabe des Speicherpfades
	 * 
	 * @return String
	 */
	public String getSavePfad() {
		return savepfad;
	}
}
