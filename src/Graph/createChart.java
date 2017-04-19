package Graph;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ChartUtilities;

public class createChart {

	private static List<String> loadtime = new ArrayList<String>();
	private static List<String> secondloadtime = new ArrayList<String>();
	private static List<String> url = new ArrayList<String>();
	private static List<String> secondurl = new ArrayList<String>();
	private static List<String> threadlist = new ArrayList<String>();
	private static List<Integer> threadint = new ArrayList<Integer>();
	private static DefaultPieDataset data = new DefaultPieDataset();
	private static DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	private static JFreeChart chart = ChartFactory.createPieChart("Ladezeitverteilung", data, false, true, false);
	private static JFreeChart lineChart = ChartFactory.createBarChart("Ladezeit in ms", "ID", "Ladezeit", dataset,
			PlotOrientation.VERTICAL, true, true, false);
	private static String pathjpg;
	private static int linenum;
	private static int highestThread;
	private int finallinenum;
	private int secondlinenum;
	private int loadtimetotal;
	static int b;

	/**
	 * Erstellen eines Kreis- und Balken-diagramm
	 * 
	 * @author realMortiferum
	 * @exception IOException
	 *                wenn die Datei nicht eingelesen werden kann
	 * 
	 */
	public void creatChart() throws IOException {

		loadtandurl loadurl = new loadtandurl();
		Linenumberreader linenumm = new Linenumberreader();

		loadtime = loadurl.getloadtime();
		url = loadurl.geturl();
		threadlist = loadurl.getThread();
		linenum = linenumm.getLinenum();

		if (Hauptklasse.Compare2Trees() == 1) {
			createCompareChart();
		} else {
			for (int c = 0; c < linenum - 1; c++) {

				String substring = url.get(c).substring(Math.max(url.get(c).length() - 4, 0));
				substring = substring.substring(substring.indexOf("/") + 1);
				substring = substring.substring(0, substring.indexOf("/"));

				String thread = threadlist.get(c).substring(Math.max(threadlist.get(c).length() - 4, 0));
				thread = thread.substring(thread.indexOf("-") + 1);
				loadtimetotal = loadtimetotal + Integer.parseInt(loadtime.get(c));

				data.setValue("Thread: " + thread + " ID:" + substring + " Ladezeit gesamt: " + loadtime.get(c) + "ms",
						Integer.parseInt(loadtime.get(c)));
				dataset.setValue(Integer.parseInt(loadtime.get(c)), "Thread: " + thread, substring);
			}

			ChartFrame frame = new ChartFrame("Ladezeitverteilung v 0.1", chart);
			frame.pack();
			frame.setVisible(true);

			ChartFrame frame2 = new ChartFrame("Ladezeit v 0.1", lineChart);
			frame2.pack();
			frame2.setVisible(true);
		}

	}

	/**
	 * Erstellen eines Balkendiagramms mit den Werten des ersten und des zweiten
	 * Result Trees
	 * 
	 * @exception IOException
	 *                wenn die Datei nicht eingelesen werden kann
	 */
	public void createCompareChart() throws IOException {
		loadtandurl loadurl = new loadtandurl();
		Linenumberreader linenumm = new Linenumberreader();
		Filereader read = new Filereader();

		Hauptklasse.Choose2ResultTree();
		linenumm.Secondlinereader();
		secondlinenum = linenumm.getSecondLinenum();
		read.SecondReader();
		loadurl.Secondloadtimeurl();
		secondloadtime = loadurl.getSecondloadtime();
		secondurl = loadurl.getSecondurl();

		if (linenum < secondlinenum) {
			finallinenum = linenum;
		} else {
			finallinenum = secondlinenum;
		}

		for (int c = 0; c < finallinenum - 1; c++) {
			String thread = threadlist.get(c).substring(Math.max(threadlist.get(c).length() - 4, 0));
			thread = thread.substring(thread.indexOf("-") + 1);

			threadint.add(Integer.parseInt(thread));
			highestThread = Collections.max(threadint);
		}

		if (highestThread != 1) {
			multipleThreadCharDialog();
			if (b == 1) {
				multipleThreadChar();
			}
		} else {

			for (int c = 0; c < finallinenum - 1; c++) {

				String secondsubstring = secondurl.get(c).substring(Math.max(secondurl.get(c).length() - 4, 0));
				secondsubstring = secondsubstring.substring(secondsubstring.indexOf("/") + 1);
				secondsubstring = secondsubstring.substring(0, secondsubstring.indexOf("/"));

				String substring = url.get(c).substring(Math.max(url.get(c).length() - 4, 0));
				substring = substring.substring(substring.indexOf("/") + 1);
				substring = substring.substring(0, substring.indexOf("/"));

				String thread = threadlist.get(c).substring(Math.max(threadlist.get(c).length() - 4, 0));
				thread = thread.substring(thread.indexOf("-") + 1);

				dataset.setValue(Integer.parseInt(loadtime.get(c)), "Erster Result Tree", substring);
				dataset.setValue(Integer.parseInt(secondloadtime.get(c)), "Zweiter Result Tree", substring);
			}

			ChartFrame frame2 = new ChartFrame("Ladezeit v 0.1", lineChart);
			frame2.pack();
			frame2.setVisible(true);
		}
	}

	/**
	 * Speichern des Kreisdiagrammes
	 * 
	 * @exception IOException
	 *                wenn die Datei nicht eingelesen werden kann
	 */
	public void SavePieChart() throws IOException {
		Hauptklasse main = new Hauptklasse();
		pathjpg = main.getSavePfad();
		if (pathjpg.substring(pathjpg.length() - 4, pathjpg.length()).equals(".jpg") == false) {
			pathjpg = pathjpg + ".jpg";
		}
		pathjpg = pathjpg.substring(0, pathjpg.indexOf(".")) + "-Pie-Chart"
				+ pathjpg.substring(pathjpg.indexOf("."), pathjpg.length());
		ChartUtilities.saveChartAsJPEG(new File(pathjpg), chart, 1920, 1080);
	}

	/**
	 * Speichern des Balkendiagrammes
	 * 
	 * @exception IOException
	 *                wenn die Datei nicht eingelesen werden kann
	 */
	public void SaveBarChart() throws IOException {
		Hauptklasse main = new Hauptklasse();
		pathjpg = main.getSavePfad();
		if (pathjpg.substring(pathjpg.length() - 4, pathjpg.length()).equals(".jpg") == false) {
			pathjpg = pathjpg + ".jpg";
		}
		pathjpg = pathjpg.substring(0, pathjpg.indexOf(".")) + "-Bar-Chart"
				+ pathjpg.substring(pathjpg.indexOf("."), pathjpg.length());

		ChartUtilities.saveChartAsJPEG(new File(pathjpg), lineChart, 1920, 1080);
	}

	/**
	 * Erstellt X-Graphen wenn X-die Anzahl der Threads ist
	 * 
	 * @throws IOException
	 *             wenn die Daten nicht eingelesen werden können
	 */
	public void multipleThreadChar() throws IOException {

		Filereader read = new Filereader();
		loadtandurl loadurl = new loadtandurl();
		read.ThreadSplitter();
		loadurl.loadtimeurlsplitted();
		url = loadurl.geturl();
		loadtime = loadurl.getloadtime();
		
		int a = linenum/highestThread;
		
		
		/*
		 * -> die url und loadtimeliste ist sortiert nach den threads
		 *    die anzahl der einträge der jeweiligen threads in der url/loadt. liste gibt a an
		 *    so kann in der theorie ein dialog erstellt werden, welcher nach dem graphen für thread 1 
		 *    fragt ob man sich den graphen für die werte von thread 2 anschauen will
		 *    sollte dies der fall sein so erstellt er den gleichen graphen neu aber zählt diesmal 
		 *    die listen von der n-ten darstellung * a für (c = n*a, c<c+a, c++) ab und gibt den neuen graph aus
		 *    
		 * 
		 */
		
		
		
		

	}

	/**
	 * Dialog welcher Fragt ob mehrere Graphen bei multiplen Threads angelegt
	 * werden sollen
	 * 
	 * @return Integer
	 */
	public int multipleThreadCharDialog() {
		b = 0;
		if (JOptionPane.showConfirmDialog(null,
				"Es sind mehrere Threads vorhanden!"
						+ "\nWollen sie sich für jeden Thread einen Graphen anzeigen lassen?",
				"Threads", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			return b = b + 1;
		} else {
			return b;
		}
	}

	public int gethighestThread(){
		return highestThread;
	}
}
