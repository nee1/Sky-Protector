import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    public int totalCount = 0;

    public Score()
    {
        setImage(new GreenfootImage("Score: ", 20, Color.WHITE, Color.BLACK));
    }
    
    /**
     * Increase the total amount displayed on the counter, by a given amount.
     */
    public void bumpCount(int amount)
    {
        totalCount += amount;
        setImage(new GreenfootImage("Score: " + totalCount, 20, Color.WHITE, Color.BLACK));
    }
}
