import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spawner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spawner extends Actor
{
    /**
     * Act - do whatever the Spawner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    public void act() 
    {    
        if (Greenfoot.getRandomNumber(100)<25)
        {
            getWorld().addObject(new Enemy(),(Greenfoot.getRandomNumber(800)),(Greenfoot.getRandomNumber(600)));
        }
    }    
}