package com.dum;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;

import javax.swing.JFrame;

public class Screen2 {

	private GraphicsDevice vc;

	public Screen2() {
		// constructor
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		/* to get our computer screen */

		vc = env.getDefaultScreenDevice();	

	}

	
	// window to full screen
	public void setFullScreen(DisplayMode dm, JFrame window) {
		window.setUndecorated(true);
		window.setResizable(false);
		/* window what we create take full screen */
		vc.setFullScreenWindow(window);
	
		   if(dm != null && vc.isDisplayChangeSupported()) {
		    	try {
		    		/*if in param: null make not fullscreen */
		    		vc.setDisplayMode(dm); 
		    	}catch (Exception e){}
		    }
	}//

	/* to comming back to our computer screen */
	public Window getFullScreenWindow()
	{
		return vc.getFullScreenWindow();

	}

	/**
	 * dispose() - это заявка для операционной системы, на освобождение ресурсов
	 * окна, связанных с данным Java объектом. Это не означает, что объект
	 * Proba1 должен быть уничтожен, просто ОС уничтожит связанное с ним окно.
	 * Ресурс окна можно заново запросить у ОС с помощью вызова методов pack или
	 * show.
	 */
	public void restoreScreen() {
		Window w = vc.getFullScreenWindow();
		/**/
		if (w != null) {
			//prepare to destroy
			w.dispose();
		}
		vc.setFullScreenWindow(null); //not fullscr any more
	}
}
