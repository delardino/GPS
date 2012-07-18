package calculations;

import dijkstra.Dijkstra;
import dijkstra.Vertex;

/**
 * This class computes the distance between given 2 points 
 * 
 * @author Savas Aydin
 */
public class DistanceCalc {
	
	public static int distanceToClosest(
			double longit, double latit, Vertex closestVertex){
		
		double earthRadius = 3958.75;
	    double dLat = Math.toRadians(Dijkstra.path.get(0).latitude-latit);
	    double dLng = Math.toRadians(Dijkstra.path.get(0).longitude-longit);
	    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
	               Math.cos(Math.toRadians(latit)) * Math.cos(Math.toRadians
	               (Dijkstra.path.get(0).latitude)) *
	        	   Math.sin(dLng/2) * Math.sin(dLng/2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	    double dist = earthRadius * c;

	    int meterConversion = 1609;
	    int distanceToClosestNode=(int)(dist * meterConversion);
	    return distanceToClosestNode;	    

	}

}
