package calculations;

/**
 * The Sleep class offers a number of methods to be called to get pauses
 * of various lengths. This way the try and catch parts doesn't have to
 * be included in all classes where a thread sleep is needed.
 * 
 * @author Magnus Bergqvist
 */
public class Sleep {
	
	public static void sleep1(){
		try{
			Thread.sleep(1);
		}
		catch(Exception e){
			System.out.println("");
		}
	}
	
	public static void sleep30(){
		try{
			Thread.sleep(30);
		}
		catch(Exception e){
			System.out.println("");
		}
	}
	
	public static void sleep100(){
		try{
			Thread.sleep(100);
		}
		catch(Exception e){
			System.out.println("");
		}
	}
	
	public static void sleep1000(){
		try{
			Thread.sleep(1000);
		}
		catch(Exception e){
			System.out.println("");
		}
	}
}
