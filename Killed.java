import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Counter here.
 * 
 * @XianBallz 
 * @version (a version number or a date)
 */
public class Killed extends Actor implements Observer
{
    private int totalCount = 0;

    public Killed()
    {
        setImage(new GreenfootImage("Killed : ", 30, Color.WHITE, new Color(0, 0, 0, 0)));
    }

    /**
     * Increase the total amount displayed on the counter, by a given amount.
     */
    public void bumpCount()
    {
        setImage(new GreenfootImage("Killed : " + totalCount, 30, Color.WHITE, new Color(0, 0, 0, 0)));
    }
    
    public void ItotalCount(int amount){
        totalCount += amount;
        bumpCount();
    }
}