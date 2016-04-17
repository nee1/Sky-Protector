import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * Write a description of class Debris here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pebble extends SmoothMover
{
    private static final Vector GRAVITY = new Vector(90, 1.5);
    private static final int FORCE = 15;
    
    public Pebble()
    {
        int direction = Greenfoot.getRandomNumber(360);
        int speed = Greenfoot.getRandomNumber(FORCE);
        increaseSpeed( new Vector(direction, speed));
        
        // random image size
        GreenfootImage img = getImage();
        int width = Greenfoot.getRandomNumber(20) + 1;
        int height = Greenfoot.getRandomNumber(20) + 1;
        img.scale (width, height);
        
        setRotation (Greenfoot.getRandomNumber(360));
    }
    
    /**
     * Act - do whatever the Debris wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        increaseSpeed(GRAVITY);
        move();
    }    
}
