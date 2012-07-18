package Visual;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import VisualApp.language;

/**
 * Main class
 * @author Michal Musialik
 */


public class Main {
/**
 * File readers for saved language
 */
	static FileReader  reader ;
	static BufferedReader br;
	static String string=null ;

	public static void main (String [] args)throws FileNotFoundException{

		reader = new FileReader ("languade.txt");
		br = new BufferedReader(reader); 
		/**
		 * Reader compares file string and sets to last selected language
		 */
		try {

			if((string = br.readLine()) != null) {
				}
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 

		if (string.equals("polish")){
			language.lang=5;

		}
		if (string.equals("swedish")){
			language.lang=1;

		}
		if (string.equals("turkish")){
			language.lang=3;

		}
		if (string.equals("english")){
			language.lang=0;

		}
		if (string.equals("persian")){
			language.lang=4;
		}
		if (string.equals("etiopian")){
			language.lang=2;

		}
		
/**
 * Runs next frame thats animation
 */
		AnimationFrame.run();
		
		
	}
}
