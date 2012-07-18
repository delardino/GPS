package Visual;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import reader.Reader;
import calculations.DistanceCalc;
import dijkstra.Dijkstra;
/*
 * Show route summary frame
 *  @author Michal Musialik
 */

import VisualApp.language;
import VisualApp.pictures;
import VisualApp.buttons;
import VisualApp.pictures;
import VisualApp.sizePosition;
/**
 *@author Michal Musialik
 * Display route summary class
 */


public class routeSummary extends JFrame implements ActionListener  {



	public static void run (){
		routeSummary mrx = new routeSummary ();
	}

	static dislpayinformation destInfo = new dislpayinformation();

	/**
	 * Loading settings from control classes
	 */
	sizePosition size = new sizePosition();
	buttons button = new buttons ();

	pictures pic = new pictures();

	/**
	 * Getting the saved pictures from MapWindowJFrame
	 */

	public ImageIcon icon2 = new ImageIcon("images/rs2.jpeg");
	private ImageIcon icon = new ImageIcon("images/rs.jpeg"); 

	private JLabel picture2 = new JLabel ();
	private JLabel picture = new JLabel ();

	public routeSummary(){

		/**
		 * Building buttons 
		 */
		JLabel menu = new JLabel(new ImageIcon 
				("images/rh_main_background.jpeg"));

		menu.setLayout(null);
		menu.setBounds(0, 0, 1280, 800);



		picture2.setBounds(1100, 300, 170, 100);
		picture.setBounds(0, 0, 1083, 796);

		button.getGoToMain().setBounds(size.getxLoc() + 1050,size.getyLoc() + 
				550, size.getxSize(), size.getySize());

		picture.setIcon(icon);
		picture2.setIcon(icon2);
		picture.setMaximumSize(new Dimension(200,300));

		button.getGoToMain().setIcon(pic.getBack());
		button.getGoToMain().setFont(new Font(language.font,Font.PLAIN,14));
		button.getGoToMain().setHorizontalTextPosition(SwingConstants.CENTER);
		button.getGoToMain().setBorderPainted(false);


		button.getGoToMain().setBorderPainted(false);
		button.getGoToMain().setForeground(Color.white);
		button.getGoToMain().setToolTipText
		(language.strTable[language.lang][9]);



		add(menu);

		menu.add(picture2);
		menu.add(picture);
		menu.add(button.getGoToMain());




		button.getGoToMain().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				setVisible(false);
				Option.run();
			}
		});

		setUndecorated(true);
		setTitle("Route Summary");
		setSize(size.getFrameXsize(), size.getFrameYsize());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(null);

	}
	/**
	 * Panel with drawing methods
	 */

	public void actionPerformed(ActionEvent arg0) {

		setVisible(false);
		Option.run();	
	}



}
