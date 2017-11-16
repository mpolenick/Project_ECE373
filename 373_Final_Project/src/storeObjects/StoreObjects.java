package storeObjects;
import java.awt.image.BufferedImage;

public abstract class StoreObjects {
	protected BufferedImage picture;
	protected int Price;
	protected int numLimit;
	protected int discount;
	public StoreObjects() {
		Price = 0;
		numLimit = 0;
		discount = 0;
	}
	public int getPrice() {
		return this.Price;
	}
	public int getnumLimit() {
		return this.numLimit;
	}
	public int getdiscount() {
		return this.discount;
	}
	public void setPrice(int e) {
		this.Price = e;
	}
	public void setnumLimit(int e) {
		this.numLimit = e;
	}
	public void setdiscount(int e) {
		this.discount = e;
	}
	public abstract void loadimage();
	
}
