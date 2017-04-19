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
	private int linenum;
	private int secondlinenum;

	/*
	 * Herausfiltern der Ladezeit und der URL durch Kommasplit
	 * 
	 * @author realMortiferum
	 * 
	 * @date 2017/04/18
	 */
	public void loadtimeurl() {

		Filereader fileread = new Filereader();
		Linenumberreader linenumread = new Linenumberreader();

		content = fileread.getContent();
		linenum = linenumread.getLinenum();

		for (int c = 1; c < linenum; c++) {
			String Test = content.get(c);

			String[] myStrings = Test.split(",");
			String load = myStrings[1];
			String urlString = myStrings[13];

			loadtime.add(load);
			url.add(urlString);
		}
	}
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

	/*
	 * Rückgabe der Url-liste
	 * 
	 * @return List
	 * 
	 * @author realMortiferum
	 * 
	 * @date 2017/04/18
	 */
	public List<String> geturl() {
		return url;
	}
	public List<String> getSecondurl() {
		return secondurl;
	}


	/*
	 * Rückgabe der Ladezeit-liste
	 * 
	 * @return List
	 * 
	 * @author realMortiferum
	 * 
	 * @date 2017/04/18
	 */
	public List<String> getloadtime() {
		return loadtime;
	}
	public List<String> getSecondloadtime() {
		return secondloadtime;
	}
}
