package VisualApp;

import javax.swing.Icon;
import javax.swing.ImageIcon;


/**
 * Graphical control class
 * @author Michal Musialik,Hanei Vahabi, Rahwa Batha
 */
public class pictures {


	/**
	 * List of locations, is used by comboboxes in both of selection options
	 */
	
	public String[] Names={	language.strTable[language.lang][10],
			"Aran Restaurant","Backa Theatre","Ericsson","Esters Cafe",
			"Ferry","Jupiter","Patricia","Pressbyran","Saga","Science Park",
			"Sigma","Svea"};
	private ImageIcon[] pics;
/**
 * Pictures are matched with location choices
 */
	public pictures(){
		pics=new ImageIcon[Names.length];
		for(int i=0;i<Names.length;i++)
			pics[i]=new ImageIcon("locations/"+Names[i]+".JPG"); 
		
	}
	

	private ImageIcon polishFlag = new ImageIcon("images/Polen.jpg");
	private ImageIcon swedishFlag = new ImageIcon("images/Sweden.jpg");
	private ImageIcon turkeyFlag = new ImageIcon("images/Turkey.jpg");
	private ImageIcon englondFlag = new ImageIcon("images/England.jpg");
	private ImageIcon persianFlag = new ImageIcon("images/Iran.jpg");
	private ImageIcon ehtopianFlag = new ImageIcon("images/Ethopien.jpg");
	private ImageIcon view = new ImageIcon("buttons/viewcurr.jpg");
	public static ImageIcon shade = new ImageIcon(
			"buttons/smallroutesummarygray.jpg");
	


	private ImageIcon route = new ImageIcon ("buttons/routesummary.jpg");
	private ImageIcon quit = new ImageIcon ("buttons/quitsmall.jpg");
	private ImageIcon ok = new ImageIcon ("buttons/oksmall.jpg");
	private ImageIcon back = new ImageIcon ("buttons/backsmall.jpg");
	private ImageIcon lang = new ImageIcon ("buttons/lang.jpg");
	private ImageIcon games = new ImageIcon ("buttons/games.jpg");
	private ImageIcon FindLatob = new ImageIcon ("buttons/atob.jpg"); 
	private ImageIcon FindL = new ImageIcon ("buttons/findl.jpg");
	public static ImageIcon smallroute = new ImageIcon (
			"buttons/smallroutesummary.jpg");
	private ImageIcon feedingd = new ImageIcon ("buttons/feedingducks.jpg");
	private ImageIcon starvethef = new ImageIcon ("buttons/starvethefox.jpg");



	/**
	 * This is default picture
	 * 
	 */
	private ImageIcon pic1 = new ImageIcon ("images/gu.png");
	
	/**
	 * Setters and getters
	 */
	public ImageIcon getSmallroute() {
		return smallroute;
	}
	public void setSmallroute(ImageIcon smallroute) {
		this.smallroute = smallroute;
	}

	public ImageIcon getShade() {
		return shade;
	}
	public void setShade(ImageIcon shade) {
		this.shade = shade;
	}
	

	public ImageIcon getPolishFlag() {
		return polishFlag;
	}
	public void setPolishFlag(ImageIcon polishFlag) {
		this.polishFlag = polishFlag;
	}
	public ImageIcon getSwedishFlag() {
		return swedishFlag;
	}
	public void setSwedishFlag(ImageIcon swedishFlag) {
		this.swedishFlag = swedishFlag;
	}
	public ImageIcon getTurkeyFlag() {
		return turkeyFlag;
	}
	public void setTurkeyFlag(ImageIcon turkeyFlag) {
		this.turkeyFlag = turkeyFlag;
	}
	public ImageIcon getEnglondFlag() {
		return englondFlag;
	}
	public void setEnglondFlag(ImageIcon englondFlag) {
		this.englondFlag = englondFlag;
	}
	public ImageIcon getPersianFlag() {
		return persianFlag;
	}
	public void setPersianFlag(ImageIcon persianFlag) {
		this.persianFlag = persianFlag;
	}
	public ImageIcon getEhtopianFlag() {
		return ehtopianFlag;
	}
	public void setEhtopianFlag(ImageIcon ehtopianFlag) {
		this.ehtopianFlag = ehtopianFlag;
	}
		
	public ImageIcon getPic1() {
		return pic1;
	}
	public ImageIcon getPic(int i) {
		return pics[i];
	}
	
	public void setPic1(ImageIcon pic1) {
		this.pic1 = pic1;
	}
	
	public String[] getNames() {
		return Names;
	}
	public void setNames(String[] names) {
		Names = names;
	}
	public ImageIcon[] getPics() {
		return pics;
	}
	public void setPics(ImageIcon[] pics) {
		this.pics = pics;
	}
	public ImageIcon getView() {
		return view;
	}
	public void setView(ImageIcon view) {
		this.view = view;
	}
	public ImageIcon getRoute() {
		return route;
	}
	public void setRoute(ImageIcon route) {
		this.route = route;
	}
	public ImageIcon getQuit() {
		return quit;
	}
	public void setQuit(ImageIcon quit) {
		this.quit = quit;
	}
	public ImageIcon getOk() {
		return ok;
	}
	public void setOk(ImageIcon ok) {
		this.ok = ok;
	}
	public ImageIcon getBack() {
		return back;
	}
	public void setBack(ImageIcon back) {
		this.back = back;
	}
	public ImageIcon getLang() {
		return lang;
	}
	public void setLang(ImageIcon lang) {
		this.lang = lang;
	}
	public ImageIcon getGames() {
		return games;
	}
	public void setGames(ImageIcon games) {
		this.games = games;
	}
	public ImageIcon getFindLatob() {
		return FindLatob;
	}
	public void setFindLatob(ImageIcon findLatob) {
		FindLatob = findLatob;
	}
	public ImageIcon getFindL() {
		return FindL;
	}
	public void setFindL(ImageIcon findL) {
		FindL = findL;
	}
	public ImageIcon getFeedingd() {
		return feedingd;
	}
	public void setFeedingd(ImageIcon feedingd) {
		this.feedingd = feedingd;
	}
	public ImageIcon getStarvethef() {
		return starvethef;
	}
	public void setStarvethef(ImageIcon starvethef) {
		this.starvethef = starvethef;
	}
	
	
	
}
