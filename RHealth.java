import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RHealth extends Lives implements ObserverHL
{
    public int totalCount = 3;
    public static GreenfootImage[] numberImage = new GreenfootImage[3];
    public RHealth()
    {
        //setImage(new GreenfootImage("./images/herz.png"));//
        setImage(new GreenfootImage("Health : " + totalCount, 30, Color.GREEN, new Color(0, 0, 0, 0)));
         /*GreenfootImage built= new GreenfootImage(numberImage[totalCount%3]);
         int num = totalCount;
         while ((num = num/3) > 0)
         {
            GreenfootImage additional = new GreenfootImage(numberImage[num%3]);
            GreenfootImage combined = new GreenfootImage(built.getWidth()+additional.getWidth(), built.getHeight());
            combined.drawImage(additional, 0, 0);
            combined.drawImage(built, additional.getWidth(), 0);
            built = new GreenfootImage(combined);
         }*/
    }
    /**
     * Increase the total amount displayed on the counter, by a given amount.
     */
    public void bumpCount(int amount)
    {
        if(amount==-3){
           setImage(new GreenfootImage("Health : 0", 30, Color.GREEN, new Color(0, 0, 0, 0)));
           return;
        }
        totalCount += amount;
        setImage(new GreenfootImage("Health : " + totalCount, 30, Color.GREEN, new Color(0, 0, 0, 0)));
        if (totalCount<=0)
        {
            totalCount=3;
        }
        
        if (totalCount>=6)
        {setImage(new GreenfootImage("Health : " + totalCount, 30, Color.WHITE, new Color(0, 0, 0, 0)));}
        
        if (totalCount==5)
        {setImage(new GreenfootImage("Health : " + totalCount, 30, Color.CYAN, new Color(0, 0, 0, 0)));}
        
        if (totalCount==4)
        {setImage(new GreenfootImage("Health : " + totalCount, 30, Color.BLUE, new Color(0, 0, 0, 0)));}
        
        if (totalCount==3)
        {setImage(new GreenfootImage("Health : " + totalCount, 30, Color.GREEN, new Color(0, 0, 0, 0)));}
        
        if (totalCount==2)
        {setImage(new GreenfootImage("Health : " + totalCount, 30, Color.YELLOW, new Color(0, 0, 0, 0)));}
        
        if (totalCount==1)
        {setImage(new GreenfootImage("Health : " + totalCount, 30, Color.RED, new Color(0, 0, 0, 0)));}
    }
    
    public void update(int amount){
        bumpCount(amount);
    }
}