package mapView;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.io.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.imageio.*;

import reader.Reader;

import calculations.DistanceCalc;
import calculations.PositionCalc;
import calculations.Sleep;
import dijkstra.*;
import Visual.*;
import VisualApp.Clock;
import mapView.*;

/**
 * The RoadHunter class creates an instance of class MapWindowJFrame at the same
 * time it calculates the coordinates for the map pointer from the GPS  
 * coordinates received from class Main.
 * @author Magnus Bergqvist
 *
 */

public class MapView {

	public static MapWindowJFrame window = new MapWindowJFrame();
	public Graphics g;
	public Graphics2D g2;
	public Graphics2D g2d;

	/**
	 * Method show() creates new instance of WindowClass and shows it
	 */
	public void show(){
		if(window.isShowing()){
			// do nothing	
		} else {
			window.setTitle("Road Hunter Demo");
			window.setVisible(true);
			Sleep.sleep30();
		}
	}

	/**
	 * paintFirstLine() method takes the coordinates of the first node of 
	 * calculated path and draws a line to the coordinates for the pedestrians
	 * current location
	 */

	public void paintFirstLine(int x, int y, int xCurr, int yCurr){
		g2 = (Graphics2D)window.mapPicture.getGraphics();
		g2.setColor(Color.orange);
		g2.setStroke(new BasicStroke(6));

		Sleep.sleep100();
		g2.drawLine(x, y, xCurr, yCurr);

	}
	/**
	 * A method to paint the nodes of the route calculated by 
	 * the Dijkstra class. Receives calculated route as an ArrayList
	 */


	public void paintAllNodes(ArrayList<Vertex> vertexList){
		g2 = (Graphics2D)window.mapPicture.getGraphics();
		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(6));

		for(int i = 0 ; i < vertexList.size() ; i++){

			int x = PositionCalc.calcX(vertexList.get(i).getLongitude());
			int y = PositionCalc.calcY(vertexList.get(i).getLatitude());

			Sleep.sleep30();

			g2.fillOval(x-4, y-4, 8, 8);

		}
	}

	/**
	 * A method to paint the path of the route calculated by 
	 * the Dijkstra class onto the map. 
	 * Receives calculated route as an ArrayList
	 */
	public void paintRoute(ArrayList<Vertex> vertexList){
		g2 = (Graphics2D)window.mapPicture.getGraphics();
		g2.setColor(Color.green);
		g2.setStroke(new BasicStroke(6));

		
		/**
		 * Iterates over the received list of nodes and draws a line between
		 * them
		 */
		for(int i = 0 ; i < vertexList.size() ; i++){
			
			int x = PositionCalc.calcX(vertexList.get(i).getLongitude());
			int y = PositionCalc.calcY(vertexList.get(i).getLatitude());

			Sleep.sleep30();

			g2.fillOval(x-2, y-2, 4, 4);
			if(i > 0){

				int xOld = PositionCalc.calcX(
						vertexList.get(i-1).getLongitude());

				int yOld = PositionCalc.calcY(
						vertexList.get(i-1).getLatitude());

				Sleep.sleep30();

				g2.drawLine(x, y, xOld, yOld);
			}
		}
		EndFlag(vertexList);
		drawDistance();

	}
	
	/**
	 * Method to set position for the start and end makers on to the map,
	 * they will appear centered on the start and end nodes
	 */
	public void EndFlag(ArrayList<Vertex> path){

		int endNodeIndex = path.size()-1;
		g2d = (Graphics2D)window.mapPicture.getGraphics();

		ImageIcon picfile = new ImageIcon("map/startflag.gif");
		Image image = picfile.getImage();
		g2d.drawImage(image,
				PositionCalc.calcX(path.get(0).getLongitude())-10, 
				PositionCalc.calcY(path.get(0).getLatitude())-10,
				null);

		picfile = new ImageIcon("map/endflag.gif");
		image = picfile.getImage();
		g2d.drawImage(image,
				PositionCalc.calcX(path.get(endNodeIndex).getLongitude())-40, 
				PositionCalc.calcY(path.get(endNodeIndex).getLatitude())-40,
				null);
	}


	/**
	 * Method displaying the total distance of path from current location 
	 * to end node in the map view status bar.
	 */
	public void drawDistance(){
		g2d = (Graphics2D)window.distancePanel.getGraphics();


		g2d.setColor(Color.red);
		g2d.setFont(new Font("Arial",Font.BOLD,14));
		g2d.drawString("Total distance: " + (
				dislpayinformation.totDist + DistanceCalc.distanceToClosest(
						Double.parseDouble(Reader.gpsData.longitude), 
						Double.parseDouble(Reader.gpsData.latitude), 
						Dijkstra.path.get(0))) + "m", 2, 40);
	}
	
	public void viewPosition1(double longitude, double latitude){
		window.clock.repaint();

		/**
		 * sets panel of window as graphic container
		 */
		Graphics g = window.mapPicture.getGraphics();

		/**
		 * Color of graphic objects
		 */
		g.setColor(Color.red);

		/**
		 * Following calculations takes the GPScoordinates and recalculate them
		 * to correspond to a position on the map
		 */

		int x = PositionCalc.calcX(longitude);
		int y = PositionCalc.calcY(latitude);

		/**
		 * Calls a brake for a 1ms just so that the paint
		 * method won't screw up
		 */

		Sleep.sleep1(); 

		/**
		 * Paints the tracing dot, the minus values are
		 * there to get the center of the point
		 * on the coordinate
		 */
		g.fillOval(x-3, y-3, 6, 6);

	}
	
	
	
	/**
	 * viewPosition() method takes pedestrian's current location coordinate 
	 * and displays it on the map and stays as a trace
	 * 
	 * Method replacing viewPosition1 above.
	 */
	public void viewPosition(double xIn, double yIn){
		
		window.clock.repaint();
		
		int x = PositionCalc.calcX(xIn);
		int y = PositionCalc.calcY(yIn);

		Graphics2D g2d =  (Graphics2D)window.mapPicture.getGraphics();

		ImageIcon picfile = new ImageIcon("map/smiley.gif");
		Image image = picfile.getImage();
		g2d.drawImage(image,
				x-10,	//Just to center the image which is 20x20 px in size 
				y-10,	//Just to center the image which is 20x20 px in size
				null);

	}
}


