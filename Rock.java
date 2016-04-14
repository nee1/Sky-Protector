import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends Actor
{
     private int speedRock;
     public Rock()
   {
       speedRock = Greenfoot.getRandomNumber(5)-6;
   }
   private Alien meinKiller;
   public void act() 
   {
        move(speedRock);
        if (getX() < 2)
            {               
                getWorld().removeObject(this);
            }
   } 
}
