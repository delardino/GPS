package dijkstra;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import calculations.Sleep;



/**
 * This class includes implementation of the Dijkstra algorithm and
 * find the shortest path between two nodes and allows you to set the nodes 
 * as start and end point
 * 
 * @author Savas Aydin 
 */
public class Dijkstra
{
	/**
	 *path ArrayList stores the Vertexes of shortest path from startVertex 
	 *to endVertex. allVertexList stores the Vertexes of we created 
	 *for given area.
	 */
	public static Vertex v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15,
	v16,v17,v18,v19,v20,v21,v22,v23,v24,v25,v26,v27,v28,v29,v30,v31,v32,v33,v34,
	v35,v36,v37;
	public static ArrayList<Vertex> path;  

	public static ArrayList<Vertex> allVertexList = new ArrayList<Vertex>(); 

	/**
	 * This is basically implementation of Dijkstra algorithm.
	 * First it finds the shortest vertex from source vertex 
	 * and add it to a list.  
	 */
	public static void implementationDijkstra(Vertex source)
	{
		/**
		 * First initialize single-source
		 */
		source.minDistance = 0.;
		PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
		vertexQueue.add(source);

		/**
		 * Visit each edge of u until list is empty
		 */
		while (!vertexQueue.isEmpty()) {
			Vertex u = vertexQueue.poll();

			for (Edge e : u.adjacencies){
				Vertex v = e.target;
				double weight = e.weight;
				double distancePassThroughU = u.minDistance + weight;

				/**
				 * Relax part
				 * if d[v]>d[u]+w(u,v)
				 * d[v]=d[u]+w(u,v)
				 */           
				if (distancePassThroughU < v.minDistance) {
					vertexQueue.remove(v);

					v.minDistance = distancePassThroughU ;
					v.previous = u;
					vertexQueue.add(v);
				}
			}
		}
	}

	/**
	 * This method stores the nodes start from target node to source node 
	 * as ArrayList. And reverses it to get shortest path from start point.
	 */
	public static ArrayList<Vertex> getShortestPathTo(Vertex target)
	{
		path = new ArrayList<Vertex>();
		for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
			path.add(vertex);

		Collections.reverse(path);
		return path;
	}

	/**
	 * this method defines the each vertexes on given map.
	 * You can see more details for nodes in Vertex class 
	 */
	public void setUpDijkstra()
	{
		v1 = new Vertex("1",11.93793, 57.70764);
		allVertexList.add(v1);
		v2 = new Vertex("Pressbyran", 11.93775, 57.70778);
		allVertexList.add(v2);
		v3 = new Vertex("3", 11.93793, 57.70725);
		allVertexList.add(v3);
		v4 = new Vertex("4", 11.93619, 57.70721);
		allVertexList.add(v4);
		v5 = new Vertex("5", 11.93668, 57.70706);
		allVertexList.add(v5);
		v6 = new Vertex("6", 11.93747, 57.70683);
		allVertexList.add(v6);
		v7 = new Vertex("7", 11.93578, 57.70676);
		allVertexList.add(v7);
		v8 = new Vertex("8", 11.93628, 57.70662);
		allVertexList.add(v8);
		v9 = new Vertex("9", 11.93708, 57.70642);
		allVertexList.add(v9);
		v10 = new Vertex("10", 11.93792, 57.70625);
		allVertexList.add(v10);
		v11 = new Vertex("11", 11.93926, 57.70640);
		allVertexList.add(v11);
		v12 = new Vertex("12", 11.93538, 57.70632);
		allVertexList.add(v12);
		v13 = new Vertex("13", 11.93589, 57.70617);
		allVertexList.add(v13);
		v14 = new Vertex("14", 11.93667, 57.70598);
		allVertexList.add(v14);
		v15 = new Vertex("15", 11.93746, 57.70578);
		allVertexList.add(v15);
		v16 = new Vertex("16", 11.93847, 57.70553);
		allVertexList.add(v16);
		v17 = new Vertex("Ferry",11.94000, 57.70575);
		allVertexList.add(v17);
		v18 = new Vertex("18", 11.93447, 57.70540);
		allVertexList.add(v18);
		v19 = new Vertex("19", 11.93588, 57.70505);
		allVertexList.add(v19);
		v20 = new Vertex("20", 11.93656, 57.70481);
		allVertexList.add(v20);
		v21 = new Vertex("21", 11.93761, 57.70453);
		allVertexList.add(v21);
		v22 = new Vertex("Patricia", 11.93726, 57.70660);
		allVertexList.add(v22);
		v23 = new Vertex("Svea", 11.93687,57.70619 );
		allVertexList.add(v23);
		v24 = new Vertex("Jupiter", 11.93806, 57.70642);
		allVertexList.add(v24);
		v25	 = new Vertex("Backa Theatre", 11.93621, 57.70609);
		allVertexList.add(v25);
		v26 = new Vertex("Esters Cafe", 11.93667, 57.70562);
		allVertexList.add(v26);
		v27 = new Vertex("27", 11.93687, 57.70592);
		allVertexList.add(v27);
		v28 = new Vertex("28", 11.93792, 57.70489);
		allVertexList.add(v28);
		v29 = new Vertex("Ericsson", 11.94084, 57.70598);
		allVertexList.add(v29);
		v30 = new Vertex("Sigma", 11.94065, 57.70624);
		allVertexList.add(v30);
		v31 = new Vertex("31", 11.94040, 57.70655);
		allVertexList.add(v31);
		v32= new Vertex("32",11.93949,57.70633 );
		allVertexList.add(v32);
		v33=new Vertex("Science Park", 11.93959, 57.70688);
		allVertexList.add(v33);
		v34=new Vertex("34", 11.93889, 57.70600);
		allVertexList.add(v34);
		v35=new Vertex("35", 11.93822, 57.70661);
		allVertexList.add(v35);
		v36=new Vertex("Aran Restaurant", 11.93739, 57.70459);
		allVertexList.add(v36);
		v37=new Vertex("Saga",11.93686,57.70620);
		allVertexList.add(v37);
		/**
		 * Connections of each node with the distance
		 */
		v1.adjacencies = new Edge[]{ new Edge(v3, 42),
				new Edge(v2, 25) };

		v2.adjacencies = new Edge[]{ new Edge(v1, 25)};

		v3.adjacencies = new Edge[]{ new Edge(v1, 42),
				new Edge(v6, 68),
				new Edge(v33, 190)};

		v4.adjacencies = new Edge[]{ new Edge(v5, 56),
				new Edge(v7, 66) };

		v5.adjacencies = new Edge[]{ new Edge(v4, 56),
				new Edge(v6, 90),
				new Edge(v8, 65)};

		v6.adjacencies = new Edge[]{ new Edge(v3,  68),
				new Edge(v5,  90),
				new Edge(v22, 34),
				new Edge(v10, 80),
				new Edge(v35, 47 )};

		v7.adjacencies = new Edge[]{ new Edge(v4,  66),
				new Edge(v8,  57), 
				new Edge(v12, 65)};

		v8.adjacencies = new Edge[]{ new Edge(v5, 65),
				new Edge(v7, 57),
				new Edge(v9, 91),
				new Edge(v13, 65)};

		v9.adjacencies = new Edge[]{ new Edge(v22, 27),
				new Edge(v8, 91),
				new Edge(v10, 94),
				new Edge(v23, 34)};

		v10.adjacencies = new Edge[]{ new Edge(v6, 80),
				new Edge(v9, 94),
				new Edge(v34,110),
				new Edge(v15, 72),
				new Edge(v16, 99),
				new Edge (v24, 24)};

		v11.adjacencies = new Edge[]{ new Edge(v34, 59),
				new Edge(v32, 26),
				new Edge(v33, 63)};

		v12.adjacencies = new Edge[]{ new Edge(v7, 65),
				new Edge(v13, 58),
				new Edge(v18, 140)};

		v13.adjacencies = new Edge[]{ new Edge(v8, 65),
				new Edge(v12, 58),
				new Edge(v25, 36)};

		v14.adjacencies =new Edge[]{ new Edge(v25, 52),
				new Edge(v37, 31),
				new Edge(v27, 23),
				new Edge(v19, 130)};

		v15.adjacencies = new Edge[]{ new Edge(v27, 67),
				new Edge(v10, 72),
				new Edge(v16, 110),
				new Edge(v20, 150)};

		v16.adjacencies = new Edge[]{ new Edge(v10, 99), 
				new Edge(v34, 69 ),
				new Edge(v15, 110),
				new Edge(v28, 92)};

		v17.adjacencies = new Edge[]{ new Edge(v32, 84),
				new Edge(v29, 96)};

		v18.adjacencies = new Edge[]{ new Edge(v12, 140),
				new Edge(v19, 160)};

		v19.adjacencies = new Edge[]{ new Edge(v18, 160),
				new Edge(v14, 130),
				new Edge(v20, 79)};

		v20.adjacencies = new Edge[]{ new Edge(v19, 79),
				new Edge(v15, 150),
				new Edge(v36, 94)};

		v21.adjacencies = new Edge[]{ new Edge(v28, 52),
				new Edge(v36, 25)};

		v22.adjacencies = new Edge[]{ new Edge(v6, 34),
				new Edge(v9, 27)};

		v23.adjacencies= new Edge[]{ new Edge(v9, 34),
				new Edge(v37, 1)};

		v24.adjacencies = new Edge[]{ new Edge(v10,24 ),
				new Edge(v35, 27)};

		v25.adjacencies = new Edge[]{ new Edge(v13, 36),
				new Edge(v14, 52)};

		v26.adjacencies = new Edge[]{ new Edge(v27, 39)};

		v27.adjacencies = new Edge[]{ new Edge(v14, 23),
				new Edge(v15, 67),
				new Edge(v26, 39)};

		v28.adjacencies = new Edge[]{ new Edge(v21, 52),
				new Edge(v16, 92)};
		
		v29.adjacencies = new Edge[]{ new Edge(v17, 96),
				new Edge(v30, 35)};
		
		v30.adjacencies = new Edge[]{ new Edge(v29, 35),
				new Edge(v31,34)};
		
		v31.adjacencies = new Edge[]{new Edge(v32, 43),
				new Edge(v30, 34)};
		
		v32.adjacencies = new Edge[]{new Edge(v11, 36),
				new Edge(v31, 43),
				new Edge(v17, 84)};
		
		v33.adjacencies = new Edge[]{new Edge(v3, 190),
				new Edge(v11, 63)};
		
		v34.adjacencies = new Edge[]{new Edge(v10, 110),
				new Edge(v11, 47),
				new Edge(v16, 69)};
		
		v35.adjacencies = new Edge[]{new Edge(v24, 110),
				new Edge(v11, 61 ),
				new Edge(v6, 47 )};
		
		v36.adjacencies = new Edge[]{new Edge(v21, 25),
				new Edge(v20, 94)};
		
		v37.adjacencies= new Edge[]{ new Edge(v23, 1),
				new Edge(v14, 31)};
	}     

	/**
	 * This method sets the start and end nodes 
	 * that you want to find the shortest path between 
	 */
	public void setStartTarget(Vertex startV, Vertex endV){
		implementationDijkstra(startV); //v1=source vertex
		{	
			List<Vertex> path = getShortestPathTo(endV);
			System.out.println("Path: " + path);
			System.out.println("Distance to " + endV + ": " + 
					endV.minDistance);
			
		}
	}
	
}
	
