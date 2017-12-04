package world;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

import textures.Sprite;
import textures.Texture;

public class Tile {

    private static final Texture            terrain = new Texture("spritesheet_template");
    private static final Map<Integer, Tile> tileMap = new HashMap<Integer, Tile>();
    protected Texture                       sprite;
    protected Sprite 						sprite1;
    protected boolean                       solid;
    protected int                           id;
    protected float x,y;

    public static final Tile tile1 = new Tile(0xFFFFFFFF, new Texture(terrain, 1, 1, 64));
    public static final Tile tile2 = new Tile(0xFFFF0000, new Texture(terrain, 1, 2, 64));

    private Tile(int id, Texture sprite) {
        this.id = id;
        this.sprite = sprite;
        solid = true;
        tileMap.put(id, this);
    }
    //probably will delete all rectangle methods
    public Rectangle getBounds() {
    	return new Rectangle((int) x,(int) y,sprite1.getWidth(),sprite1.getHeight());
    }
    
    public Rectangle getTop() {
    	return new Rectangle((int) x + 6,(int) y,sprite1.getWidth() - 6,4);
    }
    public Rectangle getBottom() {
    	return new Rectangle((int) x + 6,(int) y + sprite1.getHeight()-4,sprite1.getWidth() - 6,4);
    }
    public Rectangle getRight() {
    	return new Rectangle((int) x + sprite1.getWidth() - 4,(int) y +6,4,sprite1.getHeight() - 6);
    }
    public Rectangle getLeft() {
    	return new Rectangle((int) x - 6 ,(int) y  +6,4,sprite1.getHeight() - 6);
    }
    public Tile(float x, float y, Sprite sprite2) {
		this.x = x;
		this.y = y;
		this.sprite1 = sprite2;
		this.solid = true;
	}

	public void render(Graphics2D g) {
        sprite1.render(g, x, y);
        //debug stuff?
        g.setColor(Color.RED);
        g.draw(getTop());
        g.setColor(Color.BLUE);
        g.draw(getBottom());
        g.setColor(Color.MAGENTA);
        g.draw(getLeft());
        g.setColor(Color.ORANGE);
        g.draw(getRight());
        
    }


    public boolean isSolid() {
        return solid;
    }

    public static Tile getFromID(int id) {
        return tileMap.get(id);
    }

}
