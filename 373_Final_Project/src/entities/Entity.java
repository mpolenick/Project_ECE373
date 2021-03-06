package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

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
	
	public void render(Graphics2D g) {
		sprite.render(g,x,y);
		//g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		/*
		g.setColor(Color.RED);
        g.draw(getTop());
        g.setColor(Color.BLUE);
        g.draw(getBottom());
        g.setColor(Color.MAGENTA);
        g.draw(getLeft());
        g.setColor(Color.ORANGE);
        g.draw(getRight());
        */
	}
	
	public Rectangle getBounds() {
    	return new Rectangle((int) x,(int) y,sprite.getWidth(),sprite.getHeight());
    }
    
    public Rectangle getTop() {
    	return new Rectangle((int) x,(int) y,sprite.getWidth() - 6,4);
    }
    public Rectangle getBottom() {
    	return new Rectangle((int) x ,(int) y + sprite.getHeight()-4,sprite.getWidth()-6,4);
    }
    public Rectangle getRight() {
    	return new Rectangle((int) x + sprite.getWidth() - 4,(int) y +6,4,sprite.getHeight() - 10);
    }
    public Rectangle getLeft() {
    	return new Rectangle((int) x - 4 ,(int) y  +6,4,sprite.getHeight() - 10);
    }
}
