package storeObjects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class powerUp extends UsableObjects {
	private String Effect;
	private boolean used;
	public powerUp() {
		Effect = null;
		used = true;
	}
	public void Use() {
		used = true;
	}
	public void replace(powerUp e) {
		this.Effect = e.Effect;
		this.used = false;
	}
	public String getEffect() {
		return Effect;
	}
	public void setEffect(String e) {
		Effect = e;
	}
	public boolean getUsed() {
		return used;
	}
	public void setUsed(boolean e) {
		used = e;
	}
public void loadimage() {
	try {
		picture=ImageIO.read(getClass().getResource("../images/"+Effect+".png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}
