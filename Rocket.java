import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Actor
{
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveRocket();
    }    
    
    public void moveRocket() {
        if (Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(),getY()-5);
        }
        
        if (Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(),getY()+5);
        
        }
    }
}
