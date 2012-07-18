package Final_DB;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class HighScoreDB extends JFrame implements KeyListener{

	
	private JButton jbtOK;
	private JButton jbtShowHighScore;
	private JLabel label;
	private JTextField jtf;
	private java.awt.Container window1, window2;
	String score="10";
	
	public HighScoreDB(){
		
		super("GroupH");
		
		window1=getContentPane();
		
		window1.setLayout(new FlowLayout());
		
		label=new JLabel("Enter your name");
		window1.add(label);
		
		jtf=new JTextField(15);
		window1.add(jtf);
		
		jbtOK=new JButton("OK");
		window1.add(jbtOK);
		
		jbtShowHighScore=new JButton("Show Highscore");
		window1.add(jbtShowHighScore);
		
		
		jtf.addKeyListener(this);
		
		jbtOK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				try
				{
					Class.forName("org.sqlite.JDBC");
				    Connection conn = DriverManager.getConnection("jdbc:sqlite:savas.db");  
					Statement state = conn.createStatement();   
					state.executeUpdate("create table if not exists FeedingDuck(Name Text, Score Text);");
				
					PreparedStatement prep = conn.prepareStatement(
			          "insert into FeedingDuck values (?, ?);");

					prep.setString(1,jtf.getText());
					prep.setString(2, score);
					prep.addBatch();
					
					prep.executeBatch();
					
					state.close();   
					conn.close();   
					
					JOptionPane.showMessageDialog(null, "your name is saved into list");
				} 
				catch (Exception e) {   
					e.printStackTrace(System.err);  
				} 
				
			}
			
		});
		
		
		
	/*	
		jbtShowHighScore.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				try{
					String sql="Select * from FeedingDuck order by score";
					Class.forName("org.sqlite.JDBC");
				    Connection conn = DriverManager.getConnection("jdbc:sqlite:savas.db");  
					Statement state = conn.createStatement();  
					ResultSet rs=state.executeQuery(sql);

					
					
					JPanel panel=new JPanel(new GridLayout(10,2));
					
					panel.add(new JLabel("Name"));
					panel.add(new JLabel("Score"));
					
					while(rs.next()){
						String firstName=rs.getString(1);
						String yourScore=rs.getString(2);
						
						
						
						panel.add(new JLabel(firstName));
						panel.add(new JLabel(yourScore));
					}
					window1.add(panel);
				}
				
				catch (Exception e) {   
					e.printStackTrace(System.err);  
			
				}
			}	
		});  */   		
	}
	
	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args){
		HighScoreDB frame=new HighScoreDB();
		frame.setTitle("GroupH");
		frame.setSize(300,300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}