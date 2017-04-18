package Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Linenumberreader {

	private String path;
	private static int linenumm;
	
	public void linereader() throws IOException{
		Pathsetter pathset = new Pathsetter();
		path = pathset.getPath();
		
		LineNumberReader lnr = new LineNumberReader(new FileReader(new File(path)));
		lnr.skip(Long.MAX_VALUE);
		linenumm = lnr.getLineNumber(); 
	}
	
	public int getLinenum(){
		return linenumm;
	}
}
