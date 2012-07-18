package dijkstra;

import java.util.ArrayList;

import calculations.PositionCalc;

/**
 * We can draw a line between nodes to get value of angle. Then it is easy to 
 * find the direction to follow in path of route by comparing those angles.
 * This class makes the calculations to find the angles between given 2 points. 
 * 
 * @author Savas Aydin
 */
public class Directions {
	
	/**
	 * This list stores inclines of lines between two nodes
	 */	
	public static ArrayList<Double> inclineList = new ArrayList<Double>();
	public static ArrayList<String> directionList=new ArrayList<String>();
	
	/**
	 * This method gets the nodes from path list and tries to convert
	 * them as x and y to calculate the incline between them.
	 * And estimates direction by comparing those inclines
	 */
	public void direction(ArrayList<Vertex> pathList){
		
		for(int i = 0 ; i < pathList.size() ; i++){
			
			double xIn=pathList.get(i).getLongitude();
			double yIn=pathList.get(i).getLatitude();
			
			double x = PositionCalc.calcX(xIn);
			double y = PositionCalc.calcY(yIn);
			
			if(i > 0){
				double xInOld = pathList.get(i-1).getLongitude();
				double yInOld = pathList.get(i-1).getLatitude();
				
				double xOld = PositionCalc.calcX(xInOld);
				double yOld = PositionCalc.calcY(yInOld);
				
				/**
				 * Basic math calculation for getting tangent of the line 
				 * between two nodes. 
				 * atan method calculates the angles 
				 * between value of -Pi/2 and Pi/2
				 * Math coordinate system Pi equals to 180 degree. 
				 * Necessary calculations to find angle are 
				 * computed. Then implemented to Java coordinate system. 
				 */
				double m = (y-yOld)/(x-xOld);
				double angle = Math.atan(m)* 180 / Math.PI;
				if (angle<0){
					angle=90-angle;
				}
				if((yOld>y)&&(xOld<x)){
					angle=-angle;
				}	
				if ((yOld>y)&&(xOld>x)){
					angle=180+angle;
				}
				inclineList.add(angle);
				
			}
				
		}
		
		/**
		 * Path size is always 1 element more inclineList size.
		 * Plus estimating direction comes from the constant of incline 
		 * which is 0.45 in this case.
		 * Because there is not exact straight way in reality. 
		 * There is always an incline for given 3 nodes
		 * Theoretically, there are 2 line between 3 nodes and differences 
		 * between tangents of lines give us the direction 
		 */
		for(int j=0;j<pathList.size();j++){
			System.out.print(pathList.get(j)+" ");
			if(j>=1 & j<Dijkstra.path.size()-1){
				if((inclineList.get(j)-inclineList.get(j-1))>25){
					System.out.print("Turn Right " );
					directionList.add("Turn Right");
				}	
				else if((inclineList.get(j)-inclineList.get(j-1))<-25){
					System.out.print("Turn Left  ");
					directionList.add("Turn Left");
				}	
				else{
					System.out.print("Go Straight  ");
					directionList.add("Go Straight");
				}	
			}
		}
		
	}
}
