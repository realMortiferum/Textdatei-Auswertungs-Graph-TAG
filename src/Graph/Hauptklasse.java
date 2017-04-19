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
        
		
        ChooseResultTree();
		reader.Reader();
		loadurl.loadtimeurl();
        createChart.creatChart();
        Choose2ResultTree();
		ChooseSavefile();
        createChart.SavePieChart();
		createChart.SaveBarChart();
        durchschnitt.durchschnitt();
		int durchschnittint = durchschnitt.getDurchschnitt();
		
		JOptionPane.showMessageDialog(null, "Die Durchschnittliche Ladezeit betrug: " + durchschnittint + " ms.");

	}
	
	public static void ChooseResultTree(){
		FileFilter filter = new FileNameExtensionFilter("Textdateien", "txt");
        JFileChooser chooseResultTree = new JFileChooser();
        chooseResultTree.addChoosableFileFilter(filter);
        int rueckgabeWert = chooseResultTree.showOpenDialog(null);
		if (rueckgabeWert == JFileChooser.APPROVE_OPTION) {
			pfad = String.valueOf(chooseResultTree.getSelectedFile());
		}
	}

	public static void Choose2ResultTree(){
		FileFilter filter2 = new FileNameExtensionFilter("Textdateien", "txt");
		JFileChooser chooseResultTree2 = new JFileChooser();
		chooseResultTree2.addChoosableFileFilter(filter2);
		int rueckgabeWert3 = chooseResultTree2.showOpenDialog(null);
		if (rueckgabeWert3 == JFileChooser.APPROVE_OPTION) {
			pfad2 = String.valueOf(chooseResultTree2.getSelectedFile());
		}
	}

	public static void ChooseSavefile(){
		JFileChooser chooseSavePath = new JFileChooser();
        int rueckgabeWert2 = chooseSavePath.showSaveDialog(null);
		if (rueckgabeWert2 == JFileChooser.APPROVE_OPTION) {
			savepfad = String.valueOf(chooseSavePath.getSelectedFile());
		}

	}

	public String getPfad() {
		return pfad;
	}
	
	public String getPfad2() {
		return pfad2;
	}

	public String getSavePfad() {
		return savepfad;
	}
}
