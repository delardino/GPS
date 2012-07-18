package parser;
import java.util.*;

/**
 *  This class creates tokens and helps for parsing NMEA
 * sentences
 * 
 * @author Aydan Halilov 
 */
public class tokenizer {

	 private String DELIMITER = ",";
	 private int currentPosition;
	 private int nextPosition;
	 private String s;
	 
	 public tokenizer(String s){
		 this.s = s;
		 this.currentPosition = 0;
		 this.nextPosition = s.indexOf(DELIMITER, currentPosition);
	 }
	 public boolean hasNext(){
		 return nextPosition != -1 && currentPosition <= nextPosition;
	 }
	 public String next()throws NoSuchElementException{
		 if(!hasNext())
			 throw new NoSuchElementException();
		 String next = s.substring(currentPosition,nextPosition);
		 currentPosition = nextPosition + 1;
		 nextPosition = s.indexOf(DELIMITER, currentPosition);
		 return next;
	 }
}
