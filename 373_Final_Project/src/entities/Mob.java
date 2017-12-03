package entities;

import states.GameState;
import textures.Sprite;
import world.Tile;

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
		if(!hasHorizontalCollision()) x += dx;
		if(!hasVerticalCollision()) y += dy;
	}
	
	protected boolean hasVerticalCollision() {
		for(int i =0; i < state.getTiles().size();i++) {
			Tile t = state.getTiles().get(i);
			if(getBounds().intersects(t.getTop()) && (dy > 0)) {
				dy = 0;
				return true;
			}
			if(getBounds().intersects(t.getBottom()) && dy < 0) {
				dy = 0;
				return true;
			}
		}
		return false;
	}
	
	protected boolean hasHorizontalCollision() {
		for(int i =0; i < state.getTiles().size();i++) {
			Tile t = state.getTiles().get(i);
			if(getBounds().intersects(t.getRight()) && (dx < 0)) {
				dx = 0;
				return true;
			}
			if(getBounds().intersects(t.getLeft()) && dx > 0) {
				dx = 0;
				return true;
			}
		}
		return false;
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
