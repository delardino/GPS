package VisualApp;




/**
 * This is a control class for the GUI frames and timer for AnimationFrame.java
 * @author Michal Musialik
 */

public class sizePosition {
	/**
	 * Various positions and sizes for gui
	 */
	
	private int xSizeFlag = 255;

	private int ySizeFlag = 255;

	private int xSize = 105; 
	private int ySize = 105; 
	
	private int xSizeBig = 255; 
	private int ySizeBig = 255; 
	
	private int xLoc = 100;	
	private int yLoc = 100;
	private int xMove = 255; 
	private int yMove = 255; 
	

	private int frameXsize = 1280;
	private int frameYsize = 796;
	
	
	
/**
 * Timer for automatic frame change in milliseconds
 */
	private int timeMili = 0;
	
	
	private int picXpos = 20;
	private int picYpos = 20;
	

	
	private int picXsize = 400;
	private int picYsize = 300;
	
	

	/**
	 * 	Setters and Getters
	 */
	public int getxSizeFlag() {
		return xSizeFlag;
	}
	public void setxSizeFlag(int xSizeFlag) {
		this.xSizeFlag = xSizeFlag;
	}
	public int getySizeFlag() {
		return ySizeFlag;
	}
	public void setySizeFlag(int ySizeFlag) {
		this.ySizeFlag = ySizeFlag;
	}
	public int getPicXsize() {
		return picXsize;
	}
	public void setPicXsize(int picXsize) {
		this.picXsize = picXsize;
	}
	public int getPicYsize() {
		return picYsize;
	}
	public int getxSizeBig() {
		return xSizeBig;
	}
	public void setxSizeBig(int xSizeBig) {
		this.xSizeBig = xSizeBig;
	}
	public int getySizeBig() {
		return ySizeBig;
	}
	public void setySizeBig(int ySizeBig) {
		this.ySizeBig = ySizeBig;
	}
	public void setPicYsize(int picYsize) {
		this.picYsize = picYsize;
	}

	public int getPicXpos() {
		return picXpos;
	}
	public void setPicXpos(int picXpos) {
		this.picXpos = picXpos;
	}
	public int getPicYpos() {
		return picYpos;
	}
	public void setPicYpos(int picYpos) {
		this.picYpos = picYpos;
	}
	
			

	public int getTimeMili() {
		return timeMili;
	}
	public void setTimeMili(int timeMili) {
		this.timeMili = timeMili;
	}
	public int getxSize() {
		return xSize;
	}
	public void setxSize(int xSize) {
		this.xSize = xSize;
	}
	public int getySize() {
		return ySize;
	}
	public void setySize(int ySize) {
		this.ySize = ySize;
	}
	public int getxLoc() {
		return xLoc;
	}
	public void setxLoc(int xLoc) {
		this.xLoc = xLoc;
	}
	public int getyLoc() {
		return yLoc;
	}
	public void setyLoc(int yLoc) {
		this.yLoc = yLoc;
	}
	public int getxMove() {
		return xMove;
	}
	public void setxMove(int xMove) {
		this.xMove = xMove;
	}
	public int getyMove() {
		return yMove;
	}
	public void setyMove(int yMove) {
		this.yMove = yMove;
	}
	
	public int getFrameXsize() {
		return frameXsize;
	}
	public void setFrameXsize(int frameXsize) {
		this.frameXsize = frameXsize;
	}
	public int getFrameYsize() {
		return frameYsize;
	}
	public void setFrameYsize(int frameYsize) {
		this.frameYsize = frameYsize;
	}
		
	
	
}
