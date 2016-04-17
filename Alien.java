import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alien here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Alien extends Actor
{
    public boolean movesides = true;
    Counter counter;
    public Alien(Counter x)
    {
       this.counter =x;
    }
    public void act() 
    {
        World backdrop = (Space) getWorld();
        if (movesides == true) {
            setLocation(getX(), getY ()+2);
            if (getY() > 700) {
                movesides = false;
            } 
        }
        if (movesides == false) {
            setLocation(getX(), getY ()-2);
            if (getY() < 100) {
                movesides = true;
            }
        }  
        //chooses when to drop a power or Rock
        int randy = Greenfoot.getRandomNumber(250);
        if (randy >= 248) 
        {
            backdrop.addObject(new Rock(), getX(), getY() + 10);
        }       
        if (counter.givescore() >= 10)
            {
                int extraRock = Greenfoot.getRandomNumber(300);
                if (extraRock >= 298)
                {
                   backdrop.addObject(new Rock(), getX(), getY() + 10); 
                }
                
            }
        if (counter.givescore() >= 15)
            {
                int extraRock1 = Greenfoot.getRandomNumber(600);
                if (extraRock1 >= 598)
                {
                   backdrop.addObject(new Rock(), getX(), getY() + 10); 
                }
                
            }
        if (counter.givescore() >= 20)
            {
                int extraRock2 = Greenfoot.getRandomNumber(700);
                if (extraRock2 >= 698)
                {
                   backdrop.addObject(new Rock(), getX(), getY() + 10); 
                }
                
            }
        if (counter.givescore() >= 25)
            {
                int extraRock3 = Greenfoot.getRandomNumber(700);
                if (extraRock3 >= 698)
                {
                   backdrop.addObject(new Rock(), getX(), getY() + 10); 
                }
                
            }
        if (counter.givescore() >= 30)
            {
                int extraRock4 = Greenfoot.getRandomNumber(500);
                if (extraRock4 >= 498)
                {
                   backdrop.addObject(new Rock(), getX(), getY() + 10); 
                }
                
            }

}
}
