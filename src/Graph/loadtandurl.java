package Graph;

import java.util.ArrayList;
import java.util.List;

public class loadtandurl {

	private static List<String> content = new ArrayList<String>();
	private static List<String> secondcontent = new ArrayList<String>();
	private static List<String> loadtime = new ArrayList<String>();
	private static List<String> secondloadtime = new ArrayList<String>();
	private static List<String> url = new ArrayList<String>();
	private static List<String> secondurl = new ArrayList<String>();
	private static List<String> thread = new ArrayList<String>();
	private int linenum;
	private int secondlinenum;
	private static int loadvalue;
	private static int threadvalue;
	private static int urlvalue;

	/**
	 * Herausfiltern der Ladezeit und der URL durch Kommasplit
	 * 
	 * @author realMortiferum
	 * 
	 * 
	 */
	public void loadtimeurl() {

		Filereader fileread = new Filereader();
		Linenumberreader linenumread = new Linenumberreader();
		Hauptklasse main = new Hauptklasse();

		content = fileread.getContent();
		linenum = linenumread.getLinenum();
		loadvalue = main.getLoadValue();
		threadvalue = main.getThreadValue();
		urlvalue = main.getUrlValue();

		for (int c = 1; c < linenum; c++) {
			String Test = content.get(c);

			String[] myStrings = Test.split(",");
			String load = myStrings[loadvalue];
			String threadString = myStrings[threadvalue];
			String urlString = myStrings[urlvalue];

			thread.add(threadString);
			loadtime.add(load);
			url.add(urlString);
		}
	}

	/**
	 * Herausfiltern der Ladezeit und URL des zweiten Result Trees
	 */
	public void Secondloadtimeurl() {

		Filereader fileread = new Filereader();
		Linenumberreader linenumread = new Linenumberreader();

		secondcontent = fileread.getSecondContent();
		secondlinenum = linenumread.getSecondLinenum();

		for (int c = 1; c < secondlinenum; c++) {
			String Test = secondcontent.get(c);

			String[] myStrings = Test.split(",");
			String load = myStrings[1];
			String urlString = myStrings[13];

			secondloadtime.add(load);
			secondurl.add(urlString);
		}
	}

	public void loadtimeurlsplitted() {

		Filereader fileread = new Filereader();
		Linenumberreader linenumread = new Linenumberreader();

		content = fileread.getSplittedThreads();
		linenum = linenumread.getLinenum();

		for (int c = 0; c < linenum-1; c++) {
			
			String urlString = content.get(c).substring(Math.max(content.get(c).length() - 5, 0));
			urlString = urlString.substring(urlString.indexOf("/") + 1);
			urlString = urlString.substring(0, urlString.indexOf("/"));
			
			String loadString = content.get(c).substring(0, content.get(c).indexOf("S"));
			
			String threadString = content.get(c).substring(0,content.get(c).indexOf("h"));
			threadString = threadString.substring(threadString.indexOf("-") + 1);
            			
			thread.add(threadString);
			loadtime.add(loadString);
			url.add(urlString);

		}
	}

	/**
	 * Rückgabe der Url-liste
	 * 
	 * @return List
	 * 
	 * @author realMortiferum
	 * 
	 * 
	 */
	public List<String> geturl() {
		return url;
	}

	/**
	 * Rückgabe der Url-Liste des zweiten Result Trees
	 * 
	 * @return List
	 */
	public List<String> getSecondurl() {
		return secondurl;
	}

	/**
	 * Rückgabe der Ladezeit-liste
	 * 
	 * @return List
	 * 
	 * @author realMortiferum
	 * 
	 * 
	 */
	public List<String> getloadtime() {
		return loadtime;
	}

	/**
	 * Rückgabe der Ladezeit des zweiten Result Trees
	 * 
	 * @return List
	 */
	public List<String> getSecondloadtime() {
		return secondloadtime;
	}

	/**
	 * Threadnummer wird weitergegeben
	 * 
	 * @return List
	 */
	public List<String> getThread() {
		return thread;
	}
}
