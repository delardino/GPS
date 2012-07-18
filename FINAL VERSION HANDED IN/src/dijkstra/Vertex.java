package dijkstra;
import java.util.*;

/**
 * This class defines the nodes 
 * 
 * @author Savas Aydin
 */
public class Vertex implements Comparable<Vertex>
{
	 /**
     * Adjacencies array keeps the neighbors of the nodes.
     * minDistance is the shortest distance to source node.
     * previous stores the previous vertex to get path
     */
    public final String name;
    public Edge[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    public double longitude, latitude;
    
    /**
     * A vertex consists of a name, longitude and latitude which refer 
     * respectively x and y in coordinate axis
     */
    public Vertex(String vertexName, double longitude, double latitude) { 
   	 this.name = vertexName;
   	 this.longitude=longitude; 
   	 this.latitude=latitude;
    }
    public double getLongitude(){ return longitude;}
    
    public double getLatitude(){ return latitude;}
    
    public String toString() { return name; }
    
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }

}
