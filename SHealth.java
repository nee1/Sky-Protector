import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SHealth extends Lives
{
    private int totalCount = 3;

    public SHealth()
    {
        setImage(new GreenfootImage("" + totalCount, 30, Color.GREEN, Color.BLACK));
    }

    /**
     * Increase the total amount displayed on the counter, by a given amount.
     */
    public void bumpCount(int amount)
    {
        totalCount += amount;
        setImage(new GreenfootImage("" + totalCount, 30, Color.GREEN, Color.BLACK));
        if (totalCount<=0)
        {
            totalCount=3;
        }
        
        if (totalCount>=6)
        {setImage(new GreenfootImage("" + totalCount, 30, Color.WHITE, Color.BLACK));}
        
        if (totalCount==5)
        {setImage(new GreenfootImage("" + totalCount, 30, Color.CYAN, Color.BLACK));}
        
        if (totalCount==4)
        {setImage(new GreenfootImage("" + totalCount, 30, Color.BLUE, Color.BLACK));}
        
        if (totalCount==3)
        {setImage(new GreenfootImage("" + totalCount, 30, Color.GREEN, Color.BLACK));}
        
        if (totalCount==2)
        {setImage(new GreenfootImage("" + totalCount, 30, Color.YELLOW, Color.BLACK));}
        
        if (totalCount==1)
        {setImage(new GreenfootImage("" + totalCount, 30, Color.RED, Color.BLACK));}
    }
}