package helloWorld;

import java.io.File;

import org.lwjgl.LWJGLUtil;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame
{
	public static final int SCREEN = 0;
	public Main()
	{
		super("My Game");
		addState(new GameWindow());
	}


	@Override
	public void initStatesList(GameContainer gc) throws SlickException
	{
		getState(SCREEN).init(gc, this);
		enterState(SCREEN);
		
	}
	
	public static void main(String[] args)
	{
		System.setProperty("org.lwjgl.librarypath", new File(new File(System.getProperty("user.dir"), "native"), LWJGLUtil.getPlatformName()).getAbsolutePath());
		try
		{
			AppGameContainer app = new AppGameContainer(new Main());
			int height = app.getScreenHeight() / 10 * 9;
			app.setShowFPS(true);
			app.setDisplayMode((int)(height*1.2), height, false);
			System.out.println("Ratio: " + height*1.2/height);
			app.start();
		} catch (SlickException e)
		{
			e.printStackTrace();
		}

	}

}
