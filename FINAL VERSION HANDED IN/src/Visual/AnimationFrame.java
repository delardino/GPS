package Visual;
import java.awt.*;
import javax.swing.*;

import VisualApp.pictures;
import VisualApp.sizePosition;


/**
 * Animation frame
 * @author Michal Musialik
 */

public class AnimationFrame extends JFrame {

	public static void run (){
		AnimationFrame  run = new AnimationFrame  ();
	}


	public AnimationFrame() {


		pictures pic = new pictures ();
		sizePosition size = new sizePosition ();

		JFrame frame = new JFrame();

		frame.add(new ImagePanel());
		frame.setSize(size.getFrameXsize() + 105, size.getFrameYsize());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setVisible(true);

		/**
		 * Getting animation
		 */
		ImageIcon imageIcon = new ImageIcon("images/intro.gif");
		Image image = imageIcon.getImage();




		/**
		 * Timer for automatic frame switch, time is set in setPosition class.
		 */
		long t0,t1;
		t0=System.currentTimeMillis();
		do{
			t1=System.currentTimeMillis();
		}
		while (t1 - t0 < size.getTimeMili());
		frame.setVisible(false);
		Option.run ();




	}  
	/**
	 * Inner class for Image drawing
	 */

	static class ImagePanel extends JPanel {
		ImageIcon imageIcon = new ImageIcon("images/intro.gif");
		Image image = imageIcon.getImage();


		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			if (image != null)
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		}
	}
}
