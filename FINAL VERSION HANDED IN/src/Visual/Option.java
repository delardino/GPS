package Visual;

import VisualApp.buttons;
import VisualApp.language;
import VisualApp.pictures;
import VisualApp.sizePosition;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.*;

import mainStart.NavigationStart;

import VisualApp.pictures;

/**
 * Main menu frame
 * @author Michal Musilaik
 */
public class Option extends JFrame{

	public static void run (){
		Option mrx = new Option ();
	}


	JLabel menu ;
	/**
	 * Loading settings from control classes
	 */
	buttons button = new buttons ();
	pictures pic = new pictures ();
	sizePosition size = new sizePosition();




	public Option(){
		/**
		 * Buttons and gui settings
		 */
		buttons button = new buttons ();
		menu = new JLabel (new ImageIcon ("images/rh_main_background.jpeg"));



		button.getFindLocation().setBorderPainted(false);
		button.getFindLocation().setForeground(Color.white);
		button.getFindLocation().setToolTipText
		(language.strTable[language.lang][0]);

		button.getFindWithCurrent().setBorderPainted(false);
		button.getFindWithCurrent().setForeground(Color.white);
		button.getFindWithCurrent().setToolTipText
		(language.strTable[language.lang][1]);

		button.getCurrentLocation().setBorderPainted(false);
		button.getCurrentLocation().setForeground(Color.white);
		button.getCurrentLocation().setToolTipText
		(language.strTable[language.lang][2]);

		button.getLanguade().setBorderPainted(false);
		button.getLanguade().setForeground(Color.white);
		button.getLanguade().setToolTipText
		(language.strTable[language.lang][3]);

		button.getGameButton().setBorderPainted(false);
		button.getGameButton().setForeground(Color.white);
		button.getGameButton().setToolTipText
		(language.strTable[language.lang][4]);

		button.getShutdown().setBorderPainted(false);
		button.getShutdown().setForeground(Color.white);
		button.getShutdown().setToolTipText
		(language.strTable[language.lang][5]);

		button.getRouteSummary().setBorderPainted(false);
		button.getRouteSummary().setForeground(Color.white);
		button.getRouteSummary().setToolTipText
		(language.strTable[language.lang][8]);

		menu.setLayout(null);

		button.getFindLocation().setBounds(size.getxLoc(), size.getyLoc(), 
				size.getxSizeBig() , size.getySizeBig() );
		button.getFindWithCurrent().setBounds(size.getxLoc() + size.getxMove() 
				+ 100, size.getyLoc() , size.getxSizeBig() , size.getySizeBig());
		button.getCurrentLocation().setBounds(size.getxLoc()  + size.getxMove()
				+ size.getxMove() +200, size.getyLoc() , size.getxSizeBig(),
				size.getySizeBig() );

		button.getLanguade().setBounds(size.getxLoc()  , size.getyLoc() 
				+ size.getyMove()+ 100 , size.getxSizeBig(), size.getySizeBig());
		button.getRouteSummary().setBounds(size.getxLoc()  + size.getxMove()
				+ 100, size.getyLoc() + size.getyMove()+ 100 ,
				size.getxSizeBig(), size.getySizeBig());
		button.getGameButton().setBounds(size.getxLoc()  + size.getxMove()
				+ size.getxMove() +200, size.getyLoc() + size.getyMove()+ 100,
				size.getxSizeBig(), size.getySizeBig());

		button.getShutdown().setBounds(size.getxLoc() + 1050, size.getyLoc()
				+ 550, size.getxSize(), size.getySize());


		button.getFindLocation().setHorizontalTextPosition
		(SwingConstants.CENTER);
		button.getFindWithCurrent().setHorizontalTextPosition
		(SwingConstants.CENTER);
		button.getCurrentLocation().setHorizontalTextPosition
		(SwingConstants.CENTER);

		button.getLanguade().setHorizontalTextPosition
		(SwingConstants.CENTER);
		button.getRouteSummary().setHorizontalTextPosition
		(SwingConstants.CENTER);
		button.getGameButton().setHorizontalTextPosition
		(SwingConstants.CENTER);

		button.getShutdown().setHorizontalTextPosition
		(SwingConstants.CENTER);

		button.getFindLocation().setIcon(pic.getFindLatob());
		button.getFindWithCurrent().setIcon(pic.getFindL());
		button.getCurrentLocation().setIcon(pic.getView());

		button.getGameButton().setIcon(pic.getGames());
		button.getRouteSummary().setIcon(pic.getRoute());
		button.getLanguade().setIcon(pic.getLang());

		button.getShutdown().setIcon(pic.getQuit());


		button.getFindLocation().setFont(new Font(language.font,Font.PLAIN,14));

		button.getFindWithCurrent().setFont(new Font
				(language.font,Font.PLAIN,14));
		button.getCurrentLocation().setFont(new Font
				(language.font,Font.PLAIN,14));

		button.getLanguade().setFont(new Font(language.font,Font.PLAIN,14));
		button.getRouteSummary().setFont(new Font(language.font,Font.PLAIN,14));
		button.getGameButton().setFont(new Font(language.font,Font.PLAIN,14));

		button.getShutdown().setFont(new Font(language.font,Font.PLAIN,14));


		menu.add(button.getFindLocation());
		menu.add(button.getFindWithCurrent());
		menu.add(button.getCurrentLocation());

		menu.add(button.getLanguade());
		menu.add(button.getRouteSummary());
		menu.add(button.getGameButton());

		menu.add(button.getShutdown());



		add(menu);
		/**
		 * Actions Listeners
		 */


		 button.getGameButton().addActionListener(new ActionListener ()
		 {
			 public void actionPerformed(ActionEvent e)
			 {
				 Game.run();
				 setVisible(false);



			 } });
		 button.getFindLocation().addActionListener(new ActionListener ()
		 {
			 public void actionPerformed(ActionEvent e)
			 {

				 Location.run();
				 setVisible(false);

			 } });
		 button.getFindWithCurrent().addActionListener(new ActionListener ()
		 {
			 public void actionPerformed(ActionEvent e)
			 {
				 CurrentLocation.run();
				 setVisible(false);


			 } });

		 button.getCurrentLocation().addActionListener(new ActionListener ()
		 {
			 public void actionPerformed(ActionEvent e)
			 {
				 NavigationStart.startTrackMovement();
				 setVisible(false);

			 } });

		 button.getLanguade().addActionListener(new ActionListener()
		 {
			 public void actionPerformed(ActionEvent e) 
			 { 
				 /**
				  * Try and catch for saving last chosen language that will 
				  * be loaded at start up
				  */
				 try {
					 LanguadeFrame.run();
				 } catch (FileNotFoundException e1) {

					 e1.printStackTrace();
				 }
				 setVisible(false);
			 }});

		 button.getRouteSummary().addActionListener(new ActionListener()
		 {
			 public void actionPerformed(ActionEvent e) 
			 { 
				 routeSummary.run();
				 setVisible(false);
			 }});

		 button.getShutdown().addActionListener(new ActionListener()
		 {
			 public void actionPerformed(ActionEvent e) 
			 {   
				 System.exit(0);

			 }});



		 setSize(size.getFrameXsize(), size.getFrameYsize());
		 setLocationRelativeTo(null);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setUndecorated(true);
		 setVisible(true);
		 setLayout(null);


	}

}
