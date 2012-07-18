package Visual;
import VisualApp.buttons;
import VisualApp.language;
import VisualApp.pictures;
import VisualApp.sizePosition;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.*;
/*
 * Languade class
 * @Michal Musilaik
 * 
 */

import VisualApp.MP3Player;
import VisualApp.pictures;
/*
 * @author Michal Musialik
 */


public class LanguadeFrame extends JFrame  {
	/*
	 * Language frame 
	 */

	public static PrintWriter output;

	public static void run ()throws FileNotFoundException{
		LanguadeFrame mrx = new LanguadeFrame ();
	}
	public static void createFile(){
		try{
			output = new PrintWriter ("languade.txt");
		}
		catch(FileNotFoundException e){

		}

	}

	public File save ;

	/*
	 * Loading settings from control classes
	 */

	pictures pic = new pictures ();
	sizePosition size = new sizePosition ();
	buttons button = new buttons();
	/*
	 * MP3 files with native prenaouncation
	 */

	private MP3Player poland = new MP3Player ("sound/MP3polish.mp3");
	private MP3Player sweden = new MP3Player ("sound/MP3swedish.mp3");
	private MP3Player turkey = new MP3Player ("sound/MP3turkish.mp3");
	private MP3Player england = new MP3Player ("sound/MP3english.mp3");
	private MP3Player persian = new MP3Player ("sound/MP3persian.mp3");
	private MP3Player ethiopian = new MP3Player ("sound/MP3etho.mp3");



	private JLabel start ;



	public LanguadeFrame ()throws FileNotFoundException {

		/*
		 * Building buttons
		 */


		start = new JLabel(new ImageIcon ("images/rh_main_background.jpeg"));
		start.setLayout(null);
		start.setBackground(Color.LIGHT_GRAY);

		button.getPolandButton().setBounds(size.getxLoc(), size.getyLoc(), size.getxSizeBig() , size.getySizeBig() );
		button.getSwedenButton().setBounds(size.getxLoc() + size.getxMove() + 100, size.getyLoc() , size.getxSizeBig() , size.getySizeBig() );
		button.getTurkeyButton().setBounds(size.getxLoc()  + size.getxMove() + size.getxMove() +200, size.getyLoc() , size.getxSizeBig(), size.getySizeBig() );

		button.getEnglandButton().setBounds(size.getxLoc()  , size.getyLoc() + size.getyMove()+ 100 , size.getxSizeBig(), size.getySizeBig());
		button.getPersianButton().setBounds(size.getxLoc()  + size.getxMove() + 100, size.getyLoc() + size.getyMove()+ 100 , size.getxSizeBig(), size.getySizeBig());
		button.getEthiopianButton().setBounds(size.getxLoc()  + size.getxMove() + size.getxMove() +200, size.getyLoc() + size.getyMove()+ 100, size.getxSizeBig(), size.getySizeBig());
		button.getBack().setBounds(size.getxLoc() + 1050,size.getyLoc() + 550, size.getxSize(), size.getySize());



		button.getPolandButton().setIcon(pic.getPolishFlag());
		button.getSwedenButton().setIcon(pic.getSwedishFlag());
		button.getTurkeyButton().setIcon(pic.getTurkeyFlag());
		button.getEnglandButton().setIcon(pic.getEnglondFlag());
		button.getPersianButton().setIcon(pic.getPersianFlag());
		button.getEthiopianButton().setIcon(pic.getEhtopianFlag());
		button.getBack().setIcon(pic.getBack());

		button.getPolandButton().setBorderPainted(false);
		button.getSwedenButton().setBorderPainted(false);
		button.getTurkeyButton().setBorderPainted(false);
		button.getEnglandButton().setBorderPainted(false);
		button.getPersianButton().setBorderPainted(false);
		button.getEthiopianButton().setBorderPainted(false);
		button.getBack().setBorderPainted(false);



		button.getPolandButton().setHorizontalTextPosition(SwingConstants.CENTER);
		button.getSwedenButton().setHorizontalTextPosition(SwingConstants.CENTER);
		button.getTurkeyButton().setHorizontalTextPosition(SwingConstants.CENTER);
		button.getEnglandButton().setHorizontalTextPosition(SwingConstants.CENTER);
		button.getPersianButton().setHorizontalTextPosition(SwingConstants.CENTER);
		button.getEthiopianButton().setHorizontalTextPosition(SwingConstants.CENTER);
		button.getBack().setHorizontalTextPosition(SwingConstants.CENTER);


		button.getPolandButton().setFont(new Font("Arial",Font.PLAIN,14));
		button.getSwedenButton().setFont(new Font("Arial",Font.PLAIN,14));
		button.getTurkeyButton().setFont(new Font("Arial",Font.PLAIN,14));
		button.getEnglandButton().setFont(new Font("Arial",Font.PLAIN,14));
		button.getPersianButton().setFont(new Font("Arial",Font.PLAIN,14));
		button.getEthiopianButton().setFont(new Font("Arial",Font.PLAIN,14));


		button.getBack().setBorderPainted(false);
		button.getBack().setForeground(Color.white);
		button.getBack().setToolTipText(language.strTable[language.lang][6]);

		add(button.getPolandButton());
		add(button.getSwedenButton());
		add(button.getTurkeyButton());
		add(button.getEnglandButton());
		add(button.getPersianButton());
		add(button.getEthiopianButton());
		add(button.getBack());


		add(start);


		/*
		 * Action listeners for buttons
		 * Added sound for each button
		 * Sound are represented by native languages
		 * Languages are set from a double array
		 * Selection will be saved to a text file and on next start up selected languade vill be loaded as default
		 */
		button.getPolandButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				language.lang=5;
				poland.play();
				createFile();
				output.print("poland");
				output.close();
				setVisible(false);
				Option.run();
			}
		});

		button.getSwedenButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				sweden.play();
				createFile();
				output.print("swedish");
				output.close();
				language.lang=1;
				setVisible(false);
				Option.run();

			}
		});

		button.getTurkeyButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				turkey.play();
				createFile();
				output.print("turkish");
				language.lang=3;
				output.close();
				setVisible(false);
				Option.run();
			}
		});



		button.getEnglandButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				createFile();
				output.print("english");
				output.close();
				england.play();
				language.lang=0;
				setVisible(false);
				Option.run();

			}
		});

		button.getPersianButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				createFile();
				output.print("Persian");
				output.close();
				language.lang=4;
				persian.play();
				setVisible(false);
				Option.run();

			}
		});

		button.getEthiopianButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				createFile();
				output.print("etiopian");
				output.close();
				language.lang=2;
				language.font = "Nyala";
				ethiopian.play();
				setVisible(false);
				Option.run();

			}
		});

		button.getBack().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				Option.run();
			}
		});




		setTitle("Start");
		setSize(size.getFrameXsize(), size.getFrameYsize());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setVisible(true);
		setLayout(null);
		setResizable(false);

	}


}
