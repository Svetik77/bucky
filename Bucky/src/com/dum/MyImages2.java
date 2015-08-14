package com.dum;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyImages2 extends JFrame {

	/**
	 * pics 206 x 120; lesok 300 x 168, pole 1600 x 1000
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// method
		/** x,y, 16 or 32 , how many time to refresh */
		DisplayMode dm = new DisplayMode(800, 600, 16,
				DisplayMode.REFRESH_RATE_UNKNOWN);
		MyImages2 im = new MyImages2();
		im.runDisplayMy(dm);
	}

	private Screen2 scr;
	private Image backgr;
	private Image face;
	private boolean loaded;

	public void runDisplayMy(DisplayMode dm) {
		// run method
		setBackground(Color.PINK);
		setForeground(Color.WHITE);
		setFont(new Font("Arial", Font.PLAIN, 24));

		loaded = false;

		Screen2 scr = new Screen2();
		try {
			// this : reference to any object to working with here
			scr.setFullScreen(dm, this);
			loadPics();
			try {
				Thread.sleep(3000);
			} catch (Exception e) {	
			}
		} finally {
			scr.restoreScreen();
		}
	}

	public void loadPics() {
		String lesok3 = "C:\\Users\\sveta\\workspaceGames\\Bucky\\src\\resource\\lesok.jpg";
		// pole 1600 x 1000
		String pole = "C:\\Users\\sveta\\workspaceGames\\Bucky\\src\\resource\\pole.jpg";
		// kolobok 206 x 120
		String kolobok = "resource/kolobok.jpg";
		String kolobok2 = "resource/kolobok2.jpg";
		String lesok = "resource/lesok.jpg";
		// method
		Image imgKolobok = new ImageIcon(getClass().getClassLoader()
				.getResource(kolobok)).getImage();
		Image imgKolobok2 = new ImageIcon(getClass().getClassLoader()
				.getResource(kolobok2)).getImage();
		Image imgLesok = new ImageIcon(getClass().getClassLoader().getResource(
				lesok)).getImage();

		// backgr = imgLesok;
		backgr = new ImageIcon(pole).getImage();
		face = imgKolobok;
		loaded = true;
		repaint();
	}

	//

	@Override
	public void paint(Graphics g) {
		// method
		if (g instanceof Graphics2D) {
			Graphics2D g2 = (Graphics2D) g;
			// we want to change text, to smooth text
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
					RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		}
		if (loaded) {
			g.drawImage(backgr, 0, 0, null);
			g.drawImage(face, 300, 180, null);
		}

	}

	public Screen2 getScr() {
		return scr;
	}

	public void setScr(Screen2 scr) {
		this.scr = scr;
	}

}
