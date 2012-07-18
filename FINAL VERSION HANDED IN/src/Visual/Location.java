package Visual;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import mainStart.NavigationStart;

import VisualApp.pictures;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.PrintWriter;
import VisualApp.buttons;
import VisualApp.language;
import VisualApp.pictures;
/*
 * Search lovation from A to B
 * @author Michal Musialik,Hanei Vahabi,Rahwa Batha
 */
import VisualApp.sizePosition;

/**
 * @author Michal Musialik
 * Class for A to B
 */


public class Location extends JFrame {

	public static void run (){
		Location mrx = new Location ();
	}

	/**
	 * Loading control classes
	 */
	pictures pic = new pictures ();
	sizePosition size = new sizePosition();
	buttons button = new buttons ();



	private pictures [] loc  = {new pictures ()};

	/**
	 * ComboBox with preset options each location name is bound a picture 
	 * with location
	 */
	private JComboBox com1 = new JComboBox(pic.Names);
	private JComboBox com2 = new JComboBox(pic.Names);



	JLabel manu ;

	private JLabel showDestination1;
	private JLabel showDestination2;



	public Location(){
		/**
		 * Building buttons
		 */

		manu = new JLabel (new ImageIcon ("images/rh_main_background.jpeg"));

		com1.setBounds(520, 100, 200, 20);

		com2.setBounds(520, 400, 200, 20);




		showDestination1 = new JLabel ();
		showDestination2 = new JLabel ();



		showDestination1.setBounds(size.getPicXpos(), size.getPicYpos() + 20 , 
				size.getPicXsize(), size.getPicYsize());	
		showDestination2.setBounds(size.getPicXpos() , size.getPicYpos() + 400,
				size.getPicXsize(), size.getPicYsize());

		showDestination1.setIcon(pic.getPic1());
		showDestination2.setIcon(pic.getPic1());

		manu.add(showDestination1);
		manu.add(showDestination2); 

		button.getOk().setBounds(size.getxLoc() + 800, size.getyLoc() + 300, 
				size.getxSize(), size.getySize());
		button.getBack().setBounds(size.getxLoc() + 1050,size.getyLoc() + 550, 
				size.getxSize(), size.getySize());

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

		manu.add(com1);
		manu.add(com2);
		manu.add(button.getOk());
		manu.add(button.getBack());



		add(manu);

		/**
		 * Action listeners for combox and buttons
		 */

		com1.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent event) 
			{ 
				/*
				 * Setting location A 
				 */
				if(event.getActionCommand()=="comboBoxChanged")
					showDestination1.setIcon(pic.getPic
							(com1.getSelectedIndex()));	
				setVisible( true);


			}});
		com2.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent event) 
			{ 

				/*
				 * Setting location B
				 */
				if(event.getActionCommand()=="comboBoxChanged")
					showDestination2.setIcon(pic.getPic
							(com2.getSelectedIndex()));	
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
			public void actionPerformed(ActionEvent e) 
			{ 
				/**
				 * After location A and B have been set information is send 
				 * to NavigationStart package
				 */

				NavigationStart.startNavigationAtoB(
						(String)com1.getSelectedItem(), 
						(String)com2.getSelectedItem());
				setVisible(false);
			}
		});





		setSize(size.getFrameXsize(), size.getFrameYsize());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setVisible(true);
		setLayout(null);




	}

}








