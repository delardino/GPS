package screenShot;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

/**
 * The ScreenShot class takes a screen shot of the whole screen and saves it 
 * as a .jpeg file. The class is supposed to be used after a completed 
 * navigation session to be able to look upon the traveled route, 
 * both immediately after the session and later to see the last
 * navigation session.
 * 
 * @author Magnus Bergqvist
 */
public class ScreenShot {

	public static void captureScreen() /*throws Exception*/ {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRectangle = new Rectangle(0,0,1083,796);
		Rectangle screenRectangle2 = new Rectangle(1105, 100, 155, 100);
		try{
			Robot robot = new Robot();
			BufferedImage image = robot.createScreenCapture(screenRectangle);
			ImageIO.write(image, "jpeg", new File("images/rs.jpeg"));
			BufferedImage image2 = robot.createScreenCapture(screenRectangle2);
			ImageIO.write(image2, "jpeg", new File("images/rs2.jpeg"));
		}
		catch (Throwable t){
			System.out.println("Could not create Robot in ScreenShot.class");
		}
	}
}
