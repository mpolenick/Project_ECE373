package drivers;

import storeObjects.Lives;

public class driver_StoreObject {
	public static void main(String[] args) {
		System.out.println("===Testing store objects===\n");
		driver_UsableObjects.main(args);
		driver_CharacterSkin.main(args);
		
		Lives store = new Lives();
		
		if(store.getPrice() != 0) {
			System.out.println("Error with get price, expected 0 got "+store.getPrice());
			return;
		}
		if(store.getnumLimit() != 0) {
			System.out.println("Error with get num limit, expected 0 got "+store.getnumLimit());
			return;
		}
		if(store.getdiscount() != 0) {
			System.out.println("Error with get discount, expected 0 got "+store.getdiscount());
			return;
		}
		
		store.setPrice(10);
		if(store.getPrice() != 10) {
			System.out.println("Error with get price, expected 10 got "+store.getPrice());
			return;
		}
		store.setnumLimit(5);
		if(store.getnumLimit() != 5) {
			System.out.println("Error with get num limit, expected 5 got "+store.getnumLimit());
			return;
		}
		store.setdiscount(20);
		if(store.getdiscount() != 20) {
			System.out.println("Error with get discount, expected 20 got "+store.getdiscount());
			return;
		}
		System.out.println("\n===Store Objects passed all tests===");
	}

}
