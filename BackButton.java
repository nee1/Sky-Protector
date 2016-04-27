import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackButton extends Actor
{
   
     private Actor actor;
  
    public BackButton(Actor a)
    {
        actor = a;
    }
    
    
    public void act() 
    {
               this.click();

    }    
    
    
    public void click()
    {
        if(Greenfoot.mouseClicked(this)){
            getWorld().removeObject(actor);
            getWorld().removeObject(this);
        }
    }
    
}
