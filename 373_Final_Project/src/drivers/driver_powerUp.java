package drivers;

import storeObjects.powerUp;

public class driver_powerUp {
	public static void main(String[] args) {
		powerUp p1 = new powerUp();
		powerUp p2 = new powerUp();
		
		String effect = p1.getEffect();
		if(effect != null) {
			System.out.println("Error with get effect, expected null, got "+effect);
			return;
		}
		if(p1.getUsed() != true) {
			System.out.println("Error with get used, expected true, got "+p1.getUsed());
			return;
		}
		p1.setUsed(false);
		if(p1.getUsed() != false) {
			System.out.println("Error with set use, expected true, got "+p1.getUsed());
			return;
		}
		p1.Use();
		if(p1.getUsed() != true) {
			System.out.println("Error with use, expected true, got "+p1.getUsed());
			return;
		}
		p1.setEffect("test");
		effect = p1.getEffect();
		if(effect != "test") {
			System.out.println("Error with set effect, expected test got "+effect);
			return;
		}
		p2.setEffect("test2");
		p1.replace(p2);
		effect = p1.getEffect();
		if(effect != "test2" || p1.getUsed() != false) {
			System.out.println("Error with replace, expected test2 got "+effect);
			return;
		}
		p1.setEffect("lightning");
		try{
			p1.loadimage();
		}
		catch(Exception e){
			System.out.println("Error loading Image");
			e.printStackTrace();
			return;
		}
		System.out.println("Power ups passed all tests");

	}
}
