package Graph;

import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;


public class createChart {

	private static List<String> loadtime = new ArrayList<String>();
	private static List<String> url = new ArrayList<String>();
	private int linenum;
	
	public void creatChart(){
		
		loadtandurl loadurl = new loadtandurl();
		Linenumberreader linenumm = new Linenumberreader();
		
		
		loadtime = loadurl.getloadtime();
		url = loadurl.geturl();
        linenum = linenumm.getLinenum();
		
		
		DefaultPieDataset data = new DefaultPieDataset();
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		for (int c = 0; c < linenum-1; c++ ){
			
		String substring = url.get(c).substring(Math.max(url.get(c).length() - 4, 0));
		substring = substring.substring(substring.indexOf("/") + 1);
		substring = substring.substring(0, substring.indexOf("/"));
		
		data.setValue(url.get(c), Integer.parseInt(loadtime.get(c)));
		dataset.setValue(Integer.parseInt(loadtime.get(c)),"Zeit", substring);
		}
		
		JFreeChart chart = ChartFactory.createPieChart("Ladezeitverteilung", data, true, true, false);
		
		ChartFrame frame = new ChartFrame("Ladezeitverteilung v 0.1", chart);
		frame.pack();
		frame.setVisible(true);
		

		
		JFreeChart lineChart = ChartFactory.createBarChart("Ladezeit in ms", "URL", "Ladezeit", dataset, PlotOrientation.VERTICAL, false, true, false);
		
		ChartFrame frame2 = new ChartFrame("Ladezeit v 0.1", lineChart);
		frame2.pack();
		frame2.setVisible(true);
		
	}
	
}
