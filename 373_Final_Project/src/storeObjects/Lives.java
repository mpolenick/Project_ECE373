package storeObjects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Lives extends UsableObjects {
	private int Lives;
	public Lives() {
		Lives = 3;
	}
	public int getLives() {
		return Lives;
	}
	public void setLives(int e) {
		 Lives = e;
	}
	public void addLife() {
		Lives += 1;
	}
	public void  removeLife() {
		Lives -= 1;
	}
	public void loadimage() {
		try {
			picture=ImageIO.read(getClass().getResource("../images/life.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
