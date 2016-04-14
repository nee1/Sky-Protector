import greenfoot.*;
import java.awt.Color;

public class Healthbar extends Actor
{
   
    int health = 10;         //leben
    int healthbarWidth = 80;  //breite
    int healthbarHeight = 15; //höhe
    int pixelsPerHealthPoint = (int) healthbarWidth/health;
   public Healthbar()
   {
       update();
   }
    
    public void act()
   {
       update();
      
   }
    
    public void update()
    {
        setImage(new GreenfootImage(healthbarWidth +2,healthbarHeight  +2));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.WHITE);
        myImage.drawRect(0, 0, healthbarWidth+1, healthbarHeight+1);
        myImage.setColor(Color.RED);
        myImage.fillRect(1, 1, health*pixelsPerHealthPoint, healthbarHeight);
        
        //WIe sieht es aus
    }
    
    public void loseHealth()
    {
        health--;
    }    
}
