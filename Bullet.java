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
          eatRock();
            
        
   } 
 
   
    private void eatRock()
    {
        Actor Rock = getOneObjectAtOffset(0,0, Rock.class);             
        if(Rock !=null) 
        {
             
            World myWorld = getWorld();
            MyWorld crabspace = (MyWorld)myWorld;
            Counter counter = crabspace.getCounter();
            counter.addScore();
            rocket.weapon=null;
             getWorld().removeObject(Rock); 
        }
        else
        {
            if (getX() > 1280)
            {
               rocket.weapon=null;
                //  new Rock(this);
                getWorld().removeObject(this);
               // schuss.setRotation(0);
               // getCrabWorld().addObject(1290, 450);
                
            }
        }
    }
   
   
}