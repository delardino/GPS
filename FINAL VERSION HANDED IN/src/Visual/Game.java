package Visual;

import VisualApp.buttons;
import VisualApp.language;
import VisualApp.pictures;
import VisualApp.sizePosition;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import VisualApp.pictures;



/**
 * Game frame 
 * @author Michal Musilaik
 * 
 */




public class Game extends JFrame{

	public static void run (){
		Game mrx = new Game();
	}
	/**
	 * Loading settings from control classes
	 */
	pictures pic = new pictures ();
	sizePosition size = new sizePosition ();
	buttons button = new buttons();




	public Game(){
		/**
		 * Building buttons
		 */
		JLabel menu = new JLabel (new ImageIcon ("images/rh_main_background.jpeg"));

		menu.setLayout(null);


		button.getStravTheFox().setBounds(size.getxLoc() + 250, size.getyLoc()
				+ 170 , size.getxSizeBig(), size.getySizeBig());
		button.getFeedingDucks().setBounds(size.getxLoc() + 550, size.getyLoc()
				+ 170 , size.getxSizeBig() , size.getySizeBig());
		button.getBack().setBounds(size.getxLoc() + 1050,size.getyLoc() + 550, 
				size.getxSize(), size.getySize());

		button.getStravTheFox().setFont(new Font(language.font,Font.PLAIN,14));
		button.getFeedingDucks().setFont(new Font(language.font,Font.PLAIN,14));
		button.getBack().setFont(new Font(language.font,Font.PLAIN,14));

		button.getStravTheFox().setIcon(pic.getStarvethef());
		button.getFeedingDucks().setIcon(pic.getFeedingd());
		button.getBack().setIcon(pic.getBack());

		button.getStravTheFox().setBorderPainted(false);
		button.getFeedingDucks().setBorderPainted(false);
		button.getBack().setBorderPainted(false);


		menu.add(button.getStravTheFox());
		menu.add(button.getFeedingDucks());
		menu.add(button.getBack());

		button.getStravTheFox().setHorizontalTextPosition
		(SwingConstants.CENTER);
		button.getFeedingDucks().setHorizontalTextPosition
		(SwingConstants.CENTER);
		button.getBack().setHorizontalTextPosition(SwingConstants.CENTER);

		button.getBack().setBorderPainted(false);
		button.getBack().setForeground(Color.white);
		button.getBack().setToolTipText(language.strTable[language.lang][6]);

		button.getFeedingDucks().setBorderPainted(false);
		button.getFeedingDucks().setForeground(Color.white);
		button.getFeedingDucks().setToolTipText("Start Feeding Ducks Game");
		add(menu);



		/**
		 * Action listeners with with runnable games as jar files from 
		 * our term 1 project
		 */


		button.getStravTheFox().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{ 
				try {
					Runtime.getRuntime().exec("java -jar StarveTheFox.jar");
				} catch (IOException e1) {

					e1.printStackTrace();
				}



			}});

		button.getFeedingDucks().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{ 
				try {

					Runtime.getRuntime().exec("java -jar FeedingDucks.jar");

				} catch (IOException e1) {
					e1.printStackTrace();



				}

			}});

		button.getBack().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{ 
				Option.run();
				setVisible(false);

			}});

		setTitle("Game");
		setSize(1280, 800);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(null);


	}


}