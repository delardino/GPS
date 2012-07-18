package Visual;
import VisualApp.buttons;

import VisualApp.language;
import VisualApp.pictures;
import VisualApp.sizePosition;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import mainStart.NavigationStart;
import mapView.MapView;
/*
 * @author Michal Musiali, Hanei Vahabi, Rahwa Batha
 * Search from current location frame
 */

import VisualApp.pictures;
import VisualApp.pictures;
/**
 * Select route from current location
 * Current location method works as followed:
 * - Pedestrian select final destination
 * - Road Hunter draw distance to closest note and then draw following route
 * @author Michal Musialik
 */

public class CurrentLocation extends JFrame{

	public static void run (){
		CurrentLocation mrx = new CurrentLocation ();
	}
	/**
	 * Loading settings from control classes
	 */

	buttons button = new buttons();

	sizePosition size = new sizePosition();

	pictures pic = new pictures ();

	/**
	 * ComboBox with pictures for selection
	 */
	private pictures [] loc  = {new pictures ()};
	private JComboBox com3 = new JComboBox(pic.Names);

	JLabel menu ;

	private JLabel showDestination ;

	public CurrentLocation(){

		/**
		 * Buttons and gui settings
		 */
		menu = new JLabel (new ImageIcon ("images/rh_main_background.jpeg"));

		showDestination = new JLabel ();
		com3.setBounds(520, 100, 200, 20);
		menu.setLayout(null);

		showDestination.setBounds(size.getPicXpos(), size.getPicYpos() +
				20, size.getPicXsize(), size.getPicYsize());
		showDestination.setIcon(pic.getPic1());

		button.getOk().setBounds(size.getxLoc() + 800, size.getyLoc() ,
				size.getxSize() , size.getySize());
		button.getBack().setBounds(size.getxLoc() + 1050,size.getyLoc() + 
				550, size.getxSize(), size.getySize());

		button.getOk().setHorizontalTextPosition(SwingConstants.CENTER);
		button.getBack().setHorizontalTextPosition(SwingConstants.CENTER);

		button.getOk().setIcon(pic.getOk());
		button.getBack().setIcon(pic.getBack());

		button.getOk().setFont(new Font(language.font,Font.PLAIN,14));
		button.getBack().setFont(new Font(language.font,Font.PLAIN,14));

		button.getOk().setBorderPainted(false);
		button.getOk().setForeground(Color.white);
		button.getOk().setToolTipText(language.strTable[language.lang][7]);

		button.getBack().setBorderPainted(false);
		button.getBack().setForeground(Color.white);
		button.getBack().setToolTipText(language.strTable[language.lang][6]);

		menu.add(showDestination);
		menu.add(com3);
		menu.add(button.getBack());
		menu.add(button.getOk());


		add(menu);
		/**
		 * Adding action listeners
		 */
		com3.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent event) 
			{ 

				if(event.getActionCommand()=="comboBoxChanged")
					showDestination.setIcon(pic.getPic
							(com3.getSelectedIndex()));	
				setVisible( true);


			}});

		button.getBack().addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent e) 
			{ 
				Option.run();
				setVisible(false);
			}});

		button.getOk().addActionListener(new ActionListener()

		{
			/**
			 * Confirmation for destination, from here the selection of the
			 * array is promoted to 
			 * mainStart package where Dijkstra draw shortest path from current
			 * destination to arrival 
			 * destination
			 */
			public void actionPerformed(ActionEvent e) 
			{ 
				if(((String)com3.getSelectedItem()).equals("Aran Restaurant")){

					MapView.window.picshow = 
						new JLabel(new ImageIcon("minipic/aran.jpg"));
				}
				
				if(((String)com3.getSelectedItem()).equals("Backa Theatre")){

					MapView.window.picshow = 
						new JLabel(new ImageIcon("minipic/backa.jpg"));
				}
				
				if(((String)com3.getSelectedItem()).equals("Ericsson")){

					MapView.window.picshow = 
						new JLabel(new ImageIcon("minipic/ericsson.jpg"));
				}
				
				if(((String)com3.getSelectedItem()).equals("Esters Cafe")){

					MapView.window.picshow = 
						new JLabel(new ImageIcon("minipic/esters.jpg"));
				}
				
				if(((String)com3.getSelectedItem()).equals("Ferry")){

					MapView.window.picshow = 
						new JLabel(new ImageIcon("minipic/ferry.jpg"));
				}
				
				if(((String)com3.getSelectedItem()).equals("Jupiter")){

					MapView.window.picshow = 
						new JLabel(new ImageIcon("minipic/jupiter.jpg"));
				}
				
				if(((String)com3.getSelectedItem()).equals("Patricia")){

					MapView.window.picshow = 
						new JLabel(new ImageIcon("minipic/patricia.jpg"));
				}

				if(((String)com3.getSelectedItem()).equals("Pressbyran")){

					MapView.window.picshow = 
						new JLabel(new ImageIcon("minipic/pressbyran.jpg"));
				}

				if(((String)com3.getSelectedItem()).equals("Saga")){

					MapView.window.picshow = 
						new JLabel(new ImageIcon("minipic/saga.jpg"));
				}

				if(((String)com3.getSelectedItem()).equals("Science Park")){

					MapView.window.picshow = 
						new JLabel(new ImageIcon("minipic/science.jpg"));
				}

				if(((String)com3.getSelectedItem()).equals("Sigma")){

					MapView.window.picshow = 
						new JLabel(new ImageIcon("minipic/sigma.jpg"));
				}

				if(((String)com3.getSelectedItem()).equals("Svea")){

					MapView.window.picshow = 
						new JLabel(new ImageIcon("minipic/svea.jpg"));
				}

				NavigationStart.startNavigationCurrentToB(
						(String)com3.getSelectedItem());
				setVisible(false);




			}});


		setSize(size.getFrameXsize(), size.getFrameYsize());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setVisible(true);
		setLayout(null);

	}



}