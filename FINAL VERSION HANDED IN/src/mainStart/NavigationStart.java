package mainStart;

import java.awt.Menu;

import Visual.MapWindowJFrame;
import VisualApp.buttons;
import calculations.PositionCalc;
import calculations.Sleep;
import mapView.MapView;
import dijkstra.CurrToB;
import dijkstra.Dijkstra;
import dijkstra.Directions;
import reader.Reader;
import screenShot.ScreenShot;

/**
 *This class controls the flow once a navigation option is chosen from the
 *Road Hunter main menu 
 *
 * @author Savas Aydin, Magnus Bergqvist
 */
public class NavigationStart {

	public static MapView mapView = new MapView();
	public static Dijkstra dijk = new Dijkstra();
	public static CurrToB currToB = new CurrToB(); 
	public static Directions direction = new Directions();
	public static String startNode = null;
	public static String endNode = null;
	private static int startNodeNumber = 1500;
	private static int endNodeNumber = 1500;

	/**
	 * startNavigationAtoB() first option. Sets the start and end node
	 * chosen by the pedestrian and then calls reader class to start
	 */
	public static void startNavigationAtoB(String start, String end){
		startNode = start;
		endNode = end;
		Reader.start();
	}
	/**
	 * startNavigationCurrentToB() second option. Sets the end node
	 * chosen by the pedestrian and then calls reader class to start.
	 * Start node will be set to pedestrians current location.
	 */
	public static void startNavigationCurrentToB(String end){
		endNode = end;
		Reader.start();
	}
	/**
	 * startTrackMovement() third option. No start and end nodes are set.
	 * This is a free movement mode so that the pedestrian can just track
	 * his/her movement.
	 */
	public static void startTrackMovement(){
		Reader.start();
	}




	/**
	 * calculateNavigate() checks which option that has been chosen from the
	 * main menu by looking at the startNode and endNode variables
	 * 
	 * Within the if and else-if statements there are loops to control
	 * guidance of the pedestrian by checking when the user arrives at different
	 * nodes along the path.
	 */
	public static void calculateNaviagte(){

		/**
		 * If current location to B is selected
		 */

		if(startNode == null && endNode != null){
			
			if(Dijkstra.allVertexList.isEmpty())
				dijk.setUpDijkstra();

			Sleep.sleep1000();
			Sleep.sleep1000();
			Sleep.sleep1000();
			for(int i = 0 ; i < Dijkstra.allVertexList.size(); i++){
				if(Dijkstra.allVertexList.get(i).toString().equals(endNode)){
					endNodeNumber = i;
				}
			}

			currToB.Converter(Double.parseDouble(Reader.gpsData.longitude), 
					Double.parseDouble(Reader.gpsData.latitude),
					Dijkstra.allVertexList.get(endNodeNumber));


			direction.direction(Dijkstra.path);


			mapView.show();
			//here goes the paintFirstLine call

			int x = PositionCalc.calcX(Dijkstra.path.get(0).getLongitude());
			int y = PositionCalc.calcY(Dijkstra.path.get(0).getLatitude());
			int xCurr = PositionCalc.calcX(Double.parseDouble(
					Reader.gpsData.longitude));
			int yCurr = PositionCalc.calcY(Double.parseDouble(
					Reader.gpsData.latitude));
			Sleep.sleep1000();
			//mapView.paintAllNodes(Dijkstra.allVertexList);
			mapView.paintFirstLine(x, y, xCurr, yCurr);
			mapView.paintRoute(Dijkstra.path);


			int sizeIndex = Dijkstra.path.size()-1;
			double endLong = Dijkstra.path.get(sizeIndex).getLongitude();
			double endLat = Dijkstra.path.get(sizeIndex).getLatitude();
			double currentLong = 0.0;
			double currentLat = 0.0;
			int nextNode = 1;
			int nextTurn=0;
			int longComparsion;
			int latComparsion;
			Sleep.sleep1000();


			while (nextNode != sizeIndex){

				currentLong = Double.parseDouble(Reader.gpsData.longitude);
				currentLat = Double.parseDouble(Reader.gpsData.latitude);
				mapView.viewPosition(currentLong,currentLat);

				longComparsion=
					PositionCalc.calcX(currentLong)-
					PositionCalc.calcX(
							Dijkstra.path.get(nextNode).getLongitude());
				longComparsion = Math.abs(longComparsion);

				latComparsion=
					PositionCalc.calcY(currentLat)-
					PositionCalc.calcY(
							Dijkstra.path.get(nextNode).getLatitude());
				latComparsion = Math.abs(latComparsion);

				if((longComparsion + latComparsion)<15){
					if(nextTurn<Directions.directionList.size()){
						MapWindowJFrame.setDirectionIcon(
								Directions.directionList.get(nextTurn));
						nextTurn++;
						System.out.println("You have arrived at a node");
						nextNode++;
					}	
				}

				//Sleep.sleep100();
			}

			while (nextNode == sizeIndex){


				currentLong = Double.parseDouble(Reader.gpsData.longitude);
				currentLat = Double.parseDouble(Reader.gpsData.latitude);
				mapView.viewPosition(currentLong,currentLat);

				longComparsion=
					PositionCalc.calcX(currentLong)-
					PositionCalc.calcX(
							Dijkstra.path.get(nextNode).getLongitude());
				longComparsion = Math.abs(longComparsion);

				latComparsion=
					PositionCalc.calcY(currentLat)-
					PositionCalc.calcY(
							Dijkstra.path.get(nextNode).getLatitude());
				latComparsion = Math.abs(latComparsion);


				if((longComparsion + latComparsion)<15){
					System.out.println(
							"You've arrived at your final destination");
					MapWindowJFrame.setStopSign();
					ScreenShot.captureScreen();
					
					MapWindowJFrame.menu.add(buttons.RouteSummary);
					nextNode++; //stops the while loop
					
				} 	

			}

		}

		/**
		 * Here goes the method for navigation from selected A to B
		 */
		else if(startNode != null && endNode != null){
			
			if(Dijkstra.allVertexList.isEmpty())
				dijk.setUpDijkstra();

			for(int i = 0 ; i < Dijkstra.allVertexList.size(); i++){
				if(Dijkstra.allVertexList.get(i).toString().equals(startNode)){
					startNodeNumber = i;
				}
			}
			for(int i = 0 ; i < Dijkstra.allVertexList.size(); i++){
				if(Dijkstra.allVertexList.get(i).toString().equals(endNode)){
					endNodeNumber = i;
				}
			}




			dijk.setStartTarget(Dijkstra.allVertexList.get(startNodeNumber), 
					Dijkstra.allVertexList.get(endNodeNumber));
			Sleep.sleep1000();
			Sleep.sleep1000();
			Sleep.sleep1000();


			mapView.show();
			//here goes the paintFirstLine call

			int x = PositionCalc.calcX(Dijkstra.path.get(0).getLongitude());
			int y = PositionCalc.calcY(Dijkstra.path.get(0).getLatitude());
			Sleep.sleep1000();
			//mapView.paintAllNodes(Dijkstra.allVertexList);
			mapView.paintRoute(Dijkstra.path);


			int sizeIndex = Dijkstra.path.size()-1;
			double endLong = Dijkstra.path.get(sizeIndex).getLongitude();
			double endLat = Dijkstra.path.get(sizeIndex).getLatitude();
			double currentLong = 0.0;
			double currentLat = 0.0;
			int nextNode = 0;
			int longComparsion;
			int latComparsion;
			Sleep.sleep1000();


			while(nextNode != sizeIndex){

				currentLong = Double.parseDouble(Reader.gpsData.longitude);
				currentLat = Double.parseDouble(Reader.gpsData.latitude);
				mapView.viewPosition(currentLong,currentLat);

				longComparsion=
					PositionCalc.calcX(currentLong)-
					PositionCalc.calcX(
							Dijkstra.path.get(nextNode).getLongitude());
				longComparsion = Math.abs(longComparsion);

				latComparsion=
					PositionCalc.calcY(currentLat)-
					PositionCalc.calcY(
							Dijkstra.path.get(nextNode).getLatitude());
				latComparsion = Math.abs(latComparsion);

				if((longComparsion + latComparsion)<15){
					System.out.println("You have arrived at a node");
					nextNode++;
				}

				//Sleep.sleep100();
			}

			while (nextNode == sizeIndex){


				currentLong = Double.parseDouble(Reader.gpsData.longitude);
				currentLat = Double.parseDouble(Reader.gpsData.latitude);
				mapView.viewPosition(currentLong,currentLat);

				longComparsion=
					PositionCalc.calcX(currentLong)-
					PositionCalc.calcX(
							Dijkstra.path.get(nextNode).getLongitude());
				longComparsion = Math.abs(longComparsion);

				latComparsion=
					PositionCalc.calcY(currentLat)-
					PositionCalc.calcY(
							Dijkstra.path.get(nextNode).getLatitude());
				latComparsion = Math.abs(latComparsion);


				if((longComparsion + latComparsion)<15){
					System.out.println(
							"You've arrived at your final destination");
					nextNode++; //stops the while loop
					ScreenShot.captureScreen();
				}
			}
		}
		
		/**
		 * 
		 * Else it's free track movement mode
		 * 
		 */
		else{

			Sleep.sleep1000();

			mapView.show();

			Sleep.sleep1000();
			Sleep.sleep1000();
			Sleep.sleep1000();

			double currentLong = 0.0;
			double currentLat = 0.0;
			int nextNode = 0;
			int longComparsion;
			int latComparsion;
			Sleep.sleep1000();


			for(int i = 0 ; i < 1 ;){

				currentLong = Double.parseDouble(Reader.gpsData.longitude);
				currentLat = Double.parseDouble(Reader.gpsData.latitude);
				mapView.viewPosition(currentLong,currentLat);

				Sleep.sleep100();
			}
		}
	}
	
	/**
	 * setNodes() After a completed navigation this method is called 
	 * to prepare the arraylists for new paths
	 */
	public static void setNodes(){
		System.out.println(startNode + endNode);
		startNode=null;
		endNode=null;
		System.out.println(startNode + endNode);
		Dijkstra.path.clear();
		System.out.println(Dijkstra.path);
		Dijkstra.allVertexList.clear();
		System.out.println(Dijkstra.allVertexList);
	}
}
