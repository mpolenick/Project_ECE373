package states;

import java.awt.Graphics;

public interface State {
	public void init();
	public void enter();	//enter state
	public void tick(StateManager stateManager);
	public void render(Graphics g);
	public void exit();		//exit state
	public String getName();
}
