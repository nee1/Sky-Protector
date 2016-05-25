import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PHealth extends Lives
{
    private int totalCount = 50;

    public PHealth()
    {
        setImage(new GreenfootImage("" + totalCount, 30, Color.RED, new Color(0, 0, 0, 0)));
    }

    /**
     * Increase the total amount displayed on the counter, by a given amount.
     */
    public void bumpCount(int amount)
    {
        totalCount += amount;
        setImage(new GreenfootImage("" + totalCount, 30, Color.RED, new Color(0, 0, 0, 0)));
        if (totalCount<=0)
        {
            World Space;
            Space = getWorld();
            Space.removeObject(this);
        }
    }
}