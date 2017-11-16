package drivers;

import enemyObjects.FlyEnemy;
import enemyObjects.GroundEnemy;

public class Driver_Enemy {

	public static void main(String[] args) 
	{
		//Test Enemy Class
		
		FlyEnemy f1 = new FlyEnemy();
		GroundEnemy g1 =  new GroundEnemy();
		
		//print info for enemy without change
		System.out.println("New object Enemy test: Should all be default \n");
		System.out.println("Test for FlyEnemy gets info from Enemy class: X:" + f1.getX() +  ", Y:"  + f1.getY() + ", HitX:" + f1.getHitBoxX() + ", HitY:" + f1.getHitBoxY()
				+  ", name:" + f1.getName());
		System.out.println("Test for GroundEnemy gets info from Enemy class: X:" + g1.getX() +  ", Y:"  + g1.getY() + ", HitX:" + g1.getHitBoxX() + ", HitY:" + g1.getHitBoxY()
				+  ", name:" + g1.getName());
		
		//print all info for actual class ground and fly
		System.out.println("\nNew object subclass test: Should all be default \n");
		System.out.println("Test for FlyEnemy class: shape:" + f1.getShape() +  ", hit?:"  + f1.getHit() + ", Tdist:" + f1.getTotalDistance());
		System.out.println("Test for GroundEnemy class: shape:" + g1.getShape() +  ", hit?:"  + g1.getHit() + ", Tdist:" + g1.getTotalDistance());
		
		
		//change location if hit and name
		//setting both to  0,0 so can see change 
		f1.setX(0);
		f1.setY(0);
		g1.setX(0);
		g1.setY(0);
		//setting to two different because hitboxes will not be the same
		f1.setHitBoxX(5);
		f1.setHitBoxY(5);
		g1.setHitBoxX(3);
		g1.setHitBoxY(3);
		//to tell the difference between enemys throughout levels
		f1.setName("FlyEnemy1");
		g1.setName("GroundEnemy1");
		
		//print result after changes
		System.out.println("\nNew object Enemy test: Should all be new values  \n");
		System.out.println("Test for FlyEnemy gets info from Enemy class: X:" + f1.getX() +  ", Y:"  + f1.getY() + ", HitX:" + f1.getHitBoxX() + ", HitY:" + f1.getHitBoxY()
				+  ", name:" + f1.getName());
		System.out.println("Test for GroundEnemy gets info from Enemy class: X:" + g1.getX() +  ", Y:"  + g1.getY() + ", HitX:" + g1.getHitBoxX() + ", HitY:" + g1.getHitBoxY()
				+  ", name:" + g1.getName());
		
		////change get hit shape and total distance
		// setting to square and triangle
		f1.setShape("Square");
		g1.setShape("Triangle");
		//setting got hit or not f1 = false g1 = true;
		f1.setHit(false);
		g1.setHit(true);
		//total dist for both are 10 and 5 
		f1.setTotalDistance(10);
		g1.setTotalDistance(5);
		//print results after changes
		System.out.println("\nNew object subclass test: Should all be new values \n");
		System.out.println("Test for FlyEnemy class: shape:" + f1.getShape() +  ", hit?:"  + f1.getHit() + ", Tdist:" + f1.getTotalDistance());
		System.out.println("Test for GroundEnemy class: shape:" + g1.getShape() +  ", hit?:"  + g1.getHit() + ", Tdist:" + g1.getTotalDistance());
		
		
		//testing the move function in the fly and ground
		System.out.println("\nTest to see if move function runs :\n");
		System.out.println("test move up RATE = 2: ");
		for(int i = 0; i < f1.getTotalDistance();i = i + 2 )
		{
			f1.move(2);
			System.out.println("FlyE YLoc: " + f1.getY() );
		}
		System.out.println("test move down RATE = -2: ");
		for(int i = f1.getTotalDistance(); i > 0;i = i - 2 )
		{
			f1.move(-2);
			System.out.println("FlyE YLoc: " + f1.getY() );
		}
		
		System.out.println("test move right RATE = 1: ");
		for(int j = 0; j < g1.getTotalDistance();j++ )
		{
			g1.move(1);
			System.out.println("GroundE XLoc: " + g1.getX() );
		}
		System.out.println("test move left RATE = -1: ");
		for(int i = g1.getTotalDistance(); i > 0;i-- )
		{
			g1.move(-1);
			System.out.println("GroundE XLoc: " + g1.getX() );
		}
		
		
	}

}
