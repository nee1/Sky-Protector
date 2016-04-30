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
        //System.out.println("before calling doPlay of Initial Screen - in initialscreen : " + screenStateManager);
        prepare();
    }
    
    
    public void prepare()
    {
        System.out.println("getWorld in GameOverScreen : " + getWorld());
        skyworld.addObject(playButton, skyworld.getWidth()/2, 100);
        skyworld.addObject(helpButton, skyworld.getWidth()/2, 200);
        playButton.setCommand(playCommand);
        helpButton.setCommand(helpCommand);
        //ScreenStateManager ss = screenStateManager1;
        //System.out.println("before calling doPlay of Initial Screen - in prepare : " + ss);
        playCommand.setReceiver(
            new Receiver()
            {
                public void performAction()
                {
                    if(Greenfoot.mouseClicked(playButton)){
                        System.out.println("before calling doPlay Method in playCommand.setReciever : " + screenStateManager1);
                        //System.out.println("before calling Screen2 : " + ss);
                        screenStateManager1.doInitGame();
                    }
            }
           });
           
        helpCommand.setReceiver(
        new Receiver()
            {
                public void performAction()
                {
                        if(Greenfoot.mouseClicked(helpButton)){
                                Help help = helpButton.getHelp();
                                getWorld().addObject(help, getWorld().getWidth()/2, getWorld().getHeight()/2);
                                        
                                getWorld().addObject(new BackButton(help), 
                                                help.getX() - help.getImage().getWidth()/2,
                                                    help.getY() - help.getImage().getHeight()/2);
                                
                            }
                }
           }
        );
        
        
        
        
    }
}
