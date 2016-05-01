import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InitialScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InitialScreen extends SkyWorld
{
    private PlayButton playButton;
    private HelpButton helpButton;
    private PlayGameCommand playCommand;
    private HelpCommand helpCommand;
    private ScreenStateManager screenStateManager1;
    private static GreenfootSound GameofThrones;
    
    public InitialScreen(ScreenStateManager screenStateManager)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        
        playButton = new PlayButton();
        helpButton = new HelpButton();
        helpCommand = new HelpCommand();
        playCommand = new PlayGameCommand();
        screenStateManager1 = screenStateManager;
        GameofThrones = new GreenfootSound("GameofThrones.mp3");
        GameofThrones.play();
        //System.out.println("before calling doPlay of Initial Screen - in initialscreen : " + screenStateManager);
        prepare();
    }
    
    
    
    public void prepare()
    {
        addObject(playButton, getWidth()/2, 100);
        addObject(helpButton, getWidth()/2, 200);        
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
                        //Greenfoot.setWorld(new Space());
                        //System.out.println("before calling doPlay of Initial Screen2 WWW : " + ss);
                        System.out.println("before calling doPlay Method in playCommand.setReciever : " + screenStateManager1);
                        
                        screenStateManager1.doPlay();
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
