import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Star here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Star extends Actor
{
    /**
     * Act - do whatever the Star wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
 private static final int SIZE=3;
    private int speed;
    
   public Star()
   {
       GreenfootImage img = new GreenfootImage(SIZE,SIZE);
       int colour = Greenfoot.getRandomNumber(256);
       img.setColor(new Color(colour, colour, colour));
       img.fillOval(0,0,SIZE,SIZE);
       setImage(img);
       
       speed = Greenfoot.getRandomNumber(5)+1;
       
   }
   public void act() 
   {
        setLocation(getX()-speed,getY());
        if(getX()<SIZE)
        {
            int x = getWorld().getWidth()-SIZE;
            int y = Greenfoot.getRandomNumber(getWorld().getWidth());
            setLocation(x,y);
        }
   }     
}
