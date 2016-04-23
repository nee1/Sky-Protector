import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayButton extends Actor implements BtInvoker
{
     BtCommand newBtCommand;
    
     
     public PlayButton()
     {
          
         
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
