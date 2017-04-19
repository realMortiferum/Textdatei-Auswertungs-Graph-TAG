package Graph;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
	private static DefaultPieDataset data = new DefaultPieDataset();
	private static DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	private static JFreeChart chart = ChartFactory.createPieChart("Ladezeitverteilung", data, true, true, false);
	private static JFreeChart lineChart = ChartFactory.createBarChart("Ladezeit in ms", "URL", "Ladezeit", dataset,
			PlotOrientation.VERTICAL, false, true, false);
	private static String pathjpg;
	private int linenum;
	private int finallinenum;
	private int secondlinenum;

	/*
	 * Erstellen eines Kreis- und Balken-diagramm
	 * 
	 * @author realMortiferum
	 * 
	 * @date 2017/04/18
	 */
	public void creatChart() throws IOException{

		loadtandurl loadurl = new loadtandurl();
		Linenumberreader linenumm = new Linenumberreader();
		Filereader read = new Filereader();

		loadtime = loadurl.getloadtime();
		url = loadurl.geturl();
		linenum = linenumm.getLinenum();
        
		if(Hauptklasse.Compare2Trees() == 1 ){
			Hauptklasse.Choose2ResultTree();
			linenumm.Secondlinereader();
			secondlinenum = linenumm.getSecondLinenum();
			read.SecondReader();
			loadurl.Secondloadtimeurl();
            secondloadtime = loadurl.getSecondloadtime();
			secondurl = loadurl.getSecondurl();
			
			if(linenum < secondlinenum){
				finallinenum = linenum;
			}
			else {
				finallinenum = secondlinenum;
			}
			
			for (int c = 0; c < finallinenum - 1; c++) {
				
				String secondsubstring = secondurl.get(c).substring(Math.max(secondurl.get(c).length() - 4, 0));
				secondsubstring = secondsubstring.substring(secondsubstring.indexOf("/") + 1);
				secondsubstring = secondsubstring.substring(0, secondsubstring.indexOf("/"));
				

				String substring = url.get(c).substring(Math.max(url.get(c).length() - 4, 0));
				substring = substring.substring(substring.indexOf("/") + 1);
				substring = substring.substring(0, substring.indexOf("/"));


				dataset.setValue(Integer.parseInt(loadtime.get(c)), "Erster Result Tree", substring);
				dataset.setValue(Integer.parseInt(secondloadtime.get(c)), "Zweiter Result Tree", substring);
	}
			
			ChartFrame frame2 = new ChartFrame("Ladezeit v 0.1", lineChart);
			frame2.pack();
			frame2.setVisible(true);
		
		}
		else{
			
			for (int c = 0; c < linenum - 1; c++) {

				String substring = url.get(c).substring(Math.max(url.get(c).length() - 4, 0));
				substring = substring.substring(substring.indexOf("/") + 1);
				substring = substring.substring(0, substring.indexOf("/"));

				data.setValue(url.get(c), Integer.parseInt(loadtime.get(c)));
				dataset.setValue(Integer.parseInt(loadtime.get(c)), "Zeit", substring);
			}

			ChartFrame frame = new ChartFrame("Ladezeitverteilung v 0.1", chart);
			frame.pack();
			frame.setVisible(true);

			ChartFrame frame2 = new ChartFrame("Ladezeit v 0.1", lineChart);
			frame2.pack();
			frame2.setVisible(true);
		}
		
	}	

	public void SavePieChart() throws IOException {
		Hauptklasse main = new Hauptklasse();
		pathjpg = main.getSavePfad();
		if( pathjpg.substring(pathjpg.length()-4,pathjpg.length()).equals(".jpg") == false){
			pathjpg = pathjpg + ".jpg";
		}
		pathjpg = pathjpg.substring(0, pathjpg.indexOf(".")) + "-Pie-Chart"
				+ pathjpg.substring(pathjpg.indexOf("."), pathjpg.length());
		ChartUtilities.saveChartAsJPEG(new File(pathjpg), chart, 1920, 1080);
	}

	public void SaveBarChart() throws IOException {
		Hauptklasse main = new Hauptklasse();
		pathjpg = main.getSavePfad();
		if( pathjpg.substring(pathjpg.length()-4,pathjpg.length()).equals(".jpg") == false){
			pathjpg = pathjpg + ".jpg";
		}
		pathjpg = pathjpg.substring(0, pathjpg.indexOf(".")) + "-Bar-Chart"
				+ pathjpg.substring(pathjpg.indexOf("."), pathjpg.length());

		ChartUtilities.saveChartAsJPEG(new File(pathjpg), lineChart, 1920, 1080);
	}
}
