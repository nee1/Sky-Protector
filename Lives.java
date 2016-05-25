import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lives extends Actor implements ObserverHL
{
    public int totalCount = 3;

    public Lives()
    {
        setImage(new GreenfootImage("Lives : " + totalCount, 30, Color.WHITE, new Color(0, 0, 0, 0)));
    }

    /**
     * Increase the total amount displayed on the counter, by a given amount.
     */
    public void bumpCount(int amount)
    {
        totalCount += amount;
        setImage(new GreenfootImage("Lives : " + totalCount, 30, Color.WHITE, new Color(0, 0, 0, 0)));
    }
    
    public int getValue()
    {
        return totalCount;
    }
    
    public void update(int amount){
        bumpCount(amount);
    }
}