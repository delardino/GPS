package VisualApp;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

/**
 * MP3 Player class
 * This class is downloaded from www.javazoom.net
 */

public class MP3Player {
	private String filename;
	private Player player; 
	
	public MP3Player(String filename) {
		this.filename = filename;
	}
	public void close() { 
		if (player != null) player.close();
	}
	public void play() {
		try {
			FileInputStream fis     = new FileInputStream(filename);
			BufferedInputStream bis = new BufferedInputStream(fis);
			player = new Player(bis);
		}
		catch (Exception e) {
			System.out.println("Problem playing file " + filename);
			System.out.println(e);
		}
	
		new Thread() {
			public void run() {
				try { player.play(); }
				catch (Exception e) { System.out.println(e); }
			}
		}.start();
	}
}
