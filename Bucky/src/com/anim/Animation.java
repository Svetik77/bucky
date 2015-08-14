package com.anim;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Animation {
	
	List<OneScene> scenList ;
	private int scenIndex;
	//how long time
	private long movieTime;
	private long totalTime;
	
	
	Animation() {
		//constructor 
		scenList = new ArrayList<>();
		totalTime = 0;
		startik();
	}
	
	/**add scene to ArrayList and set Time for each scene
	 * if i have 3 sceen, totalTime = 3 */
	public synchronized void addScene(Image img, long t) {
		totalTime += t;
		/*if I have 3 scene it add 3 elements*/
		scenList.add(new OneScene(img, totalTime));
	}

	//start animation from beginning
	public synchronized void startik() {
		// method
		movieTime = 0;
		scenIndex = 0;	
	}

	//change scene timePast from last update
	public synchronized void update(long timePast) {
		if(scenList.size() > 1) {
			movieTime += timePast;
			
			// if true we have to restart pic other wise it will stay
			if(movieTime >= totalTime) {
				movieTime = 0;
				scenIndex = 0;
			}//1
			
		}//2
		
		/*when it end of one scene scenIndex++ go to the next one */
		while (movieTime > getScene(scenIndex).endTime) {
			scenIndex++;
		}	
	}
	
	// get animation current scene (aka image)
	public synchronized Image getImage() {
		if(scenList.size() == 0) {
			return null;
		} else {
			return getScene(scenIndex).pic;
		}
	}//
	
	
	private  OneScene getScene(int x) {
		return (OneScene)scenList.get(x);
	}
	//// PRIVASTE INNER CLASS 
	private  class OneScene {
		public long endTime;
		Image pic;
		public OneScene( Image pic, long endTime) {
	
			this.endTime = endTime;
			this.pic = pic;
		}
		
	
	}
}
