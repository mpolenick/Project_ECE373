package entities;

import java.awt.Graphics;

import states.GameState;
import textures.Sprite;

public abstract class Entity {
	
	protected double x, y;
	protected Sprite sprite;
	protected GameState state;
	
	public Entity(Sprite sprite, double x, double y, GameState state) {
		super();
		this.sprite = sprite;
		this.x = x;
		this.y = y;
		this.state = state;
		System.out.println("Adding entity :"+ sprite.toString());
		state.addEntity(this);
	}
	
	public abstract void tick();
	
	public void render(Graphics g) {
		sprite.render(g,x,y);
	}
}
