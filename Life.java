import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Baby here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Life extends Spawner
{
    int ballstaken=0;
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        GreenfootImage img = getImage();
        img.scale(35,15);
        setImage(img);
        
        movearound();
        
        Actor Ball=getOneIntersectingObject(Ball.class);
        if (Ball!=null)
        {
            getWorld().removeObject(Ball);
            ballstaken++;
        }
       
        if (ballstaken>=1)
        {
            getWorld().removeObject(this);
        }
    }
    
    public void movearound()
    {
        turn(-3);
    }
}
