import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
         GreenfootImage img = new GreenfootImage(1300, 800);
        img.fill();
        setBackground(img);
        addStars(500); 
    }

    public void addStars(int howMany)
    {
        for(int s=0; s<howMany; s++)
        {
            int x = Greenfoot.getRandomNumber( getWidth());
            int y = Greenfoot.getRandomNumber( getHeight());
            addObject(new Star(), x, y);
        }
    }



}




