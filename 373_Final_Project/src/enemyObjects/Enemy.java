package enemyObjects;

public abstract class Enemy 
{
	protected String name;
	protected int locX;
	protected int locY;
	protected int hitboxX;
	protected int hitboxY;
	
	public Enemy()
	{
		name = "noName";
		locX = -9999;
		locY = -9999;
		hitboxX = -9999;
		hitboxY = -9999;
	}
	
	//setters and getters
	public String getName()
	{
		return this.name;
	}
	public int getX()
	{
		return this.locX;
	}
	public int getY()
	{
		return this.locY;
	}
	public int getHitBoxX()
	{
		return this.hitboxX;
	}
	public int getHitBoxY()
	{
		return this.hitboxY;
	}
	public void setName(String n)
	{
		this.name = n;
	}
	public void setX(int x)
	{
		this.locX = x;
	}
	public void setY(int y)
	{
		this.locY = y;
	}
	public void setHitBoxX(int x)
	{
		this.hitboxX = x;
	}
	public void setHitBoxY(int y)
	{
		this.hitboxY = y;
	}
	
	//abstract methods
	public abstract void move(int rate);
}
