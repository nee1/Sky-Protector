import greenfoot.*;
import java.awt.Color;
public class GameOverScreen extends Actor
{
    public GameOverScreen()
    {
        
    }
    
    private PlayButton playButton;
    private HelpButton helpButton;
    private PlayGameCommand playCommand;
    private HelpCommand helpCommand;
    private ScreenStateManager screenStateManager1;
    SkyWorld skyworld;
    
    public GameOverScreen(ScreenStateManager screenStateManager, SkyWorld sky)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        setImage(new GreenfootImage("Game Over", 48, Color.WHITE, Color.BLACK));
        screenStateManager1 = screenStateManager;
        skyworld = sky;
        playButton = new PlayButton();
        helpButton = new HelpButton();
        helpCommand = new HelpCommand();
        playCommand = new PlayGameCommand();
    }
}
