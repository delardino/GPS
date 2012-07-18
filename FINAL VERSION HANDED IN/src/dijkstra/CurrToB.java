package dijkstra;

import java.util.List;
import calculations.*;
import reader.Reader;

/**
 * This class finds closest vertex from current position. And makes calculation 
 * to find distance from current location to closest node to it.
 * 
 * @author Savas Aydin 
 */
public class CurrToB {
	
	/**
	 * This variables are comprised to used in Converter method.  
	 */
	public static int total = 0;
	public static double min = 999999.0;
	public static int indexOfVertex;
	public static double distanceToClosestVertex;
	
	/**
	 * It includes basic math theorem; d=sqrt(|X1-X2|*|X1-X2| + |Y1-Y2|*|Y1-Y2|)
	 * We can assume that CurrentPosition(X1,Y1) and
	 * closestVertex(X2,Y2) and d is the distance between CurrentPosition 
	 * and closestVertex.
	 * Method carries this theorem to every node and finds the shortest vertex 
	 * to current location. 
	 */
	public static void setStartTargetFromCurr(Vertex startV, Vertex endV){
		Dijkstra.implementationDijkstra(startV); //v1=source vertex
		{	
			List<Vertex> path = Dijkstra.getShortestPathTo(endV);
			System.out.println("Path: " + path);
			System.out.println("Distance to " + endV + ": " + 
					(endV.minDistance + DistanceCalc.distanceToClosest(
							Double.parseDouble(Reader.gpsData.longitude), 
							Double.parseDouble(Reader.gpsData.latitude), 
							Dijkstra.path.get(0))));
			
		}
	}

	
	/**
	* converter method calculates the distances from current position to 
	* each node that we have and return the node that has minimum distance  
	*/
	public void Converter(double longit, double latit, Vertex targetVertex){
		
		for(int i=0; i<Dijkstra.allVertexList.size();i++){
			double xIn=Dijkstra.allVertexList.get(i).getLongitude();
			double yIn=Dijkstra.allVertexList.get(i).getLatitude();

			
			int x = PositionCalc.calcX(xIn);

			int y = PositionCalc.calcY(yIn);
			
			int xCurr = PositionCalc.calcX(longit);
			int yCurr = PositionCalc.calcY(latit);
			
			int xDif=x-xCurr;
			int yDif=y-yCurr;
			
			total= (int)Math.sqrt(Math.abs((xDif * xDif) + (yDif * yDif)));
			
			if(total<min){
				min=total;
				indexOfVertex=i;
			}
		}
		
		setStartTargetFromCurr(
				Dijkstra.allVertexList.get(indexOfVertex),targetVertex);

	}
	

}
