package storeObjects;

public abstract class  UsableObjects extends StoreObjects {
	protected int remaining;
	public UsableObjects() {
		remaining = 0;
	}
	public int getRemaining() {
		return remaining;
	}
	public void setRemaining(int e) {
	       remaining = e;
	}
}
