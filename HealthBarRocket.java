import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class HealthBarRocket extends Actor
{
    int healthRocket = 5;         //Live
    int healthBarWidthRocket = 80;  //Width
    int healthBarHeightRocket = 15; //Height
    int pixelsPerHealthPointRocket = (int) healthBarWidthRocket/healthRocket;
    
    public HealthBarRocket() {
        update();
    }
    
    public void act() 
    {
        update();
    }    
    
    public void update() {
        setImage(new GreenfootImage(healthBarWidthRocket +2,healthBarHeightRocket  +2));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.WHITE);
        myImage.drawRect(0, 0, healthBarWidthRocket+1, healthBarHeightRocket+1);
        myImage.setColor(Color.RED);
        myImage.fillRect(1, 1, healthRocket*pixelsPerHealthPointRocket, healthBarHeightRocket);
        
        //How does it look like
    }
    
    public void loseHealthRocket()
   {
        healthRocket--;
   }
}
