package states;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import entities.Entity;
import entities.Player;
import graphic_for_game.ShapeRunner;
import textures.Sprite;

public class GameState implements State{
	
	private ArrayList<Entity> entities;

	@Override
	public void init() {
		entities = new ArrayList<Entity>();
		new Player(new Sprite("octagonred"), 100, 100, this);
	}

	@Override
	public void enter() {}

	@Override
	public void tick(StateManager stateManager) {
		for (Entity e : entities) {
			e.tick();
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, ShapeRunner.WIDTH, ShapeRunner.HEIGHT);
		for (Entity e : entities) {
			e.render(g);
		}
	}

	@Override
	public void exit() {
		entities.clear();
	}

	@Override
	public String getName() {
		return "game";
	}

	public void addEntity(Entity entity) {
		entities.add(entity);
	}

}
