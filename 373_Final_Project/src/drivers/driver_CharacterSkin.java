package drivers;

import storeObjects.CharacterSkin;

public class driver_CharacterSkin {
	public static void main(String[] args) {
		CharacterSkin c1 = new CharacterSkin();
		
		if(!c1.getColor().equals("")) {
			System.out.println("Error with get color, expected empty string, got "+c1.getColor());
			return;
		}
		if(!c1.getShape().equals("")) {
			System.out.println("Error with get shape, expected empty string, got "+c1.getShape());
			return;
		}
		if(!c1.getPurchased() == false) {
			System.out.println("Error with get purchased, expected false, got "+c1.getPurchased());
			return;
		}
		c1.setColor("red");
		if(c1.getColor() != "red") {
			System.out.println("Error with set color, expected red, got "+c1.getColor());
			return;
		}
		c1.setShape("octagon");
		if(c1.getShape() != "octagon") {
			System.out.println("Error with set shape, expected octagon, got "+c1.getShape());
			return;
		}
		c1.setPurchased(true);
		if(c1.getPurchased() != true) {
			System.out.println("Error with set purchased, expected true, got "+c1.getPurchased());
			return;
		}
		try{
			c1.loadimage();
		}
		catch(Exception e){
			System.out.println("Error loading Image");
			e.printStackTrace();
			return;
		}
		System.out.println("Character skin passed all tests");
	}
}
