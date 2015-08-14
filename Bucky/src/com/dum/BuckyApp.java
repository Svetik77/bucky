package com.dum;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;

public class BuckyApp extends JFrame {

	/**
	 * pics 206 x 120; 300 x 168
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// method
		/** x,y, 16 or 32 , how many time to refresh */
		DisplayMode dm = new DisplayMode(800, 600, 16,
				DisplayMode.REFRESH_RATE_UNKNOWN);
		BuckyApp b = new BuckyApp();
		b.runDisplay(dm);
	}

	public void runDisplay(DisplayMode dm) {
		// method
		setBackground(Color.PINK);
		setForeground(Color.WHITE);
		setFont(new Font("Arial", Font.PLAIN, 24));
		
		Screen2 scr = new Screen2();
		try {
			//this : reference to any object to working with here
			scr.setFullScreen(dm, this);
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		} finally {
			scr.restoreScreen();
		}
	}//
	
	@Override
	public void paint(Graphics g) {
		// method
		if(g instanceof Graphics2D) {
			Graphics2D g2 = (Graphics2D) g;
			//we want to change text, to smooth text 
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		}
		g.drawString("this is gona be awesome", 200, 200);

	}

}
