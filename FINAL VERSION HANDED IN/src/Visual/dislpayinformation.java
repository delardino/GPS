package Visual;

import reader.Reader;
import dijkstra.Dijkstra;
import dijkstra.RemainingDistance;
/**
 * Class for draw on show route information
 * @author Michal Musialik
 * 
 */
public class dislpayinformation {

	public static int totDist = (int)(Dijkstra.path.get
			(Dijkstra.path.size()-1).minDistance);



	public int getTotDist() {
		return this.totDist;
	}
	public void setTotDist(int totDist) {
		this.totDist = totDist;
	}


}
