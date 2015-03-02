package com.burningbushgames.test;



import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameWindow extends BasicGameState {
	
	private Shape rectangle;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{
		rectangle = new Polygon(new float[] {0,0, 10,0, 10,10, 0,10});
		rectangle.setCenterX(gc.getWidth()*.5F);
		rectangle.setCenterY(gc.getHeight()*.5F);
		System.out.println("you suck");
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException 
	{
		g.setColor(Color.orange);
		g.fill(rectangle);
		g.setColor(Color.red);
		g.draw(rectangle);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		return 0;
	}


}
