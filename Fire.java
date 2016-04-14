import greenfoot.*;

/**
 * Write a description of class Feuer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fire extends Actor
{
    /**
     * Act - do whatever the Feuer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(-3);
        if (getX() < 2)
            {               
                getWorld().removeObject(this);
            }
    }    
}
