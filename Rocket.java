import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Actor
{
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Bullet weapon;
    
    public void act() 
    {
      moveRocket();
        
      if (Greenfoot.isKeyDown("space"))
      {
          shoot();
      }  
    }    
    
    public void moveRocket() {
        if (Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(),getY()-5);
        }
        
        if (Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(),getY()+5);
        
        }
        if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+5,getY());
        }
        if (Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-5,getY());
        }
    }
    public void shoot()
    {
      if(weapon==null)
      {
          weapon = new Bullet(this);
          weapon.setRotation(0);
          getMyWorld().addObject(weapon,getX()+150,getY());
          //Greenfoot.playSound("Laser 04 sound effect.mp3");
      }
    }
    
    public MyWorld getMyWorld(){
        return (MyWorld) getWorld();
    }
}
