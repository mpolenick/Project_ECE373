package enemyObjects;

public class FlyEnemy extends Enemy
{
	private int totaldistMoveY;
	private boolean isHit;
	private String shape;
	
	public FlyEnemy() 
	{
		totaldistMoveY = 0;
		isHit = false;
		shape = "NOSHAPE";
	}

	//setters and getters
	public String getShape()
	{
		return this.shape;
	}
	public void setShape(String s)
	{
		this.shape = s;
	}
	public int getTotalDistance()
	{
		return this.totaldistMoveY;
	}
	public void setTotalDistance(int d)
	{
		this.totaldistMoveY = d;
	}
	public boolean getHit()
	{
		return this.isHit;
	}
	public void setHit(boolean b)
	{
		this.isHit = b;
	}

	public void move(int rate) 
	{
		super.locY = super.locY + rate;
	}
}
