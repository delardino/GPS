package dijkstra;

import reader.Reader;
import calculations.PositionCalc;


/**
 * This class is to calculate the remaining distance and return it whenever 
 * GPS device gets new signal. When we arrived the last node in path
 * it returns zero.
 * It is almost the same calculation to find distance from current position to
 * target node but returns remaming distance.
 * 
 * @author Savas Aydin
 */
public class RemainingDistance {
	
	public static int total=0; 
	public static int longComparision, latComparision;
	public static String remainingDist;
	
	/*
	 * 
	 */
	public static String remainingDistance(Double currLong, Double currLat){
	
		for(int i=0;i<Dijkstra.path.size();){
		
			double xIn=Dijkstra.allVertexList.get(i).getLongitude();
			double yIn=Dijkstra.allVertexList.get(i).getLatitude();
	
			int x = PositionCalc.calcX(xIn);
			int y = PositionCalc.calcY(yIn);
			
			int xCurr = PositionCalc.calcX(currLong);
			int yCurr = PositionCalc.calcY(currLat);
			
			int xDif=x-xCurr;
			int yDif=y-yCurr;
			total= (int)Math.sqrt(Math.abs((xDif * xDif) + (yDif * yDif)));
				
			remainingDist = Double.toString(Dijkstra.path.get(
					Dijkstra.path.size()-1).minDistance - total);
			
			
			longComparision= xCurr - x;
			longComparision = Math.abs(longComparision);
	
			latComparision= yCurr - y;
			latComparision = Math.abs(latComparision);
	
			if((longComparision + latComparision)<20){
				Dijkstra.implementationDijkstra(Dijkstra.path.get(i+1));
				remainingDist = Double.toString(
						Dijkstra.path.get(Dijkstra.path.size()-1).minDistance
						+ 3 );
				i++;
				return remainingDist;
			}
			else
			return remainingDist;
		}
		
		return "0";
	}
}
