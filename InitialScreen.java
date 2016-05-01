import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InitialScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InitialScreen extends World
{
    private PlayButton playButton;
    private HelpButton helpButton;
    private PlayGameCommand playCommand;
    private HelpCommand helpCommand;
    private static GreenfootSound GameofThrones;
    
    public InitialScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1,false);
        playButton = new PlayButton();
        helpButton = new HelpButton();
        helpCommand = new HelpCommand();
        playCommand = new PlayGameCommand();
        prepare();
        GameofThrones = new GreenfootSound("GameofThrones.mp3");
        GameofThrones.play();
    }
    
    
    public void prepare()
    {
        addObject(playButton, getWidth()/2, 100);
        addObject(helpButton, getWidth()/2, 200);        
        playButton.setCommand(playCommand);
        helpButton.setCommand(helpCommand);
        
        playCommand.setReceiver(
      
            new Receiver()
            {
                public void performAction()
                {
                    if(Greenfoot.mouseClicked(playButton)){
                        Greenfoot.setWorld(new Space());
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
                                addObject(help, getWidth()/2, getHeight()/2);
                                        
                                addObject(new BackButton(help), 
                                                help.getX() - help.getImage().getWidth()/2,
                                                    help.getY() - help.getImage().getHeight()/2);
                                
                            }
                }
           }
        );
        
        
        
        
    }
}
