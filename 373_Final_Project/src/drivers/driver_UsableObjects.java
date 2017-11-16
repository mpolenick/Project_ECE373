package drivers;

import storeObjects.Lives;

public class driver_UsableObjects {
	public static void main(String[] args) {	
		driver_Lives.main(args);
		driver_powerUp.main(args);
		
		Lives obj = new Lives();
		
		if(obj.getRemaining() != 0) {
			System.out.println("Error with get remaining, expected 0 got "+obj.getRemaining());
			return;
		}
		obj.setRemaining(3);
		if(obj.getRemaining() != 3) {
			System.out.println("Error with set remaining, expected 3 got "+obj.getRemaining());
			return;
		}
		System.out.println("Usable Objects passed all tests\n");

	}

}
