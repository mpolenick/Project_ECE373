package entities;

import states.GameState;
import textures.Sprite;

public abstract class Mob extends Entity {
	
	protected double dx, dy;
	
	public Mob(Sprite sprite, double x, double y, GameState state) {
		super(sprite, x, y, state);
	}
	
	@Override
	public void tick() {
		move();
	}
	
	public void move() {
		x += dx;
		y += dy;
	}
}
