package VisualApp;

import javax.swing.JButton;





/**
 * Button class
 * @author Michal Musialik 
 */
public class buttons {
	/**
	 * Main frame buttons
	 */
	private JButton FindLocation = new JButton ();
	private JButton FindWithCurrent = new JButton ();
	private JButton CurrentLocation = new JButton ();
	private JButton Languade = new JButton ();
	private JButton GameButton = new JButton ();
	private JButton shutdown = new JButton ();



	/**
	 * Game frame buttons
	 */
	private JButton StravTheFox = new JButton ();
	private JButton FeedingDucks= new JButton ();
	/**
	 * Back and ok buttons
	 */

	private JButton Back = new JButton ();
	private JButton Ok = new JButton ();
	/**
	 * Languade frame buttons
	 */
	private JButton polandButton = new JButton("Polski");
	private JButton swedenButton = new JButton("Svenska");
	private JButton turkeyButton = new JButton("Turkish");
	private JButton englandButton = new JButton("English");
	private JButton persianButton = new JButton("Persian");
	private JButton ethiopianButton = new JButton("Ethopian");
	/**
	 * Map frame buttons
	 */
	public static JButton RouteSummary = new JButton ();

	/**
	 * Route summary buttons
	 */
	private JButton goToMain = new JButton ();
	/**
	 * Setters and getters
	 */
	public JButton getGoToMain() {
		return goToMain;
	}
	public void setGoToMain(JButton goToMain) {
		this.goToMain = goToMain;
	}
	public static JButton getRouteSummary() {
		return RouteSummary;
	}
	public static void setRouteSummary(JButton routeSummary) {
		RouteSummary = routeSummary;
	}

	public JButton getStravTheFox() {
		return StravTheFox;
	}
	public void setStravTheFox(JButton stravTheFox) {
		StravTheFox = stravTheFox;
	}
	public JButton getFeedingDucks() {
		return FeedingDucks;
	}
	public void setFeedingDucks(JButton feedingDucks) {
		FeedingDucks = feedingDucks;
	}
	public JButton getBack() {
		return Back;
	}
	public void setBack(JButton back) {
		Back = back;
	}
	public JButton getOk() {
		return Ok;
	}
	public void setOk(JButton ok) {
		Ok = ok;
	}
	public JButton getPolandButton() {
		return polandButton;
	}
	public void setPolandButton(JButton polandButton) {
		this.polandButton = polandButton;
	}
	public JButton getSwedenButton() {
		return swedenButton;
	}
	public void setSwedenButton(JButton swedenButton) {
		this.swedenButton = swedenButton;
	}
	public JButton getTurkeyButton() {
		return turkeyButton;
	}
	public void setTurkeyButton(JButton turkeyButton) {
		this.turkeyButton = turkeyButton;
	}
	public JButton getEnglandButton() {
		return englandButton;
	}
	public void setEnglandButton(JButton englandButton) {
		this.englandButton = englandButton;
	}
	public JButton getPersianButton() {
		return persianButton;
	}
	public void setPersianButton(JButton persianButton) {
		this.persianButton = persianButton;
	}
	public JButton getEthiopianButton() {
		return ethiopianButton;
	}
	public void setEthiopianButton(JButton ethiopianButton) {
		this.ethiopianButton = ethiopianButton;
	}

	public JButton getFindLocation() {
		return FindLocation;
	}
	public void setFindLocation(JButton findLocation) {
		FindLocation = findLocation;
	}
	public JButton getFindWithCurrent() {
		return FindWithCurrent;
	}
	public void setFindWithCurrent(JButton findWithCurrent) {
		FindWithCurrent = findWithCurrent;
	}
	public JButton getCurrentLocation() {
		return CurrentLocation;
	}
	public void setCurrentLocation(JButton currentLocation) {
		CurrentLocation = currentLocation;
	}
	public JButton getLanguade() {
		return Languade;
	}
	public void setLanguade(JButton languade) {
		Languade = languade;
	}
	public JButton getGameButton() {
		return GameButton;
	}
	public void setGameButton(JButton gameButton) {
		GameButton = gameButton;
	}
	public JButton getShutdown() {
		return shutdown;
	}
	public void setShutdown(JButton shutdown) {
		this.shutdown = shutdown;
	}


}