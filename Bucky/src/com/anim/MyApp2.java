package com.anim;

import java.awt.DisplayMode;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import com.dum.Screen2;

public class MyApp2 {
	private Screen2 screen;
	private Image bgr ;
	private Animation animat;
	

	
	public static void main(String[] args) {
		// method
		DisplayMode dm = new DisplayMode(800, 600, 16,
				DisplayMode.REFRESH_RATE_UNKNOWN);
		MyApp2 b = new MyApp2();
		b.runDisplay(dm);
	}// main
	
	public void runDisplay(DisplayMode dm) {
		// method
		screen = new Screen2();
		try {
			screen.setFullScreen(dm, new JFrame());
			loadPics();
			movieLoop();
		} finally {
			screen.restoreScreen();
		}
	}

	public void movieLoop() {
		// method
		
	}

	String pole = "resource/pole.jpg";
	Image imgPole = new ImageIcon(getClass().getClassLoader()
			.getResource(pole)).getImage();
	String s1 = "resource/sss1.png";
	Image imgSSS1 = new ImageIcon(getClass().getClassLoader()
			.getResource(s1)).getImage();
	String s2 = "resource/sss1.png";
	Image imgSSS2 = new ImageIcon(getClass().getClassLoader()
			.getResource(s1)).getImage();
	String s4 = "resource/sss2.png";
	Image imgSSS4 = new ImageIcon(getClass().getClassLoader()
			.getResource(s4)).getImage();
	String s5 = "resource/sss4.png";
	Image imgSSS5 = new ImageIcon(getClass().getClassLoader()
			.getResource(s5)).getImage();
	
	public void loadPics() {
		bgr = imgPole;
		animat = new Animation();
		animat.addScene(imgSSS1, 250);
		animat.addScene(imgSSS2, 250);
		animat.addScene(imgSSS4, 250);
		animat.addScene(imgSSS5, 250);
	}
}
