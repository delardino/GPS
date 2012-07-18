package Visual;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import calculations.DistanceCalc;
import calculations.PositionCalc;

import dijkstra.*;

import mainStart.NavigationStart;
import mapView.MapView;

import reader.Reader;
import screenShot.ScreenShot;

import VisualApp.Clock;
import VisualApp.MP3Player;
import VisualApp.language;
import VisualApp.pictures;
import VisualApp.buttons;
import VisualApp.pictures;
import VisualApp.sizePosition;


/**
 * The MapWindowJFrame class creates the JFrame for the navigation map view.
 * It creates buttons and additional panels for different information
 * 
 * @author Michal Musialik, Magnus Bergqvist
 */


public class MapWindowJFrame extends JFrame implements ActionListener{

	/**
	 * Loading control classes
	 */	

	pictures pic = new pictures ();
	sizePosition size = new sizePosition();
	public static buttons button = new buttons ();

	/**
	 * Setting the timer variables
	 */

	public Timer stopper = new Timer(10, this);
	public int secs = 0;
	public int mins = 0;
	public int hrs = 0;
	public JLabel displayTimer;
	private DecimalFormat dFormat = new DecimalFormat("00");




	private String msg = "Speed"; 

	/**
	 * Loading the MP3 files for direction
	 */
	private static MP3Player rigth = new MP3Player ("sound/rigth.mp3");
	private static MP3Player left = new MP3Player ("sound/left.mp3");
	private static MP3Player foward = new MP3Player ("sound/foward.mp3");
	private static MP3Player arrived = new MP3Player ("sound/arrived.mp3");

	/**
	 * Loading images for directions
	 */
	private static ImageIcon leftTurn = new ImageIcon ("" +
	"images/vanstersvang.png");
	private static ImageIcon rightTurn = new ImageIcon 
	("" +"images/hogersvang.png");
	private static ImageIcon forward = new ImageIcon ("images/rakt-fram.png");
	private static ImageIcon stop = new ImageIcon ("images/stop.png");

	private static JLabel dirrection = new JLabel ();


	public clockPanel clock = new clockPanel ();

	public static JLabel picshow; //= new JLabel();

	public static JPanel menu = new JPanel (null);
	public JLabel shade = new JLabel (pic.getShade()); 
	public JPanel distancePanel = new JPanel();

	/**
	 * Loading map 
	 */


	public JLabel statuspic = new JLabel (new ImageIcon("" +
	"images/statusbarback.jpg") );
	public JLabel mapPicture = new JLabel(new ImageIcon("map/map.jpeg"));

	public MapWindowJFrame(){




		/**
		 * Loaction and size of map
		 */

		mapPicture.setSize(1083, 796);
		mapPicture.setLocation(0,0);

		displayTimer = new JLabel();

		menu.setLayout(null);
		menu.setBounds(0, 0, 1280, 800);

		/**
		 * Building buttons
		 */

		shade.setBounds(1150, 530, size.getxSize(), size.getySize());
		menu.setBackground(Color.BLACK);
		statuspic.setBounds(1082,-2,197,800);

		clock.setBounds(1105, 50, size.getxSize()+50 , size.getySize()-50);
		clock.setBackground(Color.YELLOW);

		displayTimer.setBounds(1105, 450, 100, 100);
		picshow.setBounds(1100, 260, 163, 122);
		

		button.getRouteSummary().setBounds(1150, 530, size.getxSize(), 
				size.getySize());
		dirrection.setBounds(1110, 400,size.getxSize(), size.getySize());
		button.getBack().setBounds(size.getxLoc() + 1050,size.getyLoc() + 550, 
				size.getxSize(), size.getySize());




		button.getBack().setHorizontalTextPosition(SwingConstants.CENTER);

		button.getRouteSummary().setHorizontalTextPosition(
				SwingConstants.CENTER);

		button.getBack().setIcon(pic.getBack());

		button.getRouteSummary().setIcon(pic.getSmallroute());

		picshow.setBackground(Color.RED);

		button.getBack().setFont(new Font(language.font,Font.PLAIN,14));

		button.getRouteSummary().setFont(new Font(language.font,Font.PLAIN,14));

		clock.setForeground(Color.BLUE);
		clock.setFont(new Font ("Arial",Font.BOLD,14));


		button.getBack().setBorderPainted(false);
		button.getBack().setForeground(Color.white);
		button.getBack().setToolTipText(language.strTable[language.lang][6]);


		button.getRouteSummary().setBorderPainted(false);

		button.getRouteSummary().setForeground(Color.white);

		button.getRouteSummary().setToolTipText(
				language.strTable[language.lang][8]);

		dirrection.setIcon(null);

		distancePanel.setBounds(1105, 100, 155, 100);

		distancePanel.setBackground(Color.yellow);

		menu.add(distancePanel);

		menu.add(picshow);

		menu.add(clock);

		menu.add(displayTimer);

		menu.add(dirrection);

		menu.add(button.getRouteSummary());

		menu.add(button.getBack());
		
		menu.add(mapPicture, BorderLayout.CENTER);
		menu.add(statuspic);
		

		/**
		 * Timer start after you've confirmed your route from CurrentLocation, 
		 * Location or current location button
		 */

		Timer timer  = new Timer (5, this);
		timer.start();
		add(menu);


		button.getRouteSummary().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			
				routeSummary.run();
				setVisible(false);
				if(mapView.MapView.window.isVisible()){
					mapView.MapView.window.setVisible(false);
				}

			}
		});



		button.getBack().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				/**
				 * Stops reading data from the reader
				 */

				stopper.stop();
				try{
					Reader.stop();	
				}
				catch(Throwable t){

				}
				NavigationStart.setNodes();
				Option.run();
				setVisible(false);
			}
		});



		setTitle("Map window");
		setSize(size.getFrameXsize(), size.getFrameYsize());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setVisible(true);
		setLayout(null);
		stopper.start();

	}
	/**
	 * Stopper
	 */
	public void actionPerformed(ActionEvent e)
	{

		if (e.getSource() == stopper)
		{
			secs++;
		}

		if (secs == 60)
		{
			mins++;
			secs = 0;
		}

		if (mins == 60)
		{
			hrs++;
			mins = 0;
			secs = 0;
		}

		if (hrs == 24)
		{
			hrs = 0;
			mins = 0;
			secs = 0;
		}
		displayTimer.setText(
				dFormat.format(hrs) + ":" + 
				dFormat.format(mins));

	}


	/**
	 * setDirectionIcon changes the picture in mapview for directions to the 
	 * pedestrian and plays sound for audio guidance.
	 */

	public static void setDirectionIcon(String direction){

		if(direction.equals("Turn Right")){
			dirrection.setIcon(rightTurn);
			dirrection.repaint();
			rigth.play();
		}
		else if(direction.equals("Turn Left")){
			dirrection.setIcon(leftTurn);
			dirrection.repaint();
			left.play();
		}
		else{ //(Directions.directionList.equals("Go Straight")){
			dirrection.setIcon(forward);
			dirrection.repaint();
			foward.play();
		}
	}
	public static void setStopSign(){
		dirrection.setIcon(stop);
		dirrection.repaint();
		arrived.play();
	}


	/**
	 * clockPanel() creates the clock panel for the map view 
	 */
	public static class clockPanel extends JPanel {
		public static Clock clock = new Clock ();


		public void paintComponent(Graphics a) {
			super.paintComponent(a);
			a.drawString(clock.CurrentTime(),10,15);

		}


	}

}
