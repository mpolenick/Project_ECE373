package enemyObjects;

public class GroundEnemy extends Enemy
{
	private int totaldistMoveX;
	private boolean isHit;
	private String shape;
	
	public GroundEnemy() 
	{
		totaldistMoveX = 0;
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
		return this.totaldistMoveX;
	}
	public void setTotalDistance(int d)
	{
		this.totaldistMoveX = d;
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
		super.locX = super.locX + rate;
	}
}
