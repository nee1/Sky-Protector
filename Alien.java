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
    /**
     * Act - do whatever the Alien wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
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
    
}
}
