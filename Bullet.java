import greenfoot.*;

public class Bullet extends Actor
{
   private Rocket rocket;
   
   public Bullet(Rocket rocket)
   {
        this.rocket = rocket;
   }
     
   public void act() 
   {
        move(45); 
        
            
        if (getX() > 1280)
        {
            rocket.weapon=null;
            getWorld().removeObject(this);
        }
   } 
  
}