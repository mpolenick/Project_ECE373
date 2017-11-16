package storeObjects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class CharacterSkin extends StoreObjects {
	private String Color;
	private String Shape;
	private boolean purchased;
	public CharacterSkin() {
		Color = new String();
		Shape = new String();
		purchased = false;
	}
	public void setColor(String e) {
		Color = e;
	}
	public void setShape(String e) {
		Shape = e;
	}
	public void setPurchased(boolean e) {
		purchased = e;
	}
	public String getColor() {
		return Color;
	}
	public String getShape() {
		return Shape;
	}
	public boolean getPurchased() {
		return purchased;
	}
	public void loadimage() {
		try {
			picture=ImageIO.read(getClass().getResource("../images/"+Shape+Color+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
