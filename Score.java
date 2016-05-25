import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor implements Observer
{
    public int totalCount = 0;

    public Score()
    {
        setImage(new GreenfootImage("Score : "+totalCount, 30, Color.GREEN, new Color(0, 0, 0, 0)));
    }
    
    /**
     * Increase the total amount displayed on the counter, by a given amount.
     */
    public void bumpCount()
    {
        setImage(new GreenfootImage("Score : " + totalCount, 30, Color.GREEN, new Color(0, 0, 0, 0)));
    }
    
    public void ItotalCount(int amount){
        totalCount += amount;
        bumpCount();
    }
}
