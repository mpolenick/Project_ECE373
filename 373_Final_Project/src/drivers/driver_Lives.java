package drivers;

import storeObjects.Lives;

public class driver_Lives {
	public static void main(String[] args) {
		Lives l1 = new Lives();
		
		int curLives = l1.getLives();
		if(curLives != 3) {
			System.out.println("Error with get lives, expected 3 got "+curLives);
			return;
		}
		l1.setLives(4);
		curLives = l1.getLives();
		if(curLives != 4) {
			System.out.println("Error with set lives, expected 4 got "+curLives);
			return;
		}
		l1.removeLife();
		l1.removeLife();
		curLives = l1.getLives();
		if(curLives != 2) {
			System.out.println("Error with remove life lives, expected 2 got "+curLives);
			return;
		}
		l1.addLife();
		l1.addLife();
		l1.addLife();
		curLives = l1.getLives();
		if(curLives != 5) {
			System.out.println("Error with add life, expected 5 got "+curLives);
			return;
		}
		try{
			l1.loadimage();
		}
		catch(Exception e){
			System.out.println("Error loading Image");
			e.printStackTrace();
			return;
		}
		System.out.println("Lives passed all tests");

	}
}
