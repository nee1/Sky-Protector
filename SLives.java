import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SLives extends Lives
{
    public int totalCount = 3;

    public SLives()
    {
        setImage(new GreenfootImage("" + totalCount, 30, Color.WHITE, Color.BLACK));
    }

    /**
     * Increase the total amount displayed on the counter, by a given amount.
     */
    public void bumpCount(int amount)
    {
        totalCount += amount;
        setImage(new GreenfootImage("" + totalCount, 30, Color.WHITE, Color.BLACK));
    }
    
    public int getValue()
    {
        return totalCount;
    }
}