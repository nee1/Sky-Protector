import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Counter here.
 * 
 * @XianBallz 
 * @version (a version number or a date)
 */
public class Killed extends Score
{
    private int totalCount = 0;

    public Killed()
    {
        setImage(new GreenfootImage("", 20, Color.WHITE, Color.BLACK));
    }

    /**
     * Increase the total amount displayed on the counter, by a given amount.
     */
    public void bumpCount(int amount)
    {
        totalCount += amount;
        setImage(new GreenfootImage("" + totalCount, 20, Color.WHITE, Color.BLACK));
    }
}