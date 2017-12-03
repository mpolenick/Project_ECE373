package entities;

import states.GameState;
import textures.Sprite;

public abstract class Mob extends Entity {
	
	protected double dx, dy;
	protected double maxDy;
	protected double gravity;
	protected boolean falling = true;
	protected boolean canJump;
	
	public Mob(Sprite sprite, double x, double y, GameState state) {
		super(sprite, x, y, state);
		gravity = 0.5;
		maxDy = 7;
	}
	
	@Override
	public void tick() {
		move();
		fall();
	}
	
	public void move() {
		x += dx;
		y += dy;
	}
	
	protected void fall() {
		if (falling) {
			dy += gravity;
			if (dy > maxDy) {
				dy = maxDy;
			}
		}
	}
	
	protected void jump (double jumpHeight) {
		//temporarily set can jump to true until collisions is working
		canJump = true;
		if (canJump) {
			dy -= jumpHeight;
			canJump = false;
		}
	}
}
