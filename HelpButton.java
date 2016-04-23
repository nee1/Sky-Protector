import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HelpButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpButton extends Actor implements BtInvoker
{
 
    private Help help;
    private BtCommand newBtCommand;
   
    public HelpButton()
    {
        help = new Help();
        
    }
    public Help getHelp()
    {
        return help;
    }
    
    
    public void act() 
    {
        click();
    }    
    
     public void setCommand(BtCommand newCmd)
    {
        this.newBtCommand = newCmd;
    }
    
    
     public void click()
    {
       newBtCommand.executeCommand();
    }
    
   
    
    
}
